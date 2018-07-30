package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表操作定义 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-30 17:18:08
 */
public class TcgTableOperationQueryWebImpl<PK extends Serializable> extends TcgTableOperationAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK operationId_IN;
            private PK operationId_NOTIN;











            private PK tableId_IN;
            private PK tableId_NOTIN;
























                public PK getId() {
                    return id;
                }


                public void setId(PK id) {
                    this.id = id;
                }


                public PK getId_NE() {
                return id_NE;
                }


                public void setId_NE(PK id_NE) {
                this.id_NE = id_NE;
                }








                public PK getId_IN() {
                    return id_IN;
                }

                public void setId_IN(PK id_IN) {
                    this.id_IN = id_IN;
                }

                public PK getId_NOTIN() {
                    return id_NOTIN;
                }

                public void setId_NOTIN(PK id_NOTIN) {
                    this.id_NOTIN = id_NOTIN;
                }


















                public PK getOperationId() {
                    return operationId;
                }


                public void setOperationId(PK operationId) {
                    this.operationId = operationId;
                }


                public PK getOperationId_NE() {
                return operationId_NE;
                }


                public void setOperationId_NE(PK operationId_NE) {
                this.operationId_NE = operationId_NE;
                }








                public PK getOperationId_IN() {
                    return operationId_IN;
                }

                public void setOperationId_IN(PK operationId_IN) {
                    this.operationId_IN = operationId_IN;
                }

                public PK getOperationId_NOTIN() {
                    return operationId_NOTIN;
                }

                public void setOperationId_NOTIN(PK operationId_NOTIN) {
                    this.operationId_NOTIN = operationId_NOTIN;
                }


















                public PK getTableId() {
                    return tableId;
                }


                public void setTableId(PK tableId) {
                    this.tableId = tableId;
                }


                public PK getTableId_NE() {
                return tableId_NE;
                }


                public void setTableId_NE(PK tableId_NE) {
                this.tableId_NE = tableId_NE;
                }








                public PK getTableId_IN() {
                    return tableId_IN;
                }

                public void setTableId_IN(PK tableId_IN) {
                    this.tableId_IN = tableId_IN;
                }

                public PK getTableId_NOTIN() {
                    return tableId_NOTIN;
                }

                public void setTableId_NOTIN(PK tableId_NOTIN) {
                    this.tableId_NOTIN = tableId_NOTIN;
                }










	
}