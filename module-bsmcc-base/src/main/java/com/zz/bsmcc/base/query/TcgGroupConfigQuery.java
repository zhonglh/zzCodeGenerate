package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgGroupConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 组设置查询接口
 *
 * @author Administrator
 * @date 2018-7-24 12:32:15
 */
public interface TcgGroupConfigQuery<PK extends Serializable> extends Query<TcgGroupConfigEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgGroupConfigQuery id(PK id);
            public TcgGroupConfigQuery idNot(PK idNot);
            public TcgGroupConfigQuery idIn(PK idIn);
            public TcgGroupConfigQuery idNotIn(PK idNotIn);
            public TcgGroupConfigQuery idIsNull();
            public TcgGroupConfigQuery idIsNotNull();












            public TcgGroupConfigQuery projectId(PK projectId);
            public TcgGroupConfigQuery projectIdNot(PK projectIdNot);
            public TcgGroupConfigQuery projectIdIn(PK projectIdIn);
            public TcgGroupConfigQuery projectIdNotIn(PK projectIdNotIn);
            public TcgGroupConfigQuery projectIdIsNull();
            public TcgGroupConfigQuery projectIdIsNotNull();












            public TcgGroupConfigQuery moduleName(String moduleName);
            public TcgGroupConfigQuery moduleNameNot(String moduleNameNot);
            public TcgGroupConfigQuery moduleNameIn(String moduleNameIn);
            public TcgGroupConfigQuery moduleNameNotIn(String moduleNameNotIn);
            public TcgGroupConfigQuery moduleNameLike(String moduleNameLike);
            public TcgGroupConfigQuery moduleNameNotLike(String moduleNameNotLike);
            public TcgGroupConfigQuery moduleNameIsNull();
            public TcgGroupConfigQuery moduleNameIsNotNull();












            public TcgGroupConfigQuery groupCode(String groupCode);
            public TcgGroupConfigQuery groupCodeNot(String groupCodeNot);
            public TcgGroupConfigQuery groupCodeIn(String groupCodeIn);
            public TcgGroupConfigQuery groupCodeNotIn(String groupCodeNotIn);
            public TcgGroupConfigQuery groupCodeLike(String groupCodeLike);
            public TcgGroupConfigQuery groupCodeNotLike(String groupCodeNotLike);
            public TcgGroupConfigQuery groupCodeIsNull();
            public TcgGroupConfigQuery groupCodeIsNotNull();












        public TcgGroupConfigQuery createTime(Timestamp createTime);
        public TcgGroupConfigQuery createTimeNot(Timestamp createTimeNot);
        public TcgGroupConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgGroupConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgGroupConfigQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgGroupConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgGroupConfigQuery createUserId(PK createUserId);
            public TcgGroupConfigQuery createUserIdNot(PK createUserIdNot);
            public TcgGroupConfigQuery createUserIdIn(PK createUserIdIn);
            public TcgGroupConfigQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgGroupConfigQuery createUserIdIsNull();
            public TcgGroupConfigQuery createUserIdIsNotNull();












        public TcgGroupConfigQuery updateTime(Timestamp updateTime);
        public TcgGroupConfigQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgGroupConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgGroupConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgGroupConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgGroupConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgGroupConfigQuery updateUserId(PK updateUserId);
            public TcgGroupConfigQuery updateUserIdNot(PK updateUserIdNot);
            public TcgGroupConfigQuery updateUserIdIn(PK updateUserIdIn);
            public TcgGroupConfigQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgGroupConfigQuery updateUserIdIsNull();
            public TcgGroupConfigQuery updateUserIdIsNotNull();












        public TcgGroupConfigQuery versionNo(Integer versionNo);
        public TcgGroupConfigQuery versionNoNot(Integer versionNoNot);
        public TcgGroupConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgGroupConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgGroupConfigQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgGroupConfigQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}