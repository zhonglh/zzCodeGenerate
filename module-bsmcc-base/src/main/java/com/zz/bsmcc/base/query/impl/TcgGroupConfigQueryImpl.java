package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgGroupConfigQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 组设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:58
 */
public class TcgGroupConfigQueryImpl<PK extends Serializable> extends TcgGroupConfigAbstractQueryImpl<PK> implements TcgGroupConfigQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> projectId_IN;
            private List<PK> projectId_NOTIN;













            private List<String> moduleName_IN;
            private List<String> moduleName_NOTIN;













            private List<String> groupCode_IN;
            private List<String> groupCode_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgGroupConfigQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgGroupConfigQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgGroupConfigQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgGroupConfigQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgGroupConfigQuery projectId(PK projectId) {
                    if(!IdUtils.isEmpty(projectId)){
                        this.projectId = projectId;
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery projectIdNot(PK projectIdNot) {
                    if(!IdUtils.isEmpty(projectIdNot)){
                        this.projectId_NE = projectIdNot;
                    }
                    return this;
                }

                @Override
                public TcgGroupConfigQuery projectIdIn(PK projectIdIn) {
                    if(!IdUtils.isEmpty(projectIdIn)){
                        if(this.projectId_IN == null){
                            this.projectId_IN = new ArrayList<PK>();
                        }
                        this.projectId_IN.add( projectIdIn );
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery projectIdNotIn(PK projectIdNotIn) {
                    if(!IdUtils.isEmpty(projectIdNotIn)){
                        if(this.projectId_NOTIN == null){
                            this.projectId_NOTIN = new ArrayList<PK>();
                        }
                        this.projectId_NOTIN.add( projectIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgGroupConfigQuery projectIdIsNull() {
                    this.isNulls.add("projectId");
                    return this;
                }



                @Override
                public TcgGroupConfigQuery projectIdIsNotNull() {
                    this.isNotNulls.add("projectId");
                    return this;
                }















                @Override
                public TcgGroupConfigQuery moduleName(String moduleName) {
                    if(!IdUtils.isEmpty(moduleName)){
                        this.moduleName = moduleName;
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery moduleNameNot(String moduleNameNot) {
                    if(!IdUtils.isEmpty(moduleNameNot)){
                        this.moduleName_NE = moduleNameNot;
                    }
                    return this;
                }




                @Override
                public TcgGroupConfigQuery moduleNameLike(String moduleNameLike) {
                    if(!IdUtils.isEmpty(moduleNameLike)){
                        this.moduleName_LIKE = moduleNameLike;
                    }
                    return this;
                }



                @Override
                public TcgGroupConfigQuery moduleNameNotLike(String moduleNameNotLike) {
                    if(!IdUtils.isEmpty(moduleNameNotLike)){
                        this.moduleName_NOTLIKE = moduleNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgGroupConfigQuery moduleNameIn(String moduleNameIn) {
                    if(!IdUtils.isEmpty(moduleNameIn)){
                        if(this.moduleName_IN == null){
                            this.moduleName_IN = new ArrayList<String>();
                        }
                        this.moduleName_IN.add( moduleNameIn );
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery moduleNameNotIn(String moduleNameNotIn) {
                    if(!IdUtils.isEmpty(moduleNameNotIn)){
                        if(this.moduleName_NOTIN == null){
                            this.moduleName_NOTIN = new ArrayList<String>();
                        }
                        this.moduleName_NOTIN.add( moduleNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgGroupConfigQuery moduleNameIsNull() {
                    this.isNulls.add("moduleName");
                    return this;
                }



                @Override
                public TcgGroupConfigQuery moduleNameIsNotNull() {
                    this.isNotNulls.add("moduleName");
                    return this;
                }













                @Override
                public TcgGroupConfigQuery groupCode(String groupCode) {
                    if(!IdUtils.isEmpty(groupCode)){
                        this.groupCode = groupCode;
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery groupCodeNot(String groupCodeNot) {
                    if(!IdUtils.isEmpty(groupCodeNot)){
                        this.groupCode_NE = groupCodeNot;
                    }
                    return this;
                }




                @Override
                public TcgGroupConfigQuery groupCodeLike(String groupCodeLike) {
                    if(!IdUtils.isEmpty(groupCodeLike)){
                        this.groupCode_LIKE = groupCodeLike;
                    }
                    return this;
                }



                @Override
                public TcgGroupConfigQuery groupCodeNotLike(String groupCodeNotLike) {
                    if(!IdUtils.isEmpty(groupCodeNotLike)){
                        this.groupCode_NOTLIKE = groupCodeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgGroupConfigQuery groupCodeIn(String groupCodeIn) {
                    if(!IdUtils.isEmpty(groupCodeIn)){
                        if(this.groupCode_IN == null){
                            this.groupCode_IN = new ArrayList<String>();
                        }
                        this.groupCode_IN.add( groupCodeIn );
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery groupCodeNotIn(String groupCodeNotIn) {
                    if(!IdUtils.isEmpty(groupCodeNotIn)){
                        if(this.groupCode_NOTIN == null){
                            this.groupCode_NOTIN = new ArrayList<String>();
                        }
                        this.groupCode_NOTIN.add( groupCodeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgGroupConfigQuery groupCodeIsNull() {
                    this.isNulls.add("groupCode");
                    return this;
                }



                @Override
                public TcgGroupConfigQuery groupCodeIsNotNull() {
                    this.isNotNulls.add("groupCode");
                    return this;
                }













            @Override
            public TcgGroupConfigQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgGroupConfigQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgGroupConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgGroupConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgGroupConfigQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgGroupConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgGroupConfigQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgGroupConfigQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgGroupConfigQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgGroupConfigQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgGroupConfigQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgGroupConfigQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgGroupConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgGroupConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgGroupConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgGroupConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgGroupConfigQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgGroupConfigQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgGroupConfigQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgGroupConfigQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgGroupConfigQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgGroupConfigQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgGroupConfigQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgGroupConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgGroupConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgGroupConfigQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgGroupConfigQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}