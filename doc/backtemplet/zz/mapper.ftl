<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="${table.fullPackageName}.dao.${table.javaName}DAO">
 	<!-- 映射配置 -->
	<resultMap id="${table.javaName}ResultMap" type="${table.fullPackageName}.bo.${table.javaName}BO" >
		<#list columns as being>
         	<result column="${being.columnName}" property="${being.javaName}"/>

        </#list>
	</resultMap>


    <!-- 校验条件配置 -->
    <sql id="${table.javaName}4CheckQueryFilter">
        <where>

		<#list columns as being>
			<#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
				<#if being.columnIskey == '1' >
                    <if test="${being.javaName} != null and ${being.javaName} != ''"> AND T.${being.columnName} != ${emptyString!'#'}{${being.javaName}} </if>
				<#elseif  being.columnIsfk == '1' >
					<if test="${being.javaName} != null and ${being.javaName} != ''"> AND T.${being.columnName} = ${emptyString!'#'}{${being.javaName}} </if>
				<#else>
					<if test="${being.javaName} != null and ${being.javaName} != ''"> AND T.${being.columnName} = ${emptyString!'#'}{${being.javaName}} </if>
				</#if>
			<#else>
					<if test="${being.javaName} != null"> AND T.${being.columnName} = ${emptyString!'#'}{${being.javaName}} </if>
			</#if>
		</#list>

        </where>
    </sql>

    <select id="selectCheck" parameterType="${table.fullPackageName}.bo.${table.javaName}BO" resultMap="${table.javaName}ResultMap">
        SELECT T.* FROM ${table.tableName} T
        <include refid="${table.javaName}4CheckQueryFilter"/>  limit 1
    </select>


</mapper>
