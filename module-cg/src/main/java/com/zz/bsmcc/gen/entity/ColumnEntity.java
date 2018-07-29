package com.zz.bsmcc.gen.entity;

import java.util.ArrayList;
import java.util.List;

public class ColumnEntity {
	/**
	 * 列名称,如 user_name
	 */
	private String columnName;

	/**
	 * 列对应属性名 , 如userName
	 */
	private String shortColumnName;

	/**
	 * 列类型
	 */
	private String columnType;

	/**
	 * 列对应的JAVA类型
	 */
	private String javaType;

	private String jdbcType;

	//列 检验类型, 目前使用的是jquery validate 的类型
	private String validate;


	//列长度
	private String columnPrecision;

	//列小数点精度
	private String columnScale;

	/**
	 * 列说明
	 */
	private String columnComments;

	/**
	 * 列说明补充
	 */
	private String columnOtherComments;

	/**
	 * 是否可以为空
	 */
	private String nullable;
	
	private Boolean isEnum;
	
	private String enumClassName;

	private String packageStr;

	private List<EnumEntity> enumList = new ArrayList<EnumEntity>();

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getShortColumnName() {
		return shortColumnName;
	}

	public void setShortColumnName(String shortColumnName) {
		this.shortColumnName = shortColumnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getColumnScale() {
		return columnScale;
	}

	public void setColumnScale(String columnScale) {
		this.columnScale = columnScale;
	}

	public String getColumnComments() {
		return columnComments;
	}

	public void setColumnComments(String columnComments) {
		this.columnComments = columnComments;
	}


	public Boolean getIsEnum() {
		return isEnum;
	}

	public void setIsEnum(Boolean isEnum) {
		this.isEnum = isEnum;
	}

	public List<EnumEntity> getEnumList() {
		return enumList;
	}

	public void setEnumList(List<EnumEntity> enumList) {
		this.enumList = enumList;
	}

	public String getColumnPrecision() {
		return columnPrecision;
	}

	public void setColumnPrecision(String columnPrecision) {
		this.columnPrecision = columnPrecision;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getEnumClassName() {
		return enumClassName;
	}

	public void setEnumClassName(String enumClassName) {
		this.enumClassName = enumClassName;
	}

	public String getPackageStr() {
		return packageStr;
	}

	public void setPackageStr(String packageStr) {
		this.packageStr = packageStr;
	}

	public String getColumnOtherComments() {
		return columnOtherComments;
	}

	public void setColumnOtherComments(String columnOtherComments) {
		this.columnOtherComments = columnOtherComments;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}
}
