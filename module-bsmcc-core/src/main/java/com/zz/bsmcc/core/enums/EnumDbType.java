package com.zz.bsmcc.core.enums;

/**
 * @author Administrator
 */

public enum EnumDbType {
	
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
		return null;
	}
	

}
