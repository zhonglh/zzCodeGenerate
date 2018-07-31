package com.zz.bsmcc.core.util.table.engine.impl;

import com.zz.bsmcc.core.util.table.engine.ReadDbProcess;
import com.zz.bsmcc.core.util.table.pojo.Column;
import com.zz.bsmcc.core.util.table.pojo.Table;

/**
 * MySQL 数据库读取器
 * @author Administrator
 */
public class MySqlReadDbProcess extends AbstractReadDbProcess implements ReadDbProcess {

    @Override
    protected String getReadAllTableSQL() {
        String sql =  "select table_name , table_schema , table_type , table_comment " +
                "from information_schema.tables " +
                "where table_schema not in ('information_schema','test' )";
        System.out.println("getReadAllTableSQL : "+sql);
        return sql;
    }

    @Override
    protected String getReadOneTableSQL(String tableSchema, String tableName) {
        String sql =  "select table_name , table_schema , table_type , table_comment " +
                "from information_schema.tables T " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " ;
        System.out.println("getReadOneTableSQL : "+sql);
        return sql;
    }

    @Override
    protected String getReadColumnsByTable(String tableSchema, String tableName) {
        String sql =  "SELECT column_name , column_comment , data_type , character_maximum_length , " +
                "numeric_precision , numeric_scale , is_nullable " +
                "from information_schema.COLUMNS T where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' ";
        System.out.println("getReadColumnsByTable : "+sql);
        return sql;
    }


    @Override
    protected String getReadIndexsByTable(String tableSchema, String tableName) {
        String sql =  " select constraint_name from information_schema.TABLE_CONSTRAINTS t " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " +
                "and CONSTRAINT_TYPE = 'UNIQUE'";
        System.out.println("getReadIndexsByTable : "+sql);
        return sql;
    }

    @Override
    protected String getReadIndexColumnsByTable(String tableSchema, String tableName, String indexName) {
        String sql =  " select column_name from information_schema.KEY_COLUMN_USAGE t " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " +
                "and CONSTRAINT_NAME = '"+indexName+"' " ;
        System.out.println("getReadIndexColumnsByTable : "+sql);
        return sql;
    }

    @Override
    protected String getReadConstraintsByTable(String tableSchema, String tableName) {
        String sql =   " select constraint_name from information_schema.TABLE_CONSTRAINTS t " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " +
                "and CONSTRAINT_TYPE = 'PRIMARY KEY'  and CONSTRAINT_NAME <> 'PRIMARY'";
        System.out.println("getReadConstraintsByTable : "+sql);
        return sql;
    }

    @Override
    protected String getReadConstraintColumnsByTable(String tableSchema, String tableName, String constraintName) {
        String sql =  " select column_name from information_schema.KEY_COLUMN_USAGE t " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " +
                "and CONSTRAINT_NAME = '"+constraintName+"' " ;
        System.out.println("getReadConstraintColumnsByTable : "+sql);
        return sql;

    }

    @Override
    protected boolean isTable(Table table) {
        return table.getTableType().indexOf("VIEW")!= -1 ? false : true;
    }


    @Override
    protected boolean isFixedChar(Column column) {
        return column.getDataType().equalsIgnoreCase("CHAR");
    }
}
