package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgDbConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 连接池设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 14:46:23
 */
public abstract class TcgDbConfigAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgDbConfigEntity,PK> {






            protected PK id;
            protected PK id_NE;












            protected String dbType;
            protected String dbType_NE;
            protected String dbType_LIKE;
            protected String dbType_NOTLIKE;












            protected String dbUrl;
            protected String dbUrl_NE;
            protected String dbUrl_LIKE;
            protected String dbUrl_NOTLIKE;












            protected String dbUsername;
            protected String dbUsername_NE;
            protected String dbUsername_LIKE;
            protected String dbUsername_NOTLIKE;












            protected String dbPassword;
            protected String dbPassword_NE;
            protected String dbPassword_LIKE;
            protected String dbPassword_NOTLIKE;












            protected String title;
            protected String title_NE;
            protected String title_LIKE;
            protected String title_NOTLIKE;












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