package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgTableConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 表设置查询接口
 *
 * @author Administrator
 * @date 2018-8-4 21:05:51
 */
public interface TcgTableConfigQuery<PK extends Serializable> extends Query<TcgTableConfigEntity,PK> {






            public TcgTableConfigQuery id(PK id);
            public TcgTableConfigQuery idNot(PK idNot);
            public TcgTableConfigQuery idIn(PK idIn);
            public TcgTableConfigQuery idNotIn(PK idNotIn);
            public TcgTableConfigQuery idIsNull();
            public TcgTableConfigQuery idIsNotNull();












            public TcgTableConfigQuery dbId(PK dbId);
            public TcgTableConfigQuery dbIdNot(PK dbIdNot);
            public TcgTableConfigQuery dbIdIn(PK dbIdIn);
            public TcgTableConfigQuery dbIdNotIn(PK dbIdNotIn);
            public TcgTableConfigQuery dbIdIsNull();
            public TcgTableConfigQuery dbIdIsNotNull();












            public TcgTableConfigQuery projectId(PK projectId);
            public TcgTableConfigQuery projectIdNot(PK projectIdNot);
            public TcgTableConfigQuery projectIdIn(PK projectIdIn);
            public TcgTableConfigQuery projectIdNotIn(PK projectIdNotIn);
            public TcgTableConfigQuery projectIdIsNull();
            public TcgTableConfigQuery projectIdIsNotNull();












            public TcgTableConfigQuery moduleId(PK moduleId);
            public TcgTableConfigQuery moduleIdNot(PK moduleIdNot);
            public TcgTableConfigQuery moduleIdIn(PK moduleIdIn);
            public TcgTableConfigQuery moduleIdNotIn(PK moduleIdNotIn);
            public TcgTableConfigQuery moduleIdIsNull();
            public TcgTableConfigQuery moduleIdIsNotNull();












            public TcgTableConfigQuery schemaName(String schemaName);
            public TcgTableConfigQuery schemaNameNot(String schemaNameNot);
            public TcgTableConfigQuery schemaNameIn(String schemaNameIn);
            public TcgTableConfigQuery schemaNameNotIn(String schemaNameNotIn);
            public TcgTableConfigQuery schemaNameLike(String schemaNameLike);
            public TcgTableConfigQuery schemaNameNotLike(String schemaNameNotLike);
            public TcgTableConfigQuery schemaNameIsNull();
            public TcgTableConfigQuery schemaNameIsNotNull();












            public TcgTableConfigQuery tableName(String tableName);
            public TcgTableConfigQuery tableNameNot(String tableNameNot);
            public TcgTableConfigQuery tableNameIn(String tableNameIn);
            public TcgTableConfigQuery tableNameNotIn(String tableNameNotIn);
            public TcgTableConfigQuery tableNameLike(String tableNameLike);
            public TcgTableConfigQuery tableNameNotLike(String tableNameNotLike);
            public TcgTableConfigQuery tableNameIsNull();
            public TcgTableConfigQuery tableNameIsNotNull();












            public TcgTableConfigQuery tableType(String tableType);
            public TcgTableConfigQuery tableTypeNot(String tableTypeNot);
            public TcgTableConfigQuery tableTypeIn(String tableTypeIn);
            public TcgTableConfigQuery tableTypeNotIn(String tableTypeNotIn);
            public TcgTableConfigQuery tableTypeIsNull();
            public TcgTableConfigQuery tableTypeIsNotNull();













            public TcgTableConfigQuery tableRelation(String tableRelation);
            public TcgTableConfigQuery tableRelationNot(String tableRelationNot);
            public TcgTableConfigQuery tableRelationIn(String tableRelationIn);
            public TcgTableConfigQuery tableRelationNotIn(String tableRelationNotIn);
            public TcgTableConfigQuery tableRelationLike(String tableRelationLike);
            public TcgTableConfigQuery tableRelationNotLike(String tableRelationNotLike);
            public TcgTableConfigQuery tableRelationIsNull();
            public TcgTableConfigQuery tableRelationIsNotNull();












