package com.zz.bsmcc.core.enums;


import java.io.Serializable;

/**
 * 界面元素
 * @author Administrator
 */
public enum EnumPageElement implements EnumBase{

    text("input","text" , "文本") ,
    digits("input","integer" , "整数") ,
    number("input","number" , "数字") ,
    date("input","date" , "日期") ,
    timestamp("input","timestamp" , "时间") ,
    email("input","email" , "邮件") ,
    url("input","url" ,"网址"),
    creditcard("input","creditcard" ,"信用卡"),

    radio("input","radio" ,"单选"),
    checkbox("input","checkbox" ,"多选"),


    textarea("textarea","textarea" ,"文本域"),
    select("select","select" ,"下拉选择"),

    openwin("openwin","openwin" ,"弹框选择"),

    singlefile("file","singlefile" ,"单文件"),
    multifile("file","multifile" ,"多文件"),

    singleimage("file","singleimage" ,"单图片"),
    multiimage("file","multiimage" ,"多图片"),
    ;

    EnumPageElement(String element ,String value, String name) {
        this.element = element;
        this.value = value;
        this.name = name;
    }

    String element ;
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


    public static EnumPageElement getPageElement(String val){
        try {
            return EnumPageElement.valueOf(val);
        }catch(Exception e){
            return null;
        }
    }




}
