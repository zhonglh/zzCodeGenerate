package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgOperationService;
import com.zz.bsmcc.base.dao.TcgOperationDAO;
import com.zz.bsmcc.base.domain.TcgOperationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgOperationServiceImpl extends BaseServiceImpl<TcgOperationEntity,String> implements TcgOperationService {


	@Autowired
	private TcgOperationDAO tcgOperationDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgOperationDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgOperationDAO;
	}
}
