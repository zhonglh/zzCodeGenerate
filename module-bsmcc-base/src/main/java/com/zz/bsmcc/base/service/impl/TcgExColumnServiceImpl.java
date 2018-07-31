package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgExColumnService;
import com.zz.bsmcc.base.dao.TcgExColumnDAO;
import com.zz.bsmcc.base.bo.TcgExColumnBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgExColumnServiceImpl extends BaseServiceImpl<TcgExColumnBO,String> implements TcgExColumnService {


	@Autowired
	private TcgExColumnDAO tcgExColumnDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgExColumnDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgExColumnDAO;
	}
}
