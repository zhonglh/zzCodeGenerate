package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgTempletGroupEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 模板组 BO , 扩展 模板组Entity对象
* @author Administrator
*/
@EntityAnnotation(value="模板组" , resource = "")
@TableName(value="tcg_templet_group" , resultMap = "TcgTempletGroupResultMap")
public class TcgTempletGroupBO extends TcgTempletGroupEntity implements Serializable {

}
