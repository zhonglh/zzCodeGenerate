package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 连接池设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:58
 */
public class TcgDbConfigQueryWebImpl<PK extends Serializable> extends TcgDbConfigAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;










            private String dbType_IN;
            private String dbType_NOTIN;










            private String dbUrl_IN;
            private String dbUrl_NOTIN;










            private String dbUsername_IN;
            private String dbUsername_NOTIN;










            private String dbPassword_IN;
            private String dbPassword_NOTIN;










            private String title_IN;
            private String title_NOTIN;








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


















                public String getDbType() {
                    return dbType;
                }


                public void setDbType(String dbType) {
                    this.dbType = dbType;
                }


                public String getDbType_NE() {
                    return dbType_NE;
                }


                public void setDbType_NE(String dbType_NE) {
                    this.dbType_NE = dbType_NE;
                }



                public String getDbType_IN() {
                    return dbType_IN;
                }

                public void setDbType_IN(String dbType_IN) {
                    this.dbType_IN = dbType_IN;
                }

                public String getDbType_NOTIN() {
                    return dbType_NOTIN;
                }

                public void setDbType_NOTIN(String dbType_NOTIN) {
                    this.dbType_NOTIN = dbType_NOTIN;
                }




                public String getDbType_LIKE() {
                    return dbType_LIKE;
                }

                public void setDbType_LIKE(String dbType_LIKE) {
                    this.dbType_LIKE = dbType_LIKE;
                }

                public String getDbType_NOTLIKE() {
                    return dbType_NOTLIKE;
                }

                public void setDbType_NOTLIKE(String dbType_NOTLIKE) {
                    this.dbType_NOTLIKE = dbType_NOTLIKE;
                }















                public String getDbUrl() {
                    return dbUrl;
                }


                public void setDbUrl(String dbUrl) {
                    this.dbUrl = dbUrl;
                }


                public String getDbUrl_NE() {
                    return dbUrl_NE;
                }


                public void setDbUrl_NE(String dbUrl_NE) {
                    this.dbUrl_NE = dbUrl_NE;
                }



                public String getDbUrl_IN() {
                    return dbUrl_IN;
                }

                public void setDbUrl_IN(String dbUrl_IN) {
                    this.dbUrl_IN = dbUrl_IN;
                }

                public String getDbUrl_NOTIN() {
                    return dbUrl_NOTIN;
                }

                public void setDbUrl_NOTIN(String dbUrl_NOTIN) {
                    this.dbUrl_NOTIN = dbUrl_NOTIN;
                }




                public String getDbUrl_LIKE() {
                    return dbUrl_LIKE;
                }

                public void setDbUrl_LIKE(String dbUrl_LIKE) {
                    this.dbUrl_LIKE = dbUrl_LIKE;
                }

                public String getDbUrl_NOTLIKE() {
                    return dbUrl_NOTLIKE;
                }

                public void setDbUrl_NOTLIKE(String dbUrl_NOTLIKE) {
                    this.dbUrl_NOTLIKE = dbUrl_NOTLIKE;
                }















                public String getDbUsername() {
                    return dbUsername;
                }


                public void setDbUsername(String dbUsername) {
                    this.dbUsername = dbUsername;
                }


                public String getDbUsername_NE() {
                    return dbUsername_NE;
                }


                public void setDbUsername_NE(String dbUsername_NE) {
                    this.dbUsername_NE = dbUsername_NE;
                }



                public String getDbUsername_IN() {
                    return dbUsername_IN;
                }

                public void setDbUsername_IN(String dbUsername_IN) {
                    this.dbUsername_IN = dbUsername_IN;
                }

                public String getDbUsername_NOTIN() {
                    return dbUsername_NOTIN;
                }

                public void setDbUsername_NOTIN(String dbUsername_NOTIN) {
                    this.dbUsername_NOTIN = dbUsername_NOTIN;
                }




                public String getDbUsername_LIKE() {
                    return dbUsername_LIKE;
                }

                public void setDbUsername_LIKE(String dbUsername_LIKE) {
                    this.dbUsername_LIKE = dbUsername_LIKE;
                }

                public String getDbUsername_NOTLIKE() {
                    return dbUsername_NOTLIKE;
                }

                public void setDbUsername_NOTLIKE(String dbUsername_NOTLIKE) {
                    this.dbUsername_NOTLIKE = dbUsername_NOTLIKE;
                }















                public String getDbPassword() {
                    return dbPassword;
                }


                public void setDbPassword(String dbPassword) {
                    this.dbPassword = dbPassword;
                }


                public String getDbPassword_NE() {
                    return dbPassword_NE;
                }


                public void setDbPassword_NE(String dbPassword_NE) {
                    this.dbPassword_NE = dbPassword_NE;
                }



                public String getDbPassword_IN() {
                    return dbPassword_IN;
                }

                public void setDbPassword_IN(String dbPassword_IN) {
                    this.dbPassword_IN = dbPassword_IN;
                }

                public String getDbPassword_NOTIN() {
                    return dbPassword_NOTIN;
                }

                public void setDbPassword_NOTIN(String dbPassword_NOTIN) {
                    this.dbPassword_NOTIN = dbPassword_NOTIN;
                }




                public String getDbPassword_LIKE() {
                    return dbPassword_LIKE;
                }

                public void setDbPassword_LIKE(String dbPassword_LIKE) {
                    this.dbPassword_LIKE = dbPassword_LIKE;
                }

                public String getDbPassword_NOTLIKE() {
                    return dbPassword_NOTLIKE;
                }

                public void setDbPassword_NOTLIKE(String dbPassword_NOTLIKE) {
                    this.dbPassword_NOTLIKE = dbPassword_NOTLIKE;
                }















                public String getTitle() {
                    return title;
                }


                public void setTitle(String title) {
                    this.title = title;
                }


                public String getTitle_NE() {
                    return title_NE;
                }


                public void setTitle_NE(String title_NE) {
                    this.title_NE = title_NE;
                }



                public String getTitle_IN() {
                    return title_IN;
                }

                public void setTitle_IN(String title_IN) {
                    this.title_IN = title_IN;
                }

                public String getTitle_NOTIN() {
                    return title_NOTIN;
                }

                public void setTitle_NOTIN(String title_NOTIN) {
                    this.title_NOTIN = title_NOTIN;
                }




                public String getTitle_LIKE() {
                    return title_LIKE;
                }

                public void setTitle_LIKE(String title_LIKE) {
                    this.title_LIKE = title_LIKE;
                }

                public String getTitle_NOTLIKE() {
                    return title_NOTLIKE;
                }

                public void setTitle_NOTLIKE(String title_NOTLIKE) {
                    this.title_NOTLIKE = title_NOTLIKE;
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