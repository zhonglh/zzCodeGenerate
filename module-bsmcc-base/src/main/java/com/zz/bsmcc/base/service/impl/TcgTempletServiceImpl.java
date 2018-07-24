package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgTempletService;
import com.zz.bsmcc.base.dao.TcgTempletDAO;
import com.zz.bsmcc.base.bo.TcgTempletBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgTempletServiceImpl extends BaseServiceImpl<TcgTempletBO,String> implements TcgTempletService {


	@Autowired
	private TcgTempletDAO tcgTempletDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgTempletDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgTempletDAO;
	}
}
