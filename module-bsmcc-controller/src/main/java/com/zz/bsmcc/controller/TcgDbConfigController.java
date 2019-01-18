package com.zz.bsmcc.controller;

import com.zz.bsmcc.base.bo.TcgDbConfigBO;
import com.zz.bsmcc.base.query.impl.TcgDbConfigQueryWebImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 连接池设置 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:18
 */
@RequestMapping("/db/config")
@Controller
public class TcgDbConfigController extends ZzccBaseController<TcgDbConfigBO, String , TcgDbConfigQueryWebImpl> {




	@Override
	protected void isExist(TcgDbConfigBO tcgDbConfigBO) {

	}



}
