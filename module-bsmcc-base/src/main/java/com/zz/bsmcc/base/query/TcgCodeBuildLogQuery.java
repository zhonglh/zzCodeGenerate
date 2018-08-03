package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgCodeBuildLogEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 代码生成记录查询接口
 *
 * @author Administrator
 * @date 2018-8-3 11:23:12
 */
public interface TcgCodeBuildLogQuery<PK extends Serializable> extends Query<TcgCodeBuildLogEntity,PK> {






            public TcgCodeBuildLogQuery id(PK id);
            public TcgCodeBuildLogQuery idNot(PK idNot);
            public TcgCodeBuildLogQuery idIn(PK idIn);
            public TcgCodeBuildLogQuery idNotIn(PK idNotIn);
            public TcgCodeBuildLogQuery idIsNull();
            public TcgCodeBuildLogQuery idIsNotNull();












            public TcgCodeBuildLogQuery projectId(PK projectId);
            public TcgCodeBuildLogQuery projectIdNot(PK projectIdNot);
            public TcgCodeBuildLogQuery projectIdIn(PK projectIdIn);
            public TcgCodeBuildLogQuery projectIdNotIn(PK projectIdNotIn);
            public TcgCodeBuildLogQuery projectIdIsNull();
            public TcgCodeBuildLogQuery projectIdIsNotNull();












            public TcgCodeBuildLogQuery templetGroupId(PK templetGroupId);
            public TcgCodeBuildLogQuery templetGroupIdNot(PK templetGroupIdNot);
            public TcgCodeBuildLogQuery templetGroupIdIn(PK templetGroupIdIn);
            public TcgCodeBuildLogQuery templetGroupIdNotIn(PK templetGroupIdNotIn);
            public TcgCodeBuildLogQuery templetGroupIdIsNull();
            public TcgCodeBuildLogQuery templetGroupIdIsNotNull();












        public TcgCodeBuildLogQuery createTime(Timestamp createTime);
        public TcgCodeBuildLogQuery createTimeNot(Timestamp createTimeNot);
        public TcgCodeBuildLogQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgCodeBuildLogQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgCodeBuildLogQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgCodeBuildLogQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgCodeBuildLogQuery createUserId(PK createUserId);
            public TcgCodeBuildLogQuery createUserIdNot(PK createUserIdNot);
            public TcgCodeBuildLogQuery createUserIdIn(PK createUserIdIn);
            public TcgCodeBuildLogQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgCodeBuildLogQuery createUserIdIsNull();
            public TcgCodeBuildLogQuery createUserIdIsNotNull();












        public TcgCodeBuildLogQuery updateTime(Timestamp updateTime);
        public TcgCodeBuildLogQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgCodeBuildLogQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgCodeBuildLogQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgCodeBuildLogQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgCodeBuildLogQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgCodeBuildLogQuery updateUserId(PK updateUserId);
            public TcgCodeBuildLogQuery updateUserIdNot(PK updateUserIdNot);
            public TcgCodeBuildLogQuery updateUserIdIn(PK updateUserIdIn);
            public TcgCodeBuildLogQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgCodeBuildLogQuery updateUserIdIsNull();
            public TcgCodeBuildLogQuery updateUserIdIsNotNull();












        public TcgCodeBuildLogQuery versionNo(Integer versionNo);
        public TcgCodeBuildLogQuery versionNoNot(Integer versionNoNot);
        public TcgCodeBuildLogQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgCodeBuildLogQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgCodeBuildLogQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgCodeBuildLogQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}