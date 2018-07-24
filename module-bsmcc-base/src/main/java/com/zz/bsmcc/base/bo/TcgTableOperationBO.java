package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgTableOperationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 表操作定义 BO , 扩展 表操作定义Entity对象
* @author Administrator
*/
@EntityAnnotation(value="表操作定义" , resource = "")
@TableName(value="tcg_table_operation" , resultMap = "TcgTableOperationResultMap")
public class TcgTableOperationBO extends TcgTableOperationEntity implements Serializable {

}
