package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgModuleConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 模块设置查询接口
 *
 * @author Administrator
 * @date 2018-7-24 14:46:24
 */
public interface TcgModuleConfigQuery<PK extends Serializable> extends Query<TcgModuleConfigEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgModuleConfigQuery id(PK id);
            public TcgModuleConfigQuery idNot(PK idNot);
            public TcgModuleConfigQuery idIn(PK idIn);
            public TcgModuleConfigQuery idNotIn(PK idNotIn);
            public TcgModuleConfigQuery idIsNull();
            public TcgModuleConfigQuery idIsNotNull();












            public TcgModuleConfigQuery projectId(PK projectId);
            public TcgModuleConfigQuery projectIdNot(PK projectIdNot);
            public TcgModuleConfigQuery projectIdIn(PK projectIdIn);
            public TcgModuleConfigQuery projectIdNotIn(PK projectIdNotIn);
            public TcgModuleConfigQuery projectIdIsNull();
            public TcgModuleConfigQuery projectIdIsNotNull();












            public TcgModuleConfigQuery moduleName(String moduleName);
            public TcgModuleConfigQuery moduleNameNot(String moduleNameNot);
            public TcgModuleConfigQuery moduleNameIn(String moduleNameIn);
            public TcgModuleConfigQuery moduleNameNotIn(String moduleNameNotIn);
            public TcgModuleConfigQuery moduleNameLike(String moduleNameLike);
            public TcgModuleConfigQuery moduleNameNotLike(String moduleNameNotLike);
            public TcgModuleConfigQuery moduleNameIsNull();
            public TcgModuleConfigQuery moduleNameIsNotNull();












            public TcgModuleConfigQuery moduleResource(String moduleResource);
            public TcgModuleConfigQuery moduleResourceNot(String moduleResourceNot);
            public TcgModuleConfigQuery moduleResourceIn(String moduleResourceIn);
            public TcgModuleConfigQuery moduleResourceNotIn(String moduleResourceNotIn);
            public TcgModuleConfigQuery moduleResourceLike(String moduleResourceLike);
            public TcgModuleConfigQuery moduleResourceNotLike(String moduleResourceNotLike);
            public TcgModuleConfigQuery moduleResourceIsNull();
            public TcgModuleConfigQuery moduleResourceIsNotNull();












        public TcgModuleConfigQuery createTime(Timestamp createTime);
        public TcgModuleConfigQuery createTimeNot(Timestamp createTimeNot);
        public TcgModuleConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgModuleConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgModuleConfigQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgModuleConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgModuleConfigQuery createUserId(PK createUserId);
            public TcgModuleConfigQuery createUserIdNot(PK createUserIdNot);
            public TcgModuleConfigQuery createUserIdIn(PK createUserIdIn);
            public TcgModuleConfigQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgModuleConfigQuery createUserIdIsNull();
            public TcgModuleConfigQuery createUserIdIsNotNull();












        public TcgModuleConfigQuery updateTime(Timestamp updateTime);
        public TcgModuleConfigQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgModuleConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgModuleConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgModuleConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgModuleConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgModuleConfigQuery updateUserId(PK updateUserId);
            public TcgModuleConfigQuery updateUserIdNot(PK updateUserIdNot);
            public TcgModuleConfigQuery updateUserIdIn(PK updateUserIdIn);
            public TcgModuleConfigQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgModuleConfigQuery updateUserIdIsNull();
            public TcgModuleConfigQuery updateUserIdIsNotNull();












        public TcgModuleConfigQuery versionNo(Integer versionNo);
        public TcgModuleConfigQuery versionNoNot(Integer versionNoNot);
        public TcgModuleConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgModuleConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgModuleConfigQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgModuleConfigQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}