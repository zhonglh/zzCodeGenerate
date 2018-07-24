package ${table.basePackage}.domain;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * ${table.tableComments} 用于装载用户在查询时提交的数据
 * 链式查询
 * @author ${table.author}
 * @date ${.now}
 */
public class ${table.shortTableName?cap_first}QueryWebImpl<PK extends Serializable> extends ${table.shortTableName?cap_first}AbstractQueryImpl<PK> {

<#list table.columnList as being>




	<#if being.columnType=="char" || being.columnType=="varchar2" || being.columnType=="varchar" || being.columnType=="longtext">

		<#if being.shortColumnName == "id" ||  being.columnPrecision == "32" || being.columnPrecision == "36" || being.columnPrecision == "64">


            private PK ${being.shortColumnName}__IN;
            private PK ${being.shortColumnName}__NOTIN;
		<#elseif being.columnPrecision == "1" || being.columnPrecision == "2" >


            private String ${being.shortColumnName}__IN;
            private String ${being.shortColumnName}__NOTIN;

		<#else>

            private String ${being.shortColumnName}__IN;
            private String ${being.shortColumnName}__NOTIN;
		</#if>

	<#else>
        ;
	</#if>



</#list>











<#list table.columnList as being>




        <#if being.columnType=="char" || being.columnType=="varchar2" || being.columnType=="varchar" || being.columnType=="longtext">

            <#if being.shortColumnName == "id" ||  being.columnPrecision == "32" || being.columnPrecision == "36" || being.columnPrecision == "64">

                public PK get${being.shortColumnName?cap_first}_IN() {
                return ${being.shortColumnName}_IN;
                }

                public void set${being.shortColumnName?cap_first}_IN(PK ${being.shortColumnName}_IN) {
                this.${being.shortColumnName}_IN = ${being.shortColumnName}_IN;
                }

                public PK get${being.shortColumnName?cap_first}_NOTIN() {
                return ${being.shortColumnName}NOTIN;
                }

                public void set${being.shortColumnName?cap_first}_NOTIN(PK ${being.shortColumnName}_NOTIN) {
                this.${being.shortColumnName}_NOTIN = ${being.shortColumnName}_NOTIN;
                }

            <#elseif being.columnPrecision == "1" || being.columnPrecision == "2" >
                public String get${being.shortColumnName?cap_first}_IN() {
                    return ${being.shortColumnName}_IN;
                }

                public void set${being.shortColumnName?cap_first}_IN(String ${being.shortColumnName}_IN) {
                    this.${being.shortColumnName}_IN = ${being.shortColumnName}_IN;
                }

                public String get${being.shortColumnName?cap_first}_NOTIN() {
                    return ${being.shortColumnName}NOTIN;
                }

                public void set${being.shortColumnName?cap_first}_NOTIN(String ${being.shortColumnName}_NOTIN) {
                    this.${being.shortColumnName}_NOTIN = ${being.shortColumnName}_NOTIN;
                }

            <#else>
                public String get${being.shortColumnName?cap_first}_IN() {
                return ${being.shortColumnName}_IN;
                }

                public void set${being.shortColumnName?cap_first}_IN(String ${being.shortColumnName}_IN) {
                this.${being.shortColumnName}_IN = ${being.shortColumnName}_IN;
                }

                public String get${being.shortColumnName?cap_first}_NOTIN() {
                return ${being.shortColumnName}NOTIN;
                }

                public void set${being.shortColumnName?cap_first}_NOTIN(String ${being.shortColumnName}_NOTIN) {
                this.${being.shortColumnName}_NOTIN = ${being.shortColumnName}_NOTIN;
                }
            </#if>




        <#else>
            ;
        </#if>



</#list>

	
}