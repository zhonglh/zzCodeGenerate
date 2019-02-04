package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgDbConfigEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 连接池设置 BO , 扩展 连接池设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="连接池设置" , resource = "")
@TableName(value="tcg_db_config" , resultMap = "TcgDbConfigResultMap")
public class TcgDbConfigBO extends TcgDbConfigEntity implements Serializable {

}
