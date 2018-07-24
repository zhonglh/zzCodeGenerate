package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgColumnEventEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 列事件 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 12:32:13
 */
public abstract class TcgColumnEventAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgColumnEventEntity,PK> {
	private static final long serialVersionUID = 1L;





            protected PK id;
            protected PK id_NE;












            protected PK columnId;
            protected PK columnId_NE;












            protected String eventName;
            protected String eventName_NE;
            protected String eventName_LIKE;
            protected String eventName_NOTLIKE;












            protected String funcBody;
            protected String funcBody_NE;
            protected String funcBody_LIKE;
            protected String funcBody_NOTLIKE;












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