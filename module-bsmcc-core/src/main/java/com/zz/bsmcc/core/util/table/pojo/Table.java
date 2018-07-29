package com.zz.bsmcc.core.util.table.pojo;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class Table implements Serializable {

    String id;

    String tableName;
    String tableSchema;
    String tableType;
    String tableComment;


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
}
