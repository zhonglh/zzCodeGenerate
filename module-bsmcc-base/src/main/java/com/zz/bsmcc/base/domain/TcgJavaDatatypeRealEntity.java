package com.zz.bsmcc.base.domain;



import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;

/**
 * 数据类型关联实体类
 *
 * @author Administrator
 * @date 2018-7-30 10:25:21
 */
public class TcgJavaDatatypeRealEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="Java数据类型",sort=1  , attrLength=50    )
	private String javaType;





    //@EntityAttrAnnotation(attrName="数据库数据类型",sort=2  , attrLength=50    )
	private String dataType;







	/** 
	 * Java数据类型
	 * @return the javaType
	 */
	public String getJavaType() {
		return javaType;
	}
	
	/** 
	 * Java数据类型
	 */
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	/** 
	 * 数据库数据类型
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}
	
	/** 
	 * 数据库数据类型
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
}