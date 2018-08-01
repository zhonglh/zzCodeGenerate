package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgProjectEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 项目管理查询接口
 *
 * @author Administrator
 * @date 2018-8-1 12:52:59
 */
public interface TcgProjectQuery<PK extends Serializable> extends Query<TcgProjectEntity,PK> {






            public TcgProjectQuery id(PK id);
            public TcgProjectQuery idNot(PK idNot);
            public TcgProjectQuery idIn(PK idIn);
            public TcgProjectQuery idNotIn(PK idNotIn);
            public TcgProjectQuery idIsNull();
            public TcgProjectQuery idIsNotNull();












            public TcgProjectQuery projectName(String projectName);
            public TcgProjectQuery projectNameNot(String projectNameNot);
            public TcgProjectQuery projectNameIn(String projectNameIn);
            public TcgProjectQuery projectNameNotIn(String projectNameNotIn);
            public TcgProjectQuery projectNameLike(String projectNameLike);
            public TcgProjectQuery projectNameNotLike(String projectNameNotLike);
            public TcgProjectQuery projectNameIsNull();
            public TcgProjectQuery projectNameIsNotNull();












            public TcgProjectQuery projectRemark(String projectRemark);
            public TcgProjectQuery projectRemarkNot(String projectRemarkNot);
            public TcgProjectQuery projectRemarkIn(String projectRemarkIn);
            public TcgProjectQuery projectRemarkNotIn(String projectRemarkNotIn);
            public TcgProjectQuery projectRemarkLike(String projectRemarkLike);
            public TcgProjectQuery projectRemarkNotLike(String projectRemarkNotLike);
            public TcgProjectQuery projectRemarkIsNull();
            public TcgProjectQuery projectRemarkIsNotNull();












            public TcgProjectQuery projectPackage(String projectPackage);
            public TcgProjectQuery projectPackageNot(String projectPackageNot);
            public TcgProjectQuery projectPackageIn(String projectPackageIn);
            public TcgProjectQuery projectPackageNotIn(String projectPackageNotIn);
            public TcgProjectQuery projectPackageLike(String projectPackageLike);
            public TcgProjectQuery projectPackageNotLike(String projectPackageNotLike);
            public TcgProjectQuery projectPackageIsNull();
            public TcgProjectQuery projectPackageIsNotNull();












            public TcgProjectQuery projectLead(String projectLead);
            public TcgProjectQuery projectLeadNot(String projectLeadNot);
            public TcgProjectQuery projectLeadIn(String projectLeadIn);
            public TcgProjectQuery projectLeadNotIn(String projectLeadNotIn);
            public TcgProjectQuery projectLeadLike(String projectLeadLike);
            public TcgProjectQuery projectLeadNotLike(String projectLeadNotLike);
            public TcgProjectQuery projectLeadIsNull();
            public TcgProjectQuery projectLeadIsNotNull();












            public TcgProjectQuery projectAuthor(String projectAuthor);
            public TcgProjectQuery projectAuthorNot(String projectAuthorNot);
            public TcgProjectQuery projectAuthorIn(String projectAuthorIn);
            public TcgProjectQuery projectAuthorNotIn(String projectAuthorNotIn);
            public TcgProjectQuery projectAuthorLike(String projectAuthorLike);
            public TcgProjectQuery projectAuthorNotLike(String projectAuthorNotLike);
            public TcgProjectQuery projectAuthorIsNull();
            public TcgProjectQuery projectAuthorIsNotNull();












            public TcgProjectQuery projectNote(String projectNote);
            public TcgProjectQuery projectNoteNot(String projectNoteNot);
            public TcgProjectQuery projectNoteIn(String projectNoteIn);
            public TcgProjectQuery projectNoteNotIn(String projectNoteNotIn);
            public TcgProjectQuery projectNoteLike(String projectNoteLike);
            public TcgProjectQuery projectNoteNotLike(String projectNoteNotLike);
            public TcgProjectQuery projectNoteIsNull();
            public TcgProjectQuery projectNoteIsNotNull();












            public TcgProjectQuery projectI18n(String projectI18n);
            public TcgProjectQuery projectI18nNot(String projectI18nNot);
            public TcgProjectQuery projectI18nIn(String projectI18nIn);
            public TcgProjectQuery projectI18nNotIn(String projectI18nNotIn);
            public TcgProjectQuery projectI18nIsNull();
            public TcgProjectQuery projectI18nIsNotNull();













            public TcgProjectQuery projectTenant(String projectTenant);
            public TcgProjectQuery projectTenantNot(String projectTenantNot);
            public TcgProjectQuery projectTenantIn(String projectTenantIn);
            public TcgProjectQuery projectTenantNotIn(String projectTenantNotIn);
            public TcgProjectQuery projectTenantIsNull();
            public TcgProjectQuery projectTenantIsNotNull();













            public TcgProjectQuery queryMode(String queryMode);
            public TcgProjectQuery queryModeNot(String queryModeNot);
            public TcgProjectQuery queryModeIn(String queryModeIn);
            public TcgProjectQuery queryModeNotIn(String queryModeNotIn);
            public TcgProjectQuery queryModeLike(String queryModeLike);
            public TcgProjectQuery queryModeNotLike(String queryModeNotLike);
            public TcgProjectQuery queryModeIsNull();
            public TcgProjectQuery queryModeIsNotNull();












            public TcgProjectQuery pageUseView(String pageUseView);
            public TcgProjectQuery pageUseViewNot(String pageUseViewNot);
            public TcgProjectQuery pageUseViewIn(String pageUseViewIn);
            public TcgProjectQuery pageUseViewNotIn(String pageUseViewNotIn);
            public TcgProjectQuery pageUseViewIsNull();
            public TcgProjectQuery pageUseViewIsNotNull();













        public TcgProjectQuery createTime(Timestamp createTime);
        public TcgProjectQuery createTimeNot(Timestamp createTimeNot);
        public TcgProjectQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgProjectQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgProjectQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgProjectQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgProjectQuery createUserId(PK createUserId);
            public TcgProjectQuery createUserIdNot(PK createUserIdNot);
            public TcgProjectQuery createUserIdIn(PK createUserIdIn);
            public TcgProjectQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgProjectQuery createUserIdIsNull();
            public TcgProjectQuery createUserIdIsNotNull();












        public TcgProjectQuery updateTime(Timestamp updateTime);
        public TcgProjectQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgProjectQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgProjectQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgProjectQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgProjectQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgProjectQuery updateUserId(PK updateUserId);
            public TcgProjectQuery updateUserIdNot(PK updateUserIdNot);
            public TcgProjectQuery updateUserIdIn(PK updateUserIdIn);
            public TcgProjectQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgProjectQuery updateUserIdIsNull();
            public TcgProjectQuery updateUserIdIsNotNull();












        public TcgProjectQuery versionNo(Integer versionNo);
        public TcgProjectQuery versionNoNot(Integer versionNoNot);
        public TcgProjectQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgProjectQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgProjectQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgProjectQuery versionNoLessEqual(Integer versionNoLessEqual);










            public TcgProjectQuery deleteFlag(String deleteFlag);
            public TcgProjectQuery deleteFlagNot(String deleteFlagNot);
            public TcgProjectQuery deleteFlagIn(String deleteFlagIn);
            public TcgProjectQuery deleteFlagNotIn(String deleteFlagNotIn);
            public TcgProjectQuery deleteFlagIsNull();
            public TcgProjectQuery deleteFlagIsNotNull();









	
}