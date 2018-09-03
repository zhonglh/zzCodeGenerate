package com.zz.bsmcc.main;



import com.zz.bsmcc.gen.action.GenAction;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {
	public static Logger logger = Logger.getLogger(Start.class);

	public static void main(String[] args) throws IOException {



		List<String> tableNames = new ArrayList<String>();

		String author = "Administrator";
		String schemeName = "zzcg";

		String[] tables = "tcg_code_build_log,tcg_column_config, tcg_column_event, tcg_column_ex, tcg_column_page, tcg_column_validate, tcg_db_config, tcg_ex_column, tcg_group_config, tcg_index_config, tcg_java_datatype_real, tcg_module_config, tcg_operation, tcg_project, tcg_query_config, tcg_table_config, tcg_table_operation, tcg_templet, tcg_templet_group, tcg_templet_group_operation, ts_user".split(",");
		for(String tabl : tables){
			tableNames.add(tabl.trim().toLowerCase());
		}


		for (String tableName : tableNames) {
			logger.debug("开始生成：" + tableName);

			GenAction.gen(tableName, author,schemeName);
		}

		logger.debug("生成成功");


	}


}
