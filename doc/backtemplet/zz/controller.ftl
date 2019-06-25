package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.enums.*;

import com.zz.bms.system.service.TsDictService;
import com.zz.bms.system.bo.TsDictBO;
import com.zz.bms.core.db.entity.*;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ${table.fullPackageName}.bo.${table.javaName}BO;
import  ${table.fullPackageName}.query.impl.${table.javaName}QueryWebImpl;

<#if (table.reciprocalView?exists  )>
import  ${table.reciprocalView.fullPackageName}.query.impl.${table.reciprocalView.javaName}QueryWebImpl;
import ${table.reciprocalView.fullPackageName}.bo.${table.reciprocalView.javaName}BO;
</#if>


<#if (table.pageChildTables?exists && table.pageChildTables?size > 0 )>
import ${table.fullPackageName}.bo.${table.javaName}GroupBO;
</#if>


<#if (table.reciprocalView?exists  ) && (table.pageChildTables?exists && table.pageChildTables?size > 0 )>
import com.zz.bms.system.controller.ZzGroupDefaultController;
<#elseif (table.reciprocalView?exists  )>
import com.zz.bms.system.controller.ZzDefaultController;
<#elseif (table.pageChildTables?exists && table.pageChildTables?size > 0 )>
import com.zz.bms.system.controller.ZzGroupDefaultSimpleController;
<#else >
import com.zz.bms.system.controller.ZzDefaultSimpleController;
</#if>


<#list table.pageChildColumns as childColumn>
<#if childColumn.tableBO.tableRelation?exists && 'one-multi' == childColumn.tableBO.tableRelation>
import	${childColumn.tableBO.fullPackageName}.bo.${childColumn.tableBO.javaName}BO;
import	${childColumn.tableBO.fullPackageName}.query.impl.${childColumn.tableBO.javaName}QueryWebImpl;
</#if>
</#list>



<#if table.isReal == '1'>
	<#assign fkColumn1 = columns[1]>
	<#assign fkColumn2 = columns[2]>
import ${columns[1].fkTableConfig.fullPackageName}.service.${columns[1].fkTableConfig.javaName}Service;
import ${columns[2].fkTableConfig.fullPackageName}.service.${columns[2].fkTableConfig.javaName}Service;


import ${columns[1].fkTableConfig.fullPackageName}.bo.${columns[1].fkTableConfig.javaName}BO;
import ${columns[2].fkTableConfig.fullPackageName}.bo.${columns[2].fkTableConfig.javaName}BO;
</#if>

<#list table.pageChildColumns as childColumn>
<#if childColumn.tableBO.tableRelation?exists && 'one-multi' == childColumn.tableBO.tableRelation>
import ${childColumn.tableBO.fullPackageName}.service.${childColumn.tableBO.javaName?cap_first}Service;

</#if>
</#list>

import com.zz.bms.util.base.java.IdUtils;
import com.zz.bms.util.poi.ExcelDictHolder;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <h1>${table.tableComment} 控制层</h1>
* @author ${project.projectAuthor}
* @date ${.now}
 */
@RequestMapping("${table.fullResourceName}")
@Controller


<#if (table.reciprocalView?exists  ) && (table.pageChildTables?exists && table.pageChildTables?size > 0 )>
public class ${table.javaName}Controller extends ZzGroupDefaultController<${table.javaName}GroupBO,${table.reciprocalView.javaName}GroupBO, String , ${table.javaName}QueryWebImpl , ${table.reciprocalView.javaName}QueryWebImpl> {
<#elseif (table.reciprocalView?exists  )>
public class ${table.javaName}Controller extends ZzDefaultController<${table.javaName}BO,${table.reciprocalView.javaName}BO, String , ${table.javaName}QueryWebImpl , ${table.reciprocalView.javaName}QueryWebImpl> {
<#elseif (table.pageChildTables?exists && table.pageChildTables?size > 0 )>
public class ${table.javaName}Controller extends ZzGroupDefaultSimpleController<${table.javaName}GroupBO, String , ${table.javaName}QueryWebImpl > {
<#else >
public class ${table.javaName}Controller extends ZzDefaultSimpleController<${table.javaName}BO, String , ${table.javaName}QueryWebImpl > {
</#if>

