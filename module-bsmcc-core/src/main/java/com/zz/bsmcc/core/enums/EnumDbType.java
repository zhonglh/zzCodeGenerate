package com.zz.bsmcc.core.enums;

import com.zz.bms.core.enums.EnumBase;
import com.zz.bms.core.exceptions.InternalException;

import java.io.Serializable;

/**
 * 数据库类型
 * @author Administrator
 */

public enum EnumDbType implements EnumBase<String>{
	
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



	@Override
	public String getVal(){
		return name();
	}

	@Override
	public String getLabel(){
		return driver;
	}


	@Override
	public String getValue(){
		return name();
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



	@Override
	public EnumDbType getEnum(String v){
		return EnumDbType.getEnumDbType(v);
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

	

}
