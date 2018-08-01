package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgTempletQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 模板 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:17
 */
public class TcgTempletQueryImpl<PK extends Serializable> extends TcgTempletAbstractQueryImpl<PK> implements TcgTempletQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> groupId_IN;
            private List<PK> groupId_NOTIN;













            private List<String> fileType_IN;
            private List<String> fileType_NOTIN;













            private List<String> templetTitle_IN;
            private List<String> templetTitle_NOTIN;













            private List<String> templetDir_IN;
            private List<String> templetDir_NOTIN;













            private List<String> templetContent_IN;
            private List<String> templetContent_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;























            private List<String> deleteFlag_IN;
            private List<String> deleteFlag_NOTIN;

























                @Override
                public TcgTempletQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgTempletQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgTempletQuery groupId(PK groupId) {
                    if(!IdUtils.isEmpty(groupId)){
                        this.groupId = groupId;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery groupIdNot(PK groupIdNot) {
                    if(!IdUtils.isEmpty(groupIdNot)){
                        this.groupId_NE = groupIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery groupIdIn(PK groupIdIn) {
                    if(!IdUtils.isEmpty(groupIdIn)){
                        if(this.groupId_IN == null){
                            this.groupId_IN = new ArrayList<PK>();
                        }
                        this.groupId_IN.add( groupIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery groupIdNotIn(PK groupIdNotIn) {
                    if(!IdUtils.isEmpty(groupIdNotIn)){
                        if(this.groupId_NOTIN == null){
                            this.groupId_NOTIN = new ArrayList<PK>();
                        }
                        this.groupId_NOTIN.add( groupIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery groupIdIsNull() {
                    this.isNulls.add("groupId");
                    return this;
                }



                @Override
                public TcgTempletQuery groupIdIsNotNull() {
                    this.isNotNulls.add("groupId");
                    return this;
                }















                @Override
                public TcgTempletQuery fileType(String fileType) {
                    if(!IdUtils.isEmpty(fileType)){
                        this.fileType = fileType;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery fileTypeNot(String fileTypeNot) {
                    if(!IdUtils.isEmpty(fileTypeNot)){
                        this.fileType_NE = fileTypeNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletQuery fileTypeLike(String fileTypeLike) {
                    if(!IdUtils.isEmpty(fileTypeLike)){
                        this.fileType_LIKE = fileTypeLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery fileTypeNotLike(String fileTypeNotLike) {
                    if(!IdUtils.isEmpty(fileTypeNotLike)){
                        this.fileType_NOTLIKE = fileTypeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery fileTypeIn(String fileTypeIn) {
                    if(!IdUtils.isEmpty(fileTypeIn)){
                        if(this.fileType_IN == null){
                            this.fileType_IN = new ArrayList<String>();
                        }
                        this.fileType_IN.add( fileTypeIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery fileTypeNotIn(String fileTypeNotIn) {
                    if(!IdUtils.isEmpty(fileTypeNotIn)){
                        if(this.fileType_NOTIN == null){
                            this.fileType_NOTIN = new ArrayList<String>();
                        }
                        this.fileType_NOTIN.add( fileTypeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery fileTypeIsNull() {
                    this.isNulls.add("fileType");
                    return this;
                }



                @Override
                public TcgTempletQuery fileTypeIsNotNull() {
                    this.isNotNulls.add("fileType");
                    return this;
                }













                @Override
                public TcgTempletQuery templetTitle(String templetTitle) {
                    if(!IdUtils.isEmpty(templetTitle)){
                        this.templetTitle = templetTitle;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery templetTitleNot(String templetTitleNot) {
                    if(!IdUtils.isEmpty(templetTitleNot)){
                        this.templetTitle_NE = templetTitleNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletQuery templetTitleLike(String templetTitleLike) {
                    if(!IdUtils.isEmpty(templetTitleLike)){
                        this.templetTitle_LIKE = templetTitleLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery templetTitleNotLike(String templetTitleNotLike) {
                    if(!IdUtils.isEmpty(templetTitleNotLike)){
                        this.templetTitle_NOTLIKE = templetTitleNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery templetTitleIn(String templetTitleIn) {
                    if(!IdUtils.isEmpty(templetTitleIn)){
                        if(this.templetTitle_IN == null){
                            this.templetTitle_IN = new ArrayList<String>();
                        }
                        this.templetTitle_IN.add( templetTitleIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery templetTitleNotIn(String templetTitleNotIn) {
                    if(!IdUtils.isEmpty(templetTitleNotIn)){
                        if(this.templetTitle_NOTIN == null){
                            this.templetTitle_NOTIN = new ArrayList<String>();
                        }
                        this.templetTitle_NOTIN.add( templetTitleNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery templetTitleIsNull() {
                    this.isNulls.add("templetTitle");
                    return this;
                }



                @Override
                public TcgTempletQuery templetTitleIsNotNull() {
                    this.isNotNulls.add("templetTitle");
                    return this;
                }













                @Override
                public TcgTempletQuery templetDir(String templetDir) {
                    if(!IdUtils.isEmpty(templetDir)){
                        this.templetDir = templetDir;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery templetDirNot(String templetDirNot) {
                    if(!IdUtils.isEmpty(templetDirNot)){
                        this.templetDir_NE = templetDirNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletQuery templetDirLike(String templetDirLike) {
                    if(!IdUtils.isEmpty(templetDirLike)){
                        this.templetDir_LIKE = templetDirLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery templetDirNotLike(String templetDirNotLike) {
                    if(!IdUtils.isEmpty(templetDirNotLike)){
                        this.templetDir_NOTLIKE = templetDirNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery templetDirIn(String templetDirIn) {
                    if(!IdUtils.isEmpty(templetDirIn)){
                        if(this.templetDir_IN == null){
                            this.templetDir_IN = new ArrayList<String>();
                        }
                        this.templetDir_IN.add( templetDirIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery templetDirNotIn(String templetDirNotIn) {
                    if(!IdUtils.isEmpty(templetDirNotIn)){
                        if(this.templetDir_NOTIN == null){
                            this.templetDir_NOTIN = new ArrayList<String>();
                        }
                        this.templetDir_NOTIN.add( templetDirNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery templetDirIsNull() {
                    this.isNulls.add("templetDir");
                    return this;
                }



                @Override
                public TcgTempletQuery templetDirIsNotNull() {
                    this.isNotNulls.add("templetDir");
                    return this;
                }













                @Override
                public TcgTempletQuery templetContent(String templetContent) {
                    if(!IdUtils.isEmpty(templetContent)){
                        this.templetContent = templetContent;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery templetContentNot(String templetContentNot) {
                    if(!IdUtils.isEmpty(templetContentNot)){
                        this.templetContent_NE = templetContentNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletQuery templetContentLike(String templetContentLike) {
                    if(!IdUtils.isEmpty(templetContentLike)){
                        this.templetContent_LIKE = templetContentLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery templetContentNotLike(String templetContentNotLike) {
                    if(!IdUtils.isEmpty(templetContentNotLike)){
                        this.templetContent_NOTLIKE = templetContentNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery templetContentIn(String templetContentIn) {
                    if(!IdUtils.isEmpty(templetContentIn)){
                        if(this.templetContent_IN == null){
                            this.templetContent_IN = new ArrayList<String>();
                        }
                        this.templetContent_IN.add( templetContentIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery templetContentNotIn(String templetContentNotIn) {
                    if(!IdUtils.isEmpty(templetContentNotIn)){
                        if(this.templetContent_NOTIN == null){
                            this.templetContent_NOTIN = new ArrayList<String>();
                        }
                        this.templetContent_NOTIN.add( templetContentNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery templetContentIsNull() {
                    this.isNulls.add("templetContent");
                    return this;
                }



                @Override
                public TcgTempletQuery templetContentIsNotNull() {
                    this.isNotNulls.add("templetContent");
                    return this;
                }













            @Override
            public TcgTempletQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgTempletQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgTempletQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTempletQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTempletQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgTempletQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgTempletQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgTempletQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgTempletQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgTempletQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgTempletQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTempletQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTempletQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgTempletQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgTempletQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgTempletQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgTempletQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgTempletQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgTempletQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTempletQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTempletQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgTempletQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }












                @Override
                public TcgTempletQuery deleteFlag(String deleteFlag) {
                    if(!IdUtils.isEmpty(deleteFlag)){
                        this.deleteFlag = deleteFlag;
                    }
                    return this;
                }


                @Override
                public TcgTempletQuery deleteFlagNot(String deleteFlagNot) {
                    if(!IdUtils.isEmpty(deleteFlagNot)){
                        this.deleteFlag_NE = deleteFlagNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletQuery deleteFlagIn(String deleteFlagIn) {
                    if(!IdUtils.isEmpty(deleteFlagIn)){
                        if(this.deleteFlag_IN == null){
                            this.deleteFlag_IN = new ArrayList<String>();
                        }
                        this.deleteFlag_IN.add( deleteFlagIn );
                    }
                    return this;
                }


                @Override
                    public TcgTempletQuery deleteFlagNotIn(String deleteFlagNotIn) {
                    if(!IdUtils.isEmpty(deleteFlagNotIn)){
                        if(this.deleteFlag_NOTIN == null){
                            this.deleteFlag_NOTIN = new ArrayList<String>();
                        }
                        this.deleteFlag_NOTIN.add( deleteFlagNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgTempletQuery deleteFlagIsNull() {
                    this.isNulls.add("deleteFlag");
                    return this;
                }



                @Override
                public TcgTempletQuery deleteFlagIsNotNull() {
                    this.isNotNulls.add("deleteFlag");
                    return this;
                }









	
}