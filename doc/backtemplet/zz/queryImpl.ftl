package ${table.fullPackageName}.${templet.fileInnerPackage};



import com.zz.bms.util.base.java.IdUtils;
import ${table.fullPackageName}.domain.${table.javaName}Entity;
import ${table.fullPackageName}.query.${table.javaName}Query;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
<#list table.importClasss as importClass>
import ${importClass};
</#list>

/**
* <h1>${table.tableComment} 查询实现类</h1>
* 可用于链式查询
* @author ${project.projectAuthor}
* @date ${.now}
*/
public class ${table.javaName}QueryImpl<PK extends Serializable> extends ${table.javaName}AbstractQueryImpl<PK> implements ${table.javaName}Query<PK>, Serializable  {

<#list columns as being>
    <#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
        <#if being.columnIsfk == '1' || being.columnIskey == '1' >
        private List<PK> ${being.javaName}_IN;
        private List<PK> ${being.javaName}_NOTIN;

        <#elseif being.columnIsdict == "1"  >
        private List<String> ${being.javaName}_IN;
        private List<String> ${being.javaName}_NOTIN;

		<#else>

        private List<String> ${being.javaName}_IN;
        private List<String> ${being.javaName}_NOTIN;
		</#if>
    <#elseif being.columnType=="INT" || being.columnType=="DOUBLE" || being.columnType=="DECIMAL" || being.columnType=="LONG"  || being.columnType=="NUMBER" || being.columnType=="BIGINT">
    <#elseif being.columnType=="DATE"  || being.columnType=="DATETIME" || being.columnType=="TIMESTAMP" >
    <#else>

