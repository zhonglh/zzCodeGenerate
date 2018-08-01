package com.zz.bsmcc.base.logic;

import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.db.entity.EntityUtil;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.InternalException;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bms.util.base.data.StringUtil;
import com.zz.bms.util.base.java.IdUtils;
import com.zz.bms.util.base.java.ReflectionSuper;
import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.domain.TcgProjectEntity;
import com.zz.bsmcc.core.enums.EnumDbColumnType;
import com.zz.bsmcc.core.enums.EnumJavaType;
import com.zz.bsmcc.core.enums.EnumPageElement;
import com.zz.bsmcc.core.util.table.pojo.Column;
import com.zz.bsmcc.core.util.table.pojo.Index;
import com.zz.bsmcc.core.util.table.pojo.Table;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author Administrator
 */
public class TableLogic {


    public static List<String> insideFieldNames = new ArrayList<String>();
    static{
        Field[] allField = ReflectionSuper.getAllField(BaseBusinessExEntity.class , BaseEntity.class);
        for(Field field : allField){
            insideFieldNames.add(field.getName());
        }
    }

    public static void initTableConfig(TcgTableConfigBO tcgTableConfigBO , Table table , TcgProjectEntity project , ILoginUserEntity<String> sessionUserVO){
        tcgTableConfigBO.setSchemaName(table.getTableSchema());
        tcgTableConfigBO.setTableName(table.getTableName());
        tcgTableConfigBO.setIsTable(table.isTable()? EnumYesNo.YES.getCode():EnumYesNo.NO.getCode());
        tcgTableConfigBO.setTableComment(table.getTableComment());


        tcgTableConfigBO.setProjectName(project.getProjectName());
        tcgTableConfigBO.setQueryMode(project.getQueryMode());

        tcgTableConfigBO.setIsBuildController(EnumYesNo.YES.getCode());
        if(table.isTable() && project.getPageUseView().equals(EnumYesNo.YES.getCode())){
            tcgTableConfigBO.setIsBuildController(EnumYesNo.NO.getCode());
        }
        tcgTableConfigBO.setIsBuildMenu(tcgTableConfigBO.getIsBuildController());
        tcgTableConfigBO.setJavaName(StringUtil.firstUpperCase(StringFormatKit.toCamelCase(tcgTableConfigBO.getTableName())));
        tcgTableConfigBO.setIsTree(EnumYesNo.NO.getCode());


        EntityUtil.autoSetEntity(tcgTableConfigBO , sessionUserVO);

        tcgTableConfigBO.setId(IdUtils.getId());

    }



    public static void initColumnConfig(TcgColumnConfigBO columnBO, TcgTableConfigBO tableBO , Column column ,
                                    Map<String,String> typeMap , ILoginUserEntity<String> sessionUserVO){
        columnBO.setTableId(tableBO.getId());
        columnBO.setColumnName(column.getColumnName());
        columnBO.setColumnComment(column.getColumnComment());
        columnBO.setColumnOtherComment(column.getColumnOtherComments());
        columnBO.setColumnType(column.getDataType());
        if(column.getCharmaxLength() != null && column.getCharmaxLength() != 0) {
            columnBO.setColumnLength(column.getCharmaxLength());
        }else if(column.getPrecision()!=null && column.getPrecision() != 0){
            columnBO.setColumnLength(column.getPrecision());
        }
        if(column.getScale()!=null && column.getScale()!=0) {
            columnBO.setColumnScale(column.getScale());
        }
        columnBO.setColumnIsnull(column.isNullable()?EnumYesNo.YES.getCode():EnumYesNo.NO.getCode());


        columnBO.setColumnIskey("id".equals(column.getColumnName()) ? EnumYesNo.YES.getCode():EnumYesNo.NO.getCode());

        columnBO.setColumnIsfk(EnumYesNo.NO.getCode());
        if(columnBO.getColumnIskey().equals(EnumYesNo.NO.getCode())) {
            if (columnBO.getColumnLength() != null &&
                    (columnBO.getColumnLength() == 32 || columnBO.getColumnLength() == 36 || columnBO.getColumnLength() == 64)
                    ) {
                columnBO.setColumnIsfk(EnumYesNo.YES.getCode());
            }
        }


        columnBO.setColumnIsdict(EnumYesNo.NO.getCode());

        if(columnBO.getColumnIskey().equals(EnumYesNo.NO.getCode()) || columnBO.getColumnIsfk().equals(EnumYesNo.NO.getCode())) {
            if (column.isFixedChar() && column.getCharmaxLength() <= 2) {
                columnBO.setColumnIsdict(EnumYesNo.YES.getCode());
            }
        }


        processJavaType(columnBO, typeMap);



        setTableParent(tableBO , column);

        EntityUtil.autoSetEntity(columnBO , sessionUserVO);

        columnBO.setId(IdUtils.getId());

    }

