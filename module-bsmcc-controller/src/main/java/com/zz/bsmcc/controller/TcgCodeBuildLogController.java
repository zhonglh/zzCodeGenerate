package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.core.vo.AjaxJson;
import com.zz.bms.shiro.utils.ShiroUtils;



import com.zz.bsmcc.base.bo.TcgCodeBuildLogBO;
import com.zz.bsmcc.base.bo.TcgProjectBO;
import com.zz.bsmcc.base.bo.TcgTempletBO;
import com.zz.bsmcc.base.dao.TcgGroupConfigDAO;
import com.zz.bsmcc.base.dao.TcgProjectDAO;
import com.zz.bsmcc.base.query.TcgTempletQuery;
import com.zz.bsmcc.base.query.impl.TcgCodeBuildLogQueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import com.zz.bsmcc.base.query.impl.TcgTempletQueryImpl;
import com.zz.bsmcc.base.service.TcgGroupConfigService;
import com.zz.bsmcc.base.service.TcgProjectService;
import com.zz.bsmcc.base.service.TcgTempletService;
import com.zz.bsmcc.business.CgBusiness;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 代码生成记录 控制层
 *
 * @author Administrator
 * @date 2018-8-3 11:23:12
 */
@RequestMapping("/code/build/log")
@Controller
public class TcgCodeBuildLogController extends ZzccBaseController<TcgCodeBuildLogBO, String , TcgCodeBuildLogQueryWebImpl> {

	@Autowired
	private TcgProjectService projectService;

	@Autowired
	private TcgTempletService templetService;

	@Autowired
	private CgBusiness cgBusiness;


	@Override
	protected boolean isExist(TcgCodeBuildLogBO tcgCodeBuildLogBO) {
		return false;
	}


	@RequestMapping(
			value = {"/cg"},
			method = {RequestMethod.POST}
	)
	@ResponseBody
	public Object cg(TcgCodeBuildLogBO m, ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		TcgProjectBO projectBO = projectService.selectById(m.getProjectId());

		TcgTempletQuery tcgTempletQuery = new TcgTempletQueryImpl();
		tcgTempletQuery.groupId(m.getTempletGroupId());
		List<TcgTempletBO> templets = templetService.selectList(tcgTempletQuery.buildWrapper());

		if(projectBO == null){
			throw new BizException("项目信息已经不存在了");
		}

		if( templets == null || !templets.isEmpty()){
			throw new BizException("请先在该模板组添加模板");
		}

		cgBusiness.cg(projectBO , templets);

		return AjaxJson.successAjax;



	}



}
