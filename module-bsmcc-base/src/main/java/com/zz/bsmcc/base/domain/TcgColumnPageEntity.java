package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;

import java.math.BigDecimal;

/**
 * 列界面设置实体类
 *
 * @author Administrator
 * @date 2018-7-30 16:56:02
 */
public class TcgColumnPageEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="是否真实列",sort=2  , attrLength=1    )
	//1: 数据库中的列  0: 扩展列  
	private String realColumn;





    //@EntityAttrAnnotation(attrName="是否可编辑",sort=3  , attrLength=1    )
	private String editable;





    //@EntityAttrAnnotation(attrName="是否隐藏",sort=4  , attrLength=1    )
	private String hiddenable;





    //@EntityAttrAnnotation(attrName="是否在界面里",sort=5  , attrLength=1    )
	private String existPage;





    //@EntityAttrAnnotation(attrName="界面元素",sort=6  , attrLength=50    )
	//参考EnumPageElement  
	private String element;





    //@EntityAttrAnnotation(attrName="最大长度",sort=7  , attrLength=0    )
	private Integer maxlength;





    //@EntityAttrAnnotation(attrName="最小长度",sort=8  , attrLength=0    )
	private Integer minlength;





    //@EntityAttrAnnotation(attrName="最大值",sort=9  , attrLength=0    )
	private BigDecimal max;





    //@EntityAttrAnnotation(attrName="最小值",sort=10  , attrLength=0    )
	private BigDecimal min;





    //@EntityAttrAnnotation(attrName="是否必填",sort=11  , attrLength=1    )
	private String required;





    //@EntityAttrAnnotation(attrName="是否列表中显示",sort=12  , attrLength=1    )
	private String listShowable;







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
	 * 是否真实列
	 * @return the realColumn
	 */
	public String getRealColumn() {
		return realColumn;
	}
	
	/** 
	 * 是否真实列
	 */
	public void setRealColumn(String realColumn) {
		this.realColumn = realColumn;
	}
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
	 * 是否隐藏
	 * @return the hiddenable
	 */
	public String getHiddenable() {
		return hiddenable;
	}
	
	/** 
	 * 是否隐藏
	 */
	public void setHiddenable(String hiddenable) {
		this.hiddenable = hiddenable;
	}
	/** 
	 * 是否在界面里
	 * @return the existPage
	 */
	public String getExistPage() {
		return existPage;
	}
	
	/** 
	 * 是否在界面里
	 */
	public void setExistPage(String existPage) {
		this.existPage = existPage;
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
	/** 
	 * 是否列表中显示
	 * @return the listShowable
	 */
	public String getListShowable() {
		return listShowable;
	}
	
	/** 
	 * 是否列表中显示
	 */
	public void setListShowable(String listShowable) {
		this.listShowable = listShowable;
	}
	
}