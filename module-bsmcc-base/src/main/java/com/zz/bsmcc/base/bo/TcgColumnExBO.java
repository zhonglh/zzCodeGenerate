package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgColumnExEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 列扩展 BO , 扩展 列扩展Entity对象
* @author Administrator
*/
@Deprecated
@EntityAnnotation(value="列扩展" , resource = "")
@TableName(value="tcg_column_ex" , resultMap = "TcgColumnExResultMap")
public class TcgColumnExBO extends TcgColumnExEntity implements Serializable {

}
