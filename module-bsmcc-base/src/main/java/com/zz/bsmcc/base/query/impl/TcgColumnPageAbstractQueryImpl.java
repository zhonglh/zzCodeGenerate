package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgColumnPageEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 列界面设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:14
 */
public abstract class TcgColumnPageAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgColumnPageEntity,PK> {






            protected PK id;
            protected PK id_NE;












            protected PK tableId;
            protected PK tableId_NE;












            protected String realColumn;
            protected String realColumn_NE;













            protected String editable;
            protected String editable_NE;













            protected String hiddenable;
            protected String hiddenable_NE;













            protected String existPage;
            protected String existPage_NE;













            protected String element;
            protected String element_NE;
            protected String element_LIKE;
            protected String element_NOTLIKE;













        protected Integer maxlength;
        protected Integer maxlength_NE;
        protected Integer maxlength_GT;
        protected Integer maxlength_GE;
        protected Integer maxlength_LT;
        protected Integer maxlength_LE;











        protected Integer minlength;
        protected Integer minlength_NE;
        protected Integer minlength_GT;
        protected Integer minlength_GE;
        protected Integer minlength_LT;
        protected Integer minlength_LE;











        protected BigDecimal max;
        protected BigDecimal max_NE;
        protected BigDecimal max_GT;
        protected BigDecimal max_GE;
        protected BigDecimal max_LT;
        protected BigDecimal max_LE;











        protected BigDecimal min;
        protected BigDecimal min_NE;
        protected BigDecimal min_GT;
        protected BigDecimal min_GE;
        protected BigDecimal min_LT;
        protected BigDecimal min_LE;










            protected String required;
            protected String required_NE;













            protected String listShowable;
            protected String listShowable_NE;













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