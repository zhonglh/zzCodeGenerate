package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 查询条件设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:16
 */
public class TcgQueryConfigQueryWebImpl<PK extends Serializable> extends TcgQueryConfigAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK tableId_IN;
            private PK tableId_NOTIN;











            private PK columnId_IN;
            private PK columnId_NOTIN;










            private String queryTitle_IN;
            private String queryTitle_NOTIN;










            private String queryPlaceholder_IN;
            private String queryPlaceholder_NOTIN;










            private String queryRelation_IN;
            private String queryRelation_NOTIN;








        ;







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


















                public String getQueryTitle() {
                    return queryTitle;
                }


                public void setQueryTitle(String queryTitle) {
                    this.queryTitle = queryTitle;
                }


                public String getQueryTitle_NE() {
                    return queryTitle_NE;
                }


                public void setQueryTitle_NE(String queryTitle_NE) {
                    this.queryTitle_NE = queryTitle_NE;
                }



                public String getQueryTitle_IN() {
                    return queryTitle_IN;
                }

                public void setQueryTitle_IN(String queryTitle_IN) {
                    this.queryTitle_IN = queryTitle_IN;
                }

                public String getQueryTitle_NOTIN() {
                    return queryTitle_NOTIN;
                }

                public void setQueryTitle_NOTIN(String queryTitle_NOTIN) {
                    this.queryTitle_NOTIN = queryTitle_NOTIN;
                }




                public String getQueryTitle_LIKE() {
                    return queryTitle_LIKE;
                }

                public void setQueryTitle_LIKE(String queryTitle_LIKE) {
                    this.queryTitle_LIKE = queryTitle_LIKE;
                }

                public String getQueryTitle_NOTLIKE() {
                    return queryTitle_NOTLIKE;
                }

                public void setQueryTitle_NOTLIKE(String queryTitle_NOTLIKE) {
                    this.queryTitle_NOTLIKE = queryTitle_NOTLIKE;
                }















                public String getQueryPlaceholder() {
                    return queryPlaceholder;
                }


                public void setQueryPlaceholder(String queryPlaceholder) {
                    this.queryPlaceholder = queryPlaceholder;
                }


                public String getQueryPlaceholder_NE() {
                    return queryPlaceholder_NE;
                }


                public void setQueryPlaceholder_NE(String queryPlaceholder_NE) {
                    this.queryPlaceholder_NE = queryPlaceholder_NE;
                }



                public String getQueryPlaceholder_IN() {
                    return queryPlaceholder_IN;
                }

                public void setQueryPlaceholder_IN(String queryPlaceholder_IN) {
                    this.queryPlaceholder_IN = queryPlaceholder_IN;
                }

                public String getQueryPlaceholder_NOTIN() {
                    return queryPlaceholder_NOTIN;
                }

                public void setQueryPlaceholder_NOTIN(String queryPlaceholder_NOTIN) {
                    this.queryPlaceholder_NOTIN = queryPlaceholder_NOTIN;
                }




                public String getQueryPlaceholder_LIKE() {
                    return queryPlaceholder_LIKE;
                }

                public void setQueryPlaceholder_LIKE(String queryPlaceholder_LIKE) {
                    this.queryPlaceholder_LIKE = queryPlaceholder_LIKE;
                }

                public String getQueryPlaceholder_NOTLIKE() {
                    return queryPlaceholder_NOTLIKE;
                }

                public void setQueryPlaceholder_NOTLIKE(String queryPlaceholder_NOTLIKE) {
                    this.queryPlaceholder_NOTLIKE = queryPlaceholder_NOTLIKE;
                }















                public String getQueryRelation() {
                    return queryRelation;
                }


                public void setQueryRelation(String queryRelation) {
                    this.queryRelation = queryRelation;
                }


                public String getQueryRelation_NE() {
                    return queryRelation_NE;
                }


                public void setQueryRelation_NE(String queryRelation_NE) {
                    this.queryRelation_NE = queryRelation_NE;
                }



                public String getQueryRelation_IN() {
                    return queryRelation_IN;
                }

                public void setQueryRelation_IN(String queryRelation_IN) {
                    this.queryRelation_IN = queryRelation_IN;
                }

                public String getQueryRelation_NOTIN() {
                    return queryRelation_NOTIN;
                }

                public void setQueryRelation_NOTIN(String queryRelation_NOTIN) {
                    this.queryRelation_NOTIN = queryRelation_NOTIN;
                }




                public String getQueryRelation_LIKE() {
                    return queryRelation_LIKE;
                }

                public void setQueryRelation_LIKE(String queryRelation_LIKE) {
                    this.queryRelation_LIKE = queryRelation_LIKE;
                }

                public String getQueryRelation_NOTLIKE() {
                    return queryRelation_NOTLIKE;
                }

                public void setQueryRelation_NOTLIKE(String queryRelation_NOTLIKE) {
                    this.queryRelation_NOTLIKE = queryRelation_NOTLIKE;
                }












            public Integer getQuerySort() {
                return querySort;
            }


            public void setQuerySort(Integer querySort) {
                this.querySort = querySort;
            }


            public Integer getQuerySort_NE() {
                return querySort_NE;
            }


            public void setQuerySort_NE(Integer querySort_NE) {
                this.querySort_NE = querySort_NE;
            }



            public Integer getQuerySort_GT() {
                return querySort_GT;
            }


            public void setQuerySort_GT(Integer querySort_GT) {
                this.querySort_GT = querySort_GT;
            }


            public Integer getQuerySort_GE() {
                return querySort_GE;
            }


            public void setQuerySort_GE(Integer querySort_GE) {
                this.querySort_GE = querySort_GE;
            }




            public Integer getQuerySort_LT() {
                return querySort_LT;
            }


            public void setQuerySort_LT(Integer querySort_LT) {
                this.querySort_LT = querySort_LT;
            }


            public Integer getQuerySort_LE() {
                return querySort_LE;
            }


            public void setQuerySort_LE(Integer querySort_LE) {
                this.querySort_LE = querySort_LE;
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