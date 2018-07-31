package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgColumnPageEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 列界面设置 BO , 扩展 列界面设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="列界面设置" , resource = "")
@TableName(value="tcg_column_page" , resultMap = "TcgColumnPageResultMap")
public class TcgColumnPageBO extends TcgColumnPageEntity implements Serializable {

    private String columnComment ;

    private String realColumnName;

    private String editableName;

    private String hiddenableName;

    private String existPageName;

    private String requiredName;

    private String listShowableName;


    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getRealColumnName() {
        return realColumnName;
    }

    public void setRealColumnName(String realColumnName) {
        this.realColumnName = realColumnName;
    }

    public String getEditableName() {
        return editableName;
    }

    public void setEditableName(String editableName) {
        this.editableName = editableName;
    }

    public String getHiddenableName() {
        return hiddenableName;
    }

    public void setHiddenableName(String hiddenableName) {
        this.hiddenableName = hiddenableName;
    }

    public String getExistPageName() {
        return existPageName;
    }

    public void setExistPageName(String existPageName) {
        this.existPageName = existPageName;
    }

    public String getRequiredName() {
        return requiredName;
    }

    public void setRequiredName(String requiredName) {
        this.requiredName = requiredName;
    }

    public String getListShowableName() {
        return listShowableName;
    }

    public void setListShowableName(String listShowableName) {
        this.listShowableName = listShowableName;
    }
}
