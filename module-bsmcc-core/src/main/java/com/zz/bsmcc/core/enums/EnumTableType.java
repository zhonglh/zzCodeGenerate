package com.zz.bsmcc.core.enums;

import java.io.Serializable;

/**
 * 表类型
 * @author Administrator
 */

public enum EnumTableType implements EnumBase {

    singleTable("1" , "单表") ,
    mainTable("2" , "主表") ,
    attachTable("3" , "副表") ,
    childTable("4" , "字表") ,

    ;

    EnumTableType(String value, String name) {
        this.value = value;
        this.name = name;
    }

    String value ;
    String name ;

    @Override
    public Serializable getTheValue() {
        return null;
    }

    @Override
    public String getTheName() {
        return null;
    }
}
