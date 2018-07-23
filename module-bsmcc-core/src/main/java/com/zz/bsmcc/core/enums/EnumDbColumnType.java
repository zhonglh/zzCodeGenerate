package com.zz.bsmcc.core.enums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库列类型
 * @author Administrator
 */
public enum EnumDbColumnType implements EnumBase{
	
	TINYINT,
	SMALLINT,
	SHORT,
	INT,
	INTEGER,
	LONG,
	FLOAT,
	DOUBLE,
	NUMBER,
	NUMERIC,
	DECIMAL,
	CHAR,
	VARCHAR,
	VARCHAR2,
	DATE,
	DATETIME,
	TIMESTAMP,
	CLOB,
	BLOB,
	
	;
	
	
	public static EnumDbColumnType getDbType(String dbtype){
		
		dbtype = dbtype.toUpperCase();


		for(EnumDbColumnType enumDbColumnType : EnumDbColumnType.values()){
			if(dbtype.toUpperCase().equals(enumDbColumnType.name())){
				return enumDbColumnType;
			}
		}



		return null;

		
		
	}


	@Override
	public Serializable getTheValue(){
		return this.name();
	}



	@Override
	public String getTheName(){
		return this.name();
	}


	/*
	public static EnumJavaType getJavaType(String dbtype, String precision, String scale ){
		EnumDbColumnType enumDbColumnType = getDbType(dbtype);
		if(enumDbColumnType == null) {
			return null;
		}
		return getJavaType(enumDbColumnType,precision,scale);
		
	}
	
	public static EnumJavaType getJavaType(EnumDbColumnType enumDbColumnType, String precision, String scale ){

		if(precision != null && precision.equals("null")) precision = null;
		if(scale != null && scale.equals("null")) scale = null;
		

		if(enumDbColumnType == TINYINT) return EnumJavaType._Byte;
		if(enumDbColumnType == SMALLINT) return EnumJavaType._Short;
		if(enumDbColumnType == SHORT) return EnumJavaType._Short;
		
		
		if(enumDbColumnType == CHAR) return EnumJavaType._String;
		if(enumDbColumnType == VARCHAR) return EnumJavaType._String;
		if(enumDbColumnType == VARCHAR2) return EnumJavaType._String;
		
		
		else if(enumDbColumnType == INTEGER) return EnumJavaType._Integer;
		else if(enumDbColumnType == LONG) return EnumJavaType._Long;
		else if(enumDbColumnType == DOUBLE) return EnumJavaType._Double;
		else if(enumDbColumnType == FLOAT) return EnumJavaType._Float;
		else if(enumDbColumnType == NUMBER) {
			
			if(StringUtils.isNotEmpty(scale) && Integer.parseInt(scale) > 0){
				return EnumJavaType._BigDecimal;
			}else if(StringUtils.isNotEmpty(precision) && Integer.parseInt(precision) > 10){
				return EnumJavaType._Long;
			}else{
				return EnumJavaType._Integer;
			}
		}
		else if(enumDbColumnType == NUMERIC) return EnumJavaType._BigDecimal;
		else if(enumDbColumnType == DECIMAL) return EnumJavaType._BigDecimal;

		else if(enumDbColumnType == DATE) return EnumJavaType._Date;
		else if(enumDbColumnType == DATETIME) return EnumJavaType._Date;
		else if(enumDbColumnType == TIMESTAMP) return EnumJavaType._Date;

		else if(enumDbColumnType == CLOB) return EnumJavaType._Clob;
		else if(enumDbColumnType == CLOB) return EnumJavaType._Bytes;
		
		else return null;
		
	}
	*/

	public static List<String> getAll(){	
		List<String> list = new ArrayList<String>();
		for(EnumDbColumnType enumDbColumnType : EnumDbColumnType.values() ){
			list.add(enumDbColumnType.name());
		}		
		return list;		
	}
	
	
	

}
