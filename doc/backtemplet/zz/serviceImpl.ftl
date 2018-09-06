package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import ${table.fullPackageName}.bo.${table.javaName}BO;
import ${table.fullPackageName}.dao.${table.javaName}DAO;
<#if (table.isTable == '0' && table.mainTableIdConfig?exists)>
import ${table.fullPackageName}.dao.${table.mainTableIdConfig.javaName}DAO;
</#if>
import ${table.fullPackageName}.service.${table.javaName}Service;

<#list table.fkTables as being>
import ${being.fullPackageName}.bo.${being.javaName}BO;
import ${being.fullPackageName}.dao.${being.javaName}DAO;
</#list>

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ${table.tableComment} ServiceImpl
* @author ${project.projectAuthor}
* @date ${.now}
*/
@Service
public class ${table.javaName}ServiceImpl extends BaseServiceImpl<${table.javaName}BO,String> implements ${table.javaName}Service {



	<#list table.fkTables as being>
	<#if ((table.mainTableIdConfig?exists && table.mainTableIdConfig.id!=being.id && table.id!=being.id) || (!table.mainTableIdConfig?exists && table.id!=being.id))>
    @Autowired
    private ${being.javaName}DAO ${being.javaName?uncap_first}DAO;
	</#if>
	</#list>


	<#if (table.isTable == '1' || ! table.mainTableIdConfig?exists) >
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
    private ${table.mainTableIdConfig.javaName}DAO ${table.mainTableIdConfig.javaName?uncap_first}DAO ;


    @Override
    public BaseDAO getQueryDAO() {
    	return ${table.javaName?uncap_first}DAO ;
    }

    @Override
    public BaseDAO getRwDAO() {
		return ${table.mainTableIdConfig.javaName?uncap_first}DAO ;
    }

	</#if>


	<#if exColumnMap?exists >
	@Override
	public ${table.javaName}BO processResult(${table.javaName}BO ${table.javaName?uncap_first}BO) {

		<#list exColumnMap?keys as key>
			<#if exColumnMap[key][0].originalColumnFk == '1'>
			<#assign fkTable = exColumnMap[key][0].originalColumn.fkTableConfig >
			${fkTable.javaName}BO ${fkTable.javaName?uncap_first}BO = ${exColumnMap[key][0].originalColumn.fkTableConfig.javaName?uncap_first}DAO.selectById(tcgExColumnBO.getOriginalColumnId());
            if(${fkTable.javaName?uncap_first}BO != null){
				<#list exColumnMap[key] as val>
				${table.javaName?uncap_first}BO.set${val.javaName?cap_first}(${fkTable.javaName?uncap_first}BO.get${val.fkJavaName?cap_first}());
				</#list>
            }
			<#else>
            //todo 处理字典信息
			</#if>
		</#list>

		return ${table.javaName?uncap_first}BO;

	}
	</#if>


}