package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bsmcc.base.domain.TcgQueryConfigEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 查询条件设置 BO , 扩展 查询条件设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="查询条件设置" , resource = "")
@TableName(value="tcg_query_config" , resultMap = "TcgQueryConfigResultMap")
public class TcgQueryConfigBO extends TcgQueryConfigEntity implements Serializable {

    @TableField(exist = false)
    private String columnComment ;

    //代码生成

    /**
     * 列信息
     */
    @TableField(exist = false)
    private TcgColumnPageBO columnPage ;

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }


    public TcgColumnPageBO getColumnPage() {
        return columnPage;
    }

    public void setColumnPage(TcgColumnPageBO columnPage) {
        this.columnPage = columnPage;
    }
}
