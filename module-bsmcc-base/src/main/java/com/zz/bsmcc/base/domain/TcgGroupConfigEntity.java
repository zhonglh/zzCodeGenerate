package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
 * 组设置实体类
 *
 * @author Administrator
 * @date 2018-7-24 14:42:51
 */
public class TcgGroupConfigEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{






    //@EntityAttrAnnotation(attrName="",sort=1  , attrLength=32    )
	private String projectId;





    //@EntityAttrAnnotation(attrName="组名称",sort=2  , attrLength=30    )
	private String moduleName;





    //@EntityAttrAnnotation(attrName="组编码",sort=3  , attrLength=20    )
	private String groupCode;







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
	 * 组名称
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}
	
	/** 
	 * 组名称
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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
	
}