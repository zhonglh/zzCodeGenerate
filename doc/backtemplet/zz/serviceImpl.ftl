package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.core.enums.EnumErrorMsg;
import ${project.projectPackage}.enums.*;

import com.zz.bms.core.db.entity.EntityUtil;
import com.zz.bms.core.exceptions.DbException;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.system.service.impl.SystemBaseServiceImpl;

import com.zz.bms.system.service.TsDictService;

import com.zz.bms.system.bo.TsDictBO;
import ${table.fullPackageName}.bo.${table.javaName}BO;
import ${table.fullPackageName}.dao.${table.javaName}DAO;
<#if (table.isTable == '0' && table.mainTableConfig?exists)>
import ${table.fullPackageName}.dao.${table.mainTableConfig.javaName}DAO;
</#if>
import ${table.fullPackageName}.service.${table.javaName}Service;

<#list table.fkTableSet as being>
import ${being.fullPackageName}.bo.${being.javaName}BO;
import ${being.fullPackageName}.dao.${being.javaName}DAO;
</#list>


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* ${table.tableComment} ServiceImpl
* @author ${project.projectAuthor}
* @date ${.now}
*/
@Service
public class ${table.javaName}ServiceImpl extends SystemBaseServiceImpl<${table.javaName}BO,String> implements ${table.javaName}Service {



	@Autowired
	private TsDictService tsDictService;



	<#list table.fkTableSet as being>
	<#if ((table.mainTableConfig?exists && table.mainTableConfig.id!=being.id && table.id!=being.id) || (!table.mainTableConfig?exists && table.id!=being.id))>
    @Autowired
    private ${being.javaName}DAO ${being.javaName?uncap_first}DAO;
	</#if>
	</#list>


    @Autowired
    private ${table.javaName}DAO ${table.javaName?uncap_first}DAO ;



    @Override
    public BaseDAO getDAO() {
    	return ${table.javaName?uncap_first}DAO ;
    }



	<#if exColumnMap?exists >
	@Override
	public ${table.javaName}BO processResult(${table.javaName}BO ${table.javaName?uncap_first}BO) {

		<#list exColumnMap?keys as key>
		<#if exColumnMap[key][0].originalColumnFk == '1'>
		<#assign fkTable = exColumnMap[key][0].originalColumn.fkTableConfig >

		if(StringUtils.isNotEmpty( ${table.javaName?uncap_first}BO.get${exColumnMap[key][0].originalColumn.javaName?cap_first}())){
			${fkTable.javaName}BO temp = ${exColumnMap[key][0].originalColumn.fkTableConfig.javaName?uncap_first}DAO.selectById( ${table.javaName?uncap_first}BO.get${exColumnMap[key][0].originalColumn.javaName?cap_first}() );
			if(temp != null){
				<#list exColumnMap[key] as val>
				${table.javaName?uncap_first}BO.set${val.javaName?cap_first}(temp.get${val.fkJavaName?cap_first}());
				</#list>
			}
		}
		<#else>
		try {
			if(StringUtils.isEmpty(${table.javaName?uncap_first}BO.get${exColumnMap[key][0].javaName?cap_first}()) && StringUtils.isNotEmpty(${table.javaName?uncap_first}BO.get${exColumnMap[key][0].originalColumn.javaName?cap_first}()) ) {
				String dictName = tsDictService.getDictName(${table.javaName?uncap_first}BO.get${exColumnMap[key][0].originalColumn.javaName?cap_first}(),EnumDictType.${exDictColumnMap[key][0].originalColumn.dictType?upper_case}.getVal());
				${table.javaName?uncap_first}BO.set${exColumnMap[key][0].javaName?cap_first}(dictName);
			}
		}catch(Exception e){

		}
		</#if>
		</#list>


		<#if table.fileColumns?exists>
		<#list table.fileColumns as fileColumn>
		try{
			if(StringUtils.isNotEmpty(${table.javaName?uncap_first}BO.get${fileColumn.javaName?cap_first}()) && ${table.javaName?uncap_first}BO.get${fileColumn.javaName?cap_first}List() == null){
			QueryWrapper<VsFileUseBO> qw = new QueryWrapper<VsFileUseBO>();
			qw.lambda().eq(VsFileUseBO::getBusinessId , ${table.javaName?uncap_first}BO.getId());
			qw.lambda().eq(VsFileUseBO::getBusinessTempId , ${table.javaName?uncap_first}BO.get${fileColumn.javaName?cap_first}());
			List<VsFileUseBO> list = vsFileUseService.list(qw);
				${table.javaName?uncap_first}BO.set${fileColumn.javaName?cap_first}List(list);
			}
		}catch(Exception e){}

		</#list>
		</#if>


		return ${table.javaName?uncap_first}BO;

	}





