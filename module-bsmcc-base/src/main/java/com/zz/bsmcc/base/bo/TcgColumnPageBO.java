package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgColumnPageEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 列界面设置 BO , 扩展 列界面设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="列界面设置" , resource = "")
@TableName(value="tcg_column_page" , resultMap = "TcgColumnPageResultMap")
public class TcgColumnPageBO extends TcgColumnPageEntity implements Serializable {

}
