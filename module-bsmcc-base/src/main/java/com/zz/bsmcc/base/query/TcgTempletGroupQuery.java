package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgTempletGroupEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 模板组查询接口
 *
 * @author Administrator
 * @date 2018-7-30 17:18:09
 */
public interface TcgTempletGroupQuery<PK extends Serializable> extends Query<TcgTempletGroupEntity,PK> {






            public TcgTempletGroupQuery id(PK id);
            public TcgTempletGroupQuery idNot(PK idNot);
            public TcgTempletGroupQuery idIn(PK idIn);
            public TcgTempletGroupQuery idNotIn(PK idNotIn);
            public TcgTempletGroupQuery idIsNull();
            public TcgTempletGroupQuery idIsNotNull();












            public TcgTempletGroupQuery groupName(String groupName);
            public TcgTempletGroupQuery groupNameNot(String groupNameNot);
            public TcgTempletGroupQuery groupNameIn(String groupNameIn);
            public TcgTempletGroupQuery groupNameNotIn(String groupNameNotIn);
            public TcgTempletGroupQuery groupNameLike(String groupNameLike);
            public TcgTempletGroupQuery groupNameNotLike(String groupNameNotLike);
            public TcgTempletGroupQuery groupNameIsNull();
            public TcgTempletGroupQuery groupNameIsNotNull();












            public TcgTempletGroupQuery groupRemark(String groupRemark);
            public TcgTempletGroupQuery groupRemarkNot(String groupRemarkNot);
            public TcgTempletGroupQuery groupRemarkIn(String groupRemarkIn);
            public TcgTempletGroupQuery groupRemarkNotIn(String groupRemarkNotIn);
            public TcgTempletGroupQuery groupRemarkLike(String groupRemarkLike);
            public TcgTempletGroupQuery groupRemarkNotLike(String groupRemarkNotLike);
            public TcgTempletGroupQuery groupRemarkIsNull();
            public TcgTempletGroupQuery groupRemarkIsNotNull();












        public TcgTempletGroupQuery createTime(Timestamp createTime);
        public TcgTempletGroupQuery createTimeNot(Timestamp createTimeNot);
        public TcgTempletGroupQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgTempletGroupQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgTempletGroupQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgTempletGroupQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgTempletGroupQuery createUserId(PK createUserId);
            public TcgTempletGroupQuery createUserIdNot(PK createUserIdNot);
            public TcgTempletGroupQuery createUserIdIn(PK createUserIdIn);
            public TcgTempletGroupQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgTempletGroupQuery createUserIdIsNull();
            public TcgTempletGroupQuery createUserIdIsNotNull();












        public TcgTempletGroupQuery updateTime(Timestamp updateTime);
        public TcgTempletGroupQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgTempletGroupQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgTempletGroupQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgTempletGroupQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgTempletGroupQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgTempletGroupQuery updateUserId(PK updateUserId);
            public TcgTempletGroupQuery updateUserIdNot(PK updateUserIdNot);
            public TcgTempletGroupQuery updateUserIdIn(PK updateUserIdIn);
            public TcgTempletGroupQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgTempletGroupQuery updateUserIdIsNull();
            public TcgTempletGroupQuery updateUserIdIsNotNull();












        public TcgTempletGroupQuery versionNo(Integer versionNo);
        public TcgTempletGroupQuery versionNoNot(Integer versionNoNot);
        public TcgTempletGroupQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgTempletGroupQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgTempletGroupQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgTempletGroupQuery versionNoLessEqual(Integer versionNoLessEqual);










            public TcgTempletGroupQuery deleteFlag(String deleteFlag);
            public TcgTempletGroupQuery deleteFlagNot(String deleteFlagNot);
            public TcgTempletGroupQuery deleteFlagIn(String deleteFlagIn);
            public TcgTempletGroupQuery deleteFlagNotIn(String deleteFlagNotIn);
            public TcgTempletGroupQuery deleteFlagIsNull();
            public TcgTempletGroupQuery deleteFlagIsNotNull();









	
}