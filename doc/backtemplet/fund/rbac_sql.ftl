

insert into tr_object_info(
id,
object_name,
object_name_i18n,
process_id,
system_id,
describes,
remark,

create_time,
create_user_id,
update_time,
update_user_id,
version_no) values (

'${table.id}',
'${table.tableName}',
'${table.javaName}',
null,
'2',
null,
null,


SYSDATE() ,
'1' ,
SYSDATE() ,
'1' ,
1
);

<#if tableoperations?exists>
<#list tableoperations as operation>

insert into tr_object_info(
id,
permission_code,
permission_Name,
permission_Name_i18n,
object_Id,
operation_Id ,
rbac_flag,
describes,
remark ,

create_time,
create_user_id ,
update_time,
update_user_id ,
version_no ,
system_Id
) values (
'${operation.id}',
'${table.fullResourceFile}:${operation.operationBO.operationResource}',
'${operation.operationBO.operationName}${table.tableComment}',
null,
'${table.id}',
'${operation.operationBO.id}',
'1',
null,
null,


SYSDATE() ,
'1' ,
SYSDATE() ,
'1' ,
1 ,
'2'
) ;

</#list>
</#if>


<#if tableoperations?exists>
<#list tableoperations as operation>
insert into tr_menu_permission(id ,permission_id , menu_id)
values (REPLACE(uuid() , "-" , ""),'${operation.id}','${table.id}') ;

</#list>
</#if>