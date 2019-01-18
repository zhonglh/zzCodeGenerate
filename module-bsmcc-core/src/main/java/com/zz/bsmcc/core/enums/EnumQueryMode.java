package com.zz.bsmcc.core.enums;


import java.io.Serializable;
import com.zz.bms.core.enums.EnumBase;

/**
 * 查询条件  显示模式
 * @author Administrator
 */

public enum EnumQueryMode  implements EnumBase<String>{


    toolbar("toolbar" , "工具栏样式") ,
    ordinary("ordinary" , "普通样式") ,

    ;

    EnumQueryMode(String value, String name) {
        this.value = value;
        this.name = name;
    }

    String value ;
    String name ;



    public static EnumQueryMode getQueryModeByValue(String v){

        for(EnumQueryMode qm : EnumQueryMode.values()){
            if(qm.value.equals(v)){
                return qm;
            }
        }
        return null;
    }

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


}
