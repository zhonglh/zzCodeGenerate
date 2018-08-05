package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 列校验 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:58
 */
public class TcgColumnValidateQueryWebImpl<PK extends Serializable> extends TcgColumnValidateAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK tableId_IN;
            private PK tableId_NOTIN;











            private PK columnId_IN;
            private PK columnId_NOTIN;










            private String rex_IN;
            private String rex_NOTIN;










            private String msg_IN;
            private String msg_NOTIN;








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


















                public String getRex() {
                    return rex;
                }


                public void setRex(String rex) {
                    this.rex = rex;
                }


                public String getRex_NE() {
                    return rex_NE;
                }


                public void setRex_NE(String rex_NE) {
                    this.rex_NE = rex_NE;
                }



                public String getRex_IN() {
                    return rex_IN;
                }

                public void setRex_IN(String rex_IN) {
                    this.rex_IN = rex_IN;
                }

                public String getRex_NOTIN() {
                    return rex_NOTIN;
                }

                public void setRex_NOTIN(String rex_NOTIN) {
                    this.rex_NOTIN = rex_NOTIN;
                }




                public String getRex_LIKE() {
                    return rex_LIKE;
                }

                public void setRex_LIKE(String rex_LIKE) {
                    this.rex_LIKE = rex_LIKE;
                }

                public String getRex_NOTLIKE() {
                    return rex_NOTLIKE;
                }

                public void setRex_NOTLIKE(String rex_NOTLIKE) {
                    this.rex_NOTLIKE = rex_NOTLIKE;
                }















                public String getMsg() {
                    return msg;
                }


                public void setMsg(String msg) {
                    this.msg = msg;
                }


                public String getMsg_NE() {
                    return msg_NE;
                }


                public void setMsg_NE(String msg_NE) {
                    this.msg_NE = msg_NE;
                }



                public String getMsg_IN() {
                    return msg_IN;
                }

                public void setMsg_IN(String msg_IN) {
                    this.msg_IN = msg_IN;
                }

                public String getMsg_NOTIN() {
                    return msg_NOTIN;
                }

                public void setMsg_NOTIN(String msg_NOTIN) {
                    this.msg_NOTIN = msg_NOTIN;
                }




                public String getMsg_LIKE() {
                    return msg_LIKE;
                }

                public void setMsg_LIKE(String msg_LIKE) {
                    this.msg_LIKE = msg_LIKE;
                }

                public String getMsg_NOTLIKE() {
                    return msg_NOTLIKE;
                }

                public void setMsg_NOTLIKE(String msg_NOTLIKE) {
                    this.msg_NOTLIKE = msg_NOTLIKE;
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