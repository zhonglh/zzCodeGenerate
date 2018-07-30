package ${table.basePackage}.domain;



import com.zz.bsmcc.base.query.${table.shortTableName?cap_first}Query;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * ${table.tableComments} 查询抽象类
 * 用于链式查询
 * @author ${table.author}
 * @date ${.now}
 */
public class ${table.shortTableName?cap_first}QueryImpl<PK extends Serializable> extends ${table.shortTableName?cap_first}AbstractQueryImpl<PK> implements ${table.shortTableName?cap_first}Query<PK>, Serializable  {

<#list table.columnList as being>




	<#if being.columnType=="char" || being.columnType=="varchar2" || being.columnType=="varchar" || being.columnType=="longtext">

		<#if being.shortColumnName == "id" ||  being.columnPrecision == "32" || being.columnPrecision == "36" || being.columnPrecision == "64">

            private List<PK> ${being.shortColumnName}_IN;
            private List<PK> ${being.shortColumnName}_NOTIN;
		<#elseif being.columnPrecision == "1" || being.columnPrecision == "2" >

            private List<String> ${being.shortColumnName}_IN;
            private List<String> ${being.shortColumnName}_NOTIN;

		<#else>

            private List<String> ${being.shortColumnName}_IN;
            private List<String> ${being.shortColumnName}_NOTIN;
		</#if>



	<#elseif being.columnType=="int" || being.columnType=="double" || being.columnType=="decimal" || being.columnType=="long"  || being.columnType=="number" >


	<#elseif being.columnType=="date" || being.columnType=="timestamp" >


	<#else>
        ;
	</#if>




</#list>











<#list table.columnList as being>




        <#if being.columnType=="char" || being.columnType=="varchar2" || being.columnType=="varchar" || being.columnType=="longtext">

