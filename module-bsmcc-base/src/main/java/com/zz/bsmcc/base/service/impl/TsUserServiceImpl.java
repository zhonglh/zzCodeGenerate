package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TsUserService;
import com.zz.bsmcc.base.dao.TsUserDAO;
import com.zz.bsmcc.base.bo.TsUserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service("tsUserServiceImpl4CG")
public class TsUserServiceImpl extends BaseServiceImpl<TsUserBO,String> implements TsUserService {


	@Autowired
	private TsUserDAO tsUserDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tsUserDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tsUserDAO;
	}

	@Override
	public void isExist(TsUserBO tsUserBO) {

	}
}
