

<#list dictTypes as dictType>

    insert into ts_dict_type(id,pid,dict_type_code,dict_type_name,dict_type_showable,dict_addable,dict_update,dict_delete,orderby)
    values(
        '${dictType.id}' , null , '${dictType.code}' , ${dictType.name} , '0' , '0' , '0' , '0' , ${dictType_index}
    );

    -- setting ${dictType.code} dicts
    insert into ts_dict(id,dict_type_id,dict_val,dict_name,orderby,create_user_id,create_user_name,create_time,version_no,delete_flag)
    values(
        REPLACE(uuid() , "-" , "") , '${dictType.id}' , '' , ''  , 1 , '11111111111111111111111111111111' , '管理员' , SYSDATE() , 0 , '0'
    );

    insert into ts_dict(id,dict_type_id,dict_val,dict_name,orderby,create_user_id,create_user_name,create_time,version_no,delete_flag)
    values(
        REPLACE(uuid() , "-" , "") , '${dictType.id}' , '' , ''  , 2 , '11111111111111111111111111111111' , '管理员' , SYSDATE() , 0 , '0'
    );

    insert into ts_dict(id,dict_type_id,dict_val,dict_name,orderby,create_user_id,create_user_name,create_time,version_no,delete_flag)
    values(
        REPLACE(uuid() , "-" , "") , '${dictType.id}' , '' , ''  , 3 , '11111111111111111111111111111111' , '管理员' , SYSDATE() , 0 , '0'
    );



</#list>
