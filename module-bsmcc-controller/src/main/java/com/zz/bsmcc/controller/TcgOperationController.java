package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;



import com.zz.bsmcc.base.bo.TcgOperationBO;
import com.zz.bsmcc.base.query.impl.TcgOperationQueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 操作表 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:19
 */
@RequestMapping("/operation")
@Controller
public class TcgOperationController extends ZzccBaseController<TcgOperationBO, String , TcgOperationQueryWebImpl> {




	@Override
	protected boolean isExist(TcgOperationBO tcgOperationBO) {
		return false;
	}



}
