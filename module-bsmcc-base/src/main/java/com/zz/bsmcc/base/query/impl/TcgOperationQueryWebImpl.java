package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 操作表 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-30 17:18:07
 */
public class TcgOperationQueryWebImpl<PK extends Serializable> extends TcgOperationAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;










            private String operationName_IN;
            private String operationName_NOTIN;










            private String operationResource_IN;
            private String operationResource_NOTIN;








        ;










            private PK createUserId_IN;
            private PK createUserId_NOTIN;








        ;










            private PK updateUserId_IN;
            private PK updateUserId_NOTIN;








        ;










            private String deleteFlag_IN;
            private String deleteFlag_NOTIN;

























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


















                public String getOperationName() {
                    return operationName;
                }


                public void setOperationName(String operationName) {
                    this.operationName = operationName;
                }


                public String getOperationName_NE() {
                    return operationName_NE;
                }


                public void setOperationName_NE(String operationName_NE) {
                    this.operationName_NE = operationName_NE;
                }



                public String getOperationName_IN() {
                    return operationName_IN;
                }

                public void setOperationName_IN(String operationName_IN) {
                    this.operationName_IN = operationName_IN;
                }

                public String getOperationName_NOTIN() {
                    return operationName_NOTIN;
                }

                public void setOperationName_NOTIN(String operationName_NOTIN) {
                    this.operationName_NOTIN = operationName_NOTIN;
                }




                public String getOperationName_LIKE() {
                    return operationName_LIKE;
                }

                public void setOperationName_LIKE(String operationName_LIKE) {
                    this.operationName_LIKE = operationName_LIKE;
                }

                public String getOperationName_NOTLIKE() {
                    return operationName_NOTLIKE;
                }

                public void setOperationName_NOTLIKE(String operationName_NOTLIKE) {
                    this.operationName_NOTLIKE = operationName_NOTLIKE;
                }















                public String getOperationResource() {
                    return operationResource;
                }


                public void setOperationResource(String operationResource) {
                    this.operationResource = operationResource;
                }


                public String getOperationResource_NE() {
                    return operationResource_NE;
                }


                public void setOperationResource_NE(String operationResource_NE) {
                    this.operationResource_NE = operationResource_NE;
                }



                public String getOperationResource_IN() {
                    return operationResource_IN;
                }

                public void setOperationResource_IN(String operationResource_IN) {
                    this.operationResource_IN = operationResource_IN;
                }

                public String getOperationResource_NOTIN() {
                    return operationResource_NOTIN;
                }

                public void setOperationResource_NOTIN(String operationResource_NOTIN) {
                    this.operationResource_NOTIN = operationResource_NOTIN;
                }




                public String getOperationResource_LIKE() {
                    return operationResource_LIKE;
                }

                public void setOperationResource_LIKE(String operationResource_LIKE) {
                    this.operationResource_LIKE = operationResource_LIKE;
                }

                public String getOperationResource_NOTLIKE() {
                    return operationResource_NOTLIKE;
                }

                public void setOperationResource_NOTLIKE(String operationResource_NOTLIKE) {
                    this.operationResource_NOTLIKE = operationResource_NOTLIKE;
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















                public String getDeleteFlag() {
                    return deleteFlag;
                }


                public void setDeleteFlag(String deleteFlag) {
                    this.deleteFlag = deleteFlag;
                }


                public String getDeleteFlag_NE() {
                    return deleteFlag_NE;
                }


                public void setDeleteFlag_NE(String deleteFlag_NE) {
                    this.deleteFlag_NE = deleteFlag_NE;
                }



                public String getDeleteFlag_IN() {
                    return deleteFlag_IN;
                }

                public void setDeleteFlag_IN(String deleteFlag_IN) {
                    this.deleteFlag_IN = deleteFlag_IN;
                }

                public String getDeleteFlag_NOTIN() {
                    return deleteFlag_NOTIN;
                }

                public void setDeleteFlag_NOTIN(String deleteFlag_NOTIN) {
                    this.deleteFlag_NOTIN = deleteFlag_NOTIN;
                }








	
}