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
<div class="wrapper wrapper-content animated fadeInRight">


    <form id="form" action="${ctx}/table/config/${entity.id}/updateAll" class="wizard-big">

        <input type="hidden" id="id" name="id" value="${entity.id }">

        <h1>表信息</h1>
        <fieldset>
            <div class="row">
                <div class="col-sm-6">


                    <div class="form-group">
                        <label>数据库：</label>
                        <input type="hidden" name="dbId" id="dbId" value="${entity.dbId}" />
                        <input id="dbConfigTitle" name="dbConfigTitle" value="${entity.dbConfigTitle }" readonly type="text" class="form-control">
                    </div>

                    <div class="form-group">
                        <label>项目：</label>
                        <input type="hidden" name="projectId" id="projectId" value="${entity.projectId}" />
                        <input id="projectName" name="projectName" value="${entity.projectName }" readonly type="text" class="form-control">

                    </div>


                    <div class="form-group">
                        <label>模块：</label>
                        <select id="moduleId" name="moduleId" class="form-control required">
                            <c:forEach var="module"   items="${modules }"   varStatus="status1">
                                <option value="${module.id }" >${module.moduleName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Schema </label> <input id="schemaName" name="schemaName" value="${entity.schemaName }" readonly type="text" class="form-control required">
                    </div>
                    <div class="form-group">
                        <label>表名 </label> <input id="tableName" name="tableName" value="${entity.tableName }" readonly type="text" class="form-control required">
                    </div>
                    <div class="form-group">
                        <label>表描述 *</label> <input id="tableComment" name="tableComment" value="${entity.tableComment }"  type="text" class="form-control required">
                    </div>

                    <div class="form-group">
                        <label>是否生成UI：</label>
                        <select id="isBuildController" name="isBuildController"  class="form-control required">
                            <option value="1"  <c:if test="${entity.isBuildController ==  '1' }">selected="selected"</c:if> > 是 </option>
                            <option value="0"   <c:if test="${entity.isBuildController ==  '0' }">selected="selected"</c:if>  > 否 </option>
                        </select>
                    </div>




                    <div class="form-group">
                        <label>是否生成菜单数据：</label>
                        <select id="isBuildMenu" name="isBuildMenu"  class="form-control required">
                            <option value="1"  <c:if test="${entity.isBuildMenu ==  '1' }">selected="selected"</c:if> > 是 </option>
                            <option value="0"   <c:if test="${entity.isBuildMenu ==  '0' }">selected="selected"</c:if>  > 否 </option>
                        </select>
                    </div>



                </div>



                <div class="col-sm-6">


                    <div class="form-group">
                        <label>显示复选框：</label>
                        <select id="isShowCheckbox" name="isShowCheckbox"  class="form-control">
                            <option value="1"  <c:if test="${entity.isShowCheckbox ==  '1' }">selected="selected"</c:if> >是</option>
                            <option value="0"  <c:if test="${entity.isShowCheckbox ==  '0' }">selected="selected"</c:if> >否</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>表类型：</label>
                        <select id="tableType" name="tableType"  class="form-control">
                            <option value="1"  <c:if test="${entity.tableType ==  '1' }">selected="selected"</c:if> >单表</option>
                            <option value="2"  <c:if test="${entity.tableType ==  '2' }">selected="selected"</c:if> >主表</option>
                            <option value="3"  <c:if test="${entity.tableType ==  '3' }">selected="selected"</c:if> >副表</option>
                            <option value="4"  <c:if test="${entity.tableType ==  '4' }">selected="selected"</c:if> >子表</option>
                        </select>
                    </div>




                    <div class="form-group">
                        <label>和主表的关系：</label>
                        <select id="tableRelation" name="tableRelation"  class="form-control">
                            <option value="one-one"  <c:if test="${entity.tableRelation ==  'one-one' }">selected="selected"</c:if> >一对一</option>
                            <option value="one-multi"   <c:if test="${entity.tableRelation ==  'one-multi' }">selected="selected"</c:if>  >一对多</option>
                        </select>
                    </div>





                    <div class="form-group">
                        <label>查询条件模式：</label>
                        <select id="queryMode" name="queryMode"  class="form-control required">
                            <option value="toolbar"  <c:if test="${entity.queryMode ==  'toolbar' }">selected="selected"</c:if> > 工具栏样式 </option>
                            <option value="ordinary"   <c:if test="${entity.queryMode ==  'ordinary' }">selected="selected"</c:if>  > 常用样式 </option>
                        </select>
                    </div>




                    <c:if test="${entity.isTable == '0'}">
                    <div class="form-group">
                        <label>主要的表(视图中的主表)：</label>
                        <select id="mainTableId" name="mainTableId"  class="form-control required">
                            <c:forEach items="${tables}" var="table">
                                <option value="${table.id}"  <c:if test="${entity.mainTableId ==  table.id }">selected="selected"</c:if> >${table.tableName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    </c:if>



                    <div class="form-group">
                        <label>资源名称 *</label> <input id="resourceName" name="resourceName" value="${entity.resourceName }"  type="text" class="form-control required">
                    </div>


                    <div class="form-group">
                        <label>Java 简称</label> <input id="javaName" name="javaName" value="${entity.javaName }"  type="text" class="form-control required">
                    </div>

                    <div class="form-group">
                        <label>是否为树状</label>
                        <select id="isTree" name="isTree"  class="form-control required">
                            <option value="1"  <c:if test="${entity.isTree ==  '1' }">selected="selected"</c:if> >是</option>
                            <option value="0"  <c:if test="${entity.isTree ==  '0' }">selected="selected"</c:if> >否</option>
                        </select>
                    </div>



                    <div class="form-group">
                        <label>上级字段名称</label> <input id="parentFieldName" name="parentFieldName" value="${entity.parentFieldName }"  type="text" class="form-control">
                    </div>


                </div>
                <div class="col-sm-4">
                    <div class="text-center">
                        <div style="margin-top: 20px">
                            <i class="fa fa-sign-in"
                               style="font-size: 180px; color: #e5e5e5"></i>
                        </div>
                    </div>
                </div>
            </div>

        </fieldset>


        <h1>列信息</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">

                    <table width="100%">

                        <thead>

                        <th width="80">序号</th>
                        <th width="350">列名称</th>
                        <th width="350">列类型</th>
                        <th width="350">列长度</th>
                        <th width="350">小数点位数</th>
                        <th width="350">允许空值</th>
                        <th width="150">顺序</th>
                        <th width="150">是否为主键</th>
                        <th width="150">是否为外键</th>
                        <th width="150">是否为字典</th>
                        <th width="150">字典类型</th>
                        <th width="350">列说明</th>
                        <th width="350">Java类全称</th>
                        <th width="350">Java名称</th>
                        <th width="350">组编码</th>

                        </thead>

                        <tbody>
                        <c:forEach var="column"   items="${columnConfigs}"   varStatus="status1">
                            <tr>
                                <td>${status1.index+1 }</td>
                                <td>${column.columnName }</td>
                                <td>${column.columnType }</td>

                                <td>${column.columnLength }</td>
                                <td>${column.columnScale }</td>
                                <td>${column.columnIsnullName }</td>

                                <td>
                                    <input type="hidden" id="columns[${status1.index }].id" name="columns[${status1.index }].id" value="${column.id }" />
                                    <input type="hidden" id="columns[${status1.index }].tableId" name="columns[${status1.index }].tableId" value="${column.tableId }" />
                                    <input type="number" required id="columns[${status1.index }].columnSort" name="columns[${status1.index }].columnSort" value="${column.columnSort }" size="10" />
                                </td>

                                <td>
                                    <select name="columns[${status1.index }].columnIskey" >
                                        <option value="1" <c:if test="${column.columnIskey ==  '1' }">selected="selected"</c:if>>是</option>
                                        <option value="0" <c:if test="${column.columnIskey ==  '0' }">selected="selected"</c:if>>否</option>
                                    </select>
                                </td>

                                <td>
                                    <select name="columns[${status1.index }].columnIsfk" >
                                        <option value="1" <c:if test="${column.columnIsfk ==  '1' }">selected="selected"</c:if>>是</option>
                                        <option value="0" <c:if test="${column.columnIsfk ==  '0' }">selected="selected"</c:if>>否</option>
                                    </select>
                                </td>

                                <td>
                                    <select name="columns[${status1.index }].columnIsdict" >
                                        <option value="1" <c:if test="${column.columnIsdict ==  '1' }">selected="selected"</c:if>>是</option>
                                        <option value="0" <c:if test="${column.columnIsdict ==  '0' }">selected="selected"</c:if>>否</option>
                                    </select>
                                </td>


                                <td><input type="text" id="columns[${status1.index }].dictType" name="columns[${status1.index }].dictType" value="${column.dictType }" /></td>
                                <td><input type="text" required id="columns[${status1.index }].columnComment" name="columns[${status1.index }].columnComment" value="${column.columnComment }" /></td>

                                <td><input type="text"  id="columns[${status1.index }].fkSchema" name="exColumns[${status1.index }].fkSchema" value="${column.fkSchema }" /></td>
                                <td><input type="text"  id="columns[${status1.index }].fkName" name="exColumns[${status1.index }].fkName" value="${column.fkName }" /></td>



                                <td><input type="text" required id="columns[${status1.index }].javaFullClass" name="columns[${status1.index }].javaFullClass" value="${column.javaFullClass }" /></td>
                                <td><input type="text" required id="columns[${status1.index }].javaName" name="columns[${status1.index }].javaName" value="${column.javaName }" /></td>
                                <td><input type="text"  id="columns[${status1.index }].groupCode" name="columns[${status1.index }].groupCode" value="${column.groupCode }" /></td>



                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>

                </div>


            </div>

        </fieldset>







        <h1>扩展列信息</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">

                    <table width="100%">

                        <thead>

                        <th width="80">序号</th>
                        <th width="150">源列名</th>
                        <th width="150">外键扩展</th>
                        <th width="150">字典扩展</th>
                        <th width="150">Java类全称</th>
                        <th width="150">Java名称</th>
                        <th width="150">顺序</th>
                        <th width="150">扩展列标题</th>

                        </thead>

                        <tbody>
                        <c:forEach var="exColumn"   items="${exColumns}"   varStatus="status1">
                            <tr>

                                <td>${status1.index+1 }</td>
                                <td>
                                        ${exColumn.originalColumnName }
                                        <input type="hidden" id="exColumns[${status1.index }].id" name="exColumns[${status1.index }].id" value="${exColumn.id }" />
                                        <input type="hidden" id="exColumns[${status1.index }].tableId" name="exColumns[${status1.index }].tableId" value="${exColumn.tableId }" />
                                </td>
                                <td>${exColumn.originalColumnFkName }</td>
                                <td>${exColumn.originalColumnDictName }</td>


                                <td><input type="text"  id="exColumns[${status1.index }].javaFullClass" name="exColumns[${status1.index }].javaFullClass" value="${exColumn.javaFullClass }" /></td>
                                <td><input type="text"  id="exColumns[${status1.index }].javaName" name="exColumns[${status1.index }].javaName" value="${exColumn.javaName }" /></td>
                                <td><input type="number"  id="exColumns[${status1.index }].columnSort" name="exColumns[${status1.index }].columnSort" value="${exColumn.columnSort }" /></td>
                                <td><input type="text"  id="exColumns[${status1.index }].columnTitle" name="exColumns[${status1.index }].columnTitle" value="${exColumn.columnTitle }" /></td>


                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </fieldset>








        <h1>界面信息</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">

                    <table width="100%">

                        <thead>

                        <th width="80">序号</th>
                        <th width="150">列说明</th>
                        <th width="150">是否真实列</th>
                        <th width="150">是否在界面里</th>
                        <th width="150">是否可编辑</th>
                        <th width="150">是否隐藏</th>
                        <th width="150">界面元素</th>
                        <th width="150">最大长度</th>
                        <th width="150">最小长度</th>
                        <th width="150">最大值</th>
                        <th width="150">最小值</th>
                        <th width="150">是否必填</th>
                        <th width="150">是否在列表中显示</th>

                        </thead>

                        <tbody>
                        <c:forEach var="columnPage"   items="${columnPages}"   varStatus="status1">
                            <tr>

                                <td>${status1.index+1 }</td>
                                <td>
                                        ${columnPage.columnComment }
                                        <input type="hidden" id="columnPages[${status1.index }].id" name="columnPages[${status1.index }].id" value="${columnPage.id }" />
                                        <input type="hidden" id="columnPages[${status1.index }].tableId" name="columnPages[${status1.index }].tableId" value="${columnPage.tableId }" />

                                </td>
                                <td>${columnPage.realColumnName }</td>

                                <td>
                                    <select name="columnPages[${status1.index }].existPage" >
                                        <option value="1" <c:if test="${columnPage.existPage ==  '1' }">selected="selected"</c:if>>是</option>
                                        <option value="0" <c:if test="${columnPage.existPage ==  '0' }">selected="selected"</c:if>>否</option>
                                    </select>
                                </td>

                                <td>
                                    <select name="columnPages[${status1.index }].editable" >
                                        <option value="1" <c:if test="${columnPage.editable ==  '1' }">selected="selected"</c:if>>是</option>
                                        <option value="0" <c:if test="${columnPage.editable ==  '0' }">selected="selected"</c:if>>否</option>
                                    </select>
                                </td>

                                <td>
                                    <select name="columnPages[${status1.index }].hiddenable" >
                                        <option value="1" <c:if test="${columnPage.hiddenable ==  '1' }">selected="selected"</c:if>>是</option>
                                        <option value="0" <c:if test="${columnPage.hiddenable ==  '0' }">selected="selected"</c:if>>否</option>
                                    </select>
                                </td>


                                <td>
                                    <select name="columnPages[${status1.index }].element" >
                                        <option value="text" <c:if test="${columnPage.element ==  'text' }">selected="selected"</c:if>>文本</option>
                                        <option value="digits" <c:if test="${columnPage.element ==  'digits' }">selected="selected"</c:if>>整数</option>
                                        <option value="number" <c:if test="${columnPage.element ==  'number' }">selected="selected"</c:if>>数字</option>
                                        <option value="date" <c:if test="${columnPage.element ==  'date' }">selected="selected"</c:if>>日期</option>
                                        <option value="timestamp" <c:if test="${columnPage.element ==  'timestamp' }">selected="selected"</c:if>>时间</option>
                                        <option value="email" <c:if test="${columnPage.element ==  'email' }">selected="selected"</c:if>>邮件</option>
                                        <option value="url" <c:if test="${columnPage.element ==  'url' }">selected="selected"</c:if>>网址</option>
                                        <option value="creditcard" <c:if test="${columnPage.element ==  'creditcard' }">selected="selected"</c:if>>信用卡</option>
                                        <option value="radio" <c:if test="${columnPage.element ==  'radio' }">selected="selected"</c:if>>单选</option>
                                        <option value="checkbox" <c:if test="${columnPage.element ==  'checkbox' }">selected="selected"</c:if>>多选</option>
                                        <option value="textarea" <c:if test="${columnPage.element ==  'textarea' }">selected="selected"</c:if>>文本域</option>
                                        <option value="select" <c:if test="${columnPage.element ==  'select' }">selected="selected"</c:if>>下拉选择</option>
                                        <option value="openwin" <c:if test="${columnPage.element ==  'openwin' }">selected="selected"</c:if>>弹框选择</option>
                                        <option value="singlefile" <c:if test="${columnPage.element ==  'singlefile' }">selected="selected"</c:if>>单文件</option>
                                        <option value="multifile" <c:if test="${columnPage.element ==  'multifile' }">selected="selected"</c:if>>多文件</option>
                                        <option value="singleimage" <c:if test="${columnPage.element ==  'singleimage' }">selected="selected"</c:if>>单图片</option>
                                        <option value="multiimage" <c:if test="${columnPage.element ==  'multiimage' }">selected="selected"</c:if>>多图片</option>
                                    </select>
                                </td>


                                <td><input type="number"  id="columnPages[${status1.index }].maxlength" name="columnPages[${status1.index }].maxlength" value="${columnPage.maxlength }" /></td>
                                <td><input type="number"  id="columnPages[${status1.index }].minlength" name="columnPages[${status1.index }].minlength" value="${columnPage.minlength }" /></td>
                                <td><input type="number"  id="columnPages[${status1.index }].max" name="columnPages[${status1.index }].max" value="${columnPage.max }" /></td>
                                <td><input type="number"  id="columnPages[${status1.index }].min" name="columnPages[${status1.index }].min" value="${columnPage.min }" /></td>
                                <td>
                                    <select name="columnPages[${status1.index }].required" >
                                        <option value="1" <c:if test="${columnPage.required ==  '1' }">selected="selected"</c:if>>是</option>
                                        <option value="0" <c:if test="${columnPage.required ==  '0' }">selected="selected"</c:if>>否</option>
                                    </select>
                                </td>
                                <td>
                                    <select name="columnPages[${status1.index }].listShowable" >
                                        <option value="1" <c:if test="${columnPage.listShowable ==  '1' }">selected="selected"</c:if>>是</option>
                                        <option value="0" <c:if test="${columnPage.listShowable ==  '0' }">selected="selected"</c:if>>否</option>
                                    </select>
                                </td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </fieldset>



        <h1>校验信息</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">

                    <table width="100%">

                        <thead>

                        <th width="80">序号</th>
                        <th width="150">列说明</th>
                        <th width="150">校验表达式</th>
                        <th width="150">错误提示信息</th>

                        </thead>

                        <tbody>
                        <c:forEach var="columnValidate"   items="${columnValidates}"   varStatus="status1">
                            <tr>
                                <td>${status1.index+1 }</td>
                                <td>
                                        ${columnValidate.columnComment }
                                        <input type="hidden"  id="columnValidates[${status1.index }].id" name="columnValidates[${status1.index }].id" value="${columnValidate.id}" />
                                        <input type="hidden"  id="columnValidates[${status1.index }].columnId" name="columnValidates[${status1.index }].columnId" value="${columnValidate.columnId}" />
                                        <input type="hidden"  id="columnValidates[${status1.index }].tableId" name="columnValidates[${status1.index }].tableId" value="${columnValidate.tableId}" />
                                </td>
                                <td><input type="text"  id="columnValidates[${status1.index }].rex" name="columnValidates[${status1.index }].rex" value="${columnValidate.rex }" /></td>
                                <td><input type="text"  id="columnValidates[${status1.index }].msg" name="columnValidates[${status1.index }].msg" value="${columnValidate.msg }" /></td>
                                </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </fieldset>


        <h1>事件信息</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">

                    <table width="100%">

                        <thead>

                        <th width="80">序号</th>
                        <th width="150">列说明</th>
                        <th width="150">事件名</th>
                        <th width="150">函数名</th>
                        <th width="150">参数</th>
                        <th width="150">函数体内容</th>

                        </thead>

                        <tbody>
                        <c:forEach var="columnEvent"   items="${columnEvents}"   varStatus="status1">
                            <tr>
                                <td>${status1.index+1 }</td>
                                <td>
                                    ${columnEvent.columnComment }
                                    <input type="hidden"  id="columnEvents[${status1.index }].id" name="columnEvents[${status1.index }].id" value="${columnEvent.id}" />
                                        <input type="hidden"  id="columnEvents[${status1.index }].columnId" name="columnEvents[${status1.index }].columnId" value="${columnEvent.columnId}" />
                                        <input type="hidden"  id="columnEvents[${status1.index }].tableId" name="columnEvents[${status1.index }].tableId" value="${columnEvent.tableId}" />
                                </td>
                                <td><input type="text"  id="columnEvents[${status1.index }].eventName" name="columnEvents[${status1.index }].eventName" value="${columnEvent.eventName }" /></td>
                                <td><input type="text"  id="columnEvents[${status1.index }].funcName" name="columnEvents[${status1.index }].funcName" value="${columnEvent.funcName }" /></td>
                                <td><input type="text"  id="columnEvents[${status1.index }].funcParam" name="columnEvents[${status1.index }].funcParam" value="${columnEvent.funcParam }" /></td>
                                <td><textarea id="columnEvents[${status1.index }].funcBody" name="columnEvents[${status1.index }].funcBody">${columnEvent.funcBody}</textarea></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </fieldset>


        <h1>约束信息</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">

                    <table width="100%">

                        <thead>

                        <th width="80">序号</th>
                        <th width="150">约束名</th>
                        <th width="150">列名称</th>

                        </thead>

                        <tbody>
                        <c:forEach var="indexConfig"   items="${indexConfigs}"   varStatus="status1">
                            <tr>
                                <td>${status1.index+1 }</td>
                                <td>${indexConfig.indexName }</td>
                                <td>${indexConfig.indexCloumns }</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </fieldset>



        <h1>查询条件</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">

                    <table width="100%">

                        <thead>

                        <th width="80">序号</th>
                        <th width="150">列说明</th>
                        <th width="150">标题</th>
                        <th width="150">占位符</th>
                        <th width="150">查询关系</th>
                        <th width="150">查询顺序</th>

                        </thead>

                        <tbody>
                        <c:forEach var="queryConfig"   items="${queryConfigs}"   varStatus="status1">
                            <tr>
                                <td>${status1.index+1 }</td>
                                <td>
                                        ${queryConfig.columnComment }
                                        <input type="hidden"  id="queryConfigs[${status1.index }].id" name="queryConfigs[${status1.index }].id" value="${queryConfig.id}" />
                                        <input type="hidden"  id="queryConfigs[${status1.index }].columnId" name="queryConfigs[${status1.index }].columnId" value="${queryConfig.columnId}" />
                                        <input type="hidden"  id="queryConfigs[${status1.index }].tableId" name="queryConfigs[${status1.index }].tableId" value="${queryConfig.tableId}" />
                                </td>
                                <td><input type="text"  id="queryConfigs[${status1.index }].queryTitle" name="queryConfigs[${status1.index }].queryTitle" value="${queryConfig.queryTitle }" /></td>
                                <td><input type="text"  id="queryConfigs[${status1.index }].queryPlaceholder" name="queryConfigs[${status1.index }].queryPlaceholder" value="${queryConfig.queryPlaceholder }" /></td>


                                <select name="queryConfigs[${status1.index }].queryRelation" >
                                    <option value="eq" <c:if test="${queryConfig.queryRelation ==  'eq' }">selected="selected"</c:if>>等于</option>
                                    <option value="ne" <c:if test="${queryConfig.queryRelation ==  'ne' }">selected="selected"</c:if>>不等于</option>
                                    <option value="gt" <c:if test="${queryConfig.queryRelation ==  'gt' }">selected="selected"</c:if>>大于</option>
                                    <option value="ge" <c:if test="${queryConfig.queryRelation ==  'ge' }">selected="selected"</c:if>>大于等于</option>
                                    <option value="lt" <c:if test="${queryConfig.queryRelation ==  'lt' }">selected="selected"</c:if>>小于</option>
                                    <option value="le" <c:if test="${queryConfig.queryRelation ==  'le' }">selected="selected"</c:if>>小于等于</option>
                                    <option value="like" <c:if test="${queryConfig.queryRelation ==  'like' }">selected="selected"</c:if>>模糊匹配</option>
                                    <option value="notlike" <c:if test="${queryConfig.queryRelation ==  'notlike' }">selected="selected"</c:if>>模糊不匹配</option>
                                </select>

                                <td><input type="number"  id="queryConfigs[${status1.index }].querySort" name="queryConfigs[${status1.index }].querySort" value="${queryConfig.querySort }" /></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </fieldset>





        <h1>功能操作</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">
                    <c:forEach var="operation"   items="${operations}"   varStatus="status1">
                        <input id="op${operation.id}" name="operations" type="checkbox" value="${operation.id}" <c:if test="${operation.checked}">checked</c:if>  />
                        <span for="op${operation.id}">${operation.operationName}</span>
                    </c:forEach>

                </div>
            </div>
        </fieldset>


    </form>

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
    var form = $("#form");



    form.steps(
        {
            headerTag : "h1",
            bodyTag : "fieldset",
            transitionEffect : "slideLeft",
            onCanceled : function(event) {
                top.layer.closeAll();
            },
            onStepChanging : function(event, currentIndex, newIndex) {
                // Allways allow previous action even if the current form is not valid!
                if (currentIndex > newIndex) {
                    return true;
                }
                // Forbid next action on "Warning" step if the user is to young
                if (newIndex === 3 && Number($("#age-2").val()) < 18) {
                    return false;
                }
                // Needed in some cases if the user went back (clean up)
                if (currentIndex < newIndex) {
                    // To remove error styles
                    form.find(".body:eq(" + newIndex + ") label.error")
                        .remove();
                    form.find(".body:eq(" + newIndex + ") .error")
                        .removeClass("error");
                }
                form.validate().settings.ignore = ":disabled,:hidden";
                return form.valid();
            },
            onStepChanged : function(event, currentIndex, priorIndex) {
                // Used to skip the "Warning" step if the user is old enough.
                if (currentIndex === 2
                    && Number($("#age-2").val()) >= 18) {
                    form.steps("next");
                }
                // Used to skip the "Warning" step if the user is old enough and wants to the previous step.
                if (currentIndex === 2 && priorIndex === 3) {
                    form.steps("previous");
                }
            },
            onFinishing : function(event, currentIndex) {
                form.validate().settings.ignore = ":disabled";
                return form.valid();
            },
            onFinished : function(event, currentIndex) {


                var actionurl=$('form').attr('action');

                var formData = $('form').serializeArray();

                var ajax =  ajaxSyncData(actionurl,formData);

                if(ajax.success){
                    topShwoMessage("info",ajax.msg);

                    window.setTimeout(function(){top.layer.closeAll();},2000);
                    top.iframe40.window.refreshTable();

                }else {
                    topShwoMessage("error",ajax.msg);
                }

            }
        }).validate({
        errorPlacement : function errorPlacement(error, element) {
            element.before(error);
        },
        rules : {
            confirm : {
                equalTo : "#password"
            }
        }
    });


    //增加此处  解决有些元素隐藏的问题
    $('.wizard > .content > .body').css({'position':'relative'})
    $('table').bootstrapTable({height:300});

</script>

</body>
</html>