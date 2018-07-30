package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 表设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-30 17:18:08
 */
public class TcgTableConfigQueryWebImpl<PK extends Serializable> extends TcgTableConfigAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK dbId_IN;
            private PK dbId_NOTIN;











            private PK projectId_IN;
            private PK projectId_NOTIN;











            private PK moduleId_IN;
            private PK moduleId_NOTIN;










            private String schemaName_IN;
            private String schemaName_NOTIN;










            private String tableName_IN;
            private String tableName_NOTIN;











            private String tableType_IN;
            private String tableType_NOTIN;











            private String tableRelation_IN;
            private String tableRelation_NOTIN;











            private String isShowCheckbox_IN;
            private String isShowCheckbox_NOTIN;












            private String isTable_IN;
            private String isTable_NOTIN;












            private PK mainTableId_IN;
            private PK mainTableId_NOTIN;










            private String resourceName_IN;
            private String resourceName_NOTIN;











            private String isTree_IN;
            private String isTree_NOTIN;











            private String parentFieldName_IN;
            private String parentFieldName_NOTIN;










            private String tableComment_IN;
            private String tableComment_NOTIN;










            private String queryMode_IN;
            private String queryMode_NOTIN;











            private String isBuildController_IN;
            private String isBuildController_NOTIN;












            private String isBuildMenu_IN;
            private String isBuildMenu_NOTIN;











            private String javaName_IN;
            private String javaName_NOTIN;








        ;










            private PK createUserId_IN;
            private PK createUserId_NOTIN;








        ;










            private PK updateUserId_IN;
            private PK updateUserId_NOTIN;








        ;























                public PK getId() {
                    return id;
                }


                public void setId(PK id) {
                    this.id = id;
                }


                public PK getId_NE() {
                return id_NE;
                }


                public void setId_NE(PK id_NE) {
                this.id_NE = id_NE;
                }








                public PK getId_IN() {
                    return id_IN;
                }

                public void setId_IN(PK id_IN) {
                    this.id_IN = id_IN;
                }

                public PK getId_NOTIN() {
                    return id_NOTIN;
                }

                public void setId_NOTIN(PK id_NOTIN) {
                    this.id_NOTIN = id_NOTIN;
                }


















                public PK getDbId() {
                    return dbId;
                }


                public void setDbId(PK dbId) {
                    this.dbId = dbId;
                }


                public PK getDbId_NE() {
                return dbId_NE;
                }


                public void setDbId_NE(PK dbId_NE) {
                this.dbId_NE = dbId_NE;
                }








                public PK getDbId_IN() {
                    return dbId_IN;
                }

                public void setDbId_IN(PK dbId_IN) {
                    this.dbId_IN = dbId_IN;
                }

                public PK getDbId_NOTIN() {
                    return dbId_NOTIN;
                }

                public void setDbId_NOTIN(PK dbId_NOTIN) {
                    this.dbId_NOTIN = dbId_NOTIN;
                }


















                public PK getProjectId() {
                    return projectId;
                }


                public void setProjectId(PK projectId) {
                    this.projectId = projectId;
                }


                public PK getProjectId_NE() {
                return projectId_NE;
                }


                public void setProjectId_NE(PK projectId_NE) {
                this.projectId_NE = projectId_NE;
                }








                public PK getProjectId_IN() {
                    return projectId_IN;
                }

                public void setProjectId_IN(PK projectId_IN) {
                    this.projectId_IN = projectId_IN;
                }

                public PK getProjectId_NOTIN() {
                    return projectId_NOTIN;
                }

                public void setProjectId_NOTIN(PK projectId_NOTIN) {
                    this.projectId_NOTIN = projectId_NOTIN;
                }


















                public PK getModuleId() {
                    return moduleId;
                }


                public void setModuleId(PK moduleId) {
                    this.moduleId = moduleId;
                }


                public PK getModuleId_NE() {
                return moduleId_NE;
                }


                public void setModuleId_NE(PK moduleId_NE) {
                this.moduleId_NE = moduleId_NE;
                }








                public PK getModuleId_IN() {
                    return moduleId_IN;
                }

                public void setModuleId_IN(PK moduleId_IN) {
                    this.moduleId_IN = moduleId_IN;
                }

                public PK getModuleId_NOTIN() {
                    return moduleId_NOTIN;
                }

                public void setModuleId_NOTIN(PK moduleId_NOTIN) {
                    this.moduleId_NOTIN = moduleId_NOTIN;
                }


















                public String getSchemaName() {
                    return schemaName;
                }


                public void setSchemaName(String schemaName) {
                    this.schemaName = schemaName;
                }


                public String getSchemaName_NE() {
                    return schemaName_NE;
                }


                public void setSchemaName_NE(String schemaName_NE) {
                    this.schemaName_NE = schemaName_NE;
                }



                public String getSchemaName_IN() {
                    return schemaName_IN;
                }

                public void setSchemaName_IN(String schemaName_IN) {
                    this.schemaName_IN = schemaName_IN;
                }

                public String getSchemaName_NOTIN() {
                    return schemaName_NOTIN;
                }

                public void setSchemaName_NOTIN(String schemaName_NOTIN) {
                    this.schemaName_NOTIN = schemaName_NOTIN;
                }




                public String getSchemaName_LIKE() {
                    return schemaName_LIKE;
                }

                public void setSchemaName_LIKE(String schemaName_LIKE) {
                    this.schemaName_LIKE = schemaName_LIKE;
                }

                public String getSchemaName_NOTLIKE() {
                    return schemaName_NOTLIKE;
                }

                public void setSchemaName_NOTLIKE(String schemaName_NOTLIKE) {
                    this.schemaName_NOTLIKE = schemaName_NOTLIKE;
                }















                public String getTableName() {
                    return tableName;
                }


                public void setTableName(String tableName) {
                    this.tableName = tableName;
                }


                public String getTableName_NE() {
                    return tableName_NE;
                }


                public void setTableName_NE(String tableName_NE) {
                    this.tableName_NE = tableName_NE;
                }



                public String getTableName_IN() {
                    return tableName_IN;
                }

                public void setTableName_IN(String tableName_IN) {
                    this.tableName_IN = tableName_IN;
                }

                public String getTableName_NOTIN() {
                    return tableName_NOTIN;
                }

                public void setTableName_NOTIN(String tableName_NOTIN) {
                    this.tableName_NOTIN = tableName_NOTIN;
                }




                public String getTableName_LIKE() {
                    return tableName_LIKE;
                }

                public void setTableName_LIKE(String tableName_LIKE) {
                    this.tableName_LIKE = tableName_LIKE;
                }

                public String getTableName_NOTLIKE() {
                    return tableName_NOTLIKE;
                }

                public void setTableName_NOTLIKE(String tableName_NOTLIKE) {
                    this.tableName_NOTLIKE = tableName_NOTLIKE;
                }















                public String getTableType() {
                    return tableType;
                }


                public void setTableType(String tableType) {
                    this.tableType = tableType;
                }


                public String getTableType_NE() {
                    return tableType_NE;
                }


                public void setTableType_NE(String tableType_NE) {
                    this.tableType_NE = tableType_NE;
                }



                public String getTableType_IN() {
                    return tableType_IN;
                }

                public void setTableType_IN(String tableType_IN) {
                    this.tableType_IN = tableType_IN;
                }

                public String getTableType_NOTIN() {
                    return tableType_NOTIN;
                }

                public void setTableType_NOTIN(String tableType_NOTIN) {
                    this.tableType_NOTIN = tableType_NOTIN;
                }
















                public String getTableRelation() {
                    return tableRelation;
                }


                public void setTableRelation(String tableRelation) {
                    this.tableRelation = tableRelation;
                }


                public String getTableRelation_NE() {
                    return tableRelation_NE;
                }


                public void setTableRelation_NE(String tableRelation_NE) {
                    this.tableRelation_NE = tableRelation_NE;
                }



                public String getTableRelation_IN() {
                    return tableRelation_IN;
                }

                public void setTableRelation_IN(String tableRelation_IN) {
                    this.tableRelation_IN = tableRelation_IN;
                }

                public String getTableRelation_NOTIN() {
                    return tableRelation_NOTIN;
                }

                public void setTableRelation_NOTIN(String tableRelation_NOTIN) {
                    this.tableRelation_NOTIN = tableRelation_NOTIN;
                }




                public String getTableRelation_LIKE() {
                    return tableRelation_LIKE;
                }

                public void setTableRelation_LIKE(String tableRelation_LIKE) {
                    this.tableRelation_LIKE = tableRelation_LIKE;
                }

                public String getTableRelation_NOTLIKE() {
                    return tableRelation_NOTLIKE;
                }

                public void setTableRelation_NOTLIKE(String tableRelation_NOTLIKE) {
                    this.tableRelation_NOTLIKE = tableRelation_NOTLIKE;
                }















                public String getIsShowCheckbox() {
                    return isShowCheckbox;
                }


                public void setIsShowCheckbox(String isShowCheckbox) {
                    this.isShowCheckbox = isShowCheckbox;
                }


                public String getIsShowCheckbox_NE() {
                    return isShowCheckbox_NE;
                }


                public void setIsShowCheckbox_NE(String isShowCheckbox_NE) {
                    this.isShowCheckbox_NE = isShowCheckbox_NE;
                }



                public String getIsShowCheckbox_IN() {
                    return isShowCheckbox_IN;
                }

                public void setIsShowCheckbox_IN(String isShowCheckbox_IN) {
                    this.isShowCheckbox_IN = isShowCheckbox_IN;
                }

                public String getIsShowCheckbox_NOTIN() {
                    return isShowCheckbox_NOTIN;
                }

                public void setIsShowCheckbox_NOTIN(String isShowCheckbox_NOTIN) {
                    this.isShowCheckbox_NOTIN = isShowCheckbox_NOTIN;
                }
















                public String getIsTable() {
                    return isTable;
                }


                public void setIsTable(String isTable) {
                    this.isTable = isTable;
                }


                public String getIsTable_NE() {
                    return isTable_NE;
                }


                public void setIsTable_NE(String isTable_NE) {
                    this.isTable_NE = isTable_NE;
                }



                public String getIsTable_IN() {
                    return isTable_IN;
                }

                public void setIsTable_IN(String isTable_IN) {
                    this.isTable_IN = isTable_IN;
                }

                public String getIsTable_NOTIN() {
                    return isTable_NOTIN;
                }

                public void setIsTable_NOTIN(String isTable_NOTIN) {
                    this.isTable_NOTIN = isTable_NOTIN;
                }
















                public PK getMainTableId() {
                    return mainTableId;
                }


                public void setMainTableId(PK mainTableId) {
                    this.mainTableId = mainTableId;
                }


                public PK getMainTableId_NE() {
                return mainTableId_NE;
                }


                public void setMainTableId_NE(PK mainTableId_NE) {
                this.mainTableId_NE = mainTableId_NE;
                }








                public PK getMainTableId_IN() {
                    return mainTableId_IN;
                }

                public void setMainTableId_IN(PK mainTableId_IN) {
                    this.mainTableId_IN = mainTableId_IN;
                }

                public PK getMainTableId_NOTIN() {
                    return mainTableId_NOTIN;
                }

                public void setMainTableId_NOTIN(PK mainTableId_NOTIN) {
                    this.mainTableId_NOTIN = mainTableId_NOTIN;
                }


















                public String getResourceName() {
                    return resourceName;
                }


                public void setResourceName(String resourceName) {
                    this.resourceName = resourceName;
                }


                public String getResourceName_NE() {
                    return resourceName_NE;
                }


                public void setResourceName_NE(String resourceName_NE) {
                    this.resourceName_NE = resourceName_NE;
                }



                public String getResourceName_IN() {
                    return resourceName_IN;
                }

                public void setResourceName_IN(String resourceName_IN) {
                    this.resourceName_IN = resourceName_IN;
                }

                public String getResourceName_NOTIN() {
                    return resourceName_NOTIN;
                }

                public void setResourceName_NOTIN(String resourceName_NOTIN) {
                    this.resourceName_NOTIN = resourceName_NOTIN;
                }




                public String getResourceName_LIKE() {
                    return resourceName_LIKE;
                }

                public void setResourceName_LIKE(String resourceName_LIKE) {
                    this.resourceName_LIKE = resourceName_LIKE;
                }

                public String getResourceName_NOTLIKE() {
                    return resourceName_NOTLIKE;
                }

                public void setResourceName_NOTLIKE(String resourceName_NOTLIKE) {
                    this.resourceName_NOTLIKE = resourceName_NOTLIKE;
                }















                public String getIsTree() {
                    return isTree;
                }


                public void setIsTree(String isTree) {
                    this.isTree = isTree;
                }


                public String getIsTree_NE() {
                    return isTree_NE;
                }


                public void setIsTree_NE(String isTree_NE) {
                    this.isTree_NE = isTree_NE;
                }



                public String getIsTree_IN() {
                    return isTree_IN;
                }

                public void setIsTree_IN(String isTree_IN) {
                    this.isTree_IN = isTree_IN;
                }

                public String getIsTree_NOTIN() {
                    return isTree_NOTIN;
                }

                public void setIsTree_NOTIN(String isTree_NOTIN) {
                    this.isTree_NOTIN = isTree_NOTIN;
                }
















                public String getParentFieldName() {
                    return parentFieldName;
                }


                public void setParentFieldName(String parentFieldName) {
                    this.parentFieldName = parentFieldName;
                }


                public String getParentFieldName_NE() {
                    return parentFieldName_NE;
                }


                public void setParentFieldName_NE(String parentFieldName_NE) {
                    this.parentFieldName_NE = parentFieldName_NE;
                }



                public String getParentFieldName_IN() {
                    return parentFieldName_IN;
                }

                public void setParentFieldName_IN(String parentFieldName_IN) {
                    this.parentFieldName_IN = parentFieldName_IN;
                }

                public String getParentFieldName_NOTIN() {
                    return parentFieldName_NOTIN;
                }

                public void setParentFieldName_NOTIN(String parentFieldName_NOTIN) {
                    this.parentFieldName_NOTIN = parentFieldName_NOTIN;
                }




                public String getParentFieldName_LIKE() {
                    return parentFieldName_LIKE;
                }

                public void setParentFieldName_LIKE(String parentFieldName_LIKE) {
                    this.parentFieldName_LIKE = parentFieldName_LIKE;
                }

                public String getParentFieldName_NOTLIKE() {
                    return parentFieldName_NOTLIKE;
                }

                public void setParentFieldName_NOTLIKE(String parentFieldName_NOTLIKE) {
                    this.parentFieldName_NOTLIKE = parentFieldName_NOTLIKE;
                }















                public String getTableComment() {
                    return tableComment;
                }


                public void setTableComment(String tableComment) {
                    this.tableComment = tableComment;
                }


                public String getTableComment_NE() {
                    return tableComment_NE;
                }


                public void setTableComment_NE(String tableComment_NE) {
                    this.tableComment_NE = tableComment_NE;
                }



                public String getTableComment_IN() {
                    return tableComment_IN;
                }

                public void setTableComment_IN(String tableComment_IN) {
                    this.tableComment_IN = tableComment_IN;
                }

                public String getTableComment_NOTIN() {
                    return tableComment_NOTIN;
                }

                public void setTableComment_NOTIN(String tableComment_NOTIN) {
                    this.tableComment_NOTIN = tableComment_NOTIN;
                }




                public String getTableComment_LIKE() {
                    return tableComment_LIKE;
                }

                public void setTableComment_LIKE(String tableComment_LIKE) {
                    this.tableComment_LIKE = tableComment_LIKE;
                }

                public String getTableComment_NOTLIKE() {
                    return tableComment_NOTLIKE;
                }

                public void setTableComment_NOTLIKE(String tableComment_NOTLIKE) {
                    this.tableComment_NOTLIKE = tableComment_NOTLIKE;
                }















                public String getQueryMode() {
                    return queryMode;
                }


                public void setQueryMode(String queryMode) {
                    this.queryMode = queryMode;
                }


                public String getQueryMode_NE() {
                    return queryMode_NE;
                }


                public void setQueryMode_NE(String queryMode_NE) {
                    this.queryMode_NE = queryMode_NE;
                }



                public String getQueryMode_IN() {
                    return queryMode_IN;
                }

                public void setQueryMode_IN(String queryMode_IN) {
                    this.queryMode_IN = queryMode_IN;
                }

                public String getQueryMode_NOTIN() {
                    return queryMode_NOTIN;
                }

                public void setQueryMode_NOTIN(String queryMode_NOTIN) {
                    this.queryMode_NOTIN = queryMode_NOTIN;
                }




                public String getQueryMode_LIKE() {
                    return queryMode_LIKE;
                }

                public void setQueryMode_LIKE(String queryMode_LIKE) {
                    this.queryMode_LIKE = queryMode_LIKE;
                }

                public String getQueryMode_NOTLIKE() {
                    return queryMode_NOTLIKE;
                }

                public void setQueryMode_NOTLIKE(String queryMode_NOTLIKE) {
                    this.queryMode_NOTLIKE = queryMode_NOTLIKE;
                }















                public String getIsBuildController() {
                    return isBuildController;
                }


                public void setIsBuildController(String isBuildController) {
                    this.isBuildController = isBuildController;
                }


                public String getIsBuildController_NE() {
                    return isBuildController_NE;
                }


                public void setIsBuildController_NE(String isBuildController_NE) {
                    this.isBuildController_NE = isBuildController_NE;
                }



                public String getIsBuildController_IN() {
                    return isBuildController_IN;
                }

                public void setIsBuildController_IN(String isBuildController_IN) {
                    this.isBuildController_IN = isBuildController_IN;
                }

                public String getIsBuildController_NOTIN() {
                    return isBuildController_NOTIN;
                }

                public void setIsBuildController_NOTIN(String isBuildController_NOTIN) {
                    this.isBuildController_NOTIN = isBuildController_NOTIN;
                }
















                public String getIsBuildMenu() {
                    return isBuildMenu;
                }


                public void setIsBuildMenu(String isBuildMenu) {
                    this.isBuildMenu = isBuildMenu;
                }


                public String getIsBuildMenu_NE() {
                    return isBuildMenu_NE;
                }


                public void setIsBuildMenu_NE(String isBuildMenu_NE) {
                    this.isBuildMenu_NE = isBuildMenu_NE;
                }



                public String getIsBuildMenu_IN() {
                    return isBuildMenu_IN;
                }

                public void setIsBuildMenu_IN(String isBuildMenu_IN) {
                    this.isBuildMenu_IN = isBuildMenu_IN;
                }

                public String getIsBuildMenu_NOTIN() {
                    return isBuildMenu_NOTIN;
                }

                public void setIsBuildMenu_NOTIN(String isBuildMenu_NOTIN) {
                    this.isBuildMenu_NOTIN = isBuildMenu_NOTIN;
                }
















                public String getJavaName() {
                    return javaName;
                }


                public void setJavaName(String javaName) {
                    this.javaName = javaName;
                }


                public String getJavaName_NE() {
                    return javaName_NE;
                }


                public void setJavaName_NE(String javaName_NE) {
                    this.javaName_NE = javaName_NE;
                }



                public String getJavaName_IN() {
                    return javaName_IN;
                }

                public void setJavaName_IN(String javaName_IN) {
                    this.javaName_IN = javaName_IN;
                }

                public String getJavaName_NOTIN() {
                    return javaName_NOTIN;
                }

                public void setJavaName_NOTIN(String javaName_NOTIN) {
                    this.javaName_NOTIN = javaName_NOTIN;
                }




                public String getJavaName_LIKE() {
                    return javaName_LIKE;
                }

                public void setJavaName_LIKE(String javaName_LIKE) {
                    this.javaName_LIKE = javaName_LIKE;
                }

                public String getJavaName_NOTLIKE() {
                    return javaName_NOTLIKE;
                }

                public void setJavaName_NOTLIKE(String javaName_NOTLIKE) {
                    this.javaName_NOTLIKE = javaName_NOTLIKE;
                }













            public Timestamp getCreateTime() {
                return createTime;
            }


            public void setCreateTime(Timestamp createTime) {
                this.createTime = createTime;
            }


            public Timestamp getCreateTime_NE() {
                return createTime_NE;
            }


            public void setCreateTime_NE(Timestamp createTime_NE) {
                this.createTime_NE = createTime_NE;
            }



            public Timestamp getCreateTime_GT() {
                return createTime_GT;
            }


            public void setCreateTime_GT(Timestamp createTime_GT) {
                this.createTime_GT = createTime_GT;
            }


            public Timestamp getCreateTime_GE() {
                return createTime_GE;
            }


            public void setCreateTime_GE(Timestamp createTime_GE) {
                this.createTime_GE = createTime_GE;
            }




            public Timestamp getCreateTime_LT() {
                return createTime_LT;
            }


            public void setCreateTime_LT(Timestamp createTime_LT) {
                this.createTime_LT = createTime_LT;
            }


            public Timestamp getCreateTime_LE() {
                return createTime_LE;
            }


            public void setCreateTime_LE(Timestamp createTime_LE) {
                this.createTime_LE = createTime_LE;
            }













                public PK getCreateUserId() {
                    return createUserId;
                }


                public void setCreateUserId(PK createUserId) {
                    this.createUserId = createUserId;
                }


                public PK getCreateUserId_NE() {
                return createUserId_NE;
                }


                public void setCreateUserId_NE(PK createUserId_NE) {
                this.createUserId_NE = createUserId_NE;
                }








                public PK getCreateUserId_IN() {
                    return createUserId_IN;
                }

                public void setCreateUserId_IN(PK createUserId_IN) {
                    this.createUserId_IN = createUserId_IN;
                }

                public PK getCreateUserId_NOTIN() {
                    return createUserId_NOTIN;
                }

                public void setCreateUserId_NOTIN(PK createUserId_NOTIN) {
                    this.createUserId_NOTIN = createUserId_NOTIN;
                }
















            public Timestamp getUpdateTime() {
                return updateTime;
            }


            public void setUpdateTime(Timestamp updateTime) {
                this.updateTime = updateTime;
            }


            public Timestamp getUpdateTime_NE() {
                return updateTime_NE;
            }


            public void setUpdateTime_NE(Timestamp updateTime_NE) {
                this.updateTime_NE = updateTime_NE;
            }



            public Timestamp getUpdateTime_GT() {
                return updateTime_GT;
            }


            public void setUpdateTime_GT(Timestamp updateTime_GT) {
                this.updateTime_GT = updateTime_GT;
            }


            public Timestamp getUpdateTime_GE() {
                return updateTime_GE;
            }


            public void setUpdateTime_GE(Timestamp updateTime_GE) {
                this.updateTime_GE = updateTime_GE;
            }




            public Timestamp getUpdateTime_LT() {
                return updateTime_LT;
            }


            public void setUpdateTime_LT(Timestamp updateTime_LT) {
                this.updateTime_LT = updateTime_LT;
            }


            public Timestamp getUpdateTime_LE() {
                return updateTime_LE;
            }


            public void setUpdateTime_LE(Timestamp updateTime_LE) {
                this.updateTime_LE = updateTime_LE;
            }













                public PK getUpdateUserId() {
                    return updateUserId;
                }


                public void setUpdateUserId(PK updateUserId) {
                    this.updateUserId = updateUserId;
                }


                public PK getUpdateUserId_NE() {
                return updateUserId_NE;
                }


                public void setUpdateUserId_NE(PK updateUserId_NE) {
                this.updateUserId_NE = updateUserId_NE;
                }








                public PK getUpdateUserId_IN() {
                    return updateUserId_IN;
                }

                public void setUpdateUserId_IN(PK updateUserId_IN) {
                    this.updateUserId_IN = updateUserId_IN;
                }

                public PK getUpdateUserId_NOTIN() {
                    return updateUserId_NOTIN;
                }

                public void setUpdateUserId_NOTIN(PK updateUserId_NOTIN) {
                    this.updateUserId_NOTIN = updateUserId_NOTIN;
                }















            public Integer getVersionNo() {
                return versionNo;
            }


            public void setVersionNo(Integer versionNo) {
                this.versionNo = versionNo;
            }


            public Integer getVersionNo_NE() {
                return versionNo_NE;
            }


            public void setVersionNo_NE(Integer versionNo_NE) {
                this.versionNo_NE = versionNo_NE;
            }



            public Integer getVersionNo_GT() {
                return versionNo_GT;
            }


            public void setVersionNo_GT(Integer versionNo_GT) {
                this.versionNo_GT = versionNo_GT;
            }


            public Integer getVersionNo_GE() {
                return versionNo_GE;
            }


            public void setVersionNo_GE(Integer versionNo_GE) {
                this.versionNo_GE = versionNo_GE;
            }




            public Integer getVersionNo_LT() {
                return versionNo_LT;
            }


            public void setVersionNo_LT(Integer versionNo_LT) {
                this.versionNo_LT = versionNo_LT;
            }


            public Integer getVersionNo_LE() {
                return versionNo_LE;
            }


            public void setVersionNo_LE(Integer versionNo_LE) {
                this.versionNo_LE = versionNo_LE;
            }







	
}