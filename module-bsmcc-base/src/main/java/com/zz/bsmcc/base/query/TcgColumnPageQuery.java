package com.zz.bsmcc.base.query;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.TcgColumnPageEntity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * 列界面设置查询接口
 *
 * @author Administrator
 * @date 2018-8-5 15:15:58
 */
public interface TcgColumnPageQuery<PK extends Serializable> extends Query<TcgColumnPageEntity,PK> {






            public TcgColumnPageQuery id(PK id);
            public TcgColumnPageQuery idNot(PK idNot);
            public TcgColumnPageQuery idIn(PK idIn);
            public TcgColumnPageQuery idNotIn(PK idNotIn);
            public TcgColumnPageQuery idIsNull();
            public TcgColumnPageQuery idIsNotNull();












            public TcgColumnPageQuery tableId(PK tableId);
            public TcgColumnPageQuery tableIdNot(PK tableIdNot);
            public TcgColumnPageQuery tableIdIn(PK tableIdIn);
            public TcgColumnPageQuery tableIdNotIn(PK tableIdNotIn);
            public TcgColumnPageQuery tableIdIsNull();
            public TcgColumnPageQuery tableIdIsNotNull();












            public TcgColumnPageQuery realColumn(String realColumn);
            public TcgColumnPageQuery realColumnNot(String realColumnNot);
            public TcgColumnPageQuery realColumnIn(String realColumnIn);
            public TcgColumnPageQuery realColumnNotIn(String realColumnNotIn);
            public TcgColumnPageQuery realColumnIsNull();
            public TcgColumnPageQuery realColumnIsNotNull();













            public TcgColumnPageQuery editable(String editable);
            public TcgColumnPageQuery editableNot(String editableNot);
            public TcgColumnPageQuery editableIn(String editableIn);
            public TcgColumnPageQuery editableNotIn(String editableNotIn);
            public TcgColumnPageQuery editableIsNull();
            public TcgColumnPageQuery editableIsNotNull();













            public TcgColumnPageQuery hiddenable(String hiddenable);
            public TcgColumnPageQuery hiddenableNot(String hiddenableNot);
            public TcgColumnPageQuery hiddenableIn(String hiddenableIn);
            public TcgColumnPageQuery hiddenableNotIn(String hiddenableNotIn);
            public TcgColumnPageQuery hiddenableIsNull();
            public TcgColumnPageQuery hiddenableIsNotNull();













            public TcgColumnPageQuery existPage(String existPage);
            public TcgColumnPageQuery existPageNot(String existPageNot);
            public TcgColumnPageQuery existPageIn(String existPageIn);
            public TcgColumnPageQuery existPageNotIn(String existPageNotIn);
            public TcgColumnPageQuery existPageIsNull();
            public TcgColumnPageQuery existPageIsNotNull();













            public TcgColumnPageQuery element(String element);
            public TcgColumnPageQuery elementNot(String elementNot);
            public TcgColumnPageQuery elementIn(String elementIn);
            public TcgColumnPageQuery elementNotIn(String elementNotIn);
            public TcgColumnPageQuery elementLike(String elementLike);
            public TcgColumnPageQuery elementNotLike(String elementNotLike);
            public TcgColumnPageQuery elementIsNull();
            public TcgColumnPageQuery elementIsNotNull();












        public TcgColumnPageQuery maxlength(Integer maxlength);
        public TcgColumnPageQuery maxlengthNot(Integer maxlengthNot);
        public TcgColumnPageQuery maxlengthGreaterThan(Integer maxlengthGreaterThan);
        public TcgColumnPageQuery maxlengthGreaterEqual(Integer maxlengthGreaterEqual);
        public TcgColumnPageQuery maxlengthLessThan(Integer maxlengthLessThan);
        public TcgColumnPageQuery maxlengthLessEqual(Integer maxlengthLessEqual);










        public TcgColumnPageQuery minlength(Integer minlength);
        public TcgColumnPageQuery minlengthNot(Integer minlengthNot);
        public TcgColumnPageQuery minlengthGreaterThan(Integer minlengthGreaterThan);
        public TcgColumnPageQuery minlengthGreaterEqual(Integer minlengthGreaterEqual);
        public TcgColumnPageQuery minlengthLessThan(Integer minlengthLessThan);
        public TcgColumnPageQuery minlengthLessEqual(Integer minlengthLessEqual);










