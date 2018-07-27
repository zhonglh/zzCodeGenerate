package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TsUserEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 用户 BO , 扩展 用户Entity对象
* @author Administrator
*/
@EntityAnnotation(value="用户" , resource = "")
@TableName(value="ts_user" , resultMap = "TsUserResultMap")
public class TsUserBO extends TsUserEntity implements Serializable {

}
