package com.zz.bsmcc.base.domain;



import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 列事件实体类
 *
 * @author Administrator
 * @date 2018-7-30 16:56:03
 */
public class TcgColumnEventEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="列",sort=2  , attrLength=32    )
	private String columnId;





    //@EntityAttrAnnotation(attrName="事件名称",sort=3  , attrLength=50    )
	private String eventName;



    //@EntityAttrAnnotation(attrName="函数名",sort=4  , attrLength=50    )
	private String funcName;




    //@EntityAttrAnnotation(attrName="函数体内容",sort=6  , attrLength=1000    )
	private String funcBody;







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
	 * 事件名称
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}
	
	/** 
	 * 事件名称
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	/** 
	 * 函数名
	 * @return the funcName
	 */
	public String getFuncName() {
		return funcName;
	}
	
	/** 
	 * 函数名
	 */
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	/** 
	 * 函数体内容
	 * @return the funcBody
	 */
	public String getFuncBody() {
		return funcBody;
	}
	
	/** 
	 * 函数体内容
	 */
	public void setFuncBody(String funcBody) {
		this.funcBody = funcBody;
	}
	
}