        public TcgColumnPageQuery max(BigDecimal max);
        public TcgColumnPageQuery maxNot(BigDecimal maxNot);
        public TcgColumnPageQuery maxGreaterThan(BigDecimal maxGreaterThan);
        public TcgColumnPageQuery maxGreaterEqual(BigDecimal maxGreaterEqual);
        public TcgColumnPageQuery maxLessThan(BigDecimal maxLessThan);
        public TcgColumnPageQuery maxLessEqual(BigDecimal maxLessEqual);










        public TcgColumnPageQuery min(BigDecimal min);
        public TcgColumnPageQuery minNot(BigDecimal minNot);
        public TcgColumnPageQuery minGreaterThan(BigDecimal minGreaterThan);
        public TcgColumnPageQuery minGreaterEqual(BigDecimal minGreaterEqual);
        public TcgColumnPageQuery minLessThan(BigDecimal minLessThan);
        public TcgColumnPageQuery minLessEqual(BigDecimal minLessEqual);










            public TcgColumnPageQuery required(String required);
            public TcgColumnPageQuery requiredNot(String requiredNot);
            public TcgColumnPageQuery requiredIn(String requiredIn);
            public TcgColumnPageQuery requiredNotIn(String requiredNotIn);
            public TcgColumnPageQuery requiredIsNull();
            public TcgColumnPageQuery requiredIsNotNull();













            public TcgColumnPageQuery listShowable(String listShowable);
            public TcgColumnPageQuery listShowableNot(String listShowableNot);
            public TcgColumnPageQuery listShowableIn(String listShowableIn);
            public TcgColumnPageQuery listShowableNotIn(String listShowableNotIn);
            public TcgColumnPageQuery listShowableIsNull();
            public TcgColumnPageQuery listShowableIsNotNull();













        public TcgColumnPageQuery createTime(Timestamp createTime);
        public TcgColumnPageQuery createTimeNot(Timestamp createTimeNot);
        public TcgColumnPageQuery createTimeGreaterThan(Timestamp createTimeGreaterThan);
        public TcgColumnPageQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual);
        public TcgColumnPageQuery createTimeLessThan(Timestamp createTimeLessThan);
        public TcgColumnPageQuery createTimeLessEqual(Timestamp createTimeLessEqual);










            public TcgColumnPageQuery createUserId(PK createUserId);
            public TcgColumnPageQuery createUserIdNot(PK createUserIdNot);
            public TcgColumnPageQuery createUserIdIn(PK createUserIdIn);
            public TcgColumnPageQuery createUserIdNotIn(PK createUserIdNotIn);
            public TcgColumnPageQuery createUserIdIsNull();
            public TcgColumnPageQuery createUserIdIsNotNull();












        public TcgColumnPageQuery updateTime(Timestamp updateTime);
        public TcgColumnPageQuery updateTimeNot(Timestamp updateTimeNot);
        public TcgColumnPageQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan);
        public TcgColumnPageQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual);
        public TcgColumnPageQuery updateTimeLessThan(Timestamp updateTimeLessThan);
        public TcgColumnPageQuery updateTimeLessEqual(Timestamp updateTimeLessEqual);










            public TcgColumnPageQuery updateUserId(PK updateUserId);
            public TcgColumnPageQuery updateUserIdNot(PK updateUserIdNot);
            public TcgColumnPageQuery updateUserIdIn(PK updateUserIdIn);
            public TcgColumnPageQuery updateUserIdNotIn(PK updateUserIdNotIn);
            public TcgColumnPageQuery updateUserIdIsNull();
            public TcgColumnPageQuery updateUserIdIsNotNull();












        public TcgColumnPageQuery versionNo(Integer versionNo);
        public TcgColumnPageQuery versionNoNot(Integer versionNoNot);
        public TcgColumnPageQuery versionNoGreaterThan(Integer versionNoGreaterThan);
        public TcgColumnPageQuery versionNoGreaterEqual(Integer versionNoGreaterEqual);
        public TcgColumnPageQuery versionNoLessThan(Integer versionNoLessThan);
        public TcgColumnPageQuery versionNoLessEqual(Integer versionNoLessEqual);






	
}