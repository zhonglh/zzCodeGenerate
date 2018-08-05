package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgExColumnQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 扩展列设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:58
 */
public class TcgExColumnQueryImpl<PK extends Serializable> extends TcgExColumnAbstractQueryImpl<PK> implements TcgExColumnQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> tableId_IN;
            private List<PK> tableId_NOTIN;













            private List<PK> originalColumnId_IN;
            private List<PK> originalColumnId_NOTIN;













            private List<String> javaSimpleClass_IN;
            private List<String> javaSimpleClass_NOTIN;













            private List<String> javaFullClass_IN;
            private List<String> javaFullClass_NOTIN;













            private List<String> javaName_IN;
            private List<String> javaName_NOTIN;























            private List<String> columnTitle_IN;
            private List<String> columnTitle_NOTIN;













            private List<String> fkColumnName_IN;
            private List<String> fkColumnName_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgExColumnQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgExColumnQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgExColumnQuery tableId(PK tableId) {
                    if(!IdUtils.isEmpty(tableId)){
                        this.tableId = tableId;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery tableIdNot(PK tableIdNot) {
                    if(!IdUtils.isEmpty(tableIdNot)){
                        this.tableId_NE = tableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery tableIdIn(PK tableIdIn) {
                    if(!IdUtils.isEmpty(tableIdIn)){
                        if(this.tableId_IN == null){
                            this.tableId_IN = new ArrayList<PK>();
                        }
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
                        if(this.tableId_NOTIN == null){
                            this.tableId_NOTIN = new ArrayList<PK>();
                        }
                        this.tableId_NOTIN.add( tableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery tableIdIsNull() {
                    this.isNulls.add("tableId");
                    return this;
                }



                @Override
                public TcgExColumnQuery tableIdIsNotNull() {
                    this.isNotNulls.add("tableId");
                    return this;
                }















                @Override
                public TcgExColumnQuery originalColumnId(PK originalColumnId) {
                    if(!IdUtils.isEmpty(originalColumnId)){
                        this.originalColumnId = originalColumnId;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery originalColumnIdNot(PK originalColumnIdNot) {
                    if(!IdUtils.isEmpty(originalColumnIdNot)){
                        this.originalColumnId_NE = originalColumnIdNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery originalColumnIdIn(PK originalColumnIdIn) {
                    if(!IdUtils.isEmpty(originalColumnIdIn)){
                        if(this.originalColumnId_IN == null){
                            this.originalColumnId_IN = new ArrayList<PK>();
                        }
                        this.originalColumnId_IN.add( originalColumnIdIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery originalColumnIdNotIn(PK originalColumnIdNotIn) {
                    if(!IdUtils.isEmpty(originalColumnIdNotIn)){
                        if(this.originalColumnId_NOTIN == null){
                            this.originalColumnId_NOTIN = new ArrayList<PK>();
                        }
                        this.originalColumnId_NOTIN.add( originalColumnIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery originalColumnIdIsNull() {
                    this.isNulls.add("originalColumnId");
                    return this;
                }



                @Override
                public TcgExColumnQuery originalColumnIdIsNotNull() {
                    this.isNotNulls.add("originalColumnId");
                    return this;
                }















                @Override
                public TcgExColumnQuery javaSimpleClass(String javaSimpleClass) {
                    if(!IdUtils.isEmpty(javaSimpleClass)){
                        this.javaSimpleClass = javaSimpleClass;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaSimpleClassNot(String javaSimpleClassNot) {
                    if(!IdUtils.isEmpty(javaSimpleClassNot)){
                        this.javaSimpleClass_NE = javaSimpleClassNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery javaSimpleClassLike(String javaSimpleClassLike) {
                    if(!IdUtils.isEmpty(javaSimpleClassLike)){
                        this.javaSimpleClass_LIKE = javaSimpleClassLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaSimpleClassNotLike(String javaSimpleClassNotLike) {
                    if(!IdUtils.isEmpty(javaSimpleClassNotLike)){
                        this.javaSimpleClass_NOTLIKE = javaSimpleClassNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery javaSimpleClassIn(String javaSimpleClassIn) {
                    if(!IdUtils.isEmpty(javaSimpleClassIn)){
                        if(this.javaSimpleClass_IN == null){
                            this.javaSimpleClass_IN = new ArrayList<String>();
                        }
                        this.javaSimpleClass_IN.add( javaSimpleClassIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaSimpleClassNotIn(String javaSimpleClassNotIn) {
                    if(!IdUtils.isEmpty(javaSimpleClassNotIn)){
                        if(this.javaSimpleClass_NOTIN == null){
                            this.javaSimpleClass_NOTIN = new ArrayList<String>();
                        }
                        this.javaSimpleClass_NOTIN.add( javaSimpleClassNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaSimpleClassIsNull() {
                    this.isNulls.add("javaSimpleClass");
                    return this;
                }



                @Override
                public TcgExColumnQuery javaSimpleClassIsNotNull() {
                    this.isNotNulls.add("javaSimpleClass");
                    return this;
                }













                @Override
                public TcgExColumnQuery javaFullClass(String javaFullClass) {
                    if(!IdUtils.isEmpty(javaFullClass)){
                        this.javaFullClass = javaFullClass;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaFullClassNot(String javaFullClassNot) {
                    if(!IdUtils.isEmpty(javaFullClassNot)){
                        this.javaFullClass_NE = javaFullClassNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery javaFullClassLike(String javaFullClassLike) {
                    if(!IdUtils.isEmpty(javaFullClassLike)){
                        this.javaFullClass_LIKE = javaFullClassLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaFullClassNotLike(String javaFullClassNotLike) {
                    if(!IdUtils.isEmpty(javaFullClassNotLike)){
                        this.javaFullClass_NOTLIKE = javaFullClassNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery javaFullClassIn(String javaFullClassIn) {
                    if(!IdUtils.isEmpty(javaFullClassIn)){
                        if(this.javaFullClass_IN == null){
                            this.javaFullClass_IN = new ArrayList<String>();
                        }
                        this.javaFullClass_IN.add( javaFullClassIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaFullClassNotIn(String javaFullClassNotIn) {
                    if(!IdUtils.isEmpty(javaFullClassNotIn)){
                        if(this.javaFullClass_NOTIN == null){
                            this.javaFullClass_NOTIN = new ArrayList<String>();
                        }
                        this.javaFullClass_NOTIN.add( javaFullClassNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaFullClassIsNull() {
                    this.isNulls.add("javaFullClass");
                    return this;
                }



                @Override
                public TcgExColumnQuery javaFullClassIsNotNull() {
                    this.isNotNulls.add("javaFullClass");
                    return this;
                }













                @Override
                public TcgExColumnQuery javaName(String javaName) {
                    if(!IdUtils.isEmpty(javaName)){
                        this.javaName = javaName;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaNameNot(String javaNameNot) {
                    if(!IdUtils.isEmpty(javaNameNot)){
                        this.javaName_NE = javaNameNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery javaNameLike(String javaNameLike) {
                    if(!IdUtils.isEmpty(javaNameLike)){
                        this.javaName_LIKE = javaNameLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaNameNotLike(String javaNameNotLike) {
                    if(!IdUtils.isEmpty(javaNameNotLike)){
                        this.javaName_NOTLIKE = javaNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery javaNameIn(String javaNameIn) {
                    if(!IdUtils.isEmpty(javaNameIn)){
                        if(this.javaName_IN == null){
                            this.javaName_IN = new ArrayList<String>();
                        }
                        this.javaName_IN.add( javaNameIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaNameNotIn(String javaNameNotIn) {
                    if(!IdUtils.isEmpty(javaNameNotIn)){
                        if(this.javaName_NOTIN == null){
                            this.javaName_NOTIN = new ArrayList<String>();
                        }
                        this.javaName_NOTIN.add( javaNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaNameIsNull() {
                    this.isNulls.add("javaName");
                    return this;
                }



                @Override
                public TcgExColumnQuery javaNameIsNotNull() {
                    this.isNotNulls.add("javaName");
                    return this;
                }













            @Override
            public TcgExColumnQuery columnSort(Integer columnSort) {
                if(!IdUtils.isEmpty(columnSort)){
                    this.columnSort = columnSort;
                }
                return this;
            }



            @Override
            public TcgExColumnQuery columnSortNot(Integer columnSortNot) {
                if(!IdUtils.isEmpty(columnSortNot)){
                    this.columnSort_NE = columnSortNot;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery columnSortGreaterThan(Integer columnSortGreaterThan){
                if(columnSortGreaterThan != null){
                    this.columnSort_GT = columnSortGreaterThan;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery columnSortGreaterEqual(Integer columnSortGreaterEqual){
                if(columnSortGreaterEqual != null){
                    this.columnSort_GE = columnSortGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery columnSortLessThan(Integer columnSortLessThan){
                if(columnSortLessThan != null){
                    this.columnSort_LT = columnSortLessThan;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery columnSortLessEqual(Integer columnSortLessEqual){
                if(columnSortLessEqual != null){
                    this.columnSort_LE = columnSortLessEqual;
                }
                return this;
            }












                @Override
                public TcgExColumnQuery columnTitle(String columnTitle) {
                    if(!IdUtils.isEmpty(columnTitle)){
                        this.columnTitle = columnTitle;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery columnTitleNot(String columnTitleNot) {
                    if(!IdUtils.isEmpty(columnTitleNot)){
                        this.columnTitle_NE = columnTitleNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery columnTitleLike(String columnTitleLike) {
                    if(!IdUtils.isEmpty(columnTitleLike)){
                        this.columnTitle_LIKE = columnTitleLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery columnTitleNotLike(String columnTitleNotLike) {
                    if(!IdUtils.isEmpty(columnTitleNotLike)){
                        this.columnTitle_NOTLIKE = columnTitleNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery columnTitleIn(String columnTitleIn) {
                    if(!IdUtils.isEmpty(columnTitleIn)){
                        if(this.columnTitle_IN == null){
                            this.columnTitle_IN = new ArrayList<String>();
                        }
                        this.columnTitle_IN.add( columnTitleIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery columnTitleNotIn(String columnTitleNotIn) {
                    if(!IdUtils.isEmpty(columnTitleNotIn)){
                        if(this.columnTitle_NOTIN == null){
                            this.columnTitle_NOTIN = new ArrayList<String>();
                        }
                        this.columnTitle_NOTIN.add( columnTitleNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery columnTitleIsNull() {
                    this.isNulls.add("columnTitle");
                    return this;
                }



                @Override
                public TcgExColumnQuery columnTitleIsNotNull() {
                    this.isNotNulls.add("columnTitle");
                    return this;
                }













                @Override
                public TcgExColumnQuery fkColumnName(String fkColumnName) {
                    if(!IdUtils.isEmpty(fkColumnName)){
                        this.fkColumnName = fkColumnName;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery fkColumnNameNot(String fkColumnNameNot) {
                    if(!IdUtils.isEmpty(fkColumnNameNot)){
                        this.fkColumnName_NE = fkColumnNameNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery fkColumnNameLike(String fkColumnNameLike) {
                    if(!IdUtils.isEmpty(fkColumnNameLike)){
                        this.fkColumnName_LIKE = fkColumnNameLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery fkColumnNameNotLike(String fkColumnNameNotLike) {
                    if(!IdUtils.isEmpty(fkColumnNameNotLike)){
                        this.fkColumnName_NOTLIKE = fkColumnNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery fkColumnNameIn(String fkColumnNameIn) {
                    if(!IdUtils.isEmpty(fkColumnNameIn)){
                        if(this.fkColumnName_IN == null){
                            this.fkColumnName_IN = new ArrayList<String>();
                        }
                        this.fkColumnName_IN.add( fkColumnNameIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery fkColumnNameNotIn(String fkColumnNameNotIn) {
                    if(!IdUtils.isEmpty(fkColumnNameNotIn)){
                        if(this.fkColumnName_NOTIN == null){
                            this.fkColumnName_NOTIN = new ArrayList<String>();
                        }
                        this.fkColumnName_NOTIN.add( fkColumnNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery fkColumnNameIsNull() {
                    this.isNulls.add("fkColumnName");
                    return this;
                }



                @Override
                public TcgExColumnQuery fkColumnNameIsNotNull() {
                    this.isNotNulls.add("fkColumnName");
                    return this;
                }













            @Override
            public TcgExColumnQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgExColumnQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgExColumnQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgExColumnQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgExColumnQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgExColumnQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgExColumnQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgExColumnQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgExColumnQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgExColumnQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}