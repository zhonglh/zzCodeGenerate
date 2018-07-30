package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;

/**
 * 扩展列设置实体类
 *
 * @author Administrator
 * @date 2018-7-30 15:21:03
 */
public class TcgExColumnEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="原始列的ID",sort=2  , attrLength=32    )
	private String originalColumnId;





    //@EntityAttrAnnotation(attrName="原始列的名称",sort=3  , attrLength=50    )
	private String originalColumnName;





    //@EntityAttrAnnotation(attrName="原始列是否外键",sort=4  , attrLength=1    )
	private String originalColumnFk;





    //@EntityAttrAnnotation(attrName="原始列是否字典",sort=5  , attrLength=1    )
	private String originalColumnDict;





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





    //@EntityAttrAnnotation(attrName="组编码",sort=11  , attrLength=50    )
	//一般相同的数据项用相同的组名 ， 比如在项目表中， 客户名称，客户编号， 客户电话 ，客户ID等  
	private String groupCode;





    //@EntityAttrAnnotation(attrName="字典类型",sort=12  , attrLength=50    )
	private String dictType;





    //@EntityAttrAnnotation(attrName="表的schema",sort=13  , attrLength=50    )
	private String tableSchema;





    //@EntityAttrAnnotation(attrName="表名",sort=14  , attrLength=50    )
	private String tableName;







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
	 * 原始列的名称
	 * @return the originalColumnName
	 */
	public String getOriginalColumnName() {
		return originalColumnName;
	}
	
	/** 
	 * 原始列的名称
	 */
	public void setOriginalColumnName(String originalColumnName) {
		this.originalColumnName = originalColumnName;
	}
	/** 
	 * 原始列是否外键
	 * @return the originalColumnFk
	 */
	public String getOriginalColumnFk() {
		return originalColumnFk;
	}
	
	/** 
	 * 原始列是否外键
	 */
	public void setOriginalColumnFk(String originalColumnFk) {
		this.originalColumnFk = originalColumnFk;
	}
	/** 
	 * 原始列是否字典
	 * @return the originalColumnDict
	 */
	public String getOriginalColumnDict() {
		return originalColumnDict;
	}
	
	/** 
	 * 原始列是否字典
	 */
	public void setOriginalColumnDict(String originalColumnDict) {
		this.originalColumnDict = originalColumnDict;
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
	 * 组编码
	 * @return the groupCode
	 */
	public String getGroupCode() {
		return groupCode;
	}
	
	/** 
	 * 组编码
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
	/** 
	 * 表的schema
	 * @return the tableSchema
	 */
	public String getTableSchema() {
		return tableSchema;
	}
	
	/** 
	 * 表的schema
	 */
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	/** 
	 * 表名
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}
	
	/** 
	 * 表名
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}