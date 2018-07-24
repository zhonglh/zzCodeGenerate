package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgIndexConfigEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 索引设置 BO , 扩展 索引设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="索引设置" , resource = "")
@TableName(value="tcg_index_config" , resultMap = "TcgIndexConfigResultMap")
public class TcgIndexConfigBO extends TcgIndexConfigEntity implements Serializable {

}
