<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<bms:contentHeader  />

<div region='north'>


    <c:if test="${r"${"} inAllPage == null || inAllPage != '1' ${r"}"}">
    <div class="navigation">
        <span class="words"><a>${r"${"} breadcrumb ${r"}"}</a></span>
    </div>
    </c:if>

    <div id="content-sec" style="padding: 10px 10px 0 10px;">
        <!-- 筛选条件表单开始 -->
        <form id="searchForm" onsubmit="return false" >

        <#if querys?exists >
            <#if project.queryMode == 'toolbar' >
            <div id='toolbar' style='height: 40px;     border-bottom: 2px solid #0896ba; '>
                <div class="form-inline" role="form">

                <#list querys as being>

                <#if being.columnPage?exists && being.columnPage.exColumn?exists && being.columnPage.element == 'openwin'>
                    <div class="input-group"  <#if being_index == 0> style='margin-left: -15px;'</#if>  >
                <#else >
                    <div class="form-group"   <#if being_index == 0> style='margin-left: -15px;'</#if>  >
                </#if>



                    <#if being.columnPage?exists && being.columnPage.columnConfig?exists>
                        <#if being.columnPage.element == 'text' || being.columnPage.element == 'textarea' >
                            <input type="text"  class="form-control input-sm" style='width: 200px;' id="${being.queryFieldName}<#if (being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq') >_${being.queryRelation?upper_case}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq' >_${being.queryRelation?upper_case}</#if>'  placeholder='${being.queryPlaceholder}' onkeydown='enterKeySearch(event, search);'>
                        <#elseif being.columnPage.element == 'digits' >
                            <input type="text" style='width: 200px;' <#if being.columnPage.max?exists>max="${being.columnPage.max}"</#if> step="1" class="form-control input-sm number  " id="${being.queryFieldName}<#if (being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq') >_${being.queryRelation?upper_case}</#if>" name="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq' >_${being.queryRelation?upper_case}</#if>"  placeholder="${being.queryPlaceholder}" onkeydown='enterKeySearch(event, search);'>
                        <#elseif being.columnPage.element == 'number' >
                            <input type="text" style='width: 200px;' <#if being.columnPage.max?exists>max="${being.columnPage.max}"</#if> step="1" class="form-control input-sm number  " id="${being.queryFieldName}<#if (being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq') >_${being.queryRelation?upper_case}</#if>" name="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq' >_${being.queryRelation?upper_case}</#if>"  placeholder="${being.queryPlaceholder}" onkeydown='enterKeySearch(event, search);'>
                        <#elseif being.columnPage.element == 'date' >
                            <input  type="text" class="form-control input-sm" style='width: 100px;' onclick="WdatePicker()" readonly  id="${being.queryFieldName}<#if (being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq') >_${being.queryRelation?upper_case}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq' >_${being.queryRelation?upper_case}</#if>'  placeholder='${being.queryPlaceholder}' onchange="search();">
                        <#elseif being.columnPage.element == 'timestamp' >
                            <input type="text" class="form-control input-sm" style='width: 100px;' onclick="WdatePicker()" readonly  id="${being.queryFieldName}<#if (being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq') >_${being.queryRelation?upper_case}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq' >_${being.queryRelation?upper_case}</#if>'  placeholder='${being.queryPlaceholder}' onchange="search();">
                        <#elseif being.columnPage.element == 'email' >
                            <input type="text" class="form-control input-sm" style='width: 100px;' readonly  id="${being.queryFieldName}<#if (being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq') >_${being.queryRelation?upper_case}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq' >_${being.queryRelation?upper_case}</#if>'  placeholder='${being.queryPlaceholder}' onkeydown='enterKeySearch(event, search);'>
                        <#elseif being.columnPage.element == 'url' >
                            <input type="text" class="form-control input-sm" style='width: 100px;' readonly  id="${being.queryFieldName}<#if (being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq') >_${being.queryRelation?upper_case}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq' >_${being.queryRelation?upper_case}</#if>'  placeholder='${being.queryPlaceholder}' onkeydown='enterKeySearch(event, search);'>
                        <#elseif being.columnPage.element == 'radio' || being.columnPage.element == 'checkbox' || being.columnPage.element == 'select' >
                            <select id="${being.queryFieldName}<#if (being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq') >_${being.queryRelation?upper_case}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length gt 0 && being.queryRelation != 'eq' >_${being.queryRelation?upper_case}</#if>'   class="form-control input-sm" onChange='search();'  >
                                <option value="" >${being.queryPlaceholder}</option>
                                <c:forEach items="${r"${"} ${being.columnPage.columnConfig.columnName}_dicts ${r"}"}" var="dict">
                                    <option value="${r"${"} dict.dictVal ${r"}"}">${r"${"} dict.dictName ${r"}"}</option>
                                </c:forEach>
                            </select>
                        <#elseif being.columnPage.element == 'openwin' >
                        <#else >
                        </#if>

                    <#elseif being.columnPage?exists && being.columnPage.exColumn?exists>
                        <#if being.columnPage.element == 'openwin' >
                            <c:if test="${r"${"} fn.indexOf(queryString,'${being.columnPage.exColumn.originalJavaName}') ${r"}"}">
                                <input type="text" class="form-control input-sm" name="${being.columnPage.javaName}" id="${being.columnPage.javaName}" value="${r"${"} m.${being.columnPage.javaName} ${r"}"}" readonly>
                            </c:if>

                            <c:if test="${r"${"} !fn.indexOf(queryString,'${being.columnPage.exColumn.originalJavaName}') ${r"}"}">
                                <input type="hidden" name="${being.columnPage.exColumn.originalJavaName}" id="${being.columnPage.exColumn.originalJavaName}">
                                <input type="text" name="${being.queryFieldName}" id="${being.queryFieldName}" class="form-control input-sm ${being.queryFieldName}" placeholder="${being.queryPlaceholder}" style="width: 150px; cursor: pointer;" readonly="readonly">

                                <div class="input-group-btn">
                                    <button type="button" class="btn btn-primary btn-sm ${being.queryFieldName}">
                                        <i class="fa fa-search-plus"></i>
                                    </button>
                                    <button type="button" id="clear${being.queryFieldName}" class="btn btn-primary btn-sm">
                                        <i class="fa fa-close"></i>
                                    </button>
                                </div>

                            </c:if>
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
        <#if (operation.operationResource!='update')>
            <#if operation.operationResource == 'add'>
                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                    <button type="button" class="btn btn-primary btn-sm" onclick="<#if operation.operationBO.opMode=='1'>to<#else >do</#if>${operation.operationResource?cap_first}()">
                       <i class="fa fa-plus"></i>
                        <span>${operation.operationName!} </span>
                    </button>
                </shiro:hasPermission>
            <#elseif operation.operationResource == 'detail'>
            <#elseif operation.operationResource == 'delete'>
                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                    <button type="button" class="btn btn-primary btn-sm" onclick="<#if operation.operationBO.opMode=='1'>to<#else >do</#if>${operation.operationResource?cap_first}()">
                        <i class="fa fa-trash"></i>
                        <span>${operation.operationName!} </span>
                    </button>
                </shiro:hasPermission>

            <#elseif operation.operationResource == 'importExcel'>

                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                    <div type="button" id="importExcel" class="btn btn-primary btn-sm" >
                        <i class="fa fa-upload"></i>
                        <span>${operation.operationName!'Excel导入'}</span>
                    </div>

                <div class="btn-group">
                    <button type="button" id="exportTemplet" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-download"></i>
                        模板 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">

                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/hssf/download?${r"${"} queryString }" class="export">
                                <i class="fa fa-download"></i>下载模板(Excel2003)
                            </a>
                        </li>

                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/sxssf/download?${r"${"} queryString }" class="export">
                                <i class="fa fa-download"></i>下载模板(Excel2007)
                            </a>
                        </li>
                    </ul>
                </div>

                </shiro:hasPermission>

            <#elseif operation.operationResource == 'exportExcel'>

                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                <div class="btn-group">
                    <button type="button" id="exportExcel" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-download"></i>
                    ${operation.operationName!'Excel导出'} <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">

                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/csv/export?${r"${"} queryString }" class="export" >
                                <i class="fa fa-download"></i>导出CSV
                            </a>
                        </li>
                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/hssf/export?${r"${"} queryString }" class="export" >
                                <i class="fa fa-download"></i>导出Excel2003
                            </a>
                        </li>

                        <li>
                            <a href="${r"${"} ctx ${r"}"}/${r"${"} currParentUrl ${r"}"}/sxssf/export?${r"${"} queryString }" class="export" >
                                <i class="fa fa-download"></i>导出Excel2007
                            </a>
                        </li>
                    </ul>
                </div>
                </shiro:hasPermission>
            <#else>
                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                    <button type="button" class="btn btn-primary btn-sm" onclick="<#if operation.operationBO.opMode=='1'>to<#else >do</#if>${operation.operationResource?cap_first}()">
                        <i class="${operation.icons!}"></i><span>${operation.operationName!} </span>
                    </button>
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

            <#if listColumnPages?exists>
            <#list listColumnPages as listPage>
            <th field='${listPage.javaName}' <#if listPage.numberColumn=='1' >align="right"<#elseif listPage.dateColumn=='1' >align="center"<#else >align="left"</#if> width="1" <#if listPage.numberColumn=='1' >sortable='false'<#elseif listPage.dateColumn=='1'  >sortable='false'<#else >sortable='false'</#if> <#if (listPage.columnConfig?exists && listPage.columnConfig.tableBusinessName?exists && listPage.columnConfig.tableBusinessName == '1') || (listPage_index == 0)>formatter='<#if (table.notPageChildTables?exists && table.notPageChildTables?size >0 )>titleAllFmt<#else >titleFmt</#if>'<#elseif listPage.dateColumn=='1' >formatter='dateFmt'</#if> >${listPage.columnComment}</th>
            </#list>
            </#if>

            <#if rightOperations?exists && rightOperations?size != 0 >
            <th field='makes' align="center" formatter='operationsFmt'>操作</th>
            </#if>
        </tr>
        </thead>
    </table>
</div>

<bms:openPanel />

<script>
    var tableid = "tableData-${r"${"} tableId ${r"}"}";

    var inAllPage = "${r"${"} inAllPage ${r"}"}";
    var queryString = "${r"${"} queryString ${r"}"}";
    var listUrl = "";
</script>

<bms:contentJS />

<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/listCommon.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/list.js"></script>

<shiro:hasPermission name="${table.fullResource}:importExcel">
<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/common-import-excel.js"></script>
</shiro:hasPermission>

<#list table.fkTables as fkTable>
<script src="${r"${"} staticUrl ${r"}"}/statics2/business-js${fkTable.fullResourceName}/search.js"></script>
</#list>

<script language="JavaScript">


    $(function() {

    <#if querys?exists >
        <#list querys as being>
        <#if being.columnPage.element == 'openwin' >

            //${being.queryTitle}
            $(".${being.queryFieldName}").Open${being.columnPage.exColumn.originalColumn.fkTableConfig.fullUpperResourceName}SelectWin({
                title: "${being.queryTitle}",
                selectType: "<#if being.columnPage.exColumn.originalColumn.fkTableConfig.isTree == '1'>t<#else >d</#if>1",
                callId: "${being.columnPage.exColumn.originalJavaName}",
                callName: "${being.queryFieldName}",
                clearId: "clear${being.queryFieldName}"
            });

        </#if>
        </#list>
    </#if>

    });



    <#if rightOperations?exists && rightOperations?size != 0 >
    /**
     * 操作
     * @param val
     * @param r
     * @param index
     * @returns {string}
     */
    function operationsFmt (val, r, index)
    {
        // 操作栏为图标
        var html = '';
        html += '<div class="grid-column-option">';



        <#list rightOperations as opertaion>
        <#if opertaion.operationResource == 'delete'>
        //删除按钮
        html += '<a href="javascript:;"'
                + '" name="'
                + r.${table.businessNameCamelCase!}
                + '" id="'
                + r.id
                + '" onclick="deleteOne(this);" title="${opertaion.operationName}">' +
                '<i class="fa fa-trash"></i></a>';

        <#elseif opertaion.operationResource == 'add' || opertaion.operationResource == 'exportExcel' || opertaion.operationResource == 'importExcel'>
        <#else>

            html += '<a href="javascript:;"'
                    + '" name="'
                    + r.${table.businessNameCamelCase!}
                    + '" id="'
                    + r.id
                    + '" onclick="${opertaion.operationResource}One(this);" title="${opertaion.operationName}">' +
                    '<i class="${opertaion.icons}"></i></a>';

        </#if>
        </#list>

        html += '</div>';
        return html;
    }
    </#if>


</script>

<bms:contentFooter />

