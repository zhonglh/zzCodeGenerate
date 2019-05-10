<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<bms:contentHeader title="${project.projectName!}" />


<div style="padding:0 10px">
    <div class="row">
        <div class="col-xs-12 col-lg-12 col-md-12" style="padding-left: 0;padding-right: 0">
            <div class="block-each block-each-another">

                <form id="editForm" action="" method="post">

                    <div class="block-tit">
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-youjiantou"></use>
                        </svg>基本信息
                    </div>

                    <table class="info-table">
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
                                                          name="${being.javaName}" id="${being.javaName} " placeholder="请输入${being.columnComment}，${being.maxlength}字以内" maxlength="${being.maxlength}" rows="5">${r"${"} m.${being.javaName} ${r"}"}</textarea>
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
                                                           value="${r"${"} m.${being.javaName} ${r"}"}" id="${being.javaName}" name="${being.javaName}" readonly   />

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
                                            <#else >
                                            </#if>
                                        <#elseif being?exists && being.exColumn?exists>
                                            <#if being.element == 'openwin' >
                                                <c:if test="${r"${"} fn:indexOf(allQueryString,'&${being.exColumn.originalJavaName}=') >=0 ${r"}"}">
                                                    <input type="text" class="form-control input-sm" name="${being.javaName}" id="${being.javaName}"  value="${r"${"} m.${being.javaName} ${r"}"}" readonly>
                                                </c:if>
                                                <c:if test="${r"${"} fn:indexOf(allQueryString,'&${being.exColumn.originalJavaName}=') < 0 ${r"}"}">
                                                    <div class="input-group">
                                                        <input type="hidden" name="${being.exColumn.originalJavaName}" id="${being.exColumn.originalJavaName}" value="${r"${"} m.${being.exColumn.originalJavaName} ${r"}"}">
                                                        <input type="text" name="${being.javaName}" id="${being.javaName}" value="${r"${"} m.${being.javaName} ${r"}"}" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm ${being.javaName} " placeholder="请选择${being.columnComment}" style="cursor: pointer;" readonly="readonly">
                                                        <div class="input-group-btn">
                                                            <button type="button"
                                                                    class="btn btn-primary btn-sm ${being.javaName}">
                                                                <svg class="icon" aria-hidden="true">
                                                                    <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                         xlink:href="#icon-sousuo">
                                                                    </use>
                                                                </svg>
                                                            </button>
                                                            <button type="button" id="clear${being.exColumn.originalJavaName?cap_first}"
                                                                    class="btn btn-primary btn-sm">
                                                                <svg class="icon" aria-hidden="true">
                                                                    <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                         xlink:href="#icon-close">
                                                                    </use>
                                                                </svg>
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
                                                      id="${nextPage.javaName}"  name="${nextPage.javaName}" placeholder="请输入${nextPage.columnComment}，${nextPage.maxlength}字以内" maxlength="${nextPage.maxlength}" rows="4">${r"${"} m.${nextPage.javaName} ${r"}"}</textarea>
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
                                                               value="${r"${"} m.${nextPage.javaName} ${r"}"}" id="${nextPage.javaName}" name="${nextPage.javaName}" readonly   />

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
                                                            <option value="${r"${"} dict.dictVal ${r"}"}" <c:if test="${r"${"} dict.dictVal == m.${nextPage.javaName} ${r"}"}">selected</c:if>>${r"${"} dict.dictName ${r"}"}</option>
                                                        </c:forEach>
                                                    </select>
                                                <#elseif nextPage.element == 'openwin' >
                                                <#else >
                                                </#if>
                                            <#elseif nextPage?exists && nextPage.exColumn?exists>
                                                <#if nextPage.element == 'openwin' >
                                                    <c:if test="${r"${"} fn:indexOf(allQueryString,'&${nextPage.exColumn.originalJavaName}=') >= 0 ${r"}"}">
                                                        <input type="text" class="form-control input-sm" name="${nextPage.javaName}" id="${nextPage.javaName}"  value="${r"${"} m.${nextPage.javaName} ${r"}"}" readonly>
                                                    </c:if>
                                                    <c:if test="${r"${"} fn:indexOf(allQueryString,'&${nextPage.exColumn.originalJavaName}=') < 0 ${r"}"}">
                                                        <div class="input-group">
                                                            <input type="hidden" name="${nextPage.exColumn.originalJavaName}" id="${nextPage.exColumn.originalJavaName}" value="${r"${"} m.${nextPage.exColumn.originalJavaName} ${r"}"}" >
                                                            <input type="text" name="${nextPage.javaName}" id="${nextPage.javaName}" value="${r"${"} m.${nextPage.javaName} ${r"}"}" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm ${nextPage.javaName} " placeholder="请选择${nextPage.columnComment}" style="cursor: pointer;" readonly="readonly">
                                                            <div class="input-group-btn">
                                                                <button type="button"  class="btn btn-primary btn-sm ${nextPage.javaName}">
                                                                    <svg class="icon" aria-hidden="true">
                                                                        <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                             xlink:href="#icon-sousuo">
                                                                        </use>
                                                                    </svg>
                                                                </button>
                                                                <button type="button" id="clear${nextPage.exColumn.originalJavaName?cap_first}"   class="btn btn-primary btn-sm">
                                                                    <svg class="icon" aria-hidden="true">
                                                                        <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                             xlink:href="#icon-close">
                                                                        </use>
                                                                    </svg>
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
                                    <svg class="icon" aria-hidden="true">
                                        <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-youjiantou"></use>
                                    </svg>${childColumn.tableBO.tableComment}
                                </div>

                                <#if childColumn.tableBO.tableRelation?exists && 'one-one' == childColumn.tableBO.tableRelation>
                                    <table class="info-table">
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
                                                                              name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" id="${listPage.javaName} " placeholder="请输入${listPage.columnComment}，${listPage.maxlength}字以内" maxlength="${listPage.maxlength}" rows="5">${r"${"} m.${listPage.javaName} ${r"}"}</textarea>
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
                                                                           value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${listPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${listPage.javaName}" readonly   />

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
                                                                                <svg class="icon" aria-hidden="true">
                                                                                    <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                                         xlink:href="#icon-sousuo">
                                                                                    </use>
                                                                                </svg>
                                                                            </button>
                                                                            <button type="button" id="clear${childColumn.tableBO.simpleName}BO_${listPage.exColumn.originalJavaName?cap_first}"
                                                                                    class="btn btn-primary btn-sm">
                                                                                <svg class="icon" aria-hidden="true">
                                                                                    <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                                         xlink:href="#icon-close">
                                                                                    </use>
                                                                                </svg>
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
                                                                                  name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" placeholder="请输入${nextPage.columnComment}，${nextPage.maxlength}字以内" maxlength="${nextPage.maxlength}" rows="5">${r"${"} m.${nextPage.javaName} ${r"}"}</textarea>
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
                                                                                   value="${r"${"} m.${childColumn.tableBO.simpleName}BO.${nextPage.javaName} ${r"}"}" id="${childColumn.tableBO.simpleName}BO_${nextPage.javaName}" name="${childColumn.tableBO.simpleName}BO.${nextPage.javaName}" readonly   />

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
                                                                                        <svg class="icon" aria-hidden="true">
                                                                                            <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                                                 xlink:href="#icon-sousuo">
                                                                                            </use>
                                                                                        </svg>
                                                                                    </button>
                                                                                    <button type="button" id="clear${childColumn.tableBO.simpleName}BO_${nextPage.exColumn.originalJavaName?cap_first}"   class="btn btn-primary btn-sm">
                                                                                        <svg class="icon" aria-hidden="true">
                                                                                            <use xmlns:xlink="http://www.w3.org/1999/xlink"
                                                                                                 xlink:href="#icon-close">
                                                                                            </use>
                                                                                        </svg>
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
                                        <div style="text-align: center;margin: 5px">
                                            <button type="button" class="btn btn-primary btn-sm" onclick="doAdd${childColumn.tableBO.simpleName?cap_first}()">
                                                <svg class="icon" aria-hidden="true">
                                                    <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-plus"></use>
                                                </svg>
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
                <shiro:hasPermission name="${table.fullResource}:add">
                    <button type="button" class="btn btn-primary btn-sm" onclick="doSave()">
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-save-continue"></use>
                        </svg>
                        <span>保 存</span>
                    </button>
                </shiro:hasPermission>
                <button type="button" class="btn  btn-warning btn-sm" onclick="closeWindow()">
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
    var inAllPage = "${r"${"} inAllPage ${r"}"}";
</script>

<bms:contentJS />

<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/form.js"></script>


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
            data : []
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
        var html = "<select name='${childColumn.tableBO.simpleName}BOList["+index+"].${listPage.exColumn.originalColumn.javaName}' id='${childColumn.tableBO.simpleName}BOList_"+index+"_${listPage.exColumn.originalColumn.javaName}' onblur='costTableRows(\"tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\" , \"${childColumn.tableBO.simpleName}BOList \" , "+index+")' class='form-control input-sm <#if listPage.exColumn.originalColumn.columnIsnull=='0'>required</#if>'>" ;
        html += checkedOption(${listPage.exColumn.originalColumn.dictType}_dicts() , row.${listPage.exColumn.originalColumn.javaName});
        html += "</select>";
        return html;
        <#elseif listPage.exColumn?exists && listPage.exColumn.originalColumn.columnIsfk == '1'>

        var html = '<div class="input-group">';
        html += '<input type="hidden" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.exColumn.originalColumn.javaName}" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.exColumn.originalColumn.javaName}" value="'+row.${listPage.exColumn.originalColumn.javaName}+'" >';
        html += '<input type="text"  class="form-control input-sm ${listPage.exColumn.javaName}" onclick="open${listPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\',\'${childColumn.tableBO.simpleName}BOList\',this,'+index+')" required="required" value="'+row.${listPage.exColumn.javaName}+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.exColumn.javaName}"  name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.exColumn.javaName}"  onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')" placeholder="请选择${listPage.columnComment}" readonly >';
        html += '<div class="input-group-btn">';
        html += '<div class="btn btn-primary btn-sm" onclick="open${listPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\', \'${childColumn.tableBO.simpleName}BOList\',document.getElementById(\'${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.exColumn.javaName}\'),'+index+')">';
        html += '<svg class="icon" aria-hidden="true">';
        html += '<use xmlns:xlink="http://www.w3.org/1999/xlink"  xlink:href="#icon-sousuo"></use>';
        html += '</svg>';
        html += '</div>';
        html += '<div class="btn btn-primary btn-sm" onclick="clear${listPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\', \'${childColumn.tableBO.simpleName}BOList\',document.getElementById(\'${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.exColumn.javaName}\'),'+index+')"  >';
        html += '<svg class="icon" aria-hidden="true">';
        html += ' <use xmlns:xlink="http://www.w3.org/1999/xlink"	xlink:href="#icon-close"></use>';
        html += '</svg>';
        html += '</div>';
        html += '</div>';
        html += '</div>';

        return html;
        <#else >

        <#if listPage.element == 'text'  || listPage.element == 'textarea'  >
        var html = '<input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
            'placeholder="请输入${listPage.columnComment}" autocomplete="off" '+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
            'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}"'+
            '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';

        <#elseif listPage.element == 'digits' >
        var html = '<input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm number  <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
            'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
            'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}" step="1"'+
            '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';
        <#elseif listPage.element == 'number' >
        var html = '<input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm number fd-decimal2 <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
        'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
        'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}" step="0.01"'+
        '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';
        <#elseif listPage.element == 'date' ||  listPage.element == 'timestamp' >
        var html = '<input type="text" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm Wdate <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
        'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
        'onclick="WdatePicker({dateFmt: \'yyyy-MM-dd\', el: \'${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}\'})"'+
        'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}" readonly   />';
        <#elseif listPage.element == 'email' >
        var html = '<input type="email" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
        'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
        'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}"'+
        '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';
        <#elseif listPage.element == 'url' >
        var html = '<input type="url" <#if listPage.required?exists && listPage.required == '1'>required="required"</#if> class="form-control input-sm <#if listPage.required?exists && listPage.required == '1'>required</#if>"'+
        'placeholder="请输入${listPage.columnComment}" autocomplete="off"'+ ' onblur="costTableRows(\'tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}\' , \'${childColumn.tableBO.simpleName}BOList\' , '+index+')"'+
        'value="'+val+'" id="${childColumn.tableBO.simpleName}BOList_'+index+'_${listPage.javaName}" name="${childColumn.tableBO.simpleName}BOList['+index+'].${listPage.javaName}"'+
        '<#if listPage.max?exists>max="${listPage.max}" </#if> <#if listPage.min?exists>min="${listPage.min}" </#if> <#if listPage.minlength?exists>minlength="${listPage.minlength}" </#if> <#if listPage.maxlength?exists>maxlength="${listPage.maxlength}" </#if> />';

        <#else >
        </#if>
        return html;

        </#if>
    }
    </#if>
    </#list>
    </#if>
    function markFmt${childColumn.tableBO.simpleName?cap_first}(val, r,index){
        var html =	'<div class="grid-column-option">';
        html+=	'<a href="javascript: doDel${childColumn.tableBO.simpleName?cap_first}('+ index + ');" title="删除"><svg class="icon" aria-hidden="true"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-delete"></use></svg></a>';
        html+=	'</div>';
        return html;
    }


    function doDel${childColumn.tableBO.simpleName?cap_first}(index){
        $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("deleteRow" , index);
        var rows = $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("getRows");
        $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("loadData",rows);
    }

    function doAdd${childColumn.tableBO.simpleName?cap_first}() {
        var rows = $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("getRows");
        rows.push({ <#if (childColumn.tableBO.tablePO.showPages?exists && childColumn.tableBO.tablePO.showPages?size >0)><#list childColumn.tableBO.tablePO.showPages as listPage>${listPage.javaName} : "" <#if listPage_has_next>,</#if></#list></#if> });
        $('#tableData-${childColumn.tableBO.fullUpperResourceName?uncap_first}').datagrid("loadData",rows);
    }
    </#if>
    </#list>

    </#if>

</script>


<bms:contentFooter />