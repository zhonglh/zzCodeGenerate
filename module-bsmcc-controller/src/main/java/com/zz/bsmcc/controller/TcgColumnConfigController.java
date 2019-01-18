package com.zz.bsmcc.controller;

import com.zz.bsmcc.base.bo.TcgColumnConfigBO;
import com.zz.bsmcc.base.query.impl.TcgColumnConfigQueryWebImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 列设置 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:16
 */
@RequestMapping("/column/config")
@Controller
public class TcgColumnConfigController extends ZzccBaseController<TcgColumnConfigBO, String , TcgColumnConfigQueryWebImpl> {




	@Override
	protected void isExist(TcgColumnConfigBO tcgColumnConfigBO) {

	}



}
