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

    @TableField(exist = false)
    //用来存放本列对应的表
    private TcgTableConfigBO tableBO;

    //用于生成代码

    //如果是外键， 外键对应的表
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
    @TableField(exist = false)
    private boolean inParentClass;

    @TableField(exist = false)
    private String setMethodName;
    @TableField(exist = false)
    private String getMethodName;


    //对应的原始列 , 比如 project_name ,  对应的应该就是project_id 列
    //用于外键 弹框选择
    @TableField(exist = false)
    private TcgColumnConfigBO  originalColumn;


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


    public String getSetMethodName() {
        return setMethodName;
    }

    public void setSetMethodName(String setMethodName) {
        this.setMethodName = setMethodName;
    }

    public String getGetMethodName() {
        return getMethodName;
    }

    public void setGetMethodName(String getMethodName) {
        this.getMethodName = getMethodName;
    }

    public boolean isInParentClass() {
        return inParentClass;
    }

    public void setInParentClass(boolean inParentClass) {
        this.inParentClass = inParentClass;
    }

    public TcgColumnConfigBO getOriginalColumn() {
        return originalColumn;
    }

    public void setOriginalColumn(TcgColumnConfigBO originalColumn) {
        this.originalColumn = originalColumn;
    }

    public TcgTableConfigBO getTableBO() {
        return tableBO;
    }

    public void setTableBO(TcgTableConfigBO tableBO) {
        this.tableBO = tableBO;
    }
}
