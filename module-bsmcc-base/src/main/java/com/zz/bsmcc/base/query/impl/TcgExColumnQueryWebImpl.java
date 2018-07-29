package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 扩展列设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-29 1:16:11
 */
public class TcgExColumnQueryWebImpl<PK extends Serializable> extends TcgExColumnAbstractQueryImpl<PK> implements Serializable {
    private static final long serialVersionUID = 1L;







            private PK id_IN;
            private PK id_NOTIN;











            private PK tableId_IN;
            private PK tableId_NOTIN;










            private String javaSimpleClass_IN;
            private String javaSimpleClass_NOTIN;










            private String javaFullClass_IN;
            private String javaFullClass_NOTIN;










            private String javaName_IN;
            private String javaName_NOTIN;










            private String columnTitle_IN;
            private String columnTitle_NOTIN;










            private String groupCode_IN;
            private String groupCode_NOTIN;










            private String dictType_IN;
            private String dictType_NOTIN;








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


















                public String getJavaSimpleClass() {
                    return javaSimpleClass;
                }


                public void setJavaSimpleClass(String javaSimpleClass) {
                    this.javaSimpleClass = javaSimpleClass;
                }


                public String getJavaSimpleClass_NE() {
                    return javaSimpleClass_NE;
                }


                public void setJavaSimpleClass_NE(String javaSimpleClass_NE) {
                    this.javaSimpleClass_NE = javaSimpleClass_NE;
                }



                public String getJavaSimpleClass_IN() {
                    return javaSimpleClass_IN;
                }

                public void setJavaSimpleClass_IN(String javaSimpleClass_IN) {
                    this.javaSimpleClass_IN = javaSimpleClass_IN;
                }

                public String getJavaSimpleClass_NOTIN() {
                    return javaSimpleClass_NOTIN;
                }

                public void setJavaSimpleClass_NOTIN(String javaSimpleClass_NOTIN) {
                    this.javaSimpleClass_NOTIN = javaSimpleClass_NOTIN;
                }




                public String getJavaSimpleClass_LIKE() {
                    return javaSimpleClass_LIKE;
                }

                public void setJavaSimpleClass_LIKE(String javaSimpleClass_LIKE) {
                    this.javaSimpleClass_LIKE = javaSimpleClass_LIKE;
                }

                public String getJavaSimpleClass_NOTLIKE() {
                    return javaSimpleClass_NOTLIKE;
                }

                public void setJavaSimpleClass_NOTLIKE(String javaSimpleClass_NOTLIKE) {
                    this.javaSimpleClass_NOTLIKE = javaSimpleClass_NOTLIKE;
                }















                public String getJavaFullClass() {
                    return javaFullClass;
                }


                public void setJavaFullClass(String javaFullClass) {
                    this.javaFullClass = javaFullClass;
                }


                public String getJavaFullClass_NE() {
                    return javaFullClass_NE;
                }


                public void setJavaFullClass_NE(String javaFullClass_NE) {
                    this.javaFullClass_NE = javaFullClass_NE;
                }



                public String getJavaFullClass_IN() {
                    return javaFullClass_IN;
                }

                public void setJavaFullClass_IN(String javaFullClass_IN) {
                    this.javaFullClass_IN = javaFullClass_IN;
                }

                public String getJavaFullClass_NOTIN() {
                    return javaFullClass_NOTIN;
                }

                public void setJavaFullClass_NOTIN(String javaFullClass_NOTIN) {
                    this.javaFullClass_NOTIN = javaFullClass_NOTIN;
                }




                public String getJavaFullClass_LIKE() {
                    return javaFullClass_LIKE;
                }

                public void setJavaFullClass_LIKE(String javaFullClass_LIKE) {
                    this.javaFullClass_LIKE = javaFullClass_LIKE;
                }

                public String getJavaFullClass_NOTLIKE() {
                    return javaFullClass_NOTLIKE;
                }

                public void setJavaFullClass_NOTLIKE(String javaFullClass_NOTLIKE) {
                    this.javaFullClass_NOTLIKE = javaFullClass_NOTLIKE;
                }















                public String getJavaName() {
                    return javaName;
                }


                public void setJavaName(String javaName) {
                    this.javaName = javaName;
                }


                public String getJavaName_NE() {
                    return javaName_NE;
                }


                public void setJavaName_NE(String javaName_NE) {
                    this.javaName_NE = javaName_NE;
                }



                public String getJavaName_IN() {
                    return javaName_IN;
                }

                public void setJavaName_IN(String javaName_IN) {
                    this.javaName_IN = javaName_IN;
                }

