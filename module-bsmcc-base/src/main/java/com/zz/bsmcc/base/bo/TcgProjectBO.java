package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgProjectEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 项目管理 BO , 扩展 项目管理Entity对象
* @author Administrator
*/
@EntityAnnotation(value="项目管理" , resource = "")
@TableName(value="tcg_project" , resultMap = "TcgProjectResultMap")
public class TcgProjectBO extends TcgProjectEntity implements Serializable {

}
