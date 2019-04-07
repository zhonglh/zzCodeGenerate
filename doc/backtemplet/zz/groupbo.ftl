package ${table.fullPackageName}.${templet.fileInnerPackage};
import com.zz.bms.util.configs.annotaions.GroupFieldAnnotation;


<#list table.pageChildTables as childTable>
import ${childTable.fullBoClassName} ;
</#list>

import java.io.Serializable;
import java.util.List;



/**
* ${table.javaName}Group BO , 扩展 ${table.tableComment} BO 对象
* ${table.tableComment} 数据传输对象，对应界面中的所有元素
* 注意： 对象属性需要和 ${table.javaName}GroupServiceImpl.getServices 对应
* @author ${project.projectAuthor}
* @author ${project.projectAuthor}
* @date ${.now}
*/
@EntityAnnotation(value="${table.tableComment}" , resource = "${table.fullResource}" <#if table.businessName?exists> ,businessName = "${table.businessName}"</#if>   <#if table.businessName?exists> ,businessKey = { "${table.businessKey}" }</#if>   <#if table.isTree?exists && table.isTree == '1'>,parentColumnName="${table.parentFieldName!}" ,textColumnName="${table.businessName!}" ,</#if> )
@TableName(value="${table.tableName}" , resultMap = "${table.javaName}ResultMap")
public class ${table.javaName}BO extends ${table.javaName}BO implements Serializable {

    <#list table.pageChildColumns as childColumn>

    @GroupFieldAnnotation(childTableColumnName = "${childColumn.columnName}" , filedName = "${childColumn.columnComment}")
    <#if childColumn.fkTableConfig.tableRelation?exists && 'one-one' == childColumn.fkTableConfig.tableRelation>
        ${childColumn.fkTableConfig.javaName}BO ${childColumn.fkTableConfig.simpleName?uncap_first}BO ;
    <#else >
        List<${childColumn.fkTableConfig.javaName}BO> ${childColumn.fkTableConfig.simpleName?uncap_first}BOList ;
    </#if>
    </#list>


    <#list table.pageChildColumns as childColumn>
    <#if childColumn.fkTableConfig.tableRelation?exists && 'one-one' == childColumn.fkTableConfig.tableRelation>
        public ${childColumn.fkTableConfig.javaName}BO get${childColumn.fkTableConfig.simpleName?cap_first}BO(){
            return ${childColumn.fkTableConfig.simpleName?uncap_first}BO ;
        }
        public void set${childColumn.fkTableConfig.simpleName?cap_first}BO(${childColumn.fkTableConfig.javaName}BO ${childColumn.fkTableConfig.simpleName?uncap_first}BO ){
             this.${childColumn.fkTableConfig.simpleName?uncap_first}BO = ${childColumn.fkTableConfig.simpleName?uncap_first}BO;
        }
    <#else >
        public List<${childColumn.fkTableConfig.javaName}BO>  get${childColumn.fkTableConfig.simpleName?cap_first}BOList(){
            return ${childColumn.fkTableConfig.simpleName?uncap_first}BOList ;
        }
        public void set${childColumn.fkTableConfig.simpleName?cap_first}BOList(List<${childColumn.fkTableConfig.javaName}BO> ${childColumn.fkTableConfig.simpleName?uncap_first}BOList ){
            this.${childColumn.fkTableConfig.simpleName?uncap_first}BOList = ${childColumn.fkTableConfig.simpleName?uncap_first}BOList;
        }
    </#if>
    </#list>


    @Override
    public String toString() {
        return super.toString();
    }
}
