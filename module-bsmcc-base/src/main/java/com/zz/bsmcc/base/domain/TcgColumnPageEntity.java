package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
 * 列界面设置实体类
 *
 * @author Administrator
 * @date 2018-7-24 10:20:08
 */
@EntityAnnotation(value="列界面设置" , resource = "")
@TableName(value="tcg_column_page" , resultMap = "TcgColumnPageResultMap")
public class TcgColumnPageEntity extends BaseBusinessEntity<String> implements java.io.Serializable{
	private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="是否可编辑",sort=1  , attrLength=1    )
	private String editable;





    //@EntityAttrAnnotation(attrName="界面元素",sort=2  , attrLength=50    )
	//参考EnumPageElement  
	private String element;





    //@EntityAttrAnnotation(attrName="最大长度",sort=3  , attrLength=0    )
	private Integer maxlength;





    //@EntityAttrAnnotation(attrName="最小长度",sort=4  , attrLength=0    )
	private Integer minlength;





    //@EntityAttrAnnotation(attrName="最大值",sort=5  , attrLength=0    )
	private BigDecimal max;





    //@EntityAttrAnnotation(attrName="最小值",sort=6  , attrLength=0    )
	private BigDecimal min;





    //@EntityAttrAnnotation(attrName="是否必填",sort=7  , attrLength=1    )
	private String required;







	/** 
	 * 是否可编辑
	 * @return the editable
	 */
	public String getEditable() {
		return editable;
	}
	
	/** 
	 * 是否可编辑
	 */
	public void setEditable(String editable) {
		this.editable = editable;
	}
	/** 
	 * 界面元素
	 * @return the element
	 */
	public String getElement() {
		return element;
	}
	
	/** 
	 * 界面元素
	 */
	public void setElement(String element) {
		this.element = element;
	}
	/** 
	 * 最大长度
	 * @return the maxlength
	 */
	public Integer getMaxlength() {
		return maxlength;
	}
	
	/** 
	 * 最大长度
	 */
	public void setMaxlength(Integer maxlength) {
		this.maxlength = maxlength;
	}
	/** 
	 * 最小长度
	 * @return the minlength
	 */
	public Integer getMinlength() {
		return minlength;
	}
	
	/** 
	 * 最小长度
	 */
	public void setMinlength(Integer minlength) {
		this.minlength = minlength;
	}
	/** 
	 * 最大值
	 * @return the max
	 */
	public BigDecimal getMax() {
		return max;
	}
	
	/** 
	 * 最大值
	 */
	public void setMax(BigDecimal max) {
		this.max = max;
	}
	/** 
	 * 最小值
	 * @return the min
	 */
	public BigDecimal getMin() {
		return min;
	}
	
	/** 
	 * 最小值
	 */
	public void setMin(BigDecimal min) {
		this.min = min;
	}
	/** 
	 * 是否必填
	 * @return the required
	 */
	public String getRequired() {
		return required;
	}
	
	/** 
	 * 是否必填
	 */
	public void setRequired(String required) {
		this.required = required;
	}
	
}