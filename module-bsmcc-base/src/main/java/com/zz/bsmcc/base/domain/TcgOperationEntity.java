package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
* 操作表实体类
*
* @author Administrator
* @date 2018-7-24 14:42:52
*/
public class TcgOperationEntity extends BaseBusinessExEntity<String> implements java.io.Serializable{






        //@EntityAttrAnnotation(attrName="操作名称",sort=1  , attrLength=50    )
        private String operationName;





        //@EntityAttrAnnotation(attrName="操作资源名",sort=2  , attrLength=50    )
        private String operationResource;










        //@EntityAttrAnnotation(attrName="删除标志",sort=8  , attrLength=1    )
        private String deleteFlag;


        /**
        * 操作名称
        * @return the operationName
        */
        public String getOperationName() {
        return operationName;
        }

        /**
        * 操作名称
        */
        public void setOperationName(String operationName) {
        this.operationName = operationName;
        }
        /**
        * 操作资源名
        * @return the operationResource
        */
        public String getOperationResource() {
        return operationResource;
        }

        /**
        * 操作资源名
        */
        public void setOperationResource(String operationResource) {
        this.operationResource = operationResource;
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