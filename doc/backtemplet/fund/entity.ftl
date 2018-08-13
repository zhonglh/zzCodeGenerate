package ${table.fullPackageName}.${templet.fileInnerPackage};


import com.fullbloom.db.mybatis.entity.BaseBusinessEntity;
import com.fullbloom.core.annotations.log.*;
import ${table.parentClass};
<#list table.importClasss as importClass>
import ${importClass};
</#list>

/**
 * ${table.tableComment} 实体类
<#if table.tableOtherComment ? exists>
 * ${table.tableOtherComment}
</#if>
 * @author ${project.projectAuthor}
 * @date ${.now}
 */
public class ${table.javaName} extends ${table.parentClass} implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

<#list columns as being>
<#if !being.inParentClass>
	//${being.columnComment}
	<#if being.columnOtherComment?exists>//${being.columnOtherComment}</#if>
    @EntityAttrAnnotation(attrName="${being.columnComment}",sort=${being.columnSort},<#if being.columnLength?exists && being.columnLength != 0 >attrLength=${being.columnLength}</#if><#if being.columnScale?exists && being.columnScale != 0 >,attr_decimals=${being.columnScale}</#if>)
    private ${being.javaSimpleClass}  ${being.javaName} ;

</#if>
</#list>




<#list columns as being>
<#if !being.inParentClass>
	public void ${being.setMethodName}(${being.javaSimpleClass} ${being.javaName}){
		this.${being.javaName} = ${being.javaName};
	}

    public ${being.javaSimpleClass} ${being.getMethodName}(){
    	return this.${being.javaName};
    }


 </#if>
</#list>
	
}