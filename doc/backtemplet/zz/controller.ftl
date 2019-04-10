package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;

import com.zz.bms.system.service.TsDictService;
import com.zz.bms.system.bo.TsDictBO;

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

import com.zz.bms.util.base.java.IdUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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


	@Override
	public void setCustomInfoByInsert(${table.javaName}BO bo){
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
	protected void setCommonData(${table.javaName}BO ${table.javaName?uncap_first}BO bo ,ModelMap model) {
    	Map<String , List<TsDictBO> dictMap = tsDictService.allDicts(<#list table.dictTypes as dictType>"${dictType}"<#if dictType_has_next>,</#if></#list>);
        for(Map.Entry<String , List<TsDictBO> dictObj : dictMap.entrySet()){
        	model.put(dictObj.getKey()+"_dicts", dictObj.getValue());
        }
	}
	</#if>



}
