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
 * @date 2018-7-30 17:18:06
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












            public TcgExColumnQuery originalColumnName(String originalColumnName);
            public TcgExColumnQuery originalColumnNameNot(String originalColumnNameNot);
            public TcgExColumnQuery originalColumnNameIn(String originalColumnNameIn);
            public TcgExColumnQuery originalColumnNameNotIn(String originalColumnNameNotIn);
            public TcgExColumnQuery originalColumnNameLike(String originalColumnNameLike);
            public TcgExColumnQuery originalColumnNameNotLike(String originalColumnNameNotLike);
            public TcgExColumnQuery originalColumnNameIsNull();
            public TcgExColumnQuery originalColumnNameIsNotNull();












            public TcgExColumnQuery originalColumnFk(String originalColumnFk);
            public TcgExColumnQuery originalColumnFkNot(String originalColumnFkNot);
            public TcgExColumnQuery originalColumnFkIn(String originalColumnFkIn);
            public TcgExColumnQuery originalColumnFkNotIn(String originalColumnFkNotIn);
            public TcgExColumnQuery originalColumnFkIsNull();
            public TcgExColumnQuery originalColumnFkIsNotNull();













            public TcgExColumnQuery originalColumnDict(String originalColumnDict);
            public TcgExColumnQuery originalColumnDictNot(String originalColumnDictNot);
            public TcgExColumnQuery originalColumnDictIn(String originalColumnDictIn);
            public TcgExColumnQuery originalColumnDictNotIn(String originalColumnDictNotIn);
            public TcgExColumnQuery originalColumnDictIsNull();
            public TcgExColumnQuery originalColumnDictIsNotNull();













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












            public TcgExColumnQuery groupCode(String groupCode);
            public TcgExColumnQuery groupCodeNot(String groupCodeNot);
            public TcgExColumnQuery groupCodeIn(String groupCodeIn);
            public TcgExColumnQuery groupCodeNotIn(String groupCodeNotIn);
            public TcgExColumnQuery groupCodeLike(String groupCodeLike);
            public TcgExColumnQuery groupCodeNotLike(String groupCodeNotLike);
            public TcgExColumnQuery groupCodeIsNull();
            public TcgExColumnQuery groupCodeIsNotNull();












            public TcgExColumnQuery dictType(String dictType);
            public TcgExColumnQuery dictTypeNot(String dictTypeNot);
            public TcgExColumnQuery dictTypeIn(String dictTypeIn);
            public TcgExColumnQuery dictTypeNotIn(String dictTypeNotIn);
            public TcgExColumnQuery dictTypeLike(String dictTypeLike);
            public TcgExColumnQuery dictTypeNotLike(String dictTypeNotLike);
            public TcgExColumnQuery dictTypeIsNull();
            public TcgExColumnQuery dictTypeIsNotNull();












            public TcgExColumnQuery tableSchema(String tableSchema);
            public TcgExColumnQuery tableSchemaNot(String tableSchemaNot);
            public TcgExColumnQuery tableSchemaIn(String tableSchemaIn);
            public TcgExColumnQuery tableSchemaNotIn(String tableSchemaNotIn);
            public TcgExColumnQuery tableSchemaLike(String tableSchemaLike);
            public TcgExColumnQuery tableSchemaNotLike(String tableSchemaNotLike);
            public TcgExColumnQuery tableSchemaIsNull();
            public TcgExColumnQuery tableSchemaIsNotNull();












            public TcgExColumnQuery tableName(String tableName);
            public TcgExColumnQuery tableNameNot(String tableNameNot);
            public TcgExColumnQuery tableNameIn(String tableNameIn);
            public TcgExColumnQuery tableNameNotIn(String tableNameNotIn);
            public TcgExColumnQuery tableNameLike(String tableNameLike);
            public TcgExColumnQuery tableNameNotLike(String tableNameNotLike);
            public TcgExColumnQuery tableNameIsNull();
            public TcgExColumnQuery tableNameIsNotNull();












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