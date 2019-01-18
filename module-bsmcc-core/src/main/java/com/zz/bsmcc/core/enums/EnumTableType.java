package com.zz.bsmcc.core.enums;

import java.io.Serializable;
import com.zz.bms.core.enums.EnumBase;

/**
 * 表类型
 * @author Administrator
 */

public enum EnumTableType implements EnumBase<String> {

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
    public String getVal(){
        return value;
    }

    @Override
    public String getLabel(){
        return name;
    }


    @Override
    public String getValue(){
        return value;
    }


    public static EnumTableType getTableTypeByValue(String val){
        for(EnumTableType type : EnumTableType.values()){
            if(val.equals(type.value)){
                return  type;
            }
        }
        return null;
    }
}
