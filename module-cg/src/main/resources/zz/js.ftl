(function() {

    $.jgrid.defaults.styleUI = "Bootstrap";
    $("#gridTable").jqGrid({
        url: contextPath+dataUrl,
        datatype: "json",
        height: 450,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colModel: [{
            name: "id",
            index: "id",
            editable: true,
            width: 60,
            hidden:true,
            sorttype: "int",
            search: true
        }
        <#assign seq = ["id", "createDate", "updateDate","createTime","updateTime"]>
        <#list table.columnList as being>
            <#if !seq?seq_contains(being.shortColumnName)>
            ,{label: "${being.columnComments}",name: "${being.shortColumnName}", index: "${being.shortColumnName}", editable: true, width: 100}
            </#if>
        </#list>
        ],
        multiselect: true,
        multiboxonly:true,
        pager: "#pagerBar",
        viewrecords: true,
        add: true,
        edit: true,
        addtext: "Add",
        edittext: "Edit",
        hidegrid: false
        }).navGrid('#pagerBar', { edit: false, add: false, del: false, refresh: true,  view: false, search: false });
        $(window).bind("resize", function () {
        var width = $(".jqGrid_wrapper").width();
        $("#gridTable").setGridWidth(width)
    })

});



/**
* 修改${table.tableComments}
* @param url
*/
function edit${table.shortTableName?cap_first}(url) {
    var ids = $("#gridTable").jqGrid('getGridParam', 'selarrrow');
    var url  = url +"?id="+ids;
    edit(url,ids);
}

/**
* 删除${table.tableComments}
* @param url
*/
function del${table.shortTableName?cap_first}(url) {
    var ids = $("#gridTable").jqGrid('getGridParam', 'selarrrow');
    var url  = url +"?ids="+ids;
    del(url,ids);
}
