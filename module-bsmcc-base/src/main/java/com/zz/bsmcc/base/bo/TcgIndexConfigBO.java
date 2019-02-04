package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bsmcc.base.domain.TcgIndexConfigEntity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import java.io.Serializable;
import java.util.List;


/**
* 索引设置 BO , 扩展 索引设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="索引设置" , resource = "")
@TableName(value="tcg_index_config" , resultMap = "TcgIndexConfigResultMap")
public class TcgIndexConfigBO extends TcgIndexConfigEntity implements Serializable {

    //用于代码生成

    /**
     * 索引列信息
     */
    @TableField(exist =  false)
    private List<TcgColumnConfigBO> columns ;

    public List<TcgColumnConfigBO> getColumns() {
        return columns;
    }

    public void setColumns(List<TcgColumnConfigBO> columns) {
        this.columns = columns;
    }
}
