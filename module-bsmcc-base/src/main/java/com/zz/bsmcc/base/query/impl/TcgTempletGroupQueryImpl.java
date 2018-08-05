package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgTempletGroupQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 模板组 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-5 15:16:00
 */
public class TcgTempletGroupQueryImpl<PK extends Serializable> extends TcgTempletGroupAbstractQueryImpl<PK> implements TcgTempletGroupQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<String> groupName_IN;
            private List<String> groupName_NOTIN;













            private List<String> groupRemark_IN;
            private List<String> groupRemark_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;























            private List<String> deleteFlag_IN;
            private List<String> deleteFlag_NOTIN;

























                @Override
                public TcgTempletGroupQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgTempletGroupQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgTempletGroupQuery groupName(String groupName) {
                    if(!IdUtils.isEmpty(groupName)){
                        this.groupName = groupName;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery groupNameNot(String groupNameNot) {
                    if(!IdUtils.isEmpty(groupNameNot)){
                        this.groupName_NE = groupNameNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGroupQuery groupNameLike(String groupNameLike) {
                    if(!IdUtils.isEmpty(groupNameLike)){
                        this.groupName_LIKE = groupNameLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupQuery groupNameNotLike(String groupNameNotLike) {
                    if(!IdUtils.isEmpty(groupNameNotLike)){
                        this.groupName_NOTLIKE = groupNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupQuery groupNameIn(String groupNameIn) {
                    if(!IdUtils.isEmpty(groupNameIn)){
                        if(this.groupName_IN == null){
                            this.groupName_IN = new ArrayList<String>();
                        }
                        this.groupName_IN.add( groupNameIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery groupNameNotIn(String groupNameNotIn) {
                    if(!IdUtils.isEmpty(groupNameNotIn)){
                        if(this.groupName_NOTIN == null){
                            this.groupName_NOTIN = new ArrayList<String>();
                        }
                        this.groupName_NOTIN.add( groupNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupQuery groupNameIsNull() {
                    this.isNulls.add("groupName");
                    return this;
                }



                @Override
                public TcgTempletGroupQuery groupNameIsNotNull() {
                    this.isNotNulls.add("groupName");
                    return this;
                }













                @Override
                public TcgTempletGroupQuery groupRemark(String groupRemark) {
                    if(!IdUtils.isEmpty(groupRemark)){
                        this.groupRemark = groupRemark;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery groupRemarkNot(String groupRemarkNot) {
                    if(!IdUtils.isEmpty(groupRemarkNot)){
                        this.groupRemark_NE = groupRemarkNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGroupQuery groupRemarkLike(String groupRemarkLike) {
                    if(!IdUtils.isEmpty(groupRemarkLike)){
                        this.groupRemark_LIKE = groupRemarkLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupQuery groupRemarkNotLike(String groupRemarkNotLike) {
                    if(!IdUtils.isEmpty(groupRemarkNotLike)){
                        this.groupRemark_NOTLIKE = groupRemarkNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupQuery groupRemarkIn(String groupRemarkIn) {
                    if(!IdUtils.isEmpty(groupRemarkIn)){
                        if(this.groupRemark_IN == null){
                            this.groupRemark_IN = new ArrayList<String>();
                        }
                        this.groupRemark_IN.add( groupRemarkIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery groupRemarkNotIn(String groupRemarkNotIn) {
                    if(!IdUtils.isEmpty(groupRemarkNotIn)){
                        if(this.groupRemark_NOTIN == null){
                            this.groupRemark_NOTIN = new ArrayList<String>();
                        }
                        this.groupRemark_NOTIN.add( groupRemarkNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupQuery groupRemarkIsNull() {
                    this.isNulls.add("groupRemark");
                    return this;
                }



                @Override
                public TcgTempletGroupQuery groupRemarkIsNotNull() {
                    this.isNotNulls.add("groupRemark");
                    return this;
                }













            @Override
            public TcgTempletGroupQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgTempletGroupQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgTempletGroupQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTempletGroupQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTempletGroupQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgTempletGroupQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgTempletGroupQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgTempletGroupQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgTempletGroupQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgTempletGroupQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgTempletGroupQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTempletGroupQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTempletGroupQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgTempletGroupQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgTempletGroupQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgTempletGroupQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgTempletGroupQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgTempletGroupQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgTempletGroupQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTempletGroupQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTempletGroupQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgTempletGroupQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }












                @Override
                public TcgTempletGroupQuery deleteFlag(String deleteFlag) {
                    if(!IdUtils.isEmpty(deleteFlag)){
                        this.deleteFlag = deleteFlag;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupQuery deleteFlagNot(String deleteFlagNot) {
                    if(!IdUtils.isEmpty(deleteFlagNot)){
                        this.deleteFlag_NE = deleteFlagNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupQuery deleteFlagIn(String deleteFlagIn) {
                    if(!IdUtils.isEmpty(deleteFlagIn)){
                        if(this.deleteFlag_IN == null){
                            this.deleteFlag_IN = new ArrayList<String>();
                        }
                        this.deleteFlag_IN.add( deleteFlagIn );
                    }
                    return this;
                }


                @Override
                    public TcgTempletGroupQuery deleteFlagNotIn(String deleteFlagNotIn) {
                    if(!IdUtils.isEmpty(deleteFlagNotIn)){
                        if(this.deleteFlag_NOTIN == null){
                            this.deleteFlag_NOTIN = new ArrayList<String>();
                        }
                        this.deleteFlag_NOTIN.add( deleteFlagNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgTempletGroupQuery deleteFlagIsNull() {
                    this.isNulls.add("deleteFlag");
                    return this;
                }



                @Override
                public TcgTempletGroupQuery deleteFlagIsNotNull() {
                    this.isNotNulls.add("deleteFlag");
                    return this;
                }









	
}