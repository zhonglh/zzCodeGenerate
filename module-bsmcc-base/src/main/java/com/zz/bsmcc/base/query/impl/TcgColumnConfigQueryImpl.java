package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgColumnConfigQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 列设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:13
 */
public class TcgColumnConfigQueryImpl<PK extends Serializable> extends TcgColumnConfigAbstractQueryImpl<PK> implements TcgColumnConfigQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> tableId_IN;
            private List<PK> tableId_NOTIN;













            private List<String> columnName_IN;
            private List<String> columnName_NOTIN;













            private List<String> columnType_IN;
            private List<String> columnType_NOTIN;

































            private List<String> columnDefault_IN;
            private List<String> columnDefault_NOTIN;













            private List<String> columnIsnull_IN;
            private List<String> columnIsnull_NOTIN;
























            private List<String> columnIsfk_IN;
            private List<String> columnIsfk_NOTIN;














            private List<String> columnIskey_IN;
            private List<String> columnIskey_NOTIN;














            private List<String> columnIsdict_IN;
            private List<String> columnIsdict_NOTIN;














            private List<String> dictType_IN;
            private List<String> dictType_NOTIN;













            private List<String> columnComment_IN;
            private List<String> columnComment_NOTIN;













            private List<String> columnOtherComment_IN;
            private List<String> columnOtherComment_NOTIN;













            private List<String> javaSimpleClass_IN;
            private List<String> javaSimpleClass_NOTIN;













            private List<String> javaFullClass_IN;
            private List<String> javaFullClass_NOTIN;













            private List<String> javaName_IN;
            private List<String> javaName_NOTIN;













            private List<String> groupCode_IN;
            private List<String> groupCode_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgColumnConfigQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgColumnConfigQuery tableId(PK tableId) {
                    if(!IdUtils.isEmpty(tableId)){
                        this.tableId = tableId;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery tableIdNot(PK tableIdNot) {
                    if(!IdUtils.isEmpty(tableIdNot)){
                        this.tableId_NE = tableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery tableIdIn(PK tableIdIn) {
                    if(!IdUtils.isEmpty(tableIdIn)){
                        if(this.tableId_IN == null){
                            this.tableId_IN = new ArrayList<PK>();
                        }
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
                        if(this.tableId_NOTIN == null){
                            this.tableId_NOTIN = new ArrayList<PK>();
                        }
                        this.tableId_NOTIN.add( tableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery tableIdIsNull() {
                    this.isNulls.add("tableId");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery tableIdIsNotNull() {
                    this.isNotNulls.add("tableId");
                    return this;
                }















                @Override
                public TcgColumnConfigQuery columnName(String columnName) {
                    if(!IdUtils.isEmpty(columnName)){
                        this.columnName = columnName;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnNameNot(String columnNameNot) {
                    if(!IdUtils.isEmpty(columnNameNot)){
                        this.columnName_NE = columnNameNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery columnNameLike(String columnNameLike) {
                    if(!IdUtils.isEmpty(columnNameLike)){
                        this.columnName_LIKE = columnNameLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnNameNotLike(String columnNameNotLike) {
                    if(!IdUtils.isEmpty(columnNameNotLike)){
                        this.columnName_NOTLIKE = columnNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnNameIn(String columnNameIn) {
                    if(!IdUtils.isEmpty(columnNameIn)){
                        if(this.columnName_IN == null){
                            this.columnName_IN = new ArrayList<String>();
                        }
                        this.columnName_IN.add( columnNameIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnNameNotIn(String columnNameNotIn) {
                    if(!IdUtils.isEmpty(columnNameNotIn)){
                        if(this.columnName_NOTIN == null){
                            this.columnName_NOTIN = new ArrayList<String>();
                        }
                        this.columnName_NOTIN.add( columnNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnNameIsNull() {
                    this.isNulls.add("columnName");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnNameIsNotNull() {
                    this.isNotNulls.add("columnName");
                    return this;
                }













                @Override
                public TcgColumnConfigQuery columnType(String columnType) {
                    if(!IdUtils.isEmpty(columnType)){
                        this.columnType = columnType;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnTypeNot(String columnTypeNot) {
                    if(!IdUtils.isEmpty(columnTypeNot)){
                        this.columnType_NE = columnTypeNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery columnTypeLike(String columnTypeLike) {
                    if(!IdUtils.isEmpty(columnTypeLike)){
                        this.columnType_LIKE = columnTypeLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnTypeNotLike(String columnTypeNotLike) {
                    if(!IdUtils.isEmpty(columnTypeNotLike)){
                        this.columnType_NOTLIKE = columnTypeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnTypeIn(String columnTypeIn) {
                    if(!IdUtils.isEmpty(columnTypeIn)){
                        if(this.columnType_IN == null){
                            this.columnType_IN = new ArrayList<String>();
                        }
                        this.columnType_IN.add( columnTypeIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnTypeNotIn(String columnTypeNotIn) {
                    if(!IdUtils.isEmpty(columnTypeNotIn)){
                        if(this.columnType_NOTIN == null){
                            this.columnType_NOTIN = new ArrayList<String>();
                        }
                        this.columnType_NOTIN.add( columnTypeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnTypeIsNull() {
                    this.isNulls.add("columnType");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnTypeIsNotNull() {
                    this.isNotNulls.add("columnType");
                    return this;
                }













            @Override
            public TcgColumnConfigQuery columnLength(Integer columnLength) {
                if(!IdUtils.isEmpty(columnLength)){
                    this.columnLength = columnLength;
                }
                return this;
            }



            @Override
            public TcgColumnConfigQuery columnLengthNot(Integer columnLengthNot) {
                if(!IdUtils.isEmpty(columnLengthNot)){
                    this.columnLength_NE = columnLengthNot;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery columnLengthGreaterThan(Integer columnLengthGreaterThan){
                if(columnLengthGreaterThan != null){
                    this.columnLength_GT = columnLengthGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery columnLengthGreaterEqual(Integer columnLengthGreaterEqual){
                if(columnLengthGreaterEqual != null){
                    this.columnLength_GE = columnLengthGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery columnLengthLessThan(Integer columnLengthLessThan){
                if(columnLengthLessThan != null){
                    this.columnLength_LT = columnLengthLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery columnLengthLessEqual(Integer columnLengthLessEqual){
                if(columnLengthLessEqual != null){
                    this.columnLength_LE = columnLengthLessEqual;
                }
                return this;
            }












            @Override
            public TcgColumnConfigQuery columnScale(Integer columnScale) {
                if(!IdUtils.isEmpty(columnScale)){
                    this.columnScale = columnScale;
                }
                return this;
            }



            @Override
            public TcgColumnConfigQuery columnScaleNot(Integer columnScaleNot) {
                if(!IdUtils.isEmpty(columnScaleNot)){
                    this.columnScale_NE = columnScaleNot;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery columnScaleGreaterThan(Integer columnScaleGreaterThan){
                if(columnScaleGreaterThan != null){
                    this.columnScale_GT = columnScaleGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery columnScaleGreaterEqual(Integer columnScaleGreaterEqual){
                if(columnScaleGreaterEqual != null){
                    this.columnScale_GE = columnScaleGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery columnScaleLessThan(Integer columnScaleLessThan){
                if(columnScaleLessThan != null){
                    this.columnScale_LT = columnScaleLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery columnScaleLessEqual(Integer columnScaleLessEqual){
                if(columnScaleLessEqual != null){
                    this.columnScale_LE = columnScaleLessEqual;
                }
                return this;
            }












                @Override
                public TcgColumnConfigQuery columnDefault(String columnDefault) {
                    if(!IdUtils.isEmpty(columnDefault)){
                        this.columnDefault = columnDefault;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnDefaultNot(String columnDefaultNot) {
                    if(!IdUtils.isEmpty(columnDefaultNot)){
                        this.columnDefault_NE = columnDefaultNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery columnDefaultLike(String columnDefaultLike) {
                    if(!IdUtils.isEmpty(columnDefaultLike)){
                        this.columnDefault_LIKE = columnDefaultLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnDefaultNotLike(String columnDefaultNotLike) {
                    if(!IdUtils.isEmpty(columnDefaultNotLike)){
                        this.columnDefault_NOTLIKE = columnDefaultNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnDefaultIn(String columnDefaultIn) {
                    if(!IdUtils.isEmpty(columnDefaultIn)){
                        if(this.columnDefault_IN == null){
                            this.columnDefault_IN = new ArrayList<String>();
                        }
                        this.columnDefault_IN.add( columnDefaultIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnDefaultNotIn(String columnDefaultNotIn) {
                    if(!IdUtils.isEmpty(columnDefaultNotIn)){
                        if(this.columnDefault_NOTIN == null){
                            this.columnDefault_NOTIN = new ArrayList<String>();
                        }
                        this.columnDefault_NOTIN.add( columnDefaultNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnDefaultIsNull() {
                    this.isNulls.add("columnDefault");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnDefaultIsNotNull() {
                    this.isNotNulls.add("columnDefault");
                    return this;
                }













                @Override
                public TcgColumnConfigQuery columnIsnull(String columnIsnull) {
                    if(!IdUtils.isEmpty(columnIsnull)){
                        this.columnIsnull = columnIsnull;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnIsnullNot(String columnIsnullNot) {
                    if(!IdUtils.isEmpty(columnIsnullNot)){
                        this.columnIsnull_NE = columnIsnullNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnIsnullIn(String columnIsnullIn) {
                    if(!IdUtils.isEmpty(columnIsnullIn)){
                        if(this.columnIsnull_IN == null){
                            this.columnIsnull_IN = new ArrayList<String>();
                        }
                        this.columnIsnull_IN.add( columnIsnullIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnConfigQuery columnIsnullNotIn(String columnIsnullNotIn) {
                    if(!IdUtils.isEmpty(columnIsnullNotIn)){
                        if(this.columnIsnull_NOTIN == null){
                            this.columnIsnull_NOTIN = new ArrayList<String>();
                        }
                        this.columnIsnull_NOTIN.add( columnIsnullNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnConfigQuery columnIsnullIsNull() {
                    this.isNulls.add("columnIsnull");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnIsnullIsNotNull() {
                    this.isNotNulls.add("columnIsnull");
                    return this;
                }














            @Override
            public TcgColumnConfigQuery columnSort(Integer columnSort) {
                if(!IdUtils.isEmpty(columnSort)){
                    this.columnSort = columnSort;
                }
                return this;
            }



            @Override
            public TcgColumnConfigQuery columnSortNot(Integer columnSortNot) {
                if(!IdUtils.isEmpty(columnSortNot)){
                    this.columnSort_NE = columnSortNot;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery columnSortGreaterThan(Integer columnSortGreaterThan){
                if(columnSortGreaterThan != null){
                    this.columnSort_GT = columnSortGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery columnSortGreaterEqual(Integer columnSortGreaterEqual){
                if(columnSortGreaterEqual != null){
                    this.columnSort_GE = columnSortGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery columnSortLessThan(Integer columnSortLessThan){
                if(columnSortLessThan != null){
                    this.columnSort_LT = columnSortLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery columnSortLessEqual(Integer columnSortLessEqual){
                if(columnSortLessEqual != null){
                    this.columnSort_LE = columnSortLessEqual;
                }
                return this;
            }












                @Override
                public TcgColumnConfigQuery columnIsfk(String columnIsfk) {
                    if(!IdUtils.isEmpty(columnIsfk)){
                        this.columnIsfk = columnIsfk;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnIsfkNot(String columnIsfkNot) {
                    if(!IdUtils.isEmpty(columnIsfkNot)){
                        this.columnIsfk_NE = columnIsfkNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnIsfkIn(String columnIsfkIn) {
                    if(!IdUtils.isEmpty(columnIsfkIn)){
                        if(this.columnIsfk_IN == null){
                            this.columnIsfk_IN = new ArrayList<String>();
                        }
                        this.columnIsfk_IN.add( columnIsfkIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnConfigQuery columnIsfkNotIn(String columnIsfkNotIn) {
                    if(!IdUtils.isEmpty(columnIsfkNotIn)){
                        if(this.columnIsfk_NOTIN == null){
                            this.columnIsfk_NOTIN = new ArrayList<String>();
                        }
                        this.columnIsfk_NOTIN.add( columnIsfkNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnConfigQuery columnIsfkIsNull() {
                    this.isNulls.add("columnIsfk");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnIsfkIsNotNull() {
                    this.isNotNulls.add("columnIsfk");
                    return this;
                }














                @Override
                public TcgColumnConfigQuery columnIskey(String columnIskey) {
                    if(!IdUtils.isEmpty(columnIskey)){
                        this.columnIskey = columnIskey;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnIskeyNot(String columnIskeyNot) {
                    if(!IdUtils.isEmpty(columnIskeyNot)){
                        this.columnIskey_NE = columnIskeyNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnIskeyIn(String columnIskeyIn) {
                    if(!IdUtils.isEmpty(columnIskeyIn)){
                        if(this.columnIskey_IN == null){
                            this.columnIskey_IN = new ArrayList<String>();
                        }
                        this.columnIskey_IN.add( columnIskeyIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnConfigQuery columnIskeyNotIn(String columnIskeyNotIn) {
                    if(!IdUtils.isEmpty(columnIskeyNotIn)){
                        if(this.columnIskey_NOTIN == null){
                            this.columnIskey_NOTIN = new ArrayList<String>();
                        }
                        this.columnIskey_NOTIN.add( columnIskeyNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnConfigQuery columnIskeyIsNull() {
                    this.isNulls.add("columnIskey");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnIskeyIsNotNull() {
                    this.isNotNulls.add("columnIskey");
                    return this;
                }














                @Override
                public TcgColumnConfigQuery columnIsdict(String columnIsdict) {
                    if(!IdUtils.isEmpty(columnIsdict)){
                        this.columnIsdict = columnIsdict;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnIsdictNot(String columnIsdictNot) {
                    if(!IdUtils.isEmpty(columnIsdictNot)){
                        this.columnIsdict_NE = columnIsdictNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnIsdictIn(String columnIsdictIn) {
                    if(!IdUtils.isEmpty(columnIsdictIn)){
                        if(this.columnIsdict_IN == null){
                            this.columnIsdict_IN = new ArrayList<String>();
                        }
                        this.columnIsdict_IN.add( columnIsdictIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnConfigQuery columnIsdictNotIn(String columnIsdictNotIn) {
                    if(!IdUtils.isEmpty(columnIsdictNotIn)){
                        if(this.columnIsdict_NOTIN == null){
                            this.columnIsdict_NOTIN = new ArrayList<String>();
                        }
                        this.columnIsdict_NOTIN.add( columnIsdictNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgColumnConfigQuery columnIsdictIsNull() {
                    this.isNulls.add("columnIsdict");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnIsdictIsNotNull() {
                    this.isNotNulls.add("columnIsdict");
                    return this;
                }














                @Override
                public TcgColumnConfigQuery dictType(String dictType) {
                    if(!IdUtils.isEmpty(dictType)){
                        this.dictType = dictType;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery dictTypeNot(String dictTypeNot) {
                    if(!IdUtils.isEmpty(dictTypeNot)){
                        this.dictType_NE = dictTypeNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery dictTypeLike(String dictTypeLike) {
                    if(!IdUtils.isEmpty(dictTypeLike)){
                        this.dictType_LIKE = dictTypeLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery dictTypeNotLike(String dictTypeNotLike) {
                    if(!IdUtils.isEmpty(dictTypeNotLike)){
                        this.dictType_NOTLIKE = dictTypeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery dictTypeIn(String dictTypeIn) {
                    if(!IdUtils.isEmpty(dictTypeIn)){
                        if(this.dictType_IN == null){
                            this.dictType_IN = new ArrayList<String>();
                        }
                        this.dictType_IN.add( dictTypeIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery dictTypeNotIn(String dictTypeNotIn) {
                    if(!IdUtils.isEmpty(dictTypeNotIn)){
                        if(this.dictType_NOTIN == null){
                            this.dictType_NOTIN = new ArrayList<String>();
                        }
                        this.dictType_NOTIN.add( dictTypeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery dictTypeIsNull() {
                    this.isNulls.add("dictType");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery dictTypeIsNotNull() {
                    this.isNotNulls.add("dictType");
                    return this;
                }













                @Override
                public TcgColumnConfigQuery columnComment(String columnComment) {
                    if(!IdUtils.isEmpty(columnComment)){
                        this.columnComment = columnComment;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnCommentNot(String columnCommentNot) {
                    if(!IdUtils.isEmpty(columnCommentNot)){
                        this.columnComment_NE = columnCommentNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery columnCommentLike(String columnCommentLike) {
                    if(!IdUtils.isEmpty(columnCommentLike)){
                        this.columnComment_LIKE = columnCommentLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnCommentNotLike(String columnCommentNotLike) {
                    if(!IdUtils.isEmpty(columnCommentNotLike)){
                        this.columnComment_NOTLIKE = columnCommentNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnCommentIn(String columnCommentIn) {
                    if(!IdUtils.isEmpty(columnCommentIn)){
                        if(this.columnComment_IN == null){
                            this.columnComment_IN = new ArrayList<String>();
                        }
                        this.columnComment_IN.add( columnCommentIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnCommentNotIn(String columnCommentNotIn) {
                    if(!IdUtils.isEmpty(columnCommentNotIn)){
                        if(this.columnComment_NOTIN == null){
                            this.columnComment_NOTIN = new ArrayList<String>();
                        }
                        this.columnComment_NOTIN.add( columnCommentNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnCommentIsNull() {
                    this.isNulls.add("columnComment");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnCommentIsNotNull() {
                    this.isNotNulls.add("columnComment");
                    return this;
                }













                @Override
                public TcgColumnConfigQuery columnOtherComment(String columnOtherComment) {
                    if(!IdUtils.isEmpty(columnOtherComment)){
                        this.columnOtherComment = columnOtherComment;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnOtherCommentNot(String columnOtherCommentNot) {
                    if(!IdUtils.isEmpty(columnOtherCommentNot)){
                        this.columnOtherComment_NE = columnOtherCommentNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery columnOtherCommentLike(String columnOtherCommentLike) {
                    if(!IdUtils.isEmpty(columnOtherCommentLike)){
                        this.columnOtherComment_LIKE = columnOtherCommentLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnOtherCommentNotLike(String columnOtherCommentNotLike) {
                    if(!IdUtils.isEmpty(columnOtherCommentNotLike)){
                        this.columnOtherComment_NOTLIKE = columnOtherCommentNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnOtherCommentIn(String columnOtherCommentIn) {
                    if(!IdUtils.isEmpty(columnOtherCommentIn)){
                        if(this.columnOtherComment_IN == null){
                            this.columnOtherComment_IN = new ArrayList<String>();
                        }
                        this.columnOtherComment_IN.add( columnOtherCommentIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnOtherCommentNotIn(String columnOtherCommentNotIn) {
                    if(!IdUtils.isEmpty(columnOtherCommentNotIn)){
                        if(this.columnOtherComment_NOTIN == null){
                            this.columnOtherComment_NOTIN = new ArrayList<String>();
                        }
                        this.columnOtherComment_NOTIN.add( columnOtherCommentNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnOtherCommentIsNull() {
                    this.isNulls.add("columnOtherComment");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnOtherCommentIsNotNull() {
                    this.isNotNulls.add("columnOtherComment");
                    return this;
                }













                @Override
                public TcgColumnConfigQuery javaSimpleClass(String javaSimpleClass) {
                    if(!IdUtils.isEmpty(javaSimpleClass)){
                        this.javaSimpleClass = javaSimpleClass;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaSimpleClassNot(String javaSimpleClassNot) {
                    if(!IdUtils.isEmpty(javaSimpleClassNot)){
                        this.javaSimpleClass_NE = javaSimpleClassNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery javaSimpleClassLike(String javaSimpleClassLike) {
                    if(!IdUtils.isEmpty(javaSimpleClassLike)){
                        this.javaSimpleClass_LIKE = javaSimpleClassLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaSimpleClassNotLike(String javaSimpleClassNotLike) {
                    if(!IdUtils.isEmpty(javaSimpleClassNotLike)){
                        this.javaSimpleClass_NOTLIKE = javaSimpleClassNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery javaSimpleClassIn(String javaSimpleClassIn) {
                    if(!IdUtils.isEmpty(javaSimpleClassIn)){
                        if(this.javaSimpleClass_IN == null){
                            this.javaSimpleClass_IN = new ArrayList<String>();
                        }
                        this.javaSimpleClass_IN.add( javaSimpleClassIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaSimpleClassNotIn(String javaSimpleClassNotIn) {
                    if(!IdUtils.isEmpty(javaSimpleClassNotIn)){
                        if(this.javaSimpleClass_NOTIN == null){
                            this.javaSimpleClass_NOTIN = new ArrayList<String>();
                        }
                        this.javaSimpleClass_NOTIN.add( javaSimpleClassNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaSimpleClassIsNull() {
                    this.isNulls.add("javaSimpleClass");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaSimpleClassIsNotNull() {
                    this.isNotNulls.add("javaSimpleClass");
                    return this;
                }













                @Override
                public TcgColumnConfigQuery javaFullClass(String javaFullClass) {
                    if(!IdUtils.isEmpty(javaFullClass)){
                        this.javaFullClass = javaFullClass;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaFullClassNot(String javaFullClassNot) {
                    if(!IdUtils.isEmpty(javaFullClassNot)){
                        this.javaFullClass_NE = javaFullClassNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery javaFullClassLike(String javaFullClassLike) {
                    if(!IdUtils.isEmpty(javaFullClassLike)){
                        this.javaFullClass_LIKE = javaFullClassLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaFullClassNotLike(String javaFullClassNotLike) {
                    if(!IdUtils.isEmpty(javaFullClassNotLike)){
                        this.javaFullClass_NOTLIKE = javaFullClassNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery javaFullClassIn(String javaFullClassIn) {
                    if(!IdUtils.isEmpty(javaFullClassIn)){
                        if(this.javaFullClass_IN == null){
                            this.javaFullClass_IN = new ArrayList<String>();
                        }
                        this.javaFullClass_IN.add( javaFullClassIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaFullClassNotIn(String javaFullClassNotIn) {
                    if(!IdUtils.isEmpty(javaFullClassNotIn)){
                        if(this.javaFullClass_NOTIN == null){
                            this.javaFullClass_NOTIN = new ArrayList<String>();
                        }
                        this.javaFullClass_NOTIN.add( javaFullClassNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaFullClassIsNull() {
                    this.isNulls.add("javaFullClass");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaFullClassIsNotNull() {
                    this.isNotNulls.add("javaFullClass");
                    return this;
                }













                @Override
                public TcgColumnConfigQuery javaName(String javaName) {
                    if(!IdUtils.isEmpty(javaName)){
                        this.javaName = javaName;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaNameNot(String javaNameNot) {
                    if(!IdUtils.isEmpty(javaNameNot)){
                        this.javaName_NE = javaNameNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery javaNameLike(String javaNameLike) {
                    if(!IdUtils.isEmpty(javaNameLike)){
                        this.javaName_LIKE = javaNameLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaNameNotLike(String javaNameNotLike) {
                    if(!IdUtils.isEmpty(javaNameNotLike)){
                        this.javaName_NOTLIKE = javaNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery javaNameIn(String javaNameIn) {
                    if(!IdUtils.isEmpty(javaNameIn)){
                        if(this.javaName_IN == null){
                            this.javaName_IN = new ArrayList<String>();
                        }
                        this.javaName_IN.add( javaNameIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaNameNotIn(String javaNameNotIn) {
                    if(!IdUtils.isEmpty(javaNameNotIn)){
                        if(this.javaName_NOTIN == null){
                            this.javaName_NOTIN = new ArrayList<String>();
                        }
                        this.javaName_NOTIN.add( javaNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaNameIsNull() {
                    this.isNulls.add("javaName");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery javaNameIsNotNull() {
                    this.isNotNulls.add("javaName");
                    return this;
                }













                @Override
                public TcgColumnConfigQuery groupCode(String groupCode) {
                    if(!IdUtils.isEmpty(groupCode)){
                        this.groupCode = groupCode;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery groupCodeNot(String groupCodeNot) {
                    if(!IdUtils.isEmpty(groupCodeNot)){
                        this.groupCode_NE = groupCodeNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery groupCodeLike(String groupCodeLike) {
                    if(!IdUtils.isEmpty(groupCodeLike)){
                        this.groupCode_LIKE = groupCodeLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery groupCodeNotLike(String groupCodeNotLike) {
                    if(!IdUtils.isEmpty(groupCodeNotLike)){
                        this.groupCode_NOTLIKE = groupCodeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery groupCodeIn(String groupCodeIn) {
                    if(!IdUtils.isEmpty(groupCodeIn)){
                        if(this.groupCode_IN == null){
                            this.groupCode_IN = new ArrayList<String>();
                        }
                        this.groupCode_IN.add( groupCodeIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery groupCodeNotIn(String groupCodeNotIn) {
                    if(!IdUtils.isEmpty(groupCodeNotIn)){
                        if(this.groupCode_NOTIN == null){
                            this.groupCode_NOTIN = new ArrayList<String>();
                        }
                        this.groupCode_NOTIN.add( groupCodeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery groupCodeIsNull() {
                    this.isNulls.add("groupCode");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery groupCodeIsNotNull() {
                    this.isNotNulls.add("groupCode");
                    return this;
                }













            @Override
            public TcgColumnConfigQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgColumnConfigQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgColumnConfigQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        if(this.createUserId_IN == null){
                            this.createUserId_IN = new ArrayList<PK>();
                        }
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        if(this.createUserId_NOTIN == null){
                            this.createUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgColumnConfigQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgColumnConfigQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgColumnConfigQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        if(this.updateUserId_IN == null){
                            this.updateUserId_IN = new ArrayList<PK>();
                        }
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        if(this.updateUserId_NOTIN == null){
                            this.updateUserId_NOTIN = new ArrayList<PK>();
                        }
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgColumnConfigQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgColumnConfigQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}