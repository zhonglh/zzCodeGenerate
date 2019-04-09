package com.zz.bsmcc.core.util;

import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.exceptions.InternalException;
import com.zz.bms.util.base.java.ReflectionSuper;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 */
public class CgBeanUtil {


    public static Set<String> getAllClassFieldName(Class clz){
        /*if(!clz.isAssignableFrom(BaseEntity.class)){
            throw new InternalException("类型必须是 BaseEntity 的子类");
        }*/
        Set<String> nameSet = new HashSet<String>();
        Field[] fs = ReflectionSuper.getAllField( clz , Object.class);
        for(Field f : fs){
            nameSet.add(f.getName());
        }
        return nameSet;
    }

    /**
     * 获取类的字段名称
     * @param clz
     * @return
     */
    public static Set<String> getClassFieldName(Class clz){
        /*if(!clz.isAssignableFrom(BaseEntity.class)){
            throw new InternalException("类型必须是 BaseEntity 的子类");
        }*/
        Set<String> nameSet = new HashSet<String>();
        Field[] fs = ReflectionSuper.getAllField( clz , BaseEntity.class);
        for(Field f : fs){
            nameSet.add(f.getName());
        }
        return nameSet;
    }

    /**
     * 名字处理，  包括表名称 和Sehema名称
     * @return
     */
    public static String nameProcess(String name){
        //目前是处理为全小写
        if(StringUtils.isNotEmpty(name)){
            return name.toLowerCase();
        }else {
            return name;
        }

    }


}
