package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgColumnExService;
import com.zz.bsmcc.base.dao.TcgColumnExDAO;
import com.zz.bsmcc.base.bo.TcgColumnExBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgColumnExServiceImpl extends BaseServiceImpl<TcgColumnExBO,String> implements TcgColumnExService {


	@Autowired
	private TcgColumnExDAO tcgColumnExDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgColumnExDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgColumnExDAO;
	}
}
