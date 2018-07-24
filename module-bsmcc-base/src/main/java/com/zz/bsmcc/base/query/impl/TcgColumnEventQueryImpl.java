package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgColumnEventQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 列事件 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 12:32:13
 */
public class TcgColumnEventQueryImpl<PK extends Serializable> extends TcgColumnEventAbstractQueryImpl<PK> implements TcgColumnEventQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> columnId_IN;
            private List<PK> columnId_NOTIN;













            private List<String> eventName_IN;
            private List<String> eventName_NOTIN;













            private List<String> funcBody_IN;
            private List<String> funcBody_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgColumnEventQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnEventQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnEventQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgColumnEventQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgColumnEventQuery columnId(PK columnId) {
                    if(!IdUtils.isEmpty(columnId)){
                        this.columnId = columnId;
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery columnIdNot(PK columnIdNot) {
                    if(!IdUtils.isEmpty(columnIdNot)){
                        this.columnId_NE = columnIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnEventQuery columnIdIn(PK columnIdIn) {
                    if(!IdUtils.isEmpty(columnIdIn)){
                        this.columnId_IN.add( columnIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery columnIdNotIn(PK columnIdNotIn) {
                    if(!IdUtils.isEmpty(columnIdNotIn)){
                        this.columnId_NOTIN.add( columnIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnEventQuery columnIdIsNull() {
                    this.isNulls.add("columnId");
                    return this;
                }



                @Override
                public TcgColumnEventQuery columnIdIsNotNull() {
                    this.isNotNulls.add("columnId");
                    return this;
                }















                @Override
                public TcgColumnEventQuery eventName(String eventName) {
                    if(!IdUtils.isEmpty(eventName)){
                        this.eventName = eventName;
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery eventNameNot(String eventNameNot) {
                    if(!IdUtils.isEmpty(eventNameNot)){
                        this.eventName_NE = eventNameNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnEventQuery eventNameLike(String eventNameLike) {
                    if(!IdUtils.isEmpty(eventNameLike)){
                        this.eventName_LIKE = eventNameLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnEventQuery eventNameNotLike(String eventNameNotLike) {
                    if(!IdUtils.isEmpty(eventNameNotLike)){
                        this.eventName_NOTLIKE = eventNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnEventQuery eventNameIn(String eventNameIn) {
                    if(!IdUtils.isEmpty(eventNameIn)){
                        this.eventName_IN.add( eventNameIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery eventNameNotIn(String eventNameNotIn) {
                    if(!IdUtils.isEmpty(eventNameNotIn)){
                        this.eventName_NOTIN.add( eventNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnEventQuery eventNameIsNull() {
                    this.isNulls.add("eventName");
                    return this;
                }



                @Override
                public TcgColumnEventQuery eventNameIsNotNull() {
                    this.isNotNulls.add("eventName");
                    return this;
                }













                @Override
                public TcgColumnEventQuery funcBody(String funcBody) {
                    if(!IdUtils.isEmpty(funcBody)){
                        this.funcBody = funcBody;
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery funcBodyNot(String funcBodyNot) {
                    if(!IdUtils.isEmpty(funcBodyNot)){
                        this.funcBody_NE = funcBodyNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnEventQuery funcBodyLike(String funcBodyLike) {
                    if(!IdUtils.isEmpty(funcBodyLike)){
                        this.funcBody_LIKE = funcBodyLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnEventQuery funcBodyNotLike(String funcBodyNotLike) {
                    if(!IdUtils.isEmpty(funcBodyNotLike)){
                        this.funcBody_NOTLIKE = funcBodyNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnEventQuery funcBodyIn(String funcBodyIn) {
                    if(!IdUtils.isEmpty(funcBodyIn)){
                        this.funcBody_IN.add( funcBodyIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery funcBodyNotIn(String funcBodyNotIn) {
                    if(!IdUtils.isEmpty(funcBodyNotIn)){
                        this.funcBody_NOTIN.add( funcBodyNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnEventQuery funcBodyIsNull() {
                    this.isNulls.add("funcBody");
                    return this;
                }



                @Override
                public TcgColumnEventQuery funcBodyIsNotNull() {
                    this.isNotNulls.add("funcBody");
                    return this;
                }













            @Override
            public TcgColumnEventQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgColumnEventQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgColumnEventQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnEventQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnEventQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnEventQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgColumnEventQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnEventQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnEventQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgColumnEventQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgColumnEventQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgColumnEventQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgColumnEventQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnEventQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnEventQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnEventQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgColumnEventQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnEventQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnEventQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnEventQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgColumnEventQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgColumnEventQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgColumnEventQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgColumnEventQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnEventQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnEventQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnEventQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}