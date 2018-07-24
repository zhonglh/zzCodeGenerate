package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgQueryConfigService;
import com.zz.bsmcc.base.dao.TcgQueryConfigDAO;
import com.zz.bsmcc.base.bo.TcgQueryConfigBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgQueryConfigServiceImpl extends BaseServiceImpl<TcgQueryConfigBO,String> implements TcgQueryConfigService {


	@Autowired
	private TcgQueryConfigDAO tcgQueryConfigDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgQueryConfigDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgQueryConfigDAO;
	}
}
