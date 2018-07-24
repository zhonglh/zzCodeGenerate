package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgQueryConfigEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 查询条件设置 BO , 扩展 查询条件设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="查询条件设置" , resource = "")
@TableName(value="tcg_query_config" , resultMap = "TcgQueryConfigResultMap")
public class TcgQueryConfigBO extends TcgQueryConfigEntity implements Serializable {

}
