package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgColumnExEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 列扩展 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 12:32:14
 */
public abstract class TcgColumnExAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgColumnExEntity,PK> {
	private static final long serialVersionUID = 1L;





            protected PK id;
            protected PK id_NE;












            protected PK columnId;
            protected PK columnId_NE;












            protected String exKey;
            protected String exKey_NE;
            protected String exKey_LIKE;
            protected String exKey_NOTLIKE;












            protected String exVal;
            protected String exVal_NE;
            protected String exVal_LIKE;
            protected String exVal_NOTLIKE;












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