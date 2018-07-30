package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgDbConfigQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 连接池设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-30 17:18:06
 */
public class TcgDbConfigQueryImpl<PK extends Serializable> extends TcgDbConfigAbstractQueryImpl<PK> implements TcgDbConfigQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<String> dbType_IN;
            private List<String> dbType_NOTIN;













            private List<String> dbUrl_IN;
            private List<String> dbUrl_NOTIN;













            private List<String> dbUsername_IN;
            private List<String> dbUsername_NOTIN;













            private List<String> dbPassword_IN;
            private List<String> dbPassword_NOTIN;













            private List<String> title_IN;
            private List<String> title_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgDbConfigQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgDbConfigQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgDbConfigQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgDbConfigQuery dbType(String dbType) {
                    if(!IdUtils.isEmpty(dbType)){
                        this.dbType = dbType;
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery dbTypeNot(String dbTypeNot) {
                    if(!IdUtils.isEmpty(dbTypeNot)){
                        this.dbType_NE = dbTypeNot;
                    }
                    return this;
                }




                @Override
                public TcgDbConfigQuery dbTypeLike(String dbTypeLike) {
                    if(!IdUtils.isEmpty(dbTypeLike)){
                        this.dbType_LIKE = dbTypeLike;
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbTypeNotLike(String dbTypeNotLike) {
                    if(!IdUtils.isEmpty(dbTypeNotLike)){
                        this.dbType_NOTLIKE = dbTypeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgDbConfigQuery dbTypeIn(String dbTypeIn) {
                    if(!IdUtils.isEmpty(dbTypeIn)){
                        this.dbType_IN.add( dbTypeIn );
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery dbTypeNotIn(String dbTypeNotIn) {
                    if(!IdUtils.isEmpty(dbTypeNotIn)){
                        this.dbType_NOTIN.add( dbTypeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbTypeIsNull() {
                    this.isNulls.add("dbType");
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbTypeIsNotNull() {
                    this.isNotNulls.add("dbType");
                    return this;
                }













                @Override
                public TcgDbConfigQuery dbUrl(String dbUrl) {
                    if(!IdUtils.isEmpty(dbUrl)){
                        this.dbUrl = dbUrl;
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery dbUrlNot(String dbUrlNot) {
                    if(!IdUtils.isEmpty(dbUrlNot)){
                        this.dbUrl_NE = dbUrlNot;
                    }
                    return this;
                }




                @Override
                public TcgDbConfigQuery dbUrlLike(String dbUrlLike) {
                    if(!IdUtils.isEmpty(dbUrlLike)){
                        this.dbUrl_LIKE = dbUrlLike;
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbUrlNotLike(String dbUrlNotLike) {
                    if(!IdUtils.isEmpty(dbUrlNotLike)){
                        this.dbUrl_NOTLIKE = dbUrlNotLike;
                    }
                    return this;
                }

                @Override
                public TcgDbConfigQuery dbUrlIn(String dbUrlIn) {
                    if(!IdUtils.isEmpty(dbUrlIn)){
                        this.dbUrl_IN.add( dbUrlIn );
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery dbUrlNotIn(String dbUrlNotIn) {
                    if(!IdUtils.isEmpty(dbUrlNotIn)){
                        this.dbUrl_NOTIN.add( dbUrlNotIn );
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbUrlIsNull() {
                    this.isNulls.add("dbUrl");
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbUrlIsNotNull() {
                    this.isNotNulls.add("dbUrl");
                    return this;
                }













                @Override
                public TcgDbConfigQuery dbUsername(String dbUsername) {
                    if(!IdUtils.isEmpty(dbUsername)){
                        this.dbUsername = dbUsername;
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery dbUsernameNot(String dbUsernameNot) {
                    if(!IdUtils.isEmpty(dbUsernameNot)){
                        this.dbUsername_NE = dbUsernameNot;
                    }
                    return this;
                }




                @Override
                public TcgDbConfigQuery dbUsernameLike(String dbUsernameLike) {
                    if(!IdUtils.isEmpty(dbUsernameLike)){
                        this.dbUsername_LIKE = dbUsernameLike;
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbUsernameNotLike(String dbUsernameNotLike) {
                    if(!IdUtils.isEmpty(dbUsernameNotLike)){
                        this.dbUsername_NOTLIKE = dbUsernameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgDbConfigQuery dbUsernameIn(String dbUsernameIn) {
                    if(!IdUtils.isEmpty(dbUsernameIn)){
                        this.dbUsername_IN.add( dbUsernameIn );
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery dbUsernameNotIn(String dbUsernameNotIn) {
                    if(!IdUtils.isEmpty(dbUsernameNotIn)){
                        this.dbUsername_NOTIN.add( dbUsernameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbUsernameIsNull() {
                    this.isNulls.add("dbUsername");
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbUsernameIsNotNull() {
                    this.isNotNulls.add("dbUsername");
                    return this;
                }













                @Override
                public TcgDbConfigQuery dbPassword(String dbPassword) {
                    if(!IdUtils.isEmpty(dbPassword)){
                        this.dbPassword = dbPassword;
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery dbPasswordNot(String dbPasswordNot) {
                    if(!IdUtils.isEmpty(dbPasswordNot)){
                        this.dbPassword_NE = dbPasswordNot;
                    }
                    return this;
                }




                @Override
                public TcgDbConfigQuery dbPasswordLike(String dbPasswordLike) {
                    if(!IdUtils.isEmpty(dbPasswordLike)){
                        this.dbPassword_LIKE = dbPasswordLike;
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbPasswordNotLike(String dbPasswordNotLike) {
                    if(!IdUtils.isEmpty(dbPasswordNotLike)){
                        this.dbPassword_NOTLIKE = dbPasswordNotLike;
                    }
                    return this;
                }

                @Override
                public TcgDbConfigQuery dbPasswordIn(String dbPasswordIn) {
                    if(!IdUtils.isEmpty(dbPasswordIn)){
                        this.dbPassword_IN.add( dbPasswordIn );
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery dbPasswordNotIn(String dbPasswordNotIn) {
                    if(!IdUtils.isEmpty(dbPasswordNotIn)){
                        this.dbPassword_NOTIN.add( dbPasswordNotIn );
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbPasswordIsNull() {
                    this.isNulls.add("dbPassword");
                    return this;
                }



                @Override
                public TcgDbConfigQuery dbPasswordIsNotNull() {
                    this.isNotNulls.add("dbPassword");
                    return this;
                }













                @Override
                public TcgDbConfigQuery title(String title) {
                    if(!IdUtils.isEmpty(title)){
                        this.title = title;
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery titleNot(String titleNot) {
                    if(!IdUtils.isEmpty(titleNot)){
                        this.title_NE = titleNot;
                    }
                    return this;
                }




                @Override
                public TcgDbConfigQuery titleLike(String titleLike) {
                    if(!IdUtils.isEmpty(titleLike)){
                        this.title_LIKE = titleLike;
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery titleNotLike(String titleNotLike) {
                    if(!IdUtils.isEmpty(titleNotLike)){
                        this.title_NOTLIKE = titleNotLike;
                    }
                    return this;
                }

                @Override
                public TcgDbConfigQuery titleIn(String titleIn) {
                    if(!IdUtils.isEmpty(titleIn)){
                        this.title_IN.add( titleIn );
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery titleNotIn(String titleNotIn) {
                    if(!IdUtils.isEmpty(titleNotIn)){
                        this.title_NOTIN.add( titleNotIn );
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery titleIsNull() {
                    this.isNulls.add("title");
                    return this;
                }



                @Override
                public TcgDbConfigQuery titleIsNotNull() {
                    this.isNotNulls.add("title");
                    return this;
                }













            @Override
            public TcgDbConfigQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgDbConfigQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgDbConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgDbConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgDbConfigQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgDbConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgDbConfigQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgDbConfigQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgDbConfigQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgDbConfigQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgDbConfigQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgDbConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgDbConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgDbConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgDbConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgDbConfigQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgDbConfigQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgDbConfigQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgDbConfigQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgDbConfigQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgDbConfigQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgDbConfigQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgDbConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgDbConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgDbConfigQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgDbConfigQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}