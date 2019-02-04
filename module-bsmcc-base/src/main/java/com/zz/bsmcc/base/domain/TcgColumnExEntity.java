package com.zz.bsmcc.base.domain;



import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 列扩展实体类
 *
 * @author Administrator
 * @date 2018-7-30 16:56:04
 */
public class TcgColumnExEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="列",sort=2  , attrLength=32    )
	private String columnId;





    //@EntityAttrAnnotation(attrName="扩展Key",sort=3  , attrLength=50    )
	private String exKey;





    //@EntityAttrAnnotation(attrName="扩展Val",sort=4  , attrLength=500    )
	private String exVal;







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
	 * 扩展Key
	 * @return the exKey
	 */
	public String getExKey() {
		return exKey;
	}
	
	/** 
	 * 扩展Key
	 */
	public void setExKey(String exKey) {
		this.exKey = exKey;
	}
	/** 
	 * 扩展Val
	 * @return the exVal
	 */
	public String getExVal() {
		return exVal;
	}
	
	/** 
	 * 扩展Val
	 */
	public void setExVal(String exVal) {
		this.exVal = exVal;
	}
	
}