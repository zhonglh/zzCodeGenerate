package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgExColumnEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 扩展列设置 BO , 扩展 扩展列设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="扩展列设置" , resource = "")
@TableName(value="tcg_ex_column" , resultMap = "TcgExColumnResultMap")
public class TcgExColumnBO extends TcgExColumnEntity implements Serializable {

    private String originalColumnFkName ;

    private String originalColumnDictName;


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
}
