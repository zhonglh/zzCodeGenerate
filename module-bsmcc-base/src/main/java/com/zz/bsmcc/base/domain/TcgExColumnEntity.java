package com.zz.bsmcc.base.domain;



import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 扩展列设置实体类
 *
 * @author Administrator
 * @date 2018-8-1 17:35:08
 */
public class TcgExColumnEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="原始列的ID",sort=2  , attrLength=32    )
	private String originalColumnId;







    //@EntityAttrAnnotation(attrName="Java类名",sort=6  , attrLength=100    )
	private String javaSimpleClass;





    //@EntityAttrAnnotation(attrName="Java类全名",sort=7  , attrLength=200    )
	private String javaFullClass;





    //@EntityAttrAnnotation(attrName="Java 属性名",sort=8  , attrLength=100    )
	private String javaName;





    //@EntityAttrAnnotation(attrName="在表中的顺序",sort=9  , attrLength=0    )
	private Integer columnSort;





    //@EntityAttrAnnotation(attrName="列标题",sort=10  , attrLength=100    )
	private String columnTitle;








    //@EntityAttrAnnotation(attrName="对应外键表的列名",sort=13  , attrLength=50    )
	private String fkColumnName;







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
	 * 原始列的ID
	 * @return the originalColumnId
	 */
	public String getOriginalColumnId() {
		return originalColumnId;
	}
	
	/** 
	 * 原始列的ID
	 */
	public void setOriginalColumnId(String originalColumnId) {
		this.originalColumnId = originalColumnId;
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
	 * 在表中的顺序
	 * @return the columnSort
	 */
	public Integer getColumnSort() {
		return columnSort;
	}
	
	/** 
	 * 在表中的顺序
	 */
	public void setColumnSort(Integer columnSort) {
		this.columnSort = columnSort;
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
	 * 对应外键表的列名
	 * @return the fkColumnName
	 */
	public String getFkColumnName() {
		return fkColumnName;
	}
	
	/** 
	 * 对应外键表的列名
	 */
	public void setFkColumnName(String fkColumnName) {
		if(fkColumnName != null){
			fkColumnName = fkColumnName.toLowerCase();
		}
		this.fkColumnName = fkColumnName;
	}
	
}