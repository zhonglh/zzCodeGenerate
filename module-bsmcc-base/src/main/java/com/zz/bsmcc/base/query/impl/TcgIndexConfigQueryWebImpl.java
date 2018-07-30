package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 索引设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-30 17:18:07
 */
public class TcgIndexConfigQueryWebImpl<PK extends Serializable> extends TcgIndexConfigAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK tableId_IN;
            private PK tableId_NOTIN;










            private String indexName_IN;
            private String indexName_NOTIN;










            private String indexCloumns_IN;
            private String indexCloumns_NOTIN;








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


















                public String getIndexName() {
                    return indexName;
                }


                public void setIndexName(String indexName) {
                    this.indexName = indexName;
                }


                public String getIndexName_NE() {
                    return indexName_NE;
                }


                public void setIndexName_NE(String indexName_NE) {
                    this.indexName_NE = indexName_NE;
                }



                public String getIndexName_IN() {
                    return indexName_IN;
                }

                public void setIndexName_IN(String indexName_IN) {
                    this.indexName_IN = indexName_IN;
                }

                public String getIndexName_NOTIN() {
                    return indexName_NOTIN;
                }

                public void setIndexName_NOTIN(String indexName_NOTIN) {
                    this.indexName_NOTIN = indexName_NOTIN;
                }




                public String getIndexName_LIKE() {
                    return indexName_LIKE;
                }

                public void setIndexName_LIKE(String indexName_LIKE) {
                    this.indexName_LIKE = indexName_LIKE;
                }

                public String getIndexName_NOTLIKE() {
                    return indexName_NOTLIKE;
                }

                public void setIndexName_NOTLIKE(String indexName_NOTLIKE) {
                    this.indexName_NOTLIKE = indexName_NOTLIKE;
                }















                public String getIndexCloumns() {
                    return indexCloumns;
                }


                public void setIndexCloumns(String indexCloumns) {
                    this.indexCloumns = indexCloumns;
                }


                public String getIndexCloumns_NE() {
                    return indexCloumns_NE;
                }


                public void setIndexCloumns_NE(String indexCloumns_NE) {
                    this.indexCloumns_NE = indexCloumns_NE;
                }



                public String getIndexCloumns_IN() {
                    return indexCloumns_IN;
                }

                public void setIndexCloumns_IN(String indexCloumns_IN) {
                    this.indexCloumns_IN = indexCloumns_IN;
                }

                public String getIndexCloumns_NOTIN() {
                    return indexCloumns_NOTIN;
                }

                public void setIndexCloumns_NOTIN(String indexCloumns_NOTIN) {
                    this.indexCloumns_NOTIN = indexCloumns_NOTIN;
                }




                public String getIndexCloumns_LIKE() {
                    return indexCloumns_LIKE;
                }

                public void setIndexCloumns_LIKE(String indexCloumns_LIKE) {
                    this.indexCloumns_LIKE = indexCloumns_LIKE;
                }

                public String getIndexCloumns_NOTLIKE() {
                    return indexCloumns_NOTLIKE;
                }

                public void setIndexCloumns_NOTLIKE(String indexCloumns_NOTLIKE) {
                    this.indexCloumns_NOTLIKE = indexCloumns_NOTLIKE;
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