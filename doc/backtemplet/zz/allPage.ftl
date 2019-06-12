<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<bms:contentHeader  />
<!--
<div region='north' border=0>
    <div class="pro-tit">
        <h1 >
            <span><span class="fcol-org"></span></span>
        </h1>
    </div>
</div>
<div region='center' border=0 style='padding: 10px;' >
-->
    <div id='divTabs' class="easyui-tabs" plain="true" fit='true' border=0>
        <div title= "${table.tableComment}" >
            <iframe width='100%' height='99%' frameborder='0'></iframe>
        </div>

        <#if table.notPageChildTables?exists>
        <#list table.notPageChildTables as notPageChildTable>
        <div title="${notPageChildTable.tableComment}" >
            <iframe width='100%' height='99%' frameborder='0'></iframe>
        </div>
        </#list>
        </#if>
    </div>
<!--</div>-->




<bms:contentJS />

<script type="text/javascript">
    $(function(){
        $('#divTabs').tabs({onSelect: tabSelected});

        tabSelected("${table.tableComment}", 0);
    });

    var urls = [
            ctx+'${table.fullResourceName}/${r"${"} m.id ${r"}"}/update?inAllPage=1'<#if table.notPageChildTables?exists>,</#if>
        <#if table.notPageChildColumns?exists>
        <#list table.notPageChildColumns as notPageChildColumn>
        <#if notPageChildColumn.tableBO.tableRelation?exists && 'one-one' == notPageChildColumn.tableBO.tableRelation>
            ctx+'${notPageChildColumn.tableBO.fullResourceName}/toAddorUpdate?inAllPage=1&${notPageChildColumn.javaName}=${r"${"} m.id ${r"}"}'<#if notPageChildColumn_has_next>,</#if>
        <#else >
            <#if notPageChildColumn.tableBO.isTree?exists && notPageChildColumn.tableBO.isTree == '0'>
            ctx+'${notPageChildColumn.tableBO.fullResourceName}/toList?inAllPage=1&${notPageChildColumn.javaName}=${r"${"} m.id ${r"}"}'<#if notPageChildColumn_has_next>,</#if>
            <#else >
            ctx+'${notPageChildColumn.tableBO.fullResourceName}/toTree?inAllPage=1&${notPageChildColumn.javaName}=${r"${"} m.id ${r"}"}'<#if notPageChildColumn_has_next>,</#if>
            </#if>
        </#if>
        </#list>
        </#if>
    ];

    /**
     * Tab页点击事件：动态加载模块url
     */
    function tabSelected(title, index)
    {
        //动态根据TAB改变标题
        $(".tabSubTitle",parent.document).html(title);

        var iframe = $('#divTabs').find('iframe');
        if (0 == iframe[index].src.length)
        {

            iframe[index].src = urls[index];
            iframe[index].height = '100%';
        }

    }
</script>


<bms:contentFooter />