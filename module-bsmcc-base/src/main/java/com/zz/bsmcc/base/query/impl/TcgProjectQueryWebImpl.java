package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 项目管理 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:16
 */
public class TcgProjectQueryWebImpl<PK extends Serializable> extends TcgProjectAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;










            private String projectName_IN;
            private String projectName_NOTIN;










            private String projectRemark_IN;
            private String projectRemark_NOTIN;










            private String projectPackage_IN;
            private String projectPackage_NOTIN;










            private String projectLead_IN;
            private String projectLead_NOTIN;










            private String projectAuthor_IN;
            private String projectAuthor_NOTIN;










            private String projectNote_IN;
            private String projectNote_NOTIN;











            private String projectI18n_IN;
            private String projectI18n_NOTIN;












            private String projectTenant_IN;
            private String projectTenant_NOTIN;











            private String queryMode_IN;
            private String queryMode_NOTIN;











            private String pageUseView_IN;
            private String pageUseView_NOTIN;









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


















                public String getProjectName() {
                    return projectName;
                }


                public void setProjectName(String projectName) {
                    this.projectName = projectName;
                }


                public String getProjectName_NE() {
                    return projectName_NE;
                }


                public void setProjectName_NE(String projectName_NE) {
                    this.projectName_NE = projectName_NE;
                }



                public String getProjectName_IN() {
                    return projectName_IN;
                }

                public void setProjectName_IN(String projectName_IN) {
                    this.projectName_IN = projectName_IN;
                }

                public String getProjectName_NOTIN() {
                    return projectName_NOTIN;
                }

                public void setProjectName_NOTIN(String projectName_NOTIN) {
                    this.projectName_NOTIN = projectName_NOTIN;
                }




                public String getProjectName_LIKE() {
                    return projectName_LIKE;
                }

                public void setProjectName_LIKE(String projectName_LIKE) {
                    this.projectName_LIKE = projectName_LIKE;
                }

                public String getProjectName_NOTLIKE() {
                    return projectName_NOTLIKE;
                }

                public void setProjectName_NOTLIKE(String projectName_NOTLIKE) {
                    this.projectName_NOTLIKE = projectName_NOTLIKE;
                }















                public String getProjectRemark() {
                    return projectRemark;
                }


                public void setProjectRemark(String projectRemark) {
                    this.projectRemark = projectRemark;
                }


                public String getProjectRemark_NE() {
                    return projectRemark_NE;
                }


                public void setProjectRemark_NE(String projectRemark_NE) {
                    this.projectRemark_NE = projectRemark_NE;
                }



                public String getProjectRemark_IN() {
                    return projectRemark_IN;
                }

                public void setProjectRemark_IN(String projectRemark_IN) {
                    this.projectRemark_IN = projectRemark_IN;
                }

                public String getProjectRemark_NOTIN() {
                    return projectRemark_NOTIN;
                }

                public void setProjectRemark_NOTIN(String projectRemark_NOTIN) {
                    this.projectRemark_NOTIN = projectRemark_NOTIN;
                }




                public String getProjectRemark_LIKE() {
                    return projectRemark_LIKE;
                }

                public void setProjectRemark_LIKE(String projectRemark_LIKE) {
                    this.projectRemark_LIKE = projectRemark_LIKE;
                }

                public String getProjectRemark_NOTLIKE() {
                    return projectRemark_NOTLIKE;
                }

                public void setProjectRemark_NOTLIKE(String projectRemark_NOTLIKE) {
                    this.projectRemark_NOTLIKE = projectRemark_NOTLIKE;
                }















                public String getProjectPackage() {
                    return projectPackage;
                }


                public void setProjectPackage(String projectPackage) {
                    this.projectPackage = projectPackage;
                }


                public String getProjectPackage_NE() {
                    return projectPackage_NE;
                }


                public void setProjectPackage_NE(String projectPackage_NE) {
                    this.projectPackage_NE = projectPackage_NE;
                }



                public String getProjectPackage_IN() {
                    return projectPackage_IN;
                }

                public void setProjectPackage_IN(String projectPackage_IN) {
                    this.projectPackage_IN = projectPackage_IN;
                }

                public String getProjectPackage_NOTIN() {
                    return projectPackage_NOTIN;
                }

                public void setProjectPackage_NOTIN(String projectPackage_NOTIN) {
                    this.projectPackage_NOTIN = projectPackage_NOTIN;
                }




                public String getProjectPackage_LIKE() {
                    return projectPackage_LIKE;
                }

                public void setProjectPackage_LIKE(String projectPackage_LIKE) {
                    this.projectPackage_LIKE = projectPackage_LIKE;
                }

                public String getProjectPackage_NOTLIKE() {
                    return projectPackage_NOTLIKE;
                }

                public void setProjectPackage_NOTLIKE(String projectPackage_NOTLIKE) {
                    this.projectPackage_NOTLIKE = projectPackage_NOTLIKE;
                }















                public String getProjectLead() {
                    return projectLead;
                }


                public void setProjectLead(String projectLead) {
                    this.projectLead = projectLead;
                }


                public String getProjectLead_NE() {
                    return projectLead_NE;
                }


                public void setProjectLead_NE(String projectLead_NE) {
                    this.projectLead_NE = projectLead_NE;
                }



                public String getProjectLead_IN() {
                    return projectLead_IN;
                }

                public void setProjectLead_IN(String projectLead_IN) {
                    this.projectLead_IN = projectLead_IN;
                }

                public String getProjectLead_NOTIN() {
                    return projectLead_NOTIN;
                }

                public void setProjectLead_NOTIN(String projectLead_NOTIN) {
                    this.projectLead_NOTIN = projectLead_NOTIN;
                }




                public String getProjectLead_LIKE() {
                    return projectLead_LIKE;
                }

                public void setProjectLead_LIKE(String projectLead_LIKE) {
                    this.projectLead_LIKE = projectLead_LIKE;
                }

                public String getProjectLead_NOTLIKE() {
                    return projectLead_NOTLIKE;
                }

                public void setProjectLead_NOTLIKE(String projectLead_NOTLIKE) {
                    this.projectLead_NOTLIKE = projectLead_NOTLIKE;
                }















                public String getProjectAuthor() {
                    return projectAuthor;
                }


                public void setProjectAuthor(String projectAuthor) {
                    this.projectAuthor = projectAuthor;
                }


                public String getProjectAuthor_NE() {
                    return projectAuthor_NE;
                }


                public void setProjectAuthor_NE(String projectAuthor_NE) {
                    this.projectAuthor_NE = projectAuthor_NE;
                }



                public String getProjectAuthor_IN() {
                    return projectAuthor_IN;
                }

                public void setProjectAuthor_IN(String projectAuthor_IN) {
                    this.projectAuthor_IN = projectAuthor_IN;
                }

                public String getProjectAuthor_NOTIN() {
                    return projectAuthor_NOTIN;
                }

                public void setProjectAuthor_NOTIN(String projectAuthor_NOTIN) {
                    this.projectAuthor_NOTIN = projectAuthor_NOTIN;
                }




                public String getProjectAuthor_LIKE() {
                    return projectAuthor_LIKE;
                }

                public void setProjectAuthor_LIKE(String projectAuthor_LIKE) {
                    this.projectAuthor_LIKE = projectAuthor_LIKE;
                }

                public String getProjectAuthor_NOTLIKE() {
                    return projectAuthor_NOTLIKE;
                }

                public void setProjectAuthor_NOTLIKE(String projectAuthor_NOTLIKE) {
                    this.projectAuthor_NOTLIKE = projectAuthor_NOTLIKE;
                }















                public String getProjectNote() {
                    return projectNote;
                }


                public void setProjectNote(String projectNote) {
                    this.projectNote = projectNote;
                }


                public String getProjectNote_NE() {
                    return projectNote_NE;
                }


                public void setProjectNote_NE(String projectNote_NE) {
                    this.projectNote_NE = projectNote_NE;
                }



                public String getProjectNote_IN() {
                    return projectNote_IN;
                }

                public void setProjectNote_IN(String projectNote_IN) {
                    this.projectNote_IN = projectNote_IN;
                }

                public String getProjectNote_NOTIN() {
                    return projectNote_NOTIN;
                }

                public void setProjectNote_NOTIN(String projectNote_NOTIN) {
                    this.projectNote_NOTIN = projectNote_NOTIN;
                }




                public String getProjectNote_LIKE() {
                    return projectNote_LIKE;
                }

                public void setProjectNote_LIKE(String projectNote_LIKE) {
                    this.projectNote_LIKE = projectNote_LIKE;
                }

                public String getProjectNote_NOTLIKE() {
                    return projectNote_NOTLIKE;
                }

                public void setProjectNote_NOTLIKE(String projectNote_NOTLIKE) {
                    this.projectNote_NOTLIKE = projectNote_NOTLIKE;
                }















                public String getProjectI18n() {
                    return projectI18n;
                }


                public void setProjectI18n(String projectI18n) {
                    this.projectI18n = projectI18n;
                }


                public String getProjectI18n_NE() {
                    return projectI18n_NE;
                }


                public void setProjectI18n_NE(String projectI18n_NE) {
                    this.projectI18n_NE = projectI18n_NE;
                }



                public String getProjectI18n_IN() {
                    return projectI18n_IN;
                }

                public void setProjectI18n_IN(String projectI18n_IN) {
                    this.projectI18n_IN = projectI18n_IN;
                }

                public String getProjectI18n_NOTIN() {
                    return projectI18n_NOTIN;
                }

                public void setProjectI18n_NOTIN(String projectI18n_NOTIN) {
                    this.projectI18n_NOTIN = projectI18n_NOTIN;
                }
















                public String getProjectTenant() {
                    return projectTenant;
                }


                public void setProjectTenant(String projectTenant) {
                    this.projectTenant = projectTenant;
                }


                public String getProjectTenant_NE() {
                    return projectTenant_NE;
                }


                public void setProjectTenant_NE(String projectTenant_NE) {
                    this.projectTenant_NE = projectTenant_NE;
                }



                public String getProjectTenant_IN() {
                    return projectTenant_IN;
                }

                public void setProjectTenant_IN(String projectTenant_IN) {
                    this.projectTenant_IN = projectTenant_IN;
                }

                public String getProjectTenant_NOTIN() {
                    return projectTenant_NOTIN;
                }

                public void setProjectTenant_NOTIN(String projectTenant_NOTIN) {
                    this.projectTenant_NOTIN = projectTenant_NOTIN;
                }
















                public String getQueryMode() {
                    return queryMode;
                }


                public void setQueryMode(String queryMode) {
                    this.queryMode = queryMode;
                }


                public String getQueryMode_NE() {
                    return queryMode_NE;
                }


                public void setQueryMode_NE(String queryMode_NE) {
                    this.queryMode_NE = queryMode_NE;
                }



                public String getQueryMode_IN() {
                    return queryMode_IN;
                }

                public void setQueryMode_IN(String queryMode_IN) {
                    this.queryMode_IN = queryMode_IN;
                }

                public String getQueryMode_NOTIN() {
                    return queryMode_NOTIN;
                }

                public void setQueryMode_NOTIN(String queryMode_NOTIN) {
                    this.queryMode_NOTIN = queryMode_NOTIN;
                }




                public String getQueryMode_LIKE() {
                    return queryMode_LIKE;
                }

                public void setQueryMode_LIKE(String queryMode_LIKE) {
                    this.queryMode_LIKE = queryMode_LIKE;
                }

                public String getQueryMode_NOTLIKE() {
                    return queryMode_NOTLIKE;
                }

                public void setQueryMode_NOTLIKE(String queryMode_NOTLIKE) {
                    this.queryMode_NOTLIKE = queryMode_NOTLIKE;
                }















                public String getPageUseView() {
                    return pageUseView;
                }


                public void setPageUseView(String pageUseView) {
                    this.pageUseView = pageUseView;
                }


                public String getPageUseView_NE() {
                    return pageUseView_NE;
                }


                public void setPageUseView_NE(String pageUseView_NE) {
                    this.pageUseView_NE = pageUseView_NE;
                }



                public String getPageUseView_IN() {
                    return pageUseView_IN;
                }

                public void setPageUseView_IN(String pageUseView_IN) {
                    this.pageUseView_IN = pageUseView_IN;
                }

                public String getPageUseView_NOTIN() {
                    return pageUseView_NOTIN;
                }

                public void setPageUseView_NOTIN(String pageUseView_NOTIN) {
                    this.pageUseView_NOTIN = pageUseView_NOTIN;
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