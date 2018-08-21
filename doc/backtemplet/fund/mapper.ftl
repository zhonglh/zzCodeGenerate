<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="${table.fullPackageName}.dao.${table.javaName}Dao">
 	<!-- 映射配置 -->
	<resultMap id="${table.javaName}ResultMap" type="${table.fullPackageName}.domain.${table.javaName}" >
		<#list columns as being>
         	<result column="${being.columnName}" property="${being.javaName}"/>
        </#list>
	</resultMap>

	 <!-- 条件配置 -->
	<sql id="${table.javaName}QueryFilter">
		<where>
			<#list columns as being>

				<#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
					<#if being.columnIsfk == '1' || being.columnIskey == '1' || being.columnIsdict == '1' >
						<if test="${being.javaName} != null and ${being.javaName} != ''"> AND T.${being.columnName} = ${emptyString!'#'}{${being.javaName}} </if>
					<#else>
						<if test="${being.javaName} != null and ${being.javaName} != ''"> AND T.${being.columnName} like CONCAT('%',${emptyString!'#'}{${being.javaName}},'%' ) </if>
					</#if>

				<#else>
					<if test="${being.javaName} != null"> AND T.${being.columnName} = ${emptyString!'#'}{${being.javaName}} </if>
				</#if>

			</#list>
			<if test="rbac != null"> and( $${"{rbac}"} )</if>

			<if test="queryIdList != null"> AND T.ID IN
			 <foreach collection="queryIdList" index="index" item="item" open="(" separator="," close=")">${emptyString!'#'}{item}</foreach>
			</if>
		</where>
	</sql>


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
					<if test="${being.javaName} != null and ${being.javaName} != ''"> AND T.${being.columnName} = ${emptyString!'#'}{${being.javaName}} </if>
				</#if>


		</#list>

        </where>
    </sql>


    <!-- 删除条件配置 -->
    <sql id="${table.javaName}DeleteFilter">
        <where>
		<#list columns as being>

			<#if being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
				<#if being.columnIsfk == '1' || being.columnIskey == '1' || being.columnIsdict == '1' >
                    <if test="${being.javaName} != null and ${being.javaName} != ''"> AND T.${being.columnName} = ${emptyString!'#'}{${being.javaName}} </if>
				<#else>
                    <if test="${being.javaName} != null and ${being.javaName} != ''"> AND T.${being.columnName} like CONCAT('%',${emptyString!'#'}{${being.javaName}},'%' ) </if>
				</#if>

			<#else>
                <if test="${being.javaName} != null"> AND T.${being.columnName} = ${emptyString!'#'}{${being.javaName}} </if>
			</#if>

		</#list>
            <if test="rbac != null"> and( $${"{rbac}"} )</if>

            <if test="queryIdList != null"> AND T.ID IN
                <foreach collection="queryIdList" index="index" item="item" open="(" separator="," close=")">${emptyString!'#'}{item}</foreach>
            </if>
        </where>
    </sql>

	 <!-- 更新配置 -->
	<sql id="${table.javaName}SetFilter">
		<set>
		<#list columns as being>

		<#if being.columnName=="CREATE_TIME" || being.columnName=="CREATE_USER_ID" || being.columnName=="CREATE_USER_NAME" >
		<#elseif  being.columnType=="CHAR" || being.columnType=="VARCHAR2" || being.columnType=="VARCHAR" || being.columnType=="LONGTEXT">
			<if test="${being.javaName} != null"> T.${being.columnName} = ${emptyString!'#'}{${being.javaName}<#if being.columnType=="DATE" ></#if>}, </if>
		<#else>
			<#if being.columnName=="VERSION">
			<if test="${being.javaName} != null"> T.${being.columnName} =  T.${being.columnName} + 1, </if>
			<#else>
			<if test="${being.javaName} != null"> T.${being.columnName} = ${emptyString!'#'}{${being.javaName}<#if being.columnType=="DATE" ></#if>}, </if>
			</#if>
		</#if>

		</#list>
		</set>
	</sql>


    <!-- =======业务SQL====== -->
    <!-- 保存${table.tableComment} -->
    <insert id="save" parameterType="${table.fullPackageName}.domain.${table.javaName}">
        INSERT INTO ${table.tableName} (
		<#list columns as being>
		${ being.columnName}<#if being_has_next>,</#if>
		</#list>
        ) VALUES (
	<#list columns as being>
		#${"{" + being.javaName}}<#if being_has_next>,</#if>
	</#list>
        )
    </insert>



    <!-- 根据条件查询第一条${table.tableComment} -->
    <select id="findTopOne4Check" parameterType="${table.fullPackageName}.domain.${table.javaName}" resultMap="${table.javaName}ResultMap">
        SELECT T.* FROM ${table.tableName} T
        <include refid="${table.javaName}4CheckQueryFilter"/>  limit 1
    </select>


    <!-- 删除${table.tableComment} -->
    <delete id="delete" parameterType="${table.fullPackageName}.domain.${table.javaName}">
        DELETE FROM ${table.tableName} T
        <include refid="${table.javaName}DeleteFilter"/>
    </delete>

    <!-- 修改${table.tableComment} -->
    <update id="update" parameterType="${table.fullPackageName}.domain.${table.javaName}">
        UPDATE ${table.tableName} T
        <include refid="${table.javaName}SetFilter"/>
        WHERE T.ID=#${"{id"}}
		<#list columns as being>
		<#if being.columnName =="version_no">
		and version_no = #${"{versionNo"}}
		</#if>
		<if test="rbac != null"> and( $${"{rbac}"} )</if>

		</#list>
    </update>



    <!-- 根据条件查询第一条${table.tableComment} -->
    <select id="findTopOne" parameterType="${table.fullPackageName}.domain.${table.javaName}" resultMap="${table.javaName}ResultMap">
        SELECT T.* FROM ${table.tableName} T
        <include refid="${table.javaName}QueryFilter"/>  limit 1
    </select>

    <!-- 根据条件查询保存${table.tableComment}列表 -->
    <select id="findList" parameterType="${table.fullPackageName}.domain.${table.javaName}" resultMap="${table.javaName}ResultMap">
        SELECT T.* FROM ${table.tableName} T
        <include refid="${table.javaName}QueryFilter"/>
    </select>

    <!-- 查询所有 -->
    <select id="findAll"  resultMap="${table.javaName}ResultMap">
        SELECT T.* FROM ${table.tableName} T
    </select>


</mapper>
