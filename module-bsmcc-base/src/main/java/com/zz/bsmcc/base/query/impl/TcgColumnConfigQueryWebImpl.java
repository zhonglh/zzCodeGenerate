package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 列设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:57
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












            private String columnIsdict_IN;
            private String columnIsdict_NOTIN;











            private String dictType_IN;
            private String dictType_NOTIN;










            private String fkSchema_IN;
            private String fkSchema_NOTIN;










            private String fkName_IN;
            private String fkName_NOTIN;










            private String columnComment_IN;
            private String columnComment_NOTIN;










            private String columnOtherComment_IN;
            private String columnOtherComment_NOTIN;










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












            public Integer getColumnScale() {
                return columnScale;
            }


            public void setColumnScale(Integer columnScale) {
                this.columnScale = columnScale;
            }


            public Integer getColumnScale_NE() {
                return columnScale_NE;
            }


            public void setColumnScale_NE(Integer columnScale_NE) {
                this.columnScale_NE = columnScale_NE;
            }



            public Integer getColumnScale_GT() {
                return columnScale_GT;
            }


            public void setColumnScale_GT(Integer columnScale_GT) {
                this.columnScale_GT = columnScale_GT;
            }


            public Integer getColumnScale_GE() {
                return columnScale_GE;
            }


            public void setColumnScale_GE(Integer columnScale_GE) {
                this.columnScale_GE = columnScale_GE;
            }




            public Integer getColumnScale_LT() {
                return columnScale_LT;
            }


            public void setColumnScale_LT(Integer columnScale_LT) {
                this.columnScale_LT = columnScale_LT;
            }


            public Integer getColumnScale_LE() {
                return columnScale_LE;
            }


            public void setColumnScale_LE(Integer columnScale_LE) {
                this.columnScale_LE = columnScale_LE;
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
















                public String getColumnIsdict() {
                    return columnIsdict;
                }


                public void setColumnIsdict(String columnIsdict) {
                    this.columnIsdict = columnIsdict;
                }


                public String getColumnIsdict_NE() {
                    return columnIsdict_NE;
                }


                public void setColumnIsdict_NE(String columnIsdict_NE) {
                    this.columnIsdict_NE = columnIsdict_NE;
                }



                public String getColumnIsdict_IN() {
                    return columnIsdict_IN;
                }

                public void setColumnIsdict_IN(String columnIsdict_IN) {
                    this.columnIsdict_IN = columnIsdict_IN;
                }

                public String getColumnIsdict_NOTIN() {
                    return columnIsdict_NOTIN;
                }

                public void setColumnIsdict_NOTIN(String columnIsdict_NOTIN) {
                    this.columnIsdict_NOTIN = columnIsdict_NOTIN;
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















                public String getFkSchema() {
                    return fkSchema;
                }


                public void setFkSchema(String fkSchema) {
                    this.fkSchema = fkSchema;
                }


                public String getFkSchema_NE() {
                    return fkSchema_NE;
                }


                public void setFkSchema_NE(String fkSchema_NE) {
                    this.fkSchema_NE = fkSchema_NE;
                }



                public String getFkSchema_IN() {
                    return fkSchema_IN;
                }

                public void setFkSchema_IN(String fkSchema_IN) {
                    this.fkSchema_IN = fkSchema_IN;
                }

                public String getFkSchema_NOTIN() {
                    return fkSchema_NOTIN;
                }

                public void setFkSchema_NOTIN(String fkSchema_NOTIN) {
                    this.fkSchema_NOTIN = fkSchema_NOTIN;
                }




                public String getFkSchema_LIKE() {
                    return fkSchema_LIKE;
                }

                public void setFkSchema_LIKE(String fkSchema_LIKE) {
                    this.fkSchema_LIKE = fkSchema_LIKE;
                }

                public String getFkSchema_NOTLIKE() {
                    return fkSchema_NOTLIKE;
                }

                public void setFkSchema_NOTLIKE(String fkSchema_NOTLIKE) {
                    this.fkSchema_NOTLIKE = fkSchema_NOTLIKE;
                }















                public String getFkName() {
                    return fkName;
                }


                public void setFkName(String fkName) {
                    this.fkName = fkName;
                }


                public String getFkName_NE() {
                    return fkName_NE;
                }


                public void setFkName_NE(String fkName_NE) {
                    this.fkName_NE = fkName_NE;
                }



                public String getFkName_IN() {
                    return fkName_IN;
                }

                public void setFkName_IN(String fkName_IN) {
                    this.fkName_IN = fkName_IN;
                }

                public String getFkName_NOTIN() {
                    return fkName_NOTIN;
                }

                public void setFkName_NOTIN(String fkName_NOTIN) {
                    this.fkName_NOTIN = fkName_NOTIN;
                }




                public String getFkName_LIKE() {
                    return fkName_LIKE;
                }

                public void setFkName_LIKE(String fkName_LIKE) {
                    this.fkName_LIKE = fkName_LIKE;
                }

                public String getFkName_NOTLIKE() {
                    return fkName_NOTLIKE;
                }

                public void setFkName_NOTLIKE(String fkName_NOTLIKE) {
                    this.fkName_NOTLIKE = fkName_NOTLIKE;
                }















                public String getColumnComment() {
                    return columnComment;
                }


                public void setColumnComment(String columnComment) {
                    this.columnComment = columnComment;
                }


                public String getColumnComment_NE() {
                    return columnComment_NE;
                }


                public void setColumnComment_NE(String columnComment_NE) {
                    this.columnComment_NE = columnComment_NE;
                }



                public String getColumnComment_IN() {
                    return columnComment_IN;
                }

                public void setColumnComment_IN(String columnComment_IN) {
                    this.columnComment_IN = columnComment_IN;
                }

                public String getColumnComment_NOTIN() {
                    return columnComment_NOTIN;
                }

                public void setColumnComment_NOTIN(String columnComment_NOTIN) {
                    this.columnComment_NOTIN = columnComment_NOTIN;
                }




                public String getColumnComment_LIKE() {
                    return columnComment_LIKE;
                }

                public void setColumnComment_LIKE(String columnComment_LIKE) {
                    this.columnComment_LIKE = columnComment_LIKE;
                }

                public String getColumnComment_NOTLIKE() {
                    return columnComment_NOTLIKE;
                }

                public void setColumnComment_NOTLIKE(String columnComment_NOTLIKE) {
                    this.columnComment_NOTLIKE = columnComment_NOTLIKE;
                }















                public String getColumnOtherComment() {
                    return columnOtherComment;
                }


                public void setColumnOtherComment(String columnOtherComment) {
                    this.columnOtherComment = columnOtherComment;
                }


                public String getColumnOtherComment_NE() {
                    return columnOtherComment_NE;
                }


                public void setColumnOtherComment_NE(String columnOtherComment_NE) {
                    this.columnOtherComment_NE = columnOtherComment_NE;
                }



                public String getColumnOtherComment_IN() {
                    return columnOtherComment_IN;
                }

                public void setColumnOtherComment_IN(String columnOtherComment_IN) {
                    this.columnOtherComment_IN = columnOtherComment_IN;
                }

                public String getColumnOtherComment_NOTIN() {
                    return columnOtherComment_NOTIN;
                }

                public void setColumnOtherComment_NOTIN(String columnOtherComment_NOTIN) {
                    this.columnOtherComment_NOTIN = columnOtherComment_NOTIN;
                }




                public String getColumnOtherComment_LIKE() {
                    return columnOtherComment_LIKE;
                }

                public void setColumnOtherComment_LIKE(String columnOtherComment_LIKE) {
                    this.columnOtherComment_LIKE = columnOtherComment_LIKE;
                }

                public String getColumnOtherComment_NOTLIKE() {
                    return columnOtherComment_NOTLIKE;
                }

                public void setColumnOtherComment_NOTLIKE(String columnOtherComment_NOTLIKE) {
                    this.columnOtherComment_NOTLIKE = columnOtherComment_NOTLIKE;
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