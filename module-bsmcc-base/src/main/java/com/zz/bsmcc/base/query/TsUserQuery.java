package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TsUserEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 用户查询接口
 *
 * @author Administrator
 * @date 2018-7-30 17:18:09
 */
public interface TsUserQuery<PK extends Serializable> extends Query<TsUserEntity,PK> {






            public TsUserQuery id(PK id);
            public TsUserQuery idNot(PK idNot);
            public TsUserQuery idIn(PK idIn);
            public TsUserQuery idNotIn(PK idNotIn);
            public TsUserQuery idIsNull();
            public TsUserQuery idIsNotNull();












            public TsUserQuery userName(String userName);
            public TsUserQuery userNameNot(String userNameNot);
            public TsUserQuery userNameIn(String userNameIn);
            public TsUserQuery userNameNotIn(String userNameNotIn);
            public TsUserQuery userNameLike(String userNameLike);
            public TsUserQuery userNameNotLike(String userNameNotLike);
            public TsUserQuery userNameIsNull();
            public TsUserQuery userNameIsNotNull();












            public TsUserQuery loginName(String loginName);
            public TsUserQuery loginNameNot(String loginNameNot);
            public TsUserQuery loginNameIn(String loginNameIn);
            public TsUserQuery loginNameNotIn(String loginNameNotIn);
            public TsUserQuery loginNameLike(String loginNameLike);
            public TsUserQuery loginNameNotLike(String loginNameNotLike);
            public TsUserQuery loginNameIsNull();
            public TsUserQuery loginNameIsNotNull();












            public TsUserQuery loginPassword(String loginPassword);
            public TsUserQuery loginPasswordNot(String loginPasswordNot);
            public TsUserQuery loginPasswordIn(String loginPasswordIn);
            public TsUserQuery loginPasswordNotIn(String loginPasswordNotIn);
            public TsUserQuery loginPasswordLike(String loginPasswordLike);
            public TsUserQuery loginPasswordNotLike(String loginPasswordNotLike);
            public TsUserQuery loginPasswordIsNull();
            public TsUserQuery loginPasswordIsNotNull();












            public TsUserQuery salt(PK salt);
            public TsUserQuery saltNot(PK saltNot);
            public TsUserQuery saltIn(PK saltIn);
            public TsUserQuery saltNotIn(PK saltNotIn);
            public TsUserQuery saltIsNull();
            public TsUserQuery saltIsNotNull();












            public TsUserQuery status(String status);
            public TsUserQuery statusNot(String statusNot);
            public TsUserQuery statusIn(String statusIn);
            public TsUserQuery statusNotIn(String statusNotIn);
            public TsUserQuery statusIsNull();
            public TsUserQuery statusIsNotNull();













            public TsUserQuery leadId(PK leadId);
            public TsUserQuery leadIdNot(PK leadIdNot);
            public TsUserQuery leadIdIn(PK leadIdIn);
            public TsUserQuery leadIdNotIn(PK leadIdNotIn);
            public TsUserQuery leadIdIsNull();
            public TsUserQuery leadIdIsNotNull();












            public TsUserQuery phone(String phone);
            public TsUserQuery phoneNot(String phoneNot);
            public TsUserQuery phoneIn(String phoneIn);
            public TsUserQuery phoneNotIn(String phoneNotIn);
            public TsUserQuery phoneLike(String phoneLike);
            public TsUserQuery phoneNotLike(String phoneNotLike);
            public TsUserQuery phoneIsNull();
            public TsUserQuery phoneIsNotNull();












            public TsUserQuery email(String email);
            public TsUserQuery emailNot(String emailNot);
            public TsUserQuery emailIn(String emailIn);
            public TsUserQuery emailNotIn(String emailNotIn);
            public TsUserQuery emailLike(String emailLike);
            public TsUserQuery emailNotLike(String emailNotLike);
            public TsUserQuery emailIsNull();
            public TsUserQuery emailIsNotNull();












            public TsUserQuery avatarUrl(String avatarUrl);
            public TsUserQuery avatarUrlNot(String avatarUrlNot);
            public TsUserQuery avatarUrlIn(String avatarUrlIn);
            public TsUserQuery avatarUrlNotIn(String avatarUrlNotIn);
            public TsUserQuery avatarUrlLike(String avatarUrlLike);
            public TsUserQuery avatarUrlNotLike(String avatarUrlNotLike);
            public TsUserQuery avatarUrlIsNull();
            public TsUserQuery avatarUrlIsNotNull();












            public TsUserQuery openId(PK openId);
            public TsUserQuery openIdNot(PK openIdNot);
            public TsUserQuery openIdIn(PK openIdIn);
            public TsUserQuery openIdNotIn(PK openIdNotIn);
            public TsUserQuery openIdIsNull();
            public TsUserQuery openIdIsNotNull();












            public TsUserQuery unionId(PK unionId);
            public TsUserQuery unionIdNot(PK unionIdNot);
            public TsUserQuery unionIdIn(PK unionIdIn);
            public TsUserQuery unionIdNotIn(PK unionIdNotIn);
            public TsUserQuery unionIdIsNull();
            public TsUserQuery unionIdIsNotNull();












