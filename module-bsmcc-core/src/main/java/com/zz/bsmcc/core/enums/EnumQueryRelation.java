package com.zz.bsmcc.core.enums;

import java.io.Serializable;

/**
 * 查询关系
 * @author Administrator
 */

public enum EnumQueryRelation implements EnumBase{

    eq("","等于"),
    ne("ne","不等于"),

    gt("gt","大于"),
    ge("ge","大于等于"),
    lt("lt","小于"),
    le("le","小于等于"),

    like("like","模糊匹配"),
    notlike("notlike","模糊不匹配"),
    in("in","IN"),
    notin("notin","NOT IN"),



    between("between" , "范围-左闭右闭"),
    betweenl("betweenl" , "范围-左开右闭"),
    betweenr("betweenr" , "范围-右开左闭"),


    isnull("isnull","为空"),
    isnotnull("isnotnull","不为空"),

    ;

    EnumQueryRelation(String value, String name) {
        this.value = value;
        this.name = name;
    }

    String value ;
    String name ;

    @Override
    public Serializable getTheValue() {
        return name();
    }

    @Override
    public String getTheName() {
        return name;
    }




}
