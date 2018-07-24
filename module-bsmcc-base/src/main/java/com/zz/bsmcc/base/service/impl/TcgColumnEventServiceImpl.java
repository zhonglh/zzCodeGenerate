package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgColumnEventService;
import com.zz.bsmcc.base.dao.TcgColumnEventDAO;
import com.zz.bsmcc.base.domain.TcgColumnEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgColumnEventServiceImpl extends BaseServiceImpl<TcgColumnEventEntity,String> implements TcgColumnEventService {


	@Autowired
	private TcgColumnEventDAO tcgColumnEventDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgColumnEventDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgColumnEventDAO;
	}
}
