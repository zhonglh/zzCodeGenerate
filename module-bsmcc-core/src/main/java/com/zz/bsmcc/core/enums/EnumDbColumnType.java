package com.zz.bsmcc.core.enums;


import com.zz.bms.core.enums.EnumBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库列类型
 * @author Administrator
 */
public enum EnumDbColumnType implements EnumBase{

	INT,
	INTEGER,
	BIGINT,
	LONG,
	FLOAT,
	DOUBLE,
	NUMBER,
	NUMERIC,
	DECIMAL,

	BOOL,



	CHAR,
	VARCHAR,
	VARCHAR2,
	LONGTEXT,

	DATE,
	DATETIME,
	TIMESTAMP,
	TINYINT,
	SMALLINT,
	SHORT,
	CLOB,
	BLOB,
	
	;
	
	
	public static EnumDbColumnType getDataType(String dataType){
		
		dataType = dataType.toUpperCase();


		for(EnumDbColumnType enumDbColumnType : EnumDbColumnType.values()){
			if(dataType.toUpperCase().equals(enumDbColumnType.name())){
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



	public static EnumJavaType getJavaType(String dataType, Integer precision, Integer scale ){
		EnumDbColumnType enumDbColumnType = getDataType(dataType);
		if(enumDbColumnType == null) {
			return null;
		}
		return getJavaType(enumDbColumnType,precision,scale);
		
	}
	
	public static EnumJavaType getJavaType(EnumDbColumnType enumDbColumnType, Integer precision, Integer scale ){

		if(precision != null && precision.equals("null")) {
			precision = null;
		}
		if(scale != null && scale.equals("null")) {
			scale = null;
		}
		

		if(enumDbColumnType == TINYINT) {
			return EnumJavaType._Byte;
		}
		if(enumDbColumnType == SMALLINT) {
			return EnumJavaType._Short;
		}
		if(enumDbColumnType == SHORT) {
			return EnumJavaType._Short;
		}
		
		
		if(enumDbColumnType == CHAR || enumDbColumnType == VARCHAR  || enumDbColumnType == VARCHAR2  || enumDbColumnType == LONGTEXT) {
			return EnumJavaType._String;
		}



		if(enumDbColumnType == BOOL) {
			return EnumJavaType._Boolean;
		}

		
		
		else if(enumDbColumnType == INTEGER || enumDbColumnType == INT) {
			return EnumJavaType._Integer;
		}
		else if(enumDbColumnType == LONG || enumDbColumnType == BIGINT) {
			return EnumJavaType._Long;
		}
		else if(enumDbColumnType == DOUBLE) {
			return EnumJavaType._Double;
		}
		else if(enumDbColumnType == FLOAT) {
			return EnumJavaType._Float;
		}
		else if(enumDbColumnType == NUMBER) {
			
			if(scale != null && scale > 0){
				return EnumJavaType._BigDecimal;
			}else if(precision != null && precision > 10){
				return EnumJavaType._Long;
			}else{
				return EnumJavaType._Integer;
			}
		}
		else if(enumDbColumnType == NUMERIC) {
			return EnumJavaType._BigDecimal;
		}
		else if(enumDbColumnType == DECIMAL) {
			return EnumJavaType._BigDecimal;
		}

		else if(enumDbColumnType == DATE) {
			return EnumJavaType._Date;
		}
		else if(enumDbColumnType == DATETIME) {
			return EnumJavaType._Date;
		}
		else if(enumDbColumnType == TIMESTAMP) {
			return EnumJavaType._Timestamp;
		}

		else if(enumDbColumnType == CLOB) {
			return EnumJavaType._Clob;
		}
		else if(enumDbColumnType == CLOB) {
			return EnumJavaType._Bytes;
		}
		
		else {
			return null;
		}
		
	}


	public static List<String> getAll(){	
		List<String> list = new ArrayList<String>();
		for(EnumDbColumnType enumDbColumnType : EnumDbColumnType.values() ){
			list.add(enumDbColumnType.name());
		}		
		return list;		
	}
	
	
	

}
