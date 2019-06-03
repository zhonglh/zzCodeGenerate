<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<bms:contentHeader title="${project.projectName!}" />




<div style="padding:0 10px">
    <div class="row">
        <div class="col-xs-12 col-lg-12 col-md-12" style="padding-left: 0;padding-right: 0">
            <div class="block-each block-each-another">

                <form action="" method="post" id="editForm" viewId="editForm" >

                    <div class="block-tit">
                        &nbsp;<i class="fa fa-th-list"></i>&nbsp;基本信息
                    </div>


                    <table class="info-table hide-area">

                        <colgroup>
                            <col style="width: 15%" />
                            <col style="width: 35%" />
                            <col style="width: 15%" />
                            <col style="width: 35%" />
                        </colgroup>

                        <tbody>
                        <#list showColumnPages as being>
                        <#if being_index%2 ==0>
                            <tr>
                                <th>${being.columnComment}<#if being.required?exists && being.required == '1'><font color="red">*</font></#if></th>
                                <td class="fd<#if being.element == 'singlefile' || being.element == 'multifile' || being.element == 'singleimage' || being.element == 'multiimage'>_uploadFile</#if>_${being.javaName}<#if  being.element == 'select' || being.element == 'checkbox' || being.element == 'radio'>Name</#if>">
                                <#if being.element == 'date' >
                                    <fmt:formatDate value="${r"${"} m.${being.javaName} ${r"}"}" pattern="yyyy-MM-dd" />
                                <#elseif being.element == 'timestamp' >
                                    <fmt:formatDate value="${r"${"} m.${being.javaName} ${r"}"}" pattern="yyyy-MM-dd  HH:mm:ss" />
                                <#elseif being.element == 'select' || being.element == 'checkbox' || being.element == 'radio' >
                                    ${r"${"} m.${being.javaName}Name ${r"}"}
                                <#elseif being.element == 'singlefile' || being.element == 'multifile' || being.element == 'singleimage' || being.element == 'multiimage'  >

                                    <ul style="margin: 0 0 10px 0">
                                        <c:forEach var="item" items="${r"${"}m.${being.javaName}List}">
                                            <li>
                                                <a href="<c:if test="${r"${"}item.fileEngine == '1'}">javascript:viewFile('${r"${"}item.id}');</c:if><c:if test="${r"${"}item.fileEngine != '1'}">${r"${"}item.accessUrl}</c:if>" class="file-text" title="${r"${"}item.showName}" style="float:left;">
                                                <span style="float:left;">${r"${"}item.showName}</span>
                                                <span style="float:right;" class="fileSize" fileSize="${r"${"}item.fileSize}">(${r"${"}item.fileSize})</span>
                                                </a>

                                                <a href="javascript:downloadFile('${r"${"}item.id}');" class="file-operate" style="float:right;"><i class="fa fa-download"></i></a>

                                                <div style="clear: both;"></div>
                                            </li>
                                        </c:forEach>
                                    </ul>

                                <#else >
                                    <c:out value="${r"${"} m.${being.javaName} ${r"}"}" escapeXml="true"/>
                                </#if>
                                </td>
                                <#if being_has_next>
                                <#assign nextPage=showColumnPages[being_index+1]>
                                <th>${nextPage.columnComment}<#if nextPage.required?exists && nextPage.required == '1'><font color="red">*</font></#if></th>
                                <td class="fd<#if nextPage.element == 'singlefile' || nextPage.element == 'multifile' || nextPage.element == 'singleimage' || nextPage.element == 'multiimage'>_uploadFile</#if>_${nextPage.javaName}<#if  nextPage.element == 'select' || nextPage.element == 'checkbox' || nextPage.element == 'radio'>Name</#if>">
                                <#if nextPage.element == 'date' >
                                    <fmt:formatDate value="${r"${"} m.${nextPage.javaName} ${r"}"}" pattern="yyyy-MM-dd" />
                                <#elseif nextPage.element == 'timestamp' >
                                    <fmt:formatDate value="${r"${"} m.${nextPage.javaName} ${r"}"}" pattern="yyyy-MM-dd  HH:mm:ss" />
                                <#elseif nextPage.element == 'select' || nextPage.element == 'checkbox' || nextPage.element == 'radio' >
                                    ${r"${"} m.${nextPage.javaName}Name ${r"}"}
                                <#elseif nextPage.element == 'singlefile' || nextPage.element == 'multifile' || nextPage.element == 'singleimage' || nextPage.element == 'multiimage'  >

                                    <ul style="margin: 0 0 10px 0">
                                        <c:forEach var="item" items="${r"${"}m.${nextPage.javaName}List}">
                                            <li>
                                                <a href="<c:if test="${r"${"}item.fileEngine == '1'}">javascript:viewFile('${r"${"}item.id}');</c:if><c:if test="${r"${"}item.fileEngine != '1'}">${r"${"}item.accessUrl}</c:if>" class="file-text" title="${r"${"}item.showName}" style="float:left;">
                                                <span style="float:left;">${r"${"}item.showName}</span>
                                                <span style="float:right;" class="fileSize" fileSize="${r"${"}item.fileSize}">(${r"${"}item.fileSize})</span>
                                                </a>

                                                <a href="javascript:downloadFile('${r"${"}item.id}');" class="file-operate" style="float:right;"><i class="fa fa-download"></i></a>

                                                <div style="clear: both;"></div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                <#else >
                                    <c:out value="${r"${"} m.${nextPage.javaName} ${r"}"}" escapeXml="true"/>
                                </#if>
                                </td>
                                </#if>
                            </tr>

                        </#if>
                        </#list>
                        </tbody>
                    </table>

                    <input type="hidden" id="id" name="id" value="${r"${"} m.id ${r"}"}">

                    <table class="info-table show-area">
                        <colgroup>
                            <col style="width: 15%" />
                            <col style="width: 35%" />
                            <col style="width: 15%" />
                            <col style="width: 35%" />
                        </colgroup>

                        <tbody>

                        <#list showColumnPages as being>
                        <#if being_index%2 ==0>
                            <tr>
                                <th>${being.columnComment}<#if being.required?exists && being.required == '1'><font color="red">*</font></#if></th>
                                <td>
                                <#if being?exists && being.columnConfig?exists>
                                    <#if being.element == 'text'  >
                                        <input type="text" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm <#if being.required?exists && being.required == '1'>required</#if>"
                                               placeholder="请输入${being.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${being.javaName} ${r"}"}" id="${being.javaName}" name="${being.javaName}"
                                                <#if being.max?exists>max="${being.max}" </#if> <#if being.min?exists>min="${being.min}" </#if> <#if being.minlength?exists>minlength="${being.minlength}" </#if> <#if being.maxlength?exists>maxlength="${being.maxlength}" </#if> />
                                    <#elseif being.element == 'textarea' >
                                        <div class="info-detail">
                                            <textarea <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm <#if being.required?exists && being.required == '1'>required</#if> "
                                                      name="${being.javaName}" id="${being.javaName}"  placeholder="请输入${being.columnComment}，${being.maxlength}字以内" maxlength="${being.maxlength}" rows="5"><c:out value="${r"${"} m.${being.javaName} ${r"}"}" escapeXml="true"/></textarea>
                                        </div>
                                    <#elseif being.element == 'digits' >
                                        <input type="text" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm number  <#if being.required?exists && being.required == '1'>required</#if>"
                                               placeholder="请输入${being.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${being.javaName} ${r"}"}" id="${being.javaName}" name="${being.javaName}" step="1"
                                                <#if being.max?exists>max="${being.max}" </#if> <#if being.min?exists>min="${being.min}" </#if> <#if being.minlength?exists>minlength="${being.minlength}" </#if> <#if being.maxlength?exists>maxlength="${being.maxlength}" </#if> />
                                    <#elseif being.element == 'number' >
                                        <input type="text" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm number fd-decimal2 <#if being.required?exists && being.required == '1'>required</#if>"
                                               placeholder="请输入${being.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${being.javaName} ${r"}"}" id="${being.javaName}" name="${being.javaName}" step="0.01"
                                                <#if being.max?exists>max="${being.max}" </#if> <#if being.min?exists>min="${being.min}" </#if> <#if being.minlength?exists>minlength="${being.minlength}" </#if> <#if being.maxlength?exists>maxlength="${being.maxlength}" </#if> />
                                    <#elseif being.element == 'date' ||  being.element == 'timestamp' >

                                            <input type="text" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm Wdate <#if being.required?exists && being.required == '1'>required</#if>"
                                                   placeholder="请输入${being.columnComment}" autocomplete="off"
                                                   onclick="WdatePicker({dateFmt: 'yyyy-MM-dd', el: '${being.javaName}'})"
                                                   value='<fmt:formatDate value="${r"${"} m.${being.javaName} ${r"}"}" pattern="yyyy-MM-dd" />' id="${being.javaName}" name="${being.javaName}" readonly   />

                                    <#elseif being.element == 'email' >
                                        <input type="email" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm <#if being.required?exists && being.required == '1'>required</#if>"
                                               placeholder="请输入${being.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${being.javaName} ${r"}"}" id="${being.javaName}" name="${being.javaName}"
                                                <#if being.max?exists>max="${being.max}" </#if> <#if being.min?exists>min="${being.min}" </#if> <#if being.minlength?exists>minlength="${being.minlength}" </#if> <#if being.maxlength?exists>maxlength="${being.maxlength}" </#if> />
                                    <#elseif being.element == 'url' >
                                        <input type="url" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm <#if being.required?exists && being.required == '1'>required</#if>"
                                               placeholder="请输入${being.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${being.javaName} ${r"}"}" id="${being.javaName}" name="${being.javaName}"
                                                <#if being.max?exists>max="${being.max}" </#if> <#if being.min?exists>min="${being.min}" </#if> <#if being.minlength?exists>minlength="${being.minlength}" </#if> <#if being.maxlength?exists>maxlength="${being.maxlength}" </#if> />
                                    <#elseif being.element == 'radio' || being.element == 'checkbox' || being.element == 'select' >
                                        <select id="${being.javaName}"  name="${being.javaName}" <#if being.required?exists && being.required == '1'>required="required"</#if> style="width:98%">
                                            <option value="" ></option>
                                            <c:forEach items="${r"${"} ${being.columnConfig.dictType}_dicts ${r"}"}" var="dict">
                                                <option value="${r"${"} dict.dictVal ${r"}"}" <c:if test="${r"${"} dict.dictVal == m.${being.javaName} ${r"}"}">selected</c:if>>${r"${"} dict.dictName  ${r"}"}</option>
                                            </c:forEach>
                                        </select>
                                    <#elseif being.element == 'openwin' >
                                    <#elseif being.element == 'singlefile' || being.element == 'multifile' || being.element == 'singleimage' || being.element == 'multiimage'  >
                                        <div class="" style="margin-bottom: 0px">
                                            <div class="info-detail">
                                                <input type="hidden" id="${being.javaName}" name="${being.javaName}" value="${r"${"} m.${being.javaName}}">
                                                <div class="uploader-list">
                                                    <ul id="thelist_${being.javaName}" class="file-list" style="margin: 0 0 10px 0" ></ul>
                                                </div>
                                                <div id="thelist_${being.javaName}_items" style="display: none;">
                                                    <c:forEach var="item" items="${r"${"} m.${being.javaName}List}">
                                                        <span id="${r"${"} item.id}" fileUseId="${r"${"} item.id}" accessUrl="${r"${"} item.accessUrl}" fileEngine="${r"${"} item.fileEngine}" fileSize="${r"${"} item.fileSize}" showName="${r"${"} item.showName}" businessId="${r"${"} item.businessId}"   />
                                                    </c:forEach>
                                                </div>

                                                <div class="btns">
                                                    <div id="uploadFile_${being.javaName}" title='附件' class="webuploader-container" style="width: 80px" data-options="viewAreaId:'#thelist_${being.javaName}', businessFileType:'${being.javaName}'  ,businessTempId: '${r"${"} m.${being.javaName}}' ">
                                                        <i class="fa fa-upload"></i>
                                                        <span>上传附件</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    <#else >
                                    </#if>
                                <#elseif being?exists && being.exColumn?exists>
                                    <#if being.element == 'openwin' >
                                        <c:if test="${r"${"} fn:indexOf(allQueryString,'&${being.exColumn.originalJavaName}=') >= 0 ${r"}"}">
                                            <input type="text" class="form-control input-sm" name="${being.javaName}"  id="${being.javaName}" value="${r"${"} m.${being.javaName} ${r"}"}" readonly>
                                        </c:if>
                                        <c:if test="${r"${"} fn:indexOf(allQueryString,'&${being.exColumn.originalJavaName}=') <0  ${r"}"}">
                                        <div class="input-group">
                                            <input type="hidden" name="${being.exColumn.originalJavaName}" id="${being.exColumn.originalJavaName}" value="${r"${"} m.${being.exColumn.originalJavaName} ${r"}"}">
                                            <input type="text" name="${being.javaName}" id="${being.javaName}" value="${r"${"} m.${being.javaName} ${r"}"}" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm ${being.javaName} " placeholder="请选择${being.columnComment}" style="cursor: pointer;" readonly="readonly">
                                            <div class="input-group-btn">
                                                <button type="button"
                                                        class="btn btn-primary btn-sm ${being.javaName}">
                                                    &nbsp;<i class="fa fa-search"></i>&nbsp;
                                                </button>
                                                <button type="button" id="clear${being.exColumn.originalJavaName?cap_first}"
                                                        class="btn btn-primary btn-sm">
                                                    &nbsp;<i class="fa fa-close"></i>&nbsp;
                                                </button>
                                            </div>
                                        </div>
                                        </c:if>
                                    </#if>
                                </#if>
                                </td>
                                <#if being_has_next>
                                <#assign nextPage=showColumnPages[being_index+1]>
                                <th>${nextPage.columnComment}<#if nextPage.required?exists && nextPage.required == '1'><font color="red">*</font></#if></th>
                                <td>
                                <#if nextPage?exists && nextPage.columnConfig?exists>
                                    <#if nextPage.element == 'text'  >
                                        <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${nextPage.javaName} ${r"}"}" id="${nextPage.javaName}" name="${nextPage.javaName}"
                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                    <#elseif nextPage.element == 'textarea' >
                                        <div class="info-detail">
                                            <textarea <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if> " rows="5"
                                                      id="${nextPage.javaName}" name="${nextPage.javaName}" placeholder="请输入${nextPage.columnComment}，${nextPage.maxlength}字以内" maxlength="${nextPage.maxlength}" rows="4">${r"${"} m.${nextPage.javaName} ${r"}"}</textarea>
                                        </div>
                                    <#elseif nextPage.element == 'digits' >
                                        <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm number  <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${nextPage.javaName} ${r"}"}" id="${nextPage.javaName}" name="${nextPage.javaName}" step="1"
                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                    <#elseif nextPage.element == 'number' >
                                        <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm number fd-decimal2 <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${nextPage.javaName} ${r"}"}" id="${nextPage.javaName}" name="${nextPage.javaName}" step="0.01"
                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                    <#elseif nextPage.element == 'date' ||  nextPage.element == 'timestamp' >
                                            <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm Wdate <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                   placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                   onclick="WdatePicker({dateFmt: 'yyyy-MM-dd', el: '${nextPage.javaName}'})"
                                                           value='<fmt:formatDate value="${r"${"} m.${nextPage.javaName} ${r"}"}" pattern="yyyy-MM-dd" />' id="${nextPage.javaName}" name="${nextPage.javaName}" readonly   />

                                    <#elseif nextPage.element == 'email' >
                                        <input type="email" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${nextPage.javaName} ${r"}"}" id="${nextPage.javaName}" name="${nextPage.javaName}"
                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                    <#elseif nextPage.element == 'url' >
                                        <input type="url" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                               value="${r"${"} m.${nextPage.javaName} ${r"}"}" id="${nextPage.javaName}" name="${nextPage.javaName}"
                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                    <#elseif nextPage.element == 'radio' || nextPage.element == 'checkbox' || nextPage.element == 'select' >
                                        <select id="${nextPage.javaName}"  name="${nextPage.javaName}" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> style="width:98%">
                                            <option value="" ></option>
                                            <c:forEach items="${r"${"} ${nextPage.columnConfig.dictType}_dicts ${r"}"}" var="dict">
                                                <option value="${r"${"} dict.dictVal ${r"}"}" <c:if test="${r"${"} dict.dictVal == m.${nextPage.javaName} ${r"}"}">selected</c:if>>${r"${"}  dict.dictName ${r"}"}</option>
                                            </c:forEach>
                                        </select>
                                    <#elseif nextPage.element == 'openwin' >
                                    <#elseif nextPage.element == 'singlefile' || nextPage.element == 'multifile' || nextPage.element == 'singleimage' || nextPage.element == 'multiimage'  >
                                        <div class="" style="margin-bottom: 0px">
                                            <div class="info-detail">
                                                <input type="hidden" id="${nextPage.javaName}" name="${nextPage.javaName}" value="${r"${"} m.${nextPage.javaName}}">
                                                <div class="uploader-list">
                                                    <ul id="thelist_${nextPage.javaName}" class="file-list" style="margin: 0 0 10px 0" ></ul>
                                                </div>
                                                <div id="thelist_${nextPage.javaName}_items" style="display: none;">
                                                    <c:forEach var="item" items="${r"${"} m.${nextPage.javaName}List}">
                                                        <span id="${r"${"} item.id}" fileUseId="${r"${"} item.id}" accessUrl="${r"${"} item.accessUrl}" fileEngine="${r"${"} item.fileEngine}" fileSize="${r"${"} item.fileSize}" showName="${r"${"} item.showName}" businessId="${r"${"} item.businessId}"   />
                                                    </c:forEach>
                                                </div>

                                                <div class="btns">
                                                    <div id="uploadFile_${nextPage.javaName}" title='附件' class="webuploader-container" style="width: 80px" data-options="viewAreaId:'#thelist_${nextPage.javaName}', businessFileType:'${nextPage.javaName}'  ,businessTempId: '${r"${"} m.${nextPage.javaName}}' ">
                                                        <i class="fa fa-upload"></i>
                                                        <span>上传附件</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    <#else >
                                    </#if>
                                <#elseif nextPage?exists && nextPage.exColumn?exists>
                                    <#if nextPage.element == 'openwin' >
                                            <c:if test="${r"${"} fn:indexOf(allQueryString,'&${nextPage.exColumn.originalJavaName}=') >= 0 ${r"}"}">
                                                <input type="text" class="form-control input-sm" name="${nextPage.javaName}" id="${nextPage.javaName}" value="${r"${"} m.${nextPage.javaName} ${r"}"}" readonly>
                                            </c:if>
                                            <c:if test="${r"${"} fn:indexOf(allQueryString,'&${nextPage.exColumn.originalJavaName}=') < 0 ${r"}"}">
                                            <div class="input-group">
                                                <input type="hidden" name="${nextPage.exColumn.originalJavaName}" id="${nextPage.exColumn.originalJavaName}" value="${r"${"} m.${nextPage.exColumn.originalJavaName} ${r"}"}" >
                                                <input type="text" name="${nextPage.javaName}" id="${nextPage.javaName}" value="${r"${"} m.${nextPage.javaName} ${r"}"}" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm ${nextPage.javaName} " placeholder="请选择${nextPage.columnComment}" style="cursor: pointer;" readonly="readonly">
                                                <div class="input-group-btn">
                                                    <button type="button"  class="btn btn-primary btn-sm ${nextPage.javaName}">
                                                        &nbsp;<i class="fa fa-search"></i>&nbsp;
                                                    </button>
                                                    <button type="button" id="clear${nextPage.exColumn.originalJavaName?cap_first}"   class="btn btn-primary btn-sm">
                                                        &nbsp;<i class="fa fa-close"></i>&nbsp;
                                                    </button>
                                                </div>
                                            </div>
                                            </c:if>
                                    </#if>
                                <#else >
                                    出现错误
                                </#if>
                                </td>
                                </#if>
                            </tr>

                        </#if>
                        </#list>
                        </tbody>
                    </table>



                    <#list table.pageChildTableSet as fkTable>
                        <#if fkTable.tableName != table.tableName>
                            <input type="hidden" id="temp${fkTable.fullUpperResourceName}" />
                        </#if>
                    </#list>


                    <#if (table.pageChildColumns?exists && table.pageChildColumns?size > 0 )>
                        <div class="block-each block-each-another">
                            <#list table.pageChildColumns as childColumn>

                                <div class="block-tit">
                                    &nbsp;<i class="fa fa-th-list"></i>&nbsp;${childColumn.tableBO.tableComment}
                                </div>

                                <#if childColumn.tableBO.tableRelation?exists && 'one-one' == childColumn.tableBO.tableRelation>
                                    <input type="hidden" name="${childColumn.tableBO.simpleName}BO.id" id="${childColumn.tableBO.simpleName}BO_id" value="${r"${"} m.${childColumn.tableBO.simpleName}BO.id ${r"}"}">
                                    <table class="info-table hide-area">
                                        <colgroup>
                                            <col style="width: 15%" />
                                            <col style="width: 35%" />
                                            <col style="width: 15%" />
                                            <col style="width: 35%" />
                                        </colgroup>

                                        <tbody>

                                        <#list childColumn.tableBO.tablePO.showPages as being>
                                            <#if being_index%2 ==0>
                                                <tr>
                                                    <#if being?exists && ( (being.columnConfig?exists && being.columnConfig.javaName != childColumn.javaName)  || (being.exColumn?exists && being.exColumn.originalColumn.javaName != childColumn.javaName))>
                                                    <th>${being.columnComment}<#if being.required?exists && being.required == '1'><font color="red">*</font></#if></th>
                                                    <td class="fd_${childColumn.tableBO.simpleName}BO${being.javaName}<#if  being.element == 'select' || being.element == 'checkbox' || being.element == 'radio'>Name</#if>">
                                                        <#if being.element == 'date' >
                                                            <fmt:formatDate value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${being.javaName} ${r"}"}" pattern="yyyy-MM-dd" />
                                                        <#elseif being.element == 'timestamp' >
                                                            <fmt:formatDate value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${being.javaName} ${r"}"}" pattern="yyyy-MM-dd  HH:mm:ss" />
                                                        <#elseif being.element == 'select' || being.element == 'checkbox' || being.element == 'radio' >
                                                            ${r"${"} m.${childColumn.tableBO.simpleName}BO.${being.javaName}Name ${r"}"}
                                                        <#else >
                                                            <c:out value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${being.javaName} ${r"}"}" escapeXml="true"/>
                                                        </#if>
                                                    </td>
                                                    </#if>
                                                    <#if being_has_next>
                                                        <#assign nextPage=childColumn.tableBO.tablePO.showPages[being_index+1]>
                                                        <#if nextPage?exists && ( (nextPage.columnConfig?exists && nextPage.columnConfig.javaName != childColumn.javaName)  || (nextPage.exColumn?exists && nextPage.exColumn.originalColumn.javaName != childColumn.javaName))>

                                                        <th>${nextPage.columnComment}<#if nextPage.required?exists && nextPage.required == '1'><font color="red">*</font></#if></th>
                                                        <td class="fd_${childColumn.tableBO.simpleName}BO${nextPage.javaName}<#if  nextPage.element == 'select' || nextPage.element == 'checkbox' || nextPage.element == 'radio'>Name</#if>">
                                                            <#if nextPage.element == 'date' >
                                                                <fmt:formatDate value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" pattern="yyyy-MM-dd" />
                                                            <#elseif nextPage.element == 'timestamp' >
                                                                <fmt:formatDate value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" pattern="yyyy-MM-dd  HH:mm:ss" />
                                                            <#elseif nextPage.element == 'select' || nextPage.element == 'checkbox' || nextPage.element == 'radio' >
                                                                ${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName}Name ${r"}"}
                                                            <#else >
                                                                <c:out value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" escapeXml="true"/>
                                                            </#if>
                                                        </td>
                                                        </#if>
                                                    </#if>
                                                </tr>

                                            </#if>
                                        </#list>

                                        </tbody>


                                    </table>






                                    <table class="info-table show-area">
                                        <colgroup>
                                            <col style="width: 15%" />
                                            <col style="width: 35%" />
                                            <col style="width: 15%" />
                                            <col style="width: 35%" />
                                        </colgroup>

                                        <tbody>


                                        <#list childColumn.tableBO.tablePO.showPages as listPage>
                                            <#if listPage_index%2 ==0>
                                                <tr>
                                                    <#if listPage?exists && ( (listPage.columnConfig?exists && listPage.columnConfig.javaName != childColumn.javaName)  || (listPage.exColumn?exists && listPage.exColumn.originalColumn.javaName != childColumn.javaName))>
                                                        <th>${listPage.columnComment}<#if listPage.required?exists && listPage.required == '1'><font color="red">*</font></#if></th>
                                                        <td>
                                                            <#if listPage?exists && listPage.columnConfig?exists>
                                                                <#if listPage.element == 'text'  >
                                                                    <input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm <#if listPage.required?exists && listPage.required == '1'>required</#if>"
                                                                           placeholder="请输入${listPage.columnComment}" autocomplete="off"
                                                                           value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}"
                                                                            <#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />
                                                                <#elseif listPage.element == 'textarea' >
                                                                    <div class="info-detail">
                                                                    <textarea <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm <#if listPage.required?exists && listPage.required == '1'>required</#if> "
                                                                              name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" placeholder="请输入${listPage.columnComment}，${listPage.maxlength}字以内" maxlength="${listPage.maxlength}" rows="5">${r"${"} m.${listPage.javaName} ${r"}"}</textarea>
                                                                    </div>
                                                                <#elseif listPage.element == 'digits' >
                                                                    <input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm number  <#if listPage.required?exists && listPage.required == '1'>required</#if>"
                                                                           placeholder="请输入${listPage.columnComment}" autocomplete="off"
                                                                           value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" step="1"
                                                                            <#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />
                                                                <#elseif listPage.element == 'number' >
                                                                    <input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm number fd-decimal2 <#if listPage.required?exists && listPage.required == '1'>required</#if>"
                                                                           placeholder="请输入${listPage.columnComment}" autocomplete="off"
                                                                           value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" step="0.01"
                                                                            <#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />
                                                                <#elseif listPage.element == 'date' ||  listPage.element == 'timestamp' >

                                                                    <input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm Wdate <#if listPage.required?exists && listPage.required == '1'>required</#if>"
                                                                           placeholder="请输入${listPage.columnComment}" autocomplete="off"
                                                                           onclick="WdatePicker({dateFmt: 'yyyy-MM-dd', el: '${childColumn.tableBO.simpleName}BO_${listPage.javaName}'})"
                                                                           value='<fmt:formatDate value=“${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}” pattern="yyyy-MM-dd" />' id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" readonly   />

                                                                <#elseif listPage.element == 'email' >
                                                                    <input type="email" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm <#if listPage.required?exists && listPage.required == '1'>required</#if>"
                                                                           placeholder="请输入${listPage.columnComment}" autocomplete="off"
                                                                           value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}"
                                                                            <#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />
                                                                <#elseif listPage.element == 'url' >
                                                                    <input type="url" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm <#if listPage.required?exists && listPage.required == '1'>required</#if>"
                                                                           placeholder="请输入${listPage.columnComment}" autocomplete="off"
                                                                           value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}"
                                                                            <#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />
                                                                <#elseif listPage.element == 'radio' || listPage.element == 'checkbox' || listPage.element == 'select' >
                                                                    <select id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}"  name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> style="width:98%">
                                                                        <option value="" ></option>
                                                                        <c:forEach items="${r"${"} ${listPage.columnConfig.dictType}_dicts ${r"}"}" var="dict">
                                                                            <option value="${r"${"} dict.dictVal ${r"}"}" <c:if test="${r"${"} dict.dictVal == m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}">selected</c:if>>${r"${"} dict.dictName  ${r"}"}</option>
                                                                        </c:forEach>
                                                                    </select>
                                                                <#elseif listPage.element == 'openwin' >
                                                                <#else >
                                                                </#if>
                                                            <#elseif listPage?exists && listPage.exColumn?exists>
                                                                <#if listPage.element == 'openwin' && listPage.exColumn.originalColumn.tableBO.tableName!=table.tableName>
                                                                    <c:if test="${r"${"} fn:indexOf(allQueryString,'&${listPage.exColumn.originalJavaName}=') >=0 ${r"}"}">
                                                                        <input type="text" class="form-control input-sm" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}"  value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}" readonly>
                                                                    </c:if>
                                                                    <c:if test="${r"${"} fn:indexOf(allQueryString,'&${listPage.exColumn.originalJavaName}=') < 0 ${r"}"}">
                                                                        <div class="input-group">
                                                                            <input type="hidden" name="${childColumn.tableBO.simpleName}BO.${listPage.exColumn.originalJavaName}" id="${childColumn.tableBO.simpleName}BO_${listPage.exColumn.originalJavaName}" value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.exColumn.originalJavaName} ${r"}"}">
                                                                            <input type="text" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm ${childColumn.tableBO.simpleName}BO_${listPage.javaName} " placeholder="请选择${listPage.columnComment}" style="cursor: pointer;" readonly="readonly">
                                                                            <div class="input-group-btn">
                                                                                <button type="button"
                                                                                        class="btn btn-primary btn-sm ${childColumn.tableBO.simpleName}BO_${listPage.javaName}">
                                                                                    &nbsp;<i class="fa fa-search"></i>&nbsp;
                                                                                </button>
                                                                                <button type="button" id="clear${childColumn.tableBO.simpleName}BO_${listPage.exColumn.originalJavaName?cap_first}"
                                                                                        class="btn btn-primary btn-sm">
                                                                                    &nbsp;<i class="fa fa-close"></i>&nbsp;
                                                                                </button>
                                                                            </div>
                                                                        </div>
                                                                    </c:if>
                                                                </#if>
                                                            </#if>
                                                        </td>
                                                    </#if>

                                                    <#if listPage_has_next>
                                                        <#assign nextPage=childColumn.tableBO.tablePO.showPages[listPage_index+1]>
                                                        <#if nextPage?exists && ( (nextPage.columnConfig?exists && nextPage.columnConfig.javaName != childColumn.javaName)  || (nextPage.exColumn?exists && nextPage.exColumn.originalColumn.javaName != childColumn.javaName))>
                                                            <th>${nextPage.columnComment}<#if nextPage.required?exists && nextPage.required == '1'><font color="red">*</font></#if></th>
                                                            <td>
                                                                <#if nextPage?exists && nextPage.columnConfig?exists>
                                                                    <#if nextPage.element == 'text'  >
                                                                        <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                                               value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}"
                                                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                                                    <#elseif nextPage.element == 'textarea' >
                                                                        <div class="info-detail">
                                                                        <textarea <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if> "
                                                                                  id=name="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" placeholder="请输入${nextPage.columnComment}，${nextPage.maxlength}字以内" maxlength="${nextPage.maxlength}" rows="5">${r"${"} m.${nextPage.javaName} ${r"}"}</textarea>
                                                                        </div>
                                                                    <#elseif nextPage.element == 'digits' >
                                                                        <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm number  <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                                               value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" step="1"
                                                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                                                    <#elseif nextPage.element == 'number' >
                                                                        <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm number fd-decimal2 <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                                               value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" step="0.01"
                                                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                                                    <#elseif nextPage.element == 'date' ||  nextPage.element == 'timestamp' >

                                                                        <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm Wdate <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                                               onclick="WdatePicker({dateFmt: 'yyyy-MM-dd', el: '${childColumn.tableBO.simpleName}BO_${nextPage.javaName}'})"
                                                                               value='<fmt:formatDate value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" pattern="yyyy-MM-dd" />' id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" readonly   />

                                                                    <#elseif nextPage.element == 'email' >
                                                                        <input type="email" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                                               value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}"
                                                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                                                    <#elseif nextPage.element == 'url' >
                                                                        <input type="url" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                                               placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                                               value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}"
                                                                                <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />
                                                                    <#elseif nextPage.element == 'radio' || nextPage.element == 'checkbox' || nextPage.element == 'select' >
                                                                        <select id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}"  name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> style="width:98%">
                                                                            <option value="" ></option>
                                                                            <c:forEach items="${r"${"} ${nextPage.columnConfig.dictType}_dicts ${r"}"}" var="dict">
                                                                                <option value="${r"${"} dict.dictVal ${r"}"}" <c:if test="${r"${"} dict.dictVal == m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}">selected</c:if>>${r"${"} dict.dictName ${r"}"}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    <#elseif nextPage.element == 'openwin' >
                                                                    <#else >
                                                                    </#if>
                                                                <#elseif nextPage?exists && nextPage.exColumn?exists>
                                                                    <#if nextPage.element == 'openwin' && nextPage.exColumn.originalColumn.tableBO.tableName!=table.tableName>
                                                                        <c:if test="${r"${"} fn:indexOf(allQueryString,'&${nextPage.exColumn.originalJavaName}=') >= 0 ${r"}"}">
                                                                            <input type="text" class="form-control input-sm" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}"  value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" readonly>
                                                                        </c:if>
                                                                        <c:if test="${r"${"} fn:indexOf(allQueryString,'&${nextPage.exColumn.originalJavaName}=') < 0 ${r"}"}">
                                                                            <div class="input-group">
                                                                                <input type="hidden" name="${childColumn.tableBO.simpleName}BO.${nextPage.exColumn.originalJavaName}" id="${childColumn.tableBO.simpleName}BO_${nextPage.exColumn.originalJavaName}" value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.exColumn.originalJavaName} ${r"}"}" >
                                                                                <input type="text" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm ${childColumn.tableBO.simpleName}BO_${nextPage.javaName} " placeholder="请选择${nextPage.columnComment}" style="cursor: pointer;" readonly="readonly">
                                                                                <div class="input-group-btn">
                                                                                    <button type="button"  class="btn btn-primary btn-sm ${childColumn.tableBO.simpleName}BO_${nextPage.javaName}">
                                                                                        &nbsp;<i class="fa fa-search"></i>&nbsp;
                                                                                    </button>
                                                                                    <button type="button" id="clear${childColumn.tableBO.simpleName}BO_${nextPage.exColumn.originalJavaName?cap_first}"   class="btn btn-primary btn-sm">
                                                                                        &nbsp;<i class="fa fa-close"></i>&nbsp;
                                                                                    </button>
                                                                                </div>
                                                                            </div>
                                                                        </c:if>
                                                                    </#if>
                                                                <#else >
                                                                    出现错误
                                                                </#if>
                                                            </td>
                                                        </#if>
                                                    </#if>


                                                </tr>
                                            </#if>
                                        </#list>
                                        </tbody>

                                    </table>

                                <#else >



                                    <div class="${childColumn.tableBO.fullUpperResourceName?uncap_first}" style="width: 100%">
                                        <table id='tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}' class='easyui-datagrid' singleSelect="true" scrollbarSize="0"   method='post' fit='false'  fitColumns="true" border='true'>
                                            <thead>
                                            <tr>
                                                <th field="id" align="left" hidden="true">id</th>
                                                <#if childColumn.tableBO.tablePO.listColumnPages?exists>
                                                    <#list childColumn.tableBO.tablePO.listColumnPages as listPage>
                                                        <#if listPage?exists && ( (listPage.columnConfig?exists && listPage.columnConfig.javaName != childColumn.javaName)  || (listPage.exColumn?exists && listPage.exColumn.originalColumn.javaName != childColumn.javaName))>
                                                            <th field='${listPage.javaName}' <#if listPage.numberColumn=='1' >align="right"<#elseif listPage.dateColumn=='1' >align="center"<#else >align="left"</#if> width="1" <#if listPage.numberColumn=='1' >sortable='true'<#elseif listPage.dateColumn=='1'  >sortable='true'<#else >sortable='false'</#if> formatter="${childColumn.tableBO.fullUpperResourceName?uncap_first}_${listPage.javaName}Fmt"  >${listPage.columnComment}</th>
                                                        </#if>
                                                    </#list>
                                                </#if>
                                                <th field="option" align="left" formatter="markFmt${childColumn.tableBO.simpleName?cap_first}">操作</th>
                                            </tr>
                                            </thead>
                                        </table>
                                        <div class="show-area" style="text-align: center;margin: 5px">
                                            <button type="button" class="btn btn-primary btn-sm" onclick="doAdd${childColumn.tableBO.simpleName?cap_first}()">
                                               <i class="fa fa-plus"></i>
                                                <span>添 加</span>
                                            </button>
                                        </div>
                                    </div>


                                </#if>
                            </#list>
                        </div>
                    </#if>








                </form>
            </div>

            <div style="margin-top:10px;position:absolute;" align="center" class="toolBar">

                <shiro:hasPermission name="${table.fullResource}:update">
                    <button type="button" class="btn btn-primary btn-sm hide-area" onclick="openEdit()">
                        <i class="fa fa-edit"></i>
                        <span>编 辑</span>
                    </button>
                </shiro:hasPermission>

                <button type="button" class="btn  btn-warning btn-sm hide-area" onclick="closeWindow()">
                    <i class="fa fa-mail-reply"></i>
                    <span>返 回</span>
                </button>


                <shiro:hasPermission name="${table.fullResource}:update">
                    <button type="button" class="btn btn-primary btn-sm show-area" onclick="doUpdate()">
                        <i class="fa fa-save"></i>
                        <span>保 存</span>
                    </button>
                </shiro:hasPermission>

                <button type="button" class="btn  btn-warning btn-sm show-area" onclick="cancelEdit()">
                    <i class="fa fa-close"></i>
                    <span>取 消</span>
                </button>

            </div>
        </div>
    </div>
</div>

<script>
    var inAllPage = "${r"${"} inAllPage ${r"}"}";
</script>

<bms:contentJS />


<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/form.js"></script>
<#if table.fileColumns?exists>
<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/common-upload.js"></script>
</#if>

<#list table.pageChildTableSet as fkTable>
<#if fkTable.tableName != table.tableName>
<script src="${r"${"} staticUrl ${r"}"}/statics2/business-js${fkTable.fullResourceName}/search.js"></script>
</#if>
</#list>

<#list table.fkTables as fkTable>
<script src="${r"${"} staticUrl ${r"}"}/statics2/business-js${fkTable.fullResourceName}/search.js"></script>
</#list>



<script language="JavaScript">
    $(function() {

        <#list showColumnPages as listPage>
        <#if listPage?exists && listPage.exColumn?exists>
        <#if listPage.element == 'openwin' >

        //选择${listPage.columnComment}
        ${r"$"}(".${listPage.javaName}").Open${listPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}SelectWin({
            title: "${listPage.columnComment}",
            selectType: "<#if listPage.exColumn.originalColumn.fkTableConfig.isTree == '1'>t<#else >d</#if>1",
            callId: "${listPage.exColumn.originalJavaName}",
            callName: "${listPage.javaName}",
            clearId: "clear${listPage.exColumn.originalJavaName?cap_first}"
        });
        </#if>
        </#if>
        </#list>

        <#if (table.pageChildColumns?exists && table.pageChildColumns?size > 0 )>
        <#list table.pageChildColumns as childColumn>
        <#if childColumn.tableBO.tableRelation?exists && 'one-one' == childColumn.tableBO.tableRelation>
        <#list childColumn.tableBO.tablePO.showPages as listPage>
        <#if listPage.element == 'openwin' >
        <#if listPage.exColumn.originalColumn.fkTableConfig.tableName != table.tableName>
        ${r"$"}(".${childColumn.tableBO.simpleName}BO_${listPage.javaName}").Open${listPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}SelectWin({
            title: "${listPage.columnComment}",
            selectType: "<#if listPage.exColumn.originalColumn.fkTableConfig.isTree == '1'>t<#else >d</#if>1",
            callId: "${childColumn.tableBO.simpleName}BO_${listPage.exColumn.originalJavaName}",
            callName: "${childColumn.tableBO.simpleName}BO_${listPage.javaName}",
            clearId: "clear${childColumn.tableBO.simpleName}BO_${listPage.exColumn.originalJavaName?cap_first}"
        });
        </#if>
        </#if>
        </#list>
        </#if>
        </#list>
        </#if>




        <#list table.pageChildTableSet as fkTable>
        <#if fkTable.tableName != table.tableName>
        $("#temp${fkTable.fullUpperResourceName}").Open${fkTable.fullUpperResourceName?cap_first}SelectWin({
            title: "${fkTable.tableComment}",
            selectType: "<#if fkTable.isTree == '1'>t<#else >d</#if>1",
            callId: "",
            callName: "",
            clearId: ""
        },function(id,name,row){
            $(temp${fkTable.fullUpperResourceName?cap_first}).val(row.${fkTable.businessNameCamelCase?uncap_first});
            $(temp${fkTable.fullUpperResourceName?cap_first}).prev().val(row.id);

            costTableRows(tableId , tableJavaName , temp${fkTable.fullUpperResourceName?cap_first}Index);

        });
        </#if>
        </#list>

        <#if table.pageChildColumns?exists>
        <#list table.pageChildColumns as childColumn>
        <#if childColumn.tableBO.tableRelation?exists && 'one-multi' == childColumn.tableBO.tableRelation>
        $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid({
            url : $AppContext+dataUrl+"/${childColumn.tableBO.simpleName}/list?${childColumn.javaName}=${r"${"} m.id ${r"}"}",
            onLoadSuccess : function(data){
                if(data.rows!=null){
                    $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("resize", {height: (data.rows.length + 1) * tableHeight});
                    $(".fd-decimal2").inputDecimal(2);
                }
            }
        });
        </#if>
        </#list>
        </#if>
    });


    <#if table.pageChildColumns?exists >
    var tableId , tableJavaName;

    <#list table.pageChildTableSet as fkTable>
    <#if fkTable.tableName != table.tableName>
    var temp${fkTable.fullUpperResourceName}  , temp${fkTable.fullUpperResourceName}Index ;
    </#if>
    </#list>
    </#if>


    <#if (table.childListDicts?exists && table.childListDicts?size > 0) >
    <#list table.childListDicts as dictType>
    function ${dictType!}_dicts() {
        var html = "<option value=''>请选择</option>";
    <c:forEach items="${r"${"} ${dictType!}_dicts ${r"}"}" var="dict">
        html += "<option value='${r"${"} dict.dictVal ${r"}"}'>${r"${"} dict.dictName ${r"}"}</option>";
    </c:forEach>
        return html;
    }
    </#list>
    </#if>



    <#list table.pageChildTableSet as fkTable>
    <#if fkTable.tableName != table.tableName>
    function open${fkTable.fullUpperResourceName}(theTabelId , theTableJavaName ,obj ,index){
        if(obj != null && obj != undefined) {
            temp${fkTable.fullUpperResourceName}Index = index;
            temp${fkTable.fullUpperResourceName} = obj[0];
            if(temp${fkTable.fullUpperResourceName} == null){
                temp${fkTable.fullUpperResourceName} = obj;
            }


            tableId = theTabelId;
            tableJavaName = theTableJavaName;

            $("#temp${fkTable.fullUpperResourceName}").click();
        }
    }
    function clear${fkTable.fullUpperResourceName}(theTabelId , theTableJavaName ,obj ,index){
        if(obj != null && obj != undefined){
            temp${fkTable.fullUpperResourceName}Index = index;
            temp${fkTable.fullUpperResourceName} = obj[0];
            if(temp${fkTable.fullUpperResourceName} == null){
                temp${fkTable.fullUpperResourceName} = obj;
            }

            tableId = theTabelId
            tableJavaName = theTableJavaName
            $(temp${fkTable.fullUpperResourceName}).val("");
            $(temp${fkTable.fullUpperResourceName}).prev().val("");

            costTableRows(tableId , tableJavaName , temp${fkTable.fullUpperResourceName}Index);
        }
    }
    </#if>
    </#list>




    <#if table.pageChildColumns?exists>
    <#list table.pageChildColumns as childColumn>
    <#if childColumn.tableBO.tableRelation?exists && 'one-multi' == childColumn.tableBO.tableRelation>
    <#if childColumn.tableBO.tablePO.listColumnPages?exists>
    <#list childColumn.tableBO.tablePO.listColumnPages as listPage>

    <#if listPage?exists && ( (listPage.columnConfig?exists && listPage.columnConfig.javaName != childColumn.javaName)  || (listPage.exColumn?exists && listPage.exColumn.originalColumn.javaName != childColumn.javaName))>

    function ${childColumn.tableBO.fullUpperResourceName?uncap_first}_${listPage.javaName}Fmt(val, row,index){
        <#if listPage.exColumn?exists && listPage.exColumn.originalColumn.columnIsdict== '1'>
        var html = "<select name='${childColumn.tableBO.simpleName}BOList["+index+"].${listPage.exColumn.originalColumn.javaName}' id='${childColumn.tableBO.simpleName}BOList_"+index+"_${listPage.exColumn.originalColumn.javaName}' onblur='costTableRows(\"tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\" , \"${childColumn.tableBO.simpleName}BOList \" , "+index+")' class='form-control input-sm show-area <#if listPage.exColumn.originalColumn.columnIsnull=='0'>required</#if>'>" ;
        html += checkedOption(${listPage.exColumn.originalColumn.dictType}_dicts() , row.${listPage.exColumn.originalColumn.javaName});
        html += "</select>";
        html += "<div class='hide-area'>"+row.${listPage.javaName}+"</div>";
        return html;
        <#elseif listPage.exColumn?exists && listPage.exColumn.originalColumn.columnIsfk == '1'>

        var html = '<div class="input-group show-area">';
        html += '<input type="hidden" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.exColumn.originalColumn.javaName}" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.exColumn.originalColumn.javaName}" value="'+row.${listPage.exColumn.originalColumn.javaName}+'" >';
        html += '<input type="text"  class="form-control input-sm openwindow ${listPage.exColumn.javaName}" onclick="open${listPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\',\'${childColumn.tableBO.simpleName}BOList\',this,'+index+')" required="required" value="'+row.${listPage.exColumn.javaName}+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.exColumn.javaName}"  name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.exColumn.javaName}"  onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')" placeholder="请选择${listPage.columnComment}" readonly >';
        html += '<div class="input-group-btn">';
        html += '<div class="btn btn-primary btn-sm" onclick="open${listPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\', \'${childColumn.tableBO.simpleName}BOList\',document.getElementById(\'${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.exColumn.javaName}\'),'+index+')">';
        html += '&nbsp;<i class="fa fa-search"></i>&nbsp;';
        html += '</div>';
        html += '<div class="btn btn-primary btn-sm" onclick="clear${listPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\', \'${childColumn.tableBO.simpleName}BOList\',document.getElementById(\'${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.exColumn.javaName}\'),'+index+')"  >';
        html += '&nbsp;<i class="fa fa-close"></i>&nbsp;';
        html += '</div>';
        html += '</div>';
        html += '</div>';


        html += "<div class='hide-area' >"+row.${listPage.javaName}+"</div>" ;

        return html;
        <#else >

        <#if listPage.element == 'text'  || listPage.element == 'textarea'  >
        var html = '<input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm show-area <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
            'placeholder="请输入${listPage.columnComment}" autocomplete="off" '+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
            'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}"'+
            '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';

        <#elseif listPage.element == 'digits' >
        var html = '<input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm show-area number  <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
            'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
            'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}" step="1"'+
            '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';
        <#elseif listPage.element == 'number' >
        var html = '<input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm show-area number fd-decimal2 <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
            'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
            'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}" step="0.01"'+
            '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';
        <#elseif listPage.element == 'date' ||  listPage.element == 'timestamp' >
        var dd = "";
        if(val != undefined && val != null && val != 0){
            <#if listPage.element == 'date'>
            dd = changeDateFormat(val);
            <#else >
            dd = changeDatetimeFormat(val);
            </#if>
        }
        var html = '<input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm show-area Wdate  <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
            'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
            'onclick="WdatePicker({dateFmt: \'yyyy-MM-dd\', el: \'${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}\'})"'+
            'value="'+dd+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}" readonly   />';
        <#elseif listPage.element == 'email' >
        var html = '<input type="email" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm show-area <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
            'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
            'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}"'+
            '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';
        <#elseif listPage.element == 'url' >
        var html = '<input type="url" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm show-area <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
            'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
            'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}"'+
            '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';

        <#else >
        </#if>
        html += "<div class='hide-area' >"+<#if listPage.element == 'date' ||  listPage.element == 'timestamp' >dd<#else >val</#if>+"</div>" ;
        return html;

        </#if>
    }
    </#if>
    </#list>
    </#if>
    function markFmt${childColumn.tableBO.simpleName?cap_first}(val, r,index){
        var html =	'<div class="grid-column-option">';
        html+=	'<a href="javascript: doDel${childColumn.tableBO.simpleName?cap_first}('+ index + ');" title="删除"><i class="fa fa-trash"></i></a>';
        html+=	'</div>';
        return html;
    }


    function doDel${childColumn.tableBO.simpleName?cap_first}(index){
        $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("deleteRow" , index);
        var rows = $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("getRows");
        $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("loadData",rows);
        openEdit();
    }

    function doAdd${childColumn.tableBO.simpleName?cap_first}() {
        var rows = $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("getRows");
        rows.push({ <#if (childColumn.tableBO.tablePO.showPages?exists && childColumn.tableBO.tablePO.showPages?size >0)><#list childColumn.tableBO.tablePO.showPages as listPage>${listPage.javaName} : "" <#if listPage_has_next>,</#if></#list></#if> });
        $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("loadData",rows);
        openEdit();
    }
    </#if>
    </#list>

    </#if>

</script>


<bms:contentFooter />