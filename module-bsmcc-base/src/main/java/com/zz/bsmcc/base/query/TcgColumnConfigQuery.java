package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgColumnConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 列设置查询接口
 *
 * @author Administrator
 * @date 2018-8-5 15:15:57
 */
public interface TcgColumnConfigQuery<PK extends Serializable> extends Query<TcgColumnConfigEntity,PK> {






            public TcgColumnConfigQuery id(PK id);
            public TcgColumnConfigQuery idNot(PK idNot);
            public TcgColumnConfigQuery idIn(PK idIn);
            public TcgColumnConfigQuery idNotIn(PK idNotIn);
            public TcgColumnConfigQuery idIsNull();
            public TcgColumnConfigQuery idIsNotNull();












            public TcgColumnConfigQuery tableId(PK tableId);
            public TcgColumnConfigQuery tableIdNot(PK tableIdNot);
            public TcgColumnConfigQuery tableIdIn(PK tableIdIn);
            public TcgColumnConfigQuery tableIdNotIn(PK tableIdNotIn);
            public TcgColumnConfigQuery tableIdIsNull();
            public TcgColumnConfigQuery tableIdIsNotNull();












            public TcgColumnConfigQuery columnName(String columnName);
            public TcgColumnConfigQuery columnNameNot(String columnNameNot);
            public TcgColumnConfigQuery columnNameIn(String columnNameIn);
            public TcgColumnConfigQuery columnNameNotIn(String columnNameNotIn);
            public TcgColumnConfigQuery columnNameLike(String columnNameLike);
            public TcgColumnConfigQuery columnNameNotLike(String columnNameNotLike);
            public TcgColumnConfigQuery columnNameIsNull();
            public TcgColumnConfigQuery columnNameIsNotNull();












            public TcgColumnConfigQuery columnType(String columnType);
            public TcgColumnConfigQuery columnTypeNot(String columnTypeNot);
            public TcgColumnConfigQuery columnTypeIn(String columnTypeIn);
            public TcgColumnConfigQuery columnTypeNotIn(String columnTypeNotIn);
            public TcgColumnConfigQuery columnTypeLike(String columnTypeLike);
            public TcgColumnConfigQuery columnTypeNotLike(String columnTypeNotLike);
            public TcgColumnConfigQuery columnTypeIsNull();
            public TcgColumnConfigQuery columnTypeIsNotNull();












        public TcgColumnConfigQuery columnLength(Integer columnLength);
        public TcgColumnConfigQuery columnLengthNot(Integer columnLengthNot);
        public TcgColumnConfigQuery columnLengthGreaterThan(Integer columnLengthGreaterThan);
        public TcgColumnConfigQuery columnLengthGreaterEqual(Integer columnLengthGreaterEqual);
        public TcgColumnConfigQuery columnLengthLessThan(Integer columnLengthLessThan);
        public TcgColumnConfigQuery columnLengthLessEqual(Integer columnLengthLessEqual);










        public TcgColumnConfigQuery columnScale(Integer columnScale);
        public TcgColumnConfigQuery columnScaleNot(Integer columnScaleNot);
        public TcgColumnConfigQuery columnScaleGreaterThan(Integer columnScaleGreaterThan);
        public TcgColumnConfigQuery columnScaleGreaterEqual(Integer columnScaleGreaterEqual);
        public TcgColumnConfigQuery columnScaleLessThan(Integer columnScaleLessThan);
        public TcgColumnConfigQuery columnScaleLessEqual(Integer columnScaleLessEqual);










            public TcgColumnConfigQuery columnDefault(String columnDefault);
            public TcgColumnConfigQuery columnDefaultNot(String columnDefaultNot);
            public TcgColumnConfigQuery columnDefaultIn(String columnDefaultIn);
            public TcgColumnConfigQuery columnDefaultNotIn(String columnDefaultNotIn);
            public TcgColumnConfigQuery columnDefaultLike(String columnDefaultLike);
            public TcgColumnConfigQuery columnDefaultNotLike(String columnDefaultNotLike);
            public TcgColumnConfigQuery columnDefaultIsNull();
            public TcgColumnConfigQuery columnDefaultIsNotNull();












            public TcgColumnConfigQuery columnIsnull(String columnIsnull);
            public TcgColumnConfigQuery columnIsnullNot(String columnIsnullNot);
            public TcgColumnConfigQuery columnIsnullIn(String columnIsnullIn);
            public TcgColumnConfigQuery columnIsnullNotIn(String columnIsnullNotIn);
            public TcgColumnConfigQuery columnIsnullIsNull();
            public TcgColumnConfigQuery columnIsnullIsNotNull();













