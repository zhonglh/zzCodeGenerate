package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgTempletGropOperationEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 模板组操作定义查询接口
 *
 * @author Administrator
 * @date 2018-7-30 17:18:09
 */
public interface TcgTempletGropOperationQuery<PK extends Serializable> extends Query<TcgTempletGropOperationEntity,PK> {






            public TcgTempletGropOperationQuery id(PK id);
            public TcgTempletGropOperationQuery idNot(PK idNot);
            public TcgTempletGropOperationQuery idIn(PK idIn);
            public TcgTempletGropOperationQuery idNotIn(PK idNotIn);
            public TcgTempletGropOperationQuery idIsNull();
            public TcgTempletGropOperationQuery idIsNotNull();












            public TcgTempletGropOperationQuery groupId(PK groupId);
            public TcgTempletGropOperationQuery groupIdNot(PK groupIdNot);
            public TcgTempletGropOperationQuery groupIdIn(PK groupIdIn);
            public TcgTempletGropOperationQuery groupIdNotIn(PK groupIdNotIn);
            public TcgTempletGropOperationQuery groupIdIsNull();
            public TcgTempletGropOperationQuery groupIdIsNotNull();












            public TcgTempletGropOperationQuery operationId(PK operationId);
            public TcgTempletGropOperationQuery operationIdNot(PK operationIdNot);
            public TcgTempletGropOperationQuery operationIdIn(PK operationIdIn);
            public TcgTempletGropOperationQuery operationIdNotIn(PK operationIdNotIn);
            public TcgTempletGropOperationQuery operationIdIsNull();
            public TcgTempletGropOperationQuery operationIdIsNotNull();












            public TcgTempletGropOperationQuery icons(String icons);
            public TcgTempletGropOperationQuery iconsNot(String iconsNot);
            public TcgTempletGropOperationQuery iconsIn(String iconsIn);
            public TcgTempletGropOperationQuery iconsNotIn(String iconsNotIn);
            public TcgTempletGropOperationQuery iconsLike(String iconsLike);
            public TcgTempletGropOperationQuery iconsNotLike(String iconsNotLike);
            public TcgTempletGropOperationQuery iconsIsNull();
            public TcgTempletGropOperationQuery iconsIsNotNull();












            public TcgTempletGropOperationQuery styles(String styles);
            public TcgTempletGropOperationQuery stylesNot(String stylesNot);
            public TcgTempletGropOperationQuery stylesIn(String stylesIn);
            public TcgTempletGropOperationQuery stylesNotIn(String stylesNotIn);
            public TcgTempletGropOperationQuery stylesLike(String stylesLike);
            public TcgTempletGropOperationQuery stylesNotLike(String stylesNotLike);
            public TcgTempletGropOperationQuery stylesIsNull();
            public TcgTempletGropOperationQuery stylesIsNotNull();












            public TcgTempletGropOperationQuery classs(String classs);
            public TcgTempletGropOperationQuery classsNot(String classsNot);
            public TcgTempletGropOperationQuery classsIn(String classsIn);
            public TcgTempletGropOperationQuery classsNotIn(String classsNotIn);
            public TcgTempletGropOperationQuery classsLike(String classsLike);
            public TcgTempletGropOperationQuery classsNotLike(String classsNotLike);
            public TcgTempletGropOperationQuery classsIsNull();
            public TcgTempletGropOperationQuery classsIsNotNull();












            public TcgTempletGropOperationQuery position(String position);
            public TcgTempletGropOperationQuery positionNot(String positionNot);
            public TcgTempletGropOperationQuery positionIn(String positionIn);
            public TcgTempletGropOperationQuery positionNotIn(String positionNotIn);
            public TcgTempletGropOperationQuery positionLike(String positionLike);
            public TcgTempletGropOperationQuery positionNotLike(String positionNotLike);
            public TcgTempletGropOperationQuery positionIsNull();
            public TcgTempletGropOperationQuery positionIsNotNull();








	
}