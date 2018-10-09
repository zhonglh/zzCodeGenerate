package ${table.fullPackageName}.${templet.fileInnerPackage};


import com.fullbloom.db.mybatis.entity.BaseBusinessEntity;
import com.fullbloom.core.annotations.log.*;
import com.fullbloom.source.component.files.domain.TsFiles;
<#list table.importClasss as importClass>
import ${importClass};
</#list>


<#list fkTables as being>
import ${being.fullPackageName}.domain.${being.javaName};
</#list>


import java.util.List;

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



<#list columnPages as being>
    <#if being.element == 'singlefile' || being.element == 'multifile' >
    private List<TsFiles>  ${being.javaName}List ;
    </#if>
</#list>


    <#list columnPages as page>
    <#if page.exColumn?exists>
    @EntityAttrAnnotation(attrName="${page.exColumn.columnTitle}",sort=${page.exColumn.columnSort})
    private ${page.exColumn.javaSimpleClass} ${page.exColumn.javaName} ;

    </#if>
    </#list>


<#list fkTables as fkTable>
    private ${fkTable.javaName}  ${fkTable.javaName?uncap_first} ;
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





    <#list columnPages as being>
    <#if being.element == 'singlefile' || being.element == 'multifile' >
    public void set${being.javaName?cap_first}List(List<TsFiles> ${being.javaName}List){
        this.${being.javaName}List = ${being.javaName}List;
    }

    public List<TsFiles> get${being.javaName?cap_first}List(){
        return this.${being.javaName}List;
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


<#list fkTables as fkTable>
    public void set${fkTable.javaName?cap_first}(${fkTable.javaName?cap_first} ${fkTable.javaName?uncap_first}){
        this.${fkTable.javaName?uncap_first} = ${fkTable.javaName?uncap_first};
    }

    public ${fkTable.javaName?cap_first} get${fkTable.javaName?cap_first}(){
        return this.${fkTable.javaName?uncap_first};
    }
</#list>
	
}