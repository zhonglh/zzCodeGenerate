package ${table.fullPackageName}.${templet.fileInnerDir};


import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;
import com.zz.bms.annotaions.EntityAttrDBAnnotation;
import com.zz.bms.core.Constant;
import ${table.parentClass};
<#list table.importClsss as importClss>
import ${importClss};
</#list>

/**
 * ${table.tableComment} 实体类
 * ${table.tableOtherComment}
 * @author ${project.projectAuthor}
 * @date ${.now}
 */
public class ${table.javaName}Entity extends ${table.parentClass}<String> implements java.io.Serializable{

    @TableField(exist=false)
    private static final long serialVersionUID = 1L;

<#list columns as being>
<#if !being.isInParentClass>

	//${being.columnComment}
	<#if being.columnOtherComment?length gt 0>//${being.columnOtherComment}</#if>
	private ${being.javaSimpleClass}  ${being.javaName} ;


</#if>
</#list>




<#list columns as being>
<#if !being.isInParentClass>

	public void ${being.setMethodName}(${being.javaSimpleClass} ${being.javaName}){
		this.${being.javaName} = ${being.javaName};
	}


    public void ${being.getMethodName}(){
    	return this.${being.javaName};
    }


 </#if>
</#list>
	
}