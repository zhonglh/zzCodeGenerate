package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 连接池设置实体类
 *
 * @author Administrator
 * @date 2018-7-29 1:16:11
 */
public class TcgDbConfigEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="数据库类型",sort=1  , attrLength=20    )
	private String dbType;





    //@EntityAttrAnnotation(attrName="数据库地址",sort=2  , attrLength=200    )
	private String dbUrl;





    //@EntityAttrAnnotation(attrName="用户名",sort=3  , attrLength=50    )
	private String dbUsername;





    //@EntityAttrAnnotation(attrName="密码",sort=4  , attrLength=50    )
	private String dbPassword;





    //@EntityAttrAnnotation(attrName="标题",sort=5  , attrLength=100    )
	private String title;







	/** 
	 * 数据库类型
	 * @return the dbType
	 */
	public String getDbType() {
		return dbType;
	}
	
	/** 
	 * 数据库类型
	 */
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	/** 
	 * 数据库地址
	 * @return the dbUrl
	 */
	public String getDbUrl() {
		return dbUrl;
	}
	
	/** 
	 * 数据库地址
	 */
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	/** 
	 * 用户名
	 * @return the dbUsername
	 */
	public String getDbUsername() {
		return dbUsername;
	}
	
	/** 
	 * 用户名
	 */
	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}
	/** 
	 * 密码
	 * @return the dbPassword
	 */
	public String getDbPassword() {
		return dbPassword;
	}
	
	/** 
	 * 密码
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	/** 
	 * 标题
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/** 
	 * 标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
}