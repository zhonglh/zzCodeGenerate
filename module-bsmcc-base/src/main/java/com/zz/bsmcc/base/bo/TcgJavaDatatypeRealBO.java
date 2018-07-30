package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgJavaDatatypeRealEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 数据类型关联 BO , 扩展 数据类型关联Entity对象
* @author Administrator
*/
@EntityAnnotation(value="数据类型关联" , resource = "")
@TableName(value="tcg_java_datatype_real" , resultMap = "TcgJavaDatatypeRealResultMap")
public class TcgJavaDatatypeRealBO extends TcgJavaDatatypeRealEntity implements Serializable {

}
