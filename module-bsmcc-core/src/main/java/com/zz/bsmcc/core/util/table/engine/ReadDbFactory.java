package com.zz.bsmcc.core.util.table.engine;

import com.zz.bms.core.exceptions.InternalException;
import com.zz.bsmcc.core.enums.EnumDbType;
import com.zz.bsmcc.core.util.table.engine.impl.MySqlReadDbProcess;

/**
 * 数据库读取器工厂
 * @author Administrator
 */
public class ReadDbFactory {

    public static ReadDbProcess buildReadDbProcess(String dbType){
        EnumDbType db = EnumDbType.getEnumDbType(dbType);
        if(db == EnumDbType.mysql){
            return new MySqlReadDbProcess();
        }
        throw new InternalException("数据库类型错误 , 目前只支持MySQL数据库");
    }

}
