package com.zz.bsmcc.core.util.table.pojo;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class DbConfig implements Serializable{

	public String dbType;
	public String dbUrl;
	public String dbUsername;
	public String dbPassword;

	public DbConfig(String dbType, String dbUrl, String dbUsername, String dbPassword) {
		this.dbType = dbType;
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
}
