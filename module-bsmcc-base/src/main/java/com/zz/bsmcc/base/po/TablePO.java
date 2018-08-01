package com.zz.bsmcc.base.po;

import com.zz.bsmcc.base.bo.*;

import java.io.Serializable;
import java.util.List;

/**
 * 表格的所有元素
 * @author Administrator
 */
public class TablePO implements Serializable{

    private TcgTableConfigBO tableBO;
    private List<TcgColumnConfigBO> columns;
    private List<TcgExColumnBO> exColumns;
    private List<TcgColumnPageBO> columnPages;
    private List<TcgIndexConfigBO> indexs;

    private List<TcgColumnValidateBO> columnValidates;
    private List<TcgColumnEventBO> columnEvents;
    private List<TcgQueryConfigBO> queryConfigs;
    private List<TcgTableOperationBO> tableOperations;



    public TcgTableConfigBO getTableBO() {
        return tableBO;
    }

    public void setTableBO(TcgTableConfigBO tableBO) {
        this.tableBO = tableBO;
    }

    public List<TcgColumnConfigBO> getColumns() {
        return columns;
    }

    public void setColumns(List<TcgColumnConfigBO> columns) {
        this.columns = columns;
    }

    public List<TcgExColumnBO> getExColumns() {
        return exColumns;
    }

    public void setExColumns(List<TcgExColumnBO> exColumns) {
        this.exColumns = exColumns;
    }


    public List<TcgColumnPageBO> getColumnPages() {
        return columnPages;
    }

    public void setColumnPages(List<TcgColumnPageBO> columnPages) {
        this.columnPages = columnPages;
    }

    public List<TcgIndexConfigBO> getIndexs() {
        return indexs;
    }

    public void setIndexs(List<TcgIndexConfigBO> indexs) {
        this.indexs = indexs;
    }

    public List<TcgColumnValidateBO> getColumnValidates() {
        return columnValidates;
    }

    public void setColumnValidates(List<TcgColumnValidateBO> columnValidates) {
        this.columnValidates = columnValidates;
    }

    public List<TcgColumnEventBO> getColumnEvents() {
        return columnEvents;
    }

    public void setColumnEvents(List<TcgColumnEventBO> columnEvents) {
        this.columnEvents = columnEvents;
    }

    public List<TcgQueryConfigBO> getQueryConfigs() {
        return queryConfigs;
    }

    public void setQueryConfigs(List<TcgQueryConfigBO> queryConfigs) {
        this.queryConfigs = queryConfigs;
    }

    public List<TcgTableOperationBO> getTableOperations() {
        return tableOperations;
    }

    public void setTableOperations(List<TcgTableOperationBO> tableOperations) {
        this.tableOperations = tableOperations;
    }
}