        public TcgColumnConfigQuery columnSort(Integer columnSort);
        public TcgColumnConfigQuery columnSortNot(Integer columnSortNot);
        public TcgColumnConfigQuery columnSortGreaterThan(Integer columnSortGreaterThan);
        public TcgColumnConfigQuery columnSortGreaterEqual(Integer columnSortGreaterEqual);
        public TcgColumnConfigQuery columnSortLessThan(Integer columnSortLessThan);
        public TcgColumnConfigQuery columnSortLessEqual(Integer columnSortLessEqual);










            public TcgColumnConfigQuery columnIsfk(String columnIsfk);
            public TcgColumnConfigQuery columnIsfkNot(String columnIsfkNot);
            public TcgColumnConfigQuery columnIsfkIn(String columnIsfkIn);
            public TcgColumnConfigQuery columnIsfkNotIn(String columnIsfkNotIn);
            public TcgColumnConfigQuery columnIsfkIsNull();
            public TcgColumnConfigQuery columnIsfkIsNotNull();













            public TcgColumnConfigQuery columnIskey(String columnIskey);
            public TcgColumnConfigQuery columnIskeyNot(String columnIskeyNot);
            public TcgColumnConfigQuery columnIskeyIn(String columnIskeyIn);
            public TcgColumnConfigQuery columnIskeyNotIn(String columnIskeyNotIn);
            public TcgColumnConfigQuery columnIskeyIsNull();
            public TcgColumnConfigQuery columnIskeyIsNotNull();













            public TcgColumnConfigQuery columnIsdict(String columnIsdict);
            public TcgColumnConfigQuery columnIsdictNot(String columnIsdictNot);
            public TcgColumnConfigQuery columnIsdictIn(String columnIsdictIn);
            public TcgColumnConfigQuery columnIsdictNotIn(String columnIsdictNotIn);
            public TcgColumnConfigQuery columnIsdictIsNull();
            public TcgColumnConfigQuery columnIsdictIsNotNull();













            public TcgColumnConfigQuery dictType(String dictType);
            public TcgColumnConfigQuery dictTypeNot(String dictTypeNot);
            public TcgColumnConfigQuery dictTypeIn(String dictTypeIn);
            public TcgColumnConfigQuery dictTypeNotIn(String dictTypeNotIn);
            public TcgColumnConfigQuery dictTypeLike(String dictTypeLike);
            public TcgColumnConfigQuery dictTypeNotLike(String dictTypeNotLike);
            public TcgColumnConfigQuery dictTypeIsNull();
            public TcgColumnConfigQuery dictTypeIsNotNull();












            public TcgColumnConfigQuery fkSchema(String fkSchema);
            public TcgColumnConfigQuery fkSchemaNot(String fkSchemaNot);
            public TcgColumnConfigQuery fkSchemaIn(String fkSchemaIn);
            public TcgColumnConfigQuery fkSchemaNotIn(String fkSchemaNotIn);
            public TcgColumnConfigQuery fkSchemaLike(String fkSchemaLike);
            public TcgColumnConfigQuery fkSchemaNotLike(String fkSchemaNotLike);
            public TcgColumnConfigQuery fkSchemaIsNull();
            public TcgColumnConfigQuery fkSchemaIsNotNull();












            public TcgColumnConfigQuery fkName(String fkName);
            public TcgColumnConfigQuery fkNameNot(String fkNameNot);
            public TcgColumnConfigQuery fkNameIn(String fkNameIn);
            public TcgColumnConfigQuery fkNameNotIn(String fkNameNotIn);
            public TcgColumnConfigQuery fkNameLike(String fkNameLike);
            public TcgColumnConfigQuery fkNameNotLike(String fkNameNotLike);
            public TcgColumnConfigQuery fkNameIsNull();
            public TcgColumnConfigQuery fkNameIsNotNull();












            public TcgColumnConfigQuery columnComment(String columnComment);
            public TcgColumnConfigQuery columnCommentNot(String columnCommentNot);
            public TcgColumnConfigQuery columnCommentIn(String columnCommentIn);
            public TcgColumnConfigQuery columnCommentNotIn(String columnCommentNotIn);
            public TcgColumnConfigQuery columnCommentLike(String columnCommentLike);
            public TcgColumnConfigQuery columnCommentNotLike(String columnCommentNotLike);
            public TcgColumnConfigQuery columnCommentIsNull();
            public TcgColumnConfigQuery columnCommentIsNotNull();












