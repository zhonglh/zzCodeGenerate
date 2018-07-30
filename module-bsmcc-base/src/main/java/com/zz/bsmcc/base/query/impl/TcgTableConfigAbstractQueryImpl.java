package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgTableConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-30 17:18:08
 */
public abstract class TcgTableConfigAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgTableConfigEntity,PK> {






            protected PK id;
            protected PK id_NE;












            protected PK dbId;
            protected PK dbId_NE;












            protected PK projectId;
            protected PK projectId_NE;












            protected PK moduleId;
            protected PK moduleId_NE;












            protected String schemaName;
            protected String schemaName_NE;
            protected String schemaName_LIKE;
            protected String schemaName_NOTLIKE;












            protected String tableName;
            protected String tableName_NE;
            protected String tableName_LIKE;
            protected String tableName_NOTLIKE;












            protected String tableType;
            protected String tableType_NE;













            protected String tableRelation;
            protected String tableRelation_NE;
            protected String tableRelation_LIKE;
            protected String tableRelation_NOTLIKE;












            protected String isShowCheckbox;
            protected String isShowCheckbox_NE;













            protected String isTable;
            protected String isTable_NE;













            protected PK mainTableId;
            protected PK mainTableId_NE;












            protected String resourceName;
            protected String resourceName_NE;
            protected String resourceName_LIKE;
            protected String resourceName_NOTLIKE;












            protected String isTree;
            protected String isTree_NE;













            protected String parentFieldName;
            protected String parentFieldName_NE;
            protected String parentFieldName_LIKE;
            protected String parentFieldName_NOTLIKE;












            protected String tableComment;
            protected String tableComment_NE;
            protected String tableComment_LIKE;
            protected String tableComment_NOTLIKE;












            protected String queryMode;
            protected String queryMode_NE;
            protected String queryMode_LIKE;
            protected String queryMode_NOTLIKE;












            protected String isBuildController;
            protected String isBuildController_NE;













            protected String isBuildMenu;
            protected String isBuildMenu_NE;













            protected String javaName;
            protected String javaName_NE;
            protected String javaName_LIKE;
            protected String javaName_NOTLIKE;












        protected Timestamp createTime;
        protected Timestamp createTime_NE;
        protected Timestamp createTime_GT;
        protected Timestamp createTime_GE;
        protected Timestamp createTime_LT;
        protected Timestamp createTime_LE;










            protected PK createUserId;
            protected PK createUserId_NE;












        protected Timestamp updateTime;
        protected Timestamp updateTime_NE;
        protected Timestamp updateTime_GT;
        protected Timestamp updateTime_GE;
        protected Timestamp updateTime_LT;
        protected Timestamp updateTime_LE;










            protected PK updateUserId;
            protected PK updateUserId_NE;













        protected Integer versionNo;
        protected Integer versionNo_NE;
        protected Integer versionNo_GT;
        protected Integer versionNo_GE;
        protected Integer versionNo_LT;
        protected Integer versionNo_LE;






	
}