package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgQueryConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 查询条件设置查询接口
 *
 * @author Administrator
 * @date 2018-7-29 1:16:14
 */
public interface TcgQueryConfigQuery<PK extends Serializable> extends Query<TcgQueryConfigEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgQueryConfigQuery id(PK id);
            public TcgQueryConfigQuery idNot(PK idNot);
            public TcgQueryConfigQuery idIn(PK idIn);
            public TcgQueryConfigQuery idNotIn(PK idNotIn);
            public TcgQueryConfigQuery idIsNull();
            public TcgQueryConfigQuery idIsNotNull();












            public TcgQueryConfigQuery tableId(PK tableId);
            public TcgQueryConfigQuery tableIdNot(PK tableIdNot);
            public TcgQueryConfigQuery tableIdIn(PK tableIdIn);
            public TcgQueryConfigQuery tableIdNotIn(PK tableIdNotIn);
            public TcgQueryConfigQuery tableIdIsNull();
            public TcgQueryConfigQuery tableIdIsNotNull();












            public TcgQueryConfigQuery columnId(PK columnId);
            public TcgQueryConfigQuery columnIdNot(PK columnIdNot);
            public TcgQueryConfigQuery columnIdIn(PK columnIdIn);
            public TcgQueryConfigQuery columnIdNotIn(PK columnIdNotIn);
            public TcgQueryConfigQuery columnIdIsNull();
            public TcgQueryConfigQuery columnIdIsNotNull();












            public TcgQueryConfigQuery queryTitle(String queryTitle);
            public TcgQueryConfigQuery queryTitleNot(String queryTitleNot);
            public TcgQueryConfigQuery queryTitleIn(String queryTitleIn);
            public TcgQueryConfigQuery queryTitleNotIn(String queryTitleNotIn);
            public TcgQueryConfigQuery queryTitleLike(String queryTitleLike);
            public TcgQueryConfigQuery queryTitleNotLike(String queryTitleNotLike);
            public TcgQueryConfigQuery queryTitleIsNull();
            public TcgQueryConfigQuery queryTitleIsNotNull();












            public TcgQueryConfigQuery queryPlaceholder(String queryPlaceholder);
            public TcgQueryConfigQuery queryPlaceholderNot(String queryPlaceholderNot);
            public TcgQueryConfigQuery queryPlaceholderIn(String queryPlaceholderIn);
            public TcgQueryConfigQuery queryPlaceholderNotIn(String queryPlaceholderNotIn);
            public TcgQueryConfigQuery queryPlaceholderLike(String queryPlaceholderLike);
            public TcgQueryConfigQuery queryPlaceholderNotLike(String queryPlaceholderNotLike);
            public TcgQueryConfigQuery queryPlaceholderIsNull();
            public TcgQueryConfigQuery queryPlaceholderIsNotNull();












            public TcgQueryConfigQuery queryRelation(String queryRelation);
            public TcgQueryConfigQuery queryRelationNot(String queryRelationNot);
            public TcgQueryConfigQuery queryRelationIn(String queryRelationIn);
            public TcgQueryConfigQuery queryRelationNotIn(String queryRelationNotIn);
            public TcgQueryConfigQuery queryRelationLike(String queryRelationLike);
            public TcgQueryConfigQuery queryRelationNotLike(String queryRelationNotLike);
            public TcgQueryConfigQuery queryRelationIsNull();
            public TcgQueryConfigQuery queryRelationIsNotNull();












        public TcgQueryConfigQuery querySort(Integer querySort);
        public TcgQueryConfigQuery querySortNot(Integer querySortNot);
        public TcgQueryConfigQuery querySortGreaterThan(Integer querySortGreaterThan);
        public TcgQueryConfigQuery querySortGreaterEqual(Integer querySortGreaterEqual);
        public TcgQueryConfigQuery querySortLessThan(Integer querySortLessThan);
        public TcgQueryConfigQuery querySortLessEqual(Integer querySortLessEqual);










        public TcgQueryConfigQuery createTime(Timestamp createTime);
        public TcgQueryConfigQuery createTimeNot(Timestamp createTimeNot);
        public TcgQueryConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgQueryConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgQueryConfigQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgQueryConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgQueryConfigQuery createUserId(PK createUserId);
            public TcgQueryConfigQuery createUserIdNot(PK createUserIdNot);
            public TcgQueryConfigQuery createUserIdIn(PK createUserIdIn);
            public TcgQueryConfigQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgQueryConfigQuery createUserIdIsNull();
            public TcgQueryConfigQuery createUserIdIsNotNull();












        public TcgQueryConfigQuery updateTime(Timestamp updateTime);
        public TcgQueryConfigQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgQueryConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgQueryConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgQueryConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgQueryConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgQueryConfigQuery updateUserId(PK updateUserId);
            public TcgQueryConfigQuery updateUserIdNot(PK updateUserIdNot);
            public TcgQueryConfigQuery updateUserIdIn(PK updateUserIdIn);
            public TcgQueryConfigQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgQueryConfigQuery updateUserIdIsNull();
            public TcgQueryConfigQuery updateUserIdIsNotNull();












        public TcgQueryConfigQuery versionNo(Integer versionNo);
        public TcgQueryConfigQuery versionNoNot(Integer versionNoNot);
        public TcgQueryConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgQueryConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgQueryConfigQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgQueryConfigQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}