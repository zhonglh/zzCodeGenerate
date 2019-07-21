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


<title>ZZ代码生成平台</title>

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
                        <form class="form-horizontal m-t" method="post" id="signupForm" action="${ctx}/code/build/log/cg">
                        
                        	<input type="hidden" id="id" name="id" value="${entity.id }"/>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">项目：</label>
                                <div class="col-sm-8">

                                    <select id="projectId" name="projectId"  class="form-control">
                                        <c:forEach items="${projects}" var="project">
                                            <option value="${project.id}" <c:if test="${entity.projectId ==  project.id }">selected="selected"</c:if> >${project.projectName}</option>
                                        </c:forEach>
                                    </select>



                                </div>
                            </div>




                            <div class="form-group">
                                <label class="col-sm-3 control-label">模板组：</label>
                                <div class="col-sm-8">
                                    <select id="templetGroupId" name="templetGroupId"  class="form-control">
                                        <c:forEach items="${groups}" var="group">
                                            <option value="${group.id}" <c:if test="${entity.templetGroupId ==  group.id }">selected="selected"</c:if> >${group.groupName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>




                            <div class="form-group">
                                <label class="col-sm-3 control-label">依赖项目：</label>
                                <div class="col-sm-8">

                                    <select id="dependentProjectId" name="dependentProjectId"  class="form-control">
                                        <c:forEach items="${projects}" var="project">
                                            <option value="${project.id}" <c:if test="${entity.projectId ==  project.id }">selected="selected"</c:if> >${project.projectName}</option>
                                        </c:forEach>
                                    </select>



                                </div>
                            </div>
                        

                            
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" onclick="submitForm()">生成</button>
                                    <button class="btn btn-primary" onclick="download()">下载</button>
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
		    password: "required",
		    confirm_password: {
		      equalTo: "#dbPassword"
		    }
		  }
	});
	
	function submitForm(){

		
		if( !$('form').valid() ) return false;


        $('form').attr('action','${ctx}/code/build/log/cg');

		//var actionurl = window.location.href;
        var actionurl = $('form').attr('action');

        $('form').attr('onSubmit','javaScript:return false;');
		   
		var formData = $('form').serializeArray();
		
		var ajax =  ajaxSyncData(actionurl,formData);
		
		if(ajax.success){	
			
			topShwoMessage("info",ajax.msg);
			top.iframe90.window.refreshTable();
			window.setTimeout(function(){top.layer.closeAll();},2000);
			
		}else {
			topShwoMessage("error",ajax.msg);
		}
	}


	function download(){

        if( !$('form').valid() ) return false;

        $('form').attr('action','${ctx}/code/build/log/download');

        $('form').removeAttr('onSubmit');

        $('form')[0].submit();

    }
	
	</script>

</body>
</html>