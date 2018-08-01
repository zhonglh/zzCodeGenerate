package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgQueryConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 查询条件设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:16
 */
public abstract class TcgQueryConfigAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgQueryConfigEntity,PK> {






            protected PK id;
            protected PK id_NE;












            protected PK tableId;
            protected PK tableId_NE;












            protected PK columnId;
            protected PK columnId_NE;












            protected String queryTitle;
            protected String queryTitle_NE;
            protected String queryTitle_LIKE;
            protected String queryTitle_NOTLIKE;












            protected String queryPlaceholder;
            protected String queryPlaceholder_NE;
            protected String queryPlaceholder_LIKE;
            protected String queryPlaceholder_NOTLIKE;












            protected String queryRelation;
            protected String queryRelation_NE;
            protected String queryRelation_LIKE;
            protected String queryRelation_NOTLIKE;













        protected Integer querySort;
        protected Integer querySort_NE;
        protected Integer querySort_GT;
        protected Integer querySort_GE;
        protected Integer querySort_LT;
        protected Integer querySort_LE;










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