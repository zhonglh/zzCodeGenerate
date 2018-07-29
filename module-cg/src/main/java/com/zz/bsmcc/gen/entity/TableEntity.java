package com.zz.bsmcc.gen.entity;

import java.util.ArrayList;
import java.util.List;

public class TableEntity {

	/**
	 * 表名称 , 如ts_user
	 */
	private String tableName;

	/**
	 * 表名称对应的JAVA名称， 如tsUser
	 */
	private String shortTableName;


	/**
	 * 表名称对应实体名称， 将第一个 "_" 及前面的都删除, 并且将每个单词的第一个字母大写
	 * 如表名称为 tr_user_baseinfo   ,  转换为 UserBaseinfo
	 */
	private String entityName;


	/**
	 * 表说明
	 */
	private String tableComments;
	
	private String sequence;

	/**
	 * 对应的包
	 */
	private String basePackage;

	/**
	 * 对应的具体的包
	 */
	private String subPackage;
	
	private String author;

	private String isSlimple = "YES";
	
	private List<String> importEntity = new ArrayList<String>();

	//列集合
	private List<ColumnEntity> columnList = new ArrayList<ColumnEntity>();

	//索引集合
	private List<IndexEntity> indexList = new ArrayList<IndexEntity>();

	//约束集合
	private List<ConstraintEntity> constraintList = new ArrayList<ConstraintEntity>();






	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getShortTableName() {
		return shortTableName;
	}

	public void setShortTableName(String shortTableName) {
		this.shortTableName = shortTableName;
	}

	public List<ColumnEntity> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<ColumnEntity> columnList) {
		this.columnList = columnList;
	}

	public String getTableComments() {
		return tableComments;
	}

	public void setTableComments(String tableComments) {
		this.tableComments = tableComments;
	}

	public List<String> getImportEntity() {
		return importEntity;
	}

	public void setImportEntity(List<String> importEntity) {
		this.importEntity = importEntity;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubPackage() {
		return subPackage;
	}

	public void setSubPackage(String subPackage) {
		this.subPackage = subPackage;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getIsSlimple() {
		return isSlimple;
	}

	public void setIsSlimple(String isSlimple) {
		this.isSlimple = isSlimple;
	}

	public List<IndexEntity> getIndexList() {
		return indexList;
	}

	public void setIndexList(List<IndexEntity> indexList) {
		this.indexList = indexList;
	}

	public List<ConstraintEntity> getConstraintList() {
		return constraintList;
	}

	public void setConstraintList(List<ConstraintEntity> constraintList) {
		this.constraintList = constraintList;
	}
}
