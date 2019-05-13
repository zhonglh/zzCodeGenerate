<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
    session.setAttribute("lang", "zh-cn");
%>


<!DOCTYPE html>
<html lang="cn">


<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>福布罗代码生成平台</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx}/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx}/statics/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="${ctx}/statics/css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/statics/css/style.min.css?v=4.1.0" rel="stylesheet">
    <link href="${ctx}/statics/css/plugins/bootstrap-table/bootstrap-table.min.css"  rel="stylesheet">

    <link href="${ctx}/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${ctx}/statics/css/plugins/steps/jquery.steps.css" rel="stylesheet">


    <link rel="stylesheet" href="${ctx}/statics/css/layer.css"  id="layui_layer_skinlayercss">
    <link rel="stylesheet" href="${ctx}/statics/css/layer.ext.css"  id="layui_layer_skinlayerextcss">

    <link href="${ctx}/statics/css/toastr.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
</head>

</head>

<body class="gray-bg">
<div class="animated">

    <div class="ibox-content">

    <form id="form" class="form-horizontal m-t">

        <input type="hidden" id="id" name="id" value="${entity.id }">


        <div class="form-group">
            <label class="col-sm-3 control-label">模块：</label>
            <div class="col-sm-8">
                <select id="moduleId" name="moduleId" class="form-control">
                    <option value="" ></option>
                    <c:forEach var="module"   items="${modules }"   varStatus="status1">
                        <option value="${module.id }" <c:if test="${module.id == entity.moduleId}">selected="selected"</c:if>  >${module.moduleName}</option>
                    </c:forEach>
                </select>
            </div>

        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Schema </label>
            <div class="col-sm-8">
                <input id="schemaName" name="schemaName" value="${entity.schemaName }" readonly type="text" class="form-control required">
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label">视图名 </label>
            <div class="col-sm-8">
                <input id="tableName" name="tableName" value="${entity.tableName }" readonly type="text" class="form-control required">
            </div>

        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">视图描述 *</label>
            <div class="col-sm-8">
                <input id="tableComment" name="tableComment" value="${entity.tableComment }"  type="text" class="form-control required">
            </div>

        </div>



        <c:if test="${entity.isTable == '0'}">
        <div class="form-group">
            <label class="col-sm-3 control-label">主要表Schema </label>
            <div class="col-sm-8">
                <input id="mainTableSchema" name="mainTableSchema" value="${entity.mainTableSchema }"  type="text" class="form-control">
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label">主要表名称 </label>
            <div class="col-sm-8">
            <input id="mainTableName" name="mainTableName" value="${entity.mainTableName }"  type="text" class="form-control">
            </div>
        </div>
        </c:if>


        <div class="form-group">
            <label class="col-sm-3 control-label">业务名称列 *</label>
            <div class="col-sm-8">
                <input id="businessName" name="businessName" value="${entity.businessName }"  type="text" class="form-control">
            </div>

        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">业务主键列 *</label>
            <div class="col-sm-8">
                <input id="businessKey" name="businessKey" value="${entity.businessKey }"  type="text" class="form-control">
            </div>

        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">是否为树状</label>
            <div class="col-sm-8">
            <select id="isTree" name="isTree"  class="form-control required" onchange="changeIsTree(this)">
                <option value="1"  <c:if test="${entity.isTree ==  '1' }">selected="selected"</c:if> >是</option>
                <option value="0"  <c:if test="${entity.isTree ==  '0' }">selected="selected"</c:if> >否</option>
            </select>
            </div>
        </div>



        <div class="form-group">
            <label class="col-sm-3 control-label">上级字段名称</label>
            <div class="col-sm-8">
                <input id="parentFieldName" name="parentFieldName" value="${entity.parentFieldName }"  type="text" class="form-control">
            </div>
        </div>



        <div class="form-group">
            <div class="col-sm-8 col-sm-offset-3">
                <button class="btn btn-primary" onclick="submitForm()">提交</button>
            </div>
        </div>


    </form>

    </div>
</div>


<script src="${ctx}/statics/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx}/statics/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${ctx}/statics/js/content.min.js?v=1.0.0"></script>
<script src="${ctx}/statics/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${ctx}/statics/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script
        src="${ctx}/statics/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${ctx}/statics/js/demo/bootstrap-table-demo.min.js"></script>
<script src="${ctx}/statics/js/layer.min.js"></script>

<script src="${ctx}/statics/js/plugins/staps/jquery.steps.min.js"></script>
<script src="${ctx}/statics/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/statics/js/plugins/validate/messages_zh.min.js"></script>

<script src="${ctx}/statics/plug-in/ajax/AjaxUtil.js"></script>
<script src="${ctx}/statics/plug-in/ajax/curd.js"></script>
<script src="${ctx}/statics/plug-in/toastr/toastr.min.js"></script>
<script src="${ctx}/statics/plug-in/toastr/toastr.js"></script>




<script>

    var tableId = '${entity.id }';


    function changeIsTree(isTree){
        var $isTree = $(isTree);
        if($isTree.val() == "1"){
            $("#parentFieldName").removeAttr("readonly");
        }else {
            $("#parentFieldName").attr("readonly" , "readonly");
            $("#parentFieldName").val("");
        }
    }

    function submitForm(){


        if( !$('form').valid() ) return false;

        var actionurl= window.location.href;
        //$('form').attr('action');

        var formData = $('form').serializeArray();

        var ajax =  ajaxSyncData(actionurl,formData);

        if(ajax.success){
            alert(ajax.msg);
            top.layer.closeAll();

            top.iframe40.window.refreshTable();

        }else {
            topShwoMessage("error",ajax.msg);
        }
    }


</script>

</body>
</html>