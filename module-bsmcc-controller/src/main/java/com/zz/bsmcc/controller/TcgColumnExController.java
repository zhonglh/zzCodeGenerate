package com.zz.bsmcc.controller;

import com.zz.bsmcc.base.bo.TcgColumnExBO;
import com.zz.bsmcc.base.query.impl.TcgColumnExQueryWebImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 列扩展 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:18
 */
@RequestMapping("/column/ex")
@Controller
public class TcgColumnExController extends ZzccBaseController<TcgColumnExBO, String , TcgColumnExQueryWebImpl> {




	@Override
	protected void isExist(TcgColumnExBO tcgColumnExBO) {

	}



}
