package com.zz.bsmcc.base.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bsmcc.base.domain.TcgColumnConfigEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


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

    /**
     * 列对应的Java 类型
     */
    @TableField(exist = false)
    private Class javaClass;

    //用于生成代码

    //如果是外键， 外键对应的表
   @TableField(exist = false)
    private TcgTableConfigBO fkTableConfig;

    //如果是外键， 外键列名
    @TableField(exist = false)
    private String fkColumnName;

    //如果是外键， 外键列名对应的Java属性
    @TableField(exist = false)
    private String fkJavaName;

    //如果是外键， 外键列对应的类名，简写
    @TableField(exist = false)
    private String fkJavaSimpleClass;

    //如果是外键， 外键列对应的类名，全称
    @TableField(exist = false)
    private String fkJavaFullClass;

    // 视图对应的列， 判断是否是主要的表 的列
    @TableField(exist = false)
    private boolean inParentClass;

    //列对应的 set方法名
    @TableField(exist = false)
    private String setMethodName;
    //列对应的 get方法名
    @TableField(exist = false)
    private String getMethodName;


    //对应的原始列 , 比如 project_name ,  对应的应该就是project_id 列
    //用于外键 弹框选择
    @TableField(exist = false)
    private TcgColumnConfigBO  originalColumn;

    //衍生列  ， 如果是字典或者外键， 对应的扩展列
    @TableField(exist = false)
    private List<TcgExColumnBO> exCloumns;

    /**
     * 本列是否为表的业务名称
     */
    @TableField(exist = false)
    private String tableBusinessName ;


    /**
     * 本列是否为表的业务主键
     */
    @TableField(exist = false)
    private String tableBusinessKey ;

    /**
     * 文件类型 ，参考 EnumPageElement 最后四种
     * 如果不是文件类型， 为 null
     */
    @TableField(exist = false)
    private String fileType;

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

    public List<TcgExColumnBO> getExCloumns() {
        return exCloumns;
    }

    public void setExCloumns(List<TcgExColumnBO> exCloumns) {
        this.exCloumns = exCloumns;
    }


    public String getTableBusinessName() {
        return tableBusinessName;
    }

    public void setTableBusinessName(String tableBusinessName) {
        this.tableBusinessName = tableBusinessName;
    }

    public String getTableBusinessKey() {
        return tableBusinessKey;
    }

    public void setTableBusinessKey(String tableBusinessKey) {
        this.tableBusinessKey = tableBusinessKey;
    }

    public Class getJavaClass() {
        return javaClass;
    }

    public void setJavaClass(Class javaClass) {
        this.javaClass = javaClass;
    }

    public boolean isNumber() {
        return Number.class.isAssignableFrom(javaClass);
    }

    public boolean isDate() {
        return Date.class.isAssignableFrom(javaClass);
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return super.getColumnName();
    }

    public static void main(String[] args) {
        System.out.println(Date.class.isAssignableFrom(String.class));
    }
}
