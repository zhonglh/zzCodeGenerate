package com.zz.bsmcc.core.util.table.engine.impl;

import com.zz.bsmcc.core.util.table.engine.ReadDbProcess;
import com.zz.bsmcc.core.util.table.pojo.Column;
import com.zz.bsmcc.core.util.table.pojo.Table;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * MySQL 数据库读取器
 * @author Administrator
 */
public class MySqlReadDbProcess extends AbstractReadDbProcess implements ReadDbProcess {

    public Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected String getReadAllTableSQL(String tableSchema) {
        String sql =  "select table_name , table_schema , table_type , table_comment " +
                "from information_schema.tables " +
                "where table_schema not in ('information_schema','test' ) " +
                "order by table_schema , table_name";

        if(StringUtils.isNotEmpty(tableSchema)){
            sql =  "select table_name , table_schema , table_type , table_comment " +
                    "from information_schema.tables " +
                    "where table_schema = '"+tableSchema+"'" +
                    "order by table_name";
        }
        logger.debug("getReadAllTableSQL : "+sql);
        return sql;
    }

    @Override
    protected String getReadOneTableSQL(String tableSchema, String tableName) {
        String sql =  "select table_name , table_schema , table_type , table_comment " +
                "from information_schema.tables T " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " ;
        logger.debug("getReadOneTableSQL : "+sql);
        return sql;
    }

    @Override
    protected String getReadColumnsByTable(String tableSchema, String tableName) {
        String sql =  "SELECT column_name , column_comment  , data_type , character_maximum_length , " +
                "numeric_precision , numeric_scale , is_nullable ,column_default " +
                "from information_schema.COLUMNS T where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' ";
        logger.debug("getReadColumnsByTable : "+sql);
        return sql;
    }


    @Override
    protected String getReadIndexsByTable(String tableSchema, String tableName) {
        String sql =  " select constraint_name from information_schema.TABLE_CONSTRAINTS t " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " +
                "and CONSTRAINT_TYPE = 'UNIQUE'";
        logger.debug("getReadIndexsByTable : "+sql);
        return sql;
    }

    @Override
    protected String getReadIndexColumnsByTable(String tableSchema, String tableName, String indexName) {
        String sql =  " select column_name from information_schema.KEY_COLUMN_USAGE t " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " +
                "and CONSTRAINT_NAME = '"+indexName+"' " ;
        logger.debug("getReadIndexColumnsByTable : "+sql);
        return sql;
    }

    @Override
    protected String getReadConstraintsByTable(String tableSchema, String tableName) {
        String sql =   " select constraint_name from information_schema.TABLE_CONSTRAINTS t " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " +
                "and CONSTRAINT_TYPE = 'PRIMARY KEY'  and CONSTRAINT_NAME <> 'PRIMARY'";
        logger.debug("getReadConstraintsByTable : "+sql);
        return sql;
    }

    @Override
    protected String getReadConstraintColumnsByTable(String tableSchema, String tableName, String constraintName) {
        String sql =  " select column_name from information_schema.KEY_COLUMN_USAGE t " +
                "where T.TABLE_NAME  = '"+tableName+"' and T.TABLE_SCHEMA='"+tableSchema+"' " +
                "and CONSTRAINT_NAME = '"+constraintName+"' " ;
        logger.debug("getReadConstraintColumnsByTable : "+sql);
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
