package com.zz.bsmcc.base.domain;


import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotations.TableField;

/**
* 模板组操作定义实体类
*
* @author Administrator
* @date 2018-7-29 1:16:15
*/
public class TcgTempletGropOperationEntity extends BaseEntity<String> implements java.io.Serializable{
    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





            //@EntityAttrAnnotation(attrName="模板组",sort=1  , attrLength=32    )
            private String groupId;





            //@EntityAttrAnnotation(attrName="操作",sort=2  , attrLength=32    )
            private String operationId;





            //@EntityAttrAnnotation(attrName="图标",sort=3  , attrLength=100    )
            private String icons;





            //@EntityAttrAnnotation(attrName="样式",sort=4  , attrLength=100    )
            private String styles;





            //@EntityAttrAnnotation(attrName="Class",sort=5  , attrLength=100    )
            private String classs;





            //@EntityAttrAnnotation(attrName="位置",sort=6  , attrLength=10    )
                //top     上面，    toolbar  right   右边，  操作列中  all      两个地方都有  
            private String position;


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
            * 操作
            * @return the operationId
            */
            public String getOperationId() {
            return operationId;
            }

            /**
            * 操作
            */
            public void setOperationId(String operationId) {
            this.operationId = operationId;
            }
            /**
            * 图标
            * @return the icons
            */
            public String getIcons() {
            return icons;
            }

            /**
            * 图标
            */
            public void setIcons(String icons) {
            this.icons = icons;
            }
            /**
            * 样式
            * @return the styles
            */
            public String getStyles() {
            return styles;
            }

            /**
            * 样式
            */
            public void setStyles(String styles) {
            this.styles = styles;
            }
            /**
            * Class
            * @return the classs
            */
            public String getClasss() {
            return classs;
            }

            /**
            * Class
            */
            public void setClasss(String classs) {
            this.classs = classs;
            }
            /**
            * 位置
            * @return the position
            */
            public String getPosition() {
            return position;
            }

            /**
            * 位置
            */
            public void setPosition(String position) {
            this.position = position;
            }

    }