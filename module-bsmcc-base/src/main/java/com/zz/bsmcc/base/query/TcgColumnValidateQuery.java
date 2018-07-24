package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgColumnValidateEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 列校验查询接口
 *
 * @author Administrator
 * @date 2018-7-24 12:32:15
 */
public interface TcgColumnValidateQuery<PK extends Serializable> extends Query<TcgColumnValidateEntity,PK> {
	static final long serialVersionUID = 1L;





            public TcgColumnValidateQuery id(PK id);
            public TcgColumnValidateQuery idNot(PK idNot);
            public TcgColumnValidateQuery idIn(PK idIn);
            public TcgColumnValidateQuery idNotIn(PK idNotIn);
            public TcgColumnValidateQuery idIsNull();
            public TcgColumnValidateQuery idIsNotNull();












            public TcgColumnValidateQuery columnId(PK columnId);
            public TcgColumnValidateQuery columnIdNot(PK columnIdNot);
            public TcgColumnValidateQuery columnIdIn(PK columnIdIn);
            public TcgColumnValidateQuery columnIdNotIn(PK columnIdNotIn);
            public TcgColumnValidateQuery columnIdIsNull();
            public TcgColumnValidateQuery columnIdIsNotNull();












            public TcgColumnValidateQuery rex(String rex);
            public TcgColumnValidateQuery rexNot(String rexNot);
            public TcgColumnValidateQuery rexIn(String rexIn);
            public TcgColumnValidateQuery rexNotIn(String rexNotIn);
            public TcgColumnValidateQuery rexLike(String rexLike);
            public TcgColumnValidateQuery rexNotLike(String rexNotLike);
            public TcgColumnValidateQuery rexIsNull();
            public TcgColumnValidateQuery rexIsNotNull();












            public TcgColumnValidateQuery msg(String msg);
            public TcgColumnValidateQuery msgNot(String msgNot);
            public TcgColumnValidateQuery msgIn(String msgIn);
            public TcgColumnValidateQuery msgNotIn(String msgNotIn);
            public TcgColumnValidateQuery msgLike(String msgLike);
            public TcgColumnValidateQuery msgNotLike(String msgNotLike);
            public TcgColumnValidateQuery msgIsNull();
            public TcgColumnValidateQuery msgIsNotNull();












        public TcgColumnValidateQuery createTime(Timestamp createTime);
        public TcgColumnValidateQuery createTimeNot(Timestamp createTimeNot);
        public TcgColumnValidateQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgColumnValidateQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgColumnValidateQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgColumnValidateQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgColumnValidateQuery createUserId(PK createUserId);
            public TcgColumnValidateQuery createUserIdNot(PK createUserIdNot);
            public TcgColumnValidateQuery createUserIdIn(PK createUserIdIn);
            public TcgColumnValidateQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgColumnValidateQuery createUserIdIsNull();
            public TcgColumnValidateQuery createUserIdIsNotNull();












        public TcgColumnValidateQuery updateTime(Timestamp updateTime);
        public TcgColumnValidateQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgColumnValidateQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgColumnValidateQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgColumnValidateQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgColumnValidateQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgColumnValidateQuery updateUserId(PK updateUserId);
            public TcgColumnValidateQuery updateUserIdNot(PK updateUserIdNot);
            public TcgColumnValidateQuery updateUserIdIn(PK updateUserIdIn);
            public TcgColumnValidateQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgColumnValidateQuery updateUserIdIsNull();
            public TcgColumnValidateQuery updateUserIdIsNotNull();












        public TcgColumnValidateQuery versionNo(Integer versionNo);
        public TcgColumnValidateQuery versionNoNot(Integer versionNoNot);
        public TcgColumnValidateQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgColumnValidateQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgColumnValidateQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgColumnValidateQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}