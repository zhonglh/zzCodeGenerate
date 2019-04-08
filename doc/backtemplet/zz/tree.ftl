<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<bms:contentHeader title="${project.projectName!}" />



<div region='north'>
    <div class="navigation">


        <span class="words"><a>${r"${"} breadcrumb ${r"}"}</a></span>


    </div>
    <div id="content-sec" style="padding: 10px 10px 0 10px;">
        <!-- 筛选条件表单开始 -->
        <form id="searchForm" onsubmit="return false" >


        </form>



        <#if topOperations?exists>

        <div class="btn-bar" style="margin-left: -10px;">

        <#list topOperations as operation>
        <#if (operation.operationResource!='update')>

            <#if operation.operationResource == 'add'>

                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                    <button type="button" class="btn btn-primary btn-sm" onclick="<#if operation.operationBO.opMode=='1'>to<#else >do</#if>${operation.operationResource?cap_first}()">
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-plus"></use>
                        </svg>
                        <span>${operation.operationName!} </span>
                    </button>
                </shiro:hasPermission>

            <#elseif operation.operationResource == 'delete'>

                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                    <button type="button" class="btn btn-primary btn-sm" onclick="<#if operation.operationBO.opMode=='1'>to<#else >do</#if>${operation.operationResource?cap_first}()">
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#icon-delete"></use>
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

            <#else>

                <shiro:hasPermission name="${table.fullResource}:${operation.operationResource}">
                    <button type="button" class="btn btn-primary btn-sm" onclick="<#if operation.operationBO.opMode=='1'>to<#else >do</#if>${operation.operationResource?cap_first}()">
                        <svg class="icon" aria-hidden="true">
                            <use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="${operation.icons!}"></use>
                        </svg>
                        <span>${operation.operationName!} </span>
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
    <table id='tableData-${r"${"} tableId ${r"}"}' class='easyui-treegrid' method='post' fit='true' pagination='true' fitColumns="true"
           border='true' sortName="id" sortOrder="desc" style="width: 100%;">
        <thead>
        <tr>
            <#if listColumnPages?exists>
            <#list listColumnPages as listPage>
            <th field='${listPage.javaName}' <#if listPage.numberColumn=='1' >align="right"<#elseif listPage.dateColumn=='1' >align="center"<#else >align="left"</#if> width="1" <#if listPage.numberColumn=='1' >sortable='true'<#elseif listPage.dateColumn=='1'  >sortable='true'<#else >sortable='false'</#if> <#if (listPage.columnConfig?exists && listPage.columnConfig.tableBusinessName?exists && listPage.columnConfig.tableBusinessName == '1' ) || (listPage_index == 0)>formatter='<#if (table.notPageChildTables?exists && table.notPageChildTables?size >0 )>titleAllFmt<#else >titleFmt</#if>'<#elseif listPage.dateColumn=='1' >formatter='dateFmt'</#if> >${listPage.columnComment}</th>
            </#list>
            </#if>



        </tr>
        </thead>
    </table>
</div>




<script>
    var tableid = "tableData-${r"${"} tableId ${r"}"}";
    var tree_field = "${table.businessNameCamelCase!}";
    var id_field = "id";
</script>



<bms:contentJS />

<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/listCommon.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/tree.js"></script>

<shiro:hasPermission name="${table.fullResource}:importExcel">
<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/common-import-excel.js"></script>
</shiro:hasPermission>



<script language="JavaScript">




</script>

<bms:contentFooter />

