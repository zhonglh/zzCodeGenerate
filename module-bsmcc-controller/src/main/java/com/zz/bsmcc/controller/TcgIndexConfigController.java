package com.zz.bsmcc.controller;

import com.zz.bsmcc.base.bo.TcgIndexConfigBO;
import com.zz.bsmcc.base.query.impl.TcgIndexConfigQueryWebImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 索引设置 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:19
 */
@RequestMapping("/index/config")
@Controller
public class TcgIndexConfigController extends ZzccBaseController<TcgIndexConfigBO, String , TcgIndexConfigQueryWebImpl> {




	@Override
	protected void isExist(TcgIndexConfigBO tcgIndexConfigBO) {

	}



}
