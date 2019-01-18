package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bsmcc.base.bo.TcgModuleConfigBO;
import com.zz.bsmcc.base.bo.TcgProjectBO;
import com.zz.bsmcc.base.query.TcgModuleConfigQuery;
import com.zz.bsmcc.base.query.impl.TcgModuleConfigQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgModuleConfigQueryWebImpl;
import com.zz.bsmcc.base.service.TcgProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	protected void isExist(TcgModuleConfigBO tcgModuleConfigBO) {

	}




	@Override
	protected void setCommonData(TcgModuleConfigBO tcgModuleConfigBO , ModelMap model) {

		String projectId = tcgModuleConfigBO.getProjectId();

		List<TcgProjectBO> projects = tcgProjectService.list();
		model.put("projects" , projects);

		TcgModuleConfigQuery query = new TcgModuleConfigQueryImpl();
		if(StringUtils.isNotEmpty(tcgModuleConfigBO.getId())) {
			query.idNot(tcgModuleConfigBO.getId());
		}
		if(StringUtils.isEmpty(projectId) && projects != null && !projects.isEmpty()) {
			projectId = projects.get(0).getId();
		}

		query.projectId(projectId);

		QueryWrapper wrapper = query.buildWrapper() ;
		wrapper.orderByDesc("create_time" );
		List<TcgModuleConfigBO> modules =  this.baseService.list(wrapper);
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

		QueryWrapper wrapper = query.buildWrapper() ;
		wrapper.orderByDesc("create_time" );
		return  this.baseService.list(wrapper);
	}


	@Override
	protected void processBO(TcgModuleConfigBO m) {
		if(m.getId() != null && m.getPid() != null){
			if(m.getId().equalsIgnoreCase(m.getPid())){
				throw new BizException("上级模块不能是自己， 请重新选择上级模块！");
			}

			TcgModuleConfigBO parent = this.baseService.getById(m.getPid());
			List<String> pids = new ArrayList<String>();
			if(parent != null){
				getParents(pids , parent.getId());
			}

			if(!pids.isEmpty() && pids.contains(m.getId())){
				throw new BizException("上级模块不能是自己的下级， 请重新选择上级模块！");
			}
		}
	}

	private void  getParents(List<String> pids,String id){

		pids.add(id);
		TcgModuleConfigBO bo = this.baseService.getById(id);
		if(bo != null && StringUtils.isNotEmpty(bo.getPid())){
			getParents(pids , bo.getPid());
		}
	}


	@Override
	protected void processResult(List<TcgModuleConfigBO> records) {



	}




}
