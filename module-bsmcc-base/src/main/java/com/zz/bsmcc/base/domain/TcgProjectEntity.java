package com.zz.bsmcc.base.domain;



import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
* 项目管理实体类
*
* @author Administrator
* @date 2018-7-30 10:54:37
*/
public class TcgProjectEntity extends BaseBusinessEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





        //@EntityAttrAnnotation(attrName="项目名称",sort=1  , attrLength=20    )
        private String projectName;





        //@EntityAttrAnnotation(attrName="项目说明",sort=2  , attrLength=200    )
        private String projectRemark;





        //@EntityAttrAnnotation(attrName="项目总包名",sort=3  , attrLength=100    )
        private String projectPackage;



        private String packageIncludeModule;





        //@EntityAttrAnnotation(attrName="项目经理",sort=4  , attrLength=50    )
        private String projectLead;





        //@EntityAttrAnnotation(attrName="作者",sort=5  , attrLength=100    )
            //用于注释  
        private String projectAuthor;





        //@EntityAttrAnnotation(attrName="总的代码注释",sort=6  , attrLength=500    )
        private String projectNote;





        //@EntityAttrAnnotation(attrName="是否国际化",sort=7  , attrLength=1    )
        private String projectI18n;


        //@EntityAttrAnnotation(attrName="是否有租户模式",sort=8  , attrLength=1    )
        private String projectTenant;



        //@EntityAttrAnnotation(attrName="是否有机构",sort=8  , attrLength=1    )
        private String projectOrgan;


        //@EntityAttrAnnotation(attrName="查询条件模式",sort=9  , attrLength=20    )
            //toolbar      工具栏样式，尽量在一行  ordinary    普通模式， 一个条件一行 ， 最后是关键字查询  
        private String queryMode;

        //@EntityAttrAnnotation(attrName="界面使用视图",sort=10  , attrLength=1    )
        //每个界面都用视图一一对应
        private String pageUseView;

        //是否自动创建扩展列
        private String autoExColumn;

        //是否有多个Schema
        private String isMultiSchema ;

        //Schema 名称
        private String otherSchema;

        /**
        * 项目名称
        * @return the projectName
        */
        public String getProjectName() {
        return projectName;
        }

        /**
        * 项目名称
        */
        public void setProjectName(String projectName) {
        this.projectName = projectName;
        }
        /**
        * 项目说明
        * @return the projectRemark
        */
        public String getProjectRemark() {
        return projectRemark;
        }

        /**
        * 项目说明
        */
        public void setProjectRemark(String projectRemark) {
        this.projectRemark = projectRemark;
        }
        /**
        * 项目总包名
        * @return the projectPackage
        */
        public String getProjectPackage() {
            return projectPackage;
        }

        /**
        * 项目总包名
        */
        public void setProjectPackage(String projectPackage) {
        this.projectPackage = projectPackage;
        }

        public String getPackageIncludeModule() {
            return packageIncludeModule;
        }

        public void setPackageIncludeModule(String packageIncludeModule) {
            this.packageIncludeModule = packageIncludeModule;
        }

    /**
        * 项目经理
        * @return the projectLead
        */
        public String getProjectLead() {
        return projectLead;
        }

        /**
        * 项目经理
        */
        public void setProjectLead(String projectLead) {
        this.projectLead = projectLead;
        }
        /**
        * 作者
        * @return the projectAuthor
        */
        public String getProjectAuthor() {
        return projectAuthor;
        }

        /**
        * 作者
        */
        public void setProjectAuthor(String projectAuthor) {
        this.projectAuthor = projectAuthor;
        }
        /**
        * 总的代码注释
        * @return the projectNote
        */
        public String getProjectNote() {
        return projectNote;
        }

        /**
        * 总的代码注释
        */
        public void setProjectNote(String projectNote) {
        this.projectNote = projectNote;
        }
        /**
        * 是否国际化
        * @return the projectI18n
        */
        public String getProjectI18n() {
        return projectI18n;
        }

        /**
        * 是否国际化
        */
        public void setProjectI18n(String projectI18n) {
        this.projectI18n = projectI18n;
        }
        /**
        * 是否有租户模式
        * @return the projectTenant
        */
        public String getProjectTenant() {
        return projectTenant;
        }

        /**
        * 是否有租户模式
        */
        public void setProjectTenant(String projectTenant) {
        this.projectTenant = projectTenant;
        }

        /**
         * 是否有机构
         * @return
         */
        public String getProjectOrgan() {
                return projectOrgan;
            }

            public void setProjectOrgan(String projectOrgan) {
                this.projectOrgan = projectOrgan;
            }

    /**
        * 查询条件模式
        * @return the queryMode
        */
        public String getQueryMode() {
        return queryMode;
        }

        /**
        * 查询条件模式
        */
        public void setQueryMode(String queryMode) {
        this.queryMode = queryMode;
        }

        public String getPageUseView() {
            return pageUseView;
        }

        public void setPageUseView(String pageUseView) {
            this.pageUseView = pageUseView;
        }

        public String getAutoExColumn() {
            return autoExColumn;
        }

        public void setAutoExColumn(String autoExColumn) {
            this.autoExColumn = autoExColumn;
        }


        public String getIsMultiSchema() {
            return isMultiSchema;
        }

        public void setIsMultiSchema(String isMultiSchema) {
            this.isMultiSchema = isMultiSchema;
        }

        public String getOtherSchema() {
            return otherSchema;
        }

        public void setOtherSchema(String otherSchema) {
            this.otherSchema = otherSchema;
        }
}