    public static void processJavaType(TcgColumnConfigBO columnBO, Map<String, String> typeMap) {
        String javaType = typeMap.get(columnBO.getColumnType());
        if(StringUtils.isEmpty(javaType)){
            EnumJavaType enumJavaType = EnumDbColumnType.getJavaType(columnBO.getColumnType() , columnBO.getColumnLength() , columnBO.getColumnScale() );
            if(enumJavaType != null){
                javaType = enumJavaType.getFullname();
            }
        }
        if(StringUtils.isEmpty(javaType)){
            throw new InternalException(columnBO.getColumnType() +" 对应的Java类型没有设置");
        }

        columnBO.setJavaFullClass(javaType);
        columnBO.setJavaSimpleClass(javaType.substring(javaType.lastIndexOf("."))+1);
        columnBO.setJavaName(StringFormatKit.toCamelCase(columnBO.getColumnName()));
    }


    public static void initIndexConfig(TcgIndexConfigBO indexBO, TcgTableConfigBO tcgTableConfigBO, Index ci , ILoginUserEntity<String> sessionUserVO) {
        indexBO.setTableId(tcgTableConfigBO.getId());
        indexBO.setIndexName(ci.getIndexName());
        StringBuilder columnNames = new StringBuilder("");
        Collections.sort(ci.getColumnNames());
        for(String columnName : ci.getColumnNames()){
            columnNames.append(columnName).append(",");
        }
        columnNames.deleteCharAt(columnNames.length() -1);
        indexBO.setIndexCloumns(columnNames.toString());

        EntityUtil.autoSetEntity(indexBO , sessionUserVO);

        indexBO.setId(IdUtils.getId());

    }


    public static void initExColumn(TcgExColumnBO exColumnBO, TcgColumnConfigBO columnBO, ILoginUserEntity<String> sessionUserVO) {
        exColumnBO.setTableId(columnBO.getTableId());
        exColumnBO.setOriginalColumnId(columnBO.getId());
        exColumnBO.setOriginalColumnName(columnBO.getColumnName());
        exColumnBO.setOriginalColumnDict(EnumYesNo.NO.getCode());
        exColumnBO.setOriginalColumnFk(EnumYesNo.NO.getCode());

        exColumnBO.setColumnTitle(columnBO.getColumnComment());
        String javaName = columnBO.getJavaName();
        if(javaName.endsWith("Id") || javaName.endsWith("id")){
            javaName = javaName.substring(0 , javaName.length() -2) + "Name";
        }else {
            javaName = javaName + "Name";
        }
        exColumnBO.setJavaName(javaName);
        exColumnBO.setJavaFullClass("java.lang.String");
        exColumnBO.setJavaSimpleClass("String");
        exColumnBO.setGroupCode(columnBO.getColumnName());

        exColumnBO.setColumnSort(columnBO.getColumnSort() + 1);


        EntityUtil.autoSetEntity(exColumnBO , sessionUserVO);



        exColumnBO.setId(IdUtils.getId());

    }



    public static void initColumnPage(TcgColumnPageBO pageBO, TcgExColumnBO columnBO, ILoginUserEntity<String> sessionUserVO) {
        pageBO.setRealColumn(EnumYesNo.NO.getCode());

        pageBO.setExistPage(EnumYesNo.YES.getCode());
        pageBO.setEditable(EnumYesNo.YES.getCode());
        pageBO.setHiddenable(EnumYesNo.NO.getCode());

        pageBO.setElement((String) EnumPageElement.text.getTheValue());

        pageBO.setRequired(EnumYesNo.YES.getCode());

        pageBO.setListShowable(pageBO.getEditable());


        EntityUtil.autoSetEntity(pageBO , sessionUserVO);

        pageBO.setId(columnBO.getId());
        pageBO.setTableId(columnBO.getTableId());


    }

