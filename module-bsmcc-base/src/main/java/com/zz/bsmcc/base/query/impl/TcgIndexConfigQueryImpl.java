package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgIndexConfigQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 索引设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-29 1:16:12
 */
public class TcgIndexConfigQueryImpl<PK extends Serializable> extends TcgIndexConfigAbstractQueryImpl<PK> implements TcgIndexConfigQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> tableId_IN;
            private List<PK> tableId_NOTIN;













            private List<String> indexName_IN;
            private List<String> indexName_NOTIN;













            private List<String> indexCloumns_IN;
            private List<String> indexCloumns_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgIndexConfigQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgIndexConfigQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgIndexConfigQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgIndexConfigQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgIndexConfigQuery tableId(PK tableId) {
                    if(!IdUtils.isEmpty(tableId)){
                        this.tableId = tableId;
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery tableIdNot(PK tableIdNot) {
                    if(!IdUtils.isEmpty(tableIdNot)){
                        this.tableId_NE = tableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgIndexConfigQuery tableIdIn(PK tableIdIn) {
                    if(!IdUtils.isEmpty(tableIdIn)){
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
                        this.tableId_NOTIN.add( tableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgIndexConfigQuery tableIdIsNull() {
                    this.isNulls.add("tableId");
                    return this;
                }



                @Override
                public TcgIndexConfigQuery tableIdIsNotNull() {
                    this.isNotNulls.add("tableId");
                    return this;
                }















                @Override
                public TcgIndexConfigQuery indexName(String indexName) {
                    if(!IdUtils.isEmpty(indexName)){
                        this.indexName = indexName;
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery indexNameNot(String indexNameNot) {
                    if(!IdUtils.isEmpty(indexNameNot)){
                        this.indexName_NE = indexNameNot;
                    }
                    return this;
                }




                @Override
                public TcgIndexConfigQuery indexNameLike(String indexNameLike) {
                    if(!IdUtils.isEmpty(indexNameLike)){
                        this.indexName_LIKE = indexNameLike;
                    }
                    return this;
                }



                @Override
                public TcgIndexConfigQuery indexNameNotLike(String indexNameNotLike) {
                    if(!IdUtils.isEmpty(indexNameNotLike)){
                        this.indexName_NOTLIKE = indexNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgIndexConfigQuery indexNameIn(String indexNameIn) {
                    if(!IdUtils.isEmpty(indexNameIn)){
                        this.indexName_IN.add( indexNameIn );
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery indexNameNotIn(String indexNameNotIn) {
                    if(!IdUtils.isEmpty(indexNameNotIn)){
                        this.indexName_NOTIN.add( indexNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgIndexConfigQuery indexNameIsNull() {
                    this.isNulls.add("indexName");
                    return this;
                }



                @Override
                public TcgIndexConfigQuery indexNameIsNotNull() {
                    this.isNotNulls.add("indexName");
                    return this;
                }













                @Override
                public TcgIndexConfigQuery indexCloumns(String indexCloumns) {
                    if(!IdUtils.isEmpty(indexCloumns)){
                        this.indexCloumns = indexCloumns;
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery indexCloumnsNot(String indexCloumnsNot) {
                    if(!IdUtils.isEmpty(indexCloumnsNot)){
                        this.indexCloumns_NE = indexCloumnsNot;
                    }
                    return this;
                }




                @Override
                public TcgIndexConfigQuery indexCloumnsLike(String indexCloumnsLike) {
                    if(!IdUtils.isEmpty(indexCloumnsLike)){
                        this.indexCloumns_LIKE = indexCloumnsLike;
                    }
                    return this;
                }



                @Override
                public TcgIndexConfigQuery indexCloumnsNotLike(String indexCloumnsNotLike) {
                    if(!IdUtils.isEmpty(indexCloumnsNotLike)){
                        this.indexCloumns_NOTLIKE = indexCloumnsNotLike;
                    }
                    return this;
                }

                @Override
                public TcgIndexConfigQuery indexCloumnsIn(String indexCloumnsIn) {
                    if(!IdUtils.isEmpty(indexCloumnsIn)){
                        this.indexCloumns_IN.add( indexCloumnsIn );
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery indexCloumnsNotIn(String indexCloumnsNotIn) {
                    if(!IdUtils.isEmpty(indexCloumnsNotIn)){
                        this.indexCloumns_NOTIN.add( indexCloumnsNotIn );
                    }
                    return this;
                }



                @Override
                public TcgIndexConfigQuery indexCloumnsIsNull() {
                    this.isNulls.add("indexCloumns");
                    return this;
                }



                @Override
                public TcgIndexConfigQuery indexCloumnsIsNotNull() {
                    this.isNotNulls.add("indexCloumns");
                    return this;
                }













            @Override
            public TcgIndexConfigQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgIndexConfigQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgIndexConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgIndexConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgIndexConfigQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgIndexConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgIndexConfigQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgIndexConfigQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgIndexConfigQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgIndexConfigQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgIndexConfigQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgIndexConfigQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgIndexConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgIndexConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgIndexConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgIndexConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgIndexConfigQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgIndexConfigQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgIndexConfigQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgIndexConfigQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgIndexConfigQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgIndexConfigQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgIndexConfigQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgIndexConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgIndexConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgIndexConfigQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgIndexConfigQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}