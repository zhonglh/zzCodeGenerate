package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.enums.*;

import com.zz.bms.system.service.TsDictService;
import com.zz.bms.system.bo.TsDictBO;
import com.zz.bms.core.db.entity.*;

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



<#if table.isReal == '1'>
	<#assign fkColumn1 = columns[1]>
	<#assign fkColumn2 = columns[2]>
import ${columns[1].fkTableConfig.fullPackageName}.service.${columns[1].fkTableConfig.javaName}Service;
import ${columns[2].fkTableConfig.fullPackageName}.service.${columns[2].fkTableConfig.javaName}Service;


import ${columns[1].fkTableConfig.fullPackageName}.bo.${columns[1].fkTableConfig.javaName}BO;
import ${columns[2].fkTableConfig.fullPackageName}.bo.${columns[2].fkTableConfig.javaName}BO;
</#if>

import com.zz.bms.util.base.java.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * ${table.tableComment} 控制层
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



	@Override
	public void setCustomInfoByInsert(${table.javaName}<#if (table.pageChildTables?exists && table.pageChildTables?size > 0 )>Group</#if>BO bo , ILoginUserEntity sessionUser){
		<#list columnPages as page>
		    <#if page.defaultType?exists && page.defaultType == 'CUSTOM'>
				<#if page.columnConfig?exists>
					bo.${page.columnConfig.setMethodName}(<#if page.defaultValue?exists>${page.theDefaultValue}</#if>);
				</#if>
		    </#if>
		</#list>
	}

	<#if (table.dictTypes?exists && table.dictTypes?size > 0) >
	@Override
	protected void setCommonData(${table.javaName}<#if (table.pageChildTables?exists && table.pageChildTables?size > 0 )>Group</#if>BO ${table.javaName?uncap_first}BO ,ModelMap model) {
    	Map<String , List<TsDictBO>> dictMap = tsDictService.allDicts(<#list table.dictTypes as dictType>EnumDictType.${dictType?upper_case}.getVal()<#if dictType_has_next>,</#if></#list>);
        for(Map.Entry<String , List<TsDictBO>> dictObj : dictMap.entrySet()){
        	model.put(dictObj.getKey()+"_dicts", dictObj.getValue());
        }
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