            public TsUserQuery systemAdmin(String systemAdmin);
            public TsUserQuery systemAdminNot(String systemAdminNot);
            public TsUserQuery systemAdminIn(String systemAdminIn);
            public TsUserQuery systemAdminNotIn(String systemAdminNotIn);
            public TsUserQuery systemAdminIsNull();
            public TsUserQuery systemAdminIsNotNull();













            public TsUserQuery depId(PK depId);
            public TsUserQuery depIdNot(PK depIdNot);
            public TsUserQuery depIdIn(PK depIdIn);
            public TsUserQuery depIdNotIn(PK depIdNotIn);
            public TsUserQuery depIdIsNull();
            public TsUserQuery depIdIsNotNull();












            public TsUserQuery organId(PK organId);
            public TsUserQuery organIdNot(PK organIdNot);
            public TsUserQuery organIdIn(PK organIdIn);
            public TsUserQuery organIdNotIn(PK organIdNotIn);
            public TsUserQuery organIdIsNull();
            public TsUserQuery organIdIsNotNull();












            public TsUserQuery remark(String remark);
            public TsUserQuery remarkNot(String remarkNot);
            public TsUserQuery remarkIn(String remarkIn);
            public TsUserQuery remarkNotIn(String remarkNotIn);
            public TsUserQuery remarkLike(String remarkLike);
            public TsUserQuery remarkNotLike(String remarkNotLike);
            public TsUserQuery remarkIsNull();
            public TsUserQuery remarkIsNotNull();












            public TsUserQuery deleteFlag(String deleteFlag);
            public TsUserQuery deleteFlagNot(String deleteFlagNot);
            public TsUserQuery deleteFlagIn(String deleteFlagIn);
            public TsUserQuery deleteFlagNotIn(String deleteFlagNotIn);
            public TsUserQuery deleteFlagIsNull();
            public TsUserQuery deleteFlagIsNotNull();













            public TsUserQuery createUserId(PK createUserId);
            public TsUserQuery createUserIdNot(PK createUserIdNot);
            public TsUserQuery createUserIdIn(PK createUserIdIn);
            public TsUserQuery createUserIdNotIn(PK createUserIdNotIn);
            public TsUserQuery createUserIdIsNull();
            public TsUserQuery createUserIdIsNotNull();












            public TsUserQuery createUserName(String createUserName);
            public TsUserQuery createUserNameNot(String createUserNameNot);
            public TsUserQuery createUserNameIn(String createUserNameIn);
            public TsUserQuery createUserNameNotIn(String createUserNameNotIn);
            public TsUserQuery createUserNameLike(String createUserNameLike);
            public TsUserQuery createUserNameNotLike(String createUserNameNotLike);
            public TsUserQuery createUserNameIsNull();
            public TsUserQuery createUserNameIsNotNull();












        public TsUserQuery createTime(Timestamp createTime);
        public TsUserQuery createTimeNot(Timestamp createTimeNot);
        public TsUserQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TsUserQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TsUserQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TsUserQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TsUserQuery updateUserId(PK updateUserId);
            public TsUserQuery updateUserIdNot(PK updateUserIdNot);
            public TsUserQuery updateUserIdIn(PK updateUserIdIn);
            public TsUserQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TsUserQuery updateUserIdIsNull();
            public TsUserQuery updateUserIdIsNotNull();












            public TsUserQuery updateUserName(String updateUserName);
            public TsUserQuery updateUserNameNot(String updateUserNameNot);
            public TsUserQuery updateUserNameIn(String updateUserNameIn);
            public TsUserQuery updateUserNameNotIn(String updateUserNameNotIn);
            public TsUserQuery updateUserNameLike(String updateUserNameLike);
            public TsUserQuery updateUserNameNotLike(String updateUserNameNotLike);
            public TsUserQuery updateUserNameIsNull();
            public TsUserQuery updateUserNameIsNotNull();












        public TsUserQuery updateTime(Timestamp updateTime);
        public TsUserQuery updateTimeNot(Timestamp updateTimeNot);
        public TsUserQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TsUserQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TsUserQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TsUserQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










        public TsUserQuery versionNo(Integer versionNo);
        public TsUserQuery versionNoNot(Integer versionNoNot);
        public TsUserQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TsUserQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TsUserQuery versionNoLessThan(Integer versionNoLessThan);
        public TsUserQuery versionNoLessEqual(Integer versionNoLessEqual);










            public TsUserQuery tenantId(PK tenantId);
            public TsUserQuery tenantIdNot(PK tenantIdNot);
            public TsUserQuery tenantIdIn(PK tenantIdIn);
            public TsUserQuery tenantIdNotIn(PK tenantIdNotIn);
            public TsUserQuery tenantIdIsNull();
            public TsUserQuery tenantIdIsNotNull();








	
}