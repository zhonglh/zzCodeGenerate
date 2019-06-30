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
                        
                        	<input type="hidden" id="id" name="id" value="${entity.id }"/>




                            <div class="form-group">
                                <label class="col-sm-3 control-label">模板组：</label>
                                <div class="col-sm-8">
                                    <select id="groupId" name="groupId"  class="form-control">
                                        <c:forEach items="${groups}" var="group">
                                            <option value="${group.id}" <c:if test="${entity.groupId ==  group.id }">selected="selected"</c:if> >${group.groupName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>



                            <div class="form-group">
                                <label class="col-sm-3 control-label">生成文件的文件类型：</label>
                                <div class="col-sm-8">
                                    <select id="fileType" name="fileType"  class="form-control">
                                        <c:forEach items="${fileTypes}" var="fileType">
                                            <option value="${fileType.value}" <c:if test="${entity.fileType ==  fileType.value }">selected="selected"</c:if> >${fileType.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>



                            <div class="form-group">
                                <label class="col-sm-3 control-label">生成文件外文件夹：</label>
                                <div class="col-sm-8">
                                    <input id="fileOutDir" name="fileOutDir" value="${entity.fileOutDir }" class="form-control" type="text" aria-required="true" aria-invalid="true" required="true" class="error">
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">生成文件内文件夹：</label>
                                <div class="col-sm-8">
                                    <input id="fileInnerDir" name="fileInnerDir" value="${entity.fileInnerDir }" class="form-control" type="text" aria-invalid="true" class="error">
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否UI：</label>
                                <div class="col-sm-8">

                                    <select id="isUi" name="isUi"  class="form-control">
                                        <option value="1" <c:if test="${entity.isUi ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                        <option value="0" <c:if test="${entity.isUi ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否菜单SQL：</label>
                                <div class="col-sm-8">

                                    <select id="isMenuSql" name="isMenuSql"  class="form-control">
                                        <option value="1" <c:if test="${entity.isMenuSql ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                        <option value="0" <c:if test="${entity.isMenuSql ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                    </select>
                                </div>
                            </div>




                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否权限SQL：</label>
                                <div class="col-sm-8">

                                    <select id="isRbacSql" name="isRbacSql"  class="form-control">
                                        <option value="1" <c:if test="${entity.isRbacSql ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                        <option value="0" <c:if test="${entity.isRbacSql ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                    </select>
                                </div>
                            </div>




                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否字典SQL：</label>
                                <div class="col-sm-8">
                                    <select id="isDictSql" name="isDictSql"  class="form-control">
                                        <option value="1" <c:if test="${entity.isDictSql ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                        <option value="0" <c:if test="${entity.isDictSql ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">生成文件的后缀：</label>
                                <div class="col-sm-8">
                                    <input id="fileSuffix" name="fileSuffix" value="${entity.fileSuffix }" class="form-control" type="text"  aria-invalid="true"  class="error">
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">文件名是否要包含对象名：</label>
                                <div class="col-sm-8">

                                    <select id="haveObjectName" name="haveObjectName"  class="form-control">
                                        <option value="1" <c:if test="${entity.haveObjectName ==  '1' }">selected="selected"</c:if> hassubinfo="true">是</option>
                                        <option value="0" <c:if test="${entity.haveObjectName ==  '0' }">selected="selected"</c:if> hassubinfo="true">否</option>
                                    </select>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-3 control-label">模板标题：</label>
                                <div class="col-sm-8">
                                    <input id="templetTitle" name="templetTitle" value="${entity.templetTitle }" class="form-control" type="text" aria-required="true" aria-invalid="true" required="true" class="error">

                                </div>
                            </div>



                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否仅限于关联表：</label>
                                <div class="col-sm-8">

                                    <select id="effectiveReal" name="effectiveReal"  class="form-control">
                                        <option value="" >全部</option>
                                        <option value="1" <c:if test="${entity.effectiveReal ==  '1' }">selected="selected"</c:if> hassubinfo="true">关联表</option>
                                        <option value="0" <c:if test="${entity.effectiveReal ==  '0' }">selected="selected"</c:if> hassubinfo="true">非关联表</option>
                                    </select>
                                </div>
                            </div>



                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否仅限于树状：</label>
                                <div class="col-sm-8">

                                    <select id="effectiveTree" name="effectiveTree"  class="form-control">
                                        <option value="" >全部</option>
                                        <option value="1" <c:if test="${entity.effectiveTree ==  '1' }">selected="selected"</c:if> hassubinfo="true">树状</option>
                                        <option value="0" <c:if test="${entity.effectiveTree ==  '0' }">selected="selected"</c:if> hassubinfo="true">非树状</option>
                                    </select>
                                </div>
                            </div>



                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否仅限于单表界面：</label>
                                <div class="col-sm-8">

                                    <select id="effectiveSingle" name="effectiveSingle"  class="form-control">
                                        <option value="" >全部</option>
                                        <option value="1" <c:if test="${entity.effectiveSingle ==  '1' }">selected="selected"</c:if> hassubinfo="true">单表界面</option>
                                        <option value="0" <c:if test="${entity.effectiveSingle ==  '0' }">selected="selected"</c:if> hassubinfo="true">组合表界面</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label">是否仅限于视图：</label>
                                <div class="col-sm-8">

                                    <select id="effectiveView" name="effectiveSingle"  class="form-control">
                                        <option value="" >全部</option>
                                        <option value="1" <c:if test="${entity.effectiveView ==  '1' }">selected="selected"</c:if> hassubinfo="true">视图(view)</option>
                                        <option value="0" <c:if test="${entity.effectiveView ==  '0' }">selected="selected"</c:if> hassubinfo="true">表(table)</option>
                                    </select>
                                </div>
                            </div>



                            <div class="form-group">
                                <label class="col-sm-3 control-label">模板内容：</label>
                                <div class="col-sm-8">
                                    <textarea rows="30" style="width:100%;" id="templetContent" name="templetContent"><c:out value="${entity.templetContent}" escapeXml="true"/></textarea></div>
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

	function checkIs(){
	    var isUi = $("#isUi").val();
        var isMenuSql = $("#isMenuSql").val();
        var isRbacSql = $("#isRbacSql").val();
        var count = parseInt(isUi) + parseInt(isMenuSql) + parseInt(isRbacSql);
        if(count > 1){
            topShwoMessage("info","是否UI , 是否菜单SQL 和 是否权限SQL 只能选择一个为是");
            return false;
        }
        return true;
    }
	
	function submitForm(){

		
		if( !$('form').valid() ) return false;

		if( ! checkIs() ) return false;

		var actionurl= window.location.href;
            //$('form').attr('action');
		   
		var formData = $('form').serializeArray();
		
		var ajax =  ajaxSyncData(actionurl,formData);
		
		if(ajax.success){	
			
			topShwoMessage("info",ajax.msg);
			top.iframe6.window.refreshTable();
			window.setTimeout(function(){top.layer.closeAll();},2000);
			
		}else {
			topShwoMessage("error",ajax.msg);
		}
	}
	
	</script>

</body>
</html>