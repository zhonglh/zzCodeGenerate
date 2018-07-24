package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
 * 列扩展实体类
 *
 * @author Administrator
 * @date 2018-7-24 10:20:07
 */
@EntityAnnotation(value="列扩展" , resource = "")
@TableName(value="tcg_column_ex" , resultMap = "TcgColumnExResultMap")
public class TcgColumnExEntity extends BaseBusinessEntity<String> implements java.io.Serializable{
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