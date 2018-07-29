package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgTableConfigQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 表设置 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-29 1:16:14
 */
public class TcgTableConfigQueryImpl<PK extends Serializable> extends TcgTableConfigAbstractQueryImpl<PK> implements TcgTableConfigQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> dbId_IN;
            private List<PK> dbId_NOTIN;













            private List<PK> projectId_IN;
            private List<PK> projectId_NOTIN;













            private List<PK> moduleId_IN;
            private List<PK> moduleId_NOTIN;













            private List<String> schemaName_IN;
            private List<String> schemaName_NOTIN;













            private List<String> tableName_IN;
            private List<String> tableName_NOTIN;













            private List<String> tableType_IN;
            private List<String> tableType_NOTIN;














            private List<String> tableRelation_IN;
            private List<String> tableRelation_NOTIN;













            private List<String> isShowCheckbox_IN;
            private List<String> isShowCheckbox_NOTIN;














            private List<String> isTable_IN;
            private List<String> isTable_NOTIN;














            private List<PK> mainTableId_IN;
            private List<PK> mainTableId_NOTIN;













            private List<String> resourceName_IN;
            private List<String> resourceName_NOTIN;













            private List<String> isTree_IN;
            private List<String> isTree_NOTIN;














            private List<String> parentFieldName_IN;
            private List<String> parentFieldName_NOTIN;













            private List<String> content_IN;
            private List<String> content_NOTIN;













            private List<String> queryMode_IN;
            private List<String> queryMode_NOTIN;













            private List<String> isBuildController_IN;
            private List<String> isBuildController_NOTIN;














            private List<String> isBuildMenu_IN;
            private List<String> isBuildMenu_NOTIN;














            private List<String> javaName_IN;
            private List<String> javaName_NOTIN;























            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;


































                @Override
                public TcgTableConfigQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgTableConfigQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgTableConfigQuery dbId(PK dbId) {
                    if(!IdUtils.isEmpty(dbId)){
                        this.dbId = dbId;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery dbIdNot(PK dbIdNot) {
                    if(!IdUtils.isEmpty(dbIdNot)){
                        this.dbId_NE = dbIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery dbIdIn(PK dbIdIn) {
                    if(!IdUtils.isEmpty(dbIdIn)){
                        this.dbId_IN.add( dbIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery dbIdNotIn(PK dbIdNotIn) {
                    if(!IdUtils.isEmpty(dbIdNotIn)){
                        this.dbId_NOTIN.add( dbIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery dbIdIsNull() {
                    this.isNulls.add("dbId");
                    return this;
                }



                @Override
                public TcgTableConfigQuery dbIdIsNotNull() {
                    this.isNotNulls.add("dbId");
                    return this;
                }















                @Override
                public TcgTableConfigQuery projectId(PK projectId) {
                    if(!IdUtils.isEmpty(projectId)){
                        this.projectId = projectId;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery projectIdNot(PK projectIdNot) {
                    if(!IdUtils.isEmpty(projectIdNot)){
                        this.projectId_NE = projectIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery projectIdIn(PK projectIdIn) {
                    if(!IdUtils.isEmpty(projectIdIn)){
                        this.projectId_IN.add( projectIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery projectIdNotIn(PK projectIdNotIn) {
                    if(!IdUtils.isEmpty(projectIdNotIn)){
                        this.projectId_NOTIN.add( projectIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery projectIdIsNull() {
                    this.isNulls.add("projectId");
                    return this;
                }



                @Override
                public TcgTableConfigQuery projectIdIsNotNull() {
                    this.isNotNulls.add("projectId");
                    return this;
                }















                @Override
                public TcgTableConfigQuery moduleId(PK moduleId) {
                    if(!IdUtils.isEmpty(moduleId)){
                        this.moduleId = moduleId;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery moduleIdNot(PK moduleIdNot) {
                    if(!IdUtils.isEmpty(moduleIdNot)){
                        this.moduleId_NE = moduleIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery moduleIdIn(PK moduleIdIn) {
                    if(!IdUtils.isEmpty(moduleIdIn)){
                        this.moduleId_IN.add( moduleIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery moduleIdNotIn(PK moduleIdNotIn) {
                    if(!IdUtils.isEmpty(moduleIdNotIn)){
                        this.moduleId_NOTIN.add( moduleIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery moduleIdIsNull() {
                    this.isNulls.add("moduleId");
                    return this;
                }



                @Override
                public TcgTableConfigQuery moduleIdIsNotNull() {
                    this.isNotNulls.add("moduleId");
                    return this;
                }















                @Override
                public TcgTableConfigQuery schemaName(String schemaName) {
                    if(!IdUtils.isEmpty(schemaName)){
                        this.schemaName = schemaName;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery schemaNameNot(String schemaNameNot) {
                    if(!IdUtils.isEmpty(schemaNameNot)){
                        this.schemaName_NE = schemaNameNot;
                    }
                    return this;
                }




                @Override
                public TcgTableConfigQuery schemaNameLike(String schemaNameLike) {
                    if(!IdUtils.isEmpty(schemaNameLike)){
                        this.schemaName_LIKE = schemaNameLike;
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery schemaNameNotLike(String schemaNameNotLike) {
                    if(!IdUtils.isEmpty(schemaNameNotLike)){
                        this.schemaName_NOTLIKE = schemaNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery schemaNameIn(String schemaNameIn) {
                    if(!IdUtils.isEmpty(schemaNameIn)){
                        this.schemaName_IN.add( schemaNameIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery schemaNameNotIn(String schemaNameNotIn) {
                    if(!IdUtils.isEmpty(schemaNameNotIn)){
                        this.schemaName_NOTIN.add( schemaNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery schemaNameIsNull() {
                    this.isNulls.add("schemaName");
                    return this;
                }



                @Override
                public TcgTableConfigQuery schemaNameIsNotNull() {
                    this.isNotNulls.add("schemaName");
                    return this;
                }













                @Override
                public TcgTableConfigQuery tableName(String tableName) {
                    if(!IdUtils.isEmpty(tableName)){
                        this.tableName = tableName;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery tableNameNot(String tableNameNot) {
                    if(!IdUtils.isEmpty(tableNameNot)){
                        this.tableName_NE = tableNameNot;
                    }
                    return this;
                }




                @Override
                public TcgTableConfigQuery tableNameLike(String tableNameLike) {
                    if(!IdUtils.isEmpty(tableNameLike)){
                        this.tableName_LIKE = tableNameLike;
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery tableNameNotLike(String tableNameNotLike) {
                    if(!IdUtils.isEmpty(tableNameNotLike)){
                        this.tableName_NOTLIKE = tableNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery tableNameIn(String tableNameIn) {
                    if(!IdUtils.isEmpty(tableNameIn)){
                        this.tableName_IN.add( tableNameIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery tableNameNotIn(String tableNameNotIn) {
                    if(!IdUtils.isEmpty(tableNameNotIn)){
                        this.tableName_NOTIN.add( tableNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery tableNameIsNull() {
                    this.isNulls.add("tableName");
                    return this;
                }



                @Override
                public TcgTableConfigQuery tableNameIsNotNull() {
                    this.isNotNulls.add("tableName");
                    return this;
                }













                @Override
                public TcgTableConfigQuery tableType(String tableType) {
                    if(!IdUtils.isEmpty(tableType)){
                        this.tableType = tableType;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery tableTypeNot(String tableTypeNot) {
                    if(!IdUtils.isEmpty(tableTypeNot)){
                        this.tableType_NE = tableTypeNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery tableTypeIn(String tableTypeIn) {
                    if(!IdUtils.isEmpty(tableTypeIn)){
                        this.tableType_IN.add( tableTypeIn );
                    }
                    return this;
                }


                @Override
                    public TcgTableConfigQuery tableTypeNotIn(String tableTypeNotIn) {
                    if(!IdUtils.isEmpty(tableTypeNotIn)){
                        this.tableType_NOTIN.add( tableTypeNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgTableConfigQuery tableTypeIsNull() {
                    this.isNulls.add("tableType");
                    return this;
                }



                @Override
                public TcgTableConfigQuery tableTypeIsNotNull() {
                    this.isNotNulls.add("tableType");
                    return this;
                }














                @Override
                public TcgTableConfigQuery tableRelation(String tableRelation) {
                    if(!IdUtils.isEmpty(tableRelation)){
                        this.tableRelation = tableRelation;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery tableRelationNot(String tableRelationNot) {
                    if(!IdUtils.isEmpty(tableRelationNot)){
                        this.tableRelation_NE = tableRelationNot;
                    }
                    return this;
                }




                @Override
                public TcgTableConfigQuery tableRelationLike(String tableRelationLike) {
                    if(!IdUtils.isEmpty(tableRelationLike)){
                        this.tableRelation_LIKE = tableRelationLike;
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery tableRelationNotLike(String tableRelationNotLike) {
                    if(!IdUtils.isEmpty(tableRelationNotLike)){
                        this.tableRelation_NOTLIKE = tableRelationNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery tableRelationIn(String tableRelationIn) {
                    if(!IdUtils.isEmpty(tableRelationIn)){
                        this.tableRelation_IN.add( tableRelationIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery tableRelationNotIn(String tableRelationNotIn) {
                    if(!IdUtils.isEmpty(tableRelationNotIn)){
                        this.tableRelation_NOTIN.add( tableRelationNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery tableRelationIsNull() {
                    this.isNulls.add("tableRelation");
                    return this;
                }



                @Override
                public TcgTableConfigQuery tableRelationIsNotNull() {
                    this.isNotNulls.add("tableRelation");
                    return this;
                }













                @Override
                public TcgTableConfigQuery isShowCheckbox(String isShowCheckbox) {
                    if(!IdUtils.isEmpty(isShowCheckbox)){
                        this.isShowCheckbox = isShowCheckbox;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery isShowCheckboxNot(String isShowCheckboxNot) {
                    if(!IdUtils.isEmpty(isShowCheckboxNot)){
                        this.isShowCheckbox_NE = isShowCheckboxNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery isShowCheckboxIn(String isShowCheckboxIn) {
                    if(!IdUtils.isEmpty(isShowCheckboxIn)){
                        this.isShowCheckbox_IN.add( isShowCheckboxIn );
                    }
                    return this;
                }


                @Override
                    public TcgTableConfigQuery isShowCheckboxNotIn(String isShowCheckboxNotIn) {
                    if(!IdUtils.isEmpty(isShowCheckboxNotIn)){
                        this.isShowCheckbox_NOTIN.add( isShowCheckboxNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgTableConfigQuery isShowCheckboxIsNull() {
                    this.isNulls.add("isShowCheckbox");
                    return this;
                }



                @Override
                public TcgTableConfigQuery isShowCheckboxIsNotNull() {
                    this.isNotNulls.add("isShowCheckbox");
                    return this;
                }














                @Override
                public TcgTableConfigQuery isTable(String isTable) {
                    if(!IdUtils.isEmpty(isTable)){
                        this.isTable = isTable;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery isTableNot(String isTableNot) {
                    if(!IdUtils.isEmpty(isTableNot)){
                        this.isTable_NE = isTableNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery isTableIn(String isTableIn) {
                    if(!IdUtils.isEmpty(isTableIn)){
                        this.isTable_IN.add( isTableIn );
                    }
                    return this;
                }


                @Override
                    public TcgTableConfigQuery isTableNotIn(String isTableNotIn) {
                    if(!IdUtils.isEmpty(isTableNotIn)){
                        this.isTable_NOTIN.add( isTableNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgTableConfigQuery isTableIsNull() {
                    this.isNulls.add("isTable");
                    return this;
                }



                @Override
                public TcgTableConfigQuery isTableIsNotNull() {
                    this.isNotNulls.add("isTable");
                    return this;
                }














                @Override
                public TcgTableConfigQuery mainTableId(PK mainTableId) {
                    if(!IdUtils.isEmpty(mainTableId)){
                        this.mainTableId = mainTableId;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery mainTableIdNot(PK mainTableIdNot) {
                    if(!IdUtils.isEmpty(mainTableIdNot)){
                        this.mainTableId_NE = mainTableIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery mainTableIdIn(PK mainTableIdIn) {
                    if(!IdUtils.isEmpty(mainTableIdIn)){
                        this.mainTableId_IN.add( mainTableIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery mainTableIdNotIn(PK mainTableIdNotIn) {
                    if(!IdUtils.isEmpty(mainTableIdNotIn)){
                        this.mainTableId_NOTIN.add( mainTableIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery mainTableIdIsNull() {
                    this.isNulls.add("mainTableId");
                    return this;
                }



                @Override
                public TcgTableConfigQuery mainTableIdIsNotNull() {
                    this.isNotNulls.add("mainTableId");
                    return this;
                }















                @Override
                public TcgTableConfigQuery resourceName(String resourceName) {
                    if(!IdUtils.isEmpty(resourceName)){
                        this.resourceName = resourceName;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery resourceNameNot(String resourceNameNot) {
                    if(!IdUtils.isEmpty(resourceNameNot)){
                        this.resourceName_NE = resourceNameNot;
                    }
                    return this;
                }




                @Override
                public TcgTableConfigQuery resourceNameLike(String resourceNameLike) {
                    if(!IdUtils.isEmpty(resourceNameLike)){
                        this.resourceName_LIKE = resourceNameLike;
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery resourceNameNotLike(String resourceNameNotLike) {
                    if(!IdUtils.isEmpty(resourceNameNotLike)){
                        this.resourceName_NOTLIKE = resourceNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery resourceNameIn(String resourceNameIn) {
                    if(!IdUtils.isEmpty(resourceNameIn)){
                        this.resourceName_IN.add( resourceNameIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery resourceNameNotIn(String resourceNameNotIn) {
                    if(!IdUtils.isEmpty(resourceNameNotIn)){
                        this.resourceName_NOTIN.add( resourceNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery resourceNameIsNull() {
                    this.isNulls.add("resourceName");
                    return this;
                }



                @Override
                public TcgTableConfigQuery resourceNameIsNotNull() {
                    this.isNotNulls.add("resourceName");
                    return this;
                }













                @Override
                public TcgTableConfigQuery isTree(String isTree) {
                    if(!IdUtils.isEmpty(isTree)){
                        this.isTree = isTree;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery isTreeNot(String isTreeNot) {
                    if(!IdUtils.isEmpty(isTreeNot)){
                        this.isTree_NE = isTreeNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery isTreeIn(String isTreeIn) {
                    if(!IdUtils.isEmpty(isTreeIn)){
                        this.isTree_IN.add( isTreeIn );
                    }
                    return this;
                }


                @Override
                    public TcgTableConfigQuery isTreeNotIn(String isTreeNotIn) {
                    if(!IdUtils.isEmpty(isTreeNotIn)){
                        this.isTree_NOTIN.add( isTreeNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgTableConfigQuery isTreeIsNull() {
                    this.isNulls.add("isTree");
                    return this;
                }



                @Override
                public TcgTableConfigQuery isTreeIsNotNull() {
                    this.isNotNulls.add("isTree");
                    return this;
                }














                @Override
                public TcgTableConfigQuery parentFieldName(String parentFieldName) {
                    if(!IdUtils.isEmpty(parentFieldName)){
                        this.parentFieldName = parentFieldName;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery parentFieldNameNot(String parentFieldNameNot) {
                    if(!IdUtils.isEmpty(parentFieldNameNot)){
                        this.parentFieldName_NE = parentFieldNameNot;
                    }
                    return this;
                }




                @Override
                public TcgTableConfigQuery parentFieldNameLike(String parentFieldNameLike) {
                    if(!IdUtils.isEmpty(parentFieldNameLike)){
                        this.parentFieldName_LIKE = parentFieldNameLike;
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery parentFieldNameNotLike(String parentFieldNameNotLike) {
                    if(!IdUtils.isEmpty(parentFieldNameNotLike)){
                        this.parentFieldName_NOTLIKE = parentFieldNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery parentFieldNameIn(String parentFieldNameIn) {
                    if(!IdUtils.isEmpty(parentFieldNameIn)){
                        this.parentFieldName_IN.add( parentFieldNameIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery parentFieldNameNotIn(String parentFieldNameNotIn) {
                    if(!IdUtils.isEmpty(parentFieldNameNotIn)){
                        this.parentFieldName_NOTIN.add( parentFieldNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery parentFieldNameIsNull() {
                    this.isNulls.add("parentFieldName");
                    return this;
                }



                @Override
                public TcgTableConfigQuery parentFieldNameIsNotNull() {
                    this.isNotNulls.add("parentFieldName");
                    return this;
                }













                @Override
                public TcgTableConfigQuery content(String content) {
                    if(!IdUtils.isEmpty(content)){
                        this.content = content;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery contentNot(String contentNot) {
                    if(!IdUtils.isEmpty(contentNot)){
                        this.content_NE = contentNot;
                    }
                    return this;
                }




                @Override
                public TcgTableConfigQuery contentLike(String contentLike) {
                    if(!IdUtils.isEmpty(contentLike)){
                        this.content_LIKE = contentLike;
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery contentNotLike(String contentNotLike) {
                    if(!IdUtils.isEmpty(contentNotLike)){
                        this.content_NOTLIKE = contentNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery contentIn(String contentIn) {
                    if(!IdUtils.isEmpty(contentIn)){
                        this.content_IN.add( contentIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery contentNotIn(String contentNotIn) {
                    if(!IdUtils.isEmpty(contentNotIn)){
                        this.content_NOTIN.add( contentNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery contentIsNull() {
                    this.isNulls.add("content");
                    return this;
                }



                @Override
                public TcgTableConfigQuery contentIsNotNull() {
                    this.isNotNulls.add("content");
                    return this;
                }













                @Override
                public TcgTableConfigQuery queryMode(String queryMode) {
                    if(!IdUtils.isEmpty(queryMode)){
                        this.queryMode = queryMode;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery queryModeNot(String queryModeNot) {
                    if(!IdUtils.isEmpty(queryModeNot)){
                        this.queryMode_NE = queryModeNot;
                    }
                    return this;
                }




                @Override
                public TcgTableConfigQuery queryModeLike(String queryModeLike) {
                    if(!IdUtils.isEmpty(queryModeLike)){
                        this.queryMode_LIKE = queryModeLike;
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery queryModeNotLike(String queryModeNotLike) {
                    if(!IdUtils.isEmpty(queryModeNotLike)){
                        this.queryMode_NOTLIKE = queryModeNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery queryModeIn(String queryModeIn) {
                    if(!IdUtils.isEmpty(queryModeIn)){
                        this.queryMode_IN.add( queryModeIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery queryModeNotIn(String queryModeNotIn) {
                    if(!IdUtils.isEmpty(queryModeNotIn)){
                        this.queryMode_NOTIN.add( queryModeNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery queryModeIsNull() {
                    this.isNulls.add("queryMode");
                    return this;
                }



                @Override
                public TcgTableConfigQuery queryModeIsNotNull() {
                    this.isNotNulls.add("queryMode");
                    return this;
                }













                @Override
                public TcgTableConfigQuery isBuildController(String isBuildController) {
                    if(!IdUtils.isEmpty(isBuildController)){
                        this.isBuildController = isBuildController;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery isBuildControllerNot(String isBuildControllerNot) {
                    if(!IdUtils.isEmpty(isBuildControllerNot)){
                        this.isBuildController_NE = isBuildControllerNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery isBuildControllerIn(String isBuildControllerIn) {
                    if(!IdUtils.isEmpty(isBuildControllerIn)){
                        this.isBuildController_IN.add( isBuildControllerIn );
                    }
                    return this;
                }


                @Override
                    public TcgTableConfigQuery isBuildControllerNotIn(String isBuildControllerNotIn) {
                    if(!IdUtils.isEmpty(isBuildControllerNotIn)){
                        this.isBuildController_NOTIN.add( isBuildControllerNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgTableConfigQuery isBuildControllerIsNull() {
                    this.isNulls.add("isBuildController");
                    return this;
                }



                @Override
                public TcgTableConfigQuery isBuildControllerIsNotNull() {
                    this.isNotNulls.add("isBuildController");
                    return this;
                }














                @Override
                public TcgTableConfigQuery isBuildMenu(String isBuildMenu) {
                    if(!IdUtils.isEmpty(isBuildMenu)){
                        this.isBuildMenu = isBuildMenu;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery isBuildMenuNot(String isBuildMenuNot) {
                    if(!IdUtils.isEmpty(isBuildMenuNot)){
                        this.isBuildMenu_NE = isBuildMenuNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery isBuildMenuIn(String isBuildMenuIn) {
                    if(!IdUtils.isEmpty(isBuildMenuIn)){
                        this.isBuildMenu_IN.add( isBuildMenuIn );
                    }
                    return this;
                }


                @Override
                    public TcgTableConfigQuery isBuildMenuNotIn(String isBuildMenuNotIn) {
                    if(!IdUtils.isEmpty(isBuildMenuNotIn)){
                        this.isBuildMenu_NOTIN.add( isBuildMenuNotIn );
                    }
                    return this;
                    }



                @Override
                public TcgTableConfigQuery isBuildMenuIsNull() {
                    this.isNulls.add("isBuildMenu");
                    return this;
                }



                @Override
                public TcgTableConfigQuery isBuildMenuIsNotNull() {
                    this.isNotNulls.add("isBuildMenu");
                    return this;
                }














                @Override
                public TcgTableConfigQuery javaName(String javaName) {
                    if(!IdUtils.isEmpty(javaName)){
                        this.javaName = javaName;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery javaNameNot(String javaNameNot) {
                    if(!IdUtils.isEmpty(javaNameNot)){
                        this.javaName_NE = javaNameNot;
                    }
                    return this;
                }




                @Override
                public TcgTableConfigQuery javaNameLike(String javaNameLike) {
                    if(!IdUtils.isEmpty(javaNameLike)){
                        this.javaName_LIKE = javaNameLike;
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery javaNameNotLike(String javaNameNotLike) {
                    if(!IdUtils.isEmpty(javaNameNotLike)){
                        this.javaName_NOTLIKE = javaNameNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery javaNameIn(String javaNameIn) {
                    if(!IdUtils.isEmpty(javaNameIn)){
                        this.javaName_IN.add( javaNameIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery javaNameNotIn(String javaNameNotIn) {
                    if(!IdUtils.isEmpty(javaNameNotIn)){
                        this.javaName_NOTIN.add( javaNameNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery javaNameIsNull() {
                    this.isNulls.add("javaName");
                    return this;
                }



                @Override
                public TcgTableConfigQuery javaNameIsNotNull() {
                    this.isNotNulls.add("javaName");
                    return this;
                }













            @Override
            public TcgTableConfigQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TcgTableConfigQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TcgTableConfigQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTableConfigQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTableConfigQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgTableConfigQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgTableConfigQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TcgTableConfigQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















            @Override
            public TcgTableConfigQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TcgTableConfigQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TcgTableConfigQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTableConfigQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTableConfigQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TcgTableConfigQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











                @Override
                public TcgTableConfigQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTableConfigQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTableConfigQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTableConfigQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TcgTableConfigQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















            @Override
            public TcgTableConfigQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TcgTableConfigQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TcgTableConfigQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TcgTableConfigQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TcgTableConfigQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TcgTableConfigQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }







	
}