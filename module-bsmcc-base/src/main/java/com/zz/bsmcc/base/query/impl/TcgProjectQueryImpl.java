package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgProjectQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 项目管理 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 12:32:15
 */
public class TcgProjectQueryImpl<PK extends Serializable> extends TcgProjectAbstractQueryImpl<PK> implements TcgProjectQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<String> projectName_IN;
            private List<String> projectName_NOTIN;













            private List<String> projectRemark_IN;
            private List<String> projectRemark_NOTIN;













            private List<String> projectPackage_IN;
            private List<String> projectPackage_NOTIN;













            private List<String> projectLead_IN;
            private List<String> projectLead_NOTIN;













            private List<String> projectAuthor_IN;
            private List<String> projectAuthor_NOTIN;













            private List<String> projectNote_IN;
            private List<String> projectNote_NOTIN;













            private List<String> projectI18n_IN;
            private List<String> projectI18n_NOTIN;














            private List<String> projectTenant_IN;
            private List<String> projectTenant_NOTIN;
























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;























            private List<String> deleteFlag_IN;
            private List<String> deleteFlag_NOTIN;

























                @Override
                public TcgProjectQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgProjectQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgProjectQuery projectName(String projectName) {
                    if(!IdUtils.isEmpty(projectName)){
                        this.projectName = projectName;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectNameNot(String projectNameNot) {
                    if(!IdUtils.isEmpty(projectNameNot)){
                        this.projectName_NE = projectNameNot;
                    }
                    return this;
                }




                @Override
                public TcgProjectQuery projectNameLike(String projectNameLike) {
                    if(!IdUtils.isEmpty(projectNameLike)){
                        this.projectName_LIKE = projectNameLike;
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectNameNotLike(String projectNameNotLike) {
                    if(!IdUtils.isEmpty(projectNameNotLike)){
                        this.projectName_NOTLIKE = projectNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery projectNameIn(String projectNameIn) {
                    if(!IdUtils.isEmpty(projectNameIn)){
                        this.projectName_IN.add( projectNameIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectNameNotIn(String projectNameNotIn) {
                    if(!IdUtils.isEmpty(projectNameNotIn)){
                        this.projectName_NOTIN.add( projectNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectNameIsNull() {
                    this.isNulls.add("projectName");
                    return this;
                }



                @Override
                public TcgProjectQuery projectNameIsNotNull() {
                    this.isNotNulls.add("projectName");
                    return this;
                }













                @Override
                public TcgProjectQuery projectRemark(String projectRemark) {
                    if(!IdUtils.isEmpty(projectRemark)){
                        this.projectRemark = projectRemark;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectRemarkNot(String projectRemarkNot) {
                    if(!IdUtils.isEmpty(projectRemarkNot)){
                        this.projectRemark_NE = projectRemarkNot;
                    }
                    return this;
                }




                @Override
                public TcgProjectQuery projectRemarkLike(String projectRemarkLike) {
                    if(!IdUtils.isEmpty(projectRemarkLike)){
                        this.projectRemark_LIKE = projectRemarkLike;
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectRemarkNotLike(String projectRemarkNotLike) {
                    if(!IdUtils.isEmpty(projectRemarkNotLike)){
                        this.projectRemark_NOTLIKE = projectRemarkNotLike;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery projectRemarkIn(String projectRemarkIn) {
                    if(!IdUtils.isEmpty(projectRemarkIn)){
                        this.projectRemark_IN.add( projectRemarkIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectRemarkNotIn(String projectRemarkNotIn) {
                    if(!IdUtils.isEmpty(projectRemarkNotIn)){
                        this.projectRemark_NOTIN.add( projectRemarkNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectRemarkIsNull() {
                    this.isNulls.add("projectRemark");
                    return this;
                }



                @Override
                public TcgProjectQuery projectRemarkIsNotNull() {
                    this.isNotNulls.add("projectRemark");
                    return this;
                }













                @Override
                public TcgProjectQuery projectPackage(String projectPackage) {
                    if(!IdUtils.isEmpty(projectPackage)){
                        this.projectPackage = projectPackage;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectPackageNot(String projectPackageNot) {
                    if(!IdUtils.isEmpty(projectPackageNot)){
                        this.projectPackage_NE = projectPackageNot;
                    }
                    return this;
                }




                @Override
                public TcgProjectQuery projectPackageLike(String projectPackageLike) {
                    if(!IdUtils.isEmpty(projectPackageLike)){
                        this.projectPackage_LIKE = projectPackageLike;
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectPackageNotLike(String projectPackageNotLike) {
                    if(!IdUtils.isEmpty(projectPackageNotLike)){
                        this.projectPackage_NOTLIKE = projectPackageNotLike;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery projectPackageIn(String projectPackageIn) {
                    if(!IdUtils.isEmpty(projectPackageIn)){
                        this.projectPackage_IN.add( projectPackageIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectPackageNotIn(String projectPackageNotIn) {
                    if(!IdUtils.isEmpty(projectPackageNotIn)){
                        this.projectPackage_NOTIN.add( projectPackageNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectPackageIsNull() {
                    this.isNulls.add("projectPackage");
                    return this;
                }



                @Override
                public TcgProjectQuery projectPackageIsNotNull() {
                    this.isNotNulls.add("projectPackage");
                    return this;
                }













                @Override
                public TcgProjectQuery projectLead(String projectLead) {
                    if(!IdUtils.isEmpty(projectLead)){
                        this.projectLead = projectLead;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectLeadNot(String projectLeadNot) {
                    if(!IdUtils.isEmpty(projectLeadNot)){
                        this.projectLead_NE = projectLeadNot;
                    }
                    return this;
                }




                @Override
                public TcgProjectQuery projectLeadLike(String projectLeadLike) {
                    if(!IdUtils.isEmpty(projectLeadLike)){
                        this.projectLead_LIKE = projectLeadLike;
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectLeadNotLike(String projectLeadNotLike) {
                    if(!IdUtils.isEmpty(projectLeadNotLike)){
                        this.projectLead_NOTLIKE = projectLeadNotLike;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery projectLeadIn(String projectLeadIn) {
                    if(!IdUtils.isEmpty(projectLeadIn)){
                        this.projectLead_IN.add( projectLeadIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectLeadNotIn(String projectLeadNotIn) {
                    if(!IdUtils.isEmpty(projectLeadNotIn)){
                        this.projectLead_NOTIN.add( projectLeadNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectLeadIsNull() {
                    this.isNulls.add("projectLead");
                    return this;
                }



                @Override
                public TcgProjectQuery projectLeadIsNotNull() {
                    this.isNotNulls.add("projectLead");
                    return this;
                }













                @Override
                public TcgProjectQuery projectAuthor(String projectAuthor) {
                    if(!IdUtils.isEmpty(projectAuthor)){
                        this.projectAuthor = projectAuthor;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectAuthorNot(String projectAuthorNot) {
                    if(!IdUtils.isEmpty(projectAuthorNot)){
                        this.projectAuthor_NE = projectAuthorNot;
                    }
                    return this;
                }




                @Override
                public TcgProjectQuery projectAuthorLike(String projectAuthorLike) {
                    if(!IdUtils.isEmpty(projectAuthorLike)){
                        this.projectAuthor_LIKE = projectAuthorLike;
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectAuthorNotLike(String projectAuthorNotLike) {
                    if(!IdUtils.isEmpty(projectAuthorNotLike)){
                        this.projectAuthor_NOTLIKE = projectAuthorNotLike;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery projectAuthorIn(String projectAuthorIn) {
                    if(!IdUtils.isEmpty(projectAuthorIn)){
                        this.projectAuthor_IN.add( projectAuthorIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectAuthorNotIn(String projectAuthorNotIn) {
                    if(!IdUtils.isEmpty(projectAuthorNotIn)){
                        this.projectAuthor_NOTIN.add( projectAuthorNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectAuthorIsNull() {
                    this.isNulls.add("projectAuthor");
                    return this;
                }



                @Override
                public TcgProjectQuery projectAuthorIsNotNull() {
                    this.isNotNulls.add("projectAuthor");
                    return this;
                }













                @Override
                public TcgProjectQuery projectNote(String projectNote) {
                    if(!IdUtils.isEmpty(projectNote)){
                        this.projectNote = projectNote;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectNoteNot(String projectNoteNot) {
                    if(!IdUtils.isEmpty(projectNoteNot)){
                        this.projectNote_NE = projectNoteNot;
                    }
                    return this;
                }




                @Override
                public TcgProjectQuery projectNoteLike(String projectNoteLike) {
                    if(!IdUtils.isEmpty(projectNoteLike)){
                        this.projectNote_LIKE = projectNoteLike;
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectNoteNotLike(String projectNoteNotLike) {
                    if(!IdUtils.isEmpty(projectNoteNotLike)){
                        this.projectNote_NOTLIKE = projectNoteNotLike;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery projectNoteIn(String projectNoteIn) {
                    if(!IdUtils.isEmpty(projectNoteIn)){
                        this.projectNote_IN.add( projectNoteIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectNoteNotIn(String projectNoteNotIn) {
                    if(!IdUtils.isEmpty(projectNoteNotIn)){
                        this.projectNote_NOTIN.add( projectNoteNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery projectNoteIsNull() {
                    this.isNulls.add("projectNote");
                    return this;
                }



                @Override
                public TcgProjectQuery projectNoteIsNotNull() {
                    this.isNotNulls.add("projectNote");
                    return this;
                }













                @Override
                public TcgProjectQuery projectI18n(String projectI18n) {
                    if(!IdUtils.isEmpty(projectI18n)){
                        this.projectI18n = projectI18n;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectI18nNot(String projectI18nNot) {
                    if(!IdUtils.isEmpty(projectI18nNot)){
                        this.projectI18n_NE = projectI18nNot;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery projectI18nIn(String projectI18nIn) {
                    if(!IdUtils.isEmpty(projectI18nIn)){
                        this.projectI18n_IN.add( projectI18nIn );
                    }
                    return this;
                }


                @Override
                    public TcgProjectQuery projectI18nNotIn(String projectI18nNotIn) {
                    if(!IdUtils.isEmpty(projectI18nNotIn)){
                        this.projectI18n_NOTIN.add( projectI18nNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgProjectQuery projectI18nIsNull() {
                    this.isNulls.add("projectI18n");
                    return this;
                }



                @Override
                public TcgProjectQuery projectI18nIsNotNull() {
                    this.isNotNulls.add("projectI18n");
                    return this;
                }














                @Override
                public TcgProjectQuery projectTenant(String projectTenant) {
                    if(!IdUtils.isEmpty(projectTenant)){
                        this.projectTenant = projectTenant;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery projectTenantNot(String projectTenantNot) {
                    if(!IdUtils.isEmpty(projectTenantNot)){
                        this.projectTenant_NE = projectTenantNot;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery projectTenantIn(String projectTenantIn) {
                    if(!IdUtils.isEmpty(projectTenantIn)){
                        this.projectTenant_IN.add( projectTenantIn );
                    }
                    return this;
                }


                @Override
                    public TcgProjectQuery projectTenantNotIn(String projectTenantNotIn) {
                    if(!IdUtils.isEmpty(projectTenantNotIn)){
                        this.projectTenant_NOTIN.add( projectTenantNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgProjectQuery projectTenantIsNull() {
                    this.isNulls.add("projectTenant");
                    return this;
                }



                @Override
                public TcgProjectQuery projectTenantIsNotNull() {
                    this.isNotNulls.add("projectTenant");
                    return this;
                }














            @Override
            public TcgProjectQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgProjectQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgProjectQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgProjectQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgProjectQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgProjectQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgProjectQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgProjectQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgProjectQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgProjectQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgProjectQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgProjectQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgProjectQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgProjectQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgProjectQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgProjectQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgProjectQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgProjectQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgProjectQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgProjectQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgProjectQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgProjectQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgProjectQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }












                @Override
                public TcgProjectQuery deleteFlag(String deleteFlag) {
                    if(!IdUtils.isEmpty(deleteFlag)){
                        this.deleteFlag = deleteFlag;
                    }
                    return this;
                }


                @Override
                public TcgProjectQuery deleteFlagNot(String deleteFlagNot) {
                    if(!IdUtils.isEmpty(deleteFlagNot)){
                        this.deleteFlag_NE = deleteFlagNot;
                    }
                    return this;
                }

                @Override
                public TcgProjectQuery deleteFlagIn(String deleteFlagIn) {
                    if(!IdUtils.isEmpty(deleteFlagIn)){
                        this.deleteFlag_IN.add( deleteFlagIn );
                    }
                    return this;
                }


                @Override
                    public TcgProjectQuery deleteFlagNotIn(String deleteFlagNotIn) {
                    if(!IdUtils.isEmpty(deleteFlagNotIn)){
                        this.deleteFlag_NOTIN.add( deleteFlagNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgProjectQuery deleteFlagIsNull() {
                    this.isNulls.add("deleteFlag");
                    return this;
                }



                @Override
                public TcgProjectQuery deleteFlagIsNotNull() {
                    this.isNotNulls.add("deleteFlag");
                    return this;
                }









	
}