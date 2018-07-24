package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgModuleConfigService;
import com.zz.bsmcc.base.dao.TcgModuleConfigDAO;
import com.zz.bsmcc.base.domain.TcgModuleConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgModuleConfigServiceImpl extends BaseServiceImpl<TcgModuleConfigEntity,String> implements TcgModuleConfigService {


	@Autowired
	private TcgModuleConfigDAO tcgModuleConfigDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgModuleConfigDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgModuleConfigDAO;
	}
}
