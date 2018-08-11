package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 查询条件设置实体类
 *
 * @author Administrator
 * @date 2018-7-29 1:16:14
 */
public class TcgQueryConfigEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{

    @TableField(exist=false)
    private static final long serialVersionUID = 1L;


    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;


    //@EntityAttrAnnotation(attrName="列",sort=2  , attrLength=32    )
	private String columnId;


    //@EntityAttrAnnotation(attrName="标题",sort=3  , attrLength=20    )
	private String queryTitle;





    //@EntityAttrAnnotation(attrName="placeholder",sort=4  , attrLength=100    )
	private String queryPlaceholder;





    //@EntityAttrAnnotation(attrName="查询关系",sort=5  , attrLength=100    )
	//参考 EnumSearchType
	private String queryRelation;





    //@EntityAttrAnnotation(attrName="查询顺序",sort=6  , attrLength=0    )
	private Integer querySort;

	//查询框Name
	//没有使用列的情况需要设置， 比如关键字查询
	private String queryFieldName;




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
	 * 标题
	 * @return the queryTitle
	 */
	public String getQueryTitle() {
		return queryTitle;
	}
	
	/** 
	 * 标题
	 */
	public void setQueryTitle(String queryTitle) {
		this.queryTitle = queryTitle;
	}
	/** 
	 * placeholder
	 * @return the queryPlaceholder
	 */
	public String getQueryPlaceholder() {
		return queryPlaceholder;
	}
	
	/** 
	 * placeholder
	 */
	public void setQueryPlaceholder(String queryPlaceholder) {
		this.queryPlaceholder = queryPlaceholder;
	}
	/** 
	 * 查询关系
	 * @return the queryRelation
	 */
	public String getQueryRelation() {
		return queryRelation;
	}
	
	/** 
	 * 查询关系
	 */
	public void setQueryRelation(String queryRelation) {
		this.queryRelation = queryRelation;
	}
	/** 
	 * 查询顺序
	 * @return the querySort
	 */
	public Integer getQuerySort() {
		return querySort;
	}
	
	/** 
	 * 查询顺序
	 */
	public void setQuerySort(Integer querySort) {
		this.querySort = querySort;
	}


	/**
	 * 查询框名称
	 */
	public String getQueryFieldName() {
		return queryFieldName;
	}

	public void setQueryFieldName(String queryFieldName) {
		this.queryFieldName = queryFieldName;
	}
}