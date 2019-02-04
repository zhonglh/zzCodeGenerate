package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bsmcc.base.domain.TcgColumnEventEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 列事件 BO , 扩展 列事件Entity对象
* @author Administrator
*/
@EntityAnnotation(value="列事件" , resource = "")
@TableName(value="tcg_column_event" , resultMap = "TcgColumnEventResultMap")
public class TcgColumnEventBO extends TcgColumnEventEntity implements Serializable {

    @TableField(exist = false)
    private String columnComment ;

    //用于代码生成

    /**
     * 对应的列界面信息
     */
    @TableField(exist = false)
    private TcgColumnPageBO columnPage;

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
