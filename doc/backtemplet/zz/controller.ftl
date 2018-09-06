package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;



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



	<#if (indexs?exists && indexs?size > 0) >
	@Override
	protected boolean isExist(${table.javaName}BO ${table.javaName?uncap_first}BO) {

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
        if (isEntityExist(temp)) {return true;}
		</#list>

		return isExist;
	}
	</#if>


	<#if (table.dictTypes?exists && table.dictTypes?size > 0) >
	@Override
	protected void setCommonData(${table.javaName}BO ${table.javaName?uncap_first}BO bo ,ModelMap model) {

		<#list table.dictTypes as dictType>
			//todo ，处理字典 ${dictType}
		</#list>
	}

	</#if>


}
