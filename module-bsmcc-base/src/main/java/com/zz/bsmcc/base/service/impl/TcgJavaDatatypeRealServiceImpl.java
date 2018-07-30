package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.dao.TcgJavaDatatypeRealDAO;
import com.zz.bsmcc.base.service.TcgJavaDatatypeRealService;
import com.zz.bsmcc.base.bo.TcgJavaDatatypeRealBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgJavaDatatypeRealServiceImpl extends BaseServiceImpl<TcgJavaDatatypeRealBO,String> implements TcgJavaDatatypeRealService {


	@Autowired
	private TcgJavaDatatypeRealDAO tcgJavaDatatypeRealDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgJavaDatatypeRealDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgJavaDatatypeRealDAO;
	}
}
