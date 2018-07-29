package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 模板组 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-29 1:16:16
 */
public class TcgTempletGroupQueryWebImpl<PK extends Serializable> extends TcgTempletGroupAbstractQueryImpl<PK> implements Serializable {
    private static final long serialVersionUID = 1L;







            private PK id_IN;
            private PK id_NOTIN;










            private String groupName_IN;
            private String groupName_NOTIN;










            private String groupRemark_IN;
            private String groupRemark_NOTIN;








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


















                public String getGroupName() {
                    return groupName;
                }


                public void setGroupName(String groupName) {
                    this.groupName = groupName;
                }


                public String getGroupName_NE() {
                    return groupName_NE;
                }


                public void setGroupName_NE(String groupName_NE) {
                    this.groupName_NE = groupName_NE;
                }



                public String getGroupName_IN() {
                    return groupName_IN;
                }

                public void setGroupName_IN(String groupName_IN) {
                    this.groupName_IN = groupName_IN;
                }

                public String getGroupName_NOTIN() {
                    return groupName_NOTIN;
                }

                public void setGroupName_NOTIN(String groupName_NOTIN) {
                    this.groupName_NOTIN = groupName_NOTIN;
                }




                public String getGroupName_LIKE() {
                    return groupName_LIKE;
                }

                public void setGroupName_LIKE(String groupName_LIKE) {
                    this.groupName_LIKE = groupName_LIKE;
                }

                public String getGroupName_NOTLIKE() {
                    return groupName_NOTLIKE;
                }

                public void setGroupName_NOTLIKE(String groupName_NOTLIKE) {
                    this.groupName_NOTLIKE = groupName_NOTLIKE;
                }















                public String getGroupRemark() {
                    return groupRemark;
                }


                public void setGroupRemark(String groupRemark) {
                    this.groupRemark = groupRemark;
                }


                public String getGroupRemark_NE() {
                    return groupRemark_NE;
                }


                public void setGroupRemark_NE(String groupRemark_NE) {
                    this.groupRemark_NE = groupRemark_NE;
                }



                public String getGroupRemark_IN() {
                    return groupRemark_IN;
                }

                public void setGroupRemark_IN(String groupRemark_IN) {
                    this.groupRemark_IN = groupRemark_IN;
                }

                public String getGroupRemark_NOTIN() {
                    return groupRemark_NOTIN;
                }

                public void setGroupRemark_NOTIN(String groupRemark_NOTIN) {
                    this.groupRemark_NOTIN = groupRemark_NOTIN;
                }




                public String getGroupRemark_LIKE() {
                    return groupRemark_LIKE;
                }

                public void setGroupRemark_LIKE(String groupRemark_LIKE) {
                    this.groupRemark_LIKE = groupRemark_LIKE;
                }

                public String getGroupRemark_NOTLIKE() {
                    return groupRemark_NOTLIKE;
                }

                public void setGroupRemark_NOTLIKE(String groupRemark_NOTLIKE) {
                    this.groupRemark_NOTLIKE = groupRemark_NOTLIKE;
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