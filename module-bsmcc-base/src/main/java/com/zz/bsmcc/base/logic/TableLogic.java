package com.zz.bsmcc.base.logic;

import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.zz.bms.core.db.entity.EntityUtil;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.exceptions.InternalException;
import com.zz.bms.enums.EnumPageElement;
import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bms.util.base.data.StringUtil;
import com.zz.bms.util.base.java.IdUtils;
import com.zz.bms.util.base.java.ReflectionSuper;
import com.zz.bms.util.configs.enums.EnumExcelType;
import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.domain.TcgProjectEntity;
import com.zz.bsmcc.core.TablesLocalThread;
import com.zz.bsmcc.core.enums.*;
import com.zz.bsmcc.core.util.CgBeanUtil;
import com.zz.bsmcc.core.util.table.pojo.Column;
import com.zz.bsmcc.core.util.table.pojo.Index;
import com.zz.bsmcc.core.util.table.pojo.Table;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Administrator
 */
public class TableLogic {

    private static String regex = "^[a-z_]+[0-9]*$";

    public static List<String> insideFieldNames = new ArrayList<String>();
    static{
        Field[] allField = ReflectionSuper.getAllField(BaseBusinessExEntity.class , Object.class);
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
        if(StringUtils.isEmpty(tcgTableConfigBO.getIsBuildMenu())) {
            tcgTableConfigBO.setIsBuildMenu(tcgTableConfigBO.getIsBuildUi());
        }

        if(StringUtils.isEmpty(tcgTableConfigBO.getIsBuildRbac())) {
            tcgTableConfigBO.setIsBuildRbac(tcgTableConfigBO.getIsBuildUi());
        }
        tcgTableConfigBO.setTableType((String)EnumTableType.singleTable.getVal());
        tcgTableConfigBO.setPageRelation((String)EnumPageRelation.alone.getVal());
        tcgTableConfigBO.setIsShowCheckbox(EnumYesNo.YES.getCode());
        tcgTableConfigBO.setJavaName(StringUtil.firstUpperCase(StringFormatKit.toCamelCase(tcgTableConfigBO.getTableName())));
        tcgTableConfigBO.setIsTree(EnumYesNo.NO.getCode());
        tcgTableConfigBO.setIsReal(EnumYesNo.NO.getCode());


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
                                    Map<String,String> typeMap ,TcgProjectBO projectBO, ILoginUserEntity<String> sessionUserVO){

        columnBO.setTableBO(tableBO);
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

        //约定每个表的主键为id
        columnBO.setColumnIskey("id".equals(column.getColumnName().toLowerCase()) ? EnumYesNo.YES.getCode():EnumYesNo.NO.getCode());

        columnBO.setColumnIsfk(EnumYesNo.NO.getCode());
        if(!fieldNames.contains(columnBO.getJavaName())) {
            if (columnBO.getColumnIskey().equals(EnumYesNo.NO.getCode())) {

                boolean isFk = isFk(projectBO,columnBO);
                if(isFk) {
                    columnBO.setColumnIsfk(EnumYesNo.YES.getCode());
                    columnBO.setFkColumn("id");
                    //约定 schema外键和本表的是相同的
                    columnBO.setFkSchema(tableBO.getSchemaName());
                    //约定 外键的列名称是外键的表名称有一定的相似度，
                    //如外键表是tb_project ,外键就是 project_id
                    //如外键表是tb_project_asc ,外键就是 project_asc_id
                    processFkTable(columnBO);

                }
            }
        }


        columnBO.setColumnIsdict(EnumYesNo.NO.getCode());

        if(!fieldNames.contains(columnBO.getJavaName())) {
            if (columnBO.getColumnIskey().equals(EnumYesNo.NO.getCode()) || columnBO.getColumnIsfk().equals(EnumYesNo.NO.getCode())) {
                boolean isDict = isDict(columnBO , column);
                if(isDict) {
                    columnBO.setColumnIsdict(EnumYesNo.YES.getCode());
                    String dictType = columnBO.getColumnName().toLowerCase();
                    if(StringUtils.isNotEmpty(columnBO.getColumnOtherComment())){
                        String[] others = columnBO.getColumnOtherComment().split("        ");
                        String other0 = others[0].trim().replaceAll("\t","");
                        if(isDictTypeStr(other0)){
                            dictType = other0;
                        }
                    }
                    columnBO.setDictType(dictType);
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
        columnBO.setJavaSimpleClass(javaType.substring(javaType.lastIndexOf(".")+1));
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

        indexBO.setTipMsg("    ");

        indexBO.setId(IdUtils.getId());

    }


    public static void initExColumn(TcgExColumnBO exColumnBO, TcgColumnConfigBO columnBO, ILoginUserEntity<String> sessionUserVO) {
        exColumnBO.setTableBO(columnBO.getTableBO());
        exColumnBO.setTableId(columnBO.getTableId());
        exColumnBO.setOriginalColumnId(columnBO.getId());
        exColumnBO.setOriginalColumnName(columnBO.getColumnName());
        exColumnBO.setOriginalColumnDict(EnumYesNo.NO.getCode());
        exColumnBO.setOriginalColumnFk(EnumYesNo.NO.getCode());

        exColumnBO.setOriginalColumn(columnBO);

        String title = columnBO.getColumnComment();
        if(title.length()<=2){
            //title = title  + "名称";
        }else {
            if(title.toLowerCase().endsWith("id")){
                title = title.substring(0, title.length() -2) ;//+ "名称";
            }else {
                //title = title + "名称";
            }
        }
        exColumnBO.setColumnTitle(title);
        String javaName = columnBO.getJavaName();
        if(javaName.endsWith("Id") || javaName.endsWith("id")){
            javaName = javaName.substring(0 , javaName.length() -2) + "Name";
        }else {
            javaName = javaName + "Name";
        }
        if(javaName.length()==5){
            javaName = javaName.toLowerCase();
        }
        exColumnBO.setJavaName(javaName);
        exColumnBO.setJavaFullClass("java.lang.String");
        exColumnBO.setJavaSimpleClass("String");
        exColumnBO.setGroupCode(columnBO.getColumnName());

        //约定， 名称列就是表名加name
        //比如tb_project , 名称列就是project_name ;
        //比如tb_fund_buyer,名称列就是fund_buyer_name ;
        if(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsfk())) {
            String fkColumnName = columnBO.getFkName();
            if(fkColumnName != null) {
                fkColumnName = fkColumnName.substring(fkColumnName.indexOf("_") + 1) + "_name";
                exColumnBO.setFkColumnName(fkColumnName);
            }
        }


        exColumnBO.setColumnSort(columnBO.getColumnSort() + 1);


        EntityUtil.autoSetInsertEntity(exColumnBO , sessionUserVO);



        exColumnBO.setId(IdUtils.getId());

    }



    public static void initColumnPage(TcgColumnPageBO pageBO, TcgExColumnBO exColumnBO, ILoginUserEntity<String> sessionUserVO) {

        pageBO.setExColumn(exColumnBO);
        try {
            exColumnBO.setJavaClass(Class.forName(exColumnBO.getJavaFullClass()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pageBO.setNumber(exColumnBO.isNumber());
        pageBO.setDate(exColumnBO.isDate());

        pageBO.setRealColumn(EnumYesNo.NO.getCode());

        pageBO.setExistPage(EnumYesNo.YES.getCode());
        pageBO.setEditable(EnumYesNo.YES.getCode());
        pageBO.setHiddenable(EnumYesNo.NO.getCode());
        pageBO.setListShowable(pageBO.getEditable());

        pageBO.setElement((String) EnumPageElement.text.getVal());

        pageBO.setExcelType(EnumExcelType.IMPORT_EXPORT.getVal());
        if(exColumnBO.getOriginalColumn() != null && EnumYesNo.YES.getCode().equals(exColumnBO.getOriginalColumn().getColumnIsfk())){
            pageBO.setElement((String) EnumPageElement.openwin.getVal());
        }

        if(EnumYesNo.YES.getCode().equals(exColumnBO.getOriginalColumnDict())){
            pageBO.setExistPage(EnumYesNo.NO.getCode());
            pageBO.setEditable(EnumYesNo.NO.getCode());
            pageBO.setHiddenable(EnumYesNo.NO.getCode());
            pageBO.setListShowable(EnumYesNo.YES.getCode());


            if(StringUtils.isNotEmpty(exColumnBO.getOriginalColumn().getColumnDefault())){
                pageBO.setExistPage(EnumYesNo.NO.getCode());
                pageBO.setEditable(EnumYesNo.NO.getCode());
                pageBO.setHiddenable(EnumYesNo.NO.getCode());
                pageBO.setListShowable(EnumYesNo.NO.getCode());
                pageBO.setExcelType(EnumExcelType.NONE.getVal());
            }

        }

        pageBO.setRequired(EnumYesNo.YES.getCode());



        EntityUtil.autoSetInsertEntity(pageBO , sessionUserVO);

        pageBO.setId(exColumnBO.getId());
        pageBO.setTableId(exColumnBO.getTableId());


    }

    public static void initColumnPage(TcgColumnPageBO pageBO, TcgColumnConfigBO columnBO, ILoginUserEntity<String> sessionUserVO) {

        pageBO.setColumnConfig(columnBO);
        try {
            columnBO.setJavaClass(Class.forName(columnBO.getJavaFullClass()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        pageBO.setNumber(columnBO.isNumber());
        pageBO.setDate(columnBO.isDate());

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
            pageBO.setExcelType(EnumExcelType.NONE.getVal());
        }else if(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsdict())){
            //字典
            pageBO.setExistPage(EnumYesNo.YES.getCode());
            pageBO.setEditable(EnumYesNo.YES.getCode());
            pageBO.setHiddenable(EnumYesNo.NO.getCode());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
            pageBO.setExcelType(EnumExcelType.NONE.getVal());

            if(StringUtils.isNotEmpty(columnBO.getColumnDefault())){

                pageBO.setExistPage(EnumYesNo.NO.getCode());
                pageBO.setEditable(EnumYesNo.NO.getCode());
                pageBO.setHiddenable(EnumYesNo.NO.getCode());
                pageBO.setListShowable(EnumYesNo.NO.getCode());
                pageBO.setExcelType(EnumExcelType.NONE.getVal());
            }

        }else {
                pageBO.setExistPage(EnumYesNo.YES.getCode());
                pageBO.setEditable(EnumYesNo.YES.getCode());
                pageBO.setHiddenable(EnumYesNo.NO.getCode());
                pageBO.setListShowable(pageBO.getEditable());
                pageBO.setExcelType(EnumExcelType.IMPORT_EXPORT.getVal());

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
            pageBO.setElement((String) EnumPageElement.text.getVal());
        }else if(EnumYesNo.YES.getCode().equals(columnBO.getColumnIsdict())){
            pageBO.setElement((String)EnumPageElement.select.getVal());
        }else {
            Class clz = null;
            try {
                clz = Class.forName(columnBO.getJavaFullClass());
            } catch (ClassNotFoundException e) {
                throw new InternalException("Java 类型错误 : " + columnBO.getJavaFullClass());
            }
            if( clz.isAssignableFrom(Number.class) || Number.class.isAssignableFrom(clz)) {
                if (columnBO.getColumnScale() != null && columnBO.getColumnScale() > 0) {
                    pageBO.setElement((String) EnumPageElement.number.getVal());
                } else {
                    pageBO.setElement((String) EnumPageElement.digits.getVal());
                }
            }else if(clz == int.class || clz == long.class){
                pageBO.setElement((String) EnumPageElement.digits.getVal());
            }else if(clz == double.class || clz == float.class){
                pageBO.setElement((String) EnumPageElement.number.getVal());
            }else if(clz == Date.class){
                pageBO.setElement((String) EnumPageElement.date.getVal());
            }else if(clz == java.sql.Timestamp.class){
                pageBO.setElement((String) EnumPageElement.timestamp.getVal());
            }else if(clz == String.class){
                pageBO.setElement((String) EnumPageElement.text.getVal());
                if(columnBO.getColumnLength() >= 300){
                    pageBO.setElement((String) EnumPageElement.textarea.getVal());
                    pageBO.setListShowable(EnumYesNo.NO.getCode());
                    //处理文件类型和图片类型
                    setFileImage4Page(pageBO);
                }else {
                    pageBO.setElement((String) EnumPageElement.text.getVal());
                    //处理文件类型和图片类型
                    setFileImage4Page(pageBO);
                }
            }else {
                pageBO.setElement((String) EnumPageElement.text.getVal());
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
        //约定， 如果是上级表的外键， 名称为pid 或者 parent_id
        if(isTableParent(column.getColumnName()) ){
            tableBO.setIsTree(EnumYesNo.YES.getCode());
            tableBO.setParentFieldName(column.getColumnName());
        }
    }

    public static boolean isTableParent(String columnName) {
        if (columnName.equalsIgnoreCase("pid") || columnName.equalsIgnoreCase("parent_id")) {
            return true;
        }else  {
            return false;
        }
    }


    public static void setTableReal(TcgTableConfigBO tableBO  , List<TcgColumnConfigBO> columnConfigBOS){
        if(tableBO != null && EnumYesNo.YES.getCode().equals(tableBO.getIsTable()) && columnConfigBOS != null && columnConfigBOS.size() == 3){
            for(TcgColumnConfigBO columnConfigBO : columnConfigBOS){
                if(EnumYesNo.NO.getCode().equals(columnConfigBO.getColumnIskey()) && EnumYesNo.NO.getCode().equals(columnConfigBO.getColumnIsfk())){
                    return ;
                }
            }
            tableBO.setIsReal(EnumYesNo.YES.getCode());

            tableBO.setIsBuildMenu(EnumYesNo.NO.getCode());
            tableBO.setIsBuildRbac(EnumYesNo.NO.getCode());
            tableBO.setIsBuildUi(EnumYesNo.NO.getCode());

            tableBO.setTableType(EnumTableType.childTable.getVal());
            tableBO.setTableRelation(EnumTableRelation.one2multi.getVal());
            tableBO.setPageRelation(EnumPageRelation.embed.getVal());
        }else {
            return ;
        }
    }




    private static boolean isFk(TcgProjectBO projectBO,TcgColumnConfigBO columnBO) {

        if(EnumYesNo.NO.getCode().equals(projectBO.getProjectTenant())){
            if(columnBO.getColumnName().toLowerCase().endsWith("tenant_id")){
                return false;
            }
        }


        if(EnumYesNo.NO.getCode().equals(projectBO.getProjectOrgan())){
            if(columnBO.getColumnName().toLowerCase().endsWith("organ_id")){
                return false;
            }
        }

        //约定  外键列的长度为 32 , 36 , 64 , 并且不是file , files , image , images 结尾的
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

    /**
     * 数字列是否图片 文件
     * @param pageBO
     */
    public static void setFileImage4Page(TcgColumnPageBO pageBO) {
        //约定 ， 单文件以file结尾，  多文件以files结尾， 单图片以image结尾， 多图片以images结尾
        if(isFiles(pageBO.getColumnConfig())){
            pageBO.setElement(EnumPageElement.multifile.getValue());
            pageBO.setElementNmae(EnumPageElement.multifile.getLabel());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if(isFile(pageBO.getColumnConfig())){
            pageBO.setElement(EnumPageElement.singlefile.getValue());
            pageBO.setElementNmae(EnumPageElement.singlefile.getLabel());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if(isImages(pageBO.getColumnConfig())){
            pageBO.setElement(EnumPageElement.multiimage.getValue());
            pageBO.setElementNmae(EnumPageElement.multiimage.getLabel());
            pageBO.setListShowable(EnumYesNo.NO.getCode());
        }else if(isImage(pageBO.getColumnConfig())){
            pageBO.setElement(EnumPageElement.singleimage.getValue());
            pageBO.setElementNmae(EnumPageElement.singleimage.getLabel());
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


    /**
     * 判断列是否是字典
     * @param columnBO
     * @param column
     * @return
     */
    private static boolean isDict(TcgColumnConfigBO columnBO , Column column){
        //约定 字典或者枚举 列类型为  char(1) , varchar(2)
        if ( (column.isFixedChar() && column.getCharmaxLength() == 1) || column.getCharmaxLength() == 2) {
            return true;
        }
        return false;
    }


    /**
     * 判断字符串是否符合字典类型的命名
     * @param dicttype
     * @return
     */
    private static boolean isDictTypeStr(String dicttype){
        if(StringUtils.isEmpty(dicttype)){
            return false;
        }
        if(dicttype.length() > 100){
            return false;
        }
        //约定 字典类型只能是数字加下划线
        return dicttype.matches(regex);
    }


    /**
     * 处理外键的schema 和 tableName
     * @param columnBO
     */
    private static void processFkTable(TcgColumnConfigBO columnBO) {
        //如果外键对应的是表自己
        if(isTableParent(columnBO.getColumnName())){
            columnBO.setFkName(columnBO.getTableBO().getTableName());
            columnBO.setFkTableConfig(columnBO.getTableBO());
            return ;
        }

        List<Table> tables = TablesLocalThread.getTables();
        if(tables == null || tables.isEmpty()){
            return ;
        }
        Map<String,List<Table>> tablesMap = TablesLocalThread.getTablesMap();
        String[] columnNames = columnBO.getColumnName().split("_");
        if(columnNames.length<2){
            //约定， 外键的列名称必须通过'_'间隔 ， 除非是pid
            columnBO.setColumnIsfk(EnumYesNo.NO.getCode());
            columnBO.setFkTableConfig(null);
            columnBO.setFkSchema(null);
            columnBO.setFkName(null);
            columnBO.setFkColumn(null);
            columnBO.setFkColumnName(null);
            return ;
        }


        String theTableName = columnBO.getTableBO().getTableName();
        String prefixFkTableNme = theTableName.substring(0,theTableName.indexOf("_")) ;


        processColumnFk(columnBO, tables, tablesMap, columnNames, prefixFkTableNme);

        if(StringUtils.isEmpty(columnBO.getFkName())) {
            processColumnFk(columnBO, tables, tablesMap, columnNames, null);
        }

        if(StringUtils.isEmpty(columnBO.getFkName())) {
            //约定  如果外键没有找到对应的表信息， 则认为不是外键
            columnBO.setColumnIsfk(EnumYesNo.NO.getCode());
            columnBO.setFkTableConfig(null);
            columnBO.setFkSchema(null);
            columnBO.setFkName(null);
            columnBO.setFkColumn(null);
            columnBO.setFkColumnName(null);
        }

    }

    private static void processColumnFk(TcgColumnConfigBO columnBO,
                               List<Table> tables,
                               Map<String, List<Table>> tablesMap,
                               String[] columnNames,
                               String prefixFkTableNme) {
        for(int index = 0 ; index < columnNames.length - 1; index ++){
            String suffixFkTableNme = getSuffixTableName(columnNames , index);
            String tableName =  suffixFkTableNme;
            if(StringUtils.isNotEmpty(prefixFkTableNme)){
                tableName = prefixFkTableNme + "_" + suffixFkTableNme;
            }
            //先在本schema 下精确查找
            String table = findTableName(tableName , tables , true);
            if(table == null){
                //再在本scheam下匹配查找
                table = findTableName(suffixFkTableNme , tables , false);
            }
            if(table == null && tablesMap != null && !tablesMap.isEmpty()) {
                String[] st = null;
                //在全数据库下精确查找
                st = findTableName(tableName, tablesMap, true);

                if(st == null){
                    st = findTableName(suffixFkTableNme, tablesMap, false);
                }

                if(st != null){
                    columnBO.setFkSchema(st[0]);
                    columnBO.setFkName(st[1]);
                    break;
                }
            }
            if(StringUtils.isNotEmpty(table)){
                columnBO.setFkName(table);
                break;
            }
        }
    }


    /**
     * 在本schema 下查找表名称
     * @param tableName  表名的一部分
     * @param tables     所有的表名
     * @return
     */
    private static String findTableName(String tableName , List<Table> tables , boolean isEquals ){
        for(Table table : tables){
            if(isEquals){
                if(table.getTableName().equalsIgnoreCase(tableName)){
                    return table.getTableName();
                }else {
                    String tab = table.getTableName().substring(table.getTableName().indexOf("_")+1);
                    if(tab.equalsIgnoreCase(tableName)){
                        return table.getTableName();
                    }
                }
            }
        }
        return null;
    }


    /**
     * 在整个数据库 下查找表名称
     * @param tableName  表名的一部分
     * @param tablesMap     所有的表名
     * @return
     */
    private static String[] findTableName(String tableName , Map<String,List<Table>> tablesMap , boolean isEquals ){
        if(tablesMap == null){
            return null;
        }
        for(String key : tablesMap.keySet()) {
            List<Table> tables = tablesMap.get(key);
            String table = findTableName(tableName ,tables , isEquals );
            if(table != null){
                return new String[]{key , table};
            }
        }
        return null;
    }


    /**
     * 根据列名称或者表的后面部分
     * 如列为 lead_user_id ,  获取 lead_user , 或者 user
     * @param columnNames
     * @param index
     * @return
     */
    private static String getSuffixTableName(String[] columnNames, int index) {
        StringBuilder sb = new StringBuilder("");
        for( ; index < columnNames.length -1 ; index++){
            sb.append(columnNames[index]).append("_");
        }
        if(sb.length() > 1){
            sb = sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String column = "project_acs_id";
        String table = "tb_project_acs";
        System.out.println(table.substring(0,table.indexOf("_")) );
        System.out.println(getSuffixTableName(column.split("_"),0));
        System.out.println(getSuffixTableName(column.split("_"),1));
    }



}
