package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;

/**
 * 功能模块设置实体类
 *
 * @author Administrator
 * @date 2018-7-29 1:16:12
 */
public class TcgModuleConfigEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="项目",sort=1  , attrLength=32    )
	private String projectId;





    //@EntityAttrAnnotation(attrName="模块名称",sort=2  , attrLength=30    )
	private String moduleName;





    //@EntityAttrAnnotation(attrName="模块资源",sort=3  , attrLength=20    )
	private String moduleResource;





    //@EntityAttrAnnotation(attrName="上级模块",sort=4  , attrLength=32    )
	private String pid;







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
	/** 
	 * 上级模块
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}
	
	/** 
	 * 上级模块
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	
}