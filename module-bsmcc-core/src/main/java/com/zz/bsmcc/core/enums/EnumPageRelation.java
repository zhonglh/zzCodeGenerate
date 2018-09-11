package com.zz.bsmcc.core.enums;


import com.zz.bms.core.enums.EnumBase;

import java.io.Serializable;

/**
 * 页面关系
 * 字表或副表界面 和主表 界面的关系
 * @author Administrator
 */
public enum EnumPageRelation implements EnumBase {


    embed("1","嵌入") ,
    alone("2","单独")
    ;


    private String code;
    private String title ;

    EnumPageRelation(String code,String title) {
        this.code = code;
        this.title = title;
    }


    @Override
    public Serializable getTheValue() {
        return code;
    }

    @Override
    public String getTheName() {
        return title;
    }
}
