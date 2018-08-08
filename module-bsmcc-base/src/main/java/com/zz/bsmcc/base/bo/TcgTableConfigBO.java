package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.zz.bsmcc.base.domain.TcgTableConfigEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;
import java.util.List;


/**
* 表设置 BO , 扩展 表设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="表设置" , resource = "")
@TableName(value="tcg_table_config" , resultMap = "TcgTableConfigResultMap")
public class TcgTableConfigBO extends TcgTableConfigEntity implements Serializable {

    @TableField(exist = false)
    private String dbConfigTitle;

    @TableField(exist = false)
    private String projectName;


    @TableField(exist = false)
    private String moduleName;


    @TableField(exist = false)
    private String tableTypeName;

    @TableField(exist = false)
    private String tableRelationName;


    @TableField(exist = false)
    private String mainTableName;


    @TableField(exist = false)
    private String queryModeName;


    //用于模板生成数据


    @TableField(exist = false)
    //用于视图对应的主表信息
    private TcgTableConfigBO mainTableIdConfig;

    /**
     * 资源全称 ,  本身的资源
     */
    @TableField(exist = false)
    private String fullResourceName;

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


    @TableField(exist = false)
    private List<String> dictTypes;


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

    public String getMainTableName() {
        return mainTableName;
    }

    public void setMainTableName(String mainTableName) {
        this.mainTableName = mainTableName;
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

    public String getFullPackageName() {
        return fullPackageName;
    }

    public void setFullPackageName(String fullPackageName) {
        this.fullPackageName = fullPackageName;
    }

    public TcgTableConfigBO getMainTableIdConfig() {
        return mainTableIdConfig;
    }

    public void setMainTableIdConfig(TcgTableConfigBO mainTableIdConfig) {
        this.mainTableIdConfig = mainTableIdConfig;
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
}
