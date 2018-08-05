package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgQueryConfigQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 查询条件设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:59
 */
public class TcgQueryConfigQueryImpl<PK extends Serializable> extends TcgQueryConfigAbstractQueryImpl<PK> implements TcgQueryConfigQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> tableId_IN;
            private List<PK> tableId_NOTIN;













            private List<PK> columnId_IN;
            private List<PK> columnId_NOTIN;













            private List<String> queryTitle_IN;
            private List<String> queryTitle_NOTIN;













            private List<String> queryPlaceholder_IN;
            private List<String> queryPlaceholder_NOTIN;













            private List<String> queryRelation_IN;
            private List<String> queryRelation_NOTIN;

































            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgQueryConfigQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgQueryConfigQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgQueryConfigQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgQueryConfigQuery tableId(PK tableId) {
                    if(!IdUtils.isEmpty(tableId)){
                        this.tableId = tableId;
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery tableIdNot(PK tableIdNot) {
                    if(!IdUtils.isEmpty(tableIdNot)){
                        this.tableId_NE = tableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgQueryConfigQuery tableIdIn(PK tableIdIn) {
                    if(!IdUtils.isEmpty(tableIdIn)){
                        if(this.tableId_IN == null){
                            this.tableId_IN = new ArrayList<PK>();
                        }
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
                        if(this.tableId_NOTIN == null){
                            this.tableId_NOTIN = new ArrayList<PK>();
                        }
                        this.tableId_NOTIN.add( tableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery tableIdIsNull() {
                    this.isNulls.add("tableId");
                    return this;
                }



                @Override
                public TcgQueryConfigQuery tableIdIsNotNull() {
                    this.isNotNulls.add("tableId");
                    return this;
                }















                @Override
                public TcgQueryConfigQuery columnId(PK columnId) {
                    if(!IdUtils.isEmpty(columnId)){
                        this.columnId = columnId;
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery columnIdNot(PK columnIdNot) {
                    if(!IdUtils.isEmpty(columnIdNot)){
                        this.columnId_NE = columnIdNot;
                    }
                    return this;
                }

                @Override
                public TcgQueryConfigQuery columnIdIn(PK columnIdIn) {
                    if(!IdUtils.isEmpty(columnIdIn)){
                        if(this.columnId_IN == null){
                            this.columnId_IN = new ArrayList<PK>();
                        }
                        this.columnId_IN.add( columnIdIn );
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery columnIdNotIn(PK columnIdNotIn) {
                    if(!IdUtils.isEmpty(columnIdNotIn)){
                        if(this.columnId_NOTIN == null){
                            this.columnId_NOTIN = new ArrayList<PK>();
                        }
                        this.columnId_NOTIN.add( columnIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery columnIdIsNull() {
                    this.isNulls.add("columnId");
                    return this;
                }



                @Override
                public TcgQueryConfigQuery columnIdIsNotNull() {
                    this.isNotNulls.add("columnId");
                    return this;
                }















                @Override
                public TcgQueryConfigQuery queryTitle(String queryTitle) {
                    if(!IdUtils.isEmpty(queryTitle)){
                        this.queryTitle = queryTitle;
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery queryTitleNot(String queryTitleNot) {
                    if(!IdUtils.isEmpty(queryTitleNot)){
                        this.queryTitle_NE = queryTitleNot;
                    }
                    return this;
                }




                @Override
                public TcgQueryConfigQuery queryTitleLike(String queryTitleLike) {
                    if(!IdUtils.isEmpty(queryTitleLike)){
                        this.queryTitle_LIKE = queryTitleLike;
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryTitleNotLike(String queryTitleNotLike) {
                    if(!IdUtils.isEmpty(queryTitleNotLike)){
                        this.queryTitle_NOTLIKE = queryTitleNotLike;
                    }
                    return this;
                }

                @Override
                public TcgQueryConfigQuery queryTitleIn(String queryTitleIn) {
                    if(!IdUtils.isEmpty(queryTitleIn)){
                        if(this.queryTitle_IN == null){
                            this.queryTitle_IN = new ArrayList<String>();
                        }
                        this.queryTitle_IN.add( queryTitleIn );
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery queryTitleNotIn(String queryTitleNotIn) {
                    if(!IdUtils.isEmpty(queryTitleNotIn)){
                        if(this.queryTitle_NOTIN == null){
                            this.queryTitle_NOTIN = new ArrayList<String>();
                        }
                        this.queryTitle_NOTIN.add( queryTitleNotIn );
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryTitleIsNull() {
                    this.isNulls.add("queryTitle");
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryTitleIsNotNull() {
                    this.isNotNulls.add("queryTitle");
                    return this;
                }













                @Override
                public TcgQueryConfigQuery queryPlaceholder(String queryPlaceholder) {
                    if(!IdUtils.isEmpty(queryPlaceholder)){
                        this.queryPlaceholder = queryPlaceholder;
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery queryPlaceholderNot(String queryPlaceholderNot) {
                    if(!IdUtils.isEmpty(queryPlaceholderNot)){
                        this.queryPlaceholder_NE = queryPlaceholderNot;
                    }
                    return this;
                }




                @Override
                public TcgQueryConfigQuery queryPlaceholderLike(String queryPlaceholderLike) {
                    if(!IdUtils.isEmpty(queryPlaceholderLike)){
                        this.queryPlaceholder_LIKE = queryPlaceholderLike;
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryPlaceholderNotLike(String queryPlaceholderNotLike) {
                    if(!IdUtils.isEmpty(queryPlaceholderNotLike)){
                        this.queryPlaceholder_NOTLIKE = queryPlaceholderNotLike;
                    }
                    return this;
                }

                @Override
                public TcgQueryConfigQuery queryPlaceholderIn(String queryPlaceholderIn) {
                    if(!IdUtils.isEmpty(queryPlaceholderIn)){
                        if(this.queryPlaceholder_IN == null){
                            this.queryPlaceholder_IN = new ArrayList<String>();
                        }
                        this.queryPlaceholder_IN.add( queryPlaceholderIn );
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery queryPlaceholderNotIn(String queryPlaceholderNotIn) {
                    if(!IdUtils.isEmpty(queryPlaceholderNotIn)){
                        if(this.queryPlaceholder_NOTIN == null){
                            this.queryPlaceholder_NOTIN = new ArrayList<String>();
                        }
                        this.queryPlaceholder_NOTIN.add( queryPlaceholderNotIn );
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryPlaceholderIsNull() {
                    this.isNulls.add("queryPlaceholder");
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryPlaceholderIsNotNull() {
                    this.isNotNulls.add("queryPlaceholder");
                    return this;
                }













                @Override
                public TcgQueryConfigQuery queryRelation(String queryRelation) {
                    if(!IdUtils.isEmpty(queryRelation)){
                        this.queryRelation = queryRelation;
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery queryRelationNot(String queryRelationNot) {
                    if(!IdUtils.isEmpty(queryRelationNot)){
                        this.queryRelation_NE = queryRelationNot;
                    }
                    return this;
                }




                @Override
                public TcgQueryConfigQuery queryRelationLike(String queryRelationLike) {
                    if(!IdUtils.isEmpty(queryRelationLike)){
                        this.queryRelation_LIKE = queryRelationLike;
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryRelationNotLike(String queryRelationNotLike) {
                    if(!IdUtils.isEmpty(queryRelationNotLike)){
                        this.queryRelation_NOTLIKE = queryRelationNotLike;
                    }
                    return this;
                }

                @Override
                public TcgQueryConfigQuery queryRelationIn(String queryRelationIn) {
                    if(!IdUtils.isEmpty(queryRelationIn)){
                        if(this.queryRelation_IN == null){
                            this.queryRelation_IN = new ArrayList<String>();
                        }
                        this.queryRelation_IN.add( queryRelationIn );
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery queryRelationNotIn(String queryRelationNotIn) {
                    if(!IdUtils.isEmpty(queryRelationNotIn)){
                        if(this.queryRelation_NOTIN == null){
                            this.queryRelation_NOTIN = new ArrayList<String>();
                        }
                        this.queryRelation_NOTIN.add( queryRelationNotIn );
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryRelationIsNull() {
                    this.isNulls.add("queryRelation");
                    return this;
                }



                @Override
                public TcgQueryConfigQuery queryRelationIsNotNull() {
                    this.isNotNulls.add("queryRelation");
                    return this;
                }













            @Override
            public TcgQueryConfigQuery querySort(Integer querySort) {
                if(!IdUtils.isEmpty(querySort)){
                    this.querySort = querySort;
                }
                return this;
            }



            @Override
            public TcgQueryConfigQuery querySortNot(Integer querySortNot) {
                if(!IdUtils.isEmpty(querySortNot)){
                    this.querySort_NE = querySortNot;
                }
                return this;
            }

            @Override
            public TcgQueryConfigQuery querySortGreaterThan(Integer querySortGreaterThan){
                if(querySortGreaterThan != null){
                    this.querySort_GT = querySortGreaterThan;
                }
                return this;
            }


            @Override
            public TcgQueryConfigQuery querySortGreaterEqual(Integer querySortGreaterEqual){
                if(querySortGreaterEqual != null){
                    this.querySort_GE = querySortGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgQueryConfigQuery querySortLessThan(Integer querySortLessThan){
                if(querySortLessThan != null){
                    this.querySort_LT = querySortLessThan;
                }
                return this;
            }

            @Override
            public TcgQueryConfigQuery querySortLessEqual(Integer querySortLessEqual){
                if(querySortLessEqual != null){
                    this.querySort_LE = querySortLessEqual;
                }
                return this;
            }












            @Override
            public TcgQueryConfigQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgQueryConfigQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgQueryConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgQueryConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgQueryConfigQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgQueryConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgQueryConfigQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgQueryConfigQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgQueryConfigQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgQueryConfigQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgQueryConfigQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgQueryConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgQueryConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgQueryConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgQueryConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgQueryConfigQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgQueryConfigQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgQueryConfigQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgQueryConfigQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgQueryConfigQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgQueryConfigQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgQueryConfigQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgQueryConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgQueryConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgQueryConfigQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgQueryConfigQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}