            <#if being.shortColumnName == "id" ||  being.columnPrecision == "32" || being.columnPrecision == "36" || being.columnPrecision == "64">

                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(PK ${being.shortColumnName}) {
                    if(!IdUtils.isEmpty(${being.shortColumnName})){
                        this.${being.shortColumnName} = ${being.shortColumnName};
                    }
                    return this;
                }


                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(PK ${being.shortColumnName}Not) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}Not)){
                        this.${being.shortColumnName}_NE = ${being.shortColumnName}Not;
                    }
                    return this;
                }

                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}In(PK ${being.shortColumnName}In) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}In)){
                        this.${being.shortColumnName}_IN.add( ${being.shortColumnName}In );
                    }
                    return this;
                }


                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}NotIn(PK ${being.shortColumnName}NotIn) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}NotIn)){
                        this.${being.shortColumnName}_NOTIN.add( ${being.shortColumnName}NotIn );
                    }
                    return this;
                }



                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNull() {
                    this.isNulls.add("${being.shortColumnName}");
                    return this;
                }



                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNotNull() {
                    this.isNotNulls.add("${being.shortColumnName}");
                    return this;
                }


            <#elseif being.columnPrecision == "1" || being.columnPrecision == "2" >

                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(String ${being.shortColumnName}) {
                    if(!IdUtils.isEmpty(${being.shortColumnName})){
                        this.${being.shortColumnName} = ${being.shortColumnName};
                    }
                    return this;
                }


                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(String ${being.shortColumnName}Not) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}Not)){
                        this.${being.shortColumnName}_NE = ${being.shortColumnName}Not;
                    }
                    return this;
                }

                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}In(String ${being.shortColumnName}In) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}In)){
                        this.${being.shortColumnName}_IN.add( ${being.shortColumnName}In );
                    }
                    return this;
                }


                @Override
                    public ${table.shortTableName?cap_first}Query ${being.shortColumnName}NotIn(String ${being.shortColumnName}NotIn) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}NotIn)){
                        this.${being.shortColumnName}_NOTIN.add( ${being.shortColumnName}NotIn );
                    }
                    return this;
                    }



                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNull() {
                    this.isNulls.add("${being.shortColumnName}");
                    return this;
                }



                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNotNull() {
                    this.isNotNulls.add("${being.shortColumnName}");
                    return this;
                }

            <#else>

                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(String ${being.shortColumnName}) {
                    if(!IdUtils.isEmpty(${being.shortColumnName})){
                        this.${being.shortColumnName} = ${being.shortColumnName};
                    }
                    return this;
                }


                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(String ${being.shortColumnName}Not) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}Not)){
                        this.${being.shortColumnName}_NE = ${being.shortColumnName}Not;
                    }
                    return this;
                }




                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Like(String ${being.shortColumnName}Like) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}Like)){
                        this.${being.shortColumnName}_LIKE = ${being.shortColumnName}Like;
                    }
                    return this;
                }



                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}NotLike(String ${being.shortColumnName}NotLike) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}NotLike)){
                        this.${being.shortColumnName}_NOTLIKE = ${being.shortColumnName}NotLike;
                    }
                    return this;
                }

                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}In(String ${being.shortColumnName}In) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}In)){
                        this.${being.shortColumnName}_IN.add( ${being.shortColumnName}In );
                    }
                    return this;
                }


                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}NotIn(String ${being.shortColumnName}NotIn) {
                    if(!IdUtils.isEmpty(${being.shortColumnName}NotIn)){
                        this.${being.shortColumnName}_NOTIN.add( ${being.shortColumnName}NotIn );
                    }
                    return this;
                }



                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNull() {
                    this.isNulls.add("${being.shortColumnName}");
                    return this;
                }



                @Override
                public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNotNull() {
                    this.isNotNulls.add("${being.shortColumnName}");
                    return this;
                }
            </#if>



        <#elseif being.columnType=="int" || being.columnType=="double" || being.columnType=="decimal" || being.columnType=="long"  || being.columnType=="number" >


            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(${being.javaType} ${being.shortColumnName}) {
                if(!IdUtils.isEmpty(${being.shortColumnName})){
                    this.${being.shortColumnName} = ${being.shortColumnName};
                }
                return this;
            }



            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(${being.javaType} ${being.shortColumnName}Not) {
                if(!IdUtils.isEmpty(${being.shortColumnName}Not)){
                    this.${being.shortColumnName}_NE = ${being.shortColumnName}Not;
                }
                return this;
            }

            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}GreaterThan(${being.javaType} ${being.shortColumnName}GreaterThan){
                if(${being.shortColumnName}GreaterThan != null){
                    this.${being.shortColumnName}_GT = ${being.shortColumnName}GreaterThan;
                }
                return this;
            }


            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}GreaterEqual(${being.javaType} ${being.shortColumnName}GreaterEqual){
                if(${being.shortColumnName}GreaterEqual != null){
                    this.${being.shortColumnName}_GE = ${being.shortColumnName}GreaterEqual;
                }
                return this;
            }


            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}LessThan(${being.javaType} ${being.shortColumnName}LessThan){
                if(${being.shortColumnName}LessThan != null){
                    this.${being.shortColumnName}_LT = ${being.shortColumnName}LessThan;
                }
                return this;
            }

            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}LessEqual(${being.javaType} ${being.shortColumnName}LessEqual){
                if(${being.shortColumnName}LessEqual != null){
                    this.${being.shortColumnName}_LE = ${being.shortColumnName}LessEqual;
                }
                return this;
            }


        <#elseif being.columnType=="date" || being.columnType=="timestamp" >


            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(${being.javaType} ${being.shortColumnName}) {
                if(!IdUtils.isEmpty(${being.shortColumnName})){
                    this.${being.shortColumnName} = ${being.shortColumnName};
                }
                return this;
            }



            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(${being.javaType} ${being.shortColumnName}Not) {
                if(!IdUtils.isEmpty(${being.shortColumnName}Not)){
                    this.${being.shortColumnName}_NE = ${being.shortColumnName}Not;
                }
                return this;
            }

            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}GreaterThan(${being.javaType} ${being.shortColumnName}GreaterThan){
                if(${being.shortColumnName}GreaterThan != null){
                    this.${being.shortColumnName}_GT = ${being.shortColumnName}GreaterThan;
                }
                return this;
            }


            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}GreaterEqual(${being.javaType} ${being.shortColumnName}GreaterEqual){
                if(${being.shortColumnName}GreaterEqual != null){
                    this.${being.shortColumnName}_GE = ${being.shortColumnName}GreaterEqual;
                }
                return this;
            }


            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}LessThan(${being.javaType} ${being.shortColumnName}LessThan){
                if(${being.shortColumnName}LessThan != null){
                    this.${being.shortColumnName}_LT = ${being.shortColumnName}LessThan;
                }
                return this;
            }

            @Override
            public ${table.shortTableName?cap_first}Query ${being.shortColumnName}LessEqual(${being.javaType} ${being.shortColumnName}LessEqual){
                if(${being.shortColumnName}LessEqual != null){
                    this.${being.shortColumnName}_LE = ${being.shortColumnName}LessEqual;
                }
                return this;
            }

        <#else>
            ;
        </#if>




</#list>

	
}