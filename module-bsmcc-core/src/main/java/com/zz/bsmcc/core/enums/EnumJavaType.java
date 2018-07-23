package com.zz.bsmcc.core.enums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Java 类型
 * @author Administrator
 */

public enum EnumJavaType implements EnumBase{

	_Short("java.lang.Short")	,
	_Integer("java.lang.Integer"),
	_Long("java.lang.Long"),
	_Float("java.lang.Float"),
	_Double("java.lang.Double"),
	_BigDecimal("java.math.BigDecimal"),
	
	_String("java.lang.String"),

	_Date("java.util.Date"),
	_Timestamp("java.sql.Timestamp"),

	_Clob("java.sql.Clob"),
	_Byte("java.lang.Byte"),
	_Bytes("byte[]")	
	
	;
	
	
	private String fullname;

	private EnumJavaType(String fullname) {
		
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public static EnumJavaType getEnumJavaType(String javaClass){
		for(EnumJavaType enumJavaType : EnumJavaType.values() ){
			if(enumJavaType.getFullname() .equals(javaClass)){
				return enumJavaType;
			}
		}		
		return null;		
	}


	@Override
	public Serializable getTheValue(){
		return this.name().substring(1);
	}



	@Override
	public String getTheName(){
		return this.fullname;
	}
	
	
	
	
	
	

}
