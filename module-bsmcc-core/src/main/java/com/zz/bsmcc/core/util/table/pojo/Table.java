package com.zz.bsmcc.core.util.table.pojo;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Table implements Serializable {


    String tableName;
    String tableSchema;
    String tableType;
    String tableComment;
    String tableOtherComment;


    String id;
    /**
     * 是否为表
     * true:表
     * false 视图
     */
    boolean isTable;



    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isTable() {
        return isTable;
    }

    public void setTable(boolean table) {
        isTable = table;
    }


    public String getTableOtherComment() {
        return tableOtherComment;
    }

    public void setTableOtherComment(String tableOtherComment) {
        this.tableOtherComment = tableOtherComment;
    }
}
