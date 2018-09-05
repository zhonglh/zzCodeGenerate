package com.zz.bsmcc.core;

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
    private static ThreadLocal<List<String>> tables = new ThreadLocal<List<String>>();

    /**
     * 所有表名称
     */
    private static ThreadLocal<Map<String,List<String>>> tablesMap = new ThreadLocal<Map<String,List<String>>>();


    public static void setTables(List<String> ts) {
        tables.set(ts);
    }


    public static List<String> getTables() {
        return tables.get();
    }



    public static void setTablesMap(Map<String,List<String>> tsMap) {
        tablesMap.set(tsMap);
    }


    public static Map<String,List<String>> getTablesMap() {
        return tablesMap.get();
    }



}
