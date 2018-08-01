package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgOperationQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 操作表 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:15
 */
public class TcgOperationQueryImpl<PK extends Serializable> extends TcgOperationAbstractQueryImpl<PK> implements TcgOperationQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<String> operationName_IN;
            private List<String> operationName_NOTIN;













            private List<String> operationResource_IN;
            private List<String> operationResource_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;























            private List<String> deleteFlag_IN;
            private List<String> deleteFlag_NOTIN;

























                @Override
                public TcgOperationQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgOperationQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgOperationQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgOperationQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgOperationQuery operationName(String operationName) {
                    if(!IdUtils.isEmpty(operationName)){
                        this.operationName = operationName;
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery operationNameNot(String operationNameNot) {
                    if(!IdUtils.isEmpty(operationNameNot)){
                        this.operationName_NE = operationNameNot;
                    }
                    return this;
                }




                @Override
                public TcgOperationQuery operationNameLike(String operationNameLike) {
                    if(!IdUtils.isEmpty(operationNameLike)){
                        this.operationName_LIKE = operationNameLike;
                    }
                    return this;
                }



                @Override
                public TcgOperationQuery operationNameNotLike(String operationNameNotLike) {
                    if(!IdUtils.isEmpty(operationNameNotLike)){
                        this.operationName_NOTLIKE = operationNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgOperationQuery operationNameIn(String operationNameIn) {
                    if(!IdUtils.isEmpty(operationNameIn)){
                        if(this.operationName_IN == null){
                            this.operationName_IN = new ArrayList<String>();
                        }
                        this.operationName_IN.add( operationNameIn );
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery operationNameNotIn(String operationNameNotIn) {
                    if(!IdUtils.isEmpty(operationNameNotIn)){
                        if(this.operationName_NOTIN == null){
                            this.operationName_NOTIN = new ArrayList<String>();
                        }
                        this.operationName_NOTIN.add( operationNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgOperationQuery operationNameIsNull() {
                    this.isNulls.add("operationName");
                    return this;
                }



                @Override
                public TcgOperationQuery operationNameIsNotNull() {
                    this.isNotNulls.add("operationName");
                    return this;
                }













                @Override
                public TcgOperationQuery operationResource(String operationResource) {
                    if(!IdUtils.isEmpty(operationResource)){
                        this.operationResource = operationResource;
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery operationResourceNot(String operationResourceNot) {
                    if(!IdUtils.isEmpty(operationResourceNot)){
                        this.operationResource_NE = operationResourceNot;
                    }
                    return this;
                }




                @Override
                public TcgOperationQuery operationResourceLike(String operationResourceLike) {
                    if(!IdUtils.isEmpty(operationResourceLike)){
                        this.operationResource_LIKE = operationResourceLike;
                    }
                    return this;
                }



                @Override
                public TcgOperationQuery operationResourceNotLike(String operationResourceNotLike) {
                    if(!IdUtils.isEmpty(operationResourceNotLike)){
                        this.operationResource_NOTLIKE = operationResourceNotLike;
                    }
                    return this;
                }

                @Override
                public TcgOperationQuery operationResourceIn(String operationResourceIn) {
                    if(!IdUtils.isEmpty(operationResourceIn)){
                        if(this.operationResource_IN == null){
                            this.operationResource_IN = new ArrayList<String>();
                        }
                        this.operationResource_IN.add( operationResourceIn );
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery operationResourceNotIn(String operationResourceNotIn) {
                    if(!IdUtils.isEmpty(operationResourceNotIn)){
                        if(this.operationResource_NOTIN == null){
                            this.operationResource_NOTIN = new ArrayList<String>();
                        }
                        this.operationResource_NOTIN.add( operationResourceNotIn );
                    }
                    return this;
                }



                @Override
                public TcgOperationQuery operationResourceIsNull() {
                    this.isNulls.add("operationResource");
                    return this;
                }



                @Override
                public TcgOperationQuery operationResourceIsNotNull() {
                    this.isNotNulls.add("operationResource");
                    return this;
                }













            @Override
            public TcgOperationQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgOperationQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgOperationQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgOperationQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgOperationQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgOperationQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgOperationQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgOperationQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgOperationQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgOperationQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgOperationQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgOperationQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgOperationQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgOperationQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgOperationQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgOperationQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgOperationQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgOperationQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgOperationQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgOperationQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgOperationQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgOperationQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgOperationQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgOperationQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgOperationQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgOperationQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }












                @Override
                public TcgOperationQuery deleteFlag(String deleteFlag) {
                    if(!IdUtils.isEmpty(deleteFlag)){
                        this.deleteFlag = deleteFlag;
                    }
                    return this;
                }


                @Override
                public TcgOperationQuery deleteFlagNot(String deleteFlagNot) {
                    if(!IdUtils.isEmpty(deleteFlagNot)){
                        this.deleteFlag_NE = deleteFlagNot;
                    }
                    return this;
                }

                @Override
                public TcgOperationQuery deleteFlagIn(String deleteFlagIn) {
                    if(!IdUtils.isEmpty(deleteFlagIn)){
                        if(this.deleteFlag_IN == null){
                            this.deleteFlag_IN = new ArrayList<String>();
                        }
                        this.deleteFlag_IN.add( deleteFlagIn );
                    }
                    return this;
                }


                @Override
                    public TcgOperationQuery deleteFlagNotIn(String deleteFlagNotIn) {
                    if(!IdUtils.isEmpty(deleteFlagNotIn)){
                        if(this.deleteFlag_NOTIN == null){
                            this.deleteFlag_NOTIN = new ArrayList<String>();
                        }
                        this.deleteFlag_NOTIN.add( deleteFlagNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgOperationQuery deleteFlagIsNull() {
                    this.isNulls.add("deleteFlag");
                    return this;
                }



                @Override
                public TcgOperationQuery deleteFlagIsNotNull() {
                    this.isNotNulls.add("deleteFlag");
                    return this;
                }









	
}