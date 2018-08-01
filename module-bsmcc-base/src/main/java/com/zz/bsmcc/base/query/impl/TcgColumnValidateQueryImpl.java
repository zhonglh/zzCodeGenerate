package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgColumnValidateQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 列校验 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:14
 */
public class TcgColumnValidateQueryImpl<PK extends Serializable> extends TcgColumnValidateAbstractQueryImpl<PK> implements TcgColumnValidateQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> tableId_IN;
            private List<PK> tableId_NOTIN;













            private List<PK> columnId_IN;
            private List<PK> columnId_NOTIN;













            private List<String> rex_IN;
            private List<String> rex_NOTIN;













            private List<String> msg_IN;
            private List<String> msg_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgColumnValidateQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnValidateQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgColumnValidateQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgColumnValidateQuery tableId(PK tableId) {
                    if(!IdUtils.isEmpty(tableId)){
                        this.tableId = tableId;
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery tableIdNot(PK tableIdNot) {
                    if(!IdUtils.isEmpty(tableIdNot)){
                        this.tableId_NE = tableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnValidateQuery tableIdIn(PK tableIdIn) {
                    if(!IdUtils.isEmpty(tableIdIn)){
                        if(this.tableId_IN == null){
                            this.tableId_IN = new ArrayList<PK>();
                        }
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
                        if(this.tableId_NOTIN == null){
                            this.tableId_NOTIN = new ArrayList<PK>();
                        }
                        this.tableId_NOTIN.add( tableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery tableIdIsNull() {
                    this.isNulls.add("tableId");
                    return this;
                }



                @Override
                public TcgColumnValidateQuery tableIdIsNotNull() {
                    this.isNotNulls.add("tableId");
                    return this;
                }















                @Override
                public TcgColumnValidateQuery columnId(PK columnId) {
                    if(!IdUtils.isEmpty(columnId)){
                        this.columnId = columnId;
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery columnIdNot(PK columnIdNot) {
                    if(!IdUtils.isEmpty(columnIdNot)){
                        this.columnId_NE = columnIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnValidateQuery columnIdIn(PK columnIdIn) {
                    if(!IdUtils.isEmpty(columnIdIn)){
                        if(this.columnId_IN == null){
                            this.columnId_IN = new ArrayList<PK>();
                        }
                        this.columnId_IN.add( columnIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery columnIdNotIn(PK columnIdNotIn) {
                    if(!IdUtils.isEmpty(columnIdNotIn)){
                        if(this.columnId_NOTIN == null){
                            this.columnId_NOTIN = new ArrayList<PK>();
                        }
                        this.columnId_NOTIN.add( columnIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery columnIdIsNull() {
                    this.isNulls.add("columnId");
                    return this;
                }



                @Override
                public TcgColumnValidateQuery columnIdIsNotNull() {
                    this.isNotNulls.add("columnId");
                    return this;
                }















                @Override
                public TcgColumnValidateQuery rex(String rex) {
                    if(!IdUtils.isEmpty(rex)){
                        this.rex = rex;
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery rexNot(String rexNot) {
                    if(!IdUtils.isEmpty(rexNot)){
                        this.rex_NE = rexNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnValidateQuery rexLike(String rexLike) {
                    if(!IdUtils.isEmpty(rexLike)){
                        this.rex_LIKE = rexLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery rexNotLike(String rexNotLike) {
                    if(!IdUtils.isEmpty(rexNotLike)){
                        this.rex_NOTLIKE = rexNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnValidateQuery rexIn(String rexIn) {
                    if(!IdUtils.isEmpty(rexIn)){
                        if(this.rex_IN == null){
                            this.rex_IN = new ArrayList<String>();
                        }
                        this.rex_IN.add( rexIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery rexNotIn(String rexNotIn) {
                    if(!IdUtils.isEmpty(rexNotIn)){
                        if(this.rex_NOTIN == null){
                            this.rex_NOTIN = new ArrayList<String>();
                        }
                        this.rex_NOTIN.add( rexNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery rexIsNull() {
                    this.isNulls.add("rex");
                    return this;
                }



                @Override
                public TcgColumnValidateQuery rexIsNotNull() {
                    this.isNotNulls.add("rex");
                    return this;
                }













                @Override
                public TcgColumnValidateQuery msg(String msg) {
                    if(!IdUtils.isEmpty(msg)){
                        this.msg = msg;
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery msgNot(String msgNot) {
                    if(!IdUtils.isEmpty(msgNot)){
                        this.msg_NE = msgNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnValidateQuery msgLike(String msgLike) {
                    if(!IdUtils.isEmpty(msgLike)){
                        this.msg_LIKE = msgLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery msgNotLike(String msgNotLike) {
                    if(!IdUtils.isEmpty(msgNotLike)){
                        this.msg_NOTLIKE = msgNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnValidateQuery msgIn(String msgIn) {
                    if(!IdUtils.isEmpty(msgIn)){
                        if(this.msg_IN == null){
                            this.msg_IN = new ArrayList<String>();
                        }
                        this.msg_IN.add( msgIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery msgNotIn(String msgNotIn) {
                    if(!IdUtils.isEmpty(msgNotIn)){
                        if(this.msg_NOTIN == null){
                            this.msg_NOTIN = new ArrayList<String>();
                        }
                        this.msg_NOTIN.add( msgNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery msgIsNull() {
                    this.isNulls.add("msg");
                    return this;
                }



                @Override
                public TcgColumnValidateQuery msgIsNotNull() {
                    this.isNotNulls.add("msg");
                    return this;
                }













            @Override
            public TcgColumnValidateQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgColumnValidateQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgColumnValidateQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnValidateQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnValidateQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnValidateQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgColumnValidateQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnValidateQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgColumnValidateQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgColumnValidateQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgColumnValidateQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgColumnValidateQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnValidateQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnValidateQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnValidateQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgColumnValidateQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnValidateQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnValidateQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnValidateQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgColumnValidateQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgColumnValidateQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgColumnValidateQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgColumnValidateQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnValidateQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnValidateQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnValidateQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}