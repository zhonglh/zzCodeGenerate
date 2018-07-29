<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<div class="ibox float-e-margins">

				<div class="ibox-content">
					<div class="row row-lg">

						<table id="tables">

						</table>


							<div class="col-md-12 " style="position:absolute;left:0;top:0;">


								<div class="btn-group hidden-xs" id="exampleTableEventsToolbar"	role="group">

									<form id="addForm" >
									<div class="row ">
										<div class="col-sm-4" style="margin: 5px">
											<button type="button" id="docg" class="btn btn-outline btn-default" title='你确定要从这个表中读取吗?'  url='${ctx}/table/config/create' onClick="ajaxConfirm4Page('tables',this , 'addForm');">
												<i class="glyphicon glyphicon-wrench	" aria-hidden="true"></i>确认添加
											</button>
										</div>

										<div class="col-sm-4" style="margin: 5px">
											<select id="projectId" name="projectId" class="form-control">
												<c:forEach var="project"   items="${projects }"   varStatus="status1">
												<option value="${project.id }" >${project.projectName}</option>
												</c:forEach>
											</select>
										</div>

										<div class="col-sm-4" style="margin: 5px">
											<select id="dbId" name="dbId" class="form-control">
												<c:forEach var="dbConfig"   items="${dbConfigs }"   varStatus="status1">
													<option value="${dbConfig.id }" >${dbConfig.title}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									</form>


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
	    },{
	        field: 'tableName',
	        title: '表名称',
	        width:200
	    } ,{
            field: 'tableSchema',
            title: 'Schema',
            width:200
        } ,{
            field: 'tableType',
            title: '表类型',
            width:200
        },{
            field: 'tableComment',
            title: '表说明',
            width:200
        }  ];
		
		var $bt ;
		var $url ;
		
		function init(tablename,url){
			$url = url;
			$bt = $('#'+tablename).bootstrapTable({
			    url: url,
			    toolbar:'#exampleTableEventsToolbar',
			    dataType:'json',
			    pagination: false,
			    selectItemName:"id",
			    sidePagination:'server',
			    columns: columns1,
			    idField:'id',
			    showPaginationSwitch:true,
			    pageNumber:1,
			    pageSize:20000,
			    pageList:[10, 25, 50, 100],
			    searchOnEnterKey:true,
			    showRefresh:true,
			    showToggle:true,
			    striped:true,
			    clickToSelect:true,
			    singleSelect:false,
			    showHeader:true,
			    showFooter:false,
			    height: getHeight()-100
			});
			
		}


		
		$(window).resize(function () {
			$bt.bootstrapTable('resetView');
	    });

		$(parent).resize(function () {
			$bt.bootstrapTable('resetView');
	    });
		
		$("#dbId").change(function(){
			clkDb(this);
		});
		
		function clkDb(dbConfig){			
			var dbId = $(dbConfig).val();
			$bt.bootstrapTable('refresh', {url: '${ctx}/table/config/tableListByDbConfig/'+dbId});
			
		}


        init('tables','${ctx}/table/config/tableListByDbConfig/${dbId}');

	
	</script>
	
	

</body>
</html>