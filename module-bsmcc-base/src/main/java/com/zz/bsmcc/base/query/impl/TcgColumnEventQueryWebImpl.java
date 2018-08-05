package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 列事件 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:57
 */
public class TcgColumnEventQueryWebImpl<PK extends Serializable> extends TcgColumnEventAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK tableId_IN;
            private PK tableId_NOTIN;











            private PK columnId_IN;
            private PK columnId_NOTIN;










            private String eventName_IN;
            private String eventName_NOTIN;










            private String funcName_IN;
            private String funcName_NOTIN;










            private String funcParam_IN;
            private String funcParam_NOTIN;










            private String funcBody_IN;
            private String funcBody_NOTIN;








        ;










            private PK createUserId_IN;
            private PK createUserId_NOTIN;








        ;










            private PK updateUserId_IN;
            private PK updateUserId_NOTIN;








        ;























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


















                public PK getColumnId() {
                    return columnId;
                }


                public void setColumnId(PK columnId) {
                    this.columnId = columnId;
                }


                public PK getColumnId_NE() {
                return columnId_NE;
                }


                public void setColumnId_NE(PK columnId_NE) {
                this.columnId_NE = columnId_NE;
                }








                public PK getColumnId_IN() {
                    return columnId_IN;
                }

                public void setColumnId_IN(PK columnId_IN) {
                    this.columnId_IN = columnId_IN;
                }

                public PK getColumnId_NOTIN() {
                    return columnId_NOTIN;
                }

                public void setColumnId_NOTIN(PK columnId_NOTIN) {
                    this.columnId_NOTIN = columnId_NOTIN;
                }


















                public String getEventName() {
                    return eventName;
                }


                public void setEventName(String eventName) {
                    this.eventName = eventName;
                }


                public String getEventName_NE() {
                    return eventName_NE;
                }


                public void setEventName_NE(String eventName_NE) {
                    this.eventName_NE = eventName_NE;
                }



                public String getEventName_IN() {
                    return eventName_IN;
                }

                public void setEventName_IN(String eventName_IN) {
                    this.eventName_IN = eventName_IN;
                }

                public String getEventName_NOTIN() {
                    return eventName_NOTIN;
                }

                public void setEventName_NOTIN(String eventName_NOTIN) {
                    this.eventName_NOTIN = eventName_NOTIN;
                }




                public String getEventName_LIKE() {
                    return eventName_LIKE;
                }

                public void setEventName_LIKE(String eventName_LIKE) {
                    this.eventName_LIKE = eventName_LIKE;
                }

                public String getEventName_NOTLIKE() {
                    return eventName_NOTLIKE;
                }

                public void setEventName_NOTLIKE(String eventName_NOTLIKE) {
                    this.eventName_NOTLIKE = eventName_NOTLIKE;
                }















                public String getFuncName() {
                    return funcName;
                }


                public void setFuncName(String funcName) {
                    this.funcName = funcName;
                }


                public String getFuncName_NE() {
                    return funcName_NE;
                }


                public void setFuncName_NE(String funcName_NE) {
                    this.funcName_NE = funcName_NE;
                }



                public String getFuncName_IN() {
                    return funcName_IN;
                }

                public void setFuncName_IN(String funcName_IN) {
                    this.funcName_IN = funcName_IN;
                }

                public String getFuncName_NOTIN() {
                    return funcName_NOTIN;
                }

                public void setFuncName_NOTIN(String funcName_NOTIN) {
                    this.funcName_NOTIN = funcName_NOTIN;
                }




                public String getFuncName_LIKE() {
                    return funcName_LIKE;
                }

                public void setFuncName_LIKE(String funcName_LIKE) {
                    this.funcName_LIKE = funcName_LIKE;
                }

                public String getFuncName_NOTLIKE() {
                    return funcName_NOTLIKE;
                }

                public void setFuncName_NOTLIKE(String funcName_NOTLIKE) {
                    this.funcName_NOTLIKE = funcName_NOTLIKE;
                }















                public String getFuncParam() {
                    return funcParam;
                }


                public void setFuncParam(String funcParam) {
                    this.funcParam = funcParam;
                }


                public String getFuncParam_NE() {
                    return funcParam_NE;
                }


                public void setFuncParam_NE(String funcParam_NE) {
                    this.funcParam_NE = funcParam_NE;
                }



                public String getFuncParam_IN() {
                    return funcParam_IN;
                }

                public void setFuncParam_IN(String funcParam_IN) {
                    this.funcParam_IN = funcParam_IN;
                }

                public String getFuncParam_NOTIN() {
                    return funcParam_NOTIN;
                }

                public void setFuncParam_NOTIN(String funcParam_NOTIN) {
                    this.funcParam_NOTIN = funcParam_NOTIN;
                }




                public String getFuncParam_LIKE() {
                    return funcParam_LIKE;
                }

                public void setFuncParam_LIKE(String funcParam_LIKE) {
                    this.funcParam_LIKE = funcParam_LIKE;
                }

                public String getFuncParam_NOTLIKE() {
                    return funcParam_NOTLIKE;
                }

                public void setFuncParam_NOTLIKE(String funcParam_NOTLIKE) {
                    this.funcParam_NOTLIKE = funcParam_NOTLIKE;
                }















                public String getFuncBody() {
                    return funcBody;
                }


                public void setFuncBody(String funcBody) {
                    this.funcBody = funcBody;
                }


                public String getFuncBody_NE() {
                    return funcBody_NE;
                }


                public void setFuncBody_NE(String funcBody_NE) {
                    this.funcBody_NE = funcBody_NE;
                }



                public String getFuncBody_IN() {
                    return funcBody_IN;
                }

                public void setFuncBody_IN(String funcBody_IN) {
                    this.funcBody_IN = funcBody_IN;
                }

                public String getFuncBody_NOTIN() {
                    return funcBody_NOTIN;
                }

                public void setFuncBody_NOTIN(String funcBody_NOTIN) {
                    this.funcBody_NOTIN = funcBody_NOTIN;
                }




                public String getFuncBody_LIKE() {
                    return funcBody_LIKE;
                }

                public void setFuncBody_LIKE(String funcBody_LIKE) {
                    this.funcBody_LIKE = funcBody_LIKE;
                }

                public String getFuncBody_NOTLIKE() {
                    return funcBody_NOTLIKE;
                }

                public void setFuncBody_NOTLIKE(String funcBody_NOTLIKE) {
                    this.funcBody_NOTLIKE = funcBody_NOTLIKE;
                }













            public Timestamp getCreateTime() {
                return createTime;
            }


            public void setCreateTime(Timestamp createTime) {
                this.createTime = createTime;
            }


            public Timestamp getCreateTime_NE() {
                return createTime_NE;
            }


            public void setCreateTime_NE(Timestamp createTime_NE) {
                this.createTime_NE = createTime_NE;
            }



            public Timestamp getCreateTime_GT() {
                return createTime_GT;
            }


            public void setCreateTime_GT(Timestamp createTime_GT) {
                this.createTime_GT = createTime_GT;
            }


            public Timestamp getCreateTime_GE() {
                return createTime_GE;
            }


            public void setCreateTime_GE(Timestamp createTime_GE) {
                this.createTime_GE = createTime_GE;
            }




            public Timestamp getCreateTime_LT() {
                return createTime_LT;
            }


            public void setCreateTime_LT(Timestamp createTime_LT) {
                this.createTime_LT = createTime_LT;
            }


            public Timestamp getCreateTime_LE() {
                return createTime_LE;
            }


            public void setCreateTime_LE(Timestamp createTime_LE) {
                this.createTime_LE = createTime_LE;
            }













                public PK getCreateUserId() {
                    return createUserId;
                }


                public void setCreateUserId(PK createUserId) {
                    this.createUserId = createUserId;
                }


                public PK getCreateUserId_NE() {
                return createUserId_NE;
                }


                public void setCreateUserId_NE(PK createUserId_NE) {
                this.createUserId_NE = createUserId_NE;
                }








                public PK getCreateUserId_IN() {
                    return createUserId_IN;
                }

                public void setCreateUserId_IN(PK createUserId_IN) {
                    this.createUserId_IN = createUserId_IN;
                }

                public PK getCreateUserId_NOTIN() {
                    return createUserId_NOTIN;
                }

                public void setCreateUserId_NOTIN(PK createUserId_NOTIN) {
                    this.createUserId_NOTIN = createUserId_NOTIN;
                }
















            public Timestamp getUpdateTime() {
                return updateTime;
            }


            public void setUpdateTime(Timestamp updateTime) {
                this.updateTime = updateTime;
            }


            public Timestamp getUpdateTime_NE() {
                return updateTime_NE;
            }


            public void setUpdateTime_NE(Timestamp updateTime_NE) {
                this.updateTime_NE = updateTime_NE;
            }



            public Timestamp getUpdateTime_GT() {
                return updateTime_GT;
            }


            public void setUpdateTime_GT(Timestamp updateTime_GT) {
                this.updateTime_GT = updateTime_GT;
            }


            public Timestamp getUpdateTime_GE() {
                return updateTime_GE;
            }


            public void setUpdateTime_GE(Timestamp updateTime_GE) {
                this.updateTime_GE = updateTime_GE;
            }




            public Timestamp getUpdateTime_LT() {
                return updateTime_LT;
            }


            public void setUpdateTime_LT(Timestamp updateTime_LT) {
                this.updateTime_LT = updateTime_LT;
            }


            public Timestamp getUpdateTime_LE() {
                return updateTime_LE;
            }


            public void setUpdateTime_LE(Timestamp updateTime_LE) {
                this.updateTime_LE = updateTime_LE;
            }













                public PK getUpdateUserId() {
                    return updateUserId;
                }


                public void setUpdateUserId(PK updateUserId) {
                    this.updateUserId = updateUserId;
                }


                public PK getUpdateUserId_NE() {
                return updateUserId_NE;
                }


                public void setUpdateUserId_NE(PK updateUserId_NE) {
                this.updateUserId_NE = updateUserId_NE;
                }








                public PK getUpdateUserId_IN() {
                    return updateUserId_IN;
                }

                public void setUpdateUserId_IN(PK updateUserId_IN) {
                    this.updateUserId_IN = updateUserId_IN;
                }

                public PK getUpdateUserId_NOTIN() {
                    return updateUserId_NOTIN;
                }

                public void setUpdateUserId_NOTIN(PK updateUserId_NOTIN) {
                    this.updateUserId_NOTIN = updateUserId_NOTIN;
                }















            public Integer getVersionNo() {
                return versionNo;
            }


            public void setVersionNo(Integer versionNo) {
                this.versionNo = versionNo;
            }


            public Integer getVersionNo_NE() {
                return versionNo_NE;
            }


            public void setVersionNo_NE(Integer versionNo_NE) {
                this.versionNo_NE = versionNo_NE;
            }



            public Integer getVersionNo_GT() {
                return versionNo_GT;
            }


            public void setVersionNo_GT(Integer versionNo_GT) {
                this.versionNo_GT = versionNo_GT;
            }


            public Integer getVersionNo_GE() {
                return versionNo_GE;
            }


            public void setVersionNo_GE(Integer versionNo_GE) {
                this.versionNo_GE = versionNo_GE;
            }




            public Integer getVersionNo_LT() {
                return versionNo_LT;
            }


            public void setVersionNo_LT(Integer versionNo_LT) {
                this.versionNo_LT = versionNo_LT;
            }


            public Integer getVersionNo_LE() {
                return versionNo_LE;
            }


            public void setVersionNo_LE(Integer versionNo_LE) {
                this.versionNo_LE = versionNo_LE;
            }







	
}