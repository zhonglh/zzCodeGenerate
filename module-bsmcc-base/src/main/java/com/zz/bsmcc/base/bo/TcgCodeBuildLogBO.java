package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bsmcc.base.domain.TcgCodeBuildLogEntity;

import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 代码生成记录 BO , 扩展 代码生成记录Entity对象
* @author Administrator
*/
@EntityAnnotation(value="代码生成记录" , resource = "")
@TableName(value="tcg_code_build_log" , resultMap = "TcgCodeBuildLogResultMap")
public class TcgCodeBuildLogBO extends TcgCodeBuildLogEntity implements Serializable {

    @TableField(exist = false)
    private String projectName;

    @TableField(exist = false)
    private String templetGroupName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTempletGroupName() {
        return templetGroupName;
    }

    public void setTempletGroupName(String templetGroupName) {
        this.templetGroupName = templetGroupName;
    }
}
