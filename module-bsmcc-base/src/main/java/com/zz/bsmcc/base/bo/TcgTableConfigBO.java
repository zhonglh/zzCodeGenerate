package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.zz.bsmcc.base.domain.TcgTableConfigEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



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
}
