package com.zz.bsmcc.base.po;

import com.zz.bsmcc.base.bo.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

    //用于界面选择
    private List<TcgTableOperationBO> tableOperations;
    //用于界面选择按钮
    private List<TcgTempletGroupOperationBO> templetGroupOperations;



    private Map<String,List<TcgExColumnBO>> exColumnMap;



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

    public List<TcgTempletGroupOperationBO> getTempletGroupOperations() {
        return templetGroupOperations;
    }

    public void setTempletGroupOperations(List<TcgTempletGroupOperationBO> templetGroupOperations) {
        this.templetGroupOperations = templetGroupOperations;
    }

    public Map<String, List<TcgExColumnBO>> getExColumnMap() {
        return exColumnMap;
    }

    public void setExColumnMap(Map<String, List<TcgExColumnBO>> exColumnMap) {
        this.exColumnMap = exColumnMap;
    }
}