	@Autowired
	private TsDictService tsDictService;


<#list table.pageChildColumns as childColumn>
<#if childColumn.tableBO.tableRelation?exists && 'one-multi' == childColumn.tableBO.tableRelation>
	@Autowired
	private ${childColumn.tableBO.javaName}Service ${childColumn.tableBO.javaName?uncap_first}Service;
</#if>
</#list>

	<#if table.isReal == '1'>
		${columns[1].fkTableConfig.javaName}Service ${columns[1].fkTableConfig.javaName?uncap_first}Service;
		${columns[2].fkTableConfig.javaName}Service ${columns[2].fkTableConfig.javaName?uncap_first}Service;
	</#if>


	<#if (table.isReal == '1' && operations?exists && operations?size <= 0 )>
	public ${table.javaName}Controller(){
		super();
		this.setResourceIdentity("${columns[1].fkTableConfig.fullResource}");
		this.setResourceIdentity("${columns[2].fkTableConfig.fullResource}");
	}
	</#if>

	<#if (table.isReal == '1' && operations?exists && operations?size <= 0 )>
	@Override
	public void assertHasCreatePermission() {
		permissionList.assertHasAnyPermission(new String[]{
			"${columns[1].fkTableConfig.fullResource}:"+ PermissionList.UPDATE_PERMISSION,
			"${columns[2].fkTableConfig.fullResource}:"+ PermissionList.UPDATE_PERMISSION
		});
	}

	@Override
	public void assertHasUpdatePermission() {
		permissionList.assertHasAnyPermission(new String[]{
		"${columns[1].fkTableConfig.fullResource}:"+ PermissionList.UPDATE_PERMISSION,
		"${columns[2].fkTableConfig.fullResource}:"+ PermissionList.UPDATE_PERMISSION
		});
	}

	@Override
	public void assertHasDeletePermission() {
		permissionList.assertHasAnyPermission(new String[]{
		"${columns[1].fkTableConfig.fullResource}:"+ PermissionList.UPDATE_PERMISSION,
		"${columns[2].fkTableConfig.fullResource}:"+ PermissionList.UPDATE_PERMISSION
		});

	}
	</#if>


