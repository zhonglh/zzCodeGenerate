<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<bms:contentHeader title="${project.projectName!}" />




<div style="padding:0 10px">
    <div class="row">
        <div class="col-xs-12 col-lg-12 col-md-12" style="padding-left: 0;padding-right: 0">
            <div class="block-each block-each-another">
                <div class="block-tit">
                    <svg class="icon" aria-hidden="true">
                        <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-youjiantou"></use>
                    </svg>基本信息
                </div>



                <div id="detailForm" class="detailForm">
                    <table class="info-table">
                        <#list columnPages as columnPage>
                        <tr>
                            <th width="15%">用户名称</th>
                            <td class="fd_userName">${m.userName}</td>

                            <th width="15%">用户登录名</th>
                            <td class="fd_loginName">${m.loginName}</td>
                        </tr>
                        </#list>

                    </table>
                </div>


                <form action="" method="post" class="form-auto-fill hide editForm" viewId="detailForm" formId="editForm">
                    <input type="hidden" id="id" name="id" value="${m.id}">
                    <table class="info-table">
                        <tr>
                            <th width="15%">用户名称<font color="red">*</font></th>
                            <td><input type="text" class="form-control input-sm required"  placeholder="请输入用户名称"
                                       value="${m.userName}" id="userName" name="userName" minlength="2" maxlength='50'/></td>

                            <th width="15%">用户登录名<font color="red">*</font></th>
                            <td><input type="text" class="form-control input-sm required"  placeholder="请输入用户登录名"  autocomplete="off"
                                       value="${m.loginName}" id="loginName" name="loginName" minlength="4" maxlength='20'/></td>
                        </tr>


                        <tr>
                            <th>直属领导</th>
                            <td>
                                <div class="input-group">
                                    <input type="text"  id="leadUserName" name="leadUserName" class="form-control input-sm leadUserName"
                                           placeholder="请选择直属领导" readonly="readonly" value="${m.leadUserName}">
                                    <input type="hidden" id="leadUserId" name="leadUserId" value="${m.leadUserId}">
                                    <div class="input-group-btn">
                                        <button type="button"  class="btn btn-primary btn-sm leadUserName">
                                            <svg class="icon" aria-hidden="true">
                                                <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-sousuo"></use>
                                            </svg>
                                        </button>
                                        <button type="button"  id="clearLeadUserId"  class="btn btn-primary btn-sm">
                                            <svg class="icon" aria-hidden="true">
                                                <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-close"></use>
                                            </svg>
                                        </button>
                                    </div>
                                </div>
                            </td>
                            <th>所在部门</th>
                            <td>
                                <div class="input-group">
                                    <input type="text"  id="depName" name="depName" value="${m.depName}" class="form-control input-sm  sysdepInfo "
                                           placeholder="请选择所在部门" readonly="readonly" >
                                    <input type="hidden" id="depId" name="depId" value="${m.depId}">
                                    <div class="input-group-btn">
                                        <button type="button" class="btn btn-primary btn-sm crm-sysdepInfo">
                                            <svg class="icon" aria-hidden="true">
                                                <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-sousuo"></use>
                                            </svg>
                                        </button>
                                        <button type="button" id="clearSysdepInfo" class="btn btn-primary btn-sm">
                                            <svg class="icon" aria-hidden="true">
                                                <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-close"></use>
                                            </svg>
                                        </button>
                                    </div>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <th width="15%">手机号<font color="red">*</font></th>
                            <td><input type="text" class="form-control input-sm required"  placeholder="请输入手机号"
                                       value="${m.phone}" id="phone" name="phone" minlength="11" maxlength='11'/></td>

                            <th width="15%">邮箱<font color="red">*</font></th>
                            <td><input type="email" class="form-control input-sm required"  placeholder="请输入邮箱"
                                       value="${m.email}"  id="email" name="email" minlength="4" maxlength='50'/></td>
                        </tr>


                        <tr>
                            <th height="15%">退出文件</th>
                            <td colspan="3">
                                <div class="info-detail">
                                    <div class="uploader-list">
                                        <ul id="thelist" class="files-list" style="margin: 0 0 10px 0" ></ul>
                                    </div>
                                    <div>
                                        <div id="uploadFile" title='附件' class="webuploader-container" data-options="viewAreaId:'#thelist', fileSource:125, ">
                                            <svg class="icon" aria-hidden="true">
                                                <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-upload"></use>
                                            </svg>
                                            <span>上传附件</span>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>



                        <tr>
                            <th >备注</th>
                            <td colspan="3">
                                <div class="info-detail">
                                    <textarea class="form-control input-sm" name="remark" placeholder="请输入备注，500字以内" maxlength="500" rows="3">${m.remark}</textarea>
                                </div>
                            </td>
                        </tr>

                    </table>
                </form>
            </div>

            <div style="margin-top:10px;position:absolute;" align="center" id="toolBar">



                <shiro:hasPermission name="system.user:update">
                    <button type="button" class="btn btn-primary btn-sm btn-showEdit" onclick="switchEditDetail()">
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-edit"></use>
                        </svg>
                        <span>编 辑</span>
                    </button>
                </shiro:hasPermission>

                <button type="button" class="btn  btn-warning btn-sm btn-showEdit" onclick="closeWindow()">
                    <svg class="icon" aria-hidden="true">
                        <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-chexiao"></use>
                    </svg>
                    <span>返 回</span>
                </button>


                <shiro:hasPermission name="system.user:update">
                    <button type="button" class="btn btn-primary btn-sm hide" onclick="doUpdate()">
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-save-continue"></use>
                        </svg>
                        <span>保 存</span>
                    </button>
                </shiro:hasPermission>

                <button type="button" class="btn  btn-warning btn-sm hide" onclick="switchEditDetail()">
                    <svg class="icon" aria-hidden="true">
                        <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-close"></use>
                    </svg>
                    <span>取 消</span>
                </button>

            </div>
        </div>
    </div>
</div>





<script>


    var tableid = "tableData-${tableId}";

    //显示模式   明细/编辑
    var showMode = "detail";

</script>





<bms:contentJS />

<script src="${staticUrl}/statics2/business-js/system/user.js"></script>
<script src="${staticUrl}/statics2/js/project/form.js"></script>


<script src="${staticUrl}/statics2/js/project/common-sys-function.js"></script>



<script language="JavaScript">


    $(function() {
        //人员选择
        $(".leadUserName").OpenSystemUserSelectWin({
            title: "直属领导",
            selectType: "d1",
            callId: "leadUserId",
            callName: "leadUserName",
            clearId: "clearLeadUserId"
        });


    });


</script>

<bms:contentFooter />