            public TcgTableConfigQuery isShowCheckbox(String isShowCheckbox);
            public TcgTableConfigQuery isShowCheckboxNot(String isShowCheckboxNot);
            public TcgTableConfigQuery isShowCheckboxIn(String isShowCheckboxIn);
            public TcgTableConfigQuery isShowCheckboxNotIn(String isShowCheckboxNotIn);
            public TcgTableConfigQuery isShowCheckboxIsNull();
            public TcgTableConfigQuery isShowCheckboxIsNotNull();













            public TcgTableConfigQuery isTable(String isTable);
            public TcgTableConfigQuery isTableNot(String isTableNot);
            public TcgTableConfigQuery isTableIn(String isTableIn);
            public TcgTableConfigQuery isTableNotIn(String isTableNotIn);
            public TcgTableConfigQuery isTableIsNull();
            public TcgTableConfigQuery isTableIsNotNull();













            public TcgTableConfigQuery mainTableId(PK mainTableId);
            public TcgTableConfigQuery mainTableIdNot(PK mainTableIdNot);
            public TcgTableConfigQuery mainTableIdIn(PK mainTableIdIn);
            public TcgTableConfigQuery mainTableIdNotIn(PK mainTableIdNotIn);
            public TcgTableConfigQuery mainTableIdIsNull();
            public TcgTableConfigQuery mainTableIdIsNotNull();












            public TcgTableConfigQuery resourceName(String resourceName);
            public TcgTableConfigQuery resourceNameNot(String resourceNameNot);
            public TcgTableConfigQuery resourceNameIn(String resourceNameIn);
            public TcgTableConfigQuery resourceNameNotIn(String resourceNameNotIn);
            public TcgTableConfigQuery resourceNameLike(String resourceNameLike);
            public TcgTableConfigQuery resourceNameNotLike(String resourceNameNotLike);
            public TcgTableConfigQuery resourceNameIsNull();
            public TcgTableConfigQuery resourceNameIsNotNull();












            public TcgTableConfigQuery isTree(String isTree);
            public TcgTableConfigQuery isTreeNot(String isTreeNot);
            public TcgTableConfigQuery isTreeIn(String isTreeIn);
            public TcgTableConfigQuery isTreeNotIn(String isTreeNotIn);
            public TcgTableConfigQuery isTreeIsNull();
            public TcgTableConfigQuery isTreeIsNotNull();













            public TcgTableConfigQuery parentFieldName(String parentFieldName);
            public TcgTableConfigQuery parentFieldNameNot(String parentFieldNameNot);
            public TcgTableConfigQuery parentFieldNameIn(String parentFieldNameIn);
            public TcgTableConfigQuery parentFieldNameNotIn(String parentFieldNameNotIn);
            public TcgTableConfigQuery parentFieldNameLike(String parentFieldNameLike);
            public TcgTableConfigQuery parentFieldNameNotLike(String parentFieldNameNotLike);
            public TcgTableConfigQuery parentFieldNameIsNull();
            public TcgTableConfigQuery parentFieldNameIsNotNull();












            public TcgTableConfigQuery tableComment(String tableComment);
            public TcgTableConfigQuery tableCommentNot(String tableCommentNot);
            public TcgTableConfigQuery tableCommentIn(String tableCommentIn);
            public TcgTableConfigQuery tableCommentNotIn(String tableCommentNotIn);
            public TcgTableConfigQuery tableCommentLike(String tableCommentLike);
            public TcgTableConfigQuery tableCommentNotLike(String tableCommentNotLike);
            public TcgTableConfigQuery tableCommentIsNull();
            public TcgTableConfigQuery tableCommentIsNotNull();












