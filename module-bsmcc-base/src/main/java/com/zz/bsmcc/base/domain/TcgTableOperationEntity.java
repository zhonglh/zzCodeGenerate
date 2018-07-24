package com.zz.bsmcc.base.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
* 表操作定义实体类
*
* @author Administrator
* @date 2018-7-24 10:20:10
*/
@EntityAnnotation(value="表操作定义" , resource = "")
@TableName(value="tcg_table_operation" , resultMap = "TcgTableOperationResultMap")
public class TcgTableOperationEntity extends BaseEntity<String> implements java.io.Serializable{
    private static final long serialVersionUID = 1L;





            //@EntityAttrAnnotation(attrName="操作",sort=1  , attrLength=32    )
            private String operationId;





            //@EntityAttrAnnotation(attrName="表",sort=2  , attrLength=32    )
            private String tableId;


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
            * 表
            * @return the tableId
            */
            public String getTableId() {
            return tableId;
            }

            /**
            * 表
            */
            public void setTableId(String tableId) {
            this.tableId = tableId;
            }

    }