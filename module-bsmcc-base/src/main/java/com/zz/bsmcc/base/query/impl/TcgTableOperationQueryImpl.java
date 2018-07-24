package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgTableOperationQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 表操作定义 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 12:32:16
 */
public class TcgTableOperationQueryImpl<PK extends Serializable> extends TcgTableOperationAbstractQueryImpl<PK> implements TcgTableOperationQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> operationId_IN;
            private List<PK> operationId_NOTIN;













            private List<PK> tableId_IN;
            private List<PK> tableId_NOTIN;
























                @Override
                public TcgTableOperationQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgTableOperationQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgTableOperationQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgTableOperationQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableOperationQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgTableOperationQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgTableOperationQuery operationId(PK operationId) {
                    if(!IdUtils.isEmpty(operationId)){
                        this.operationId = operationId;
                    }
                    return this;
                }


                @Override
                public TcgTableOperationQuery operationIdNot(PK operationIdNot) {
                    if(!IdUtils.isEmpty(operationIdNot)){
                        this.operationId_NE = operationIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTableOperationQuery operationIdIn(PK operationIdIn) {
                    if(!IdUtils.isEmpty(operationIdIn)){
                        this.operationId_IN.add( operationIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTableOperationQuery operationIdNotIn(PK operationIdNotIn) {
                    if(!IdUtils.isEmpty(operationIdNotIn)){
                        this.operationId_NOTIN.add( operationIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableOperationQuery operationIdIsNull() {
                    this.isNulls.add("operationId");
                    return this;
                }



                @Override
                public TcgTableOperationQuery operationIdIsNotNull() {
                    this.isNotNulls.add("operationId");
                    return this;
                }















                @Override
                public TcgTableOperationQuery tableId(PK tableId) {
                    if(!IdUtils.isEmpty(tableId)){
                        this.tableId = tableId;
                    }
                    return this;
                }


                @Override
                public TcgTableOperationQuery tableIdNot(PK tableIdNot) {
                    if(!IdUtils.isEmpty(tableIdNot)){
                        this.tableId_NE = tableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTableOperationQuery tableIdIn(PK tableIdIn) {
                    if(!IdUtils.isEmpty(tableIdIn)){
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTableOperationQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
                        this.tableId_NOTIN.add( tableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableOperationQuery tableIdIsNull() {
                    this.isNulls.add("tableId");
                    return this;
                }



                @Override
                public TcgTableOperationQuery tableIdIsNotNull() {
                    this.isNotNulls.add("tableId");
                    return this;
                }










	
}