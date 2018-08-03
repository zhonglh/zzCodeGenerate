package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgCodeBuildLogQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 代码生成记录 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-3 11:23:12
 */
public class TcgCodeBuildLogQueryImpl<PK extends Serializable> extends TcgCodeBuildLogAbstractQueryImpl<PK> implements TcgCodeBuildLogQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> projectId_IN;
            private List<PK> projectId_NOTIN;













            private List<PK> templetGroupId_IN;
            private List<PK> templetGroupId_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgCodeBuildLogQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgCodeBuildLogQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgCodeBuildLogQuery projectId(PK projectId) {
                    if(!IdUtils.isEmpty(projectId)){
                        this.projectId = projectId;
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery projectIdNot(PK projectIdNot) {
                    if(!IdUtils.isEmpty(projectIdNot)){
                        this.projectId_NE = projectIdNot;
                    }
                    return this;
                }

                @Override
                public TcgCodeBuildLogQuery projectIdIn(PK projectIdIn) {
                    if(!IdUtils.isEmpty(projectIdIn)){
                        if(this.projectId_IN == null){
                            this.projectId_IN = new ArrayList<PK>();
                        }
                        this.projectId_IN.add( projectIdIn );
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery projectIdNotIn(PK projectIdNotIn) {
                    if(!IdUtils.isEmpty(projectIdNotIn)){
                        if(this.projectId_NOTIN == null){
                            this.projectId_NOTIN = new ArrayList<PK>();
                        }
                        this.projectId_NOTIN.add( projectIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery projectIdIsNull() {
                    this.isNulls.add("projectId");
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery projectIdIsNotNull() {
                    this.isNotNulls.add("projectId");
                    return this;
                }















                @Override
                public TcgCodeBuildLogQuery templetGroupId(PK templetGroupId) {
                    if(!IdUtils.isEmpty(templetGroupId)){
                        this.templetGroupId = templetGroupId;
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery templetGroupIdNot(PK templetGroupIdNot) {
                    if(!IdUtils.isEmpty(templetGroupIdNot)){
                        this.templetGroupId_NE = templetGroupIdNot;
                    }
                    return this;
                }

                @Override
                public TcgCodeBuildLogQuery templetGroupIdIn(PK templetGroupIdIn) {
                    if(!IdUtils.isEmpty(templetGroupIdIn)){
                        if(this.templetGroupId_IN == null){
                            this.templetGroupId_IN = new ArrayList<PK>();
                        }
                        this.templetGroupId_IN.add( templetGroupIdIn );
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery templetGroupIdNotIn(PK templetGroupIdNotIn) {
                    if(!IdUtils.isEmpty(templetGroupIdNotIn)){
                        if(this.templetGroupId_NOTIN == null){
                            this.templetGroupId_NOTIN = new ArrayList<PK>();
                        }
                        this.templetGroupId_NOTIN.add( templetGroupIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery templetGroupIdIsNull() {
                    this.isNulls.add("templetGroupId");
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery templetGroupIdIsNotNull() {
                    this.isNotNulls.add("templetGroupId");
                    return this;
                }















            @Override
            public TcgCodeBuildLogQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgCodeBuildLogQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgCodeBuildLogQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgCodeBuildLogQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgCodeBuildLogQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgCodeBuildLogQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgCodeBuildLogQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgCodeBuildLogQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgCodeBuildLogQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgCodeBuildLogQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgCodeBuildLogQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgCodeBuildLogQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgCodeBuildLogQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgCodeBuildLogQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgCodeBuildLogQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgCodeBuildLogQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgCodeBuildLogQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgCodeBuildLogQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgCodeBuildLogQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgCodeBuildLogQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgCodeBuildLogQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgCodeBuildLogQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgCodeBuildLogQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgCodeBuildLogQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}