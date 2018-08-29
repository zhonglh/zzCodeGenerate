package com.zz.bsmcc.business;

public class CgBaseBusiness {

    /**
     * 是否第三方的库表
     * @param schema
     * @param table
     * @return
     */
    public boolean isThirdParty(String schema , String table){
        return false;
    }

    /**
     * @param schema
     * @param table
     * @return
     */
    public boolean isComponent(String schema , String table){
        return table.startsWith("tr") || table.startsWith("ts");
    }


}
