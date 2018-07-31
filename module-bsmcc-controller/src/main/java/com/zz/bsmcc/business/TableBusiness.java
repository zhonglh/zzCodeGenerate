package com.zz.bsmcc.business;


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
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.TcgJavaDatatypeRealQuery;
import com.zz.bsmcc.base.query.impl.TcgJavaDatatypeRealQueryImpl;
import com.zz.bsmcc.base.service.TcgJavaDatatypeRealService;
import com.zz.bsmcc.base.service.TcgProjectService;
import com.zz.bsmcc.core.enums.EnumDbColumnType;
import com.zz.bsmcc.core.enums.EnumJavaType;
import com.zz.bsmcc.core.enums.EnumPageElement;
import com.zz.bsmcc.core.util.table.engine.ReadDbFactory;
import com.zz.bsmcc.core.util.table.engine.ReadDbProcess;
import com.zz.bsmcc.core.util.table.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;

/**
 * 表数据处理
 * @author Administrator
 */
@Component
public class TableBusiness {



    @Autowired
    private TcgProjectService tcgProjectService;

    @Autowired
    private TcgJavaDatatypeRealService tcgJavaDatatypeRealService;

    static List<String> insideFieldNames = new ArrayList<String>();
    static{
        Field[] allField = ReflectionSuper.getAllField(BaseBusinessExEntity.class , BaseEntity.class);
        for(Field field : allField){
            insideFieldNames.add(field.getName());
        }
    }


