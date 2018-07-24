package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgModuleConfigQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 模块设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 12:32:15
 */
public class TcgModuleConfigQueryImpl<PK extends Serializable> extends TcgModuleConfigAbstractQueryImpl<PK> implements TcgModuleConfigQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> projectId_IN;
            private List<PK> projectId_NOTIN;













            private List<String> moduleName_IN;
            private List<String> moduleName_NOTIN;













            private List<String> moduleResource_IN;
            private List<String> moduleResource_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgModuleConfigQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgModuleConfigQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgModuleConfigQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgModuleConfigQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgModuleConfigQuery projectId(PK projectId) {
                    if(!IdUtils.isEmpty(projectId)){
                        this.projectId = projectId;
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery projectIdNot(PK projectIdNot) {
                    if(!IdUtils.isEmpty(projectIdNot)){
                        this.projectId_NE = projectIdNot;
                    }
                    return this;
                }

                @Override
                public TcgModuleConfigQuery projectIdIn(PK projectIdIn) {
                    if(!IdUtils.isEmpty(projectIdIn)){
                        this.projectId_IN.add( projectIdIn );
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery projectIdNotIn(PK projectIdNotIn) {
                    if(!IdUtils.isEmpty(projectIdNotIn)){
                        this.projectId_NOTIN.add( projectIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgModuleConfigQuery projectIdIsNull() {
                    this.isNulls.add("projectId");
                    return this;
                }



                @Override
                public TcgModuleConfigQuery projectIdIsNotNull() {
                    this.isNotNulls.add("projectId");
                    return this;
                }















                @Override
                public TcgModuleConfigQuery moduleName(String moduleName) {
                    if(!IdUtils.isEmpty(moduleName)){
                        this.moduleName = moduleName;
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery moduleNameNot(String moduleNameNot) {
                    if(!IdUtils.isEmpty(moduleNameNot)){
                        this.moduleName_NE = moduleNameNot;
                    }
                    return this;
                }




                @Override
                public TcgModuleConfigQuery moduleNameLike(String moduleNameLike) {
                    if(!IdUtils.isEmpty(moduleNameLike)){
                        this.moduleName_LIKE = moduleNameLike;
                    }
                    return this;
                }



                @Override
                public TcgModuleConfigQuery moduleNameNotLike(String moduleNameNotLike) {
                    if(!IdUtils.isEmpty(moduleNameNotLike)){
                        this.moduleName_NOTLIKE = moduleNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgModuleConfigQuery moduleNameIn(String moduleNameIn) {
                    if(!IdUtils.isEmpty(moduleNameIn)){
                        this.moduleName_IN.add( moduleNameIn );
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery moduleNameNotIn(String moduleNameNotIn) {
                    if(!IdUtils.isEmpty(moduleNameNotIn)){
                        this.moduleName_NOTIN.add( moduleNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgModuleConfigQuery moduleNameIsNull() {
                    this.isNulls.add("moduleName");
                    return this;
                }



                @Override
                public TcgModuleConfigQuery moduleNameIsNotNull() {
                    this.isNotNulls.add("moduleName");
                    return this;
                }













                @Override
                public TcgModuleConfigQuery moduleResource(String moduleResource) {
                    if(!IdUtils.isEmpty(moduleResource)){
                        this.moduleResource = moduleResource;
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery moduleResourceNot(String moduleResourceNot) {
                    if(!IdUtils.isEmpty(moduleResourceNot)){
                        this.moduleResource_NE = moduleResourceNot;
                    }
                    return this;
                }




                @Override
                public TcgModuleConfigQuery moduleResourceLike(String moduleResourceLike) {
                    if(!IdUtils.isEmpty(moduleResourceLike)){
                        this.moduleResource_LIKE = moduleResourceLike;
                    }
                    return this;
                }



                @Override
                public TcgModuleConfigQuery moduleResourceNotLike(String moduleResourceNotLike) {
                    if(!IdUtils.isEmpty(moduleResourceNotLike)){
                        this.moduleResource_NOTLIKE = moduleResourceNotLike;
                    }
                    return this;
                }

                @Override
                public TcgModuleConfigQuery moduleResourceIn(String moduleResourceIn) {
                    if(!IdUtils.isEmpty(moduleResourceIn)){
                        this.moduleResource_IN.add( moduleResourceIn );
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery moduleResourceNotIn(String moduleResourceNotIn) {
                    if(!IdUtils.isEmpty(moduleResourceNotIn)){
                        this.moduleResource_NOTIN.add( moduleResourceNotIn );
                    }
                    return this;
                }



                @Override
                public TcgModuleConfigQuery moduleResourceIsNull() {
                    this.isNulls.add("moduleResource");
                    return this;
                }



                @Override
                public TcgModuleConfigQuery moduleResourceIsNotNull() {
                    this.isNotNulls.add("moduleResource");
                    return this;
                }













            @Override
            public TcgModuleConfigQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgModuleConfigQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgModuleConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgModuleConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgModuleConfigQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgModuleConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgModuleConfigQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgModuleConfigQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgModuleConfigQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgModuleConfigQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgModuleConfigQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgModuleConfigQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgModuleConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgModuleConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgModuleConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgModuleConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgModuleConfigQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgModuleConfigQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgModuleConfigQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgModuleConfigQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgModuleConfigQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgModuleConfigQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgModuleConfigQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgModuleConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgModuleConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgModuleConfigQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgModuleConfigQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}