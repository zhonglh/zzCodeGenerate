package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgProjectService;
import com.zz.bsmcc.base.dao.TcgProjectDAO;
import com.zz.bsmcc.base.domain.TcgProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgProjectServiceImpl extends BaseServiceImpl<TcgProjectEntity,String> implements TcgProjectService {


	@Autowired
	private TcgProjectDAO tcgProjectDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgProjectDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgProjectDAO;
	}
}
