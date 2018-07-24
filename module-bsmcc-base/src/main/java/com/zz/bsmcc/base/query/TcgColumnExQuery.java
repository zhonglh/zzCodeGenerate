package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgColumnExEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 列扩展查询接口
 *
 * @author Administrator
 * @date 2018-7-24 12:32:14
 */
public interface TcgColumnExQuery<PK extends Serializable> extends Query<TcgColumnExEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgColumnExQuery id(PK id);
            public TcgColumnExQuery idNot(PK idNot);
            public TcgColumnExQuery idIn(PK idIn);
            public TcgColumnExQuery idNotIn(PK idNotIn);
            public TcgColumnExQuery idIsNull();
            public TcgColumnExQuery idIsNotNull();












            public TcgColumnExQuery columnId(PK columnId);
            public TcgColumnExQuery columnIdNot(PK columnIdNot);
            public TcgColumnExQuery columnIdIn(PK columnIdIn);
            public TcgColumnExQuery columnIdNotIn(PK columnIdNotIn);
            public TcgColumnExQuery columnIdIsNull();
            public TcgColumnExQuery columnIdIsNotNull();












            public TcgColumnExQuery exKey(String exKey);
            public TcgColumnExQuery exKeyNot(String exKeyNot);
            public TcgColumnExQuery exKeyIn(String exKeyIn);
            public TcgColumnExQuery exKeyNotIn(String exKeyNotIn);
            public TcgColumnExQuery exKeyLike(String exKeyLike);
            public TcgColumnExQuery exKeyNotLike(String exKeyNotLike);
            public TcgColumnExQuery exKeyIsNull();
            public TcgColumnExQuery exKeyIsNotNull();












            public TcgColumnExQuery exVal(String exVal);
            public TcgColumnExQuery exValNot(String exValNot);
            public TcgColumnExQuery exValIn(String exValIn);
            public TcgColumnExQuery exValNotIn(String exValNotIn);
            public TcgColumnExQuery exValLike(String exValLike);
            public TcgColumnExQuery exValNotLike(String exValNotLike);
            public TcgColumnExQuery exValIsNull();
            public TcgColumnExQuery exValIsNotNull();












        public TcgColumnExQuery createTime(Timestamp createTime);
        public TcgColumnExQuery createTimeNot(Timestamp createTimeNot);
        public TcgColumnExQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgColumnExQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgColumnExQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgColumnExQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgColumnExQuery createUserId(PK createUserId);
            public TcgColumnExQuery createUserIdNot(PK createUserIdNot);
            public TcgColumnExQuery createUserIdIn(PK createUserIdIn);
            public TcgColumnExQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgColumnExQuery createUserIdIsNull();
            public TcgColumnExQuery createUserIdIsNotNull();












        public TcgColumnExQuery updateTime(Timestamp updateTime);
        public TcgColumnExQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgColumnExQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgColumnExQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgColumnExQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgColumnExQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgColumnExQuery updateUserId(PK updateUserId);
            public TcgColumnExQuery updateUserIdNot(PK updateUserIdNot);
            public TcgColumnExQuery updateUserIdIn(PK updateUserIdIn);
            public TcgColumnExQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgColumnExQuery updateUserIdIsNull();
            public TcgColumnExQuery updateUserIdIsNotNull();












        public TcgColumnExQuery versionNo(Integer versionNo);
        public TcgColumnExQuery versionNoNot(Integer versionNoNot);
        public TcgColumnExQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgColumnExQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgColumnExQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgColumnExQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}