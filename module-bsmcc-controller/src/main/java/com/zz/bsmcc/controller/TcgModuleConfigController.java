package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.shiro.utils.ShiroUtils;



import com.zz.bsmcc.base.bo.TcgModuleConfigBO;
import com.zz.bsmcc.base.bo.TcgProjectBO;
import com.zz.bsmcc.base.query.TcgModuleConfigQuery;
import com.zz.bsmcc.base.query.TcgQueryConfigQuery;
import com.zz.bsmcc.base.query.impl.TcgModuleConfigQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgModuleConfigQueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import com.zz.bsmcc.base.query.impl.TcgQueryConfigQueryImpl;
import com.zz.bsmcc.base.service.TcgProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 模块设置 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:19
 */
@RequestMapping("/module/config")
@Controller
public class TcgModuleConfigController extends ZzccBaseController<TcgModuleConfigBO, String , TcgModuleConfigQueryWebImpl> {

	@Autowired
	private TcgProjectService tcgProjectService;

	@Override
	protected boolean isExist(TcgModuleConfigBO tcgModuleConfigBO) {
		return false;
	}




	@Override
	protected void setCommonData(TcgModuleConfigBO tcgModuleConfigBO , ModelMap model) {

		String projectId = tcgModuleConfigBO.getProjectId();

		List<TcgProjectBO> projects = tcgProjectService.selectList(new EntityWrapper<TcgProjectBO>());
		model.put("projects" , projects);

		TcgModuleConfigQuery query = new TcgModuleConfigQueryImpl();
		if(StringUtils.isNotEmpty(tcgModuleConfigBO.getId())) {
			query.idNot(tcgModuleConfigBO.getId());
		}
		if(StringUtils.isEmpty(projectId) && projects != null && !projects.isEmpty()) {
			projectId = projects.get(0).getId();
		}

		query.projectId(projectId);

		Wrapper wrapper = query.buildWrapper() ;
		wrapper.orderBy("create_time" , false);
		List<TcgModuleConfigBO> modules =  this.baseService.selectList(wrapper);
		model.put("modules" , modules);

	}

	@RequestMapping(
			value = {"/getModules"},
			method = {RequestMethod.POST}
	)
	@ResponseBody
	public List<TcgModuleConfigBO> getModules( String projectId ,  String id){
		if(StringUtils.isEmpty(projectId)){
			return new ArrayList<TcgModuleConfigBO>();
		}

		TcgModuleConfigQuery query = new TcgModuleConfigQueryImpl();
		query.projectId(projectId);

		if(StringUtils.isNotEmpty(id)){
			query.idNot(id);
		}

		Wrapper wrapper = query.buildWrapper() ;
		wrapper.orderBy("create_time" , false);
		return  this.baseService.selectList(wrapper);
	}


	@Override
	protected void processBO(TcgModuleConfigBO m) {
		if(m.getId() != null && m.getPid() != null){
			if(m.getId().equalsIgnoreCase(m.getPid())){
				throw new BizException("上级模块不能是自己， 请重新选择上级模块！");
			}
		}
	}


	@Override
	protected void processResult(List<TcgModuleConfigBO> records) {



	}




}
