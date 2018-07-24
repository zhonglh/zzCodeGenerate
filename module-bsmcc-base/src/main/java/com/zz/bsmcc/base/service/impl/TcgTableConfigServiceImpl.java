package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgTableConfigService;
import com.zz.bsmcc.base.dao.TcgTableConfigDAO;
import com.zz.bsmcc.base.bo.TcgTableConfigBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgTableConfigServiceImpl extends BaseServiceImpl<TcgTableConfigBO,String> implements TcgTableConfigService {


	@Autowired
	private TcgTableConfigDAO tcgTableConfigDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgTableConfigDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgTableConfigDAO;
	}
}
