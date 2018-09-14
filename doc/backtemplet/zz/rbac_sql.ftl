


<#if tableoperations?exists>
    <#list tableoperations as operation>

    insert into ts_permit(
    id,
    permit_name,
    permit_code,
    remark,
    delete_flag
    ) values (
    '${operation.id}',
    '${operation.operationBO.operationName}${table.tableComment}',
    '${table.fullResourceFile}:${operation.operationBO.operationResource}',
    null,
    '0'
    ) ;

    </#list>
</#if>


<#if tableoperations?exists>
    <#list tableoperations as operation>
    insert into ts_menu_permit(id ,menu_id , permit_id)
    values (REPLACE(uuid() , "-" , ""),'${table.id}','${operation.id}') ;
    </#list>
</#if>