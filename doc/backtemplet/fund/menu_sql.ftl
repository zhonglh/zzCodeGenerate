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
<#if menu.pid?exists>'${menu.pid}'<#else>null</#if>,
${menu_index} ,
<#if (menu.pid?exists && menu.pid != '')>'${menu.path}'<#else >'/${menu.path}' </#if>,
'${menu.path}',
null,

<#if menu.level == 1 >
    <#if menu.leaf == "1" >'${menu.path}/${menu.name?cap_first}List',<#else>'Main',</#if>
<#elseif menu.level == 2 >
    <#if menu.leaf == "1" >'${menu.path}/${menu.name?cap_first}List',<#else>'menu-center',</#if>
<#else>
'${menu.path}/${menu.name?cap_first}List',
</#if>
'2',
SYSDATE() ,
'1' ,
SYSDATE() ,
'1' ,
1) ;
</#list>

