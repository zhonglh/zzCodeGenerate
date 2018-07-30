package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgDbConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 连接池设置查询接口
 *
 * @author Administrator
 * @date 2018-7-30 17:18:05
 */
public interface TcgDbConfigQuery<PK extends Serializable> extends Query<TcgDbConfigEntity,PK> {






            public TcgDbConfigQuery id(PK id);
            public TcgDbConfigQuery idNot(PK idNot);
            public TcgDbConfigQuery idIn(PK idIn);
            public TcgDbConfigQuery idNotIn(PK idNotIn);
            public TcgDbConfigQuery idIsNull();
            public TcgDbConfigQuery idIsNotNull();












            public TcgDbConfigQuery dbType(String dbType);
            public TcgDbConfigQuery dbTypeNot(String dbTypeNot);
            public TcgDbConfigQuery dbTypeIn(String dbTypeIn);
            public TcgDbConfigQuery dbTypeNotIn(String dbTypeNotIn);
            public TcgDbConfigQuery dbTypeLike(String dbTypeLike);
            public TcgDbConfigQuery dbTypeNotLike(String dbTypeNotLike);
            public TcgDbConfigQuery dbTypeIsNull();
            public TcgDbConfigQuery dbTypeIsNotNull();












            public TcgDbConfigQuery dbUrl(String dbUrl);
            public TcgDbConfigQuery dbUrlNot(String dbUrlNot);
            public TcgDbConfigQuery dbUrlIn(String dbUrlIn);
            public TcgDbConfigQuery dbUrlNotIn(String dbUrlNotIn);
            public TcgDbConfigQuery dbUrlLike(String dbUrlLike);
            public TcgDbConfigQuery dbUrlNotLike(String dbUrlNotLike);
            public TcgDbConfigQuery dbUrlIsNull();
            public TcgDbConfigQuery dbUrlIsNotNull();












            public TcgDbConfigQuery dbUsername(String dbUsername);
            public TcgDbConfigQuery dbUsernameNot(String dbUsernameNot);
            public TcgDbConfigQuery dbUsernameIn(String dbUsernameIn);
            public TcgDbConfigQuery dbUsernameNotIn(String dbUsernameNotIn);
            public TcgDbConfigQuery dbUsernameLike(String dbUsernameLike);
            public TcgDbConfigQuery dbUsernameNotLike(String dbUsernameNotLike);
            public TcgDbConfigQuery dbUsernameIsNull();
            public TcgDbConfigQuery dbUsernameIsNotNull();












            public TcgDbConfigQuery dbPassword(String dbPassword);
            public TcgDbConfigQuery dbPasswordNot(String dbPasswordNot);
            public TcgDbConfigQuery dbPasswordIn(String dbPasswordIn);
            public TcgDbConfigQuery dbPasswordNotIn(String dbPasswordNotIn);
            public TcgDbConfigQuery dbPasswordLike(String dbPasswordLike);
            public TcgDbConfigQuery dbPasswordNotLike(String dbPasswordNotLike);
            public TcgDbConfigQuery dbPasswordIsNull();
            public TcgDbConfigQuery dbPasswordIsNotNull();












            public TcgDbConfigQuery title(String title);
            public TcgDbConfigQuery titleNot(String titleNot);
            public TcgDbConfigQuery titleIn(String titleIn);
            public TcgDbConfigQuery titleNotIn(String titleNotIn);
            public TcgDbConfigQuery titleLike(String titleLike);
            public TcgDbConfigQuery titleNotLike(String titleNotLike);
            public TcgDbConfigQuery titleIsNull();
            public TcgDbConfigQuery titleIsNotNull();












        public TcgDbConfigQuery createTime(Timestamp createTime);
        public TcgDbConfigQuery createTimeNot(Timestamp createTimeNot);
        public TcgDbConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgDbConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgDbConfigQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgDbConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgDbConfigQuery createUserId(PK createUserId);
            public TcgDbConfigQuery createUserIdNot(PK createUserIdNot);
            public TcgDbConfigQuery createUserIdIn(PK createUserIdIn);
            public TcgDbConfigQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgDbConfigQuery createUserIdIsNull();
            public TcgDbConfigQuery createUserIdIsNotNull();












        public TcgDbConfigQuery updateTime(Timestamp updateTime);
        public TcgDbConfigQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgDbConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgDbConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgDbConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgDbConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgDbConfigQuery updateUserId(PK updateUserId);
            public TcgDbConfigQuery updateUserIdNot(PK updateUserIdNot);
            public TcgDbConfigQuery updateUserIdIn(PK updateUserIdIn);
            public TcgDbConfigQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgDbConfigQuery updateUserIdIsNull();
            public TcgDbConfigQuery updateUserIdIsNotNull();












        public TcgDbConfigQuery versionNo(Integer versionNo);
        public TcgDbConfigQuery versionNoNot(Integer versionNoNot);
        public TcgDbConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgDbConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgDbConfigQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgDbConfigQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}