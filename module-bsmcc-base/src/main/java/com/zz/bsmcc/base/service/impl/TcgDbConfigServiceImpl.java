package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgDbConfigService;
import com.zz.bsmcc.base.dao.TcgDbConfigDAO;
import com.zz.bsmcc.base.bo.TcgDbConfigBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgDbConfigServiceImpl extends BaseServiceImpl<TcgDbConfigBO,String> implements TcgDbConfigService {


	@Autowired
	private TcgDbConfigDAO tcgDbConfigDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgDbConfigDAO;
	}


	@Override
	public void isExist(TcgDbConfigBO tcgDbConfigBO) {

	}
}
