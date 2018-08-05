package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgTempletGroupOperationEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 模板组操作定义查询接口
 *
 * @author Administrator
 * @date 2018-8-5 15:16:00
 */
public interface TcgTempletGroupOperationQuery<PK extends Serializable> extends Query<TcgTempletGroupOperationEntity,PK> {






            public TcgTempletGroupOperationQuery id(PK id);
            public TcgTempletGroupOperationQuery idNot(PK idNot);
            public TcgTempletGroupOperationQuery idIn(PK idIn);
            public TcgTempletGroupOperationQuery idNotIn(PK idNotIn);
            public TcgTempletGroupOperationQuery idIsNull();
            public TcgTempletGroupOperationQuery idIsNotNull();












            public TcgTempletGroupOperationQuery groupId(PK groupId);
            public TcgTempletGroupOperationQuery groupIdNot(PK groupIdNot);
            public TcgTempletGroupOperationQuery groupIdIn(PK groupIdIn);
            public TcgTempletGroupOperationQuery groupIdNotIn(PK groupIdNotIn);
            public TcgTempletGroupOperationQuery groupIdIsNull();
            public TcgTempletGroupOperationQuery groupIdIsNotNull();












            public TcgTempletGroupOperationQuery operationId(PK operationId);
            public TcgTempletGroupOperationQuery operationIdNot(PK operationIdNot);
            public TcgTempletGroupOperationQuery operationIdIn(PK operationIdIn);
            public TcgTempletGroupOperationQuery operationIdNotIn(PK operationIdNotIn);
            public TcgTempletGroupOperationQuery operationIdIsNull();
            public TcgTempletGroupOperationQuery operationIdIsNotNull();












            public TcgTempletGroupOperationQuery icons(String icons);
            public TcgTempletGroupOperationQuery iconsNot(String iconsNot);
            public TcgTempletGroupOperationQuery iconsIn(String iconsIn);
            public TcgTempletGroupOperationQuery iconsNotIn(String iconsNotIn);
            public TcgTempletGroupOperationQuery iconsLike(String iconsLike);
            public TcgTempletGroupOperationQuery iconsNotLike(String iconsNotLike);
            public TcgTempletGroupOperationQuery iconsIsNull();
            public TcgTempletGroupOperationQuery iconsIsNotNull();












            public TcgTempletGroupOperationQuery styles(String styles);
            public TcgTempletGroupOperationQuery stylesNot(String stylesNot);
            public TcgTempletGroupOperationQuery stylesIn(String stylesIn);
            public TcgTempletGroupOperationQuery stylesNotIn(String stylesNotIn);
            public TcgTempletGroupOperationQuery stylesLike(String stylesLike);
            public TcgTempletGroupOperationQuery stylesNotLike(String stylesNotLike);
            public TcgTempletGroupOperationQuery stylesIsNull();
            public TcgTempletGroupOperationQuery stylesIsNotNull();












            public TcgTempletGroupOperationQuery classs(String classs);
            public TcgTempletGroupOperationQuery classsNot(String classsNot);
            public TcgTempletGroupOperationQuery classsIn(String classsIn);
            public TcgTempletGroupOperationQuery classsNotIn(String classsNotIn);
            public TcgTempletGroupOperationQuery classsLike(String classsLike);
            public TcgTempletGroupOperationQuery classsNotLike(String classsNotLike);
            public TcgTempletGroupOperationQuery classsIsNull();
            public TcgTempletGroupOperationQuery classsIsNotNull();












            public TcgTempletGroupOperationQuery position(String position);
            public TcgTempletGroupOperationQuery positionNot(String positionNot);
            public TcgTempletGroupOperationQuery positionIn(String positionIn);
            public TcgTempletGroupOperationQuery positionNotIn(String positionNotIn);
            public TcgTempletGroupOperationQuery positionLike(String positionLike);
            public TcgTempletGroupOperationQuery positionNotLike(String positionNotLike);
            public TcgTempletGroupOperationQuery positionIsNull();
            public TcgTempletGroupOperationQuery positionIsNotNull();












            public TcgTempletGroupOperationQuery other(String other);
            public TcgTempletGroupOperationQuery otherNot(String otherNot);
            public TcgTempletGroupOperationQuery otherIn(String otherIn);
            public TcgTempletGroupOperationQuery otherNotIn(String otherNotIn);
            public TcgTempletGroupOperationQuery otherLike(String otherLike);
            public TcgTempletGroupOperationQuery otherNotLike(String otherNotLike);
            public TcgTempletGroupOperationQuery otherIsNull();
            public TcgTempletGroupOperationQuery otherIsNotNull();








	
}