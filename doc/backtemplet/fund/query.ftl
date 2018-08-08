package ${table.fullPackageName}.${templet.fileInnerPackage};


import com.zz.bms.core.db.mybatis.query.Query;
import ${table.fullPackageName}.domain.${table.javaName}Entity;

import java.io.Serializable;
<#list table.importClasss as importClass>
import ${importClass};
</#list>

/**
 * ${table.tableComment} 查询抽象类
 *
 * @author ${project.projectAuthor}
 * @date ${.now}
 */
public interface ${table.javaName}Query<PK extends Serializable> extends Query<${table.javaName}Entity,PK> {

<#list columns as being>
    <#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
        <#if being.columnIsfk == '1' || being.columnIskey == '1' >
        public ${table.javaName}Query ${being.javaName}(PK ${being.javaName});
        public ${table.javaName}Query ${being.javaName}Not(PK ${being.javaName}Not);
        public ${table.javaName}Query ${being.javaName}In(PK ${being.javaName}In);
        public ${table.javaName}Query ${being.javaName}NotIn(PK ${being.javaName}NotIn);
        public ${table.javaName}Query ${being.javaName}IsNull();
        public ${table.javaName}Query ${being.javaName}IsNotNull();

		<#elseif being.columnIsdict == "1" >
        public ${table.javaName}Query ${being.javaName}(String ${being.javaName});
        public ${table.javaName}Query ${being.javaName}Not(String ${being.javaName}Not);
        public ${table.javaName}Query ${being.javaName}In(String ${being.javaName}In);
        public ${table.javaName}Query ${being.javaName}NotIn(String ${being.javaName}NotIn);
        public ${table.javaName}Query ${being.javaName}IsNull();
        public ${table.javaName}Query ${being.javaName}IsNotNull();

		<#else>
        public ${table.javaName}Query ${being.javaName}(${being.javaSimpleClass} ${being.javaName});
        public ${table.javaName}Query ${being.javaName}Not(${being.javaSimpleClass} ${being.javaName}Not);
        public ${table.javaName}Query ${being.javaName}In(${being.javaSimpleClass} ${being.javaName}In);
        public ${table.javaName}Query ${being.javaName}NotIn(${being.javaSimpleClass} ${being.javaName}NotIn);
        public ${table.javaName}Query ${being.javaName}Like(${being.javaSimpleClass} ${being.javaName}Like);
        public ${table.javaName}Query ${being.javaName}NotLike(${being.javaSimpleClass} ${being.javaName}NotLike);
        public ${table.javaName}Query ${being.javaName}IsNull();
        public ${table.javaName}Query ${being.javaName}IsNotNull();

		</#if>
    <#elseif being.columnType=="INT" || being.columnType=="DOUBLE" || being.columnType=="DECIMAL" || being.columnType=="LONG"  || being.columnType=="NUMBER" >
        public ${table.javaName}Query ${being.javaName}(${being.javaSimpleClass} ${being.javaName});
        public ${table.javaName}Query ${being.javaName}Not(${being.javaSimpleClass} ${being.javaName}Not);
        public ${table.javaName}Query ${being.javaName}GreaterThan(${being.javaSimpleClass} ${being.javaName}GreaterThan);
        public ${table.javaName}Query ${being.javaName}GreaterEqual(${being.javaSimpleClass} ${being.javaName}GreaterEqual);
        public ${table.javaName}Query ${being.javaName}LessThan(${being.javaSimpleClass} ${being.javaName}LessThan);
        public ${table.javaName}Query ${being.javaName}LessEqual(${being.javaSimpleClass} ${being.javaName}LessEqual);

    <#elseif being.columnType=="DATE" || being.columnType=="TIMESTAMP" >
        public ${table.javaName}Query ${being.javaName}(${being.javaSimpleClass} ${being.javaName});
        public ${table.javaName}Query ${being.javaName}Not(${being.javaSimpleClass} ${being.javaName}Not);
        public ${table.javaName}Query ${being.javaName}GreaterThan(${being.javaSimpleClass} ${being.javaName}GreaterThan);
        public ${table.javaName}Query ${being.javaName}GreaterEqual(${being.javaSimpleClass} ${being.javaName}GreaterEqual);
        public ${table.javaName}Query ${being.javaName}LessThan(${being.javaSimpleClass} ${being.javaName}LessThan);
        public ${table.javaName}Query ${being.javaName}LessEqual(${being.javaSimpleClass} ${being.javaName}LessEqual);

	<#else>
        //todo 生成代码错误 , 数据库类型没有包括
        ${being.columnType};
	</#if>




</#list>

	
}