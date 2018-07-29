package com.zz.bsmcc.core.util.table.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 索引  唯一索引
 * @author Administrator
 */
public class Index implements Serializable {


    String indexName ;
    List<String> columnNames;

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
}
