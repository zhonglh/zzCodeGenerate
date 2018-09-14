<#list menus as menu>
insert into ts_menu(
id,
menu_name,
menu_code,
pid,
menu_sort,
menu_url,
menu_msg,
menu_icon,
menu_redirect,

shortcut,
level,
leaf,
remark,
delete_flag,
create_user_id,
create_user_name,
create_time,
update_user_id,
update_user_name,
update_time,
version_no )
values (
'${menu.id}' ,
'${menu.title}',
'${menu.name}' ,
<#if menu.pid?exists>'${menu.pid}' ,<#else >null ,</#if>
${menu_index} ,
<#if menu.leaf == '1'>'${menu.resource}' ,<#else >null,</#if>
'${menu.title}',
null,
null,

'0',
'${menu.level}',
'${menu.leaf}',
null,
'0',
'1' ,
'1' ,
SYSDATE() ,
'1' ,
'1' ,
SYSDATE() ,
1) ;


</#list>

