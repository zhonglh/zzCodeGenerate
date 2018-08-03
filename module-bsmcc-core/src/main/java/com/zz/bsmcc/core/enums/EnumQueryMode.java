package com.zz.bsmcc.core.enums;


import java.io.Serializable;
import com.zz.bms.core.enums.EnumBase;

/**
 * 查询条件  显示模式
 * @author Administrator
 */

public enum EnumQueryMode  implements EnumBase{


    toolbar("toolbar" , "工具栏样式") ,
    ordinary("ordinary" , "普通样式") ,

    ;

    EnumQueryMode(String value, String name) {
        this.value = value;
        this.name = name;
    }

    String value ;
    String name ;


    @Override
    public Serializable getTheValue() {
        return value;
    }

    @Override
    public String getTheName() {
        return name;
    }

    public static EnumQueryMode getQueryModeByValue(String v){

        for(EnumQueryMode qm : EnumQueryMode.values()){
            if(qm.getTheValue().equals(v)){
                return qm;
            }
        }
        return null;
    }




}
