package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 列设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-24 14:46:22
 */
public class TcgColumnConfigQueryWebImpl<PK extends Serializable> extends TcgColumnConfigAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK tableId_IN;
            private PK tableId_NOTIN;










            private String columnName_IN;
            private String columnName_NOTIN;










            private String columnType_IN;
            private String columnType_NOTIN;








        ;







        ;









            private String columnDefault_IN;
            private String columnDefault_NOTIN;











            private String columnIsnull_IN;
            private String columnIsnull_NOTIN;









        ;










            private String columnIsfk_IN;
            private String columnIsfk_NOTIN;












            private String columnIskey_IN;
            private String columnIskey_NOTIN;











            private String columnContent_IN;
            private String columnContent_NOTIN;










            private String javaSimpleClass_IN;
            private String javaSimpleClass_NOTIN;










            private String javaFullClass_IN;
            private String javaFullClass_NOTIN;










            private String javaName_IN;
            private String javaName_NOTIN;










            private String groupCode_IN;
            private String groupCode_NOTIN;








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


















                public String getColumnName() {
                    return columnName;
                }


                public void setColumnName(String columnName) {
                    this.columnName = columnName;
                }


                public String getColumnName_NE() {
                    return columnName_NE;
                }


                public void setColumnName_NE(String columnName_NE) {
                    this.columnName_NE = columnName_NE;
                }



                public String getColumnName_IN() {
                    return columnName_IN;
                }

                public void setColumnName_IN(String columnName_IN) {
                    this.columnName_IN = columnName_IN;
                }

                public String getColumnName_NOTIN() {
                    return columnName_NOTIN;
                }

                public void setColumnName_NOTIN(String columnName_NOTIN) {
                    this.columnName_NOTIN = columnName_NOTIN;
                }




                public String getColumnName_LIKE() {
                    return columnName_LIKE;
                }

                public void setColumnName_LIKE(String columnName_LIKE) {
                    this.columnName_LIKE = columnName_LIKE;
                }

                public String getColumnName_NOTLIKE() {
                    return columnName_NOTLIKE;
                }

                public void setColumnName_NOTLIKE(String columnName_NOTLIKE) {
                    this.columnName_NOTLIKE = columnName_NOTLIKE;
                }















                public String getColumnType() {
                    return columnType;
                }


                public void setColumnType(String columnType) {
                    this.columnType = columnType;
                }


                public String getColumnType_NE() {
                    return columnType_NE;
                }


                public void setColumnType_NE(String columnType_NE) {
                    this.columnType_NE = columnType_NE;
                }



                public String getColumnType_IN() {
                    return columnType_IN;
                }

                public void setColumnType_IN(String columnType_IN) {
                    this.columnType_IN = columnType_IN;
                }

                public String getColumnType_NOTIN() {
                    return columnType_NOTIN;
                }

                public void setColumnType_NOTIN(String columnType_NOTIN) {
                    this.columnType_NOTIN = columnType_NOTIN;
                }




                public String getColumnType_LIKE() {
                    return columnType_LIKE;
                }

                public void setColumnType_LIKE(String columnType_LIKE) {
                    this.columnType_LIKE = columnType_LIKE;
                }

                public String getColumnType_NOTLIKE() {
                    return columnType_NOTLIKE;
                }

                public void setColumnType_NOTLIKE(String columnType_NOTLIKE) {
                    this.columnType_NOTLIKE = columnType_NOTLIKE;
                }












            public Integer getColumnLength() {
                return columnLength;
            }


            public void setColumnLength(Integer columnLength) {
                this.columnLength = columnLength;
            }


            public Integer getColumnLength_NE() {
                return columnLength_NE;
            }


            public void setColumnLength_NE(Integer columnLength_NE) {
                this.columnLength_NE = columnLength_NE;
            }



            public Integer getColumnLength_GT() {
                return columnLength_GT;
            }


            public void setColumnLength_GT(Integer columnLength_GT) {
                this.columnLength_GT = columnLength_GT;
            }


            public Integer getColumnLength_GE() {
                return columnLength_GE;
            }


            public void setColumnLength_GE(Integer columnLength_GE) {
                this.columnLength_GE = columnLength_GE;
            }




            public Integer getColumnLength_LT() {
                return columnLength_LT;
            }


            public void setColumnLength_LT(Integer columnLength_LT) {
                this.columnLength_LT = columnLength_LT;
            }


            public Integer getColumnLength_LE() {
                return columnLength_LE;
            }


            public void setColumnLength_LE(Integer columnLength_LE) {
                this.columnLength_LE = columnLength_LE;
            }












            public Integer getColumnPrecision() {
                return columnPrecision;
            }


            public void setColumnPrecision(Integer columnPrecision) {
                this.columnPrecision = columnPrecision;
            }


            public Integer getColumnPrecision_NE() {
                return columnPrecision_NE;
            }


            public void setColumnPrecision_NE(Integer columnPrecision_NE) {
                this.columnPrecision_NE = columnPrecision_NE;
            }



            public Integer getColumnPrecision_GT() {
                return columnPrecision_GT;
            }


            public void setColumnPrecision_GT(Integer columnPrecision_GT) {
                this.columnPrecision_GT = columnPrecision_GT;
            }


            public Integer getColumnPrecision_GE() {
                return columnPrecision_GE;
            }


            public void setColumnPrecision_GE(Integer columnPrecision_GE) {
                this.columnPrecision_GE = columnPrecision_GE;
            }




            public Integer getColumnPrecision_LT() {
                return columnPrecision_LT;
            }


            public void setColumnPrecision_LT(Integer columnPrecision_LT) {
                this.columnPrecision_LT = columnPrecision_LT;
            }


            public Integer getColumnPrecision_LE() {
                return columnPrecision_LE;
            }


            public void setColumnPrecision_LE(Integer columnPrecision_LE) {
                this.columnPrecision_LE = columnPrecision_LE;
            }















                public String getColumnDefault() {
                    return columnDefault;
                }


                public void setColumnDefault(String columnDefault) {
                    this.columnDefault = columnDefault;
                }


                public String getColumnDefault_NE() {
                    return columnDefault_NE;
                }


                public void setColumnDefault_NE(String columnDefault_NE) {
                    this.columnDefault_NE = columnDefault_NE;
                }



                public String getColumnDefault_IN() {
                    return columnDefault_IN;
                }

                public void setColumnDefault_IN(String columnDefault_IN) {
                    this.columnDefault_IN = columnDefault_IN;
                }

                public String getColumnDefault_NOTIN() {
                    return columnDefault_NOTIN;
                }

                public void setColumnDefault_NOTIN(String columnDefault_NOTIN) {
                    this.columnDefault_NOTIN = columnDefault_NOTIN;
                }




                public String getColumnDefault_LIKE() {
                    return columnDefault_LIKE;
                }

                public void setColumnDefault_LIKE(String columnDefault_LIKE) {
                    this.columnDefault_LIKE = columnDefault_LIKE;
                }

                public String getColumnDefault_NOTLIKE() {
                    return columnDefault_NOTLIKE;
                }

                public void setColumnDefault_NOTLIKE(String columnDefault_NOTLIKE) {
                    this.columnDefault_NOTLIKE = columnDefault_NOTLIKE;
                }















                public String getColumnIsnull() {
                    return columnIsnull;
                }


                public void setColumnIsnull(String columnIsnull) {
                    this.columnIsnull = columnIsnull;
                }


                public String getColumnIsnull_NE() {
                    return columnIsnull_NE;
                }


                public void setColumnIsnull_NE(String columnIsnull_NE) {
                    this.columnIsnull_NE = columnIsnull_NE;
                }



                public String getColumnIsnull_IN() {
                    return columnIsnull_IN;
                }

                public void setColumnIsnull_IN(String columnIsnull_IN) {
                    this.columnIsnull_IN = columnIsnull_IN;
                }

                public String getColumnIsnull_NOTIN() {
                    return columnIsnull_NOTIN;
                }

                public void setColumnIsnull_NOTIN(String columnIsnull_NOTIN) {
                    this.columnIsnull_NOTIN = columnIsnull_NOTIN;
                }













            public Integer getColumnSort() {
                return columnSort;
            }


            public void setColumnSort(Integer columnSort) {
                this.columnSort = columnSort;
            }


            public Integer getColumnSort_NE() {
                return columnSort_NE;
            }


            public void setColumnSort_NE(Integer columnSort_NE) {
                this.columnSort_NE = columnSort_NE;
            }



            public Integer getColumnSort_GT() {
                return columnSort_GT;
            }


            public void setColumnSort_GT(Integer columnSort_GT) {
                this.columnSort_GT = columnSort_GT;
            }


            public Integer getColumnSort_GE() {
                return columnSort_GE;
            }


            public void setColumnSort_GE(Integer columnSort_GE) {
                this.columnSort_GE = columnSort_GE;
            }




            public Integer getColumnSort_LT() {
                return columnSort_LT;
            }


            public void setColumnSort_LT(Integer columnSort_LT) {
                this.columnSort_LT = columnSort_LT;
            }


            public Integer getColumnSort_LE() {
                return columnSort_LE;
            }


            public void setColumnSort_LE(Integer columnSort_LE) {
                this.columnSort_LE = columnSort_LE;
            }















                public String getColumnIsfk() {
                    return columnIsfk;
                }


                public void setColumnIsfk(String columnIsfk) {
                    this.columnIsfk = columnIsfk;
                }


                public String getColumnIsfk_NE() {
                    return columnIsfk_NE;
                }


                public void setColumnIsfk_NE(String columnIsfk_NE) {
                    this.columnIsfk_NE = columnIsfk_NE;
                }



                public String getColumnIsfk_IN() {
                    return columnIsfk_IN;
                }

                public void setColumnIsfk_IN(String columnIsfk_IN) {
                    this.columnIsfk_IN = columnIsfk_IN;
                }

                public String getColumnIsfk_NOTIN() {
                    return columnIsfk_NOTIN;
                }

                public void setColumnIsfk_NOTIN(String columnIsfk_NOTIN) {
                    this.columnIsfk_NOTIN = columnIsfk_NOTIN;
                }
















                public String getColumnIskey() {
                    return columnIskey;
                }


                public void setColumnIskey(String columnIskey) {
                    this.columnIskey = columnIskey;
                }


                public String getColumnIskey_NE() {
                    return columnIskey_NE;
                }


                public void setColumnIskey_NE(String columnIskey_NE) {
                    this.columnIskey_NE = columnIskey_NE;
                }



                public String getColumnIskey_IN() {
                    return columnIskey_IN;
                }

                public void setColumnIskey_IN(String columnIskey_IN) {
                    this.columnIskey_IN = columnIskey_IN;
                }

                public String getColumnIskey_NOTIN() {
                    return columnIskey_NOTIN;
                }

                public void setColumnIskey_NOTIN(String columnIskey_NOTIN) {
                    this.columnIskey_NOTIN = columnIskey_NOTIN;
                }
















                public String getColumnContent() {
                    return columnContent;
                }


                public void setColumnContent(String columnContent) {
                    this.columnContent = columnContent;
                }


                public String getColumnContent_NE() {
                    return columnContent_NE;
                }


                public void setColumnContent_NE(String columnContent_NE) {
                    this.columnContent_NE = columnContent_NE;
                }



                public String getColumnContent_IN() {
                    return columnContent_IN;
                }

                public void setColumnContent_IN(String columnContent_IN) {
                    this.columnContent_IN = columnContent_IN;
                }

                public String getColumnContent_NOTIN() {
                    return columnContent_NOTIN;
                }

                public void setColumnContent_NOTIN(String columnContent_NOTIN) {
                    this.columnContent_NOTIN = columnContent_NOTIN;
                }




                public String getColumnContent_LIKE() {
                    return columnContent_LIKE;
                }

                public void setColumnContent_LIKE(String columnContent_LIKE) {
                    this.columnContent_LIKE = columnContent_LIKE;
                }

                public String getColumnContent_NOTLIKE() {
                    return columnContent_NOTLIKE;
                }

                public void setColumnContent_NOTLIKE(String columnContent_NOTLIKE) {
                    this.columnContent_NOTLIKE = columnContent_NOTLIKE;
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