    public TablePO tableBusiness(TcgDbConfigBO dbConfigBO, TcgTableConfigBO tableBO, ILoginUserEntity<String> sessionUserVO){


        TablePO tablePO = new TablePO();
        try {

            TcgProjectEntity project = tcgProjectService.selectById(tableBO.getProjectId());

            TcgJavaDatatypeRealQuery typeQuery = new TcgJavaDatatypeRealQueryImpl();
            List<TcgJavaDatatypeRealBO> types = tcgJavaDatatypeRealService.selectList(typeQuery.buildWrapper());
            Map<String,String> typeMap = new HashMap<String,String>();
            if(types != null && !types.isEmpty()){
                for(TcgJavaDatatypeRealBO type : types){
                    typeMap.put(type.getDataType() , type.getJavaType()) ;
                }
            }


            DbConfig dbConfig = new DbConfig(dbConfigBO.getDbType() , dbConfigBO.getDbUrl() , dbConfigBO.getDbUsername() , dbConfigBO.getDbPassword());

            ReadDbProcess readDbProcess = ReadDbFactory.buildReadDbProcess(dbConfigBO.getDbType());

            Table table = readDbProcess.readOneTable(dbConfig , tableBO.getSchemaName() , tableBO.getTableName());

            List<Column> columns = readDbProcess.readColumnsByTable(dbConfig, tableBO.getSchemaName() , tableBO.getTableName());



            List<Index> insexs = readDbProcess.readIndexsByTable( dbConfig, tableBO.getSchemaName() , tableBO.getTableName() );

            List<Constraint> constraints = readDbProcess.readConstraintsByTable( dbConfig, tableBO.getSchemaName(), tableBO.getTableName());

            //初始化表信息
            this.initTableConfig(tableBO, table , project , sessionUserVO);


            //初始化列信息
            List<TcgColumnConfigBO> columnBOs = new ArrayList<TcgColumnConfigBO>();
            int index = 0;
            for(Column column : columns){
                column.setDataType(column.getDataType().toUpperCase());
                TcgColumnConfigBO tcgColumnConfigBO = new TcgColumnConfigBO();
                initColumnConfig(tcgColumnConfigBO , tableBO, column ,typeMap , sessionUserVO);
                index ++ ;
                tcgColumnConfigBO.setColumnSort(index * 100);
                columnBOs.add(tcgColumnConfigBO);
            }

            //初始化列的扩展信息，  也就是BO里的属性
            List<TcgExColumnBO> exColumnBOs = new ArrayList<TcgExColumnBO>();
            for(TcgColumnConfigBO columnBO : columnBOs){
                if(insideFieldNames.contains(columnBO.getJavaName()) || "id".equals(columnBO.getJavaName())){
                    continue;
                }
                if(columnBO.getColumnIsdict().equals(EnumYesNo.YES.getCode())) {
                    //处理字典信息
                    TcgExColumnBO exColumnBO = new TcgExColumnBO();
                    initExColumn(exColumnBO, columnBO , sessionUserVO);
                    exColumnBO.setOriginalColumnDict(EnumYesNo.YES.getCode());
                    exColumnBOs.add(exColumnBO);
                }
                if(project.getPageUseView().equals(EnumYesNo.NO.getCode()) && columnBO.getColumnIsfk().equals(EnumYesNo.YES.getCode())){
                    //处理外键信息
                    TcgExColumnBO exColumnBO = new TcgExColumnBO();
                    initExColumn(exColumnBO, columnBO ,sessionUserVO);
                    exColumnBO.setOriginalColumnFk(EnumYesNo.YES.getCode());
                    exColumnBOs.add(exColumnBO);
                }
            }

            //处理列的页面信息
            List<TcgColumnPageBO> columnPageBOs = new ArrayList<TcgColumnPageBO>();
            for(TcgColumnConfigBO columnBO : columnBOs){
                TcgColumnPageBO pageBO = new TcgColumnPageBO();
                initColumnPage(pageBO , columnBO , sessionUserVO );
                columnPageBOs.add(pageBO);
            }
            for(TcgExColumnBO exColumnBO : exColumnBOs){
                TcgColumnPageBO pageBO = new TcgColumnPageBO();
                initColumnPage(pageBO , exColumnBO , sessionUserVO );
                columnPageBOs.add(pageBO);
            }


            //初始化表的索引信息
            List<TcgIndexConfigBO> indexBOs = new ArrayList<TcgIndexConfigBO>();
            for(Index ci : insexs){
                TcgIndexConfigBO indexBO = new TcgIndexConfigBO();
                initIndexConfig(indexBO , tableBO, ci , sessionUserVO);
                indexBOs.add(indexBO);
            }

            //初始化表的约束信息
            for(Constraint constraint : constraints){
                TcgIndexConfigBO indexBO = new TcgIndexConfigBO();
                initIndexConfig(indexBO , tableBO, constraint , sessionUserVO);
                indexBOs.add(indexBO);
            }

            tablePO.setTableBO(tableBO);
            tablePO.setColumns(columnBOs);
            tablePO.setExColumns(exColumnBOs);
            tablePO.setPageBOS(columnPageBOs);
            tablePO.setIndexBOs(indexBOs);

            return tablePO;

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }



    protected void initTableConfig(TcgTableConfigBO tcgTableConfigBO , Table table , TcgProjectEntity project ,ILoginUserEntity<String> sessionUserVO){
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



    protected void initColumnConfig(TcgColumnConfigBO columnBO, TcgTableConfigBO tableBO , Column column ,
                                    Map<String,String> typeMap ,ILoginUserEntity<String> sessionUserVO){
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

    protected void processJavaType(TcgColumnConfigBO columnBO, Map<String, String> typeMap) {
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


    protected void initIndexConfig(TcgIndexConfigBO indexBO, TcgTableConfigBO tcgTableConfigBO, Index ci ,ILoginUserEntity<String> sessionUserVO) {
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


    protected void initExColumn(TcgExColumnBO exColumnBO, TcgColumnConfigBO columnBO,ILoginUserEntity<String> sessionUserVO) {
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



    private void initColumnPage(TcgColumnPageBO pageBO, TcgExColumnBO columnBO, ILoginUserEntity<String> sessionUserVO) {
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

    private void initColumnPage(TcgColumnPageBO pageBO, TcgColumnConfigBO columnBO, ILoginUserEntity<String> sessionUserVO) {
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
    private void processPageElement(TcgColumnPageBO pageBO, TcgColumnConfigBO columnBO) {
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
    protected void setTableParent(TcgTableConfigBO tableBO , Column column){
        if(column.getColumnName().equalsIgnoreCase("pid") || column.getColumnName().equalsIgnoreCase("parent_id") ){
            tableBO.setIsTree(EnumYesNo.YES.getCode());
            tableBO.setParentFieldName(column.getColumnName());
        }
    }

}
