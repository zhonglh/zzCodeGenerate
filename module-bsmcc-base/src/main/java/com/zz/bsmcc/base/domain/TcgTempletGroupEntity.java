package com.zz.bsmcc.base.domain;



import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessSimpleExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
* 模板组实体类
*
* @author Administrator
* @date 2018-8-2 12:09:03
*/
public class TcgTempletGroupEntity extends BaseBusinessEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





        //@EntityAttrAnnotation(attrName="模板组名称",sort=1  , attrLength=50    )
        private String groupName;





        //@EntityAttrAnnotation(attrName="模板说明",sort=2  , attrLength=500    )
        private String groupRemark;










        /**
        * 模板组名称
        * @return the groupName
        */
        public String getGroupName() {
        return groupName;
        }

        /**
        * 模板组名称
        */
        public void setGroupName(String groupName) {
        this.groupName = groupName;
        }
        /**
        * 模板说明
        * @return the groupRemark
        */
        public String getGroupRemark() {
        return groupRemark;
        }

        /**
        * 模板说明
        */
        public void setGroupRemark(String groupRemark) {
        this.groupRemark = groupRemark;
        }


}