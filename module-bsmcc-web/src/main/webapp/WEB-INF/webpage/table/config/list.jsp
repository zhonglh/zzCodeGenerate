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
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="ibox float-e-margins" style="height:100%" >

			<div class="ibox-content" style="padding: 1px 1px 1px 1px;">
				<div class="row row-lg">

					<div class="col-sm-12">
						<!-- Example Events -->
						
						
						    <table id="tableForm">
						    
					    	</table>



						<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"	role="group">						
							
							<button id="b1"  msg="从现有数据库中选取表信息" type="button" class="btn btn-outline btn-default" url='${ctx}/table/config/create' onClick="createWin('tableForm',this,800,500);">
								<i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
							</button>							
						
							<button id="b2"  msg="编辑表格信息" type="button" class="btn btn-outline btn-default" url='${ctx}/table/config/{id}/tableOrViewUpdate' onClick="updateWin('tableForm',this);">
								<i class="glyphicon glyphicon-edit" aria-hidden="true"></i>
							</button>								
							
							<button id="b3" type="button" msg="删除无用数据"  class="btn btn-outline btn-default" confirm_message='你确定要删除选择的项目吗?' url='${ctx}/table/config/{id}/deleteAll' onClick="ajaxConfirm('tableForm',this);">
								<i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
							</button>

								
						</div>


					</div>
				</div>
			</div>



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





        var columns1 = [{
            field: 'aa',
            title: '选择',
            checkbox:true,
            width:40
        },{
            field: 'id',
            visible:false
        }, {
            field: 'dbConfigTitle',
            title: '数据库',
            width:120
        },{
            field: 'projectName',
            title: '项目',
            width:120
        }, {
            field: 'moduleName',
            title: '模块',
            width:120
        }, {
            field: 'tableName',
            title: '表名',
            width:120
        }, {
            field: 'javaName',
            title: 'Java名称',
            width:120
        }, {
            field: 'tableComment',
            title: '表说明'
        }];
		debugger;
		init('tableForm','${ctx}/table/config/list');
		
		



		$(".btn-outline").mouseover(function(){
				var message = $(this).attr("msg");
				if(message == null || message == "" || message == undefined ) return ;
				var id = $(this).attr("id");
				layer.tips(message,'#'+id, {
				  tips: [1, '#3595CC'],
				  time: 2000
				});
		});

		function refreshTable() {
			$('#tableForm').bootstrapTable('refresh');
		}

	</script>
	
	

</body>
</html>