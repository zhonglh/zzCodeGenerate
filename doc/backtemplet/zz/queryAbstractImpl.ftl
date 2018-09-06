package ${table.fullPackageName}.${templet.fileInnerPackage};


import com.zz.bms.core.db.mybatis.query.QueryImpl;
import ${table.fullPackageName}.domain.${table.javaName}Entity;

import java.io.Serializable;
<#list table.importClasss as importClass>
import ${importClass};
</#list>

/**
 * ${table.tableComment} 查询抽象类
 * 用于链式查询
 * @author ${project.projectAuthor}
 * @date ${.now}
 */
public abstract class ${table.javaName}AbstractQueryImpl<PK extends Serializable> extends QueryImpl<${table.javaName}Entity,PK> {

<#list columns as being>
	<#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
		<#if being.columnIsfk == '1' || being.columnIskey == '1' >
            protected PK ${being.javaName};
            protected PK ${being.javaName}_NE;

		<#elseif being.columnIsdict == "1"  >
            protected String ${being.javaName};
            protected String ${being.javaName}_NE;

		<#else>
            protected String ${being.javaName};
            protected String ${being.javaName}_NE;
            protected String ${being.javaName}_LIKE;
            protected String ${being.javaName}_NOTLIKE;

		</#if>
	<#elseif being.columnType=="INT" || being.columnType=="DOUBLE" || being.columnType=="DECIMAL" || being.columnType=="LONG"  || being.columnType=="NUMBER" || being.columnType=="BIGINT" >
        protected ${being.javaSimpleClass} ${being.javaName};
        protected ${being.javaSimpleClass} ${being.javaName}_NE;
        protected ${being.javaSimpleClass} ${being.javaName}_GT;
        protected ${being.javaSimpleClass} ${being.javaName}_GE;
        protected ${being.javaSimpleClass} ${being.javaName}_LT;
        protected ${being.javaSimpleClass} ${being.javaName}_LE;

	<#elseif being.columnType=="DATE" || being.columnType=="DATETIME" || being.columnType=="TIMESTAMP" >
        protected ${being.javaSimpleClass} ${being.javaName};
        protected ${being.javaSimpleClass} ${being.javaName}_NE;
        protected ${being.javaSimpleClass} ${being.javaName}_GT;
        protected ${being.javaSimpleClass} ${being.javaName}_GE;
        protected ${being.javaSimpleClass} ${being.javaName}_LT;
        protected ${being.javaSimpleClass} ${being.javaName}_LE;

	<#else>

        //todo ${being.columnType} ${being.javaName};
	</#if>
</#list>

	
}