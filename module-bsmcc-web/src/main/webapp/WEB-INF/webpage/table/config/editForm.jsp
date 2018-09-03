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
                            <option value="" ></option>
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
                        <select id="isBuildUi" name="isBuildUi"  class="form-control required">
                            <option value="1"  <c:if test="${entity.isBuildUi ==  '1' }">selected="selected"</c:if> > 是 </option>
                            <option value="0"   <c:if test="${entity.isBuildUi ==  '0' }">selected="selected"</c:if>  > 否 </option>
                        </select>
                    </div>




                    <div class="form-group">
                        <label>是否生成菜单权限SQL：</label>
                        <select id="isBuildMenu" name="isBuildMenu"  class="form-control required">
                            <option value="1"  <c:if test="${entity.isBuildMenu ==  '1' }">selected="selected"</c:if> > 是 </option>
                            <option value="0"  <c:if test="${entity.isBuildMenu ==  '0' }">selected="selected"</c:if>  > 否 </option>
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
                        <select id="tableType" name="tableType"  class="form-control" onchange="changeTableType(this)">
                            <option value="1"  <c:if test="${entity.tableType ==  '1' }">selected="selected"</c:if> >单表</option>
                            <option value="2"  <c:if test="${entity.tableType ==  '2' }">selected="selected"</c:if> >主表</option>
                            <option value="3"  <c:if test="${entity.tableType ==  '3' }">selected="selected"</c:if> >副表</option>
                            <option value="4"  <c:if test="${entity.tableType ==  '4' }">selected="selected"</c:if> >子表</option>
                        </select>
                    </div>




                    <div class="form-group" style="display: block">
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
                            <option value="">--选择视图的主表--</option>
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
                        <select id="isTree" name="isTree"  class="form-control required" onchange="changeIsTree(this)">
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
                        <th width="200">列名称</th>
                        <th width="200">列说明</th>
                        <th width="200">列类型</th>
                        <th width="200">列长度</th>
                        <th width="200">小数点位数</th>
                        <th width="200">允许空值</th>
                        <th width="150">顺序</th>
                        <th width="150">是否为主键</th>
                        <th width="150">是否为外键</th>
                        <th width="150">是否为字典</th>
                        <th width="150">字典类型</th>
                        <th width="200">外键对应表SCHEMA</th>
                        <th width="200">外键对应表名</th>
                        <th width="200">外键对应列名</th>
                        <th width="200">Java类全称</th>
                        <th width="200">Java名称</th>
                        <th width="200">组编码</th>

                        </thead>

                        <tbody>
                        <c:forEach var="column"   items="${columnConfigs}"   varStatus="status1">
                            <tr>
                                <td>${status1.index+1 }</td>
                                <td>${column.columnName }</td>
                                <td><input type="text" size="15" required id="columns[${status1.index }].columnComment" name="columns[${status1.index }].columnComment" value="${column.columnComment }" /></td>
                                <td>${column.columnType }</td>

                                <td>${column.columnLength }</td>
                                <td>${column.columnScale }</td>
                                <td>${column.columnIsnullName }</td>

                                <td>
                                    <input type="hidden" id="columns[${status1.index }].id" name="columns[${status1.index }].id" value="${column.id }" />
                                    <input type="hidden" id="columns[${status1.index }].tableId" name="columns[${status1.index }].tableId" value="${column.tableId }" />
                                    <input type="number" style="width: 60px" required id="columns[${status1.index }].columnSort" name="columns[${status1.index }].columnSort" value="${column.columnSort }" size="10" />
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


                                <td><input type="text" size="10" id="columns[${status1.index }].dictType" name="columns[${status1.index }].dictType" value="${column.dictType }"
                                           <c:if test="${column.columnIsdict == '1'}">class="required"</c:if> />
                                </td>
                                <td>
                                    <input type="text" size="8" id="columns[${status1.index }].fkSchema" name="columns[${status1.index }].fkSchema" value="${column.fkSchema }"
                                           <c:if test="${column.columnIsfk == '1'}">class="required"</c:if>  />
                                </td>
                                <td>
                                    <input type="text" size="15" id="columns[${status1.index }].fkName" name="columns[${status1.index }].fkName" value="${column.fkName }"
                                           <c:if test="${column.columnIsfk == '1'}">class="required"</c:if>  />
                                </td>
                                <td>
                                    <input type="text" size="6" id="columns[${status1.index }].fkColumn" name="columns[${status1.index }].fkColumn" value="${column.fkColumn }"
                                           <c:if test="${column.groupCode != null && column.groupCode != '' }">class="required"</c:if>  />
                                </td>


                                <td><input type="text" size="10" required id="columns[${status1.index }].javaFullClass" name="columns[${status1.index }].javaFullClass" value="${column.javaFullClass }" /></td>
                                <td><input type="text" size="10" required id="columns[${status1.index }].javaName" name="columns[${status1.index }].javaName" value="${column.javaName }" /></td>
                                <td><input type="text" size="10" id="columns[${status1.index }].groupCode" name="columns[${status1.index }].groupCode" value="${column.groupCode }" /></td>



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


                    <input type="button" value="新增扩展列" onclick="insertExColumn()" style="height: 30px;width: 80px; color: white; color: white; background-color: #1AB394">


                    <table width="100%" id="exColumnTable">

                        <thead>

                        <th width="60">序号</th>
                        <th width="150">源列名</th>
                        <th width="150">外键扩展</th>
                        <th width="150">字典扩展</th>
                        <th width="150">Java类全称</th>
                        <th width="150">Java名称</th>
                        <th width="100">顺序</th>
                        <th width="200">扩展列标题</th>
                        <th width="100">外键对应的列名</th>
                        <th width="100">操作</th>

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


                                <td><input type="text" size="15" class="required  id="exColumns[${status1.index }].javaFullClass" name="exColumns[${status1.index }].javaFullClass" value="${exColumn.javaFullClass }" /></td>
                                <td><input type="text" size="15" class="required  id="exColumns[${status1.index }].javaName" name="exColumns[${status1.index }].javaName" value="${exColumn.javaName }" /></td>
                                <td><input type="number" size="6" class="required id="exColumns[${status1.index }].columnSort" name="exColumns[${status1.index }].columnSort" value="${exColumn.columnSort }" /></td>
                                <td><input type="text" size="10" class="required  id="exColumns[${status1.index }].columnTitle" name="exColumns[${status1.index }].columnTitle" value="${exColumn.columnTitle }" /></td>
                                <td>
                                    <input type="text" size="10" id="exColumns[${status1.index }].fkColumnName" name="exColumns[${status1.index }].fkColumnName" value="${exColumn.fkColumnName }"
                                            <c:if test="${exColumn.originalColumnFk == '1'}">class="required"</c:if>   />
                                </td>

                                <td>
                                    <input type="button" value="删除" onclick="deleteExColumn(this)" style="height: 30px;width: 50px;color: white; background-color: #2c35cc">
                                </td>

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
                        <th width="250">列名</th>
                        <th width="250">列说明</th>
                        <th width="150">是否真实列</th>
                        <th width="150">是否在界面里</th>
                        <th width="150">是否可编辑</th>
                        <th width="150">是否隐藏</th>
                        <th width="150">界面元素</th>
                        <th width="150">是否必填</th>
                        <th width="150">是否在列表中显示</th>
                        <th width="150">最大长度</th>
                        <th width="150">最小长度</th>
                        <th width="150">最大值</th>
                        <th width="150">最小值</th>

                        </thead>

                        <tbody>
                        <c:forEach var="columnPage"   items="${columnPages}"   varStatus="status1">
                            <tr>

                                <td>${status1.index+1 }</td>
                                <td>
                                    <c:if test="${empty columnPage.exColumn}">${columnPage.columnConfig.columnName}</c:if><c:if test="${empty columnPage.columnConfig}">${columnPage.exColumn.javaName}</c:if>
                                </td>
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

                                <td><input type="number" style="width: 60px"  id="columnPages[${status1.index }].maxlength" name="columnPages[${status1.index }].maxlength" value="${columnPage.maxlength }" /></td>
                                <td><input type="number" style="width: 60px"  id="columnPages[${status1.index }].minlength" name="columnPages[${status1.index }].minlength" value="${columnPage.minlength }" /></td>
                                <td><input type="number" style="width: 60px"  id="columnPages[${status1.index }].max" name="columnPages[${status1.index }].max" value="${columnPage.max }" /></td>
                                <td><input type="number" style="width: 60px"  id="columnPages[${status1.index }].min" name="columnPages[${status1.index }].min" value="${columnPage.min }" /></td>


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
                    <input type="button" value="插入查询条件" onclick="insertQueryConfigTables()" style="height: 30px;width: 100px;color: white; background-color: #1AB394">

                    <table width="100%" id="queryConfigTable">

                        <thead>

                        <th width="60">序号</th>
                        <th width="200">列说明</th>
                        <th width="200">标题</th>
                        <th width="200">占位符</th>
                        <th width="100">查询关系</th>
                        <th width="100">查询框名称</th>
                        <th width="100">查询顺序</th>
                        <th width="100">操作</th>

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

                                <td>
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
                                </td>

                                <td><input type="text" <c:if test="${not empty queryConfig.columnId}">readonly</c:if> id="queryConfigs[${status1.index }].queryFieldName" name="queryConfigs[${status1.index }].queryFieldName" value="${queryConfig.queryFieldName }" /></td>


                                <td><input type="number" style="width:80px" id="queryConfigs[${status1.index }].querySort" name="queryConfigs[${status1.index }].querySort" value="${queryConfig.querySort }" /></td>
                                <td>
                                    <input type="button" value="删除" onclick="deletequeryConfigs(this)" style="height: 30px;width: 50px;color: white; background-color: #2c35cc">
                                </td>
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
                        <br>
                        <input id="op${operation.id}" name="operations" type="checkbox" value="${operation.id}" <c:if test="${operation.checked}">checked</c:if>  />
                        <span for="op${operation.id}">${operation.operationName}</span>
                    </c:forEach>

                </div>
            </div>
        </fieldset>



        <h1>校验信息</h1>
        <fieldset>
            <div class="row">
                <div class="col-xs-12">


                    <input type="button" value="插入校验信息" onclick="insertColumnValidates()" style="height: 30px;width: 100px;color: white; background-color: #1AB394">

                    <table width="100%" id="columnValidateTable">

                        <thead>

                        <th width="60">序号</th>
                        <th width="250">列说明</th>
                        <th width="250">校验表达式</th>
                        <th width="250">错误提示信息</th>
                        <th width="100">操作</th>

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

                                <td>
                                    <input type="button" value="删除" onclick="deleteColumnValidates(this)" style="height: 30px;width: 50px;color: white; background-color: #2c35cc">
                                </td>
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

                    <input type="button" value="插入事件信息" onclick="insertColumnEvents()" style="height: 30px;width: 100px;color: white; background-color: #1AB394">

                    <table width="100%" id="columnEventTable">

                        <thead>

                        <th width="60">序号</th>
                        <th width="150">列说明</th>
                        <th width="100">事件名</th>
                        <th width="200">函数名</th>
                        <th width="500">函数体内容</th>
                        <th width="100">操作</th>

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
                                <td><textarea id="columnEvents[${status1.index }].funcBody" name="columnEvents[${status1.index }].funcBody">${columnEvent.funcBody}</textarea></td>
                                <td>
                                    <input type="button" value="删除" onclick="deleteColumnEvents(this)" style="height: 30px;width: 50px;color: white; background-color: #2c35cc">
                                </td>
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
    $('.wizard > .content > .body').css({'position':'relative'});
    $('table').bootstrapTable({height:getHeight()-200});



    var tableId = '${entity.id }';



    //处理扩展列
    var exColTableSize = $('#exColumnTable tr').size()-1;
    function insertExColumn() {
        var trObjs = $('#exColumnTable tr');
        var mySize = exColTableSize ;
        var selectExColumn = '';
        selectExColumn = '<select name="exColumns['+mySize+'].originalColumnId">' ;
            <c:forEach items="${columnConfigs}" var="column" >
                <c:if test="${column.columnIsfk == '1'}">
        selectExColumn += '<option value="${column.id}" >${column.columnComment}</option>' ;
                </c:if>
            </c:forEach>
        selectExColumn +='</select>';
        var trTemplete = '<tr>\n' +
            '\n' +
            '                                <td width="60">'+mySize+'</td>\n' +
            '                                <td width="150">'+selectExColumn +
            '                                        <input type="hidden"  name="exColumns['+mySize+'].id" />\n' +
            '                                        <input type="hidden"  name="exColumns['+mySize+'].tableId"  value="'+tableId+'"/>\n' +
            '                                </td>' +
            '                                <td width="150"></td>\n' +
            '                                <td width="150"></td>\n' +
            '\n' +
            '\n' +
            '                                <td width="150"><input type="text" size="15"  name="exColumns['+mySize+'].javaFullClass" value="" class="required"/></td>\n' +
            '                                <td width="150"><input type="text"  size="15" name="exColumns['+mySize+'].javaName" value="" class="required"/></td>\n' +
            '                                <td width="100"><input type="number" size="6"  name="exColumns['+mySize+'].columnSort" value="" class="required"/></td>\n' +
            '                                <td width="200"><input type="text" size="10"  name="exColumns['+mySize+'].columnTitle" value="" class="required"/></td>\n' +
            '                                <td width="100">\n' +
            '                                    <input type="text" size="10"  name="exColumns['+mySize+'].fkColumnName" value="" class="required" />\n' +
            '                                </td>\n' +
            '                                <td width="100">\n' +
            '                                    <input type="button" value="删除" onclick="deleteExColumn(this)" style="height: 30px;width: 50px;color: white; background-color: #2c35cc">\n' +
            '                                </td>\n' +
            '\n' +
            '\n' +
            '\n' +
            '                            </tr>';
        $('#exColumnTable tbody').append(trTemplete);
        exColTableSize = exColTableSize+1;
        resizeIndex('exColumnTable');
        //changeExColumn();
    }
    function deleteExColumn(that) {
        $(that).parent().parent().remove();
        resizeIndex('exColumnTable');
    }


    //处理列验证信息

    var columnValidateTableSize = $('#columnValidateTable tr').size()-1;
    function insertColumnValidates() {
        var trObjs = $('#columnValidateTable tr');

        if(trObjs.size() == 2 ){
            var $tr = $(trObjs[1]);
            if($tr.hasClass("no-records-found")) {
                $tr.remove();
                columnValidateTableSize--;
            }
        }

        var mySize = columnValidateTableSize ;
        var selectHtml = '';
        selectHtml = '<select name="columnValidates['+mySize+'].columnId">' ;
        <c:forEach items="${columnPages}" var="column" >
        <c:if test="${column.existPage == '1' && column.editable == '1'}">
        selectHtml += '<option value="${column.id}" >${column.columnComment}</option>' ;
        </c:if>
        </c:forEach>
        selectHtml +='</select>';
        var trTemplete = '<tr>\n' +
            '\n' +
            '                                <td width="60">'+mySize+'</td>\n' +
            '                                <td width="250">'+selectHtml +
            '                                        <input type="hidden"  name="columnValidates['+mySize+'].id" />\n' +
            '                                        <input type="hidden"  name="columnValidates['+mySize+'].tableId"  value="'+tableId+'"/>\n' +
            '                                </td>' +
            '\n' +
            '\n' +
            '                                <td width="250"><input type="text" size="20"  name="columnValidates['+mySize+'].rex" value="" class="required"/></td>\n' +
            '                                <td width="250"><input type="text"  size="20" name="columnValidates['+mySize+'].msg" value="" class="required"/></td>\n' +
            '                                <td width="100">\n' +
            '                                    <input type="button" value="删除" onclick="deleteColumnValidates(this)" style="height: 30px;width: 50px;color: white; background-color: #2c35cc">\n' +
            '                                </td>\n' +
            '\n' +
            '\n' +
            '\n' +
            '                            </tr>';
        console.log(trTemplete)
        $('#columnValidateTable tbody').append(trTemplete);
        columnValidateTableSize = columnValidateTableSize+1;
        resizeIndex('columnValidateTable');
    }
    function deleteColumnValidates(that) {
        $(that).parent().parent().remove();
        resizeIndex('columnValidateTable');
    }



    //处理列事件信息
    var columnEventTableSize = $('#columnEventTable tr').size()-1;
    function insertColumnEvents() {
        var trObjs = $('#columnEventTable tr');
        if(trObjs.size() == 2 ){
            var $tr = $(trObjs[1]);
            if($tr.hasClass("no-records-found")) {
                $tr.remove();
                columnEventTableSize--;
            }
        }

        var mySize = columnEventTableSize ;
        var selectHtml = '';
        selectHtml = '<select name="columnEvents['+mySize+'].columnId">' ;
        <c:forEach items="${columnPages}" var="column" >
        <c:if test="${column.existPage == '1' && column.editable == '1'}">
        selectHtml += '<option value="${column.id}" >${column.columnComment}</option>' ;
        </c:if>
        </c:forEach>
        selectHtml +='</select>';
        var trTemplete = '<tr>\n' +
            '\n' +
            '                                <td width="60">'+mySize+'</td>\n' +
            '                                <td width="150">'+selectHtml +
            '                                        <input type="hidden"  name="columnEvents['+mySize+'].id" />\n' +
            '                                        <input type="hidden"  name="columnEvents['+mySize+'].tableId"  value="'+tableId+'"/>\n' +
            '                                </td>' +
            '                                <td width="100"><input size="10"  type="text"  name="columnEvents['+mySize+'].eventName" value="" class="required"/></td>\n' +
            '                                <td width="200"><input size="20"  type="text"   name="columnEvents['+mySize+'].funcName" value="" class="required"/></td>\n' +
            '                                <td width="500"><textarea  name="columnEvents['+mySize+'].funcBody" value="" class="required"/></td>\n' +
            '                                <td width="100">\n' +
            '                                    <input type="button" value="删除" onclick="deletecolumnEvents(this)" style="height: 30px;width: 50px;color: white; background-color: #2c35cc">\n' +
            '                                </td>\n' +
            '\n' +
            '\n' +
            '\n' +
            '                            </tr>';
        $('#columnEventTable tbody').append(trTemplete);
        columnEventTableSize = columnEventTableSize+1;
        resizeIndex('columnEventTable');
    }
    function deletecolumnEvents(that) {
        $(that).parent().parent().remove();
        resizeIndex('columnEventTable');
    }




    //处理查询条件
    var queryConfigTableSize = $('#queryConfigTable tr').size()-1;
    function insertQueryConfigTables() {
        var trObjs = $('#queryConfigTable tr');
        if(trObjs.size() == 2 ){
            var $tr = $(trObjs[1]);
            if($tr.hasClass("no-records-found")) {
                $tr.remove();
                queryConfigTableSize--;
            }
        }

        var mySize = queryConfigTableSize ;
        var selectHtml = '';
        //所有column可以作为查询条件 , 扩展列如果是 openwin的也可以是查询条件
        selectHtml = '<select name="queryConfigs['+mySize+'].columnId">' ;
        selectHtml += '<option value="" ></option>' ;
        <c:forEach items="${columnPages}" var="column" >

        console.log('${column.javaName} : '+ '${column.realColumn} ${column.element}');
        <c:if test="${column.realColumn == '1' || column.element == 'openwin'}">
        selectHtml += '<option value="${column.id}" >${column.columnComment}</option>' ;
        </c:if>
        </c:forEach>
        selectHtml +='</select>';
        var trTemplete = '<tr>\n' +
            '\n' +
            '                                <td width="60">'+mySize+'</td>\n' +
            '                                <td width="200">'+selectHtml +
            '                                        <input type="hidden"  name="queryConfigs['+mySize+'].id" />\n' +
            '                                        <input type="hidden"  name="queryConfigs['+mySize+'].tableId"  value="'+tableId+'"/>\n' +
            '                                </td>' +
            '                                <td width="200"><input size="20"  type="text"   name="queryConfigs['+mySize+'].queryTitle" value="" /></td>\n' +
            '                                <td width="200"><input size="20"  type="text"  name="queryConfigs['+mySize+'].queryPlaceholder" value="" /></td>\n' +
            '                                <td width="100"><select name="queryConfigs['+mySize+'].queryRelation" ><option value="eq">等于</option><option value="ne">不等于</option><option value="gt">大于</option><option value="ge">大于等于</option><option value="lt">小于</option><option value="le">小于等于</option><option value="like">模糊匹配</option><option value="notlike">模糊不匹配</option></select></td>\n' +
            '                                <td width="100"><input size="20"  type="text"  name="queryConfigs['+mySize+'].queryFieldName" value="" /></td>\n' +
            '                                <td width="100"><input style="width:80px" type="number" name="queryConfigs['+mySize+'].querySort" value="" class="required"/></td>\n' +
            '                                <td width="100">\n' +
            '                                    <input type="button" value="删除" onclick="deletequeryConfigs(this)" style="height: 30px;width: 50px;color: white; background-color: #2c35cc">\n' +
            '                                </td>\n' +
            '                            </tr>';
        $('#queryConfigTable tbody').append(trTemplete);
        console.log(trTemplete);
        queryConfigTableSize = queryConfigTableSize+1;
        resizeIndex('queryConfigTable');
    }
    function deletequeryConfigs(that) {
        $(that).parent().parent().remove();
        resizeIndex('queryConfigTable');
    }





    /**
     * 序号重新排序
     * @param tableId
     */
    function resizeIndex(tableId) {

        $("#"+tableId).find('tr').each(function (index, item) {
            $(item).children().eq(0).html(index);
        });
    }

    function changeTableType(tableType){
        var $tableType = $(tableType);
        if($tableType.val() == '1' || $tableType.val() == '2'){
            $("#isBuildMenu").val("1");
            $("#tableRelation").val("one-one");
        }else if($tableType.val() == '3'){
            $("#isBuildMenu").val("0");
            $("#tableRelation").val("one-one");
        }else if($tableType.val() == '4'){
            $("#isBuildMenu").val("0");
            $("#tableRelation").val("one-multi");
        }
    }

    function changeIsTree(isTree){
        var $isTree = $(isTree);
        if($isTree.val() == "1"){
            $("#parentFieldName").removeAttr("readonly");
        }else {
            $("#parentFieldName").attr("readonly" , "readonly");
            $("#parentFieldName").val("");
        }
    }


</script>

</body>
</html>