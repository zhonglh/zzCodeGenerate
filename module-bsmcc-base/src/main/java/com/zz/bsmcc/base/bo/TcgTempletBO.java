package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgTempletEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 模板 BO , 扩展 模板Entity对象
* @author Administrator
*/
@EntityAnnotation(value="模板" , resource = "")
@TableName(value="tcg_templet" , resultMap = "TcgTempletResultMap")
public class TcgTempletBO extends TcgTempletEntity implements Serializable {

}