	@Override
	public List<${table.javaName}BO> processResult(List<${table.javaName}BO> ${table.javaName?uncap_first}BOs) {
		if(${table.javaName?uncap_first}BOs == null || ${table.javaName?uncap_first}BOs.isEmpty()){
			return ${table.javaName?uncap_first}BOs;
		}

	<#if (exFkColumnMap?exists && exFkColumnMap?size > 0 )>
	<#list exFkColumnMap?keys as key>
	<#if exFkColumnMap[key][0].originalColumnFk == '1'>
	<#assign fkTable = exFkColumnMap[key][0].originalColumn.fkTableConfig >
		List<String> ${exFkColumnMap[key][0].originalColumn.javaName}List = new ArrayList<String>();
	</#if>
	</#list>

	<#if exFkColumnMap?exists>
		for(${table.javaName}BO bo : ${table.javaName?uncap_first}BOs)		{

	<#list exFkColumnMap?keys as key>
	<#if exFkColumnMap[key][0].originalColumnFk == '1'>
	<#assign fkTable = exFkColumnMap[key][0].originalColumn.fkTableConfig >
			if(StringUtils.isNotEmpty( bo.get${exFkColumnMap[key][0].originalColumn.javaName?cap_first}())){
				${exFkColumnMap[key][0].originalColumn.javaName}List.add(bo.get${exFkColumnMap[key][0].originalColumn.javaName?cap_first}());
			}
	</#if>
	</#list>
		}
	</#if>

	<#list exFkColumnMap?keys as key>
		<#if exFkColumnMap[key][0].originalColumnFk == '1'>
		<#assign fkTable = exFkColumnMap[key][0].originalColumn.fkTableConfig >

		if(!${exFkColumnMap[key][0].originalColumn.javaName}List.isEmpty()){
			List<${fkTable.javaName}BO> list =  ${exFkColumnMap[key][0].originalColumn.fkTableConfig.javaName?uncap_first}DAO.selectBatchIds(${exFkColumnMap[key][0].originalColumn.javaName}List);
			Map<String,${fkTable.javaName}BO> map = EntityUtil.list2Map(list);

			${table.javaName?uncap_first}BOs.forEach(${table.javaName?uncap_first}BO -> {
				if(StringUtils.isNotEmpty( ${table.javaName?uncap_first}BO.get${exFkColumnMap[key][0].originalColumn.javaName?cap_first}())){
					${fkTable.javaName}BO temp = map.get( ${table.javaName?uncap_first}BO.get${exFkColumnMap[key][0].originalColumn.javaName?cap_first}() );
					if(temp != null){
						<#list exFkColumnMap[key] as val>
							${table.javaName?uncap_first}BO.set${val.javaName?cap_first}(temp.get${val.fkJavaName?cap_first}());
						</#list>
					}
				}
			});
		}
		</#if>
	</#list>
	</#if>





	<#if (exDictColumnMap?exists && exDictColumnMap?size > 0 )>
		String[] dictTypes = new String[]{<#list exDictColumnMap?keys as key><#if exDictColumnMap[key][0].originalColumnDict == '1'>EnumDictType.${exDictColumnMap[key][0].originalColumn.dictType?upper_case}.getVal()<#if key_has_next>,</#if></#if></#list>};
		Map<String , TsDictBO> dictMap = tsDictService.allDict(dictTypes);

		${table.javaName?uncap_first}BOs.forEach(${table.javaName?uncap_first}BO -> {
		<#list exDictColumnMap?keys as key>
		<#if exDictColumnMap[key][0].originalColumnDict == '1'>
			if(StringUtils.isEmpty(${table.javaName?uncap_first}BO.get${exDictColumnMap[key][0].javaName?cap_first}()) && StringUtils.isNotEmpty(${table.javaName?uncap_first}BO.get${exDictColumnMap[key][0].originalColumn.javaName?cap_first}()) ) {
				TsDictBO dict = dictMap.get(EnumDictType.${exDictColumnMap[key][0].originalColumn.dictType?upper_case}.getVal() + ${table.javaName?uncap_first}BO.get${exDictColumnMap[key][0].originalColumn.javaName?cap_first}());
				if(dict != null) {
					${table.javaName?uncap_first}BO.set${exDictColumnMap[key][0].javaName?cap_first}(dict.getDictName());
				}
			}
		</#if>
		</#list>
		});
	</#if>
		return ${table.javaName?uncap_first}BOs;
	}
	</#if>


	@Override
	public void isExist(${table.javaName}BO ${table.javaName?uncap_first}BO) {
	<#if (table.isTable == "1" && table.isReal == '0'  && indexs?exists && indexs?size > 0) >

		${table.javaName}BO ckBO ;
		${table.javaName}BO temp = null ;

		<#list indexs as index>
			ckBO = new ${table.javaName}BO();
			ckBO.setId( ${table.javaName?uncap_first}BO.getId() );
			<#list index.columns as col>
				ckBO.${col.setMethodName}(${table.javaName?uncap_first}BO.${col.getMethodName}());
			</#list>
			temp = this.selectCheck(ckBO);
			if (EntityUtil.isEntityExist(temp)) {
			throw new BizException(EnumErrorMsg.business_error.getCode(),"${index.tipMsg}");
			}

		</#list>

	</#if>
	}



	<#if table.isReal == '1'>

	<#assign fkColumn1 = columns[1]>
	<#assign fkColumn2 = columns[2]>

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveBatchRelevance(List<${table.javaName}BO> list, ${table.javaName}BO t) {
		if(t == null || (EntityUtil.isEmpty(t.get${fkColumn1.javaName?cap_first}()) && EntityUtil.isEmpty(t.get${fkColumn2.javaName?cap_first}()) )){
			throw EnumErrorMsg.param_format_error.toException();
		}

		if(!EntityUtil.isEmpty(t.get${fkColumn1.javaName?cap_first}())){
			QueryWrapper<${table.javaName}BO> qw = new QueryWrapper<${table.javaName}BO>();
			qw.eq("${fkColumn1.columnName}", t.get${fkColumn1.javaName?cap_first}());
			this.getDAO().delete(qw);
			if(list != null && !list.isEmpty()){
				for(${table.javaName}BO bo : list){
					bo.set${fkColumn1.javaName?cap_first}(t.get${fkColumn1.javaName?cap_first}());
					if(EntityUtil.isEmpty(bo.getId())){
						bo.setId(IdUtils.getId());
					}
				}
				this.saveBatch(list);
			}
		}else if(!EntityUtil.isEmpty(t.get${fkColumn2.javaName?cap_first}())){
			QueryWrapper<${table.javaName}BO> qw = new QueryWrapper<${table.javaName}BO>();
			qw.eq("${fkColumn2.columnName}", t.get${fkColumn2.javaName?cap_first}());
			this.getDAO().delete(qw);
			if(list != null && !list.isEmpty()){
				for(${table.javaName}BO bo : list){
					bo.set${fkColumn2.javaName?cap_first}(t.get${fkColumn2.javaName?cap_first}());
					if(EntityUtil.isEmpty(bo.getId())){
						bo.setId(IdUtils.getId());
					}
				}
				this.saveBatch(list);
			}
		}else {
			throw EnumErrorMsg.param_format_error.toException();
		}
	}
	</#if>


}