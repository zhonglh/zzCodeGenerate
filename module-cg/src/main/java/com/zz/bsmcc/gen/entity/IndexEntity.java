package com.zz.bsmcc.gen.entity;

import java.util.List;

/**
 * 唯一索引对象
 */
public class IndexEntity implements java.io.Serializable {

    String indexName ;
    List<String> columnNames;
    List<String> javaNames;

    public IndexEntity() {
    }

    public IndexEntity(String indexName, List<String> columnNames, List<String> javaNames) {
        this.indexName = indexName;
        this.columnNames = columnNames;
        this.javaNames = javaNames;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<String> getJavaNames() {
        return javaNames;
    }

    public void setJavaNames(List<String> javaNames) {
        this.javaNames = javaNames;
    }
}
