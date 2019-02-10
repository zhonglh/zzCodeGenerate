
/**
* 打开${table.tableComment}选择窗口
* callId	回显数据ID的控件ID
* callName	回显数据名称的控件ID
* clearId	清空选项的控件ID
* callBack 选择后的回调函数
* @returns
*/
function open${table.fullUpperResourceName}Win(config, callBack)
{

<#if table.isTree?exists && table.isTree == '0'>
var url = config.url || $AppContext + '${table.fullResourceName}/list';
var tableTemple = '<div class="easyui-panel" style="padding:5px; border: 0; width: 605px;height:450px;">'
    + '<table align="center" class="_searchTools" width="100%" border="0" style="background-color: #ffffff;">'
        + '<tr style="height: 40px;">'
            + '<td>'
                + '<div class="form-inline" role="form" >';


<#if querys?exists >
    <#list querys as being>
        <#if being.columnPage?exists && being.columnPage.columnConfig?exists>
            <#if being.columnPage.element == 'text' || being.columnPage.element == 'textarea' >
                <input type="text"  class="form-control input-sm" style='width: 200px;' id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' >
            <#elseif being.columnPage.element == 'digits' >
                <input type="text" style='width: 200px;' <#if being.columnPage.max?exists>max="${being.columnPage.max}"</#if> step="1" class="form-control input-sm number  " id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>" name="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>"  placeholder="${being.queryPlaceholder}">
            <#elseif being.columnPage.element == 'number' >
                <input type="text" style='width: 200px;' <#if being.columnPage.max?exists>max="${being.columnPage.max}"</#if> step="1" class="form-control input-sm number  " id="${being.queryFieldName}" name="${being.queryFieldName}"  placeholder="${being.queryPlaceholder}">
            <#elseif being.columnPage.element == 'date' >
                <input  type="text" class="form-control input-sm" style='width: 100px;' onclick="WdatePicker()" readonly  id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' >
            <#elseif being.columnPage.element == 'timestamp' >
                <input type="text" class="form-control input-sm" style='width: 100px;' onclick="WdatePicker()" readonly  id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' >
            <#elseif being.columnPage.element == 'email' >
                <input type="text" class="form-control input-sm" style='width: 100px;' readonly  id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' >
            <#elseif being.columnPage.element == 'url' >
                <input type="text" class="form-control input-sm" style='width: 100px;' readonly  id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>'  placeholder='${being.queryPlaceholder}' >
            <#elseif being.columnPage.element == 'radio' || being.columnPage.element == 'checkbox' || being.columnPage.element == 'select' >
                <select id="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>" name='${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>'   class="form-control input-sm" onChange='search();'  >
                    <option value="" >'${being.queryPlaceholder}'</option>
                    <c:forEach items=${r"${"} yes_no_dicts ${r"}"} var="dict">
                        <option value="${r"${"} dict.value ${r"}"}">${dict.name}</option>
                    </c:forEach>
                </select>
            <#elseif being.columnPage.element == 'openwin' >
            <#else >
            </#if>
        </#if>
    </#list>
</#if>


                    tableTemple += '<button type="submit" class="btn btn-success btn-sm" ><i class="fa fa-search"></i>&nbsp;查询</button>'
                    + '</div>'
                + '</td>'
            + '</tr>'
        + '</table>'
    + '<table class="_dataContorl _w_height" style="height: 300px;" pagination="true" border="true"  sortName="${table.businessNameCamelCase!}" sortOrder="asc"></table>'
    + '</div>';

var options = config || {};
options.id = "_${table.fullUpperResourceName}ListPanel" + config.callId;
options.width = 616;
options.height = 550;
options.callBack = callBack;
options.url = url;
options.columns = [[
{field:"id", checkbox: true, width: 40},
<#if listColumnPages?exists>
    <#list listColumnPages as listPage>
    {field:"${listPage.javaName}", title:"${listPage.columnComment}", width: 150, <#if listPage.numberColumn=='1' >align:"right"<#elseif listPage.dateColumn=='1' >align:"center"<#else >align:"left"</#if> ,<#if listPage.dateColumn=='1' >formatter='dateFmt'</#if>}<#if listPage_has_next>,</#if>
    </#list>
</#if>
]];
options.sampleData = {id: "id", name: "${table.businessNameCamelCase!}"};
options.htmlTemple = tableTemple;
options.compiledSuccess = function(){
// 查询按钮事件
dialog.tableTemple.find("button").bind("click", function(){
search();
});

dialog.tableTemple.find('input').keydown(function(e){
if(e.keyCode==13){
search();
}
});

// 状态发生改变查询
dialog.tableTemple.find("select").bind("change", function(){
search();
});

function search(){
// 获取查询参数
var params = options.params || {};



<#if querys?exists >
    <#list querys as being>
        <#if being.columnPage?exists && being.columnPage.columnConfig?exists>
        params["${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>"] = dialog.tableTemple.find('select[name="${being.queryFieldName}<#if being.queryRelation?exists && being.queryRelation?length !=0 && being.queryRelation != 'eq' >_${being.queryRelation}</#if>"]').val();
        </#if>
    </#list>
</#if>


// 调用查询方法
dialog.tableTemple.search(params);
}
};

var dialog = DialogTools.getDialog(options);

return dialog;
</#if>







<#if table.isTree?exists && table.isTree == '1'>
var url = config.url || $AppContext + '${table.fullResourceName}/treelist';
var tableTemple = '<div style="height: 350px; overflow-y:auto; overflow-x:hidden;" class="_w_height">' +
    '<table idField="id" treeField="${table.businessNameCamelCase!}" class="_dataContorl">'  +
        '	<thead>'  +
        '		<tr>' ;

        <#if listColumnPages?exists>
            <#list listColumnPages as listPage>
                tableTemple += '			<th field="${listPage.javaName}" <#if listPage.numberColumn=='1' >align="right"<#elseif listPage.dateColumn=='1' >align="center"<#else >align="left"</#if>  <#if listPage.dateColumn=='1' >formatter='dateFmt'</#if>>${listPage.columnComment}</th>' ;
            </#list>
        </#if>


tableTemple +='		</tr>'+
        '	</thead>' +
        '</table>' +
    '</div>';

var options = config || {};
options.width = 430;
options.height = 450;
options.id = "_${table.fullUpperResourceName}List" + config.callId;
options.url = url;
options.callBack = callBack;
options.sampleData = {id: "id", name: "${table.businessNameCamelCase!}"};
options.htmlTemple = tableTemple;
var dialog = DialogTools.getDialog(options);

return dialog;

</#if>
};



//${table.tableComment}选择控件
$.fn.Open${table.fullUpperResourceName}SelectWin = function(config, callBack){
var win = open${table.fullUpperResourceName}Win(config, callBack);
$(this).unbind("click");
$(this).bind("click", function(){
win.show();
});
return win;
};
