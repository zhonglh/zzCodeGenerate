package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgColumnConfigService;
import com.zz.bsmcc.base.dao.TcgColumnConfigDAO;
import com.zz.bsmcc.base.bo.TcgColumnConfigBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgColumnConfigServiceImpl extends BaseServiceImpl<TcgColumnConfigBO,String> implements TcgColumnConfigService {


	@Autowired
	private TcgColumnConfigDAO tcgColumnConfigDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgColumnConfigDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgColumnConfigDAO;
	}
}
