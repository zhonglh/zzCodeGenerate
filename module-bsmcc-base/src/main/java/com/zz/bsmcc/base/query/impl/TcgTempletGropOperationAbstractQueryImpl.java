package com.zz.bsmcc.base.query.impl;


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import com.zz.bsmcc.base.domain.TcgTempletGropOperationEntity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 模板组操作定义 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 12:32:16
 */
public abstract class TcgTempletGropOperationAbstractQueryImpl<PK extends Serializable> extends QueryImpl<TcgTempletGropOperationEntity,PK> {
	private static final long serialVersionUID = 1L;





            protected PK id;
            protected PK id_NE;












            protected PK groupId;
            protected PK groupId_NE;












            protected PK operationId;
            protected PK operationId_NE;












            protected String icons;
            protected String icons_NE;
            protected String icons_LIKE;
            protected String icons_NOTLIKE;












            protected String styles;
            protected String styles_NE;
            protected String styles_LIKE;
            protected String styles_NOTLIKE;












            protected String classs;
            protected String classs_NE;
            protected String classs_LIKE;
            protected String classs_NOTLIKE;












            protected String position;
            protected String position_NE;
            protected String position_LIKE;
            protected String position_NOTLIKE;








	
}