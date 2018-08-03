package com.zz.bsmcc.core.enums;

import com.zz.bms.core.enums.EnumBase;
import com.zz.bms.core.exceptions.InternalException;

import java.io.Serializable;

/**
 * 数据库类型
 * @author Administrator
 */

public enum EnumDbType implements EnumBase{
	
	mysql("com.mysql.jdbc.Driver"),
	oracle("oracle.jdbc.driver.OracleDriver"),
	db2("com.ibm.db2.jcc.DB2Driver"),
	/*
	sqlserver("com.microsoft.jdbc.sqlserver.SQLServerDriver"),
	postgre("org.postgresql.Driver"),
	*/
	;
	
	
	String driver;

	private EnumDbType(String driver) {
		this.driver = driver;
	}
	
	
	
	public static String getDriver(String type){
		String dbtype = type.toLowerCase();
		for(EnumDbType enumDiver : EnumDbType.values()){
			if(enumDiver.name() .equals(dbtype)){
				return enumDiver.driver;
			}
		}
		throw new InternalException("数据库类型错误");
	}



	public static EnumDbType getEnumDbType(String type){
		type = type.toLowerCase();
		for(EnumDbType enumDiver : EnumDbType.values()){
			if(enumDiver.name() .equals(type)){
				return enumDiver;
			}
		}
		throw new InternalException("数据库类型错误");
	}


	@Override
	public Serializable getTheValue(){
		return this.name();
	}



	@Override
	public String getTheName(){
		return this.driver;
	}
	

}
