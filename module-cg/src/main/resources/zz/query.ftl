package ${table.basePackage}.domain;


import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bsmcc.base.domain.${table.shortTableName?cap_first}Entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
 * ${table.tableComments}查询接口
 *
 * @author ${table.author}
 * @date ${.now}
 */
public interface ${table.shortTableName?cap_first}Query<PK extends Serializable> extends Query<${table.shortTableName?cap_first}Entity,PK> {

<#list table.columnList as being>
	<#if being.columnType=="char" || being.columnType=="varchar2" || being.columnType=="varchar" || being.columnType=="longtext">
		<#if being.shortColumnName == "id" ||  being.columnPrecision == "32" || being.columnPrecision == "36" || being.columnPrecision == "64">
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(PK ${being.shortColumnName});
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(PK ${being.shortColumnName}Not);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}In(PK ${being.shortColumnName}In);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}NotIn(PK ${being.shortColumnName}NotIn);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNull();
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNotNull();
		<#elseif being.columnPrecision == "1" || being.columnPrecision == "2" >
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(String ${being.shortColumnName});
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(String ${being.shortColumnName}Not);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}In(String ${being.shortColumnName}In);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}NotIn(String ${being.shortColumnName}NotIn);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNull();
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNotNull();

		<#else>
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(${being.javaType} ${being.shortColumnName});
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(${being.javaType} ${being.shortColumnName}Not);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}In(${being.javaType} ${being.shortColumnName}In);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}NotIn(${being.javaType} ${being.shortColumnName}NotIn);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Like(${being.javaType} ${being.shortColumnName}Like);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}NotLike(${being.javaType} ${being.shortColumnName}NotLike);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNull();
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}IsNotNull();
		</#if>



	<#elseif being.columnType=="int" || being.columnType=="double" || being.columnType=="decimal" || being.columnType=="long"  || being.columnType=="number" >

        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(${being.javaType} ${being.shortColumnName});
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(${being.javaType} ${being.shortColumnName}Not);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}GreaterThan(${being.javaType} ${being.shortColumnName}GreaterThan);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}GreaterEqual(${being.javaType} ${being.shortColumnName}GreaterEqual);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}LessThan(${being.javaType} ${being.shortColumnName}LessThan);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}LessEqual(${being.javaType} ${being.shortColumnName}LessEqual);

	<#elseif being.columnType=="date" || being.columnType=="timestamp" >

        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}(${being.javaType} ${being.shortColumnName});
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}Not(${being.javaType} ${being.shortColumnName}Not);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}GreaterThan(${being.javaType} ${being.shortColumnName}GreaterThan);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}GreaterEqual(${being.javaType} ${being.shortColumnName}GreaterEqual);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}LessThan(${being.javaType} ${being.shortColumnName}LessThan);
        public ${table.shortTableName?cap_first}Query ${being.shortColumnName}LessEqual(${being.javaType} ${being.shortColumnName}LessEqual);

	<#else>
        ;
	</#if>




</#list>

	
}