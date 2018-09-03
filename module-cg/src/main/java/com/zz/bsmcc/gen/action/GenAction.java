package com.zz.bsmcc.gen.action;

import com.zz.bms.util.base.files.FreemarkerUtils;
import com.zz.bsmcc.core.Applications;
import com.zz.bsmcc.gen.entity.ColumnEntity;
import com.zz.bsmcc.gen.entity.TableEntity;
import com.zz.bsmcc.gen.service.GenService;
import com.zz.bsmcc.utils.FreeMarkers;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GenAction {

	public static final String ROOTPATH = Applications.get("root.path");

	public static void logger(String log) {

	}

	public static void genJava(TableEntity tableEntity, String packageName, String ftlName) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("table", tableEntity);
		String dirPath = tableEntity.getBasePackage().replaceAll("\\.", "\\\\") + File.separator + packageName;
		String fileName = StringUtils.capitalize(tableEntity.getShortTableName()) + StringUtils.capitalize(ftlName.split("\\.")[0]) + ".java";

		if("domain".equals(packageName) || "entity".equals(packageName)){
			fileName = StringUtils.capitalize(tableEntity.getShortTableName()) + "Entity.java";
		}if("bo".equals(packageName)){
			fileName = StringUtils.capitalize(tableEntity.getShortTableName()) + "BO.java";
		}else if("dao".equals(packageName)){
			fileName = StringUtils.capitalize(tableEntity.getShortTableName()) + "DAO.java";
		}else if("query".equals(packageName)){
			fileName = StringUtils.capitalize(tableEntity.getShortTableName()) + "Query.java";
		}
		packageName = packageName.replaceAll("\\." ,File.separator + File.separator );
		FreemarkerUtils.saveFile(model,ROOTPATH + File.separator + packageName,fileName,ftlName,Applications.get("ftl.path"));
	}


	public static void genJsp(TableEntity tableEntity, String ftlName) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("table", tableEntity);
		String fileName = tableEntity.getShortTableName()+ StringUtils.capitalize(ftlName.split("\\.")[0]) + ".jsp";
		FreemarkerUtils.saveFile(model,ROOTPATH + File.separator + "jspfile",fileName,ftlName,Applications.get("ftl.path"));
	}

	public static void genJs(TableEntity tableEntity, String ftlName) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("table", tableEntity);
		String fileName = tableEntity.getShortTableName() + ".js";
		FreemarkerUtils.saveFile(model,ROOTPATH + File.separator + "jsfile",fileName,ftlName,Applications.get("ftl.path"));
	}

	public static void genMapper(TableEntity tableEntity, String packageName, String ftlName) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("table", tableEntity);
		String dirPath = Applications.get("base.subpackage") + packageName;
		String fileName = StringUtils.capitalize(tableEntity.getShortTableName()) + ".xml";
		saveFile(model, dirPath, fileName, ftlName);
	}

	public static void genSupport(TableEntity tableEntity, String packageName, String ftlName) throws IOException {

		String dirPath = tableEntity.getBasePackage().replaceAll("\\.", "\\\\") + File.separator + packageName;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("table", tableEntity);

		for (ColumnEntity columnEntity : tableEntity.getColumnList()) {
			if (!columnEntity.getIsEnum() || "STATE".equalsIgnoreCase(columnEntity.getColumnName())) {
				continue;
			}
			String fileName = StringUtils.capitalize(columnEntity.getEnumClassName()) + ".java";
			model.put("column", columnEntity);
			saveFile(model, dirPath, fileName, ftlName);
		}
	}
	
	public static void genHandler(TableEntity tableEntity, String packageName, String ftlName) throws IOException {
		
		String dirPath = tableEntity.getBasePackage().replaceAll("\\.", "\\\\") + File.separator + packageName;
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("table", tableEntity);
		
		for (ColumnEntity columnEntity : tableEntity.getColumnList()) {
			if (!columnEntity.getIsEnum() || "STATE".equalsIgnoreCase(columnEntity.getColumnName())) {
				continue;
			}
			String fileName = StringUtils.capitalize(columnEntity.getEnumClassName() + "Handler") + ".java";
			model.put("column", columnEntity);
			saveFile(model, dirPath, fileName, ftlName);
		}
	}

	public static void saveFile(Map<String, Object> model, String dirPath, String fileName, String ftlName) throws IOException {

		Configuration cfg = FreeMarkers.buildConfiguration("classpath:" + Applications.get("ftl.path"));
		Template template = cfg.getTemplate(ftlName);
		String result = FreeMarkers.renderTemplate(template, model);

		String dirName = ROOTPATH + File.separator + dirPath;
		File dir = new File(dirName);
		dir.mkdirs();
		String pathname = dirName + File.separator + fileName;
		File file = new File(pathname);
		file.createNewFile();
		IOUtils.write(result, new FileOutputStream(file));
		logger("创建文件：" + pathname);

	}
	
	public static void genTypeAlias(TableEntity tableEntity, String fileName, String ftlName) throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("table", tableEntity);
		
		Configuration cfg = FreeMarkers.buildConfiguration("classpath:" + Applications.get("ftl.path"));
		Template template = cfg.getTemplate(ftlName);
		String result = FreeMarkers.renderTemplate(template, model);

		String dirName = ROOTPATH + File.separator + fileName;
		File file = new File(dirName);
		if(!file.exists()){
			file.createNewFile();
		}
		IOUtils.write(result + "\r\n", new FileOutputStream(file, true));
		logger("更新文件：" + dirName);

	}

	public static void gen(String tableName, String author, String schemeName) throws IOException {
		GenService TableService = new GenService();
		TableEntity tableEntity = new TableEntity();
		TableService.getTableComments(tableEntity, tableName, schemeName);
		TableService.getTableColumnsMeta(tableEntity, tableName, schemeName);
		TableService.getTableOther(tableEntity, tableName, schemeName);

		tableEntity.setSubPackage(Applications.get("base.subpackage"));
		tableEntity.setAuthor(author);

		int  baseEntity = 0;
		int index = 0;
		for(ColumnEntity column : tableEntity.getColumnList()){
			if(column.getColumnName().equals("version_no")) {
				index ++ ;
			}else if(column.getColumnName().equals("create_time")) {
				index ++ ;
			}else if(column.getColumnName().equals("create_user_id")) {
				index ++ ;
			}else if(column.getColumnName().equals("update_time")) {
				index ++ ;
			}else if(column.getColumnName().equals("update_user_id")) {
				index ++ ;
			}
		}
		if(index == 5) {
			baseEntity = 1;
		}

		if(baseEntity == 1){
			boolean hasDelete = false;
			for(ColumnEntity column : tableEntity.getColumnList()) {
				if (column.getColumnName().equals("delete_flag")) {
					hasDelete = true;
					break;
				}
			}
			if(hasDelete){
				baseEntity = 2;
			}
		}



		genMapper(tableEntity, File.separator + "mapper", "entityMapper.ftl");

		if(baseEntity == 0) {
			genJava(tableEntity, "domain", "entity.ftl");
		}else if(baseEntity == 1) {
			genJava(tableEntity, "domain", "entity1.ftl");
		}else if(baseEntity == 2) {
			genJava(tableEntity, "domain", "entity2.ftl");
		}


		genJava(tableEntity, "bo", "bo.ftl");

		genJava(tableEntity, "dao", "dao.ftl");
		genJava(tableEntity, "interfaces", "service.ftl");
		genJava(tableEntity, "services", "serviceImpl.ftl");
		genJava(tableEntity, "controller", "controller.ftl");
		genJava(tableEntity, "exceptions", "exceptions.ftl");



		genJava(tableEntity, "query", "query.ftl");
		genJava(tableEntity, "query.impl", "AbstractQueryImpl.ftl");
		genJava(tableEntity, "query.impl", "QueryWebImpl.ftl");
		genJava(tableEntity, "query.impl", "QueryImpl.ftl");



		genJsp(tableEntity, "list.ftl");
		genJsp(tableEntity, "input.ftl");
		genJs(tableEntity, "js.ftl");

/*
		genSupport(tableEntity, "entity" + File.separator + "support", "support.ftl");
		genHandler(tableEntity, "entity" + File.separator + "handler", "handler.ftl");
*/

//		genTypeAlias(tableEntity, "typeAlias.xml", "typeAlias.ftl");
	}
}
