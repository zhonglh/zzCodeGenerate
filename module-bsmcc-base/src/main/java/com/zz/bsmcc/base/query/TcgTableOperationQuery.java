package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgTableOperationEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 表操作定义查询接口
 *
 * @author Administrator
 * @date 2018-7-24 12:32:16
 */
public interface TcgTableOperationQuery<PK extends Serializable> extends Query<TcgTableOperationEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgTableOperationQuery id(PK id);
            public TcgTableOperationQuery idNot(PK idNot);
            public TcgTableOperationQuery idIn(PK idIn);
            public TcgTableOperationQuery idNotIn(PK idNotIn);
            public TcgTableOperationQuery idIsNull();
            public TcgTableOperationQuery idIsNotNull();












            public TcgTableOperationQuery operationId(PK operationId);
            public TcgTableOperationQuery operationIdNot(PK operationIdNot);
            public TcgTableOperationQuery operationIdIn(PK operationIdIn);
            public TcgTableOperationQuery operationIdNotIn(PK operationIdNotIn);
            public TcgTableOperationQuery operationIdIsNull();
            public TcgTableOperationQuery operationIdIsNotNull();












            public TcgTableOperationQuery tableId(PK tableId);
            public TcgTableOperationQuery tableIdNot(PK tableIdNot);
            public TcgTableOperationQuery tableIdIn(PK tableIdIn);
            public TcgTableOperationQuery tableIdNotIn(PK tableIdNotIn);
            public TcgTableOperationQuery tableIdIsNull();
            public TcgTableOperationQuery tableIdIsNotNull();








	
}