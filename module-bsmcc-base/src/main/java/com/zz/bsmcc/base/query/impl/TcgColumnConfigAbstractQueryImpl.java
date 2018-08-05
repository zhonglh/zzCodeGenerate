package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgColumnConfigEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 列设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:57
 */
public abstract class TcgColumnConfigAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgColumnConfigEntity,PK> {






            protected PK id;
            protected PK id_NE;












            protected PK tableId;
            protected PK tableId_NE;












            protected String columnName;
            protected String columnName_NE;
            protected String columnName_LIKE;
            protected String columnName_NOTLIKE;












            protected String columnType;
            protected String columnType_NE;
            protected String columnType_LIKE;
            protected String columnType_NOTLIKE;













        protected Integer columnLength;
        protected Integer columnLength_NE;
        protected Integer columnLength_GT;
        protected Integer columnLength_GE;
        protected Integer columnLength_LT;
        protected Integer columnLength_LE;











        protected Integer columnScale;
        protected Integer columnScale_NE;
        protected Integer columnScale_GT;
        protected Integer columnScale_GE;
        protected Integer columnScale_LT;
        protected Integer columnScale_LE;










            protected String columnDefault;
            protected String columnDefault_NE;
            protected String columnDefault_LIKE;
            protected String columnDefault_NOTLIKE;












            protected String columnIsnull;
            protected String columnIsnull_NE;














        protected Integer columnSort;
        protected Integer columnSort_NE;
        protected Integer columnSort_GT;
        protected Integer columnSort_GE;
        protected Integer columnSort_LT;
        protected Integer columnSort_LE;










            protected String columnIsfk;
            protected String columnIsfk_NE;













            protected String columnIskey;
            protected String columnIskey_NE;













            protected String columnIsdict;
            protected String columnIsdict_NE;













            protected String dictType;
            protected String dictType_NE;
            protected String dictType_LIKE;
            protected String dictType_NOTLIKE;












            protected String fkSchema;
            protected String fkSchema_NE;
            protected String fkSchema_LIKE;
            protected String fkSchema_NOTLIKE;












            protected String fkName;
            protected String fkName_NE;
            protected String fkName_LIKE;
            protected String fkName_NOTLIKE;












            protected String columnComment;
            protected String columnComment_NE;
            protected String columnComment_LIKE;
            protected String columnComment_NOTLIKE;












            protected String columnOtherComment;
            protected String columnOtherComment_NE;
            protected String columnOtherComment_LIKE;
            protected String columnOtherComment_NOTLIKE;












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












            protected String groupCode;
            protected String groupCode_NE;
            protected String groupCode_LIKE;
            protected String groupCode_NOTLIKE;












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