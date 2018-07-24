package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgTempletEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 模板 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 12:32:16
 */
public abstract class TcgTempletAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgTempletEntity,PK> {
	private static final long serialVersionUID = 1L;





            protected PK id;
            protected PK id_NE;












            protected PK groupId;
            protected PK groupId_NE;












            protected String fileType;
            protected String fileType_NE;
            protected String fileType_LIKE;
            protected String fileType_NOTLIKE;












            protected String templetTitle;
            protected String templetTitle_NE;
            protected String templetTitle_LIKE;
            protected String templetTitle_NOTLIKE;












            protected String templetDir;
            protected String templetDir_NE;
            protected String templetDir_LIKE;
            protected String templetDir_NOTLIKE;












            protected String templetContent;
            protected String templetContent_NE;
            protected String templetContent_LIKE;
            protected String templetContent_NOTLIKE;












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










            protected String deleteFlag;
            protected String deleteFlag_NE;









	
}