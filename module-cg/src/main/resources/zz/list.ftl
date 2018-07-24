<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="head-panel">
    <div class="search-panel form-inline">

        <form class="layui-form" action="$${"{ctx}"}/${table.entityName?lower_case}/list">


        </form>

    </div>

    <div class="button-panel" >


        <button class="layui-btn layui-btn-small" onclick="ueDialog.openFrameDialog('增加','$${"{ctx}"}/${table.entityName?lower_case}/toInput')">
            <i class="layui-icon">&#xe608;</i> 添加
        </button>
        <button class="layui-btn layui-btn-small" onclick="ueOperator.edit('gridTable','修改','$${"{ctx}"}/${table.entityName?lower_case}/toEdit')">
            <i class="layui-icon">&#xe642;</i>修改
        </button>
        <button class="layui-btn layui-btn-small layui-btn-danger" onclick="ueOperator.delete('gridTable','$${"{ctx}"}/${table.entityName?lower_case}/delete')">
            <i class="layui-icon">&#xe640;</i> 删除
        </button>



    </div>
</div>
</div>
<div class="grid-panel">
    <div class="jqGrid_wrapper">
        <table id="gridTable" class="gridTable"></table>
        <div id="pagerBar" class="pageBar"></div>
    </div>
</div>
<%@include file="/WEB-INF/views/common/footer.jsp" %>
<script>


    $(function() {

        var o = new Array();
        var colId = new Column("id","id",10,true);
        o.push(colId);

    <#assign seq = ["id"]>
    <#list table.columnList as being>
    <#if !seq?seq_contains(being.shortColumnName)>
        var col_${being.shortColumnName} = new Column("${being.columnComments}","${being.shortColumnName}");
        <#if being.columnType !="varchar" && being.columnType != "varchar2"  && being.columnType !="text"  && being.columnType !="char">
            <#if being.columnType !="varchar" && being.columnType != "varchar2"  && being.columnType !="text"  && being.columnType !="char">
            col_${being.shortColumnName}.formatter= formatter_${being.columnType};
            </#if>
        </#if>
        o.push(col_${being.shortColumnName});
    </#if>
    </#list>



        ueOperator.renderGrid("gridTable","$${"{ctx}"}/${table.entityName?lower_case}/jsonList",o);


    });
</script>


