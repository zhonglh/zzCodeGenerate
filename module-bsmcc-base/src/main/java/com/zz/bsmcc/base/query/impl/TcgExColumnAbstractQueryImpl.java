package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgExColumnEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 扩展列设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:58
 */
public abstract class TcgExColumnAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgExColumnEntity,PK> {






            protected PK id;
            protected PK id_NE;












            protected PK tableId;
            protected PK tableId_NE;












            protected PK originalColumnId;
            protected PK originalColumnId_NE;












            protected String javaSimpleClass;
            protected String javaSimpleClass_NE;
            protected String javaSimpleClass_LIKE;
            protected String javaSimpleClass_NOTLIKE;












            protected String javaFullClass;
            protected String javaFullClass_NE;
            protected String javaFullClass_LIKE;
            protected String javaFullClass_NOTLIKE;












            protected String javaName;
            protected String javaName_NE;
            protected String javaName_LIKE;
            protected String javaName_NOTLIKE;













        protected Integer columnSort;
        protected Integer columnSort_NE;
        protected Integer columnSort_GT;
        protected Integer columnSort_GE;
        protected Integer columnSort_LT;
        protected Integer columnSort_LE;










            protected String columnTitle;
            protected String columnTitle_NE;
            protected String columnTitle_LIKE;
            protected String columnTitle_NOTLIKE;












            protected String fkColumnName;
            protected String fkColumnName_NE;
            protected String fkColumnName_LIKE;
            protected String fkColumnName_NOTLIKE;












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