package ${table.basePackage}.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fullbloom.core.enums.EnumYesNo;
import com.fullbloom.utils.data.DateKit;
import com.fullbloom.core.vo.Pager;
import com.fullbloom.core.vo.AjaxJson;
import com.fullbloom.utils.java.IdUtils;

import com.fullbloom.core.exceptions.DbException;

import com.fullbloom.rbac.domain.TrUserBasicinfo;
import ${table.basePackage}.baseweb.controller.RestfulBaseController;
import ${table.basePackage}.interfaces.${table.shortTableName?cap_first}Service;
import ${table.basePackage}.exceptions.${table.shortTableName?cap_first}Exceptions;
import ${table.basePackage}.domain.${table.shortTableName?cap_first};
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${table.tableComments}控制层
 *
 * @author ${table.author}
 * @date ${.now}
 */
@RestController
@RequestMapping("")
public class ${table.shortTableName?cap_first}Controller
extends DefaultController<${table.shortTableName?cap_first}Entity , String , <${table.shortTableName?cap_first}QueryWebImpl> {




	@Autowired
	private ${table.shortTableName?cap_first}Service ${table.shortTableName}Service;

	/**
	* 新增或者修改时，检验数据是否唯一
	* @param request
	* @param response
	*/
	@RequestMapping( value = "/checkUnique" ,method = RequestMethod.POST)
	public Object checkUnique(HttpServletRequest request  , HttpServletResponse response )  {
		${table.shortTableName?cap_first} ${table.shortTableName} = getObject(request , ${table.shortTableName?cap_first}.class);
		${table.shortTableName?cap_first} temp = ${table.shortTableName}Service.findTopOne4Check(${table.shortTableName});
		if(isEntityExist(temp)) {
			return new AjaxJson(false,"数据重复！");
		}else{
			return AjaxJson.successAjax;
		}
	}



	@RequestMapping( value = "/checkAllUnique" ,method = RequestMethod.POST)
	public Object checkAllUnique(HttpServletRequest request  , HttpServletResponse response )  {
		${table.shortTableName?cap_first} ${table.shortTableName} = getObject(request , ${table.shortTableName?cap_first}.class);
		boolean isExist =  this.isExist(${table.shortTableName});
		if(isExist) {
			return new AjaxJson(false,"数据重复！");
		}else{
			return AjaxJson.successAjax;
		}
	}



	private boolean isExist(${table.shortTableName?cap_first} ${table.shortTableName})  {

		${table.shortTableName?cap_first}  ckEntity = null;
		boolean isExist = false;


		${table.shortTableName?cap_first}  temp = null;

		<#list table.indexList as begin>
		ckEntity = new ${table.shortTableName?cap_first} ();
		<#list begin.javaNames as javaName>
		ckEntity.set${javaName?cap_first}( ${table.shortTableName}.get${javaName?cap_first}() );
		</#list>
        ckEntity.setId( ${table.shortTableName}.getId() );
        temp = ${table.shortTableName}Service.findTopOne4Check(ckEntity);
        if(isEntityExist(temp)) {
			return true;
		}
		</#list>



		<#list table.constraintList as begin>
		ckEntity = new ${table.shortTableName?cap_first} ();
		<#list begin.javaNames as javaName>
		ckEntity.set${javaName?cap_first}( ${table.shortTableName}.get${javaName?cap_first}() );
		</#list>
        ckEntity.setId( ${table.shortTableName}.getId() );
		temp = ${table.shortTableName}Service.findTopOne4Check(ckEntity);
		if(isEntityExist(temp)) {
			return true;
		}
		</#list>

		return isExist;
	}




	/**
	 * 保存${table.tableComments}
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public Object save(HttpServletRequest request, HttpServletResponse response ) {
		${table.shortTableName?cap_first} ${table.shortTableName} = getObject(request , ${table.shortTableName?cap_first}.class);

		if(isExist(${table.shortTableName}) ) {
			throw DbException.DB_SAVE_SAME;
		}

		TrUserBasicinfo loginUser = this.getSessionVO().getTrUserBasicinfo();

		AjaxJson ajaxJson = null;
		String id = ${table.shortTableName}.getId();
		if(StringUtils.isEmpty(id)){
			//保存数据
			${table.shortTableName}.setId(IdUtils.getId());
			<#if table.isSlimple == "NO">
			${table.shortTableName}.setVersionNo(0);
			${table.shortTableName}.setCreateTime(DateKit.getCurrentDate());
			${table.shortTableName}.setUpdateTime(DateKit.getCurrentDate());
			${table.shortTableName}.setCreateUserId(loginUser.getId());
			${table.shortTableName}.setUpdateUserId(loginUser.getId());
			${table.shortTableName}.setDeleteFlag(EnumYesNo.NO.getCode());
			</#if>
			int size = ${table.shortTableName}Service.save(${table.shortTableName});
 			ajaxJson = new AjaxJson(true,"${table.tableComments}保存成功！");
			if (size<=0){
				throw ${table.shortTableName?cap_first}Exceptions.Save_Error;
			}
		}else{
			//修改数据

			<#if table.isSlimple == "NO">
			${table.shortTableName?cap_first} temp = ${table.shortTableName}Service.findById(id);
			${table.shortTableName}.setVersionNo(temp.getVersionNo());

			${table.shortTableName}.setUpdateTime(DateKit.getCurrentDate());
			${table.shortTableName}.setUpdateUserId(loginUser.getId());
			</#if>

			int size = ${table.shortTableName}Service.update(${table.shortTableName});
			ajaxJson = new AjaxJson(true,"${table.tableComments}修改成功！");
			if (size<=0){
				throw ${table.shortTableName?cap_first}Exceptions.Update_Error;
			}
		}
		return ajaxJson;
	}

	/**
	* 查询分页数据
	* @param request
	* @param response
	* @return
	*/
	@RequestMapping(value = "/list" ,method = RequestMethod.GET)
	public Object list( HttpServletRequest request, HttpServletResponse response){

		${table.shortTableName?cap_first} ${table.shortTableName} = getObject(request , ${table.shortTableName?cap_first}.class);

		Pager pager = new Pager();
		processPager(pager , ${table.shortTableName} , request);
		pager = ${table.shortTableName}Service.findPageList(${table.shortTableName},pager);
		return pager2Map(pager);
	}


	/**
	* 明细信息
	* @param id
	* @param request
	* @param response
	* @return
	*/
	@RequestMapping(value = "/detail/{id}" ,method = RequestMethod.GET)
	public Object detail(@PathVariable("id") String id , HttpServletRequest request, HttpServletResponse response){
		Map map = new HashMap<String,Object>();
		${table.shortTableName?cap_first} ${table.shortTableName} = ${table.shortTableName}Service.findById(id);
		map.put("${table.shortTableName}" , ${table.shortTableName});
		return map;

	}



	/**
	* 删除${table.tableComments}
	*
	* @param request
	* @param response
	*/
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public Object delete( HttpServletRequest request, HttpServletResponse response) {

		String ids = getParamString(request,"ids");

		if(ids == null || ids.isEmpty()){
			new AjaxJson(false,"请先选择要删除的记录！");
		}

		String []idString = ids.split(",");
		if(idString == null || idString.length == 0 ){
			new AjaxJson(false,"请先选择要删除的记录！");
		}

		List list = Arrays.asList(idString);

		${table.shortTableName?cap_first} ${table.shortTableName} = new ${table.shortTableName?cap_first}();
		${table.shortTableName}.setQueryIdList(list);

		List<${table.shortTableName?cap_first}> ${table.shortTableName}s = ${table.shortTableName}Service.findList(${table.shortTableName});

		if(${table.shortTableName}s == null || ${table.shortTableName}s.isEmpty()){
			new AjaxJson(false,"该记录您无权删除！");
		}

		AjaxJson ajaxJson = new AjaxJson(true,"投资者删除成功！");
		int size = ${table.shortTableName}Service.delete(${table.shortTableName}s);
		if(size != ${table.shortTableName}s.size()){
			throw ${table.shortTableName?cap_first}Exceptions.Delete_Error;
		}
		return ajaxJson;



	}


}
