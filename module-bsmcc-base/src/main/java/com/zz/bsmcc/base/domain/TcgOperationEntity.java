package com.zz.bsmcc.base.domain;



import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.db.entity.BaseBusinessSimpleExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
* 操作表实体类
*
* @author Administrator
* @date 2018-8-3 10:03:26
*/
public class TcgOperationEntity extends BaseBusinessEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





        //@EntityAttrAnnotation(attrName="操作名称",sort=1  , attrLength=50    )
        private String operationName;





        //@EntityAttrAnnotation(attrName="操作资源名",sort=2  , attrLength=50    )
        private String operationResource;





        //@EntityAttrAnnotation(attrName="是否默认操作",sort=3  , attrLength=1    )
        private String isDefault;


        //是否系统预设的
        private String isSystem;

        //选择模式
        //0: 不要去先选择数据  1: 必须选择一行数据， 2: 不少于选择一条数据
        private String selectMode;

        //操作模式
        //1: 弹框模式    2: 执行模式
        private String opMode;



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
        * 是否默认操作
        * @return the isDefault
        */
        public String getIsDefault() {
        return isDefault;
        }

        /**
        * 是否默认操作
        */
        public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
        }


        public String getIsSystem() {
            return isSystem;
        }

        public void setIsSystem(String isSystem) {
            this.isSystem = isSystem;
        }

        public String getSelectMode() {
            return selectMode;
        }

        public void setSelectMode(String selectMode) {
            this.selectMode = selectMode;
        }

        public String getOpMode() {
            return opMode;
        }

        public void setOpMode(String opMode) {
            this.opMode = opMode;
        }
}