            public TcgTableConfigQuery tableOtherComment(String tableOtherComment);
            public TcgTableConfigQuery tableOtherCommentNot(String tableOtherCommentNot);
            public TcgTableConfigQuery tableOtherCommentIn(String tableOtherCommentIn);
            public TcgTableConfigQuery tableOtherCommentNotIn(String tableOtherCommentNotIn);
            public TcgTableConfigQuery tableOtherCommentLike(String tableOtherCommentLike);
            public TcgTableConfigQuery tableOtherCommentNotLike(String tableOtherCommentNotLike);
            public TcgTableConfigQuery tableOtherCommentIsNull();
            public TcgTableConfigQuery tableOtherCommentIsNotNull();












            public TcgTableConfigQuery queryMode(String queryMode);
            public TcgTableConfigQuery queryModeNot(String queryModeNot);
            public TcgTableConfigQuery queryModeIn(String queryModeIn);
            public TcgTableConfigQuery queryModeNotIn(String queryModeNotIn);
            public TcgTableConfigQuery queryModeLike(String queryModeLike);
            public TcgTableConfigQuery queryModeNotLike(String queryModeNotLike);
            public TcgTableConfigQuery queryModeIsNull();
            public TcgTableConfigQuery queryModeIsNotNull();












            public TcgTableConfigQuery isBuildController(String isBuildController);
            public TcgTableConfigQuery isBuildControllerNot(String isBuildControllerNot);
            public TcgTableConfigQuery isBuildControllerIn(String isBuildControllerIn);
            public TcgTableConfigQuery isBuildControllerNotIn(String isBuildControllerNotIn);
            public TcgTableConfigQuery isBuildControllerIsNull();
            public TcgTableConfigQuery isBuildControllerIsNotNull();













            public TcgTableConfigQuery isBuildMenu(String isBuildMenu);
            public TcgTableConfigQuery isBuildMenuNot(String isBuildMenuNot);
            public TcgTableConfigQuery isBuildMenuIn(String isBuildMenuIn);
            public TcgTableConfigQuery isBuildMenuNotIn(String isBuildMenuNotIn);
            public TcgTableConfigQuery isBuildMenuIsNull();
            public TcgTableConfigQuery isBuildMenuIsNotNull();













            public TcgTableConfigQuery javaName(String javaName);
            public TcgTableConfigQuery javaNameNot(String javaNameNot);
            public TcgTableConfigQuery javaNameIn(String javaNameIn);
            public TcgTableConfigQuery javaNameNotIn(String javaNameNotIn);
            public TcgTableConfigQuery javaNameLike(String javaNameLike);
            public TcgTableConfigQuery javaNameNotLike(String javaNameNotLike);
            public TcgTableConfigQuery javaNameIsNull();
            public TcgTableConfigQuery javaNameIsNotNull();












        public TcgTableConfigQuery createTime(Timestamp createTime);
        public TcgTableConfigQuery createTimeNot(Timestamp createTimeNot);
        public TcgTableConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgTableConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgTableConfigQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgTableConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgTableConfigQuery createUserId(PK createUserId);
            public TcgTableConfigQuery createUserIdNot(PK createUserIdNot);
            public TcgTableConfigQuery createUserIdIn(PK createUserIdIn);
            public TcgTableConfigQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgTableConfigQuery createUserIdIsNull();
            public TcgTableConfigQuery createUserIdIsNotNull();












        public TcgTableConfigQuery updateTime(Timestamp updateTime);
        public TcgTableConfigQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgTableConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgTableConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgTableConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgTableConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgTableConfigQuery updateUserId(PK updateUserId);
            public TcgTableConfigQuery updateUserIdNot(PK updateUserIdNot);
            public TcgTableConfigQuery updateUserIdIn(PK updateUserIdIn);
            public TcgTableConfigQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgTableConfigQuery updateUserIdIsNull();
            public TcgTableConfigQuery updateUserIdIsNotNull();












        public TcgTableConfigQuery versionNo(Integer versionNo);
        public TcgTableConfigQuery versionNoNot(Integer versionNoNot);
        public TcgTableConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgTableConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgTableConfigQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgTableConfigQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}