package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgColumnPageQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 列界面设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-5 15:15:58
 */
public class TcgColumnPageQueryImpl<PK extends Serializable> extends TcgColumnPageAbstractQueryImpl<PK> implements TcgColumnPageQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> tableId_IN;
            private List<PK> tableId_NOTIN;













            private List<String> realColumn_IN;
            private List<String> realColumn_NOTIN;














            private List<String> editable_IN;
            private List<String> editable_NOTIN;














            private List<String> hiddenable_IN;
            private List<String> hiddenable_NOTIN;














            private List<String> existPage_IN;
            private List<String> existPage_NOTIN;














            private List<String> element_IN;
            private List<String> element_NOTIN;





















































            private List<String> required_IN;
            private List<String> required_NOTIN;














            private List<String> listShowable_IN;
            private List<String> listShowable_NOTIN;
























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgColumnPageQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnPageQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgColumnPageQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgColumnPageQuery tableId(PK tableId) {
                    if(!IdUtils.isEmpty(tableId)){
                        this.tableId = tableId;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery tableIdNot(PK tableIdNot) {
                    if(!IdUtils.isEmpty(tableIdNot)){
                        this.tableId_NE = tableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery tableIdIn(PK tableIdIn) {
                    if(!IdUtils.isEmpty(tableIdIn)){
                        if(this.tableId_IN == null){
                            this.tableId_IN = new ArrayList<PK>();
                        }
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
                        if(this.tableId_NOTIN == null){
                            this.tableId_NOTIN = new ArrayList<PK>();
                        }
                        this.tableId_NOTIN.add( tableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnPageQuery tableIdIsNull() {
                    this.isNulls.add("tableId");
                    return this;
                }



                @Override
                public TcgColumnPageQuery tableIdIsNotNull() {
                    this.isNotNulls.add("tableId");
                    return this;
                }















                @Override
                public TcgColumnPageQuery realColumn(String realColumn) {
                    if(!IdUtils.isEmpty(realColumn)){
                        this.realColumn = realColumn;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery realColumnNot(String realColumnNot) {
                    if(!IdUtils.isEmpty(realColumnNot)){
                        this.realColumn_NE = realColumnNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery realColumnIn(String realColumnIn) {
                    if(!IdUtils.isEmpty(realColumnIn)){
                        if(this.realColumn_IN == null){
                            this.realColumn_IN = new ArrayList<String>();
                        }
                        this.realColumn_IN.add( realColumnIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnPageQuery realColumnNotIn(String realColumnNotIn) {
                    if(!IdUtils.isEmpty(realColumnNotIn)){
                        if(this.realColumn_NOTIN == null){
                            this.realColumn_NOTIN = new ArrayList<String>();
                        }
                        this.realColumn_NOTIN.add( realColumnNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnPageQuery realColumnIsNull() {
                    this.isNulls.add("realColumn");
                    return this;
                }



                @Override
                public TcgColumnPageQuery realColumnIsNotNull() {
                    this.isNotNulls.add("realColumn");
                    return this;
                }














                @Override
                public TcgColumnPageQuery editable(String editable) {
                    if(!IdUtils.isEmpty(editable)){
                        this.editable = editable;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery editableNot(String editableNot) {
                    if(!IdUtils.isEmpty(editableNot)){
                        this.editable_NE = editableNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery editableIn(String editableIn) {
                    if(!IdUtils.isEmpty(editableIn)){
                        if(this.editable_IN == null){
                            this.editable_IN = new ArrayList<String>();
                        }
                        this.editable_IN.add( editableIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnPageQuery editableNotIn(String editableNotIn) {
                    if(!IdUtils.isEmpty(editableNotIn)){
                        if(this.editable_NOTIN == null){
                            this.editable_NOTIN = new ArrayList<String>();
                        }
                        this.editable_NOTIN.add( editableNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnPageQuery editableIsNull() {
                    this.isNulls.add("editable");
                    return this;
                }



                @Override
                public TcgColumnPageQuery editableIsNotNull() {
                    this.isNotNulls.add("editable");
                    return this;
                }














                @Override
                public TcgColumnPageQuery hiddenable(String hiddenable) {
                    if(!IdUtils.isEmpty(hiddenable)){
                        this.hiddenable = hiddenable;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery hiddenableNot(String hiddenableNot) {
                    if(!IdUtils.isEmpty(hiddenableNot)){
                        this.hiddenable_NE = hiddenableNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery hiddenableIn(String hiddenableIn) {
                    if(!IdUtils.isEmpty(hiddenableIn)){
                        if(this.hiddenable_IN == null){
                            this.hiddenable_IN = new ArrayList<String>();
                        }
                        this.hiddenable_IN.add( hiddenableIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnPageQuery hiddenableNotIn(String hiddenableNotIn) {
                    if(!IdUtils.isEmpty(hiddenableNotIn)){
                        if(this.hiddenable_NOTIN == null){
                            this.hiddenable_NOTIN = new ArrayList<String>();
                        }
                        this.hiddenable_NOTIN.add( hiddenableNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnPageQuery hiddenableIsNull() {
                    this.isNulls.add("hiddenable");
                    return this;
                }



                @Override
                public TcgColumnPageQuery hiddenableIsNotNull() {
                    this.isNotNulls.add("hiddenable");
                    return this;
                }














                @Override
                public TcgColumnPageQuery existPage(String existPage) {
                    if(!IdUtils.isEmpty(existPage)){
                        this.existPage = existPage;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery existPageNot(String existPageNot) {
                    if(!IdUtils.isEmpty(existPageNot)){
                        this.existPage_NE = existPageNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery existPageIn(String existPageIn) {
                    if(!IdUtils.isEmpty(existPageIn)){
                        if(this.existPage_IN == null){
                            this.existPage_IN = new ArrayList<String>();
                        }
                        this.existPage_IN.add( existPageIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnPageQuery existPageNotIn(String existPageNotIn) {
                    if(!IdUtils.isEmpty(existPageNotIn)){
                        if(this.existPage_NOTIN == null){
                            this.existPage_NOTIN = new ArrayList<String>();
                        }
                        this.existPage_NOTIN.add( existPageNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnPageQuery existPageIsNull() {
                    this.isNulls.add("existPage");
                    return this;
                }



                @Override
                public TcgColumnPageQuery existPageIsNotNull() {
                    this.isNotNulls.add("existPage");
                    return this;
                }














                @Override
                public TcgColumnPageQuery element(String element) {
                    if(!IdUtils.isEmpty(element)){
                        this.element = element;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery elementNot(String elementNot) {
                    if(!IdUtils.isEmpty(elementNot)){
                        this.element_NE = elementNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnPageQuery elementLike(String elementLike) {
                    if(!IdUtils.isEmpty(elementLike)){
                        this.element_LIKE = elementLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnPageQuery elementNotLike(String elementNotLike) {
                    if(!IdUtils.isEmpty(elementNotLike)){
                        this.element_NOTLIKE = elementNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery elementIn(String elementIn) {
                    if(!IdUtils.isEmpty(elementIn)){
                        if(this.element_IN == null){
                            this.element_IN = new ArrayList<String>();
                        }
                        this.element_IN.add( elementIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery elementNotIn(String elementNotIn) {
                    if(!IdUtils.isEmpty(elementNotIn)){
                        if(this.element_NOTIN == null){
                            this.element_NOTIN = new ArrayList<String>();
                        }
                        this.element_NOTIN.add( elementNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnPageQuery elementIsNull() {
                    this.isNulls.add("element");
                    return this;
                }



                @Override
                public TcgColumnPageQuery elementIsNotNull() {
                    this.isNotNulls.add("element");
                    return this;
                }













            @Override
            public TcgColumnPageQuery maxlength(Integer maxlength) {
                if(!IdUtils.isEmpty(maxlength)){
                    this.maxlength = maxlength;
                }
                return this;
            }



            @Override
            public TcgColumnPageQuery maxlengthNot(Integer maxlengthNot) {
                if(!IdUtils.isEmpty(maxlengthNot)){
                    this.maxlength_NE = maxlengthNot;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery maxlengthGreaterThan(Integer maxlengthGreaterThan){
                if(maxlengthGreaterThan != null){
                    this.maxlength_GT = maxlengthGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery maxlengthGreaterEqual(Integer maxlengthGreaterEqual){
                if(maxlengthGreaterEqual != null){
                    this.maxlength_GE = maxlengthGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery maxlengthLessThan(Integer maxlengthLessThan){
                if(maxlengthLessThan != null){
                    this.maxlength_LT = maxlengthLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery maxlengthLessEqual(Integer maxlengthLessEqual){
                if(maxlengthLessEqual != null){
                    this.maxlength_LE = maxlengthLessEqual;
                }
                return this;
            }












            @Override
            public TcgColumnPageQuery minlength(Integer minlength) {
                if(!IdUtils.isEmpty(minlength)){
                    this.minlength = minlength;
                }
                return this;
            }



            @Override
            public TcgColumnPageQuery minlengthNot(Integer minlengthNot) {
                if(!IdUtils.isEmpty(minlengthNot)){
                    this.minlength_NE = minlengthNot;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery minlengthGreaterThan(Integer minlengthGreaterThan){
                if(minlengthGreaterThan != null){
                    this.minlength_GT = minlengthGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery minlengthGreaterEqual(Integer minlengthGreaterEqual){
                if(minlengthGreaterEqual != null){
                    this.minlength_GE = minlengthGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery minlengthLessThan(Integer minlengthLessThan){
                if(minlengthLessThan != null){
                    this.minlength_LT = minlengthLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery minlengthLessEqual(Integer minlengthLessEqual){
                if(minlengthLessEqual != null){
                    this.minlength_LE = minlengthLessEqual;
                }
                return this;
            }












            @Override
            public TcgColumnPageQuery max(BigDecimal max) {
                if(!IdUtils.isEmpty(max)){
                    this.max = max;
                }
                return this;
            }



            @Override
            public TcgColumnPageQuery maxNot(BigDecimal maxNot) {
                if(!IdUtils.isEmpty(maxNot)){
                    this.max_NE = maxNot;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery maxGreaterThan(BigDecimal maxGreaterThan){
                if(maxGreaterThan != null){
                    this.max_GT = maxGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery maxGreaterEqual(BigDecimal maxGreaterEqual){
                if(maxGreaterEqual != null){
                    this.max_GE = maxGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery maxLessThan(BigDecimal maxLessThan){
                if(maxLessThan != null){
                    this.max_LT = maxLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery maxLessEqual(BigDecimal maxLessEqual){
                if(maxLessEqual != null){
                    this.max_LE = maxLessEqual;
                }
                return this;
            }












            @Override
            public TcgColumnPageQuery min(BigDecimal min) {
                if(!IdUtils.isEmpty(min)){
                    this.min = min;
                }
                return this;
            }



            @Override
            public TcgColumnPageQuery minNot(BigDecimal minNot) {
                if(!IdUtils.isEmpty(minNot)){
                    this.min_NE = minNot;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery minGreaterThan(BigDecimal minGreaterThan){
                if(minGreaterThan != null){
                    this.min_GT = minGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery minGreaterEqual(BigDecimal minGreaterEqual){
                if(minGreaterEqual != null){
                    this.min_GE = minGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery minLessThan(BigDecimal minLessThan){
                if(minLessThan != null){
                    this.min_LT = minLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery minLessEqual(BigDecimal minLessEqual){
                if(minLessEqual != null){
                    this.min_LE = minLessEqual;
                }
                return this;
            }












                @Override
                public TcgColumnPageQuery required(String required) {
                    if(!IdUtils.isEmpty(required)){
                        this.required = required;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery requiredNot(String requiredNot) {
                    if(!IdUtils.isEmpty(requiredNot)){
                        this.required_NE = requiredNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery requiredIn(String requiredIn) {
                    if(!IdUtils.isEmpty(requiredIn)){
                        if(this.required_IN == null){
                            this.required_IN = new ArrayList<String>();
                        }
                        this.required_IN.add( requiredIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnPageQuery requiredNotIn(String requiredNotIn) {
                    if(!IdUtils.isEmpty(requiredNotIn)){
                        if(this.required_NOTIN == null){
                            this.required_NOTIN = new ArrayList<String>();
                        }
                        this.required_NOTIN.add( requiredNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnPageQuery requiredIsNull() {
                    this.isNulls.add("required");
                    return this;
                }



                @Override
                public TcgColumnPageQuery requiredIsNotNull() {
                    this.isNotNulls.add("required");
                    return this;
                }














                @Override
                public TcgColumnPageQuery listShowable(String listShowable) {
                    if(!IdUtils.isEmpty(listShowable)){
                        this.listShowable = listShowable;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery listShowableNot(String listShowableNot) {
                    if(!IdUtils.isEmpty(listShowableNot)){
                        this.listShowable_NE = listShowableNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery listShowableIn(String listShowableIn) {
                    if(!IdUtils.isEmpty(listShowableIn)){
                        if(this.listShowable_IN == null){
                            this.listShowable_IN = new ArrayList<String>();
                        }
                        this.listShowable_IN.add( listShowableIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnPageQuery listShowableNotIn(String listShowableNotIn) {
                    if(!IdUtils.isEmpty(listShowableNotIn)){
                        if(this.listShowable_NOTIN == null){
                            this.listShowable_NOTIN = new ArrayList<String>();
                        }
                        this.listShowable_NOTIN.add( listShowableNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnPageQuery listShowableIsNull() {
                    this.isNulls.add("listShowable");
                    return this;
                }



                @Override
                public TcgColumnPageQuery listShowableIsNotNull() {
                    this.isNotNulls.add("listShowable");
                    return this;
                }














            @Override
            public TcgColumnPageQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgColumnPageQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgColumnPageQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnPageQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgColumnPageQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgColumnPageQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgColumnPageQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgColumnPageQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnPageQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnPageQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnPageQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgColumnPageQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgColumnPageQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgColumnPageQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnPageQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnPageQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}