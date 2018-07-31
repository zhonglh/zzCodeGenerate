package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgColumnEventEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 列事件 BO , 扩展 列事件Entity对象
* @author Administrator
*/
@EntityAnnotation(value="列事件" , resource = "")
@TableName(value="tcg_column_event" , resultMap = "TcgColumnEventResultMap")
public class TcgColumnEventBO extends TcgColumnEventEntity implements Serializable {

    private String columnComment ;

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
}
