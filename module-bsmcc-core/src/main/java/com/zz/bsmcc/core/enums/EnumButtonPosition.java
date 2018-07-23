package com.zz.bsmcc.core.enums;

import java.io.Serializable;

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
    public Serializable getTheValue() {
        return name();
    }

    @Override
    public String getTheName() {
        return title;
    }
}
