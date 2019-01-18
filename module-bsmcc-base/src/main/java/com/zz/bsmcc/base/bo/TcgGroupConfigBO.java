package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgGroupConfigEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 组设置 BO , 扩展 组设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="组设置" , resource = "")
@TableName(value="tcg_group_config" , resultMap = "TcgGroupConfigResultMap")
public class TcgGroupConfigBO extends TcgGroupConfigEntity implements Serializable {

}
