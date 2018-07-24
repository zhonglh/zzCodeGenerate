package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgColumnExEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 列扩展 BO , 扩展 列扩展Entity对象
* @author Administrator
*/
@EntityAnnotation(value="列扩展" , resource = "")
@TableName(value="tcg_column_ex" , resultMap = "TcgColumnExResultMap")
public class TcgColumnExBO extends TcgColumnExEntity implements Serializable {

}
