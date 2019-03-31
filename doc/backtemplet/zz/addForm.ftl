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


                <form id="editForm" action="" method="post">
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

                                    <th width="15%">${being.columnComment}<#if being.required?exists && being.required == '1'><font color="red">*</font></#if></th>

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
                                                              name="${being.javaName} " placeholder="请输入${being.columnComment}，${being.maxlength}字以内" maxlength="${being.maxlength}" rows="4">${r"${"} m.${being.javaName} ${r"$}"}</textarea>
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

                                            <div class="input-group">

                                                <input type="text" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm <#if being.required?exists && being.required == '1'>required</#if>"
                                                       placeholder="请输入${being.columnComment}" autocomplete="off"
                                                       onclick="WdatePicker({dateFmt: 'yyyy-MM-dd', el: '${being.javaName}'})
                                                       value="${r"${"} m.${being.javaName} ${r"}"}" id="${being.javaName}" name="${being.javaName}" readonly   />

                                                <div class="input-group-btn">
                                                    <button type="button" class="btn btn-primary btn-sm" onclick="document.getElementById('${being.javaName}').click()">
                                                        <svg class="icon" aria-hidden="true">
                                                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-rili"></use>
                                                        </svg>
                                                    </button>
                                                    <button type="button" class="btn btn-primary btn-sm" onclick="clearTime(${being.javaName?cap_first});">
                                                        <svg class="icon" aria-hidden="true">
                                                            <use  xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-close"></use>
                                                        </svg>
                                                    </button>
                                                </div>

                                            </div>

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
                                                <select id="${being.javaName}"  name="${being.javaName}" <#if being.required?exists && being.required == '1'>required="required"</#if> >
                                                <option value="" ></option>
                                                <c:forEach items=${r"${"} ${being.columnConfig.dictType} ${r"}"} var="dict">
                                                    <option value="${r"${"} dict.value ${r"}"}">${r"${"} dict.name}  ${r"}"}</option>
                                                </c:forEach>
                                                </select>
                                            <#elseif being.element == 'openwin' >
                                            <#else >
                                            </#if>

                                        <#elseif being?exists && being.exColumn?exists>
                                            <#if being.element == 'openwin' >
                                                <input type="hidden" name="${being.exColumn.originalJavaName}" id="${being.exColumn.originalJavaName}" value="${r"${"} m.${being.exColumn.originalJavaName} ${r"}"}">
                                                <input type="text" name="${being.javaName}" id="${being.javaName}" value="${r"${"} m.${being.javaName} ${r"}"}" <#if being.required?exists && being.required == '1'>required="required"</#if> class="form-control input-sm ${being.javaName} " placeholder="请选择${being.columnComment}" style="width: 150px; cursor: pointer;" readonly="readonly">

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


                                            </#if>

                                        </#if>

                                    </td>

                                    <#if being_has_next>

                                    <#assign nextPage=showColumnPages[being_index+1]>

                                    <th width="15%">${nextPage.columnComment}<#if nextPage.required?exists && nextPage.required == '1'><font color="red">*</font></#if></th>

                                    <td>





                                    <#if nextPage?exists && nextPage.columnConfig?exists>
                                        <#if nextPage.element == 'text'  >
                                            <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                   placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                   value="${r"${"} m.${nextPage.javaName} ${r"}"}" id="${nextPage.javaName}" name="${nextPage.javaName}"
                                                    <#if nextPage.max?exists>max="${nextPage.max}" </#if> <#if nextPage.min?exists>min="${nextPage.min}" </#if> <#if nextPage.minlength?exists>minlength="${nextPage.minlength}" </#if> <#if nextPage.maxlength?exists>maxlength="${nextPage.maxlength}" </#if> />

                                        <#elseif nextPage.element == 'textarea' >

                                            <div class="info-detail">
                                                <textarea <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if> "
                                                          name="${nextPage.javaName}" placeholder="请输入${nextPage.columnComment}，${nextPage.maxlength}字以内" maxlength="${nextPage.maxlength}" rows="4">${r"${"} m.${nextPage.javaName} ${r"}"}</textarea>
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

                                            <div class="input-group">



                                                <input type="text" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm <#if nextPage.required?exists && nextPage.required == '1'>required</#if>"
                                                       placeholder="请输入${nextPage.columnComment}" autocomplete="off"
                                                       onclick="WdatePicker({dateFmt: 'yyyy-MM-dd', el: '${nextPage.javaName}'})
                                                               value="${r"${"} m.${nextPage.javaName} ${r"}"}" id="${nextPage.javaName}" name="${nextPage.javaName}" readonly   />

                                                <div class="input-group-btn">
                                                    <button type="button" class="btn btn-primary btn-sm" onclick="document.getElementById('${nextPage.javaName}').click()">
                                                        <svg class="icon" aria-hidden="true">
                                                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-rili"></use>
                                                        </svg>
                                                    </button>
                                                    <button type="button" class="btn btn-primary btn-sm" onclick="clearTime(${nextPage.javaName?cap_first});">
                                                        <svg class="icon" aria-hidden="true">
                                                            <use  xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-close"></use>
                                                        </svg>
                                                    </button>
                                                </div>

                                            </div>

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
                                            <select id="${nextPage.javaName}"  name="${nextPage.javaName}" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> >
                                                <option value="" ></option>
                                                <c:forEach items=${r"${"} ${nextPage.columnConfig.dictType} ${r"}"} var="dict">
                                                    <option value="${r"${"} dict.value ${r"}"}">${dict.name}</option>
                                                </c:forEach>
                                            </select>
                                        <#elseif nextPage.element == 'openwin' >
                                        <#else >
                                        </#if>

                                    <#elseif nextPage?exists && nextPage.exColumn?exists>
                                        <#if nextPage.element == 'openwin' >

                                        <div class="input-group">
                                            <input type="hidden" name="${nextPage.exColumn.originalJavaName}" id="${nextPage.exColumn.originalJavaName}" value="${r"${"} m.${nextPage.exColumn.originalJavaName} ${r"}"}" >
                                            <input type="text" name="${nextPage.javaName}" id="${nextPage.javaName}" value="${r"${"} m.${nextPage.javaName} ${r"}"}" <#if nextPage.required?exists && nextPage.required == '1'>required="required"</#if> class="form-control input-sm ${nextPage.javaName} " placeholder="请选择${nextPage.columnComment}" style="width: 150px; cursor: pointer;" readonly="readonly">

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

                                        </#if>
                                    <#else >
                                        出现错误
                                    </#if>


                                    </td>
                                    </#if>


                                </tr>
                            </#if>

                        </#list>




                    </table>
                </form>
            </div>

            <div style="margin-top:10px;position:absolute;" align="center" id="toolBar">



                <shiro:hasPermission name="system.user:add">
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


    var tableid = "tableData-${r"${"} tableId ${r"$}"}";


</script>





<bms:contentJS />


<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/form.js"></script>


<#list table.fkTables as fkTable>
    <script src="${r"${"} staticUrl ${r"}"}/statics2/business-js${fkTable.fullResourceName}/search.js"></script>
</#list>



<script language="JavaScript">


    $(function() {

        <#list showColumnPages as being>
        <#if being?exists && being.exColumn?exists>
        <#if being.element == 'openwin' >
        //选择${being.columnComment}
        ${r"$"}(".${being.javaName}").Open${being.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}SelectWin({
            title: "${being.columnComment}",
            selectType: "<#if being.exColumn.originalColumn.fkTableConfig.isTree == '1'>t<#else >d</#if>1",
            callId: "${being.exColumn.originalJavaName}",
            callName: "${being.javaName}",
            clearId: "clear${being.exColumn.originalJavaName?cap_first}"
        });
        </#if>
        </#if>
        </#list>

    });


</script>

<bms:contentFooter />