                public String getJavaName_NOTIN() {
                    return javaName_NOTIN;
                }

                public void setJavaName_NOTIN(String javaName_NOTIN) {
                    this.javaName_NOTIN = javaName_NOTIN;
                }




                public String getJavaName_LIKE() {
                    return javaName_LIKE;
                }

                public void setJavaName_LIKE(String javaName_LIKE) {
                    this.javaName_LIKE = javaName_LIKE;
                }

                public String getJavaName_NOTLIKE() {
                    return javaName_NOTLIKE;
                }

                public void setJavaName_NOTLIKE(String javaName_NOTLIKE) {
                    this.javaName_NOTLIKE = javaName_NOTLIKE;
                }















                public String getColumnTitle() {
                    return columnTitle;
                }


                public void setColumnTitle(String columnTitle) {
                    this.columnTitle = columnTitle;
                }


                public String getColumnTitle_NE() {
                    return columnTitle_NE;
                }


                public void setColumnTitle_NE(String columnTitle_NE) {
                    this.columnTitle_NE = columnTitle_NE;
                }



                public String getColumnTitle_IN() {
                    return columnTitle_IN;
                }

                public void setColumnTitle_IN(String columnTitle_IN) {
                    this.columnTitle_IN = columnTitle_IN;
                }

                public String getColumnTitle_NOTIN() {
                    return columnTitle_NOTIN;
                }

                public void setColumnTitle_NOTIN(String columnTitle_NOTIN) {
                    this.columnTitle_NOTIN = columnTitle_NOTIN;
                }




                public String getColumnTitle_LIKE() {
                    return columnTitle_LIKE;
                }

                public void setColumnTitle_LIKE(String columnTitle_LIKE) {
                    this.columnTitle_LIKE = columnTitle_LIKE;
                }

                public String getColumnTitle_NOTLIKE() {
                    return columnTitle_NOTLIKE;
                }

                public void setColumnTitle_NOTLIKE(String columnTitle_NOTLIKE) {
                    this.columnTitle_NOTLIKE = columnTitle_NOTLIKE;
                }















                public String getGroupCode() {
                    return groupCode;
                }


                public void setGroupCode(String groupCode) {
                    this.groupCode = groupCode;
                }


                public String getGroupCode_NE() {
                    return groupCode_NE;
                }


                public void setGroupCode_NE(String groupCode_NE) {
                    this.groupCode_NE = groupCode_NE;
                }



                public String getGroupCode_IN() {
                    return groupCode_IN;
                }

                public void setGroupCode_IN(String groupCode_IN) {
                    this.groupCode_IN = groupCode_IN;
                }

                public String getGroupCode_NOTIN() {
                    return groupCode_NOTIN;
                }

                public void setGroupCode_NOTIN(String groupCode_NOTIN) {
                    this.groupCode_NOTIN = groupCode_NOTIN;
                }




                public String getGroupCode_LIKE() {
                    return groupCode_LIKE;
                }

                public void setGroupCode_LIKE(String groupCode_LIKE) {
                    this.groupCode_LIKE = groupCode_LIKE;
                }

                public String getGroupCode_NOTLIKE() {
                    return groupCode_NOTLIKE;
                }

                public void setGroupCode_NOTLIKE(String groupCode_NOTLIKE) {
                    this.groupCode_NOTLIKE = groupCode_NOTLIKE;
                }















                public String getDictType() {
                    return dictType;
                }


                public void setDictType(String dictType) {
                    this.dictType = dictType;
                }


                public String getDictType_NE() {
                    return dictType_NE;
                }


                public void setDictType_NE(String dictType_NE) {
                    this.dictType_NE = dictType_NE;
                }



                public String getDictType_IN() {
                    return dictType_IN;
                }

                public void setDictType_IN(String dictType_IN) {
                    this.dictType_IN = dictType_IN;
                }

                public String getDictType_NOTIN() {
                    return dictType_NOTIN;
                }

                public void setDictType_NOTIN(String dictType_NOTIN) {
                    this.dictType_NOTIN = dictType_NOTIN;
                }




                public String getDictType_LIKE() {
                    return dictType_LIKE;
                }

                public void setDictType_LIKE(String dictType_LIKE) {
                    this.dictType_LIKE = dictType_LIKE;
                }

                public String getDictType_NOTLIKE() {
                    return dictType_NOTLIKE;
                }

                public void setDictType_NOTLIKE(String dictType_NOTLIKE) {
                    this.dictType_NOTLIKE = dictType_NOTLIKE;
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