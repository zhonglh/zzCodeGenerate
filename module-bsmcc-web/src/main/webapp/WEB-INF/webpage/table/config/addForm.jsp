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


<title>代码生成平台</title>

<link rel="shortcut icon" href="favicon.ico">
<link href="${ctx}/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/statics/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

<link href="${ctx}/statics/css/animate.min.css" rel="stylesheet">
<link href="${ctx}/statics/css/style.min.css?v=4.1.0" rel="stylesheet">
<link href="${ctx}/statics/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
	
	
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
		<form class="form-horizontal m-t" action="${ctx}/table/config/toNext" id="signupForm" >





			<div class="form-group">
				<label class="col-sm-3 control-label">项目：</label>
				<div class="col-sm-8">

					<select id="projectId" name="projectId"  class="form-control"  onchange="changeProject(this)">
						<c:forEach items="${projects}" var="project">
							<option value="${project.id}" <c:if test="${entity.projectId ==  project.id }">selected="selected"</c:if> >${project.projectName}</option>
						</c:forEach>
					</select>
				</div>
			</div>



			<div class="form-group">
				<label class="col-sm-3 control-label">数据库：</label>
				<div class="col-sm-8">

					<select id="dbId" name="dbId" class="form-control">
						<c:forEach var="dbConfig"   items="${dbConfigs }"   varStatus="status1">
							<option value="${dbConfig.id }" >${dbConfig.title}</option>
						</c:forEach>
					</select>
				</div>
			</div>




			<div class="form-group">
				<label class="col-sm-3 control-label">Schema：</label>
				<div class="col-sm-8">
					<input id="schemaName" name="schemaName"  class="form-control" type="text"   aria-invalid="true"  class="error">
				</div>
			</div>







			<div class="form-group">
				<div class="col-sm-8 col-sm-offset-3">
					<button class="btn btn-primary" onclick="submitForm(this.form)">下一步</button>
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
    <script src="${ctx}/statics/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="${ctx}/statics/js/demo/bootstrap-table-demo.min.js"></script>
    <script src="${ctx}/statics/js/layer.min.js"></script>

	<script src="${ctx}/statics/plug-in/ajax/AjaxUtil.js"></script>
	<script src="${ctx}/statics/plug-in/ajax/curd.js"></script>
	<script src="${ctx}/statics/plug-in/toastr/toastr.min.js"></script>
	<script src="${ctx}/statics/plug-in/toastr/toastr.js"></script>
	<script type="text/javascript">

		function submitForm(f) {
			f.submit();
		}


	
	</script>
	
	

</body>
</html>