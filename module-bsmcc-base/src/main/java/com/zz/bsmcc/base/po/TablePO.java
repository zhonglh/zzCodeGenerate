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
    private List<TcgColumnPageBO> pageBOS;
    private List<TcgIndexConfigBO> indexBOs;


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

    public List<TcgColumnPageBO> getPageBOS() {
        return pageBOS;
    }

    public void setPageBOS(List<TcgColumnPageBO> pageBOS) {
        this.pageBOS = pageBOS;
    }

    public List<TcgIndexConfigBO> getIndexBOs() {
        return indexBOs;
    }

    public void setIndexBOs(List<TcgIndexConfigBO> indexBOs) {
        this.indexBOs = indexBOs;
    }
}
