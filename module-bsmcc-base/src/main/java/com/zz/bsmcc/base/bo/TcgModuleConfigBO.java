package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.zz.bsmcc.base.domain.TcgModuleConfigEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 模块设置 BO , 扩展 模块设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="模块设置" , resource = "")
@TableName(value="tcg_module_config" , resultMap = "TcgModuleConfigResultMap")
public class TcgModuleConfigBO extends TcgModuleConfigEntity implements Serializable {


    @TableField(exist = false)
    private String projectName;


    @TableField(exist = false)
    private String parentModuleNme;

    @TableField(exist = false)
    private String moduleFullResource ;


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getParentModuleNme() {
        return parentModuleNme;
    }

    public void setParentModuleNme(String parentModuleNme) {
        this.parentModuleNme = parentModuleNme;
    }

    public String getModuleFullResource() {
        return moduleFullResource;
    }

    public void setModuleFullResource(String moduleFullResource) {
        this.moduleFullResource = moduleFullResource;
    }
}
