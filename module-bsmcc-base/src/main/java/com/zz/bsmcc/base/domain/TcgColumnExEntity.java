package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;

/**
 * 列扩展实体类
 *
 * @author Administrator
 * @date 2018-7-29 1:16:09
 */
public class TcgColumnExEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="列",sort=1  , attrLength=32    )
	private String columnId;





    //@EntityAttrAnnotation(attrName="扩展Key",sort=2  , attrLength=50    )
	private String exKey;





    //@EntityAttrAnnotation(attrName="扩展Val",sort=3  , attrLength=500    )
	private String exVal;







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