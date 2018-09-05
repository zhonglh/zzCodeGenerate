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
 * 表设置实体类
 *
 * @author Administrator
 * @date 2018-7-30 10:25:22
 */
public class TcgTableConfigEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="数据库设置",sort=1  , attrLength=32    )
	private String dbId;





    //@EntityAttrAnnotation(attrName="项目",sort=2  , attrLength=32    )
	private String projectId;





    //@EntityAttrAnnotation(attrName="模块",sort=3  , attrLength=32    )
	private String moduleId;





    //@EntityAttrAnnotation(attrName="SCHEMA",sort=4  , attrLength=50    )
	private String schemaName;





    //@EntityAttrAnnotation(attrName="表名",sort=5  , attrLength=50    )
	private String tableName;





    //@EntityAttrAnnotation(attrName="表类型",sort=6  , attrLength=1    )
	//1. 单表  2. 主表  3. 附表  4. 子表  
	private String tableType;





    //@EntityAttrAnnotation(attrName="和主表关系",sort=7  , attrLength=20    )
	//one-one      一对一  one-multi     一对多  
	private String tableRelation;





    //@EntityAttrAnnotation(attrName="是否显示复选框",sort=8  , attrLength=1    )
	private String isShowCheckbox;





    //@EntityAttrAnnotation(attrName="是否为表, 表或者视图",sort=9  , attrLength=1    )
	private String isTable;





    //@EntityAttrAnnotation(attrName="主要的表",sort=10  , attrLength=32    )
	//该字段设置用于视图情况  
	private String mainTableId;





    //@EntityAttrAnnotation(attrName="资源名称",sort=11  , attrLength=50    )
	//用于路径和权限  
	private String resourceName;





    //@EntityAttrAnnotation(attrName="是否树状数据",sort=12  , attrLength=1    )
	private String isTree;





    //@EntityAttrAnnotation(attrName="上级字段名称",sort=13  , attrLength=50    )
	//树状数据时使用  
	private String parentFieldName;





    //@EntityAttrAnnotation(attrName="说明",sort=14  , attrLength=50    )
	private String tableComment;



	//@EntityAttrAnnotation(attrName="其它说明",sort=14  , attrLength=50    )
	private String tableOtherComment;


    //@EntityAttrAnnotation(attrName="查询条件模式",sort=15  , attrLength=20    )
	//toolbar      工具栏样式，尽量在一行  ordinary    普通模式， 一个条件一行 ， 最后是关键字查询  
	private String queryMode;





    //@EntityAttrAnnotation(attrName="是否生成界面",sort=16  , attrLength=1    )
	private String isBuildUi;





    //@EntityAttrAnnotation(attrName="是否生成菜单",sort=17  , attrLength=1    )
	private String isBuildMenu;



	//@EntityAttrAnnotation(attrName="是否生成权限数据",sort=17  , attrLength=1    )
	private String isBuildRbac;




    //@EntityAttrAnnotation(attrName="Java名称",sort=18  , attrLength=50    )
	private String javaName;







	/** 
	 * 数据库设置
	 * @return the dbId
	 */
	public String getDbId() {
		return dbId;
	}
	
	/** 
	 * 数据库设置
	 */
	public void setDbId(String dbId) {
		this.dbId = dbId;
	}
	/** 
	 * 项目
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	
	/** 
	 * 项目
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/** 
	 * 模块
	 * @return the moduleId
	 */
	public String getModuleId() {
		return moduleId;
	}
	
	/** 
	 * 模块
	 */
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	/** 
	 * SCHEMA
	 * @return the schemaName
	 */
	public String getSchemaName() {
		return schemaName;
	}
	
	/** 
	 * SCHEMA
	 */
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
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
	/** 
	 * 表类型
	 * @return the tableType
	 */
	public String getTableType() {
		return tableType;
	}
	
	/** 
	 * 表类型
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	/** 
	 * 和主表关系
	 * @return the tableRelation
	 */
	public String getTableRelation() {
		return tableRelation;
	}
	
	/** 
	 * 和主表关系
	 */
	public void setTableRelation(String tableRelation) {
		this.tableRelation = tableRelation;
	}
	/** 
	 * 是否显示复选框
	 * @return the isShowCheckbox
	 */
	public String getIsShowCheckbox() {
		return isShowCheckbox;
	}
	
	/** 
	 * 是否显示复选框
	 */
	public void setIsShowCheckbox(String isShowCheckbox) {
		this.isShowCheckbox = isShowCheckbox;
	}
	/** 
	 * 是否为表, 表或者视图
	 * @return the isTable
	 */
	public String getIsTable() {
		return isTable;
	}
	
	/** 
	 * 是否为表, 表或者视图
	 */
	public void setIsTable(String isTable) {
		this.isTable = isTable;
	}
	/** 
	 * 主要的表
	 * @return the mainTableId
	 */
	public String getMainTableId() {
		return mainTableId;
	}
	
	/** 
	 * 主要的表
	 */
	public void setMainTableId(String mainTableId) {
		this.mainTableId = mainTableId;
	}
	/** 
	 * 资源名称
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}
	
	/** 
	 * 资源名称
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	/** 
	 * 是否树状数据
	 * @return the isTree
	 */
	public String getIsTree() {
		return isTree;
	}
	
	/** 
	 * 是否树状数据
	 */
	public void setIsTree(String isTree) {
		this.isTree = isTree;
	}
	/** 
	 * 上级字段名称
	 * @return the parentFieldName
	 */
	public String getParentFieldName() {
		return parentFieldName;
	}
	
	/** 
	 * 上级字段名称
	 */
	public void setParentFieldName(String parentFieldName) {
		this.parentFieldName = parentFieldName;
	}
	/** 
	 * 说明
	 * @return the tableComment
	 */
	public String getTableComment() {
		return tableComment;
	}
	
	/** 
	 * 说明
	 */
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	/** 
	 * 查询条件模式
	 * @return the queryMode
	 */
	public String getQueryMode() {
		return queryMode;
	}
	
	/** 
	 * 查询条件模式
	 */
	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}

	/** 
	 * 是否生成菜单
	 * @return the isBuildMenu
	 */
	public String getIsBuildMenu() {
		return isBuildMenu;
	}
	
	/** 
	 * 是否生成菜单
	 */
	public void setIsBuildMenu(String isBuildMenu) {
		this.isBuildMenu = isBuildMenu;
	}
	/** 
	 * Java名称
	 * @return the javaName
	 */
	public String getJavaName() {
		return javaName;
	}
	
	/** 
	 * Java名称
	 */
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public String getTableOtherComment() {
		return tableOtherComment;
	}

	public void setTableOtherComment(String tableOtherComment) {
		this.tableOtherComment = tableOtherComment;
	}

	public String getIsBuildUi() {
		return isBuildUi;
	}

	public void setIsBuildUi(String isBuildUi) {
		this.isBuildUi = isBuildUi;
	}

	public String getIsBuildRbac() {
		return isBuildRbac;
	}

	public void setIsBuildRbac(String isBuildRbac) {
		this.isBuildRbac = isBuildRbac;
	}
}