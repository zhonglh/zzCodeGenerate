package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;

import com.zz.bms.system.service.TsDictService;
import com.zz.bms.system.bo.TsDictBO;

import ${table.fullPackageName}.bo.${table.javaName}BO;
import  ${table.fullPackageName}.query.impl.${table.javaName}QueryWebImpl;

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
public class ${table.javaName}Controller extends DefaultController<${table.javaName}BO, String , ${table.javaName}QueryWebImpl> {


	@Autowired
	private TsDictService tsDictService;


	@Override
	protected void isExist(${table.javaName}BO ${table.javaName?uncap_first}BO) {
	<#if (indexs?exists && indexs?size > 0) >

		${table.javaName}BO ckBO ;
		boolean isExist = false;
		${table.javaName}BO temp = null ;

		<#list indexs as index>
		ckBO = new ${table.javaName}BO();
		ckBO.setId( ${table.javaName?uncap_first}BO.getId() );
		<#list index.columns as col>
        ckBO.${col.setMethodName}(${table.javaName?uncap_first}BO.${col.getMethodName}());
		</#list>
        temp = this.baseService.selectCheck(ckBO);
        if (isEntityExist(temp)) {
        	throw new BizException(EnumErrorMsg.business_error.getCode(),"${index.tipMsg}");
		}
		</#list>

	</#if>
	}



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


	<#if table.isTree?exists && table.isTree == '1'>
	@Override
	protected TreeModel buildTreeModel(){
		return new TreeModel().toTreeModel("${table.parentFieldNameCamelCase!}" , "${table.businessNameCamelCase!}");
	}
	</#if>


}
