package ${table.fullPackageName}.${templet.fileInnerPackage};
import com.zz.bms.util.configs.annotaions.GroupFieldAnnotation;


<#list table.pageChildTables as childTable>
import ${childTable.fullBoClassName} ;
</#list>

import java.io.Serializable;
import java.util.List;



/**
* ${table.javaName}Group BO , 扩展 ${table.javaName}BO 对象
* ${table.tableComment} 数据传输对象，对应界面中的所有元素
* 注意： 对象属性需要和 ${table.javaName}GroupServiceImpl.getServices 对应
* @author ${project.projectAuthor}
* @date ${.now}
*/
public class ${table.javaName}GroupBO extends ${table.javaName}BO implements Serializable {

    <#list table.pageChildColumns as childColumn>

    @GroupFieldAnnotation(childTableColumnName = "${childColumn.columnName}" , filedName = "${childColumn.tableBO.tableComment}")
    <#if childColumn.tableBO.tableRelation?exists && 'one-one' == childColumn.tableBO.tableRelation>
    ${childColumn.tableBO.javaName}BO ${childColumn.tableBO.simpleName?uncap_first}BO ;
    <#else >
    List<${childColumn.tableBO.javaName}BO> ${childColumn.tableBO.simpleName?uncap_first}BOList ;
    </#if>
    </#list>


    <#list table.pageChildColumns as childColumn>
    <#if childColumn.tableBO.tableRelation?exists && 'one-one' == childColumn.tableBO.tableRelation>
    public ${childColumn.tableBO.javaName}BO get${childColumn.tableBO.simpleName?cap_first}BO(){
        return ${childColumn.tableBO.simpleName?uncap_first}BO ;
    }
    public void set${childColumn.tableBO.simpleName?cap_first}BO(${childColumn.tableBO.javaName}BO ${childColumn.tableBO.simpleName?uncap_first}BO ){
         this.${childColumn.tableBO.simpleName?uncap_first}BO = ${childColumn.tableBO.simpleName?uncap_first}BO;
    }
    <#else >
    public List<${childColumn.tableBO.javaName}BO>  get${childColumn.tableBO.simpleName?cap_first}BOList(){
        return ${childColumn.tableBO.simpleName?uncap_first}BOList ;
    }
    public void set${childColumn.tableBO.simpleName?cap_first}BOList(List<${childColumn.tableBO.javaName}BO> ${childColumn.tableBO.simpleName?uncap_first}BOList ){
        this.${childColumn.tableBO.simpleName?uncap_first}BOList = ${childColumn.tableBO.simpleName?uncap_first}BOList;
    }
    </#if>
    </#list>


    @Override
    public String toString() {
        return super.toString();
    }
}
