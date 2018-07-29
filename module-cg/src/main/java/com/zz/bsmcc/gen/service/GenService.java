package com.zz.bsmcc.gen.service;


import com.zz.bms.util.base.data.StringUtil;
import com.zz.bsmcc.core.Applications;
import com.zz.bsmcc.gen.dao.GenDao;
import com.zz.bsmcc.gen.entity.ColumnEntity;
import com.zz.bsmcc.gen.entity.ConstraintEntity;
import com.zz.bsmcc.gen.entity.IndexEntity;
import com.zz.bsmcc.gen.entity.TableEntity;
import com.zz.bsmcc.utils.EntityUtils;
import com.zz.bsmcc.utils.JavaTypeUtils;
import com.zz.bsmcc.utils.Obj2StrUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zhangwenling
 * @date 201
 *
 */
public class GenService {

	private GenDao TableDao = new GenDao();
	
	public static final String basePackage= Applications.get("base.package") ;

	public void getTableComments(TableEntity tableEntity, String tableName, String schemeName) {
		List<Object> tableComments = TableDao.getTableComments(tableName,schemeName);
		tableEntity.setTableName(tableName);
		tableEntity.setShortTableName(EntityUtils.column2JavaProperty(tableName));
		tableEntity.setEntityName(EntityUtils.column2JavaProperty2(tableName));
		tableEntity.setSequence(Applications.get("base.sequence"));
		tableEntity.setBasePackage(basePackage);
		
		for (Object obj : tableComments) {
			Map<String, String> m = (Map<String, String>) obj;
			String tableComment = m.get("TABLE_COMMENT").toString();
			if(tableComment != null && !tableComment.isEmpty()) {
				String comment[] = tableComment.split("\r\n");
				tableComment = comment[0];
			}
			tableEntity.setTableComments((tableComment==null?"":tableComment.trim()));
		}

		if(tableEntity.getTableComments() == null || tableEntity.getTableComments().isEmpty()) {
			tableEntity.setTableComments("");
		}
	}

	public void getTableColumnsMeta(TableEntity tableEntity, String tableName, String schemeName) {
		List<Object> tableColumnsMeta = TableDao.getTableColumnsMeta(tableName,schemeName);
		
		List<ColumnEntity> columnList = new ArrayList<ColumnEntity>();

		for (Object obj : tableColumnsMeta) {
			// [{DATA_PRECISION=12, COLUMN_NAME=ID, DATA_LENGTH=22, TABLE_COMMENT=主键, DATA_SCALE=0, NULLABLE=N, DATA_TYPE=NUMBER}
			Map<String, String> m = (Map<String, String>) obj;
			ColumnEntity columnEntity = new ColumnEntity();
			columnEntity.setColumnName(Obj2StrUtils.objToString(m.get("COLUMN_NAME")));
			columnEntity.setColumnName(columnEntity.getColumnName().toLowerCase());
			columnEntity.setShortColumnName(EntityUtils.column2JavaProperty(columnEntity.getColumnName()));
			//columnEntity.setShortColumnName((columnEntity.getColumnName()));

			String comments = Obj2StrUtils.objToString(m.get("COLUMN_COMMENT"));
			String otherComments = "";
			if(comments != null){
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
			columnEntity.setColumnComments(comments);
			columnEntity.setColumnOtherComments(otherComments);


			Boolean isEnum = comments.contains("@") ? true : false;
			if (Obj2StrUtils.objToString(m.get("CHARACTER_MAXIMUM_LENGTH")).equals("1") && isEnum){

				columnEntity.setIsEnum(true);
				columnEntity.setEnumList(EntityUtils.comments2Enum(tableEntity, columnEntity, columnEntity.getColumnComments()));
			}else {
				columnEntity.setIsEnum(false);
			}
			if(isEnum){
				columnEntity.setColumnComments(comments.split("@")[0]);
			}

			columnEntity.setColumnScale(Obj2StrUtils.objToString(m.get("DATA_SCALE")));
			columnEntity.setColumnPrecision(Obj2StrUtils.objToString(m.get("CHARACTER_MAXIMUM_LENGTH")));
			if(StringUtil.isEmpty(columnEntity.getColumnPrecision())){
				columnEntity.setColumnPrecision(Obj2StrUtils.objToString(m.get("DATA_PRECISION")));
			}
			if(StringUtils.isEmpty(columnEntity.getColumnPrecision())){
				columnEntity.setColumnPrecision("0");
			}
			if(StringUtils.isEmpty(columnEntity.getColumnScale())){
				columnEntity.setColumnScale("0");
			}

			columnEntity.setColumnType(Obj2StrUtils.objToString(m.get("DATA_TYPE")));

			columnEntity.setNullable(Obj2StrUtils.objToString(m.get("IS_NULLABLE")));

			columnEntity.setJavaType(JavaTypeUtils.getJavaType(tableEntity, columnEntity, columnEntity.getColumnType()));
			columnList.add(columnEntity);
		}
		tableEntity.setColumnList(columnList );
	}



	public void getTableOther(TableEntity tableEntity, String tableName, String schemeName) {
		List<IndexEntity> indexs = TableDao.getTableIndex(tableName,schemeName);
		List<ConstraintEntity> constraints = TableDao.getTableConstraint(tableName,schemeName);
		tableEntity.setIndexList(indexs);
		tableEntity.setConstraintList(constraints);
	}

	public static void main(String[] args) {
		GenService TableService = new GenService();
		TableEntity tableEntity = new TableEntity();
		String tableName = "t_u_user";
		TableService.getTableComments(tableEntity, tableName,"woodmall");
		TableService.getTableColumnsMeta(tableEntity, tableName,"woodmall");
		System.out.println(tableEntity.getTableComments());
	}

}
