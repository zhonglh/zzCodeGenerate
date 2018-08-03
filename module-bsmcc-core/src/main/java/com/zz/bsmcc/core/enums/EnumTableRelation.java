package com.zz.bsmcc.core.enums;

import java.io.Serializable;
import com.zz.bms.core.enums.EnumBase;

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

    public static EnumTableRelation getTableRelationByValue(String v){
        for(EnumTableRelation relation : EnumTableRelation.values()){
            if(relation.getTheValue().equals(v)){
                return relation;
            }
        }
        return null;
    }
}
