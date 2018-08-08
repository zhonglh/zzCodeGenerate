package ${table.fullPackageName}.${templet.fileInnerPackage};


import java.io.Serializable;

<#list table.importClasss as importClass>
import ${importClass};
</#list>

/**
* ${table.tableComment} 用于装载用户在查询时提交的数据
* 用于链式查询
* @author ${project.projectAuthor}
* @date ${.now}
*/
public class ${table.javaName}QueryWebImpl<PK extends Serializable> extends ${table.javaName}AbstractQueryImpl<PK> implements Serializable {

<#list columns as being>

    <#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
        <#if being.columnIsfk == '1' || being.columnIskey == '1' >
            private PK ${being.javaName}_IN;
            private PK ${being.javaName}_NOTIN;

        <#elseif being.columnIsdict == "1"  >
            private String ${being.javaName}_IN;
            private String ${being.javaName}_NOTIN;

		<#else>

            private String ${being.javaName}_IN;
            private String ${being.javaName}_NOTIN;
		</#if>

	<#else>
        //todo 生成代码错误 , 数据库类型没有包括
        ${being.columnType};
	</#if>
</#list>



<#list columns as being>

    <#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
        <#if being.columnIsfk == '1' || being.columnIskey == '1' >
            public PK get${being.javaName?cap_first}() {
                return ${being.javaName};
            }

            public void set${being.javaName?cap_first}(PK ${being.javaName}) {
                this.${being.javaName} = ${being.javaName};
            }

            public PK get${being.javaName?cap_first}_NE() {
                return ${being.javaName}_NE;
            }

            public void set${being.javaName?cap_first}_NE(PK ${being.javaName}_NE) {
                this.${being.javaName}_NE = ${being.javaName}_NE;
            }

            public PK get${being.javaName?cap_first}_IN() {
                return ${being.javaName}_IN;
            }

            public void set${being.javaName?cap_first}_IN(PK ${being.javaName}_IN) {
                this.${being.javaName}_IN = ${being.javaName}_IN;
            }

            public PK get${being.javaName?cap_first}_NOTIN() {
                return ${being.javaName}_NOTIN;
            }

            public void set${being.javaName?cap_first}_NOTIN(PK ${being.javaName}_NOTIN) {
                this.${being.javaName}_NOTIN = ${being.javaName}_NOTIN;
            }

        <#elseif being.columnIsdict == "1"  >
            public String get${being.javaName?cap_first}() {
                return ${being.javaName};
            }

            public void set${being.javaName?cap_first}(String ${being.javaName}) {
                this.${being.javaName} = ${being.javaName};
            }

            public String get${being.javaName?cap_first}_NE() {
                return ${being.javaName}_NE;
            }

            public void set${being.javaName?cap_first}_NE(String ${being.javaName}_NE) {
                this.${being.javaName}_NE = ${being.javaName}_NE;
            }

            public String get${being.javaName?cap_first}_IN() {
                return ${being.javaName}_IN;
            }

            public void set${being.javaName?cap_first}_IN(String ${being.javaName}_IN) {
                this.${being.javaName}_IN = ${being.javaName}_IN;
            }

            public String get${being.javaName?cap_first}_NOTIN() {
                return ${being.javaName}_NOTIN;
            }

            public void set${being.javaName?cap_first}_NOTIN(String ${being.javaName}_NOTIN) {
                this.${being.javaName}_NOTIN = ${being.javaName}_NOTIN;
            }

            <#else>

            public String get${being.javaName?cap_first}() {
                return ${being.javaName};
            }

            public void set${being.javaName?cap_first}(String ${being.javaName}) {
                this.${being.javaName} = ${being.javaName};
            }

            public String get${being.javaName?cap_first}_NE() {
                return ${being.javaName}_NE;
            }

            public void set${being.javaName?cap_first}_NE(String ${being.javaName}_NE) {
                this.${being.javaName}_NE = ${being.javaName}_NE;
            }

            public String get${being.javaName?cap_first}_IN() {
                return ${being.javaName}_IN;
            }

            public void set${being.javaName?cap_first}_IN(String ${being.javaName}_IN) {
                this.${being.javaName}_IN = ${being.javaName}_IN;
            }

            public String get${being.javaName?cap_first}_NOTIN() {
                return ${being.javaName}_NOTIN;
            }

