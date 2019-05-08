package com.zz.bsmcc.core.enums;

import java.io.Serializable;
import com.zz.bms.core.enums.EnumBase;

/**
 * 表关系
 * @author Administrator
 */

public enum EnumTableRelation implements EnumBase<String> {

    one2one("one-one","一对一") ,
    one2multi("one-multi","一对多") ,

    ;

    EnumTableRelation(String code, String name) {
        this.code = code;
        this.name = name;
    }

    String code ;
    String name ;


    @Override
    public String getVal(){
        return this.code;
    }

    @Override
    public String getLabel(){
        return name;
    }


    @Override
    public String getValue(){
        return this.code;
    }




    @Override
    public EnumTableRelation getEnum(String v){
        return EnumTableRelation.getTableRelationByValue(v);
    }

    public static EnumTableRelation getTableRelationByValue(String v){
        for(EnumTableRelation relation : EnumTableRelation.values()){
            if(relation.getVal().equals(v)){
                return relation;
            }
        }
        return null;
    }
}
