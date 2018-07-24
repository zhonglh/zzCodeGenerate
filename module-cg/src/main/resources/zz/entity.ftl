package ${table.basePackage}.domain;


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;

/**
* ${table.tableComments}实体类
*
* @author ${table.author}
* @date ${.now}
*/
@EntityAnnotation(value="${table.tableComments}" , resource = "")
@TableName(value="${table.tableName}" , resultMap = "${table.shortTableName?cap_first}ResultMap")
public class ${table.shortTableName?cap_first}Entity extends BaseEntity<String> implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
<#assign seq = ["id", "createTime", "createUserId", "updateTime", "updateUserId","versionNo"]>
<#list table.columnList as being>
	<#if !seq?seq_contains(being.shortColumnName)>
		<#if being.isEnum>


            @EntityAttrAnnotation(attrName="${being.columnComments}",sort=${being_index}  , attrLength=${being.columnPrecision} <#if being.columnScale != "0" >  ,attr_decimals=${being.columnScale}</#if>   )
			<#if being.columnOtherComments?length gt 0>
                //${being.columnOtherComments}
			</#if>
            private ${being.enumClassName} ${being.shortColumnName};
		<#else>




            //@EntityAttrAnnotation(attrName="${being.columnComments}",sort=${being_index}  , attrLength=${being.columnPrecision} <#if being.columnScale != "0" >  ,attr_decimals=${being.columnScale}</#if>   )
			<#if being.columnOtherComments?length gt 0>
                //${being.columnOtherComments}
			</#if>
            private ${being.javaType} ${being.shortColumnName};
		</#if>
	</#if>

</#list>

<#list table.columnList as being>
	<#if !seq?seq_contains(being.shortColumnName)>
		<#if being.isEnum>
            /**
            * ${being.columnComments}
            * @return the ${being.shortColumnName}
            */
            public ${being.enumClassName} get${being.shortColumnName?cap_first}() {
            return ${being.shortColumnName};
            }

            /**
            * ${being.columnComments}
            */
            public void set${being.shortColumnName?cap_first}(${being.enumClassName} ${being.shortColumnName}) {
            this.${being.shortColumnName} = ${being.shortColumnName};
            }
		<#else>
            /**
            * ${being.columnComments}
            * @return the ${being.shortColumnName}
            */
            public ${being.javaType} get${being.shortColumnName?cap_first}() {
            return ${being.shortColumnName};
            }

            /**
            * ${being.columnComments}
            */
            public void set${being.shortColumnName?cap_first}(${being.javaType} ${being.shortColumnName}) {
            this.${being.shortColumnName} = ${being.shortColumnName};
            }
		</#if>
	</#if>
</#list>

    }