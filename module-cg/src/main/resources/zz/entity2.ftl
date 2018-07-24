package ${table.basePackage}.domain;


import com.fullbloom.db.mybatis.entity.BaseBusinessExEntity;
import com.fullbloom.core.annotations.log.*;
<#list table.columnList as being>
<#if being.packageStr??>
import ${being.packageStr}.support.${being.enumClassName?cap_first};
</#if>
</#list>

<#list table.importEntity as being>
import ${being};
</#list>

/**
 * ${table.tableComments}实体类
 * 
 * @author ${table.author}
 * @date ${.now}
 */
public class ${table.shortTableName?cap_first} extends BaseBusinessExEntity {
	private static final long serialVersionUID = 1L;
<#assign seq = ["id", "createTime", "createUserId", "updateTime", "updateUserId","versionNo","deleteFlag"]>
<#list table.columnList as being>
<#if !seq?seq_contains(being.shortColumnName)>
	<#if being.isEnum>


    @EntityAttrAnnotation(attrName="${being.columnComments}",sort=${being_index}  , attrLength=${being.columnPrecision} <#if being.columnScale != "0" >  ,attr_decimals=${being.columnScale}</#if>   )
	<#if being.columnOtherComments?length gt 0>
	//${being.columnOtherComments}
	</#if>
	private ${being.enumClassName} ${being.shortColumnName};
 	<#else>




    @EntityAttrAnnotation(attrName="${being.columnComments}",sort=${being_index}  , attrLength=${being.columnPrecision} <#if being.columnScale != "0" >  ,attr_decimals=${being.columnScale}</#if>   )
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