            public void set${being.javaName?cap_first}_NOTIN(String ${being.javaName}_NOTIN) {
                this.${being.javaName}_NOTIN = ${being.javaName}_NOTIN;
            }

            public String get${being.javaName?cap_first}_LIKE() {
                return ${being.javaName}_LIKE;
            }

            public void set${being.javaName?cap_first}_LIKE(String ${being.javaName}_LIKE) {
                this.${being.javaName}_LIKE = ${being.javaName}_LIKE;
            }

            public String get${being.javaName?cap_first}_NOTLIKE() {
                return ${being.javaName}_NOTLIKE;
            }

            public void set${being.javaName?cap_first}_NOTLIKE(String ${being.javaName}_NOTLIKE) {
                this.${being.javaName}_NOTLIKE = ${being.javaName}_NOTLIKE;
            }
            </#if>
    <#elseif being.columnType=="INT" || being.columnType=="DOUBLE" || being.columnType=="DECIMAL" || being.columnType=="LONG"  || being.columnType=="NUMBER" >
            public ${being.javaSimpleClass} get${being.javaName?cap_first}() {
                return ${being.javaName};
            }

            public void set${being.javaName?cap_first}(${being.javaSimpleClass} ${being.javaName}) {
                this.${being.javaName} = ${being.javaName};
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_NE() {
                return ${being.javaName}_NE;
            }

            public void set${being.javaName?cap_first}_NE(${being.javaSimpleClass} ${being.javaName}_NE) {
                this.${being.javaName}_NE = ${being.javaName}_NE;
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_GT() {
                return ${being.javaName}_GT;
            }

            public void set${being.javaName?cap_first}_GT(${being.javaSimpleClass} ${being.javaName}_GT) {
                this.${being.javaName}_GT = ${being.javaName}_GT;
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_GE() {
                return ${being.javaName}_GE;
            }

            public void set${being.javaName?cap_first}_GE(${being.javaSimpleClass} ${being.javaName}_GE) {
                this.${being.javaName}_GE = ${being.javaName}_GE;
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_LT() {
                return ${being.javaName}_LT;
            }

            public void set${being.javaName?cap_first}_LT(${being.javaSimpleClass} ${being.javaName}_LT) {
                this.${being.javaName}_LT = ${being.javaName}_LT;
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_LE() {
                return ${being.javaName}_LE;
            }

            public void set${being.javaName?cap_first}_LE(${being.javaSimpleClass} ${being.javaName}_LE) {
                this.${being.javaName}_LE = ${being.javaName}_LE;
            }

    <#elseif being.columnType=="DATE" || being.columnType=="TIMESTAMP" >
            public ${being.javaSimpleClass} get${being.javaName?cap_first}() {
                return ${being.javaName};
            }

            public void set${being.javaName?cap_first}(${being.javaSimpleClass} ${being.javaName}) {
                this.${being.javaName} = ${being.javaName};
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_NE() {
                return ${being.javaName}_NE;
            }

            public void set${being.javaName?cap_first}_NE(${being.javaSimpleClass} ${being.javaName}_NE) {
                this.${being.javaName}_NE = ${being.javaName}_NE;
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_GT() {
                return ${being.javaName}_GT;
            }

            public void set${being.javaName?cap_first}_GT(${being.javaSimpleClass} ${being.javaName}_GT) {
                this.${being.javaName}_GT = ${being.javaName}_GT;
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_GE() {
                return ${being.javaName}_GE;
            }

            public void set${being.javaName?cap_first}_GE(${being.javaSimpleClass} ${being.javaName}_GE) {
                this.${being.javaName}_GE = ${being.javaName}_GE;
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_LT() {
                return ${being.javaName}_LT;
            }

            public void set${being.javaName?cap_first}_LT(${being.javaSimpleClass} ${being.javaName}_LT) {
                this.${being.javaName}_LT = ${being.javaName}_LT;
            }

            public ${being.javaSimpleClass} get${being.javaName?cap_first}_LE() {
                return ${being.javaName}_LE;
            }

            public void set${being.javaName?cap_first}_LE(${being.javaSimpleClass} ${being.javaName}_LE) {
                this.${being.javaName}_LE = ${being.javaName}_LE;
            }
        <#else>
            //todo 生成代码错误 , 数据库类型没有包括
            ${being.columnType};
        </#if>
</#list>
}