package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgIndexConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 索引设置查询接口
 *
 * @author Administrator
 * @date 2018-7-24 14:46:24
 */
public interface TcgIndexConfigQuery<PK extends Serializable> extends Query<TcgIndexConfigEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgIndexConfigQuery id(PK id);
            public TcgIndexConfigQuery idNot(PK idNot);
            public TcgIndexConfigQuery idIn(PK idIn);
            public TcgIndexConfigQuery idNotIn(PK idNotIn);
            public TcgIndexConfigQuery idIsNull();
            public TcgIndexConfigQuery idIsNotNull();












            public TcgIndexConfigQuery tableId(PK tableId);
            public TcgIndexConfigQuery tableIdNot(PK tableIdNot);
            public TcgIndexConfigQuery tableIdIn(PK tableIdIn);
            public TcgIndexConfigQuery tableIdNotIn(PK tableIdNotIn);
            public TcgIndexConfigQuery tableIdIsNull();
            public TcgIndexConfigQuery tableIdIsNotNull();












            public TcgIndexConfigQuery indexName(String indexName);
            public TcgIndexConfigQuery indexNameNot(String indexNameNot);
            public TcgIndexConfigQuery indexNameIn(String indexNameIn);
            public TcgIndexConfigQuery indexNameNotIn(String indexNameNotIn);
            public TcgIndexConfigQuery indexNameLike(String indexNameLike);
            public TcgIndexConfigQuery indexNameNotLike(String indexNameNotLike);
            public TcgIndexConfigQuery indexNameIsNull();
            public TcgIndexConfigQuery indexNameIsNotNull();












            public TcgIndexConfigQuery indexCloumns(String indexCloumns);
            public TcgIndexConfigQuery indexCloumnsNot(String indexCloumnsNot);
            public TcgIndexConfigQuery indexCloumnsIn(String indexCloumnsIn);
            public TcgIndexConfigQuery indexCloumnsNotIn(String indexCloumnsNotIn);
            public TcgIndexConfigQuery indexCloumnsLike(String indexCloumnsLike);
            public TcgIndexConfigQuery indexCloumnsNotLike(String indexCloumnsNotLike);
            public TcgIndexConfigQuery indexCloumnsIsNull();
            public TcgIndexConfigQuery indexCloumnsIsNotNull();












        public TcgIndexConfigQuery createTime(Timestamp createTime);
        public TcgIndexConfigQuery createTimeNot(Timestamp createTimeNot);
        public TcgIndexConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgIndexConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgIndexConfigQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgIndexConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgIndexConfigQuery createUserId(PK createUserId);
            public TcgIndexConfigQuery createUserIdNot(PK createUserIdNot);
            public TcgIndexConfigQuery createUserIdIn(PK createUserIdIn);
            public TcgIndexConfigQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgIndexConfigQuery createUserIdIsNull();
            public TcgIndexConfigQuery createUserIdIsNotNull();












        public TcgIndexConfigQuery updateTime(Timestamp updateTime);
        public TcgIndexConfigQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgIndexConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgIndexConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgIndexConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgIndexConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgIndexConfigQuery updateUserId(PK updateUserId);
            public TcgIndexConfigQuery updateUserIdNot(PK updateUserIdNot);
            public TcgIndexConfigQuery updateUserIdIn(PK updateUserIdIn);
            public TcgIndexConfigQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgIndexConfigQuery updateUserIdIsNull();
            public TcgIndexConfigQuery updateUserIdIsNotNull();












        public TcgIndexConfigQuery versionNo(Integer versionNo);
        public TcgIndexConfigQuery versionNoNot(Integer versionNoNot);
        public TcgIndexConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgIndexConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgIndexConfigQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgIndexConfigQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}