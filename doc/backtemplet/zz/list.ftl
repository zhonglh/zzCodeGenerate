<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<bms:contentHeader title="zz后台管理系统" />



<div region='north'>
    <div class="navigation">


        <span class="words"><a>${r"${"} breadcrumb ${r"}"}</a></span>


    </div>
    <div id="content-sec" style="padding: 10px 10px 0 10px;">
        <!-- 筛选条件表单开始 -->
        <form id="searchForm" onsubmit="return false" >

        <#if querys?exists >


            <#if project.queryMode == 'toolbar' >
            <div id='toolbar' style='height: 40px;     border-bottom: 2px solid #0896ba; '>
                <div class="form-inline" role="form">

                <#list querys as being>
                <div class="form-group" >
                    <#if being.columnPage?exists && being.columnPage.columnConfig?exists>
                        <#if being.columnPage.element == 'text' || being.columnPage.element == 'textarea' >
                            <input type="text"  class="form-control input-sm" style='width: 200px;' id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' onkeydown='enterKeySearch(event, search);'>
                        <#elseif being.columnPage.element == 'digits' >
                            <input type="text" style='width: 200px;' <#if being.columnPage.max?exists>max="${being.columnPage.max}"</#if> step="1" class="form-control input-sm number  " id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>" name="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>"  placeholder="${being.queryPlaceholder}">
                        <#elseif being.columnPage.element == 'number' >
                            <input type="text" style='width: 200px;' <#if being.columnPage.max?exists>max="${being.columnPage.max}"</#if> step="1" class="form-control input-sm number  " id="${being.queryFieldName}" name="${being.queryFieldName}"  placeholder="${being.queryPlaceholder}">
                        <#elseif being.columnPage.element == 'date' >
                            <input  type="text" class="form-control input-sm" style='width: 100px;' onclick="WdatePicker()" readonly  id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' onchange="search();">
                        <#elseif being.columnPage.element == 'timestamp' >
                            <input type="text" class="form-control input-sm" style='width: 100px;' onclick="WdatePicker()" readonly  id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' onchange="search();">
                        <#elseif being.columnPage.element == 'email' >
                            <input type="text" class="form-control input-sm" style='width: 100px;' readonly  id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' onchange="search();">
                        <#elseif being.columnPage.element == 'url' >
                            <input type="text" class="form-control input-sm" style='width: 100px;' readonly  id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' onchange="search();">
                        <#elseif being.columnPage.element == 'radio' || being.columnPage.element == 'checkbox' || being.columnPage.element == 'select' >
                            <select id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?size >0>_${being.queryRelation}</#if>'   class="form-control input-sm" onChange='search();'  >
                                <option value="" >'${being.queryPlaceholder}'</option>
                                <c:forEach items=${r"${"} yes_no_dicts ${r"}"} var="dict">
                                    <option value="${r"${"} dict.value ${r"}"}">${dict.name}</option>
                                </c:forEach>
                            </select>
                        <#elseif being.columnPage.element == 'openwin' >
                        <#else >
                        </#if>

                    <#elseif being.columnPage?exists && being.columnPage.exColumn?exists>
                        <#if being.columnPage.element == 'openwin' >
                        <input name="${being.columnPage.exColumn.originalJavaName}" id="${being.columnPage.exColumn.originalJavaName}">
                        <input name="${being.queryFieldName}" id="${being.queryFieldName}" class="form-control input-sm" placeholder="${being.queryPlaceholder}" style="width: 150px; cursor: pointer;" readonly="readonly">
                        <div class="input-group-addon" title="清除" id="clear${being.queryFieldName}" ><i class="fa fa-remove"></i></div>
                        </#if>

                    </#if>

                </div>
                </#list>


                    <div class="form-group">
                        <button type="submit" class="btn btn-success btn-sm" onclick='search();'><i class="fa fa-search"></i>&nbsp;查询</button>
                    </div>

                </div>
            </div>
            </#if>


        </#if>




        </form>



        <#if topOperations?exists>

        <div class="btn-bar" style="margin-left: -10px;">

        <#list topOperations as operation>
        <#if operation.position?exists && (operation.position == 'top' || operation.position == 'all') && (operation.operationResource!='update')>

            <#if operation.operationResource != 'importExcel' && operation.operationResource != 'exportExcel'>
            <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                <button type="button" class="btn btn-primary btn-sm" onclick="<#if operation.operationBO.opMode=='1'>to<#else >do</#if>${operation.operationResource?uncap_first}()">
                    <svg class="icon" aria-hidden="true">
                        <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="${operation.icons!}"></use>
                    </svg>
                    <span>${operation.operationName!} </span>
                </button>
            </shiro:hasPermission>
            <#elseif operation.operationResource == 'importExcel'>

                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                    <div type="button" id="importExcel" class="btn btn-primary btn-sm" >
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-daoru"></use>
                        </svg>
                        <span>${operation.operationName!'Excel导入'}</span>
                    </div>
                </shiro:hasPermission>
            <#elseif operation.operationResource == 'exportExcel'>

                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                <div class="btn-group">
                    <button type="button" id="exportExcel" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-daochu"></use>
                        </svg>
                    ${operation.operationName!'Excel导出'} <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">

                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/hssf/download" class="export">
                                <svg class="icon" aria-hidden="true">
                                    <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-download"></use>
                                </svg>下载模板(Excel2003)
                            </a>
                        </li>

                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/sxssf/download" class="export">
                                <svg class="icon" aria-hidden="true">
                                    <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-download"></use>
                                </svg>下载模板(Excel2007)
                            </a>
                        </li>

                        <li role="separator" class="divider"></li>

                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/cvs/export" class="export" >
                                <svg class="icon" aria-hidden="true">
                                    <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-daochu"></use>
                                </svg>导出CVS
                            </a>
                        </li>
                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/hssf/export" class="export" >
                                <svg class="icon" aria-hidden="true">
                                    <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-daochu"></use>
                                </svg>导出Excel2003
                            </a>
                        </li>

                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/sxssf/export" class="export" >
                                <svg class="icon" aria-hidden="true">
                                    <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-daochu"></use>
                                </svg>导出Excel2007
                            </a>
                        </li>
                    </ul>
                </div>
                </shiro:hasPermission>
            </#if>

        </#if>
        </#list>

        </div>

        </#if>


    </div>

