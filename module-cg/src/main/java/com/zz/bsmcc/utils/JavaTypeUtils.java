package com.zz.bsmcc.utils;



import com.zz.bsmcc.core.MapBean;
import com.zz.bsmcc.gen.entity.ColumnEntity;
import com.zz.bsmcc.gen.entity.TableEntity;

import java.util.List;

public class JavaTypeUtils {
	
	private static MapBean mb = new MapBean();

	static{
		mb.put("VARCHAR2", new MapBean("javaType", "java.lang.String", "jdbcType", "VARCHAR" ));
		mb.put("VARCHAR", new MapBean("javaType", "java.lang.String", "jdbcType", "VARCHAR"));
		mb.put("CHAR", new MapBean("javaType", "java.lang.String", "jdbcType", "CHAR"));
		mb.put("TEXT", new MapBean("javaType", "java.lang.String", "jdbcType", "TEXT"));
		mb.put("LONGTEXT", new MapBean("javaType", "java.lang.String", "jdbcType", "LONGTEXT"));


		mb.put("TINYINT", new MapBean("javaType", "java.lang.Integer", "jdbcType", "TINYINT" , "validate", "digits" ));
		mb.put("INTEGER", new MapBean("javaType", "java.lang.Integer", "jdbcType", "INT" , "validate", "digits" ));
		mb.put("INT", new MapBean("javaType", "java.lang.Integer", "jdbcType", "INT", "validate", "digits" ));
		mb.put("BIGINT", new MapBean("javaType", "java.lang.Long", "jdbcType", "BIGINT" , "validate", "digits"));

		mb.put("FLOAT", new MapBean("javaType", "java.lang.FLOAT", "jdbcType", "FLOAT" , "validate", "number"));
		mb.put("DOUBLE", new MapBean("javaType", "java.lang.DOUBLE", "jdbcType", "DOUBLE", "validate", "number" ));
		mb.put("NUMBER", new MapBean("javaType", "java.lang.Long", "jdbcType", "NUMERIC", "validate", "number" ));
		mb.put("DECIMAL", new MapBean("javaType", "java.math.BigDecimal", "jdbcType", "DECIMAL" , "validate", "number"));

		mb.put("DATE", new MapBean("javaType", "java.util.Date", "jdbcType", "DATE"));
		mb.put("DATETIME", new MapBean("javaType", "java.util.Date", "jdbcType", "TIMESTAMP"));
		mb.put("TIMESTAMP", new MapBean("javaType", "java.sql.Timestamp", "jdbcType", "TIMESTAMP"));
	}


	
	public static String getJavaType(TableEntity tableEntity, ColumnEntity columnEntity, String column){
		MapBean tempMap = mb.get(column.toUpperCase());

		columnEntity.setValidate(tempMap.getString("validate"));

		columnEntity.setJdbcType(tempMap.getString("jdbcType"));
		String temp = tempMap.getString("javaType");
		List<String> importEntity = tableEntity.getImportEntity();
		if(!importEntity.contains(temp)){
			importEntity.add(temp);
		}
		
		String[] split = temp.split("\\.");
		return split[split.length-1];
	}
	
	public static void main(String[] args) {
//		System.out.println(getJavaType("NUMBER"));
	}
}
