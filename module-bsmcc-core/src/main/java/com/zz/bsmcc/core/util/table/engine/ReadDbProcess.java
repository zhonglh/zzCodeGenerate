package com.zz.bsmcc.core.util.table.engine;

import com.zz.bsmcc.core.util.table.pojo.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 数据库信息读取器
 * @author Administrator
 */
public interface ReadDbProcess {

    /**
     * 读取数据库中所有的表(视图)名称
     * @param dbContig
     * @return
     * @throws SQLException
     */
    public List<Table> readAllTable(DbConfig dbContig) throws SQLException ;

    /**
     * 获取所有的列信息
     * @param dbContig
     * @param tableSchema
     * @param tableName
     * @return
     * @throws SQLException
     */
    public List<Columnt> readColumnsByTable(DbConfig dbContig ,String tableSchema ,String tableName) throws SQLException ;

    /**
     * 获取所有的唯一索引信息
     * @param dbContig
     * @param tableSchema
     * @param tableName
     * @return
     * @throws SQLException
     */
    public List<Index> readIndexsByTable(DbConfig dbContig , String tableSchema , String tableName) throws SQLException ;


    /**
     * 获取所有的约束信息
     * @param dbContig
     * @param tableSchema
     * @param tableName
     * @return
     * @throws SQLException
     */
    public List<Constraint> readConstraintsByTable(DbConfig dbContig , String tableSchema , String tableName) throws SQLException ;




}
