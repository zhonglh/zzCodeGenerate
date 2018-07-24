package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
 * 模块设置实体类
 *
 * @author Administrator
 * @date 2018-7-24 14:42:51
 */
public class TcgModuleConfigEntity extends BaseBusinessEntity<String> implements java.io.Serializable{
	private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String projectId;





    //@EntityAttrAnnotation(attrName="模块名称",sort=2  , attrLength=30    )
	private String moduleName;





    //@EntityAttrAnnotation(attrName="模块资源",sort=3  , attrLength=20    )
	private String moduleResource;







	/** 
	 * 
	 * @return the projectId
	 */
	public String getProjectId() {
		return projectId;
	}
	
	/** 
	 * 
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	/** 
	 * 模块名称
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}
	
	/** 
	 * 模块名称
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	/** 
	 * 模块资源
	 * @return the moduleResource
	 */
	public String getModuleResource() {
		return moduleResource;
	}
	
	/** 
	 * 模块资源
	 */
	public void setModuleResource(String moduleResource) {
		this.moduleResource = moduleResource;
	}
	
}