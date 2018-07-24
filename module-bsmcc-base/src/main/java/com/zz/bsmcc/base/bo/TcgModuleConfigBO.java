package com.zz.bsmcc.base.bo;

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

}
