package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 模板 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:17
 */
public class TcgTempletQueryWebImpl<PK extends Serializable> extends TcgTempletAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK groupId_IN;
            private PK groupId_NOTIN;










            private String fileType_IN;
            private String fileType_NOTIN;










            private String templetTitle_IN;
            private String templetTitle_NOTIN;










            private String templetDir_IN;
            private String templetDir_NOTIN;










            private String templetContent_IN;
            private String templetContent_NOTIN;








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


















                public PK getGroupId() {
                    return groupId;
                }


                public void setGroupId(PK groupId) {
                    this.groupId = groupId;
                }


                public PK getGroupId_NE() {
                return groupId_NE;
                }


                public void setGroupId_NE(PK groupId_NE) {
                this.groupId_NE = groupId_NE;
                }








                public PK getGroupId_IN() {
                    return groupId_IN;
                }

                public void setGroupId_IN(PK groupId_IN) {
                    this.groupId_IN = groupId_IN;
                }

                public PK getGroupId_NOTIN() {
                    return groupId_NOTIN;
                }

                public void setGroupId_NOTIN(PK groupId_NOTIN) {
                    this.groupId_NOTIN = groupId_NOTIN;
                }


















                public String getFileType() {
                    return fileType;
                }


                public void setFileType(String fileType) {
                    this.fileType = fileType;
                }


                public String getFileType_NE() {
                    return fileType_NE;
                }


                public void setFileType_NE(String fileType_NE) {
                    this.fileType_NE = fileType_NE;
                }



                public String getFileType_IN() {
                    return fileType_IN;
                }

                public void setFileType_IN(String fileType_IN) {
                    this.fileType_IN = fileType_IN;
                }

                public String getFileType_NOTIN() {
                    return fileType_NOTIN;
                }

                public void setFileType_NOTIN(String fileType_NOTIN) {
                    this.fileType_NOTIN = fileType_NOTIN;
                }




                public String getFileType_LIKE() {
                    return fileType_LIKE;
                }

                public void setFileType_LIKE(String fileType_LIKE) {
                    this.fileType_LIKE = fileType_LIKE;
                }

                public String getFileType_NOTLIKE() {
                    return fileType_NOTLIKE;
                }

                public void setFileType_NOTLIKE(String fileType_NOTLIKE) {
                    this.fileType_NOTLIKE = fileType_NOTLIKE;
                }















                public String getTempletTitle() {
                    return templetTitle;
                }


                public void setTempletTitle(String templetTitle) {
                    this.templetTitle = templetTitle;
                }


                public String getTempletTitle_NE() {
                    return templetTitle_NE;
                }


                public void setTempletTitle_NE(String templetTitle_NE) {
                    this.templetTitle_NE = templetTitle_NE;
                }



                public String getTempletTitle_IN() {
                    return templetTitle_IN;
                }

                public void setTempletTitle_IN(String templetTitle_IN) {
                    this.templetTitle_IN = templetTitle_IN;
                }

                public String getTempletTitle_NOTIN() {
                    return templetTitle_NOTIN;
                }

                public void setTempletTitle_NOTIN(String templetTitle_NOTIN) {
                    this.templetTitle_NOTIN = templetTitle_NOTIN;
                }




                public String getTempletTitle_LIKE() {
                    return templetTitle_LIKE;
                }

                public void setTempletTitle_LIKE(String templetTitle_LIKE) {
                    this.templetTitle_LIKE = templetTitle_LIKE;
                }

                public String getTempletTitle_NOTLIKE() {
                    return templetTitle_NOTLIKE;
                }

                public void setTempletTitle_NOTLIKE(String templetTitle_NOTLIKE) {
                    this.templetTitle_NOTLIKE = templetTitle_NOTLIKE;
                }















                public String getTempletDir() {
                    return templetDir;
                }


                public void setTempletDir(String templetDir) {
                    this.templetDir = templetDir;
                }


                public String getTempletDir_NE() {
                    return templetDir_NE;
                }


                public void setTempletDir_NE(String templetDir_NE) {
                    this.templetDir_NE = templetDir_NE;
                }



                public String getTempletDir_IN() {
                    return templetDir_IN;
                }

                public void setTempletDir_IN(String templetDir_IN) {
                    this.templetDir_IN = templetDir_IN;
                }

                public String getTempletDir_NOTIN() {
                    return templetDir_NOTIN;
                }

                public void setTempletDir_NOTIN(String templetDir_NOTIN) {
                    this.templetDir_NOTIN = templetDir_NOTIN;
                }




                public String getTempletDir_LIKE() {
                    return templetDir_LIKE;
                }

                public void setTempletDir_LIKE(String templetDir_LIKE) {
                    this.templetDir_LIKE = templetDir_LIKE;
                }

                public String getTempletDir_NOTLIKE() {
                    return templetDir_NOTLIKE;
                }

                public void setTempletDir_NOTLIKE(String templetDir_NOTLIKE) {
                    this.templetDir_NOTLIKE = templetDir_NOTLIKE;
                }















                public String getTempletContent() {
                    return templetContent;
                }


                public void setTempletContent(String templetContent) {
                    this.templetContent = templetContent;
                }


                public String getTempletContent_NE() {
                    return templetContent_NE;
                }


                public void setTempletContent_NE(String templetContent_NE) {
                    this.templetContent_NE = templetContent_NE;
                }



                public String getTempletContent_IN() {
                    return templetContent_IN;
                }

                public void setTempletContent_IN(String templetContent_IN) {
                    this.templetContent_IN = templetContent_IN;
                }

                public String getTempletContent_NOTIN() {
                    return templetContent_NOTIN;
                }

                public void setTempletContent_NOTIN(String templetContent_NOTIN) {
                    this.templetContent_NOTIN = templetContent_NOTIN;
                }




                public String getTempletContent_LIKE() {
                    return templetContent_LIKE;
                }

                public void setTempletContent_LIKE(String templetContent_LIKE) {
                    this.templetContent_LIKE = templetContent_LIKE;
                }

                public String getTempletContent_NOTLIKE() {
                    return templetContent_NOTLIKE;
                }

                public void setTempletContent_NOTLIKE(String templetContent_NOTLIKE) {
                    this.templetContent_NOTLIKE = templetContent_NOTLIKE;
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