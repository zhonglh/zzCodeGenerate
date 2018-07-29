package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgColumnConfigQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 列设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-29 1:16:07
 */
public class TcgColumnConfigQueryImpl<PK extends Serializable> extends TcgColumnConfigAbstractQueryImpl<PK> implements TcgColumnConfigQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






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














            private List<String> columnContent_IN;
            private List<String> columnContent_NOTIN;













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
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
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
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
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
                        this.columnName_IN.add( columnNameIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnNameNotIn(String columnNameNotIn) {
                    if(!IdUtils.isEmpty(columnNameNotIn)){
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
                        this.columnType_IN.add( columnTypeIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnTypeNotIn(String columnTypeNotIn) {
                    if(!IdUtils.isEmpty(columnTypeNotIn)){
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
            public TcgColumnConfigQuery columnPrecision(Integer columnPrecision) {
                if(!IdUtils.isEmpty(columnPrecision)){
                    this.columnPrecision = columnPrecision;
                }
                return this;
            }



            @Override
            public TcgColumnConfigQuery columnPrecisionNot(Integer columnPrecisionNot) {
                if(!IdUtils.isEmpty(columnPrecisionNot)){
                    this.columnPrecision_NE = columnPrecisionNot;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery columnPrecisionGreaterThan(Integer columnPrecisionGreaterThan){
                if(columnPrecisionGreaterThan != null){
                    this.columnPrecision_GT = columnPrecisionGreaterThan;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery columnPrecisionGreaterEqual(Integer columnPrecisionGreaterEqual){
                if(columnPrecisionGreaterEqual != null){
                    this.columnPrecision_GE = columnPrecisionGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgColumnConfigQuery columnPrecisionLessThan(Integer columnPrecisionLessThan){
                if(columnPrecisionLessThan != null){
                    this.columnPrecision_LT = columnPrecisionLessThan;
                }
                return this;
            }

            @Override
            public TcgColumnConfigQuery columnPrecisionLessEqual(Integer columnPrecisionLessEqual){
                if(columnPrecisionLessEqual != null){
                    this.columnPrecision_LE = columnPrecisionLessEqual;
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
                        this.columnDefault_IN.add( columnDefaultIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnDefaultNotIn(String columnDefaultNotIn) {
                    if(!IdUtils.isEmpty(columnDefaultNotIn)){
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
                        this.columnIsnull_IN.add( columnIsnullIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnConfigQuery columnIsnullNotIn(String columnIsnullNotIn) {
                    if(!IdUtils.isEmpty(columnIsnullNotIn)){
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
                        this.columnIsfk_IN.add( columnIsfkIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnConfigQuery columnIsfkNotIn(String columnIsfkNotIn) {
                    if(!IdUtils.isEmpty(columnIsfkNotIn)){
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
                        this.columnIskey_IN.add( columnIskeyIn );
                    }
                    return this;
                }


                @Override
                    public TcgColumnConfigQuery columnIskeyNotIn(String columnIskeyNotIn) {
                    if(!IdUtils.isEmpty(columnIskeyNotIn)){
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
                public TcgColumnConfigQuery columnContent(String columnContent) {
                    if(!IdUtils.isEmpty(columnContent)){
                        this.columnContent = columnContent;
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnContentNot(String columnContentNot) {
                    if(!IdUtils.isEmpty(columnContentNot)){
                        this.columnContent_NE = columnContentNot;
                    }
                    return this;
                }




                @Override
                public TcgColumnConfigQuery columnContentLike(String columnContentLike) {
                    if(!IdUtils.isEmpty(columnContentLike)){
                        this.columnContent_LIKE = columnContentLike;
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnContentNotLike(String columnContentNotLike) {
                    if(!IdUtils.isEmpty(columnContentNotLike)){
                        this.columnContent_NOTLIKE = columnContentNotLike;
                    }
                    return this;
                }

                @Override
                public TcgColumnConfigQuery columnContentIn(String columnContentIn) {
                    if(!IdUtils.isEmpty(columnContentIn)){
                        this.columnContent_IN.add( columnContentIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery columnContentNotIn(String columnContentNotIn) {
                    if(!IdUtils.isEmpty(columnContentNotIn)){
                        this.columnContent_NOTIN.add( columnContentNotIn );
                    }
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnContentIsNull() {
                    this.isNulls.add("columnContent");
                    return this;
                }



                @Override
                public TcgColumnConfigQuery columnContentIsNotNull() {
                    this.isNotNulls.add("columnContent");
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
                        this.javaSimpleClass_IN.add( javaSimpleClassIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaSimpleClassNotIn(String javaSimpleClassNotIn) {
                    if(!IdUtils.isEmpty(javaSimpleClassNotIn)){
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
                        this.javaFullClass_IN.add( javaFullClassIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaFullClassNotIn(String javaFullClassNotIn) {
                    if(!IdUtils.isEmpty(javaFullClassNotIn)){
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
                        this.javaName_IN.add( javaNameIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery javaNameNotIn(String javaNameNotIn) {
                    if(!IdUtils.isEmpty(javaNameNotIn)){
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
                        this.groupCode_IN.add( groupCodeIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery groupCodeNotIn(String groupCodeNotIn) {
                    if(!IdUtils.isEmpty(groupCodeNotIn)){
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
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
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
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgColumnConfigQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
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