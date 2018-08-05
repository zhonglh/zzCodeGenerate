package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;



import com.zz.bsmcc.base.bo.TcgTempletBO;
import com.zz.bsmcc.base.bo.TcgTempletGroupBO;
import com.zz.bsmcc.base.domain.TcgTempletGroupEntity;
import com.zz.bsmcc.base.query.TcgTempletGroupQuery;
import com.zz.bsmcc.base.query.TcgTempletQuery;
import com.zz.bsmcc.base.query.impl.TcgTempletGroupQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletQueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import com.zz.bsmcc.base.service.TcgTempletGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:20
 */
@RequestMapping("/templet")
@Controller
public class TcgTempletController extends ZzccBaseController<TcgTempletBO, String , TcgTempletQueryWebImpl> {

	@Autowired
	private TcgTempletGroupService tcgTempletGroupService;


	@Override
	protected void setCommonData(TcgTempletBO m, ModelMap model) {
		List<Map<String,String>> fileTypes = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","java");
		map.put("value","java");
		fileTypes.add(map);

		map = new HashMap<String,String>();
		map.put("name","js");
		map.put("value","js");
		fileTypes.add(map);

		map = new HashMap<String,String>();
		map.put("name","jsp");
		map.put("value","jsp");
		fileTypes.add(map);

		map = new HashMap<String,String>();
		map.put("name","vue");
		map.put("value","vue");
		fileTypes.add(map);

		map = new HashMap<String,String>();
		map.put("name","sql");
		map.put("value","sql");
		fileTypes.add(map);

		TcgTempletGroupQuery groupQuery = new TcgTempletGroupQueryImpl();
		List<TcgTempletGroupBO> groups = tcgTempletGroupService.selectList(groupQuery.buildWrapper());


		model.put("fileTypes" , fileTypes);
		model.put("groups" , groups);
	}


	@Override
	protected boolean isExist(TcgTempletBO tcgTempletBO) {
		return false;
	}



}
