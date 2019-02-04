package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bsmcc.base.domain.TcgTempletGroupOperationEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 模板组操作定义 BO , 扩展 模板组操作定义Entity对象
* @author Administrator
*/
@EntityAnnotation(value="模板组操作定义" , resource = "")
@TableName(value="tcg_templet_group_operation" , resultMap = "TcgTempletGroupOperationResultMap")
public class TcgTempletGroupOperationBO extends TcgTempletGroupOperationEntity implements Serializable {

    @TableField(exist = false)
    private String operationName ;

    @TableField(exist = false)
    private String operationResource;

    private TcgOperationBO operationBO;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public String getOperationResource() {
        return operationResource;
    }

    public void setOperationResource(String operationResource) {
        this.operationResource = operationResource;
    }

    public TcgOperationBO getOperationBO() {
        return operationBO;
    }

    public void setOperationBO(TcgOperationBO operationBO) {
        this.operationBO = operationBO;
    }
}
