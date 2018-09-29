package ${table.fullPackageName}.${templet.fileInnerPackage};


import com.fullbloom.db.mybatis.entity.BaseBusinessEntity;
import com.fullbloom.core.annotations.log.*;
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

	<#if being.columnOtherComment?exists>//${being.columnOtherComment}</#if>
    @EntityAttrAnnotation(attrName="${being.columnComment}",sort=${being.columnSort}<#if being.columnIsnull?exists && being.columnIsnull == '0' >,notNull=true</#if><#if (being.dictType?exists && being.dictType?length >0) >,enumType="${being.dictType}"</#if><#if being.columnLength?exists && being.columnLength != 0 >,attrLength=${being.columnLength}</#if><#if being.columnScale?exists && being.columnScale != 0 >,attrDecimals=${being.columnScale}</#if>)
    private ${being.javaSimpleClass}  ${being.javaName} ;

</#if>
</#list>




    <#list columnPages as page>
    <#if page.exColumn?exists>
    @EntityAttrAnnotation(attrName="${page.exColumn.columnTitle}",sort=${page.exColumn.columnSort})
    private ${page.exColumn.javaSimpleClass} ${page.exColumn.javaName} ;

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






    <#list columnPages as page>
    <#if page.exColumn?exists>

    public void set${page.exColumn.javaName?cap_first}(${page.exColumn.javaSimpleClass} ${page.exColumn.javaName}){
        this.${page.exColumn.javaName} = ${page.exColumn.javaName};
    }

    public ${page.exColumn.javaSimpleClass} get${page.exColumn.javaName?cap_first}(){
        return this.${page.exColumn.javaName};
    }
    </#if>
    </#list>
	
}