<#list menus as menu>
insert into tr_menus(
id,
menu_Name,
menu_Name_i18n,
parent_menu_Id,
menu_Sort,
url,
msg,
icon,

component,
system_Id,
create_time,
create_user_id,
update_time,
update_user_id,
version_no )
values (
'${menu.id}' ,
'${menu.title}' ,
null,
<#if menu.pid?exists>null<#else>'${menu.pid}'</#if>,
${menu_index} ,
'${menu.path}' ,
null,
null,

'${menu.resource}',
'2',
SYSDATE() ,
'1' ,
SYSDATE() ,
'1' ,
1) ;
</#list>

