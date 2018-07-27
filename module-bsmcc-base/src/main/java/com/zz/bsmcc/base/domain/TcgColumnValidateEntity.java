package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
 * 列校验实体类
 *
 * @author Administrator
 * @date 2018-7-24 14:42:50
 */
public class TcgColumnValidateEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{






    //@EntityAttrAnnotation(attrName="列",sort=1  , attrLength=32    )
	private String columnId;





    //@EntityAttrAnnotation(attrName="表达式",sort=2  , attrLength=200    )
	private String rex;





    //@EntityAttrAnnotation(attrName="错误消息",sort=3  , attrLength=200    )
	private String msg;







	/** 
	 * 列
	 * @return the columnId
	 */
	public String getColumnId() {
		return columnId;
	}
	
	/** 
	 * 列
	 */
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	/** 
	 * 表达式
	 * @return the rex
	 */
	public String getRex() {
		return rex;
	}
	
	/** 
	 * 表达式
	 */
	public void setRex(String rex) {
		this.rex = rex;
	}
	/** 
	 * 错误消息
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	
	/** 
	 * 错误消息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}