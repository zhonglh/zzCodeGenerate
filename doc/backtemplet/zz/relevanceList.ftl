<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/common/taglibs.jspf" %>
<bms:contentHeader title="${project.projectName!}" />


<#assign fkColumn1 = columns[1]>
<#assign fkColumn2 = columns[2]>

<div style="padding: 0 10px">
    <div class="row">

        <div class="col-xs-12 col-lg-12 col-md-12" style="padding-left: 0;padding-right: 0">
            <div class="block-each block-each-another">
                <div class="block-tit">
                    &nbsp;<i class="fa fa-th-list"></i>&nbsp;${table.tableComment}
                </div>





                <form id="from1" action="" >
                    <table id='tableData-${r"${"} tableId ${r"}"}'  class='easyui-datagrid' method='post' fit='false' pagination='false' fitColumns="true" border='true' singleSelect="true">
                        <thead>
                        <tr>
                            <th field="id" hidden="true" ></th>
                            <c:if test="${r"${"} fn:indexOf(allQueryString,'&${fkColumn1.javaName}=')<0 ${r"}"}">
                                <#list exColumns as exColumn>
                                <#if exColumn.originalJavaName == fkColumn1.javaName>
                                <th field='${exColumn.javaName}' align="left" width="1" sortable='false' >${exColumn.columnTitle}</th>
                                </#if>
                                </#list>
                                <th field='${fkColumn1.javaName}' align="left" width="0" sortable='false'  hidden="true">${fkColumn1.columnComment}</th>
                            </c:if>

                            <c:if test="${r"${"} fn:indexOf(allQueryString,'&${fkColumn2.javaName}=')<0 ${r"}"}">
                                <#list exColumns as exColumn>
                                    <#if exColumn.originalJavaName == fkColumn2.javaName>
                                        <th field='${exColumn.javaName}' align="left" width="1" sortable='false' >${exColumn.columnTitle}</th>
                                    </#if>
                                </#list>
                                <th field='${fkColumn2.javaName}' align="left" width="0" sortable='false'  hidden="true">${fkColumn2.columnComment}</th>
                            </c:if>

                            <th hidden="true" field="option" align="left" formatter="markFmt">操作</th>

                        </tr>
                        </thead>
                    </table>


                    <div style="text-align: center; margin-top: 15px" class="toolBar">

                        <c:if test="${r"${"} fn:indexOf(allQueryString,'&${fkColumn1.javaName}=')>=0 || fn:indexOf(allQueryString,'&${fkColumn2.javaName}=')>=0 ${r"}"}">
                            <c:if test="${r"${"} fn:indexOf(allQueryString,'&${fkColumn1.javaName}=')>=0 ${r"}"}">
                                <button type="button" id="addBtn" class="btn btn-primary btn-sm hide" onclick="clk${fkColumn2.fkTableConfig.fullUpperResourceName}()" >
                                   <i class="fa fa-plus"></i>
                                    <span>添 加</span>
                                </button>
                            </c:if>
                            <c:if test="${r"${"} fn:indexOf(allQueryString,'&${fkColumn2.javaName}=')>=0 ${r"}"}">
                                <button type="button" id="addBtn" class="btn btn-primary btn-sm hide" onclick="clk${fkColumn1.fkTableConfig.fullUpperResourceName}()" >
                                   <i class="fa fa-plus"></i>
                                    <span>添 加</span>
                                </button>
                            </c:if>
                        </c:if>


                        <input class="${fkColumn1.javaName}s"  class="${fkColumn1.javaName}s" type="hidden"/>
                        <input class="${fkColumn1.fkTableConfig.businessNameCamelCase!}s"  class="${fkColumn1.fkTableConfig.businessNameCamelCase!}s" type="hidden"/>
                        <input class="${fkColumn2.javaName}s"  class="${fkColumn2.javaName}s" type="hidden"/>
                        <input class="${fkColumn2.fkTableConfig.businessNameCamelCase!}s"  class="${fkColumn2.fkTableConfig.businessNameCamelCase!}s" type="hidden"/>

                    </div>

                </form>

            </div>



            <div style="margin-top:10px;position:absolute;" align="center" class="toolBar">

                <button type="button" class="btn btn-primary btn-sm hide-area" onclick="openEdit()">
                    <i class="fa fa-edit"></i>
                    <span>编 辑</span>
                </button>

                <button type="button" class="btn  btn-warning btn-sm hide-area" onclick="closeWindow()">
                    <i class="fa fa-mail-reply"></i>
                    <span>返 回</span>
                </button>


                <button type="button" class="btn btn-primary btn-sm show-area" onclick="saveRelevanceList()">
                    <i class="fa fa-save"></i>
                    <span>保 存</span>
                    </button>

                <button type="button" class="btn  btn-warning btn-sm show-area" onclick="cancelEdit()">
                    <i class="fa fa-close"></i>
                    <span>取 消</span>
                </button>

            </div>



        </div>
    </div>
