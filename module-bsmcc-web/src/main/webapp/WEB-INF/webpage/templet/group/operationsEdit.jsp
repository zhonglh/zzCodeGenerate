<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link href="${ctx}/statics/css/plugins/bootstrap-table/bootstrap-table.min.css"
          rel="stylesheet">


    <link rel="stylesheet" href="${ctx}/statics/css/layer.css" id="layui_layer_skinlayercss">
    <link rel="stylesheet" href="${ctx}/statics/css/layer.ext.css" id="layui_layer_skinlayerextcss">

    <link href="${ctx}/statics/css/toastr.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
</head>

</head>




<body class="gray-bg">
<div class="animated">

    <div class="ibox-content">
        <form class="form-horizontal m-t" onSubmit="javaScript:return false;" id="signupForm" >

            <div class="row">
                <div class="col-xs-12">

                    <table width="100%">

                        <thead>

                        <th width="80">序号</th>
                        <th width="150">按钮名称</th>
                        <th width="150">按钮资源</th>
                        <th width="150">ICON</th>
                        <th width="150">Style</th>
                        <th width="150">Class</th>
                        <th width="150">位置</th>
                        <th width="150">按钮类型</th>
                        <th width="150">顺序</th>
                        </thead>

                        <tbody>
                        <c:forEach var="operation"   items="${operations}"   varStatus="status1">
                            <tr>

                                <td>${status1.index+1 }</td>
                                <td>
                                        ${operation.operationName }
                                    <input type="hidden" id="templetGroupOperations[${status1.index }].id" name="templetGroupOperations[${status1.index }].id" value="${operation.id }" />
                                    <input type="hidden" id="templetGroupOperations[${status1.index }].operationId" name="templetGroupOperations[${status1.index }].operationId" value="${operation.operationId }" />
                                </td>
                                <td>${operation.operationResource }</td>


                                <td><input type="text" size="8"  id="templetGroupOperations[${status1.index }].icons" name="templetGroupOperations[${status1.index }].icons" value="${operation.icons }" /></td>
                                <td><input type="text" size="8"  id="templetGroupOperations[${status1.index }].styles" name="templetGroupOperations[${status1.index }].styles" value="${operation.styles }" /></td>
                                <td><input type="text" size="8"  id="templetGroupOperations[${status1.index }].classs" name="templetGroupOperations[${status1.index }].classs" value="${operation.classs }" /></td>
                                <td>
                                <select style="width: 100px;" id="templetGroupOperations[${status1.index }].position" name="templetGroupOperations[${status1.index }].position" class="form-control required">
                                    <option value="top"     <c:if test="${operation.position ==  'top' }">selected="selected"</c:if>>工具栏</option>
                                    <option value="right"   <c:if test="${operation.position ==  'right' }">selected="selected"</c:if>>操作列</option>
                                    <option value="all"     <c:if test="${operation.position ==  'all' }">selected="selected"</c:if>>全部</option>
                                </select>
                                </td>
                                <td><input type="text"  id="templetGroupOperations[${status1.index }].other" name="templetGroupOperations[${status1.index }].other" value="${operation.other }" /></td>

                                <td><input type="text" size="6"  class="required" id="templetGroupOperations[${status1.index }].sort" name="templetGroupOperations[${status1.index }].sort" value="${operation.sort }" /></td>



                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <br><br>



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


<script src="${ctx}/statics/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx}/statics/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx}/statics/js/demo/form-validate-demo.min.js"></script>
<script src="${ctx}/statics/plug-in/ajax/AjaxUtil.js"></script>

<script src="${ctx}/statics/js/layer.min.js"></script>


<script src="${ctx}/statics/plug-in/toastr/toastr.min.js"></script>
<script src="${ctx}/statics/plug-in/toastr/toastr.js"></script>

<script type="text/javascript">

    var ctx = "${ctx}";


    function submitForm(){


        if( !$('form').valid() ) return false;

        var actionurl= window.location.href;
        //$('form').attr('action');

        var formData = $('form').serializeArray();

        var ajax =  ajaxSyncData(actionurl,formData);

        if(ajax.success){

            topShwoMessage("info",ajax.msg);
            top.iframe5.window.refreshTable();
            window.setTimeout(function(){top.layer.closeAll();},2000);

        }else {
            topShwoMessage("error",ajax.msg);
        }
    }

</script>

</body>
</html>