package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgOperationEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 操作表查询接口
 *
 * @author Administrator
 * @date 2018-7-29 1:16:14
 */
public interface TcgOperationQuery<PK extends Serializable> extends Query<TcgOperationEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgOperationQuery id(PK id);
            public TcgOperationQuery idNot(PK idNot);
            public TcgOperationQuery idIn(PK idIn);
            public TcgOperationQuery idNotIn(PK idNotIn);
            public TcgOperationQuery idIsNull();
            public TcgOperationQuery idIsNotNull();












            public TcgOperationQuery operationName(String operationName);
            public TcgOperationQuery operationNameNot(String operationNameNot);
            public TcgOperationQuery operationNameIn(String operationNameIn);
            public TcgOperationQuery operationNameNotIn(String operationNameNotIn);
            public TcgOperationQuery operationNameLike(String operationNameLike);
            public TcgOperationQuery operationNameNotLike(String operationNameNotLike);
            public TcgOperationQuery operationNameIsNull();
            public TcgOperationQuery operationNameIsNotNull();












            public TcgOperationQuery operationResource(String operationResource);
            public TcgOperationQuery operationResourceNot(String operationResourceNot);
            public TcgOperationQuery operationResourceIn(String operationResourceIn);
            public TcgOperationQuery operationResourceNotIn(String operationResourceNotIn);
            public TcgOperationQuery operationResourceLike(String operationResourceLike);
            public TcgOperationQuery operationResourceNotLike(String operationResourceNotLike);
            public TcgOperationQuery operationResourceIsNull();
            public TcgOperationQuery operationResourceIsNotNull();












        public TcgOperationQuery createTime(Timestamp createTime);
        public TcgOperationQuery createTimeNot(Timestamp createTimeNot);
        public TcgOperationQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgOperationQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgOperationQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgOperationQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgOperationQuery createUserId(PK createUserId);
            public TcgOperationQuery createUserIdNot(PK createUserIdNot);
            public TcgOperationQuery createUserIdIn(PK createUserIdIn);
            public TcgOperationQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgOperationQuery createUserIdIsNull();
            public TcgOperationQuery createUserIdIsNotNull();












        public TcgOperationQuery updateTime(Timestamp updateTime);
        public TcgOperationQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgOperationQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgOperationQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgOperationQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgOperationQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgOperationQuery updateUserId(PK updateUserId);
            public TcgOperationQuery updateUserIdNot(PK updateUserIdNot);
            public TcgOperationQuery updateUserIdIn(PK updateUserIdIn);
            public TcgOperationQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgOperationQuery updateUserIdIsNull();
            public TcgOperationQuery updateUserIdIsNotNull();












        public TcgOperationQuery versionNo(Integer versionNo);
        public TcgOperationQuery versionNoNot(Integer versionNoNot);
        public TcgOperationQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgOperationQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgOperationQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgOperationQuery versionNoLessEqual(Integer versionNoLessEqual);










            public TcgOperationQuery deleteFlag(String deleteFlag);
            public TcgOperationQuery deleteFlagNot(String deleteFlagNot);
            public TcgOperationQuery deleteFlagIn(String deleteFlagIn);
            public TcgOperationQuery deleteFlagNotIn(String deleteFlagNotIn);
            public TcgOperationQuery deleteFlagIsNull();
            public TcgOperationQuery deleteFlagIsNotNull();









	
}