package com.zz.bsmcc.utils;



import springfox.documentation.schema.Maps;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Administrator
 */
public class Obj2StrUtils {
	
	/**
	 * 简单对象转换string ，null转""
	 * @param obj	对象
	 * @return String
	 */
	public static String objToString(Object obj){
		String temp = "";
		if(obj != null) {
			temp = obj.toString();
		}
		return temp;
	}
	
	/**
	 *Map<String, Object> 转换 Map<String, String>
	 * @param map Map
	 * @return	Map
	 */
	public static Map<String, String> objToStrMap(Map<String, Object> map){
		Map<String, String> temp = new HashMap<>();
		
		for(Map.Entry<String, Object> entry : map.entrySet()){
			temp.put(entry.getKey(), Obj2StrUtils.objToString(entry.getValue()));
		}
		
		return temp;
	}
}
