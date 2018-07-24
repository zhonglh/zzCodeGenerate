package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;



import com.zz.bsmcc.base.bo.TcgTableConfigBO;
import com.zz.bsmcc.base.query.impl.TcgTableConfigQueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 表设置 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:20
 */
@RequestMapping("/table/config")
@Controller
public class TcgTableConfigController extends DefaultController<TcgTableConfigBO, String , TcgTableConfigQueryWebImpl> {




	@Override
	protected boolean isExist(TcgTableConfigBO tcgTableConfigBO) {
		return false;
	}



}
