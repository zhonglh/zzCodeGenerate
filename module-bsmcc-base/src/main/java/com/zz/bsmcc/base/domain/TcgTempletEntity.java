package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessSimpleExEntity;
import com.baomidou.mybatisplus.annotations.TableField;

/**
* 模板实体类
*
* @author Administrator
* @date 2018-8-5 9:44:37
*/
public class TcgTempletEntity extends BaseBusinessEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





        //@EntityAttrAnnotation(attrName="模板组",sort=1  , attrLength=32    )
        private String groupId;





        //@EntityAttrAnnotation(attrName="生成文件外部文件夹",sort=2  , attrLength=200    )
        private String fileOutDir;





        //@EntityAttrAnnotation(attrName="生成文件内部文件夹",sort=3  , attrLength=200    )
        private String fileInnerDir;





        //@EntityAttrAnnotation(attrName="生成文件的文件类型",sort=4  , attrLength=10    )
            //如 jsp , js ,vue ,java等  
        private String fileType;





        //@EntityAttrAnnotation(attrName="生成文件的后缀",sort=5  , attrLength=10    )
            //如 jsp , js ,vue ,java等  
        private String fileSuffix;





        //@EntityAttrAnnotation(attrName="模板标题",sort=6  , attrLength=50    )
        private String templetTitle;





        //@EntityAttrAnnotation(attrName="是否UI",sort=7  , attrLength=1    )
        private String isUi;





        //@EntityAttrAnnotation(attrName="模板内容",sort=8  , attrLength=5000    )
        private String templetContent;




        /**
        * 模板组
        * @return the groupId
        */
        public String getGroupId() {
        return groupId;
        }

        /**
        * 模板组
        */
        public void setGroupId(String groupId) {
        this.groupId = groupId;
        }
        /**
        * 生成文件外部文件夹
        * @return the fileOutDir
        */
        public String getFileOutDir() {
        return fileOutDir;
        }

        /**
        * 生成文件外部文件夹
        */
        public void setFileOutDir(String fileOutDir) {
        this.fileOutDir = fileOutDir;
        }
        /**
        * 生成文件内部文件夹
        * @return the fileInnerDir
        */
        public String getFileInnerDir() {
        return fileInnerDir;
        }

        /**
        * 生成文件内部文件夹
        */
        public void setFileInnerDir(String fileInnerDir) {
        this.fileInnerDir = fileInnerDir;
        }
        /**
        * 生成文件的文件类型
        * @return the fileType
        */
        public String getFileType() {
        return fileType;
        }

        /**
        * 生成文件的文件类型
        */
        public void setFileType(String fileType) {
        this.fileType = fileType;
        }
        /**
        * 生成文件的后缀
        * @return the fileSuffix
        */
        public String getFileSuffix() {
        return fileSuffix;
        }

        /**
        * 生成文件的后缀
        */
        public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
        }
        /**
        * 模板标题
        * @return the templetTitle
        */
        public String getTempletTitle() {
        return templetTitle;
        }

        /**
        * 模板标题
        */
        public void setTempletTitle(String templetTitle) {
        this.templetTitle = templetTitle;
        }
        /**
        * 是否UI
        * @return the isUi
        */
        public String getIsUi() {
        return isUi;
        }

        /**
        * 是否UI
        */
        public void setIsUi(String isUi) {
        this.isUi = isUi;
        }
        /**
        * 模板内容
        * @return the templetContent
        */
        public String getTempletContent() {
        return templetContent;
        }

        /**
        * 模板内容
        */
        public void setTempletContent(String templetContent) {
        this.templetContent = templetContent;
        }


}