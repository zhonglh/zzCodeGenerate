package com.zz.bsmcc.base.po;

import com.zz.bsmcc.base.bo.*;

import java.io.Serializable;
import java.util.Map;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 表格的所有元素
 * @author Administrator
 */
public class TablePO implements Serializable{

    private TcgTableConfigBO tableBO;
    private List<TcgColumnConfigBO> columns;
    private List<TcgExColumnBO> exColumns;
    private List<TcgIndexConfigBO> indexs;
    private List<TcgColumnPageBO> columnPages;

    private List<TcgColumnValidateBO> columnValidates;
    private List<TcgColumnEventBO> columnEvents;
    private List<TcgQueryConfigBO> queryConfigs;

    //用于界面选择
    private List<TcgTableOperationBO> tableOperations;
    //用于界面选择按钮
    private List<TcgTempletGroupOperationBO> templetGroupOperations;


    //扩展列
    private Map<String,List<TcgExColumnBO>> exColumnMap;


    //用于列表界面上查询的弹框选择 ， 需要是外键列或者同组有外键列的
    Map<String,List<TcgQueryConfigBO>> queryFks;
    //用于列表界面上查询的弹框选择， 需要 去重
    List<TcgTableConfigBO> queryFkTables;

    //用于列表界面上查询的 字典选择 , 不用去重
    List<TcgQueryConfigBO> queryDicts;
    //用于列表界面上查询的 queryDicts 去重
    Map<String,TcgQueryConfigBO> queryDictSet;




    //用于编辑界面 , 需要是外键列或者同组有外键列的
    Map<String,List<TcgColumnPageBO>> fks;
    //用于编辑界面 , 需要 去重
    List<TcgTableConfigBO> fkTables;

    //用于编辑界面, 字典选择
    List<TcgColumnPageBO> dicts;
    //用于编辑界面, dicts去重
    Map<String,TcgColumnPageBO> dictSet;



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

    public Map<String,List<TcgQueryConfigBO>> getQueryFks() {
        return queryFks;
    }

    public void setQueryFks(Map<String,List<TcgQueryConfigBO>> queryFks) {
        this.queryFks = queryFks;
    }

    public List<TcgQueryConfigBO> getQueryDicts() {
        return queryDicts;
    }

    public void setQueryDicts(List<TcgQueryConfigBO> queryDicts) {
        this.queryDicts = queryDicts;
    }

    public Map<String,List<TcgColumnPageBO>> getFks() {
        return fks;
    }

    public void setFks(Map<String,List<TcgColumnPageBO>> fks) {
        this.fks = fks;
    }

    public List<TcgColumnPageBO> getDicts() {
        return dicts;
    }

    public void setDicts(List<TcgColumnPageBO> dicts) {
        this.dicts = dicts;
    }

    public List<TcgTableConfigBO> getQueryFkTables() {
        return queryFkTables;
    }

    public void setQueryFkTables(List<TcgTableConfigBO> queryFkTables) {
        this.queryFkTables = queryFkTables;
    }

    public List<TcgTableConfigBO> getFkTables() {
        return fkTables;
    }

    public void setFkTables(List<TcgTableConfigBO> fkTables) {
        this.fkTables = fkTables;
    }

    public Map<String, TcgQueryConfigBO> getQueryDictSet() {
        return queryDictSet;
    }

    public void setQueryDictSet(Map<String, TcgQueryConfigBO> queryDictSet) {
        this.queryDictSet = queryDictSet;
    }

    public Map<String, TcgColumnPageBO> getDictSet() {
        return dictSet;
    }

    public void setDictSet(Map<String, TcgColumnPageBO> dictSet) {
        this.dictSet = dictSet;
    }

    @Override
    public String toString() {
        return tableBO != null ? tableBO.getTableName() : "";
    }
}
