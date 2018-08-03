package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.zz.bsmcc.base.domain.TcgColumnConfigEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 列设置 BO , 扩展 列设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="列设置" , resource = "")
@TableName(value="tcg_column_config" , resultMap = "TcgColumnConfigResultMap")
public class TcgColumnConfigBO extends TcgColumnConfigEntity implements Serializable {


    @TableField(exist = false)
    private String columnIsnullName ;

    //用于生成代码
    @TableField(exist = false)
    private TcgTableConfigBO fkTableConfig;
    @TableField(exist = false)
    private String fkColumnName;
    @TableField(exist = false)
    private String fkJavaName;
    @TableField(exist = false)
    private String fkJavaSimpleClass;
    @TableField(exist = false)
    private String fkJavaFullClass;

    public String getColumnIsnullName() {
        return columnIsnullName;
    }

    public void setColumnIsnullName(String columnIsnullName) {
        this.columnIsnullName = columnIsnullName;
    }


    public TcgTableConfigBO getFkTableConfig() {
        return fkTableConfig;
    }

    public void setFkTableConfig(TcgTableConfigBO fkTableConfig) {
        this.fkTableConfig = fkTableConfig;
    }

    public String getFkColumnName() {
        return fkColumnName;
    }

    public void setFkColumnName(String fkColumnName) {
        this.fkColumnName = fkColumnName;
    }

    public String getFkJavaName() {
        return fkJavaName;
    }

    public void setFkJavaName(String fkJavaName) {
        this.fkJavaName = fkJavaName;
    }

    public String getFkJavaSimpleClass() {
        return fkJavaSimpleClass;
    }

    public void setFkJavaSimpleClass(String fkJavaSimpleClass) {
        this.fkJavaSimpleClass = fkJavaSimpleClass;
    }

    public String getFkJavaFullClass() {
        return fkJavaFullClass;
    }

    public void setFkJavaFullClass(String fkJavaFullClass) {
        this.fkJavaFullClass = fkJavaFullClass;
    }
}
