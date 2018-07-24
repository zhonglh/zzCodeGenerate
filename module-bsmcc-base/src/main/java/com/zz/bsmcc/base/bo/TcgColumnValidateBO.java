package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgColumnValidateEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 列校验 BO , 扩展 列校验Entity对象
* @author Administrator
*/
@EntityAnnotation(value="列校验" , resource = "")
@TableName(value="tcg_column_validate" , resultMap = "TcgColumnValidateResultMap")
public class TcgColumnValidateBO extends TcgColumnValidateEntity implements Serializable {

}
