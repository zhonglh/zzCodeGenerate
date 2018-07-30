package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgJavaDatatypeRealEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 数据类型关联查询接口
 *
 * @author Administrator
 * @date 2018-7-30 17:18:07
 */
public interface TcgJavaDatatypeRealQuery<PK extends Serializable> extends Query<TcgJavaDatatypeRealEntity,PK> {






            public TcgJavaDatatypeRealQuery id(PK id);
            public TcgJavaDatatypeRealQuery idNot(PK idNot);
            public TcgJavaDatatypeRealQuery idIn(PK idIn);
            public TcgJavaDatatypeRealQuery idNotIn(PK idNotIn);
            public TcgJavaDatatypeRealQuery idIsNull();
            public TcgJavaDatatypeRealQuery idIsNotNull();












            public TcgJavaDatatypeRealQuery javaType(String javaType);
            public TcgJavaDatatypeRealQuery javaTypeNot(String javaTypeNot);
            public TcgJavaDatatypeRealQuery javaTypeIn(String javaTypeIn);
            public TcgJavaDatatypeRealQuery javaTypeNotIn(String javaTypeNotIn);
            public TcgJavaDatatypeRealQuery javaTypeLike(String javaTypeLike);
            public TcgJavaDatatypeRealQuery javaTypeNotLike(String javaTypeNotLike);
            public TcgJavaDatatypeRealQuery javaTypeIsNull();
            public TcgJavaDatatypeRealQuery javaTypeIsNotNull();












            public TcgJavaDatatypeRealQuery dataType(String dataType);
            public TcgJavaDatatypeRealQuery dataTypeNot(String dataTypeNot);
            public TcgJavaDatatypeRealQuery dataTypeIn(String dataTypeIn);
            public TcgJavaDatatypeRealQuery dataTypeNotIn(String dataTypeNotIn);
            public TcgJavaDatatypeRealQuery dataTypeLike(String dataTypeLike);
            public TcgJavaDatatypeRealQuery dataTypeNotLike(String dataTypeNotLike);
            public TcgJavaDatatypeRealQuery dataTypeIsNull();
            public TcgJavaDatatypeRealQuery dataTypeIsNotNull();












        public TcgJavaDatatypeRealQuery createTime(Timestamp createTime);
        public TcgJavaDatatypeRealQuery createTimeNot(Timestamp createTimeNot);
        public TcgJavaDatatypeRealQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgJavaDatatypeRealQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgJavaDatatypeRealQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgJavaDatatypeRealQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgJavaDatatypeRealQuery createUserId(PK createUserId);
            public TcgJavaDatatypeRealQuery createUserIdNot(PK createUserIdNot);
            public TcgJavaDatatypeRealQuery createUserIdIn(PK createUserIdIn);
            public TcgJavaDatatypeRealQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgJavaDatatypeRealQuery createUserIdIsNull();
            public TcgJavaDatatypeRealQuery createUserIdIsNotNull();












        public TcgJavaDatatypeRealQuery updateTime(Timestamp updateTime);
        public TcgJavaDatatypeRealQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgJavaDatatypeRealQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgJavaDatatypeRealQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgJavaDatatypeRealQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgJavaDatatypeRealQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgJavaDatatypeRealQuery updateUserId(PK updateUserId);
            public TcgJavaDatatypeRealQuery updateUserIdNot(PK updateUserIdNot);
            public TcgJavaDatatypeRealQuery updateUserIdIn(PK updateUserIdIn);
            public TcgJavaDatatypeRealQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgJavaDatatypeRealQuery updateUserIdIsNull();
            public TcgJavaDatatypeRealQuery updateUserIdIsNotNull();












        public TcgJavaDatatypeRealQuery versionNo(Integer versionNo);
        public TcgJavaDatatypeRealQuery versionNoNot(Integer versionNoNot);
        public TcgJavaDatatypeRealQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgJavaDatatypeRealQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgJavaDatatypeRealQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgJavaDatatypeRealQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}