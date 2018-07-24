package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgTempletGropOperationService;
import com.zz.bsmcc.base.dao.TcgTempletGropOperationDAO;
import com.zz.bsmcc.base.bo.TcgTempletGropOperationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgTempletGropOperationServiceImpl extends BaseServiceImpl<TcgTempletGropOperationBO,String> implements TcgTempletGropOperationService {


	@Autowired
	private TcgTempletGropOperationDAO tcgTempletGropOperationDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgTempletGropOperationDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgTempletGropOperationDAO;
	}
}
