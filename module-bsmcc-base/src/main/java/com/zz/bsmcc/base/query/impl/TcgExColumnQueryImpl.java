package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgExColumnQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 扩展列设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-29 1:16:11
 */
public class TcgExColumnQueryImpl<PK extends Serializable> extends TcgExColumnAbstractQueryImpl<PK> implements TcgExColumnQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> tableId_IN;
            private List<PK> tableId_NOTIN;













            private List<String> javaSimpleClass_IN;
            private List<String> javaSimpleClass_NOTIN;













            private List<String> javaFullClass_IN;
            private List<String> javaFullClass_NOTIN;













            private List<String> javaName_IN;
            private List<String> javaName_NOTIN;













            private List<String> columnTitle_IN;
            private List<String> columnTitle_NOTIN;













            private List<String> groupCode_IN;
            private List<String> groupCode_NOTIN;













            private List<String> dictType_IN;
            private List<String> dictType_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgExColumnQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgExColumnQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgExColumnQuery tableId(PK tableId) {
                    if(!IdUtils.isEmpty(tableId)){
                        this.tableId = tableId;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery tableIdNot(PK tableIdNot) {
                    if(!IdUtils.isEmpty(tableIdNot)){
                        this.tableId_NE = tableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery tableIdIn(PK tableIdIn) {
                    if(!IdUtils.isEmpty(tableIdIn)){
                        this.tableId_IN.add( tableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery tableIdNotIn(PK tableIdNotIn) {
                    if(!IdUtils.isEmpty(tableIdNotIn)){
                        this.tableId_NOTIN.add( tableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery tableIdIsNull() {
                    this.isNulls.add("tableId");
                    return this;
                }



                @Override
                public TcgExColumnQuery tableIdIsNotNull() {
                    this.isNotNulls.add("tableId");
                    return this;
                }















                @Override
                public TcgExColumnQuery javaSimpleClass(String javaSimpleClass) {
                    if(!IdUtils.isEmpty(javaSimpleClass)){
                        this.javaSimpleClass = javaSimpleClass;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaSimpleClassNot(String javaSimpleClassNot) {
                    if(!IdUtils.isEmpty(javaSimpleClassNot)){
                        this.javaSimpleClass_NE = javaSimpleClassNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery javaSimpleClassLike(String javaSimpleClassLike) {
                    if(!IdUtils.isEmpty(javaSimpleClassLike)){
                        this.javaSimpleClass_LIKE = javaSimpleClassLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaSimpleClassNotLike(String javaSimpleClassNotLike) {
                    if(!IdUtils.isEmpty(javaSimpleClassNotLike)){
                        this.javaSimpleClass_NOTLIKE = javaSimpleClassNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery javaSimpleClassIn(String javaSimpleClassIn) {
                    if(!IdUtils.isEmpty(javaSimpleClassIn)){
                        this.javaSimpleClass_IN.add( javaSimpleClassIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaSimpleClassNotIn(String javaSimpleClassNotIn) {
                    if(!IdUtils.isEmpty(javaSimpleClassNotIn)){
                        this.javaSimpleClass_NOTIN.add( javaSimpleClassNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaSimpleClassIsNull() {
                    this.isNulls.add("javaSimpleClass");
                    return this;
                }



                @Override
                public TcgExColumnQuery javaSimpleClassIsNotNull() {
                    this.isNotNulls.add("javaSimpleClass");
                    return this;
                }













                @Override
                public TcgExColumnQuery javaFullClass(String javaFullClass) {
                    if(!IdUtils.isEmpty(javaFullClass)){
                        this.javaFullClass = javaFullClass;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaFullClassNot(String javaFullClassNot) {
                    if(!IdUtils.isEmpty(javaFullClassNot)){
                        this.javaFullClass_NE = javaFullClassNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery javaFullClassLike(String javaFullClassLike) {
                    if(!IdUtils.isEmpty(javaFullClassLike)){
                        this.javaFullClass_LIKE = javaFullClassLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaFullClassNotLike(String javaFullClassNotLike) {
                    if(!IdUtils.isEmpty(javaFullClassNotLike)){
                        this.javaFullClass_NOTLIKE = javaFullClassNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery javaFullClassIn(String javaFullClassIn) {
                    if(!IdUtils.isEmpty(javaFullClassIn)){
                        this.javaFullClass_IN.add( javaFullClassIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaFullClassNotIn(String javaFullClassNotIn) {
                    if(!IdUtils.isEmpty(javaFullClassNotIn)){
                        this.javaFullClass_NOTIN.add( javaFullClassNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaFullClassIsNull() {
                    this.isNulls.add("javaFullClass");
                    return this;
                }



                @Override
                public TcgExColumnQuery javaFullClassIsNotNull() {
                    this.isNotNulls.add("javaFullClass");
                    return this;
                }













                @Override
                public TcgExColumnQuery javaName(String javaName) {
                    if(!IdUtils.isEmpty(javaName)){
                        this.javaName = javaName;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaNameNot(String javaNameNot) {
                    if(!IdUtils.isEmpty(javaNameNot)){
                        this.javaName_NE = javaNameNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery javaNameLike(String javaNameLike) {
                    if(!IdUtils.isEmpty(javaNameLike)){
                        this.javaName_LIKE = javaNameLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaNameNotLike(String javaNameNotLike) {
                    if(!IdUtils.isEmpty(javaNameNotLike)){
                        this.javaName_NOTLIKE = javaNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery javaNameIn(String javaNameIn) {
                    if(!IdUtils.isEmpty(javaNameIn)){
                        this.javaName_IN.add( javaNameIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery javaNameNotIn(String javaNameNotIn) {
                    if(!IdUtils.isEmpty(javaNameNotIn)){
                        this.javaName_NOTIN.add( javaNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery javaNameIsNull() {
                    this.isNulls.add("javaName");
                    return this;
                }



                @Override
                public TcgExColumnQuery javaNameIsNotNull() {
                    this.isNotNulls.add("javaName");
                    return this;
                }













                @Override
                public TcgExColumnQuery columnTitle(String columnTitle) {
                    if(!IdUtils.isEmpty(columnTitle)){
                        this.columnTitle = columnTitle;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery columnTitleNot(String columnTitleNot) {
                    if(!IdUtils.isEmpty(columnTitleNot)){
                        this.columnTitle_NE = columnTitleNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery columnTitleLike(String columnTitleLike) {
                    if(!IdUtils.isEmpty(columnTitleLike)){
                        this.columnTitle_LIKE = columnTitleLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery columnTitleNotLike(String columnTitleNotLike) {
                    if(!IdUtils.isEmpty(columnTitleNotLike)){
                        this.columnTitle_NOTLIKE = columnTitleNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery columnTitleIn(String columnTitleIn) {
                    if(!IdUtils.isEmpty(columnTitleIn)){
                        this.columnTitle_IN.add( columnTitleIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery columnTitleNotIn(String columnTitleNotIn) {
                    if(!IdUtils.isEmpty(columnTitleNotIn)){
                        this.columnTitle_NOTIN.add( columnTitleNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery columnTitleIsNull() {
                    this.isNulls.add("columnTitle");
                    return this;
                }



                @Override
                public TcgExColumnQuery columnTitleIsNotNull() {
                    this.isNotNulls.add("columnTitle");
                    return this;
                }













                @Override
                public TcgExColumnQuery groupCode(String groupCode) {
                    if(!IdUtils.isEmpty(groupCode)){
                        this.groupCode = groupCode;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery groupCodeNot(String groupCodeNot) {
                    if(!IdUtils.isEmpty(groupCodeNot)){
                        this.groupCode_NE = groupCodeNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery groupCodeLike(String groupCodeLike) {
                    if(!IdUtils.isEmpty(groupCodeLike)){
                        this.groupCode_LIKE = groupCodeLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery groupCodeNotLike(String groupCodeNotLike) {
                    if(!IdUtils.isEmpty(groupCodeNotLike)){
                        this.groupCode_NOTLIKE = groupCodeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery groupCodeIn(String groupCodeIn) {
                    if(!IdUtils.isEmpty(groupCodeIn)){
                        this.groupCode_IN.add( groupCodeIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery groupCodeNotIn(String groupCodeNotIn) {
                    if(!IdUtils.isEmpty(groupCodeNotIn)){
                        this.groupCode_NOTIN.add( groupCodeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery groupCodeIsNull() {
                    this.isNulls.add("groupCode");
                    return this;
                }



                @Override
                public TcgExColumnQuery groupCodeIsNotNull() {
                    this.isNotNulls.add("groupCode");
                    return this;
                }













                @Override
                public TcgExColumnQuery dictType(String dictType) {
                    if(!IdUtils.isEmpty(dictType)){
                        this.dictType = dictType;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery dictTypeNot(String dictTypeNot) {
                    if(!IdUtils.isEmpty(dictTypeNot)){
                        this.dictType_NE = dictTypeNot;
                    }
                    return this;
                }




                @Override
                public TcgExColumnQuery dictTypeLike(String dictTypeLike) {
                    if(!IdUtils.isEmpty(dictTypeLike)){
                        this.dictType_LIKE = dictTypeLike;
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery dictTypeNotLike(String dictTypeNotLike) {
                    if(!IdUtils.isEmpty(dictTypeNotLike)){
                        this.dictType_NOTLIKE = dictTypeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery dictTypeIn(String dictTypeIn) {
                    if(!IdUtils.isEmpty(dictTypeIn)){
                        this.dictType_IN.add( dictTypeIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery dictTypeNotIn(String dictTypeNotIn) {
                    if(!IdUtils.isEmpty(dictTypeNotIn)){
                        this.dictType_NOTIN.add( dictTypeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery dictTypeIsNull() {
                    this.isNulls.add("dictType");
                    return this;
                }



                @Override
                public TcgExColumnQuery dictTypeIsNotNull() {
                    this.isNotNulls.add("dictType");
                    return this;
                }













            @Override
            public TcgExColumnQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgExColumnQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgExColumnQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgExColumnQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgExColumnQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgExColumnQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgExColumnQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgExColumnQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgExColumnQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgExColumnQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgExColumnQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgExColumnQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgExColumnQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgExColumnQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgExColumnQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}