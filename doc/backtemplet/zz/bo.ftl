package ${table.fullPackageName}.${templet.fileInnerPackage};

import ${table.fullPackageName}.domain.${table.javaName}Entity;

import com.baomidou.mybatisplus.annotation.TableField;

import com.zz.bms.core.db.entity.IBoEntity;
import com.zz.bms.util.configs.annotaions.*;
import com.zz.bms.constants.DefaultTypeConstant;
import com.zz.bms.constants.DictTypeConstant;
import com.zz.bms.constants.ExcelTypeConstant;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;



/**
* ${table.tableComment} BO , 扩展 ${table.javaName}Entity 对象
* @author ${project.projectAuthor}
* @date ${.now}
*/
@EntityAnnotation(value="${table.tableComment}" , resource = "${table.fullResourceName}" <#if table.businessName?exists> ,businessName = "${table.businessName}"</#if>   <#if table.businessName?exists> ,businessKey = { "${table.businessKey}" }</#if>  )
@TableName(value="${table.tableName}" , resultMap = "${table.javaName}ResultMap")
public class ${table.javaName}BO extends ${table.javaName}Entity implements Serializable , IBoEntity {

<#list exColumns as being>


    <#assign columnPage = columnPageMap[being.id] >

    @TableField(exist = false)
    <#if being.originalColumn.columnIsdict == '1'>
    @EntityAttrDictAnnotation(group = "userStatus", groupName = "用户状态" ,  dbColumnName = "dict_name" , dbColumnLength = 50 , isNameField = true , dictType = DictTypeConstant.USER_STATUS)
    </#if>
    @EntityAttrExcelAnnotation(excelProcess= ExcelTypeConstant.ONLY_EXPORT)
    @EntityAttrPageAnnotation(title = "用户状态" , sort = 501 , required = true, defaultType = DefaultTypeConstant.CUSTOM , defaultValue = "EnumUserStatus.normal.getLabel()")

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


    @Override
    public boolean isTable() {
        return <#if table.isTable?exists && table.isTable == '1'>true<#else >false</#if>;
    }


    @Override
    public String toString() {

        <#if table.businessNameGetMethods?exists && table.businessNameGetMethods?size  == 1>
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

    }
}
