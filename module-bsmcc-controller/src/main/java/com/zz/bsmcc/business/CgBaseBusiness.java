package com.zz.bsmcc.business;

public class CgBaseBusiness {

    /**
     * 是否第三方的库表
     * @param schemaName
     * @param tableName
     * @return
     */
    public boolean isThirdParty(String schemaName , String tableName){
        return false;
    }

    /**
     * @param schemaName
     * @param tableName
     * @return
     */
    public boolean isComponent(String schemaName , String tableName){
        String table = tableName.toLowerCase();
        return false;
    }


}
