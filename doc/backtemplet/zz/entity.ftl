package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.Constant;
<#list table.importClasss as importClass>
import ${importClass};
</#list>
<#if (table.isTable == '0' && table.mainTableConfig?exists)>
import ${table.fullPackageName}.domain.${table.mainTableConfig.javaName}Entity;
<#else >
import ${table.parentClass};
</#if>
/**
 * ${table.tableComment} 实体类
<#if table.tableOtherComment ? exists>
 * ${table.tableOtherComment}
</#if>
 * @author ${project.projectAuthor}
 * @date ${.now}
 */
public class ${table.javaName}Entity extends <#if (table.isTable == '0' && table.mainTableConfig?exists)>${table.mainTableConfig.javaName}Entity<#else>${table.parentClass}<String></#if> implements java.io.Serializable{

    @TableField(exist=false)
    private static final long serialVersionUID = 1L;

<#list columns as being>
<#if !being.inParentClass>
    <#assign columnPage = columnPageMap[being.id] >


    <#if being.columnIsdict == '1'>
    @EntityAttrDictAnnotation(group = "${being.javaName}", groupName = "${being.columnComment}" ,  dbColumnName = "dict_val" , dbColumnLength = 2 , isValueField = true , dictType = "${being.dictType}")
    <#elseif being.columnIsfk == '1' >
    @EntityAttrFkAnnotation(group = "${being.javaName}",  groupName = "${being.columnComment}" ,   dbColumnName = "id" , dbColumnType = CHAR" , dbColumnLength = 32   , dbColumnNotNull = true , fkClass=${being.fkTableConfig.fullBoClassName!}.class)
    </#if>
    @EntityAttrDBAnnotation(attrName="${being.columnComment}" ,type = "${being.columnType}"      <#if being.columnLength?exists>,  attrLength = ${being.columnLength}</#if> , notNull = <#if being.columnIsnull?exists && being.columnIsnull == '0'>true<#else>false</#if> )
    @EntityAttrPageAnnotation(title = "${columnPage.columnComment}",sort = ${being.columnSort}  , pageElement = "${columnPage.element}"    <#if columnPage.max?exists && columnPage.max != 0> , maxLength = ${columnPage.max} </#if>     <#if columnPage.min?exists>, minLength = ${columnPage.min} </#if>  <#if columnPage.maxlength?exists && columnPage.maxlength != 0> , maxLength = ${columnPage.maxlength} </#if>     <#if columnPage.minlength?exists>, minLength = ${columnPage.minlength} </#if>  <#if columnPage.defaultType?exists && columnPage.defaultType != 'CUSTOM' && columnPage.defaultType != ''>, defaultType = DefaultTypeConstant.${columnPage.defaultType}</#if>,required=<#if columnPage.required?exists && columnPage.required == '1'>true<#else>false</#if> )
	<#if columnPage.excelType?exists && columnPage.excelType!='0'>@EntityAttrExcelAnnotation(excelProcess= "${columnPage.excelType}")</#if>
    <#if table.isTable=='0'>//todo 如果需要Excel导入 请先设置外键信息 EntityAttrFkAnnotation ， 参考 VsUserEntity </#if>
    <#if being.columnOtherComment?exists>//${being.columnOtherComment}</#if>
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