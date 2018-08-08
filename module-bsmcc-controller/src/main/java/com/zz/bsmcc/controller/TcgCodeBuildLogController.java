package com.zz.bsmcc.controller;

import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.core.vo.AjaxJson;
import com.zz.bsmcc.base.bo.TcgCodeBuildLogBO;
import com.zz.bsmcc.base.bo.TcgProjectBO;
import com.zz.bsmcc.base.bo.TcgTempletBO;
import com.zz.bsmcc.base.bo.TcgTempletGroupBO;
import com.zz.bsmcc.base.query.TcgProjectQuery;
import com.zz.bsmcc.base.query.TcgTempletGroupOperationQuery;
import com.zz.bsmcc.base.query.TcgTempletGroupQuery;
import com.zz.bsmcc.base.query.TcgTempletQuery;
import com.zz.bsmcc.base.query.impl.TcgCodeBuildLogQueryWebImpl;
import com.zz.bsmcc.base.query.impl.TcgProjectQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletGroupQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletQueryImpl;
import com.zz.bsmcc.base.service.TcgProjectService;
import com.zz.bsmcc.base.service.TcgTempletGroupService;
import com.zz.bsmcc.base.service.TcgTempletService;
import com.zz.bsmcc.business.CgBusiness;
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
	private TcgTempletGroupService templetGroupService;

	@Autowired
	private TcgTempletService templetService;

	@Autowired
	private CgBusiness cgBusiness;


	@Override
	protected boolean isExist(TcgCodeBuildLogBO tcgCodeBuildLogBO) {
		return false;
	}

	@Override
	protected void setCommonData(TcgCodeBuildLogBO tcgCodeBuildLogBO, ModelMap model) {
		TcgProjectQuery projectQuery = new TcgProjectQueryImpl();
		List<TcgProjectBO> projects = projectService.selectList(projectQuery.buildWrapper());

		TcgTempletGroupQuery templetGroupQuery = new TcgTempletGroupQueryImpl();
		List<TcgTempletGroupBO> groups = templetGroupService.selectList(templetGroupQuery.buildWrapper());

		model.put("projects" , projects );
		model.put("groups" , groups );
	}


	@RequestMapping(value = "/cg", method = RequestMethod.POST)
	@ResponseBody
	public Object cg(TcgCodeBuildLogBO m, ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		TcgProjectBO projectBO = projectService.selectById(m.getProjectId());

		TcgTempletQuery tcgTempletQuery = new TcgTempletQueryImpl();
		tcgTempletQuery.groupId(m.getTempletGroupId());
		List<TcgTempletBO> templets = templetService.selectList(tcgTempletQuery.buildWrapper());

		if(projectBO == null){
			throw new BizException("项目信息已经不存在了");
		}

		if( templets == null || templets.isEmpty()){
			throw new BizException("请先在该模板组添加模板");
		}

		cgBusiness.cg(projectBO , templets);


		return this.create(m,model, request,  response);

	}



}
