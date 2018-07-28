package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
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
import org.springframework.web.bind.annotation.RequestMapping;

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

		List<TcgProjectBO> projects = tcgProjectService.selectList(new EntityWrapper<TcgProjectBO>());
		model.put("projects" , projects);

		TcgModuleConfigQuery query = new TcgModuleConfigQueryImpl();
		if(StringUtils.isNotEmpty(tcgModuleConfigBO.getId())) {
			query.idNot(tcgModuleConfigBO.getId());
		}
		List<TcgModuleConfigBO> modules =  this.baseService.selectList(query.buildWrapper());
		model.put("modules" , modules);

	}




	@Override
	protected void processResult(List<TcgModuleConfigBO> records) {



	}




}
