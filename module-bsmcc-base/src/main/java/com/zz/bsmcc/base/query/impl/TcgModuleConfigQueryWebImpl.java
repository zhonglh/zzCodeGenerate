package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 模块设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-24 14:46:24
 */
public class TcgModuleConfigQueryWebImpl<PK extends Serializable> extends TcgModuleConfigAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK projectId_IN;
            private PK projectId_NOTIN;










            private String moduleName_IN;
            private String moduleName_NOTIN;










            private String moduleResource_IN;
            private String moduleResource_NOTIN;








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


















                public PK getProjectId() {
                    return projectId;
                }


                public void setProjectId(PK projectId) {
                    this.projectId = projectId;
                }


                public PK getProjectId_NE() {
                return projectId_NE;
                }


                public void setProjectId_NE(PK projectId_NE) {
                this.projectId_NE = projectId_NE;
                }








                public PK getProjectId_IN() {
                    return projectId_IN;
                }

                public void setProjectId_IN(PK projectId_IN) {
                    this.projectId_IN = projectId_IN;
                }

                public PK getProjectId_NOTIN() {
                    return projectId_NOTIN;
                }

                public void setProjectId_NOTIN(PK projectId_NOTIN) {
                    this.projectId_NOTIN = projectId_NOTIN;
                }


















                public String getModuleName() {
                    return moduleName;
                }


                public void setModuleName(String moduleName) {
                    this.moduleName = moduleName;
                }


                public String getModuleName_NE() {
                    return moduleName_NE;
                }


                public void setModuleName_NE(String moduleName_NE) {
                    this.moduleName_NE = moduleName_NE;
                }



                public String getModuleName_IN() {
                    return moduleName_IN;
                }

                public void setModuleName_IN(String moduleName_IN) {
                    this.moduleName_IN = moduleName_IN;
                }

                public String getModuleName_NOTIN() {
                    return moduleName_NOTIN;
                }

                public void setModuleName_NOTIN(String moduleName_NOTIN) {
                    this.moduleName_NOTIN = moduleName_NOTIN;
                }




                public String getModuleName_LIKE() {
                    return moduleName_LIKE;
                }

                public void setModuleName_LIKE(String moduleName_LIKE) {
                    this.moduleName_LIKE = moduleName_LIKE;
                }

                public String getModuleName_NOTLIKE() {
                    return moduleName_NOTLIKE;
                }

                public void setModuleName_NOTLIKE(String moduleName_NOTLIKE) {
                    this.moduleName_NOTLIKE = moduleName_NOTLIKE;
                }















                public String getModuleResource() {
                    return moduleResource;
                }


                public void setModuleResource(String moduleResource) {
                    this.moduleResource = moduleResource;
                }


                public String getModuleResource_NE() {
                    return moduleResource_NE;
                }


                public void setModuleResource_NE(String moduleResource_NE) {
                    this.moduleResource_NE = moduleResource_NE;
                }



                public String getModuleResource_IN() {
                    return moduleResource_IN;
                }

                public void setModuleResource_IN(String moduleResource_IN) {
                    this.moduleResource_IN = moduleResource_IN;
                }

                public String getModuleResource_NOTIN() {
                    return moduleResource_NOTIN;
                }

                public void setModuleResource_NOTIN(String moduleResource_NOTIN) {
                    this.moduleResource_NOTIN = moduleResource_NOTIN;
                }




                public String getModuleResource_LIKE() {
                    return moduleResource_LIKE;
                }

                public void setModuleResource_LIKE(String moduleResource_LIKE) {
                    this.moduleResource_LIKE = moduleResource_LIKE;
                }

                public String getModuleResource_NOTLIKE() {
                    return moduleResource_NOTLIKE;
                }

                public void setModuleResource_NOTLIKE(String moduleResource_NOTLIKE) {
                    this.moduleResource_NOTLIKE = moduleResource_NOTLIKE;
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