package com.zz.bsmcc.utils;


import com.zz.bsmcc.gen.entity.ColumnEntity;
import com.zz.bsmcc.gen.entity.EnumEntity;
import com.zz.bsmcc.gen.entity.TableEntity;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntityUtils {

	/**
	 * WLK_QYH_BASE_USER 转换为 wlkQyhBaseUser
	 * 
	 * @param column
	 * @return
	 */
	public static String column2JavaProperty(String column) {
		StringBuffer sb = new StringBuffer();
		String[] split = column.toLowerCase().split("_");
		String temp = null;
		for (int i = 0; i < split.length; i++) {
			temp = split[i];
			if (i > 0) {
				temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
			}
			sb.append(temp);
		}
		return sb.toString();
	}




	/**
	 * WLK_QYH_BASE_USER 转换为 QyhBaseUser
	 *
	 * @param column
	 * @return
	 */
	public static String column2JavaProperty2(String column) {
		StringBuffer sb = new StringBuffer();
		String[] split = column.toLowerCase().split("_");
		String temp = null;
		for (int i = 1; i < split.length; i++) {
			temp = split[i];
			temp = temp.substring(0, 1).toUpperCase() + temp.substring(1);
			sb.append(temp);
		}
		return sb.toString();
	}



	/**
	 * 状态@0:正常,1:删除
	 * 
	 * @param comments
	 * @return
	 */
	public static List<EnumEntity> comments2Enum(TableEntity tableEntity, ColumnEntity columnEntity, String comments) {
		if (StringUtils.isEmpty(comments)) {
			return null;
		}
		comments = comments.split("@")[1];
		String[] categoryArr = comments.replace("：", ":").replace("，", ",").split(",");
		List<EnumEntity> enumList = new ArrayList<EnumEntity>();
		
		for (int i = 0; i < categoryArr.length; i++) {
			EnumEntity enumEntity = new EnumEntity();
			
			String enumClassName = StringUtils.capitalize(getLastName(tableEntity.getTableName())) + StringUtils.capitalize(columnEntity.getShortColumnName());
			String packageStr = tableEntity.getBasePackage() + ".entity";
			columnEntity.setEnumClassName(enumClassName);
			columnEntity.setPackageStr(packageStr);
			String[] arr = categoryArr[i].split(":");
			enumEntity.setEnumKey(arr[0]);
			enumEntity.setEnumValue(arr[1]);
			enumList.add(enumEntity);
		}

		
		return enumList;
	}

	/**
	 * WLK_QYH_SIGN_RECORD ===> WLK_QYH_SIGN
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getSequence(String tableName) {
		return tableName.substring(0, tableName.lastIndexOf("_"));
	}

	/**
	 * WLK_QYH_SIGN_RECORD ===> SIGN
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getSubPackage(String tableName) {
		tableName = getSequence(tableName);
		return tableName.substring(tableName.lastIndexOf("_") + 1).toLowerCase();
	}
	/**
	 * WLK_QYH_SIGN_RECORD ===> record
	 * 
	 * @param tableName
	 * @return
	 */
	public static String getLastName(String tableName) {
		return tableName.substring(tableName.lastIndexOf("_") + 1).toLowerCase();
	}

	public static void main(String[] args) {
		// String column = "WLK_QYH_BASE_USER";
		// System.out.println(column2JavaProperty(column ));
		// System.out.println(comments2Enum("状态@0:正常,1:删除"));
		System.out.println(getSequence("WLK_QYH_SIGN_RECORD"));
		System.out.println(getSubPackage("WLK_QYH_SIGN_RECORD"));
		System.out.println(getLastName("WLK_QYH_SIGN_RECORD"));

	}
}