</div>



<script>
    var tableid = "tableData-${r"${"} tableId ${r"}"}";

    var inAllPage = "${r"${"} inAllPage ${r"}"}";
    var queryString = "${r"${"} queryString ${r"}"}";
    var listUrl = "";


</script>

<bms:contentJS />



<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/form.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/list.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/js/project/listCommon.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/business-js${fkColumn1.fkTableConfig.fullResourceName}/search.js"></script>
<script src="${r"${"} staticUrl ${r"}"}/statics2/business-js${fkColumn2.fkTableConfig.fullResourceName}/search.js"></script>


<script language="JavaScript">


    function ${fkColumn1.javaName}Fmt(val, r,index){
        var html = '<input type="hidden" name="ms['+index+'].${fkColumn1.javaName}" id=“${fkColumn1.javaName}'+index+'”>';
        return html;
    }

    function ${fkColumn2.javaName}Fmt(val, r,index){
        var html = '<input type="hidden" name="ms['+index+'].${fkColumn2.javaName}" id=“${fkColumn2.javaName}'+index+'”>';
        return html;
    }


    function saveRelevanceList() {

        var actionUrl = ctx+dataUrl + "/saveRelevanceList?"+queryString;

        var rows = $('#'+tableid).datagrid("getRows");



        //提交表单
        $.ajax({
            url: actionUrl,
            type: 'POST',
            dataType:"json",
            contentType: "application/json; charset=utf-8",
            cache:false,
            data: JSON.stringify(rows),
            success: function (rsp, status) {
                updateSuccess(rsp, status);
            }
        });
    }


    function markFmt(val, r,index){
        var html =	'<div class="grid-column-option">';
        html+=	'<a href="javascript: doDel('+ index + ');" title="删除"><i class="fa fa-trash"></i></a>';
        html+=	'</div>';
        return html;
    }

    function doDel(index){
        $('#'+tableid).datagrid("deleteRow" , index);
        var rows = $('#'+tableid).datagrid("getRows");
        $('#'+tableid).datagrid("loadData",rows);

    }




    function clk${fkColumn2.fkTableConfig.fullUpperResourceName}(){
        open${fkColumn2.fkTableConfig.fullUpperResourceName}();
        $(".${fkColumn2.fkTableConfig.businessNameCamelCase!}s").click();
    }


    var ${fkColumn2.fkTableConfig.fullUpperResourceName?uncap_first}Window = null;
    function open${fkColumn2.fkTableConfig.fullUpperResourceName}(){
        if(${fkColumn2.fkTableConfig.fullUpperResourceName?uncap_first}Window != null){
            ${fkColumn2.fkTableConfig.fullUpperResourceName?uncap_first}Window.remove();
        }

        var rows=$('#'+tableid).datagrid("getRows");
        var ${fkColumn2.javaName}s =rows.map(n=>n.${fkColumn2.javaName});

        ${fkColumn2.javaName}s = ${fkColumn2.javaName}s.join(',');

        ${fkColumn2.fkTableConfig.fullUpperResourceName?uncap_first}Window = $(".${fkColumn2.fkTableConfig.businessNameCamelCase!}s").Open${fkColumn2.fkTableConfig.fullUpperResourceName}SelectWin(
            {
                title:"${fkColumn2.fkTableConfig.tableComment}(多选)",
                selectType: 'd2',
                callId:"${fkColumn2.javaName}s",
                callName:"${fkColumn2.fkTableConfig.businessNameCamelCase!}s",
                params:{ "id_NOTIN":${fkColumn2.javaName}s}
            },
            function(ids,names,rows){

                var datarow = $('#'+tableid).datagrid("getRows");
                var newRows = [];
                $.each(datarow,function(){
                    newRows.push(this);
                });

                $.each(rows,function(i,sub){
                    newRows.push({
                        id:'',
                        ${fkColumn1.javaName}:'${r"${"} m.${fkColumn1.javaName} ${r"}"}',
                        <#list exColumns as exColumn>
                        <#if exColumn.originalJavaName == fkColumn1.javaName>
                        ${exColumn.javaName}:'${r"${"} m.${exColumn.javaName} ${r"}"}',
                        </#if>
                        </#list>

                        ${fkColumn2.javaName}:sub.id,
                        <#list exColumns as exColumn>
                        <#if exColumn.originalJavaName == fkColumn2.javaName>
                        ${exColumn.javaName}:sub.${exColumn.fkJavaName},
                        </#if>
                        </#list>


                    });
                });
                var data = {rows:newRows};
                $('#'+tableid).datagrid("loadData",data);

            });
    }




    function clk${fkColumn1.fkTableConfig.fullUpperResourceName}(){
        open${fkColumn1.fkTableConfig.fullUpperResourceName}();
        $(".${fkColumn1.fkTableConfig.businessNameCamelCase!}s").click();
    }


    var ${fkColumn1.fkTableConfig.fullUpperResourceName?uncap_first}Window = null;
    function open${fkColumn1.fkTableConfig.fullUpperResourceName}(){
        if(${fkColumn1.fkTableConfig.fullUpperResourceName?uncap_first}Window != null){
            ${fkColumn1.fkTableConfig.fullUpperResourceName?uncap_first}Window.remove();
        }
        var rows=$('#'+tableid).datagrid("getRows");
        var ${fkColumn1.javaName}s =rows.map(n=>n.${fkColumn1.javaName});

        ${fkColumn1.javaName}s = ${fkColumn1.javaName}s.join(',');

        ${fkColumn1.fkTableConfig.fullUpperResourceName?uncap_first}Window = $(".${fkColumn1.fkTableConfig.businessNameCamelCase!}s").Open${fkColumn1.fkTableConfig.fullUpperResourceName}SelectWin(
            {
                title:"${fkColumn1.fkTableConfig.tableComment}(多选)",
                selectType: 'd2',
                callId:"${fkColumn1.javaName}s",
                callName:"${fkColumn1.fkTableConfig.businessNameCamelCase!}s",
                params:{ "id_NOTIN":${fkColumn1.javaName}s}
            },
            function(ids,names,rows){

                var datarow = $('#'+tableid).datagrid("getRows");
                var newRows = [];
                $.each(datarow,function(){
                    newRows.push(this);
                });

                $.each(rows,function(i,sub){
                    newRows.push({
                        id:'',
                    ${fkColumn2.javaName}:'${r"${"} m.${fkColumn2.javaName} ${r"}"}',
                    <#list exColumns as exColumn>
                    <#if exColumn.originalJavaName == fkColumn2.javaName>
                    ${exColumn.javaName}:'${r"${"} m.${exColumn.javaName} ${r"}"}',
                    </#if>
                    </#list>


                    ${fkColumn1.javaName}:sub.id,
                    <#list exColumns as exColumn>
                    <#if exColumn.originalJavaName == fkColumn1.javaName>
                    ${exColumn.javaName}:sub.${exColumn.fkJavaName},
                    </#if>
                    </#list>


                });
                });
                var data = {rows:newRows};
                $('#'+tableid).datagrid("loadData",data);

            });
    }

</script>



<bms:contentFooter />