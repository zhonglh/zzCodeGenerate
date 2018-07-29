package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 扩展列设置实体类
 *
 * @author Administrator
 * @date 2018-7-29 1:16:11
 */
public class TcgExColumnEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="Java类名",sort=2  , attrLength=100    )
	private String javaSimpleClass;





    //@EntityAttrAnnotation(attrName="Java类全名",sort=3  , attrLength=200    )
	private String javaFullClass;





    //@EntityAttrAnnotation(attrName="Java 属性名",sort=4  , attrLength=100    )
	private String javaName;





    //@EntityAttrAnnotation(attrName="列标题",sort=5  , attrLength=100    )
	private String columnTitle;





    //@EntityAttrAnnotation(attrName="组名称",sort=6  , attrLength=50    )
	//一般相同的数据项用相同的组名 ， 比如在项目表中， 客户名称，客户编号， 客户电话 ，客户ID等  
	private String groupCode;





    //@EntityAttrAnnotation(attrName="字典类型",sort=7  , attrLength=50    )
	private String dictType;







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
	 * Java类名
	 * @return the javaSimpleClass
	 */
	public String getJavaSimpleClass() {
		return javaSimpleClass;
	}
	
	/** 
	 * Java类名
	 */
	public void setJavaSimpleClass(String javaSimpleClass) {
		this.javaSimpleClass = javaSimpleClass;
	}
	/** 
	 * Java类全名
	 * @return the javaFullClass
	 */
	public String getJavaFullClass() {
		return javaFullClass;
	}
	
	/** 
	 * Java类全名
	 */
	public void setJavaFullClass(String javaFullClass) {
		this.javaFullClass = javaFullClass;
	}
	/** 
	 * Java 属性名
	 * @return the javaName
	 */
	public String getJavaName() {
		return javaName;
	}
	
	/** 
	 * Java 属性名
	 */
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}
	/** 
	 * 列标题
	 * @return the columnTitle
	 */
	public String getColumnTitle() {
		return columnTitle;
	}
	
	/** 
	 * 列标题
	 */
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	/** 
	 * 组名称
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}
	
	/** 
	 * 组名称
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	/** 
	 * 字典类型
	 * @return the dictType
	 */
	public String getDictType() {
		return dictType;
	}
	
	/** 
	 * 字典类型
	 */
	public void setDictType(String dictType) {
		this.dictType = dictType;
	}
	
}