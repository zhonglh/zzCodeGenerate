package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgColumnValidateService;
import com.zz.bsmcc.base.dao.TcgColumnValidateDAO;
import com.zz.bsmcc.base.domain.TcgColumnValidateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgColumnValidateServiceImpl extends BaseServiceImpl<TcgColumnValidateEntity,String> implements TcgColumnValidateService {


	@Autowired
	private TcgColumnValidateDAO tcgColumnValidateDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgColumnValidateDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgColumnValidateDAO;
	}
}
