package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgGroupConfigService;
import com.zz.bsmcc.base.dao.TcgGroupConfigDAO;
import com.zz.bsmcc.base.bo.TcgGroupConfigBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgGroupConfigServiceImpl extends BaseServiceImpl<TcgGroupConfigBO,String> implements TcgGroupConfigService {


	@Autowired
	private TcgGroupConfigDAO tcgGroupConfigDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgGroupConfigDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgGroupConfigDAO;
	}
}
