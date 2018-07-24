package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgColumnPageService;
import com.zz.bsmcc.base.dao.TcgColumnPageDAO;
import com.zz.bsmcc.base.bo.TcgColumnPageBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgColumnPageServiceImpl extends BaseServiceImpl<TcgColumnPageBO,String> implements TcgColumnPageService {


	@Autowired
	private TcgColumnPageDAO tcgColumnPageDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgColumnPageDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgColumnPageDAO;
	}
}
