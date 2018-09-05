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

<body class="gray-bg">
    <div class="animated">
       
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" onSubmit="javaScript:return false;" id="signupForm" >
                        
                        	<input type="hidden" id="id" name="id" value="${entity.id }"/>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">项目名称：</label>
                                <div class="col-sm-8">
                                    <input id="projectName" name="projectName" value="${entity.projectName }" class="form-control" type="text" aria-required="true" aria-invalid="true" required="true" class="error">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">项目包名：</label>
                                <div class="col-sm-8">
                                    <input id="projectPackage" name="projectPackage" value="${entity.projectPackage }" class="form-control" type="text" aria-required="true" aria-invalid="true" required="true" class="error">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Java包名是否要包含模块：</label>
                                <div class="col-sm-8">
                                    <select id="packageIncludeModule" name="packageIncludeModule"  class="form-control">
                                        <option value="0" <c:if test="${entity.packageIncludeModule ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                        <option value="1" <c:if test="${entity.packageIncludeModule ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">查询模式：</label>
                                <div class="col-sm-8">
                                    <select id="queryMode" name="queryMode"  class="form-control">
                                        <option value="toolbar" <c:if test="${entity.queryMode ==  'toolbar' }">selected="selected"</c:if> hassubinfo="true">工具栏样式</option>
                                        <option value="ordinary" <c:if test="${entity.queryMode ==  'ordinary' }">selected="selected"</c:if> hassubinfo="true">普通样式</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">项目经理姓名：</label>
                                <div class="col-sm-8">
                                    <input id="projectLead" name="projectLead" value="${entity.projectLead }" class="form-control" type="text" aria-required="true" aria-invalid="true" required="true" class="error">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">作者：</label>
                                <div class="col-sm-8">
                                    <input id="projectAuthor" name="projectAuthor" value="${entity.projectAuthor }" class="form-control" type="text" aria-required="true" aria-invalid="true" required="true" class="error">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">代码总的注释：</label>
                                <div class="col-sm-8">
                                    <textarea style="width : 100%" rows="5" id="projectNote" name="projectNote">${entity.projectNote }</textarea>
                                </div>
                            </div>
                        
                            <div class="form-group">
                                <label class="col-sm-3 control-label">国际化：</label>
                                <div class="col-sm-8">
                                   
                                <select id="projectI18n" name="projectI18n"  class="form-control">
                                    <option value="0" <c:if test="${entity.projectI18n ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                    <option value="1" <c:if test="${entity.projectI18n ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">租户模式：</label>
                                <div class="col-sm-8">

                                    <select id="projectTenant" name="projectTenant"  class="form-control">
                                        <option value="0" <c:if test="${entity.projectTenant ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                        <option value="1" <c:if test="${entity.projectTenant ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">页面使用视图：</label>
                                <div class="col-sm-8">

                                    <select id="pageUseView" name="pageUseView"  class="form-control">
                                        <option value="0" <c:if test="${entity.pageUseView ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                        <option value="1" <c:if test="${entity.pageUseView ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否自动创建扩展列：</label>
                                <div class="col-sm-8">
                                    <select id="autoExColumn" name="autoExColumn"  class="form-control">
                                        <option value="0" <c:if test="${entity.autoExColumn ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                        <option value="1" <c:if test="${entity.autoExColumn ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                    </select>
                                </div>
                            </div>



                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否有多个Schema：</label>
                                <div class="col-sm-8">
                                    <select id="isMultiSchema" name="isMultiSchema"  class="form-control" onchange="changeMultiSchema(this)">
                                        <option value="0" <c:if test="${entity.isMultiSchema ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                        <option value="1" <c:if test="${entity.isMultiSchema ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">Scheam名称：</label>
                                <div class="col-sm-8">
                                    <input id="otherSchema" name="otherSchema" value="${entity.otherSchema }" class="form-control" placeholder="多个Schema用逗号隔开" readonly type="text" aria-required="true" aria-invalid="true"  class="error">
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
    
    <script src="${ctx}/statics/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${ctx}/statics/js/plugins/validate/messages_zh.min.js"></script>
    <script src="${ctx}/statics/js/demo/form-validate-demo.min.js"></script>
	<script src="${ctx}/statics/plug-in/ajax/AjaxUtil.js"></script>
    <script src="${ctx}/statics/js/layer.min.js"></script>
	<script src="${ctx}/statics/plug-in/toastr/toastr.min.js"></script>
	<script src="${ctx}/statics/plug-in/toastr/toastr.js"></script>
	<script type="text/javascript">

    var ctx = "${ctx}";
	$( "#signupForm" ).validate({
		  rules: {

		  }
	});


    function changeMultiSchema(ms){
        var $ms = $(ms);
        if($ms.val() == "1"){
            $("#otherSchema").removeAttr("readonly");
        }else {
            $("#otherSchema").attr("readonly" , "readonly");
            $("#otherSchema").val("");
        }
    }
	
	function submitForm(){

		
		if( !$('form').valid() ) return false;

		var actionurl= window.location.href;
            //$('form').attr('action');
		   
		var formData = $('form').serializeArray();
		
		var ajax =  ajaxSyncData(actionurl,formData);
		
		if(ajax.success){	
			
			topShwoMessage("info",ajax.msg);
			top.iframe20.window.refreshTable();
			window.setTimeout(function(){top.layer.closeAll();},2000);
			
		}else {
			topShwoMessage("error",ajax.msg);
		}
	}
	
	</script>

</body>
</html>