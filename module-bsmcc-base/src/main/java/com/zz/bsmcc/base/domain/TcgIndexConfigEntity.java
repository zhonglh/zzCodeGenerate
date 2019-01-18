package com.zz.bsmcc.base.domain;



import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 索引设置实体类
 *
 * @author Administrator
 * @date 2018-7-29 1:16:12
 */
public class TcgIndexConfigEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String tableId;





    //@EntityAttrAnnotation(attrName="索引名称",sort=2  , attrLength=100    )
	private String indexName;





    //@EntityAttrAnnotation(attrName="索引字段",sort=3  , attrLength=500    )
	//多个用 逗号  分割
	private String indexCloumns;


	//@EntityAttrAnnotation(attrName="提示信息",sort=4  , attrLength=100    )
	private String tipMsg;







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
	 * 索引名称
	 * @return the indexName
	 */
	public String getIndexName() {
		return indexName;
	}
	
	/** 
	 * 索引名称
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	/** 
	 * 索引字段
	 * @return the indexCloumns
	 */
	public String getIndexCloumns() {
		return indexCloumns;
	}
	
	/** 
	 * 索引字段
	 */
	public void setIndexCloumns(String indexCloumns) {
		this.indexCloumns = indexCloumns;
	}


	public String getTipMsg() {
		return tipMsg;
	}

	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
}