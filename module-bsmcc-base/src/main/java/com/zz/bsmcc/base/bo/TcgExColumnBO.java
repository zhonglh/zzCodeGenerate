package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgExColumnEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 扩展列设置 BO , 扩展 扩展列设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="扩展列设置" , resource = "")
@TableName(value="tcg_ex_column" , resultMap = "TcgExColumnResultMap")
public class TcgExColumnBO extends TcgExColumnEntity implements Serializable {

}
