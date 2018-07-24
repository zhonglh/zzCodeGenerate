<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/header.jsp" %>
<div class="modal-body">


    <form class="layui-form" action="$${"{ctx}"}/${table.entityName?lower_case}/save" id="inputForm">
        <div class="modal-body" style="padding-bottom: 50px">
        <input type="hidden" id="id" name="id" value="$${"{"}   ${table.shortTableName}1.id  ${"}"}">

        <#assign seq = ["id","createTime","createUserId","updateTime","updateUserId","versionNo"]>
        <#list table.columnList as being>
        <#if !seq?seq_contains(being.shortColumnName)>
        <div class="layui-form-item">
            <label class="layui-form-label">${being.columnComments}</label>
            <div class="layui-input-block">

                <input type="text" name="${being.shortColumnName}" id="${being.shortColumnName}" autocomplete="off"
                    <#if being.nullable == "NO" >lay_required="请先输入${being.columnComments}"</#if>
                    <#if being.columnPrecision != "0" > maxlength='${being.columnPrecision}' </#if>
                    <#if (being.validate)?? > data_type="${being.validate}" </#if>  value="$${"{"}   ${table.shortTableName}1.${being.shortColumnName}  ${"}"}"
                    <#if being.columnType=="date" || being.columnType=="datetime" || being.columnType=="timestamp"> onclick="layui.laydate({elem: this})" </#if>
                       placeholder="" class="layui-input">
            </div>
        </div>
        </#if>
        </#list>

        </div>

        <div class="navbar-fixed-bottom panel-footer text-right">
            <button class="layui-btn layui-btn-small" type="submit">保存</button>
            <button type="reset" class="layui-btn layui-btn-small">重置</button>
        </div>
    </form>
</div>


<%@include file="/WEB-INF/views/common/footer.jsp" %>
<script type="text/javascript">

</script>
<script src="$${"{ctx}"}/assets/common/ueverfy.js"></script>