            public TcgColumnConfigQuery columnOtherComment(String columnOtherComment);
            public TcgColumnConfigQuery columnOtherCommentNot(String columnOtherCommentNot);
            public TcgColumnConfigQuery columnOtherCommentIn(String columnOtherCommentIn);
            public TcgColumnConfigQuery columnOtherCommentNotIn(String columnOtherCommentNotIn);
            public TcgColumnConfigQuery columnOtherCommentLike(String columnOtherCommentLike);
            public TcgColumnConfigQuery columnOtherCommentNotLike(String columnOtherCommentNotLike);
            public TcgColumnConfigQuery columnOtherCommentIsNull();
            public TcgColumnConfigQuery columnOtherCommentIsNotNull();












            public TcgColumnConfigQuery javaSimpleClass(String javaSimpleClass);
            public TcgColumnConfigQuery javaSimpleClassNot(String javaSimpleClassNot);
            public TcgColumnConfigQuery javaSimpleClassIn(String javaSimpleClassIn);
            public TcgColumnConfigQuery javaSimpleClassNotIn(String javaSimpleClassNotIn);
            public TcgColumnConfigQuery javaSimpleClassLike(String javaSimpleClassLike);
            public TcgColumnConfigQuery javaSimpleClassNotLike(String javaSimpleClassNotLike);
            public TcgColumnConfigQuery javaSimpleClassIsNull();
            public TcgColumnConfigQuery javaSimpleClassIsNotNull();












            public TcgColumnConfigQuery javaFullClass(String javaFullClass);
            public TcgColumnConfigQuery javaFullClassNot(String javaFullClassNot);
            public TcgColumnConfigQuery javaFullClassIn(String javaFullClassIn);
            public TcgColumnConfigQuery javaFullClassNotIn(String javaFullClassNotIn);
            public TcgColumnConfigQuery javaFullClassLike(String javaFullClassLike);
            public TcgColumnConfigQuery javaFullClassNotLike(String javaFullClassNotLike);
            public TcgColumnConfigQuery javaFullClassIsNull();
            public TcgColumnConfigQuery javaFullClassIsNotNull();












            public TcgColumnConfigQuery javaName(String javaName);
            public TcgColumnConfigQuery javaNameNot(String javaNameNot);
            public TcgColumnConfigQuery javaNameIn(String javaNameIn);
            public TcgColumnConfigQuery javaNameNotIn(String javaNameNotIn);
            public TcgColumnConfigQuery javaNameLike(String javaNameLike);
            public TcgColumnConfigQuery javaNameNotLike(String javaNameNotLike);
            public TcgColumnConfigQuery javaNameIsNull();
            public TcgColumnConfigQuery javaNameIsNotNull();












            public TcgColumnConfigQuery groupCode(String groupCode);
            public TcgColumnConfigQuery groupCodeNot(String groupCodeNot);
            public TcgColumnConfigQuery groupCodeIn(String groupCodeIn);
            public TcgColumnConfigQuery groupCodeNotIn(String groupCodeNotIn);
            public TcgColumnConfigQuery groupCodeLike(String groupCodeLike);
            public TcgColumnConfigQuery groupCodeNotLike(String groupCodeNotLike);
            public TcgColumnConfigQuery groupCodeIsNull();
            public TcgColumnConfigQuery groupCodeIsNotNull();












        public TcgColumnConfigQuery createTime(Timestamp createTime);
        public TcgColumnConfigQuery createTimeNot(Timestamp createTimeNot);
        public TcgColumnConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgColumnConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgColumnConfigQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgColumnConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgColumnConfigQuery createUserId(PK createUserId);
            public TcgColumnConfigQuery createUserIdNot(PK createUserIdNot);
            public TcgColumnConfigQuery createUserIdIn(PK createUserIdIn);
            public TcgColumnConfigQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgColumnConfigQuery createUserIdIsNull();
            public TcgColumnConfigQuery createUserIdIsNotNull();












        public TcgColumnConfigQuery updateTime(Timestamp updateTime);
        public TcgColumnConfigQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgColumnConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgColumnConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgColumnConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgColumnConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgColumnConfigQuery updateUserId(PK updateUserId);
            public TcgColumnConfigQuery updateUserIdNot(PK updateUserIdNot);
            public TcgColumnConfigQuery updateUserIdIn(PK updateUserIdIn);
            public TcgColumnConfigQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgColumnConfigQuery updateUserIdIsNull();
            public TcgColumnConfigQuery updateUserIdIsNotNull();












        public TcgColumnConfigQuery versionNo(Integer versionNo);
        public TcgColumnConfigQuery versionNoNot(Integer versionNoNot);
        public TcgColumnConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgColumnConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgColumnConfigQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgColumnConfigQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}