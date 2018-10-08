<style>

</style>

<template>
    <div>
        <${table.javaName}Edit :id="${table.simpleName}Id" :isInclude="true"></${table.javaName}Edit>

    <#if table.childFkTables?exists >
        <#list table.childFkTables as child>
            <#if (child.pageRelation?exists && child.pageRelation == '1')>
                <#if (child.tableRelation?exists && child.tableRelation == 'one-multi')>
                    <${child.javaName}List :${table.simpleName}Id=":${table.simpleName}Id" btnSize="small" :isInclude="true" :tableFit="false"></${child.javaName}List>
                <#else >
                    <${child.javaName}Edit :${table.simpleName}Id=":${table.simpleName}Id" ></${child.javaName}Edit>
                </#if>
            </#if>
        </#list>
    </#if>


    </div>

</template>


<script>


    import ${table.javaName}Edit from './${table.javaName}Edit' ;
<#if table.childFkTables?exists >
<#list table.childFkTables as child>
    <#if (child.pageRelation?exists && child.pageRelation == '1')>
    <#if (child.tableRelation?exists && child.tableRelation == 'one-multi')>
    import ${child.javaName}List from '@/views${child.fullResourceName}/${child.javaName}List';
    <#else >
    import ${child.javaName}Edit from '@/views${child.fullResourceName}/${child.javaName}Edit';
    </#if>
    </#if>
</#list>
</#if>


    export default {
        components: {
            ${table.javaName}Edit,
        <#if table.childFkTables?exists >
        <#list table.childFkTables as child>
            <#if (child.pageRelation?exists && child.pageRelation == '1')>
                <#if (child.tableRelation?exists && child.tableRelation == 'one-multi')>
                    ${child.javaName}List,
                <#else >
                    ${child.javaName}Edit,
                </#if>
            </#if>
        </#list>
        </#if>
        },
        props:{
            <#list columns as column>
            <#if column.columnIsfk == '1'>
            ${column.javaName} :{
                type:String,
                default:''
            },
            </#if>
            </#list>

            id :{
                type:String,
                default: ''
            },
            ${table.simpleName}Id :{
                type:String,
                default: ''
            }
        }




    }




</script>
