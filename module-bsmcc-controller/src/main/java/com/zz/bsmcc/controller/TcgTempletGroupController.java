package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;



import com.zz.bsmcc.base.bo.TcgTempletGroupBO;
import com.zz.bsmcc.base.bo.TcgTempletGroupOperationBO;
import com.zz.bsmcc.base.query.TcgOperationQuery;
import com.zz.bsmcc.base.query.TcgTempletGroupOperationQuery;
import com.zz.bsmcc.base.query.impl.TcgOperationQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletGroupOperationQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletGroupQueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import com.zz.bsmcc.base.service.TcgOperationService;
import com.zz.bsmcc.base.service.TcgTempletGroupOperationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 模板组 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:21
 */
@RequestMapping("/templet/group")
@Controller
public class TcgTempletGroupController extends ZzccBaseController<TcgTempletGroupBO, String , TcgTempletGroupQueryWebImpl> {


	@Autowired
	private TcgTempletGroupOperationService tcgTempletGroupOperationService;


	@Autowired
	private TcgOperationService tcgOperationService;


	@RequestMapping(
			value = {"/{id}/operationsEdit"},
			method = {RequestMethod.GET}
	)
	public String operationsEdit(@PathVariable String id, ModelMap model, HttpServletRequest request, HttpServletResponse response) {


		this.permissionList.assertHasPermission("operationsEdit");


		TcgTempletGroupOperationQuery query = new TcgTempletGroupOperationQueryImpl();
		query.groupId(id);
		List<TcgTempletGroupOperationBO> operationBOS = tcgTempletGroupOperationService.selectList(query.buildWrapper());

		TcgOperationQuery operationQuery = new TcgOperationQueryImpl();
		tcgOperationService.selectList();


		if(operationBOS == null || )



		return viewName("operationsEdit");

	}




	@Override
	protected boolean isExist(TcgTempletGroupBO tcgTempletGroupBO) {
		return false;
	}






}
