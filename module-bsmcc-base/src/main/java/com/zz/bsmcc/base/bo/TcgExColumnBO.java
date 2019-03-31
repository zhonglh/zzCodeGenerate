package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;
import com.zz.bsmcc.base.domain.TcgExColumnEntity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
* 扩展列设置 BO , 扩展 扩展列设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="扩展列设置" , resource = "")
@TableName(value="tcg_ex_column" , resultMap = "TcgExColumnResultMap")
public class TcgExColumnBO extends TcgExColumnEntity implements Serializable {


    //用来存放本列对应的表
    @TableField(exist = false)
    private TcgTableConfigBO tableBO;

    /**
     * 列对应的Java 类型
     */
    @TableField(exist = false)
    private Class javaClass;



    /**
     * 原列名称
     */
    @TableField(exist = false)
    private String originalColumnName;


    /**
     * 原列Java
     */
    @TableField(exist = false)
    private String originalJavaName;


    @TableField(exist = false)
    private String originalColumnFk;

    @TableField(exist = false)
    private String originalColumnDict;

    //@EntityAttrAnnotation(attrName="组编码",sort=11  , attrLength=50    )
    //一般相同的数据项用相同的组名 ， 比如在项目表中， 客户名称，客户编号， 客户电话 ，客户ID等
    @TableField(exist = false)
    private String groupCode;

    //@EntityAttrAnnotation(attrName="字典类型",sort=12  , attrLength=50    )
    @TableField(exist = false)
    private String dictType;


    @TableField(exist = false)
    private String originalColumnFkName ;

    @TableField(exist = false)
    private String originalColumnDictName;


    //用于生成代码

    @TableField(exist = false)
    private String fkJavaName;

    //对应的原始列
    //如userBO里的depName , 对应的原始列为depId
    @TableField(exist = false)
    private TcgColumnConfigBO  originalColumn;


    //对应的原始列
    //如userBO里的depName , 对应是 ts_dep表的dep_name列
    @TableField(exist = false)
    private TcgColumnConfigBO  fkColumn;


    public String getOriginalColumnName() {
        return originalColumnName;
    }

    public void setOriginalColumnName(String originalColumnName) {
        this.originalColumnName = originalColumnName;
    }

    public String getOriginalJavaName() {
        return originalJavaName;
    }

    public void setOriginalJavaName(String originalJavaName) {
        this.originalJavaName = originalJavaName;
    }

    public String getOriginalColumnFk() {
        return originalColumnFk;
    }

    public void setOriginalColumnFk(String originalColumnFk) {
        this.originalColumnFk = originalColumnFk;
    }

    public String getOriginalColumnDict() {
        return originalColumnDict;
    }

    public void setOriginalColumnDict(String originalColumnDict) {
        this.originalColumnDict = originalColumnDict;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getOriginalColumnFkName() {
        return originalColumnFkName;
    }

    public void setOriginalColumnFkName(String originalColumnFkName) {
        this.originalColumnFkName = originalColumnFkName;
    }

    public String getOriginalColumnDictName() {
        return originalColumnDictName;
    }

    public void setOriginalColumnDictName(String originalColumnDictName) {
        this.originalColumnDictName = originalColumnDictName;
    }

    public String getFkJavaName() {
        return fkJavaName;
    }

    public void setFkJavaName(String fkJavaName) {
        this.fkJavaName = fkJavaName;
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

    public TcgColumnConfigBO getFkColumn() {
        return fkColumn;
    }

    public void setFkColumn(TcgColumnConfigBO fkColumn) {
        this.fkColumn = fkColumn;
    }

    public Class getJavaClass() {
        return javaClass;
    }

    public void setJavaClass(Class javaClass) {
        this.javaClass = javaClass;
    }

    public boolean isNumber() {
        return javaClass.isAssignableFrom(Number.class);
    }

    public boolean isDate() {
        return javaClass.isAssignableFrom(Date.class);
    }
}
