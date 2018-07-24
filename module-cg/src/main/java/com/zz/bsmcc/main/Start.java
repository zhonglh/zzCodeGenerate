package com.zz.bsmcc.main;



import com.zz.bsmcc.gen.action.GenAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) throws IOException {

		List<String> tableNames = new ArrayList<String>();

		String author = "Administrator";
		String schemeName = "zzframe";

		String[] tables = "vs_user".split(",");
		for(String tabl : tables){
			tableNames.add(tabl.trim().toLowerCase());
		}


		for (String tableName : tableNames) {
			System.out.println("开始生成：" + tableName);

			GenAction.gen(tableName, author,schemeName);
		}

		System.err.println("生成成功");


	}


}