	<#list table.pageChildColumns as childColumn>
	<#if childColumn.tableBO.tableRelation?exists && 'one-multi' == childColumn.tableBO.tableRelation>
	@RequestMapping(value = "/${childColumn.tableBO.simpleName?uncap_first}/list" , method={ RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public List<${childColumn.tableBO.javaName}BO> ${childColumn.tableBO.simpleName?uncap_first}List(${childColumn.tableBO.javaName}BO m , ${childColumn.tableBO.javaName}QueryWebImpl query,ModelMap modelMap){
		QueryWrapper wrapper =   query.buildWrapper();
		return ${childColumn.tableBO.javaName?uncap_first}Service.list(wrapper);
	}
	</#if>
	</#list>


	<#if table.fileColumns?exists>
	@Override
	protected void customInfoByCreateForm(${table.javaName}<#if (table.pageChildTables?exists && table.pageChildTables?size > 0 )>Group</#if>BO m, ModelMap model) {
		<#list table.fileColumns as fileColumn>
		m.set${fileColumn.javaName?cap_first}(IdUtils.getId());
		</#list>
	}
	</#if>

	@Override
	public void setCustomInfoByInsert(${table.javaName}<#if (table.pageChildTables?exists && table.pageChildTables?size > 0 )>Group</#if>BO bo , ILoginUserEntity sessionUser){
		<#list columnPages as page>
		    <#if page.defaultType?exists && page.defaultType == 'CUSTOM' && page.defaultValue?exists >
				<#if page.columnConfig?exists && page.columnConfig.javaSimpleClass != "Date" && page.columnConfig.javaSimpleClass != "Timestamp">
					<#if page.columnConfig.javaSimpleClass == "String">
					bo.${page.columnConfig.setMethodName}("${page.theDefaultValue}");
					<#else >
					bo.${page.columnConfig.setMethodName}(${page.theDefaultValue});
					</#if>
				</#if>
		    </#if>
		</#list>
	}

	<#if (table.dictAllTypes?exists && table.dictAllTypes?size > 0) >
	@Override
	protected void setCommonData(${table.javaName}<#if (table.pageChildTables?exists && table.pageChildTables?size > 0 )>Group</#if>BO ${table.javaName?uncap_first}BO ,ModelMap model) {
    	Map<String , List<TsDictBO>> dictMap = tsDictService.allDicts(<#list table.dictAllTypes as dictType>EnumDictType.${dictType?upper_case}.getVal()<#if dictType_has_next>,</#if></#list>);
        for(Map.Entry<String , List<TsDictBO>> dictObj : dictMap.entrySet()){
        	model.put(dictObj.getKey()+"_dicts", dictObj.getValue());
        }
	}

	@Override
	public void setDictNames() {
		Map<String , List<String>> dictMap = tsDictService.allDictNames(<#list table.dictAllTypes as dictType>EnumDictType.${dictType?upper_case}.getVal()<#if dictType_has_next>,</#if></#list>);
		ExcelDictHolder.setDictMap(dictMap);
	}
	</#if>






	<#if table.isReal == '1'>



	/**
	* 到关联表类型的列表界面
	* @param m
	* @param modelMap
	* @param request
	* @param response
	* @return
	*/
	@RequestMapping(value = "/toRelevanceList" , method = RequestMethod.GET )
	public String toRelevanceList(${table.javaName}BO m, ModelMap modelMap , HttpServletRequest request, HttpServletResponse response) {

		this.assertHasViewPermission();

		this.baseRwService.processResult(m);
		modelMap.put("entity" ,m);
		modelMap.put("m" ,m);

		if (listAlsoSetCommonData) {
			setCommonData(m,modelMap);
		}

		processQueryString(modelMap,request);

		processPath(modelMap);

		String pageName = this.getRelevanceListPageName();
		if(StringUtils.isEmpty(pageName)){
			pageName = defaultRelevanceListPageName;
		}
		return viewName(pageName);
	}


	/**
	* 保存操作
	* @param ms
	* @param m
	* @param modelMap
	* @param request
	* @param response
	* @return
	*/
	@RequestMapping(value = "/saveRelevanceList", method = RequestMethod.POST , consumes = "application/json")
	@ResponseBody
	public Object saveRelevanceList(@RequestBody List<${table.javaName}BO> ms, ${table.javaName}BO m, ${table.javaName}WebImpl Q, ModelMap modelMap , HttpServletRequest request, HttpServletResponse response) {


		this.assertHasCreatePermission();

		ILoginUserEntity<String> sessionUserVO = getSessionUser();

		if(!EntityUtil.isEmpty(m.get${fkColumn1.javaName?cap_first}())){
			${fkColumn1.fkTableConfig.javaName}BO bo = ${fkColumn1.fkTableConfig.javaName?uncap_first}Service.getById(m.get${fkColumn1.javaName?cap_first}());
			if(bo == null){
				throw EnumErrorMsg.no_auth.toException();
			}


		}else if(!EntityUtil.isEmpty(m.get${fkColumn2.javaName?cap_first}())){
			${fkColumn2.fkTableConfig.javaName}BO bo = ${fkColumn2.fkTableConfig.javaName?uncap_first}Service.getById(m.get${fkColumn2.javaName?cap_first}());
			if(bO == null){
				throw EnumErrorMsg.no_auth.toException();
			}

		}else {
			throw EnumErrorMsg.param_format_error.toException();
		}

		this.baseRwService.saveBatchRelevance(ms , m );

		AjaxJson result =  AjaxJson.ok();
		return result;
	}

	</#if>


}
