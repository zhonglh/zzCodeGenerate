package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgProjectEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 项目管理 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 14:46:25
 */
public abstract class TcgProjectAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgProjectEntity,PK> {






            protected PK id;
            protected PK id_NE;












            protected String projectName;
            protected String projectName_NE;
            protected String projectName_LIKE;
            protected String projectName_NOTLIKE;












            protected String projectRemark;
            protected String projectRemark_NE;
            protected String projectRemark_LIKE;
            protected String projectRemark_NOTLIKE;












            protected String projectPackage;
            protected String projectPackage_NE;
            protected String projectPackage_LIKE;
            protected String projectPackage_NOTLIKE;












            protected String projectLead;
            protected String projectLead_NE;
            protected String projectLead_LIKE;
            protected String projectLead_NOTLIKE;












            protected String projectAuthor;
            protected String projectAuthor_NE;
            protected String projectAuthor_LIKE;
            protected String projectAuthor_NOTLIKE;












            protected String projectNote;
            protected String projectNote_NE;
            protected String projectNote_LIKE;
            protected String projectNote_NOTLIKE;












            protected String projectI18n;
            protected String projectI18n_NE;













            protected String projectTenant;
            protected String projectTenant_NE;













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