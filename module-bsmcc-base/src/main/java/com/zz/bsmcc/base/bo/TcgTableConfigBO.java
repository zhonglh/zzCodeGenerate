package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;
import com.zz.bsmcc.base.domain.TcgTableConfigEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


/**
* 表设置 BO , 扩展 表设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="表设置" , resource = "")
@TableName(value="tcg_table_config" , resultMap = "TcgTableConfigResultMap")
public class TcgTableConfigBO extends TcgTableConfigEntity implements Serializable {

    /**
     * 数据库设置标题
     */
    @TableField(exist = false)
    private String dbConfigTitle;

    /**
     * 项目名称
     */
    @TableField(exist = false)
    private String projectName;

    /**
     * 模块名称
     */
    @TableField(exist = false)
    private String moduleName;

    /**
     * 表类型名称
     * 如主表， 子表等
     */
    @TableField(exist = false)
    private String tableTypeName;

    /**
     * 表关系名称
     * 如 一对多 ， 多对多
     */
    @TableField(exist = false)
    private String tableRelationName;


    /**
     * 查询模式名称
     * 如 工具栏样式 , 普通模式
     */
    @TableField(exist = false)
    private String queryModeName;


    //简单名称 , 去掉第一个下划线 ， 并且第一个字母为小写
    //如表名为tb_user 为 user
    //如表名为ts_menu_role 为 menuRole
    @TableField(exist = false)
    private String simpleName ;


    /**
     * businessKey 对应列的 get方法
     */
    private List<String> businessKeyGetMethods;



    /**
     * businessName 对应列的 get方法
     */
    private List<String> businessNameGetMethods;




    //用于模板生成数据




    //是否有版本信息
    @TableField(exist = false)
    private boolean haveVersion;

    //用于视图对应的主表信息
    @TableField(exist = false)
    private TcgTableConfigBO mainTableConfig;

    /**
     * 资源全称 ,  本身的资源
     * 如 /system/user
     */
    @TableField(exist = false)
    private String fullResourceName;



    /**
     * 和 fullResourceName 类似 , 首字母大写
     * 去除fullResourceName 中的 /
     * 如 SystemUser
     */
    @TableField(exist = false)
    private String fullUpperResourceName;

    /**
     * 资源全称 ,  本身的资源 , 用 . 分割
     * 如 system.user
     */
    @TableField(exist = false)
    private String fullResource;

    /**
     * 和 fullResourceName 类似
     * 去除fullResourceName 中的 / \
     * 如 systemuser
     */
    @TableField(exist = false)
    private String fullResourceFile;



    /**
     * 包全称 ， 项目的包名 + 模块的包名 , 使用的时候还要在加上模板对应的包名
     */
    @TableField(exist = false)
    private String fullPackageName;

    /**
     * 实体类要继承的父类
     * BaseEntity  BaseBussinessEntity
     */
    @TableField(exist = false)
    private String parentClass;



    /**
     * 在实体类中汇总要import的类
     */
    @TableField(exist = false)
    private List<String> importClasss;

    /**
     * 所有外键对应的表信息
     */
    @TableField(exist = false)
    private List<TcgTableConfigBO> fkTables;


    /**
     * 所有外键对应的列名称
     */
    @TableField(exist = false)
    private List<TcgColumnConfigBO> fkColumns;

    /**
     * 用到的字典类型集合
     */
    @TableField(exist = false)
    private List<String> dictTypes ;




    /**
     * 本表ID是哪些表的外键
     */
    @TableField(exist = false)
    private List<TcgTableConfigBO> childFkTables;

    /**
     * 本表ID是哪些表的外键 , 外键的列名
     */
    @TableField(exist = false)
    private List<TcgColumnConfigBO> childFkColumns;


    /**
     * 和本表同一界面用到的子表 附表
     */
    @TableField(exist = false)
    private List<TcgTableConfigBO> pageChildTables;

    /**
     * 和本表同一界面用到的子表 附表 , 对应的外键列名
     */
    @TableField(exist = false)
    private List<TcgColumnConfigBO> pageChildColumns;



    /**
     * 表或者视图  对应的BO对象 类全名
     */
    @TableField(exist = false)
    private String fullBoClassName;





    public String getDbConfigTitle() {
        return dbConfigTitle;
    }

    public void setDbConfigTitle(String dbConfigTitle) {
        this.dbConfigTitle = dbConfigTitle;


    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTableTypeName() {
        return tableTypeName;
    }

    public void setTableTypeName(String tableTypeName) {
        this.tableTypeName = tableTypeName;
    }

    public String getTableRelationName() {
        return tableRelationName;
    }

    public void setTableRelationName(String tableRelationName) {
        this.tableRelationName = tableRelationName;
    }


    public String getQueryModeName() {
        return queryModeName;
    }

    public void setQueryModeName(String queryModeName) {
        this.queryModeName = queryModeName;
    }

    public String getParentClass() {
        return parentClass;
    }

    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }

    public List<String> getImportClasss() {
        return importClasss;
    }

    public void setImportClasss(List<String> importClasss) {
        this.importClasss = importClasss;
    }

    public String getFullResourceName() {
        return fullResourceName;
    }

    public void setFullResourceName(String fullResourceName) {
        this.fullResourceName = fullResourceName;
    }

    public String getFullResource() {
        return fullResource;
    }

    public void setFullResource(String fullResource) {
        this.fullResource = fullResource;
    }

    public String getFullResourceFile() {
        return fullResourceFile;
    }

    public void setFullResourceFile(String fullResourceFile) {
        this.fullResourceFile = fullResourceFile;
    }

    public String getFullPackageName() {
        return fullPackageName;
    }

    public void setFullPackageName(String fullPackageName) {
        this.fullPackageName = fullPackageName;
    }

    public TcgTableConfigBO getMainTableConfig() {
        return mainTableConfig;
    }

    public void setMainTableConfig(TcgTableConfigBO mainTableConfig) {
        this.mainTableConfig = mainTableConfig;
    }

    public List<TcgTableConfigBO> getFkTables() {
        return fkTables;
    }

    public void setFkTables(List<TcgTableConfigBO> fkTables) {
        this.fkTables = fkTables;
    }



    public List<String> getDictTypes() {
        return dictTypes;
    }

    public void setDictTypes(List<String> dictTypes) {
        this.dictTypes = dictTypes;
    }

    public boolean isHaveVersion() {
        return haveVersion;
    }

    public void setHaveVersion(boolean haveVersion) {
        this.haveVersion = haveVersion;
    }

    public List<TcgTableConfigBO> getChildFkTables() {
        return childFkTables;
    }

    public void setChildFkTables(List<TcgTableConfigBO> childFkTables) {
        this.childFkTables = childFkTables;
    }


    public List<TcgColumnConfigBO> getFkColumns() {
        return fkColumns;
    }

    public void setFkColumns(List<TcgColumnConfigBO> fkColumns) {
        this.fkColumns = fkColumns;
    }

    public List<TcgColumnConfigBO> getChildFkColumns() {
        return childFkColumns;
    }

    public void setChildFkColumns(List<TcgColumnConfigBO> childFkColumns) {
        this.childFkColumns = childFkColumns;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public List<String> getBusinessKeyGetMethods() {
        return businessKeyGetMethods;
    }

    public void setBusinessKeyGetMethods(List<String> businessKeyGetMethods) {
        this.businessKeyGetMethods = businessKeyGetMethods;
    }

    public List<String> getBusinessNameGetMethods() {
        return businessNameGetMethods;
    }

    public void setBusinessNameGetMethods(List<String> businessNameGetMethods) {
        this.businessNameGetMethods = businessNameGetMethods;
    }

    public String getFullBoClassName() {
        return fullBoClassName;
    }

    public void setFullBoClassName(String fullBoClassName) {
        this.fullBoClassName = fullBoClassName;
    }

    public String getFullUpperResourceName() {
        return fullUpperResourceName;
    }

    public void setFullUpperResourceName(String fullUpperResourceName) {
        this.fullUpperResourceName = fullUpperResourceName;
    }

    public String getBusinessNameCamelCase() {
        return StringFormatKit.toCamelCase( super.getBusinessName() );
    }

    public String getParentFieldNameCamelCase() {
        return StringFormatKit.toCamelCase( super.getParentFieldName() );
    }

    public String getBusinessKeyCamelCase() {
        return StringFormatKit.toCamelCase( super.getBusinessKey() );
    }

    public List<TcgTableConfigBO> getPageChildTables() {
        return pageChildTables;
    }

    public void setPageChildTables(List<TcgTableConfigBO> pageChildTables) {
        this.pageChildTables = pageChildTables;
    }

    public List<TcgColumnConfigBO> getPageChildColumns() {
        return pageChildColumns;
    }

    public void setPageChildColumns(List<TcgColumnConfigBO> pageChildColumns) {
        this.pageChildColumns = pageChildColumns;
    }
}
