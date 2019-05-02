package ${table.fullPackageName}.${templet.fileInnerPackage};

import ${table.fullPackageName}.domain.${table.javaName}Entity;

import com.baomidou.mybatisplus.annotation.TableField;


<#if table.isTree == '1'>
import com.zz.bms.core.ui.easyui.EasyUiTree;
</#if>

import com.zz.bms.core.db.entity.IBoEntity;
import com.zz.bms.util.configs.annotaions.*;
import com.zz.bms.constants.DefaultTypeConstant;
import com.zz.bms.constants.DictTypeConstant;
import com.zz.bms.constants.ExcelTypeConstant;
import com.baomidou.mybatisplus.annotation.TableName;

<#if (table.isTable == '0' && table.mainTableConfig?exists)>
import ${table.mainTableConfig.fullPackageName}.bo.${table.mainTableConfig.javaName}BO;
</#if>

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;



/**
* ${table.tableComment} BO , 扩展 <#if (table.isTable == '0' && table.mainTableConfig?exists)>${table.mainTableConfig.javaName}BO<#else>${table.javaName}Entity</#if> 对象
* @author ${project.projectAuthor}
* @date ${.now}
*/
@EntityAnnotation(value="${table.tableComment}" , resource = "${table.fullResource}" <#if table.haveTenant> ,haveTenant = true</#if> <#if table.haveOrgan> ,haveOrgan = true</#if> <#if table.businessName?exists> ,businessName = "${table.businessName}"</#if>   <#if table.businessName?exists> ,businessKey = { "${table.businessKey}" }</#if>   <#if table.isTree?exists && table.isTree == '1'>,parentColumnName="${table.parentFieldName!}" ,textColumnName="${table.businessName!}" </#if> )
@TableName(value="${table.tableName}" , resultMap = "${table.javaName}ResultMap")
public class ${table.javaName}BO extends <#if (table.isTable == '0' && table.mainTableConfig?exists)>${table.mainTableConfig.javaName}BO<#else>${table.javaName}Entity</#if> implements Serializable , IBoEntity {


<#if (table.isTable == '1' || !table.mainTableConfig?exists)>
<#list exColumns as being>

    <#assign columnPage = columnPageMap[being.id] >

    @TableField(exist = false)
    <#if being.originalColumn.columnIsdict == '1'>
    @EntityAttrDictAnnotation(group = "${being.originalColumn.javaName}", groupName = "${being.originalColumn.columnComment}" ,  dbColumnName = "dict_name" , dbColumnLength = 50 , isNameField = true , dictType = "${being.originalColumn.dictType}")
    <#elseif being.fkColumn?exists>
    @EntityAttrFkAnnotation(group = "${being.originalColumn.javaName}",  groupName = "${being.originalColumn.columnComment}" ,   dbColumnName = "${being.fkColumnName!}" , dbColumnType = "${being.fkColumn.columnType!}" , dbColumnLength = ${being.fkColumn.columnLength!}   <#if being.fkColumn.columnIsnull?exists && being.fkColumn.columnIsnull == '0'>, dbColumnNotNull = true</#if> , fkClass=${being.originalColumn.fkTableConfig.fullBoClassName!}.class)
    </#if>
    <#if columnPage.excelType?exists && columnPage.excelType!='0'>@EntityAttrExcelAnnotation(excelProcess= "${columnPage.excelType}")</#if>
    @EntityAttrPageAnnotation(title = "${columnPage.columnComment}",sort = ${being.columnSort}     <#if columnPage.max?exists && columnPage.max != 0> , maxLength = ${columnPage.max} </#if>     <#if columnPage.min?exists>, minLength = ${columnPage.min} </#if>  <#if columnPage.maxlength?exists && columnPage.maxlength != 0> , maxLength = ${columnPage.maxlength} </#if>     <#if columnPage.minlength?exists>, minLength = ${columnPage.minlength} </#if>   <#if columnPage.defaultType?exists && columnPage.defaultType != 'CUSTOM' && columnPage.defaultType != ''>, defaultType = DefaultTypeConstant.${columnPage.defaultType}</#if>  ,required=<#if columnPage.required?exists && columnPage.required == '1'>true<#else>false</#if> )
    private ${being.javaSimpleClass} ${being.javaName} ;

</#list>


<#list exColumns as being>
    public void set${being.javaName?cap_first}(${being.javaSimpleClass} ${being.javaName}){
        this.${being.javaName} = ${being.javaName};
    }

    public ${being.javaSimpleClass} get${being.javaName?cap_first}(){
        return this.${being.javaName};
    }

</#list>


<#if table.isTree == '1'>

    public EasyUiTree toEasyUiTree(){
        EasyUiTree tree = new EasyUiTree();
        tree.setId(this.getId());
        tree.setPid(StringUtils.isEmpty(this.get${table.parentFieldNameCamelCase?cap_first}())? null : this.get${table.parentFieldNameCamelCase?cap_first}());
        tree.setText(this.get${table.businessNameCamelCase?cap_first}());
        Map<String,String> attributes = new HashMap<String,String>();
        tree.setAttributes(attributes);
        return tree;
    }

</#if>


</#if>

    @Override
    public boolean isTable() {

    <#if table.isTable == '1' >
        return <#if (table.isTable?exists && table.isTable == '1')>true<#else >false</#if>;
    </#if>

    <#if table.isTable == '0' >
        return false;
    </#if>

    }


    @Override
    public String toString() {

    <#if (table.isTable == '1' || !table.mainTableConfig?exists)>

        <#if  (table.businessNameGetMethods?exists && table.businessNameGetMethods?size  == 1)>
        <#list table.businessNameGetMethods as businessNameGetMethod>
            return this.${businessNameGetMethod}();
        </#list>
        <#elseif table.businessNameGetMethods?exists && table.businessNameGetMethods?size  > 1>
        StringBuilder sb  = new StringBuilder();
        <#list table.businessNameGetMethods as businessNameGetMethod>
        sb.append(this.${businessNameGetMethod}());
        </#list>
        return sb.toString();
        <#else >
        return super.toString();
        </#if>
    <#else >
        return super.toString();
    </#if>

    }
}
