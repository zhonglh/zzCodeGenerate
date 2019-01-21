package com.zz.bsmcc.core.enums;


import com.zz.bms.core.enums.EnumBase;

import java.io.Serializable;

/**
 * 页面关系
 * 字表或副表界面 和主表 界面的关系
 * @author Administrator
 */
public enum EnumPageRelation implements EnumBase<String> {


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
    public String getVal(){
        return code;
    }

    @Override
    public String getLabel(){
        return title;
    }


    @Override
    public String getValue(){
        return code;
    }



    @Override
    public EnumPageRelation getEnum(String v){
        return EnumPageRelation.getEnumByValue(v);
    }

    public static EnumPageRelation getEnumByValue(String v){
        for(EnumPageRelation enum1 : EnumPageRelation.values()){
            if(enum1.getVal().equals(v)){
                return enum1;
            }
        }
        return  null;
    }

}
