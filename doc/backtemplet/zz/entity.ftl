package ${table.fullPackageName}.${templet.fileInnerPackage};


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.Constant;
<#list table.importClasss as importClass>
import ${importClass};
</#list>
<#if (table.isTable == '0' && table.mainTableIdConfig?exists)>
import ${table.fullPackageName}.domain.${table.mainTableIdConfig.javaName}Entity;
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
public class ${table.javaName}Entity extends <#if (table.isTable == '0' && table.mainTableIdConfig?exists)>${table.mainTableIdConfig.javaName}Entity<#else>${table.parentClass}<String></#if> implements java.io.Serializable{

    @TableField(exist=false)
    private static final long serialVersionUID = 1L;

<#list columns as being>
<#if !being.inParentClass>
	//${being.columnComment}
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