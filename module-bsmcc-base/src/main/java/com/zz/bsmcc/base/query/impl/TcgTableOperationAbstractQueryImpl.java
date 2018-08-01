package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgTableOperationEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表操作定义 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:17
 */
public abstract class TcgTableOperationAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgTableOperationEntity,PK> {






            protected PK id;
            protected PK id_NE;












            protected PK operationId;
            protected PK operationId_NE;












            protected PK tableId;
            protected PK tableId_NE;








	
}