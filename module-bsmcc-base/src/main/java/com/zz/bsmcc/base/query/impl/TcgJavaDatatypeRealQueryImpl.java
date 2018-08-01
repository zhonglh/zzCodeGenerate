package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgJavaDatatypeRealQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 数据类型关联 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:15
 */
public class TcgJavaDatatypeRealQueryImpl<PK extends Serializable> extends TcgJavaDatatypeRealAbstractQueryImpl<PK> implements TcgJavaDatatypeRealQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<String> javaType_IN;
            private List<String> javaType_NOTIN;













            private List<String> dataType_IN;
            private List<String> dataType_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgJavaDatatypeRealQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgJavaDatatypeRealQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgJavaDatatypeRealQuery javaType(String javaType) {
                    if(!IdUtils.isEmpty(javaType)){
                        this.javaType = javaType;
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery javaTypeNot(String javaTypeNot) {
                    if(!IdUtils.isEmpty(javaTypeNot)){
                        this.javaType_NE = javaTypeNot;
                    }
                    return this;
                }




                @Override
                public TcgJavaDatatypeRealQuery javaTypeLike(String javaTypeLike) {
                    if(!IdUtils.isEmpty(javaTypeLike)){
                        this.javaType_LIKE = javaTypeLike;
                    }
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery javaTypeNotLike(String javaTypeNotLike) {
                    if(!IdUtils.isEmpty(javaTypeNotLike)){
                        this.javaType_NOTLIKE = javaTypeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgJavaDatatypeRealQuery javaTypeIn(String javaTypeIn) {
                    if(!IdUtils.isEmpty(javaTypeIn)){
                        if(this.javaType_IN == null){
                            this.javaType_IN = new ArrayList<String>();
                        }
                        this.javaType_IN.add( javaTypeIn );
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery javaTypeNotIn(String javaTypeNotIn) {
                    if(!IdUtils.isEmpty(javaTypeNotIn)){
                        if(this.javaType_NOTIN == null){
                            this.javaType_NOTIN = new ArrayList<String>();
                        }
                        this.javaType_NOTIN.add( javaTypeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery javaTypeIsNull() {
                    this.isNulls.add("javaType");
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery javaTypeIsNotNull() {
                    this.isNotNulls.add("javaType");
                    return this;
                }













                @Override
                public TcgJavaDatatypeRealQuery dataType(String dataType) {
                    if(!IdUtils.isEmpty(dataType)){
                        this.dataType = dataType;
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery dataTypeNot(String dataTypeNot) {
                    if(!IdUtils.isEmpty(dataTypeNot)){
                        this.dataType_NE = dataTypeNot;
                    }
                    return this;
                }




                @Override
                public TcgJavaDatatypeRealQuery dataTypeLike(String dataTypeLike) {
                    if(!IdUtils.isEmpty(dataTypeLike)){
                        this.dataType_LIKE = dataTypeLike;
                    }
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery dataTypeNotLike(String dataTypeNotLike) {
                    if(!IdUtils.isEmpty(dataTypeNotLike)){
                        this.dataType_NOTLIKE = dataTypeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgJavaDatatypeRealQuery dataTypeIn(String dataTypeIn) {
                    if(!IdUtils.isEmpty(dataTypeIn)){
                        if(this.dataType_IN == null){
                            this.dataType_IN = new ArrayList<String>();
                        }
                        this.dataType_IN.add( dataTypeIn );
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery dataTypeNotIn(String dataTypeNotIn) {
                    if(!IdUtils.isEmpty(dataTypeNotIn)){
                        if(this.dataType_NOTIN == null){
                            this.dataType_NOTIN = new ArrayList<String>();
                        }
                        this.dataType_NOTIN.add( dataTypeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery dataTypeIsNull() {
                    this.isNulls.add("dataType");
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery dataTypeIsNotNull() {
                    this.isNotNulls.add("dataType");
                    return this;
                }













            @Override
            public TcgJavaDatatypeRealQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgJavaDatatypeRealQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgJavaDatatypeRealQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgJavaDatatypeRealQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgJavaDatatypeRealQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgJavaDatatypeRealQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgJavaDatatypeRealQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgJavaDatatypeRealQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgJavaDatatypeRealQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgJavaDatatypeRealQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgJavaDatatypeRealQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgJavaDatatypeRealQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgJavaDatatypeRealQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgJavaDatatypeRealQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgJavaDatatypeRealQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgJavaDatatypeRealQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgJavaDatatypeRealQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgJavaDatatypeRealQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgJavaDatatypeRealQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgJavaDatatypeRealQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgJavaDatatypeRealQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgJavaDatatypeRealQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgJavaDatatypeRealQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgJavaDatatypeRealQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}