        //todo ${being.columnType} ${being.javaName};
	</#if>
</#list>


<#list columns as being>
    <#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
        <#if being.columnIsfk == '1' || being.columnIskey == '1' >
        @Override
        public ${table.javaName}Query ${being.javaName}(PK ${being.javaName}) {
            if(!IdUtils.isEmpty(${being.javaName})){
                this.${being.javaName} = ${being.javaName};
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}Not(PK ${being.javaName}Not) {
            if(!IdUtils.isEmpty(${being.javaName}Not)){
                this.${being.javaName}_NE = ${being.javaName}Not;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}In(PK ${being.javaName}In) {
            if(!IdUtils.isEmpty(${being.javaName}In)){
                if(this.${being.javaName}_IN == null){
                    this.${being.javaName}_IN = new ArrayList<PK>();
                }
                this.${being.javaName}_IN.add( ${being.javaName}In );
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}NotIn(PK ${being.javaName}NotIn) {
            if(!IdUtils.isEmpty(${being.javaName}NotIn)){
                if(this.${being.javaName}_NOTIN == null){
                    this.${being.javaName}_NOTIN = new ArrayList<PK>();
                }
                this.${being.javaName}_NOTIN.add( ${being.javaName}NotIn );
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}IsNull() {
            this.isNulls.add("${being.javaName}");
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}IsNotNull() {
            this.isNotNulls.add("${being.javaName}");
            return this;
        }

        <#elseif being.columnIsdict == "1"  >
        @Override
        public ${table.javaName}Query ${being.javaName}(String ${being.javaName}) {
            if(!IdUtils.isEmpty(${being.javaName})){
                this.${being.javaName} = ${being.javaName};
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}Not(String ${being.javaName}Not) {
            if(!IdUtils.isEmpty(${being.javaName}Not)){
                this.${being.javaName}_NE = ${being.javaName}Not;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}In(String ${being.javaName}In) {
            if(!IdUtils.isEmpty(${being.javaName}In)){
                if(this.${being.javaName}_IN == null){
                    this.${being.javaName}_IN = new ArrayList<String>();
                }
                this.${being.javaName}_IN.add( ${being.javaName}In );
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}NotIn(String ${being.javaName}NotIn) {
            if(!IdUtils.isEmpty(${being.javaName}NotIn)){
                if(this.${being.javaName}_NOTIN == null){
                    this.${being.javaName}_NOTIN = new ArrayList<String>();
                }
                this.${being.javaName}_NOTIN.add( ${being.javaName}NotIn );
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}IsNull() {
            this.isNulls.add("${being.javaName}");
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}IsNotNull() {
            this.isNotNulls.add("${being.javaName}");
            return this;
        }

            <#else>

        @Override
        public ${table.javaName}Query ${being.javaName}(String ${being.javaName}) {
            if(!IdUtils.isEmpty(${being.javaName})){
                this.${being.javaName} = ${being.javaName};
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}Not(String ${being.javaName}Not) {
            if(!IdUtils.isEmpty(${being.javaName}Not)){
                this.${being.javaName}_NE = ${being.javaName}Not;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}Like(String ${being.javaName}Like) {
            if(!IdUtils.isEmpty(${being.javaName}Like)){
                this.${being.javaName}_LIKE = ${being.javaName}Like;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}NotLike(String ${being.javaName}NotLike) {
            if(!IdUtils.isEmpty(${being.javaName}NotLike)){
                this.${being.javaName}_NOTLIKE = ${being.javaName}NotLike;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}In(String ${being.javaName}In) {
            if(!IdUtils.isEmpty(${being.javaName}In)){
                if(this.${being.javaName}_IN == null){
                    this.${being.javaName}_IN = new ArrayList<String>();
                }
                this.${being.javaName}_IN.add( ${being.javaName}In );
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}NotIn(String ${being.javaName}NotIn) {
            if(!IdUtils.isEmpty(${being.javaName}NotIn)){
                if(this.${being.javaName}_NOTIN == null){
                    this.${being.javaName}_NOTIN = new ArrayList<String>();
                }
                this.${being.javaName}_NOTIN.add( ${being.javaName}NotIn );
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}IsNull() {
            this.isNulls.add("${being.javaName}");
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}IsNotNull() {
            this.isNotNulls.add("${being.javaName}");
            return this;
        }

            </#if>

    <#elseif being.columnType=="INT" || being.columnType=="DOUBLE" || being.columnType=="DECIMAL" || being.columnType=="LONG"  || being.columnType=="NUMBER" || being.columnType=="BIGINT">
        @Override
        public ${table.javaName}Query ${being.javaName}(${being.javaSimpleClass} ${being.javaName}) {
            if(!IdUtils.isEmpty(${being.javaName})){
                this.${being.javaName} = ${being.javaName};
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}Not(${being.javaSimpleClass} ${being.javaName}Not) {
            if(!IdUtils.isEmpty(${being.javaName}Not)){
                this.${being.javaName}_NE = ${being.javaName}Not;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}GreaterThan(${being.javaSimpleClass} ${being.javaName}GreaterThan){
            if(${being.javaName}GreaterThan != null){
                this.${being.javaName}_GT = ${being.javaName}GreaterThan;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}GreaterEqual(${being.javaSimpleClass} ${being.javaName}GreaterEqual){
            if(${being.javaName}GreaterEqual != null){
                this.${being.javaName}_GE = ${being.javaName}GreaterEqual;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}LessThan(${being.javaSimpleClass} ${being.javaName}LessThan){
            if(${being.javaName}LessThan != null){
                this.${being.javaName}_LT = ${being.javaName}LessThan;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}LessEqual(${being.javaSimpleClass} ${being.javaName}LessEqual){
            if(${being.javaName}LessEqual != null){
                this.${being.javaName}_LE = ${being.javaName}LessEqual;
            }
            return this;
        }

    <#elseif being.columnType=="DATE" || being.columnType=="DATETIME" || being.columnType=="TIMESTAMP" >
        @Override
        public ${table.javaName}Query ${being.javaName}(${being.javaSimpleClass} ${being.javaName}) {
            if(!IdUtils.isEmpty(${being.javaName})){
                this.${being.javaName} = ${being.javaName};
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}Not(${being.javaSimpleClass} ${being.javaName}Not) {
            if(!IdUtils.isEmpty(${being.javaName}Not)){
                this.${being.javaName}_NE = ${being.javaName}Not;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}GreaterThan(${being.javaSimpleClass} ${being.javaName}GreaterThan){
            if(${being.javaName}GreaterThan != null){
                this.${being.javaName}_GT = ${being.javaName}GreaterThan;
            }
            return this;
        }


        @Override
        public ${table.javaName}Query ${being.javaName}GreaterEqual(${being.javaSimpleClass} ${being.javaName}GreaterEqual){
            if(${being.javaName}GreaterEqual != null){
                this.${being.javaName}_GE = ${being.javaName}GreaterEqual;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}LessThan(${being.javaSimpleClass} ${being.javaName}LessThan){
            if(${being.javaName}LessThan != null){
                this.${being.javaName}_LT = ${being.javaName}LessThan;
            }
            return this;
        }

        @Override
        public ${table.javaName}Query ${being.javaName}LessEqual(${being.javaSimpleClass} ${being.javaName}LessEqual){
            if(${being.javaName}LessEqual != null){
                this.${being.javaName}_LE = ${being.javaName}LessEqual;
            }
            return this;
        }

        <#else>

        //todo ${being.columnType} ${being.javaName};
        </#if>
</#list>

	
}