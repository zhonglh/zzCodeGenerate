package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
 * 代码生成记录实体类
 *
 * @author Administrator
 * @date 2018-8-3 11:23:12
 */
public class TcgCodeBuildLogEntity extends BaseBusinessSimpleEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="项目",sort=1  , attrLength=32    )
	private String projectId;





    //@EntityAttrAnnotation(attrName="模板组",sort=2  , attrLength=32    )
	private String templetGroupId;







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
	 * 模板组
	 * @return the templetGroupId
	 */
	public String getTempletGroupId() {
		return templetGroupId;
	}
	
	/** 
	 * 模板组
	 */
	public void setTempletGroupId(String templetGroupId) {
		this.templetGroupId = templetGroupId;
	}
	
}