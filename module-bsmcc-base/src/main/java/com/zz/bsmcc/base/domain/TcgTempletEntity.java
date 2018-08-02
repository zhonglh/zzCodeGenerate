package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;

/**
* 模板实体类
*
* @author Administrator
* @date 2018-7-29 1:16:15
*/
public class TcgTempletEntity extends BaseBusinessEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





        //@EntityAttrAnnotation(attrName="模板组",sort=1  , attrLength=32    )
        private String groupId;





        //@EntityAttrAnnotation(attrName="文件类型",sort=2  , attrLength=10    )
            //如 jsp , js ,vue ,java等  
        private String fileType;





        //@EntityAttrAnnotation(attrName="模板标题",sort=3  , attrLength=50    )
        private String templetTitle;





        //@EntityAttrAnnotation(attrName="模板所在文件夹",sort=4  , attrLength=100    )
        private String templetDir;





        //@EntityAttrAnnotation(attrName="模板内容",sort=5  , attrLength=5000    )
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
        * 文件类型
        * @return the fileType
        */
        public String getFileType() {
        return fileType;
        }

        /**
        * 文件类型
        */
        public void setFileType(String fileType) {
        this.fileType = fileType;
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
        * 模板所在文件夹
        * @return the templetDir
        */
        public String getTempletDir() {
        return templetDir;
        }

        /**
        * 模板所在文件夹
        */
        public void setTempletDir(String templetDir) {
        this.templetDir = templetDir;
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