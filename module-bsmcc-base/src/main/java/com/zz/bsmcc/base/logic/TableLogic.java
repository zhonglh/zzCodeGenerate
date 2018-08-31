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
import com.zz.bsmcc.core.util.CgBeanUtil;
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
        tcgTableConfigBO.setSchemaName(CgBeanUtil.nameProcess(table.getTableSchema()));
        tcgTableConfigBO.setTableName(CgBeanUtil.nameProcess(table.getTableName()));
        tcgTableConfigBO.setIsTable(table.isTable()? EnumYesNo.YES.getCode():EnumYesNo.NO.getCode());
        tcgTableConfigBO.setTableComment(table.getTableComment());
        tcgTableConfigBO.setTableOtherComment(table.getTableOtherComment());


        tcgTableConfigBO.setProjectName(project.getProjectName());
        tcgTableConfigBO.setQueryMode(project.getQueryMode());

        tcgTableConfigBO.setIsBuildUi(EnumYesNo.YES.getCode());
        if(table.isTable() && project.getPageUseView().equals(EnumYesNo.YES.getCode())){
            tcgTableConfigBO.setIsBuildUi(EnumYesNo.NO.getCode());
        }
        tcgTableConfigBO.setIsBuildMenu(tcgTableConfigBO.getIsBuildUi());
        tcgTableConfigBO.setJavaName(StringUtil.firstUpperCase(StringFormatKit.toCamelCase(tcgTableConfigBO.getTableName())));
        tcgTableConfigBO.setIsTree(EnumYesNo.NO.getCode());


        String resourceName = table.getTableName();
        if(resourceName.indexOf("_")!=-1) {
            resourceName = resourceName.substring(table.getTableName().indexOf("_") + 1);
        }
        resourceName = resourceName.replaceAll("_","").toLowerCase();
        tcgTableConfigBO.setResourceName(resourceName);


        EntityUtil.autoSetInsertEntity(tcgTableConfigBO , sessionUserVO);

        tcgTableConfigBO.setId(IdUtils.getId());

    }



    public static void initColumnConfig(TcgColumnConfigBO columnBO, TcgTableConfigBO tableBO , Column column ,
                                    Map<String,String> typeMap , ILoginUserEntity<String> sessionUserVO){
        columnBO.setTableId(tableBO.getId());
        columnBO.setColumnName(column.getColumnName().toLowerCase());
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


        processJavaType(columnBO, typeMap);
        Set<String> fieldNames = CgBeanUtil.getClassFieldName(BaseBusinessExEntity.class);


        columnBO.setColumnIskey("id".equals(column.getColumnName()) ? EnumYesNo.YES.getCode():EnumYesNo.NO.getCode());

        columnBO.setColumnIsfk(EnumYesNo.NO.getCode());
        if(!fieldNames.contains(columnBO.getJavaName())) {
            if (columnBO.getColumnIskey().equals(EnumYesNo.NO.getCode())) {
                boolean isFk = isFk(columnBO);
                if(isFk) {
                    columnBO.setColumnIsfk(EnumYesNo.YES.getCode());
                    columnBO.setFkColumn("id");
                }
            }
        }


        columnBO.setColumnIsdict(EnumYesNo.NO.getCode());

        if(!fieldNames.contains(columnBO.getJavaName())) {
            if (columnBO.getColumnIskey().equals(EnumYesNo.NO.getCode()) || columnBO.getColumnIsfk().equals(EnumYesNo.NO.getCode())) {
                boolean isDict = isDict(columnBO , column);
                if(isDict) {
                    columnBO.setColumnIsdict(EnumYesNo.YES.getCode());
                }
            }
        }





        setTableParent(tableBO , column);

        EntityUtil.autoSetInsertEntity(columnBO , sessionUserVO);

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

        EntityUtil.autoSetInsertEntity(indexBO , sessionUserVO);

        indexBO.setId(IdUtils.getId());

    }


    public static void initExColumn(TcgExColumnBO exColumnBO, TcgColumnConfigBO columnBO, ILoginUserEntity<String> sessionUserVO) {
        exColumnBO.setTableId(columnBO.getTableId());
        exColumnBO.setOriginalColumnId(columnBO.getId());
        exColumnBO.setOriginalColumnName(columnBO.getColumnName());
        exColumnBO.setOriginalColumnDict(EnumYesNo.NO.getCode());
        exColumnBO.setOriginalColumnFk(EnumYesNo.NO.getCode());

        exColumnBO.setOriginalColumn(columnBO);

        String title = columnBO.getColumnComment();
        if(title.length()<=2){
            title = title + "名称";
        }else {
            if(title.toLowerCase().endsWith("id")){
                title = title.substring(0, title.length() -2) + "名称";
            }else {
                title = title + "名称";
            }
        }
        exColumnBO.setColumnTitle(title);
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


        EntityUtil.autoSetInsertEntity(exColumnBO , sessionUserVO);



        exColumnBO.setId(IdUtils.getId());

    }



    public static void initColumnPage(TcgColumnPageBO pageBO, TcgExColumnBO exColumnBO, ILoginUserEntity<String> sessionUserVO) {

        pageBO.setExColumn(exColumnBO);

        pageBO.setRealColumn(EnumYesNo.NO.getCode());

        pageBO.setExistPage(EnumYesNo.YES.getCode());
        pageBO.setEditable(EnumYesNo.YES.getCode());
        pageBO.setHiddenable(EnumYesNo.NO.getCode());
        pageBO.setListShowable(pageBO.getEditable());

        pageBO.setElement((String) EnumPageElement.text.getTheValue());
        if(exColumnBO.getOriginalColumn() != null && EnumYesNo.YES.getCode().equals(exColumnBO.getOriginalColumn().getColumnIsfk())){
            pageBO.setElement((String) EnumPageElement.openwin.getTheValue());
        }

        if(EnumYesNo.YES.getCode().equals(exColumnBO.getOriginalColumnDict())){
            pageBO.setExistPage(EnumYesNo.NO.getCode());
            pageBO.setEditable(EnumYesNo.NO.getCode());
            pageBO.setHiddenable(EnumYesNo.NO.getCode());
            pageBO.setListShowable(EnumYesNo.YES.getCode());
        }

        pageBO.setRequired(EnumYesNo.YES.getCode());



        EntityUtil.autoSetInsertEntity(pageBO , sessionUserVO);

        pageBO.setId(exColumnBO.getId());
        pageBO.setTableId(exColumnBO.getTableId());


    }

    public static void initColumnPage(TcgColumnPageBO pageBO, TcgColumnConfigBO columnBO, ILoginUserEntity<String> sessionUserVO) {

        pageBO.setColumnConfig(columnBO);

        pageBO.setRealColumn(EnumYesNo.YES.getCode());


        if(insideFieldNames.contains(columnBO.getJavaName())){
            pageBO.setExistPage(EnumYesNo.NO.getCode());
            pageBO.setEditable(EnumYesNo.NO.getCode());
            pageBO.setHiddenable(EnumYesNo.NO.getCode());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if("id".equalsIgnoreCase(columnBO.getJavaName())){
            //主键
            pageBO.setExistPage(EnumYesNo.YES.getCode());
            pageBO.setEditable(EnumYesNo.NO.getCode());
            pageBO.setHiddenable(EnumYesNo.YES.getCode());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsfk())){
            //外键
            pageBO.setExistPage(EnumYesNo.YES.getCode());
            pageBO.setEditable(EnumYesNo.NO.getCode());
            pageBO.setHiddenable(EnumYesNo.YES.getCode());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsdict())){
            //字典
            pageBO.setExistPage(EnumYesNo.YES.getCode());
            pageBO.setEditable(EnumYesNo.YES.getCode());
            pageBO.setHiddenable(EnumYesNo.NO.getCode());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else {
                pageBO.setExistPage(EnumYesNo.YES.getCode());
                pageBO.setEditable(EnumYesNo.YES.getCode());
                pageBO.setHiddenable(EnumYesNo.NO.getCode());
                pageBO.setListShowable(pageBO.getEditable());
        }


        processPageElement(pageBO, columnBO);


        if(columnBO.getColumnLength() != null && columnBO.getColumnLength() > 0){
            pageBO.setMaxlength(columnBO.getColumnLength());
        }

        pageBO.setRequired(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsnull())?EnumYesNo.NO.getCode() : EnumYesNo.YES.getCode());



        EntityUtil.autoSetInsertEntity(pageBO , sessionUserVO);

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
            pageBO.setElement((String) EnumPageElement.text.getTheValue());
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
                if(columnBO.getColumnLength() >= 100){
                    pageBO.setElement((String) EnumPageElement.textarea.getTheValue());
                    pageBO.setListShowable(EnumYesNo.NO.getCode());
                    //处理文件类型和图片类型
                    setFileImage4Page(pageBO);
                }else {
                    pageBO.setElement((String) EnumPageElement.text.getTheValue());
                    //处理文件类型和图片类型
                    setFileImage4Page(pageBO);
                }
            }else {
                pageBO.setElement((String) EnumPageElement.text.getTheValue());
                //处理文件类型和图片类型
                setFileImage4Page(pageBO);
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




    private static boolean isFk(TcgColumnConfigBO columnBO) {
        if (columnBO.getColumnLength() != null &&
                (columnBO.getColumnLength() == 32 || columnBO.getColumnLength() == 36 || columnBO.getColumnLength() == 64)
                ) {
            if(
                    !columnBO.getColumnName().toLowerCase().endsWith("file") &&
                    !columnBO.getColumnName().toLowerCase().endsWith("files") &&
                    !columnBO.getColumnName().toLowerCase().endsWith("image")&&
                    !columnBO.getColumnName().toLowerCase().endsWith("images")
                    ) {
                return true;
            }
        }
        return false;
    }


    public static void setFileImage4Page(TcgColumnPageBO pageBO) {
        if(isFiles(pageBO.getColumnConfig())){
            pageBO.setElement(EnumPageElement.multifile.getValue());
            pageBO.setElementNmae(EnumPageElement.multifile.getName());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if(isFile(pageBO.getColumnConfig())){
            pageBO.setElement(EnumPageElement.singlefile.getValue());
            pageBO.setElementNmae(EnumPageElement.singlefile.getName());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if(isImages(pageBO.getColumnConfig())){
            pageBO.setElement(EnumPageElement.multiimage.getValue());
            pageBO.setElementNmae(EnumPageElement.multiimage.getName());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if(isImage(pageBO.getColumnConfig())){
            pageBO.setElement(EnumPageElement.singleimage.getValue());
            pageBO.setElementNmae(EnumPageElement.singleimage.getName());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }
    }
    public static boolean isFiles(TcgColumnConfigBO columnBO) {

        if( columnBO.getColumnName().toLowerCase().endsWith("files") ) {
            return true;
        }
        return false;
    }
    public static boolean isFile(TcgColumnConfigBO columnBO) {

        if( columnBO.getColumnName().toLowerCase().endsWith("file") ) {
            return true;
        }
        return false;
    }
    public static boolean isImages(TcgColumnConfigBO columnBO) {

        if (columnBO.getColumnName().toLowerCase().endsWith("images")) {
            return true;
        }
        return false;
    }
    public static boolean isImage(TcgColumnConfigBO columnBO) {

        if (columnBO.getColumnName().toLowerCase().endsWith("image")) {
            return true;
        }
        return false;
    }





    private static boolean isDict(TcgColumnConfigBO columnBO , Column column){
        //固定长度并且2位值的认为是 字典或者枚举
        if (column.isFixedChar() && column.getCharmaxLength() <= 2) {
            return true;
        }
        return false;
    }


}
