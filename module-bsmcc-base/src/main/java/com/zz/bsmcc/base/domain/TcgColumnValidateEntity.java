package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
 * 列校验实体类
 *
 * @author Administrator
 * @date 2018-7-30 16:56:03
 */
public class TcgColumnValidateEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="列",sort=2  , attrLength=32    )
	private String columnId;





    //@EntityAttrAnnotation(attrName="表达式",sort=3  , attrLength=200    )
	private String rex;





    //@EntityAttrAnnotation(attrName="错误消息",sort=4  , attrLength=200    )
	private String msg;







	/** 
	 * 
	 * @return the tableId
	 */
	public String getTableId() {
		return tableId;
	}
	
	/** 
	 * 
	 */
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
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