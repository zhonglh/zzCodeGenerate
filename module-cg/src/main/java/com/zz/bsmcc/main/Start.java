package com.zz.bsmcc.main;



import com.zz.bsmcc.gen.action.GenAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) throws IOException {

		List<String> tableNames = new ArrayList<String>();

		String author = "Administrator";
		String schemeName = "zzcg";

		String[] tables = "tcg_column_config, tcg_column_event, tcg_column_ex, tcg_column_page, tcg_column_validate, tcg_db_config, tcg_group_config, tcg_index_config, tcg_module_config, tcg_operation, tcg_project, tcg_query_config, tcg_table_config, tcg_table_operation, tcg_templet, tcg_templet_grop_operation, tcg_templet_group, ts_user".split(",");
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
