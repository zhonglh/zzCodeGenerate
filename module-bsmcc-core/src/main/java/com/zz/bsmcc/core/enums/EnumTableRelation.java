package com.zz.bsmcc.core.enums;

import java.io.Serializable;

/**
 * 表关系
 * @author Administrator
 */

public enum EnumTableRelation implements EnumBase {

    one2one("一对一") ,
    one2multi("一对多") ,

    ;

    EnumTableRelation( String name) {
        this.name = name;
    }

    String name ;

    @Override
    public Serializable getTheValue() {
        return this.name();
    }

    @Override
    public String getTheName() {
        return this.name;
    }
}