</div>

<div region='center' style="padding: 0px 10px 0 10px;">
    <table id='tableData-${r"${"} tableId ${r"}"}' class='easyui-datagrid' method='post' fit='true' pagination='true' fitColumns="true"
           border='true' sortName="id" sortOrder="desc" style="width: 100%;">
        <thead>
        <tr>
            <th field="ck" checkbox="true"></th>

            <#list listColumnPages as listPage>
            <th field='${listPage.javaName}' <#if listPage.isNumber >align="right"<#elseif listPage.isDate >align="center"<#else >align="left"</#if> width="1" <#if listPage.isNumber >sortable='true'<#elseif listPage.isDate >sortable='true'<#else >sortable='false'</#if> <#if listPage.columnConfig?exists && listPage.columnConfig.isTableBusinessName>formatter='titleFmt'<#elseif listPage.isDate>formatter='dateFmt'</#if> >${listPage.columnComment}</th>
            </#list>

            <#if rightOperations?exists>
            <th field='makes' align="center" formatter='makesFmt'>操作</th>
            </#if>


        </tr>
        </thead>
    </table>
</div>




<script>
    var tableid = "tableData-${r"${"} tableId ${r"}"}";
</script>



<bms:contentJS />

<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/list.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/common-import-excel.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/business-js/system/user.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/business-js/system/dep.js"></script>

<script language="JavaScript">


    $(function() {

    <#if querys?exists >
        <#list querys as being>
        <#if being.columnPage.element == 'openwin' >

            //${being.queryTitle}
            $("#${being.queryFieldName}").Ope${being.columnPage.exColumn.fkColumn.tableBO.fullUpperResourceName}SelectWin({
                title: "${being.queryTitle}",
                selectType: "<#if being.columnPage.exColumn.fkColumn.tableBO.isTree == '1'>t<#else >d</#if>1",
                callId: "${being.columnPage.exColumn.originalJavaName}",
                callName: "${being.queryFieldName}",
                clearId: "clear${being.queryFieldName}"
            });

        </#if>
        </#list>
    </#if>

    });





</script>

<bms:contentFooter />

