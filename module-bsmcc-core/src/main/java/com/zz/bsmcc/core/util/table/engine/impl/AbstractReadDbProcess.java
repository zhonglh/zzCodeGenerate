
package com.zz.bsmcc.core.util.table.engine.impl;

import com.zz.bsmcc.core.enums.EnumDbType;
import com.zz.bsmcc.core.util.table.engine.ReadDbProcess;
import com.zz.bsmcc.core.util.table.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库处理的基础类
 * @author Administrator
 */
public abstract class AbstractReadDbProcess implements ReadDbProcess {

	private static final long serialVersionUID = -5324160085184089110L;

	private final Log log = LogFactory.getLog(this.getClass());


	@Override
	public List<Table> readAllTable(DbConfig dbContig) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Table> list = new ArrayList<Table>();
		try {
			Class.forName(EnumDbType.getDriver(dbContig.getDbType()));
			conn = DriverManager.getConnection(dbContig.getDbUrl(), dbContig.getDbUsername(), dbContig.getDbPassword());
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


			rs = stmt.executeQuery(getReadAllTableSQL());

			while (rs.next()) {
				Table table = new Table();
				String tableName = rs.getString(1);
				String tableSchema = rs.getString(2);
				String tableType = rs.getString(3);
				String tableComment = rs.getString(4);
				table.setTableName(tableName);
				table.setTableSchema(tableSchema);
				table.setTableType(tableType);
				table.setTableComment(tableComment);
				table.setId(tableSchema+":"+tableName);
				table.setTable(this.isTable(table));
				list.add(table);
			}
			stmt.close(); stmt = null;
			conn.close(); conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}

				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				throw e;
			}

		}

		return list;
	}



	@Override
	public Table readOneTable(DbConfig dbContig, String tableSchema , String tableName) throws SQLException{

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;


		Table table = new Table();
		try {
			Class.forName(EnumDbType.getDriver(dbContig.getDbType()));
			conn = DriverManager.getConnection(dbContig.getDbUrl(), dbContig.getDbUsername(), dbContig.getDbPassword());
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


			rs = stmt.executeQuery(getReadOneTableSQL(tableSchema , tableName));

			while (rs.next()) {
				String tableType = rs.getString(3);
				String tableComment = rs.getString(4);
				table.setTableName(tableName);
				table.setTableSchema(tableSchema);
				table.setTableType(tableType);
				table.setTableComment(tableComment);
				table.setId(tableSchema+":"+tableName);
				table.setTable(this.isTable(table));
				break;
			}
			stmt.close(); stmt = null;
			conn.close(); conn = null;
			return table;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}

				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				throw e;
			}

		}

		return null;

	}

	@Override
	public List<Column> readColumnsByTable(DbConfig dbContig, String tableSchema, String tableName) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Column> list = new ArrayList<Column>();
		try {
			Class.forName(EnumDbType.getDriver(dbContig.getDbType()));
			conn = DriverManager.getConnection(dbContig.getDbUrl(), dbContig.getDbUsername(), dbContig.getDbPassword());
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


			rs = stmt.executeQuery(getReadColumnsByTable(tableSchema ,tableName));

			while (rs.next()) {
				Column column = new Column();

				String filedName = rs.getString(1);
				String filedComment = rs.getString(2);
				String otherFiledComment = null;
				if(StringUtils.isNotEmpty(filedComment)) {
					StringBuilder commentSb = new StringBuilder(filedComment);
					StringBuilder otherCommentSb = new StringBuilder();
					processColumnCommon(commentSb, otherCommentSb);
					filedComment = commentSb.toString();
					if(otherCommentSb != null && otherCommentSb.length() >0) {
						otherFiledComment = otherCommentSb.toString();
					}
				}

				String dataType = rs.getString(3);
				Integer charmaxLength = rs.getInt(4);
				Integer precision = rs.getInt(5);
				Integer scale = rs.getInt(6);
				String nullable = rs.getString(7);

				column.setColumnName(filedName);
				column.setColumnComment(filedComment);
				column.setColumnOtherComments(otherFiledComment);
				column.setDataType(dataType);
				column.setCharmaxLength(charmaxLength);
				column.setPrecision(precision);
				column.setScale(scale);
				column.setNullable("YES".equals(nullable)?true : false);
				column.setFixedChar(this.isFixedChar(column));
				list.add(column);
			}
			stmt.close(); stmt = null;
			conn.close(); conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}

				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				throw e;
			}

		}
		return list;
	}

	@Override
	public List<Index> readIndexsByTable(DbConfig dbContig, String tableSchema, String tableName) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Index> list = new ArrayList<Index>();
		try {
			Class.forName(EnumDbType.getDriver(dbContig.getDbType()));
			conn = DriverManager.getConnection(dbContig.getDbUrl(), dbContig.getDbUsername(), dbContig.getDbPassword());
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


			rs = stmt.executeQuery(getReadIndexsByTable(tableSchema ,tableName));

			while (rs.next()) {
				Index index = new Index();
				index.setIndexName(rs.getString(1));
				list.add(index);
			}

			for(Index index : list){
				rs = stmt.executeQuery(getReadIndexColumnsByTable(tableSchema ,tableName , index.getIndexName()));
				index.setColumnNames(new ArrayList<String>());
				while (rs.next()) {
					index.getColumnNames().add(rs.getString(1));
				}
			}

			stmt.close(); stmt = null;
			conn.close(); conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}

				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				throw e;
			}

		}
		return list;
	}

	@Override
	public List<Constraint> readConstraintsByTable(DbConfig dbContig, String tableSchema, String tableName) throws SQLException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		List<Constraint> list = new ArrayList<Constraint>();
		try {
			Class.forName(EnumDbType.getDriver(dbContig.getDbType()));
			conn = DriverManager.getConnection(dbContig.getDbUrl(), dbContig.getDbUsername(), dbContig.getDbPassword());
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


			rs = stmt.executeQuery(getReadConstraintsByTable(tableSchema ,tableName));

			while (rs.next()) {
				Constraint constraint = new Constraint();
				constraint.setIndexName(rs.getString(1));
				list.add(constraint);
			}

			for(Constraint constraint : list){
				rs = stmt.executeQuery(getReadConstraintColumnsByTable(tableSchema ,tableName , constraint.getIndexName()));
				constraint.setColumnNames(new ArrayList<String>());
				while (rs.next()) {
					constraint.getColumnNames().add(rs.getString(1));
				}
			}

			stmt.close(); stmt = null;
			conn.close(); conn = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}

				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				throw e;
			}

		}
		return list;
	}



	private void processColumnCommon(StringBuilder commentsSb ,StringBuilder otherCommentsSb  ){

		String comments = commentsSb.toString();
		String otherComments = "";
		if(comments != null && !comments.isEmpty()){
			String c[] = comments.split("\r\n");
			comments = c[0].trim();
			if(c.length > 1){
				for(int i=1;i<c.length;i++){
					otherComments += c[i].trim()+"  ";
				}
			}
		}else {
			comments = "";
		}
		commentsSb = new StringBuilder(comments);
		otherCommentsSb = new StringBuilder(otherComments);
	}

	/**
	 * 判断是表格还是视图
	 * @return
	 */
	protected abstract boolean isTable(Table table);


	/**
	 * 获取所有表(视图)的SQL
	 * @return
	 */
	protected abstract String getReadAllTableSQL() ;


	/**
	 * 获取单个表(视图)的SQL
	 * @return
	 */
	protected abstract String getReadOneTableSQL(String tableSchema, String tableName) ;

	/**
	 * 获取指定表(视图)所有列的SQL
	 * @param tableSchema
	 * @param tableName
	 * @return
	 */
	protected abstract String getReadColumnsByTable(String tableSchema, String tableName) ;


	/**
	 * 获取指定表(视图)所有的索引SQL
	 * @param tableSchema
	 * @param tableName
	 * @return
	 */
	protected abstract String getReadIndexsByTable(String tableSchema, String tableName) ;


	/**
	 * 获取指定索引的所有列的SQL
	 * @param tableSchema
	 * @param tableName
	 * @return
	 */
	protected abstract String getReadIndexColumnsByTable(String tableSchema, String tableName , String indexName) ;



	/**
	 * 获取指定表(视图)所有的约束SQL
	 * @param tableSchema
	 * @param tableName
	 * @return
	 */
	protected abstract String getReadConstraintsByTable(String tableSchema, String tableName) ;


	/**
	 * 获取指定约束的所有列的SQL
	 * @param tableSchema
	 * @param tableName
	 * @return
	 */
	protected abstract String getReadConstraintColumnsByTable(String tableSchema, String tableName , String constraintName) ;


	/**
	 * 是否为固定长度的字符
	 * @param column
	 * @return
	 */
	protected abstract boolean isFixedChar(Column column) ;


}
