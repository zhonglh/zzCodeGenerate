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
 * 列设置实体类
 *
 * @author Administrator
 * @date 2018-7-30 13:51:09
 */
public class TcgColumnConfigEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="名称",sort=2  , attrLength=50    )
	private String columnName;





    //@EntityAttrAnnotation(attrName="类型",sort=3  , attrLength=50    )
	//如char varch  int date  
	private String columnType;





    //@EntityAttrAnnotation(attrName="长度",sort=4  , attrLength=0    )
	private Integer columnLength;





    //@EntityAttrAnnotation(attrName="小数点位数",sort=5  , attrLength=0    )
	private Integer columnScale;





    //@EntityAttrAnnotation(attrName="默认值",sort=6  , attrLength=100    )
	private String columnDefault;





    //@EntityAttrAnnotation(attrName="是否允许空值",sort=7  , attrLength=1    )
	private String columnIsnull;





    //@EntityAttrAnnotation(attrName="在表中的顺序",sort=8  , attrLength=0    )
	private Integer columnSort;





    //@EntityAttrAnnotation(attrName="是否为外键",sort=9  , attrLength=1    )
	private String columnIsfk;





    //@EntityAttrAnnotation(attrName="是否为主键",sort=10  , attrLength=1    )
	private String columnIskey;





    //@EntityAttrAnnotation(attrName="是否为字典",sort=11  , attrLength=1    )
	private String columnIsdict;





    //@EntityAttrAnnotation(attrName="字典类型",sort=12  , attrLength=100    )
	private String dictType;





    //@EntityAttrAnnotation(attrName="说明",sort=13  , attrLength=100    )
	private String columnComment;





    //@EntityAttrAnnotation(attrName="Java类名",sort=14  , attrLength=100    )
	private String javaSimpleClass;





    //@EntityAttrAnnotation(attrName="Java类全名",sort=15  , attrLength=200    )
	private String javaFullClass;





    //@EntityAttrAnnotation(attrName="Java 属性名",sort=16  , attrLength=100    )
	private String javaName;





    //@EntityAttrAnnotation(attrName="组名称",sort=17  , attrLength=50    )
	//一般相同的数据项用相同的组名 ， 比如在项目表中， 客户名称，客户编号， 客户电话 ，客户ID等  
	private String groupCode;







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
	 * 名称
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}
	
	/** 
	 * 名称
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/** 
	 * 类型
	 * @return the columnType
	 */
	public String getColumnType() {
		return columnType;
	}
	
	/** 
	 * 类型
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	/** 
	 * 长度
	 * @return the columnLength
	 */
	public Integer getColumnLength() {
		return columnLength;
	}
	
	/** 
	 * 长度
	 */
	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}
	/** 
	 * 小数点位数
	 * @return the columnScale
	 */
	public Integer getColumnScale() {
		return columnScale;
	}
	
	/** 
	 * 小数点位数
	 */
	public void setColumnScale(Integer columnScale) {
		this.columnScale = columnScale;
	}
	/** 
	 * 默认值
	 * @return the columnDefault
	 */
	public String getColumnDefault() {
		return columnDefault;
	}
	
	/** 
	 * 默认值
	 */
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}
	/** 
	 * 是否允许空值
	 * @return the columnIsnull
	 */
	public String getColumnIsnull() {
		return columnIsnull;
	}
	
	/** 
	 * 是否允许空值
	 */
	public void setColumnIsnull(String columnIsnull) {
		this.columnIsnull = columnIsnull;
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
	 * 是否为外键
	 * @return the columnIsfk
	 */
	public String getColumnIsfk() {
		return columnIsfk;
	}
	
	/** 
	 * 是否为外键
	 */
	public void setColumnIsfk(String columnIsfk) {
		this.columnIsfk = columnIsfk;
	}
	/** 
	 * 是否为主键
	 * @return the columnIskey
	 */
	public String getColumnIskey() {
		return columnIskey;
	}
	
	/** 
	 * 是否为主键
	 */
	public void setColumnIskey(String columnIskey) {
		this.columnIskey = columnIskey;
	}
	/** 
	 * 是否为字典
	 * @return the columnIsdict
	 */
	public String getColumnIsdict() {
		return columnIsdict;
	}
	
	/** 
	 * 是否为字典
	 */
	public void setColumnIsdict(String columnIsdict) {
		this.columnIsdict = columnIsdict;
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
	 * 说明
	 * @return the columnComment
	 */
	public String getColumnComment() {
		return columnComment;
	}
	
	/** 
	 * 说明
	 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
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
	
}