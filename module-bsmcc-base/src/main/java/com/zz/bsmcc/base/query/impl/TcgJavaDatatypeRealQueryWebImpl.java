package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 数据类型关联 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-30 17:18:07
 */
public class TcgJavaDatatypeRealQueryWebImpl<PK extends Serializable> extends TcgJavaDatatypeRealAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;










            private String javaType_IN;
            private String javaType_NOTIN;










            private String dataType_IN;
            private String dataType_NOTIN;








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


















                public String getJavaType() {
                    return javaType;
                }


                public void setJavaType(String javaType) {
                    this.javaType = javaType;
                }


                public String getJavaType_NE() {
                    return javaType_NE;
                }


                public void setJavaType_NE(String javaType_NE) {
                    this.javaType_NE = javaType_NE;
                }



                public String getJavaType_IN() {
                    return javaType_IN;
                }

                public void setJavaType_IN(String javaType_IN) {
                    this.javaType_IN = javaType_IN;
                }

                public String getJavaType_NOTIN() {
                    return javaType_NOTIN;
                }

                public void setJavaType_NOTIN(String javaType_NOTIN) {
                    this.javaType_NOTIN = javaType_NOTIN;
                }




                public String getJavaType_LIKE() {
                    return javaType_LIKE;
                }

                public void setJavaType_LIKE(String javaType_LIKE) {
                    this.javaType_LIKE = javaType_LIKE;
                }

                public String getJavaType_NOTLIKE() {
                    return javaType_NOTLIKE;
                }

                public void setJavaType_NOTLIKE(String javaType_NOTLIKE) {
                    this.javaType_NOTLIKE = javaType_NOTLIKE;
                }















                public String getDataType() {
                    return dataType;
                }


                public void setDataType(String dataType) {
                    this.dataType = dataType;
                }


                public String getDataType_NE() {
                    return dataType_NE;
                }


                public void setDataType_NE(String dataType_NE) {
                    this.dataType_NE = dataType_NE;
                }



                public String getDataType_IN() {
                    return dataType_IN;
                }

                public void setDataType_IN(String dataType_IN) {
                    this.dataType_IN = dataType_IN;
                }

                public String getDataType_NOTIN() {
                    return dataType_NOTIN;
                }

                public void setDataType_NOTIN(String dataType_NOTIN) {
                    this.dataType_NOTIN = dataType_NOTIN;
                }




                public String getDataType_LIKE() {
                    return dataType_LIKE;
                }

                public void setDataType_LIKE(String dataType_LIKE) {
                    this.dataType_LIKE = dataType_LIKE;
                }

                public String getDataType_NOTLIKE() {
                    return dataType_NOTLIKE;
                }

                public void setDataType_NOTLIKE(String dataType_NOTLIKE) {
                    this.dataType_NOTLIKE = dataType_NOTLIKE;
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