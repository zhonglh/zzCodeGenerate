//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zz.bsmcc.core.util.table.pojo;

import java.io.Serializable;

/**
 * 数据库对应的列
 * @author Administrator
 */
public class Column implements Serializable{


    /**
     * 列名称
     */
    private String columnName;

    /**
     * 列说明
     */
    private String columnComment ;

    /**
     *
     * 默认值
     */
    private String columnDefault;

    /**
     * 列说明补充
     */
    private String columnOtherComments;


    /**
     * 列数据库类型
     */
    private String dataType ;


    /**
     * 字符串最大长度
     */
    private Integer charmaxLength;

    /**
     * 数字最大长度
     */
    private Integer precision;

    /**
     * 小数点长度
     */
    private Integer scale;

    /**
     * 是否可以为空
     */
    private boolean nullable;



    /**
     * 是否为固定长度字符
     */
    boolean isFixedChar;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getColumnOtherComments() {
        return columnOtherComments;
    }

    public void setColumnOtherComments(String columnOtherComments) {
        this.columnOtherComments = columnOtherComments;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getCharmaxLength() {
        return charmaxLength;
    }

    public void setCharmaxLength(Integer charmaxLength) {
        this.charmaxLength = charmaxLength;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isFixedChar() {
        return isFixedChar;
    }

    public void setFixedChar(boolean fixedChar) {
        isFixedChar = fixedChar;
    }
}
