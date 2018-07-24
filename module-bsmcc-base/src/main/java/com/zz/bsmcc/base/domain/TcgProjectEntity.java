package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
* 项目管理实体类
*
* @author Administrator
* @date 2018-7-24 10:20:10
*/
@EntityAnnotation(value="项目管理" , resource = "")
@TableName(value="tcg_project" , resultMap = "TcgProjectResultMap")
public class TcgProjectEntity extends BaseBusinessExEntity<String> implements java.io.Serializable{
private static final long serialVersionUID = 1L;





        //@EntityAttrAnnotation(attrName="项目名称",sort=1  , attrLength=20    )
        private String projectName;





        //@EntityAttrAnnotation(attrName="项目说明",sort=2  , attrLength=200    )
        private String projectRemark;





        //@EntityAttrAnnotation(attrName="项目总包名",sort=3  , attrLength=100    )
        private String projectPackage;





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










        //@EntityAttrAnnotation(attrName="删除标志",sort=14  , attrLength=1    )
        private String deleteFlag;


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
        * 删除标志
        * @return the deleteFlag
        */
        public String getDeleteFlag() {
        return deleteFlag;
        }

        /**
        * 删除标志
        */
        public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
        }

}