package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;

import com.zz.bms.system.service.TsDictService;

import ${table.fullPackageName}.bo.${table.javaName}BO;
import ${table.fullPackageName}.dao.${table.javaName}DAO;
<#if (table.isTable == '0' && table.mainTableConfig?exists)>
import ${table.fullPackageName}.dao.${table.mainTableConfig.javaName}DAO;
</#if>
import ${table.fullPackageName}.service.${table.javaName}Service;

<#list table.fkTables as being>
import ${being.fullPackageName}.bo.${being.javaName}BO;
import ${being.fullPackageName}.dao.${being.javaName}DAO;
</#list>


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ${table.tableComment} ServiceImpl
* @author ${project.projectAuthor}
* @date ${.now}
*/
@Service
public class ${table.javaName}ServiceImpl extends BaseServiceImpl<${table.javaName}BO,String> implements ${table.javaName}Service {



	@Autowired
	private TsDictService tsDictService;

	<#list table.fkTables as being>
	<#if ((table.mainTableConfig?exists && table.mainTableConfig.id!=being.id && table.id!=being.id) || (!table.mainTableConfig?exists && table.id!=being.id))>
    @Autowired
    private ${being.javaName}DAO ${being.javaName?uncap_first}DAO;
	</#if>
	</#list>


	<#if (table.isTable == '1' || ! table.mainTableConfig?exists) >
	@Autowired
	private ${table.javaName}DAO ${table.javaName?uncap_first}DAO ;

	@Override
	public BaseDAO getQueryDAO() {
		return ${table.javaName?uncap_first}DAO ;
	}

	@Override
	public BaseDAO getRwDAO() {
		return ${table.javaName?uncap_first}DAO ;
	}
	<#else>

    @Autowired
    private ${table.javaName}DAO ${table.javaName?uncap_first}DAO ;

    @Autowired
    private ${table.mainTableConfig.javaName}DAO ${table.mainTableConfig.javaName?uncap_first}DAO ;


    @Override
    public BaseDAO getQueryDAO() {
    	return ${table.javaName?uncap_first}DAO ;
    }

    @Override
    public BaseDAO getRwDAO() {
		return ${table.mainTableConfig.javaName?uncap_first}DAO ;
    }

	</#if>


	<#if exColumnMap?exists >
	@Override
	public ${table.javaName}BO processResult(${table.javaName}BO ${table.javaName?uncap_first}BO) {

		<#list exColumnMap?keys as key>
			<#if exColumnMap[key][0].originalColumnFk == '1'>
			<#assign fkTable = exColumnMap[key][0].originalColumn.fkTableConfig >

			if(   StringUtils.isNotEmpty( ${table.javaName?uncap_first}BO.get${exColumnMap[key][0].originalColumn.javaName?cap_first}() ) ){
				${fkTable.javaName}BO ${fkTable.javaName?uncap_first}BO = ${exColumnMap[key][0].originalColumn.fkTableConfig.javaName?uncap_first}DAO.selectById( ${table.javaName?uncap_first}BO.get${exColumnMap[key][0].originalColumn.javaName?cap_first}() );
				if(${fkTable.javaName?uncap_first}BO != null){
					<#list exColumnMap[key] as val>
					${table.javaName?uncap_first}BO.set${val.javaName?cap_first}(${fkTable.javaName?uncap_first}BO.get${val.fkJavaName?cap_first}());
					</#list>
				}
			}
			<#else>
            try {
				if(StringUtils.isEmpty(${table.javaName?uncap_first}BO.get${exColumnMap[key][0].javaName?cap_first}()) && StringUtils.isNotEmpty(${table.javaName?uncap_first}BO.get${exColumnMap[key][0].originalColumn.javaName?cap_first}()) ) {
					String dictName = tsDictService.getDictName(${table.javaName?uncap_first}BO.get${exColumnMap[key][0].originalColumn.javaName?cap_first}(), "${exColumnMap[key][0].originalColumn.dictType}");
					${table.javaName?uncap_first}BO.set${exColumnMap[key][0].javaName?cap_first}(dictName);
            	}
            }catch(Exception e){

            }
			</#if>
		</#list>

		return ${table.javaName?uncap_first}BO;

	}
	</#if>


}