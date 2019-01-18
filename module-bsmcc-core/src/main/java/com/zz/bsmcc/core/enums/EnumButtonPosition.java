package com.zz.bsmcc.core.enums;

import java.io.Serializable;
import com.zz.bms.core.enums.EnumBase;

/**
 * 按钮位置
 * @author Administrator
 */
public enum EnumButtonPosition implements EnumBase{

    top("工具栏"),
    right("操作列"),
    all("全部");


    EnumButtonPosition(String title) {
        this.title = title;
    }

    String title ;


    @Override
    public String getVal(){
        return name();
    }

    @Override
    public String getLabel(){
        return title;
    }


    @Override
    public String getValue(){
        return name();
    }
}
