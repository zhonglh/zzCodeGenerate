package com.zz.bsmcc.core.util;

import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.util.base.java.ReflectionSuper;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 */
public class CgBeanUtil {

    /**
     * 获取类的字段名称
     * @param clz
     * @return
     */
    public static Set<String> getClassFieldName(Class clz){
        if(!clz.isAssignableFrom(BaseEntity.class)){
            throw new InternalException("类型必须是 BaseEntity 的子类");
        }
        Set<String> nameSet = new HashSet<String>();
        Field[] fs = ReflectionSuper.getAllField( clz , BaseEntity.class);
        for(Field f : fs){
            nameSet.add(f.getName());
        }
        return nameSet;
    }


}