    public static void initColumnPage(TcgColumnPageBO pageBO, TcgColumnConfigBO columnBO, ILoginUserEntity<String> sessionUserVO) {
        pageBO.setRealColumn(EnumYesNo.YES.getCode());

        if(insideFieldNames.contains(columnBO.getJavaName())){
            pageBO.setExistPage(EnumYesNo.NO.getCode());
            pageBO.setEditable(EnumYesNo.NO.getCode());
            pageBO.setHiddenable(EnumYesNo.NO.getCode());
        }else if("id".equalsIgnoreCase(columnBO.getJavaName())){
            //主键
            pageBO.setExistPage(EnumYesNo.YES.getCode());
            pageBO.setEditable(EnumYesNo.NO.getCode());
            pageBO.setHiddenable(EnumYesNo.YES.getCode());
        }else {
            pageBO.setExistPage(EnumYesNo.YES.getCode());
            pageBO.setEditable(EnumYesNo.YES.getCode());
            pageBO.setHiddenable(EnumYesNo.NO.getCode());
        }


        processPageElement(pageBO, columnBO);

        if(columnBO.getColumnLength() != null && columnBO.getColumnLength() > 0){
            pageBO.setMaxlength(columnBO.getColumnLength());
        }

        pageBO.setRequired(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsnull())?EnumYesNo.NO.getCode() : EnumYesNo.YES.getCode());
        pageBO.setListShowable(pageBO.getEditable());


        EntityUtil.autoSetEntity(pageBO , sessionUserVO);

        pageBO.setId(columnBO.getId());
        pageBO.setTableId(columnBO.getTableId());

    }


    /**
     * 根据列信息， 计算界面元素
     * @param pageBO
     * @param columnBO
     */
    public static void processPageElement(TcgColumnPageBO pageBO, TcgColumnConfigBO columnBO) {
        if(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsfk())){
            pageBO.setElement((String) EnumPageElement.openwin.getTheValue());
        }else if(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsdict())){
            pageBO.setElement((String)EnumPageElement.select.getTheValue());
        }else {
            Class clz = null;
            try {
                clz = Class.forName(columnBO.getJavaFullClass());
            } catch (ClassNotFoundException e) {
                throw new InternalException("Java 类型错误 : " + columnBO.getJavaFullClass());
            }
            if( clz.isAssignableFrom(Number.class)) {
                if (columnBO.getColumnScale() != null && columnBO.getColumnScale() > 0) {
                    pageBO.setElement((String) EnumPageElement.number.getTheValue());
                } else {
                    pageBO.setElement((String) EnumPageElement.digits.getTheValue());
                }
            }else if(clz == Date.class){
                pageBO.setElement((String) EnumPageElement.date.getTheValue());
            }else if(clz == java.sql.Timestamp.class){
                pageBO.setElement((String) EnumPageElement.timestamp.getTheValue());
            }else if(clz == String.class){
                pageBO.setElement((String) EnumPageElement.text.getTheValue());
                if(columnBO.getColumnLength() > 100){
                    pageBO.setElement((String) EnumPageElement.textarea.getTheValue());
                }else {
                    pageBO.setElement((String) EnumPageElement.text.getTheValue());
                }
            }else {
                pageBO.setElement((String) EnumPageElement.text.getTheValue());
            }
        }
    }


    /**
     * 处理表的上级列 ， 如部门用pid或者用praent_id 来表示上级部门
     * @param tableBO
     * @param column
     */
    public static void setTableParent(TcgTableConfigBO tableBO , Column column){
        if(column.getColumnName().equalsIgnoreCase("pid") || column.getColumnName().equalsIgnoreCase("parent_id") ){
            tableBO.setIsTree(EnumYesNo.YES.getCode());
            tableBO.setParentFieldName(column.getColumnName());
        }
    }
    
}
