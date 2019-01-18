package ${table.fullPackageName}.${templet.fileInnerPackage};

import ${table.fullPackageName}.domain.${table.javaName}Entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* ${table.tableComment} BO , 扩展 ${table.javaName}Entity 对象
* @author ${project.projectAuthor}
* @date ${.now}
*/
@EntityAnnotation(value="${table.tableComment}" , resource = "")
@TableName(value="${table.tableName}" , resultMap = "${table.javaName}ResultMap")
public class ${table.javaName}BO extends ${table.javaName}Entity implements Serializable {

<#list exColumns as being>

    @TableField(exist = false)
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
}
