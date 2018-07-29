package com.zz.bsmcc.gen.dao;



import com.zz.bsmcc.core.ConnectionDB;
import com.zz.bsmcc.gen.entity.ConstraintEntity;
import com.zz.bsmcc.gen.entity.IndexEntity;
import com.zz.bsmcc.utils.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangwenling  
 */
public class GenDao {

	ConnectionDB connectionDB = new ConnectionDB();





	public List<IndexEntity> getTableIndex(String tableName, String schemeName) {
		List<IndexEntity> indexs = new ArrayList<IndexEntity>();
		String sql = " select * from information_schema.TABLE_CONSTRAINTS t " +
						"where t.TABLE_NAME=? and t.TABLE_SCHEMA=? and CONSTRAINT_TYPE = 'UNIQUE'";
		List<Object> list = connectionDB.excuteQuery(sql,  new Object[]{tableName.toLowerCase(),schemeName.toLowerCase()});
		if(list == null || list.size() == 0) {
			return indexs;
		}
		for(Object obj : list){
			Map<String, String> m = (Map<String, String>) obj;
			String indexName = m.get("CONSTRAINT_NAME").toString();
			String sql1 = " select * from information_schema.KEY_COLUMN_USAGE t " +
					"where t.TABLE_NAME=? and t.TABLE_SCHEMA=? and CONSTRAINT_NAME = ? ";

			List<Object> indexList = connectionDB.excuteQuery(sql1,  new Object[]{tableName.toLowerCase(),schemeName.toLowerCase(),indexName});
			if(indexList == null || indexList.isEmpty()) {
				continue;
			}
			List<String> columnNames = new ArrayList<String>();
			List<String> javaNames = new ArrayList<String>();
			for(Object obj1 : indexList){
				Map<String, String> m1 = (Map<String, String>) obj1;
				columnNames.add(m1.get("COLUMN_NAME").toString());
				javaNames.add(EntityUtils.column2JavaProperty(m1.get("COLUMN_NAME").toString()));
			}


			indexs.add(new IndexEntity(indexName,columnNames,javaNames));

		}
		return indexs;
	}





	public List<ConstraintEntity> getTableConstraint(String tableName, String schemeName) {
		List<ConstraintEntity> constraints = new ArrayList<ConstraintEntity>();
		String sql = " select * from information_schema.TABLE_CONSTRAINTS t " +
				"where t.TABLE_NAME=? and t.TABLE_SCHEMA=? " +
				"and CONSTRAINT_TYPE = 'PRIMARY KEY'  and CONSTRAINT_NAME <> 'PRIMARY'";
		List<Object> list = connectionDB.excuteQuery(sql,  new Object[]{tableName.toLowerCase(),schemeName.toLowerCase()});
		if(list == null || list.size() == 0) {
			return constraints;
		}

		for(Object obj : list){
			Map<String, String> m = (Map<String, String>) obj;
			String indexName = m.get("CONSTRAINT_NAME").toString();
			String sql1 = " select * from information_schema.KEY_COLUMN_USAGE t " +
					"where t.TABLE_NAME=? and t.TABLE_SCHEMA=? and CONSTRAINT_NAME = ? ";

			List<Object> indexList = connectionDB.excuteQuery(sql1,  new Object[]{tableName.toLowerCase(),schemeName.toLowerCase(),indexName});
			if(indexList == null || indexList.isEmpty()) {
				continue;
			}
			List<String> columnNames = new ArrayList<String>();
			List<String> javaNames = new ArrayList<String>();
			for(Object obj1 : indexList){
				Map<String, String> m1 = (Map<String, String>) obj1;
				columnNames.add(m1.get("COLUMN_NAME").toString());
				javaNames.add(EntityUtils.column2JavaProperty(m1.get("COLUMN_NAME").toString()));
			}
			constraints.add(new  ConstraintEntity(indexName,columnNames,javaNames));

		}
		return constraints;
	}



	public List<Object> getTableComments(String tableName, String schemeName) {
		String sql = " select * from information_schema.TABLES t where t.TABLE_NAME=? and t.TABLE_SCHEMA=?";
		List<Object> excuteQuery = connectionDB.excuteQuery(sql,  new Object[]{tableName.toLowerCase(),schemeName.toLowerCase()});
		if(excuteQuery == null || excuteQuery.isEmpty()){
			throw new RuntimeException(schemeName + "." + tableName + " not found , please view setting ");
		}
		return excuteQuery;
	}
	public List<Object> getTableColumnsMeta(String tableName, String schemeName) {
//		String sql = " SELECT COLS.COLUMN_NAME, COLS.DATA_TYPE, COMMENTS.COMMENTS, COLS.DATA_LENGTH, COLS.DATA_PRECISION, COLS.DATA_SCALE,COLS.NULLABLE " + " FROM COLUMNS COLS " + " LEFT JOIN USER_COL_COMMENTS COMMENTS "
//				+ " ON COLS.COLUMN_NAME = COMMENTS.COLUMN_NAME" + " WHERE COLS.TABLE_NAME = :tableName" + " AND COMMENTS.TABLE_NAME = :tableName" + " ORDER BY COLS.COLUMN_ID ";

		String sql = "SELECT T.* from information_schema.COLUMNS T where T.TABLE_NAME  = ? and T.TABLE_SCHEMA=?";
//		List<Object> excuteQuery = ConnectionDB.excuteQuery(sql,  tableName.toUpperCase(), tableName.toUpperCase());
		List<Object> excuteQuery = connectionDB.excuteQuery(sql,  new Object[]{tableName.toLowerCase(),schemeName.toLowerCase()});
		return excuteQuery;
	}
	
	public List<Object> getTableNameByTableName(String tableName, String schemeName) {
		String sql = "SELECT T.TABLE_NAME FROM information_schema.TABLES T WHERE T.TABLE_NAME =?";
		List<Object> excuteQuery = connectionDB.excuteQuery(sql,  new Object[]{tableName.toLowerCase(),schemeName.toLowerCase()});
		return excuteQuery;
	}

	public static void main(String[] args) {
		GenDao TableDao = new GenDao();
		String tableName = "t_u_user";
//		TableDao.getTableColumnsMeta(tableName);
//		TableDao.getTableComments(tableName);
		System.err.println(TableDao.getTableComments(tableName,"woodmall"));
	}

}
