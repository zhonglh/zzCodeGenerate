package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgColumnEventEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 列事件查询接口
 *
 * @author Administrator
 * @date 2018-7-29 1:16:08
 */
public interface TcgColumnEventQuery<PK extends Serializable> extends Query<TcgColumnEventEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgColumnEventQuery id(PK id);
            public TcgColumnEventQuery idNot(PK idNot);
            public TcgColumnEventQuery idIn(PK idIn);
            public TcgColumnEventQuery idNotIn(PK idNotIn);
            public TcgColumnEventQuery idIsNull();
            public TcgColumnEventQuery idIsNotNull();












            public TcgColumnEventQuery columnId(PK columnId);
            public TcgColumnEventQuery columnIdNot(PK columnIdNot);
            public TcgColumnEventQuery columnIdIn(PK columnIdIn);
            public TcgColumnEventQuery columnIdNotIn(PK columnIdNotIn);
            public TcgColumnEventQuery columnIdIsNull();
            public TcgColumnEventQuery columnIdIsNotNull();












            public TcgColumnEventQuery eventName(String eventName);
            public TcgColumnEventQuery eventNameNot(String eventNameNot);
            public TcgColumnEventQuery eventNameIn(String eventNameIn);
            public TcgColumnEventQuery eventNameNotIn(String eventNameNotIn);
            public TcgColumnEventQuery eventNameLike(String eventNameLike);
            public TcgColumnEventQuery eventNameNotLike(String eventNameNotLike);
            public TcgColumnEventQuery eventNameIsNull();
            public TcgColumnEventQuery eventNameIsNotNull();












            public TcgColumnEventQuery funcBody(String funcBody);
            public TcgColumnEventQuery funcBodyNot(String funcBodyNot);
            public TcgColumnEventQuery funcBodyIn(String funcBodyIn);
            public TcgColumnEventQuery funcBodyNotIn(String funcBodyNotIn);
            public TcgColumnEventQuery funcBodyLike(String funcBodyLike);
            public TcgColumnEventQuery funcBodyNotLike(String funcBodyNotLike);
            public TcgColumnEventQuery funcBodyIsNull();
            public TcgColumnEventQuery funcBodyIsNotNull();












        public TcgColumnEventQuery createTime(Timestamp createTime);
        public TcgColumnEventQuery createTimeNot(Timestamp createTimeNot);
        public TcgColumnEventQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgColumnEventQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgColumnEventQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgColumnEventQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgColumnEventQuery createUserId(PK createUserId);
            public TcgColumnEventQuery createUserIdNot(PK createUserIdNot);
            public TcgColumnEventQuery createUserIdIn(PK createUserIdIn);
            public TcgColumnEventQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgColumnEventQuery createUserIdIsNull();
            public TcgColumnEventQuery createUserIdIsNotNull();












        public TcgColumnEventQuery updateTime(Timestamp updateTime);
        public TcgColumnEventQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgColumnEventQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgColumnEventQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgColumnEventQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgColumnEventQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgColumnEventQuery updateUserId(PK updateUserId);
            public TcgColumnEventQuery updateUserIdNot(PK updateUserIdNot);
            public TcgColumnEventQuery updateUserIdIn(PK updateUserIdIn);
            public TcgColumnEventQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgColumnEventQuery updateUserIdIsNull();
            public TcgColumnEventQuery updateUserIdIsNotNull();












        public TcgColumnEventQuery versionNo(Integer versionNo);
        public TcgColumnEventQuery versionNoNot(Integer versionNoNot);
        public TcgColumnEventQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgColumnEventQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgColumnEventQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgColumnEventQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}