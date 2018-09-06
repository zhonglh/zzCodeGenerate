package com.zz.bsmcc.core;

import com.zz.bsmcc.core.util.table.pojo.Table;

import java.util.List;
import java.util.Map;

/**
 * 表格名称本线程存储
 * @author Administrator
 */
public class TablesLocalThread {

    /**
     * 本Scheam下的所有表名称
     */
    private static ThreadLocal<List<Table>> tables = new ThreadLocal<List<Table>>();

    /**
     * 所有表名称
     */
    private static ThreadLocal<Map<String,List<Table>>> tablesMap = new ThreadLocal<Map<String,List<Table>>>();


    public static void setTables(List<Table> ts) {
        tables.set(ts);
    }


    public static List<Table> getTables() {
        return tables.get();
    }



    public static void setTablesMap(Map<String,List<Table>> tsMap) {
        tablesMap.set(tsMap);
    }


    public static Map<String,List<Table>> getTablesMap() {
        return tablesMap.get();
    }



}
