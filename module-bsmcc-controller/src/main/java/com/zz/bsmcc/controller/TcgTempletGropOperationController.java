package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;



import com.zz.bsmcc.base.bo.TcgTempletGropOperationBO;
import com.zz.bsmcc.base.query.impl.TcgTempletGropOperationQueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 模板组操作定义 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:21
 */
@RequestMapping("/templet/grop/operation")
@Controller
public class TcgTempletGropOperationController extends ZzccBaseController<TcgTempletGropOperationBO, String , TcgTempletGropOperationQueryWebImpl> {




	@Override
	protected boolean isExist(TcgTempletGropOperationBO tcgTempletGropOperationBO) {
		return false;
	}



}
