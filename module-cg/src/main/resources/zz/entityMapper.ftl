<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="${table.basePackage}.dao.${table.shortTableName?cap_first}Dao">
 	<!-- 映射配置 -->
	<resultMap id="${table.shortTableName?cap_first}ResultMap" type="${table.basePackage}.domain.${table.shortTableName?cap_first}" >
		<#list table.columnList as being>
         	<#if being.isEnum>
         	<result column="${being.columnName}" property="${being.shortColumnName}" typeHandler=${"\"" + being.packageStr + ".handler."}<#if being.shortColumnName=="state">YesOrNoHandler"<#else>${being.enumClassName}Handler"</#if>/>
         	<#else>
         	<result column="${being.columnName}" property="${being.shortColumnName}"/>
         	</#if>
        </#list>
	</resultMap>


    <!-- 校验条件配置 -->
    <sql id="${table.shortTableName?cap_first}4CheckQueryFilter">
        <where>
		<#list table.columnList as being>
			<#if being.isEnum>
                <if test="${being.shortColumnName} != null"> AND T.${being.columnName} = ${emptyString!'#'}${"{" + being.shortColumnName}, typeHandler=${being.packageStr + ".handler."}<#if being.shortColumnName=="state">YesOrNoHandler<#else>${being.enumClassName}Handler</#if>} </if>
			<#else>

				<#if being.columnType=="char" || being.columnType=="varchar2" || being.columnType=="varchar" || being.columnType=="longtext">

					<#if being.shortColumnName == "id">
						<if test="${being.shortColumnName} != null and ${being.shortColumnName} != ''"> AND T.${being.columnName} != ${emptyString!'#'}{${being.shortColumnName}} </if>
					<#elseif  being.columnPrecision == "32" || being.columnPrecision == "36" || being.columnPrecision == "64">
                        <if test="${being.shortColumnName} != null and ${being.shortColumnName} != ''"> AND T.${being.columnName} = ${emptyString!'#'}{${being.shortColumnName}} </if>
					<#else>
                        <if test="${being.shortColumnName} != null and ${being.shortColumnName} != ''"> AND T.${being.columnName} = ${emptyString!'#'}{${being.shortColumnName}} </if>
					</#if>


				<#else>
					<if test="${being.shortColumnName} != null"> AND T.${being.columnName} = ${emptyString!'#'}{${being.shortColumnName}} </if>
				</#if>
			</#if>

		</#list>

        </where>
    </sql>




    <!-- 根据条件查询第一条${table.tableComments} -->
    <select id="selectCheck" parameterType="${table.basePackage}.domain.${table.shortTableName?cap_first}" resultMap="${table.shortTableName?cap_first}ResultMap">
        SELECT T.* FROM ${table.tableName} T
        <include refid="${table.shortTableName?cap_first}4CheckQueryFilter"/>  limit 1
    </select>


</mapper>
