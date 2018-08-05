package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgExColumnEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 扩展列设置查询接口
 *
 * @author Administrator
 * @date 2018-8-5 15:15:58
 */
public interface TcgExColumnQuery<PK extends Serializable> extends Query<TcgExColumnEntity,PK> {






            public TcgExColumnQuery id(PK id);
            public TcgExColumnQuery idNot(PK idNot);
            public TcgExColumnQuery idIn(PK idIn);
            public TcgExColumnQuery idNotIn(PK idNotIn);
            public TcgExColumnQuery idIsNull();
            public TcgExColumnQuery idIsNotNull();












            public TcgExColumnQuery tableId(PK tableId);
            public TcgExColumnQuery tableIdNot(PK tableIdNot);
            public TcgExColumnQuery tableIdIn(PK tableIdIn);
            public TcgExColumnQuery tableIdNotIn(PK tableIdNotIn);
            public TcgExColumnQuery tableIdIsNull();
            public TcgExColumnQuery tableIdIsNotNull();












            public TcgExColumnQuery originalColumnId(PK originalColumnId);
            public TcgExColumnQuery originalColumnIdNot(PK originalColumnIdNot);
            public TcgExColumnQuery originalColumnIdIn(PK originalColumnIdIn);
            public TcgExColumnQuery originalColumnIdNotIn(PK originalColumnIdNotIn);
            public TcgExColumnQuery originalColumnIdIsNull();
            public TcgExColumnQuery originalColumnIdIsNotNull();












            public TcgExColumnQuery javaSimpleClass(String javaSimpleClass);
            public TcgExColumnQuery javaSimpleClassNot(String javaSimpleClassNot);
            public TcgExColumnQuery javaSimpleClassIn(String javaSimpleClassIn);
            public TcgExColumnQuery javaSimpleClassNotIn(String javaSimpleClassNotIn);
            public TcgExColumnQuery javaSimpleClassLike(String javaSimpleClassLike);
            public TcgExColumnQuery javaSimpleClassNotLike(String javaSimpleClassNotLike);
            public TcgExColumnQuery javaSimpleClassIsNull();
            public TcgExColumnQuery javaSimpleClassIsNotNull();












            public TcgExColumnQuery javaFullClass(String javaFullClass);
            public TcgExColumnQuery javaFullClassNot(String javaFullClassNot);
            public TcgExColumnQuery javaFullClassIn(String javaFullClassIn);
            public TcgExColumnQuery javaFullClassNotIn(String javaFullClassNotIn);
            public TcgExColumnQuery javaFullClassLike(String javaFullClassLike);
            public TcgExColumnQuery javaFullClassNotLike(String javaFullClassNotLike);
            public TcgExColumnQuery javaFullClassIsNull();
            public TcgExColumnQuery javaFullClassIsNotNull();












            public TcgExColumnQuery javaName(String javaName);
            public TcgExColumnQuery javaNameNot(String javaNameNot);
            public TcgExColumnQuery javaNameIn(String javaNameIn);
            public TcgExColumnQuery javaNameNotIn(String javaNameNotIn);
            public TcgExColumnQuery javaNameLike(String javaNameLike);
            public TcgExColumnQuery javaNameNotLike(String javaNameNotLike);
            public TcgExColumnQuery javaNameIsNull();
            public TcgExColumnQuery javaNameIsNotNull();












        public TcgExColumnQuery columnSort(Integer columnSort);
        public TcgExColumnQuery columnSortNot(Integer columnSortNot);
        public TcgExColumnQuery columnSortGreaterThan(Integer columnSortGreaterThan);
        public TcgExColumnQuery columnSortGreaterEqual(Integer columnSortGreaterEqual);
        public TcgExColumnQuery columnSortLessThan(Integer columnSortLessThan);
        public TcgExColumnQuery columnSortLessEqual(Integer columnSortLessEqual);










            public TcgExColumnQuery columnTitle(String columnTitle);
            public TcgExColumnQuery columnTitleNot(String columnTitleNot);
            public TcgExColumnQuery columnTitleIn(String columnTitleIn);
            public TcgExColumnQuery columnTitleNotIn(String columnTitleNotIn);
            public TcgExColumnQuery columnTitleLike(String columnTitleLike);
            public TcgExColumnQuery columnTitleNotLike(String columnTitleNotLike);
            public TcgExColumnQuery columnTitleIsNull();
            public TcgExColumnQuery columnTitleIsNotNull();












            public TcgExColumnQuery fkColumnName(String fkColumnName);
            public TcgExColumnQuery fkColumnNameNot(String fkColumnNameNot);
            public TcgExColumnQuery fkColumnNameIn(String fkColumnNameIn);
            public TcgExColumnQuery fkColumnNameNotIn(String fkColumnNameNotIn);
            public TcgExColumnQuery fkColumnNameLike(String fkColumnNameLike);
            public TcgExColumnQuery fkColumnNameNotLike(String fkColumnNameNotLike);
            public TcgExColumnQuery fkColumnNameIsNull();
            public TcgExColumnQuery fkColumnNameIsNotNull();












        public TcgExColumnQuery createTime(Timestamp createTime);
        public TcgExColumnQuery createTimeNot(Timestamp createTimeNot);
        public TcgExColumnQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgExColumnQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgExColumnQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgExColumnQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgExColumnQuery createUserId(PK createUserId);
            public TcgExColumnQuery createUserIdNot(PK createUserIdNot);
            public TcgExColumnQuery createUserIdIn(PK createUserIdIn);
            public TcgExColumnQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgExColumnQuery createUserIdIsNull();
            public TcgExColumnQuery createUserIdIsNotNull();












        public TcgExColumnQuery updateTime(Timestamp updateTime);
        public TcgExColumnQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgExColumnQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgExColumnQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgExColumnQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgExColumnQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgExColumnQuery updateUserId(PK updateUserId);
            public TcgExColumnQuery updateUserIdNot(PK updateUserIdNot);
            public TcgExColumnQuery updateUserIdIn(PK updateUserIdIn);
            public TcgExColumnQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgExColumnQuery updateUserIdIsNull();
            public TcgExColumnQuery updateUserIdIsNotNull();












        public TcgExColumnQuery versionNo(Integer versionNo);
        public TcgExColumnQuery versionNoNot(Integer versionNoNot);
        public TcgExColumnQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgExColumnQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgExColumnQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgExColumnQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}