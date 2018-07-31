package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgTempletGroupOperationService;
import com.zz.bsmcc.base.dao.TcgTempletGroupOperationDAO;
import com.zz.bsmcc.base.bo.TcgTempletGroupOperationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgTempletGroupOperationServiceImpl extends BaseServiceImpl<TcgTempletGroupOperationBO,String> implements TcgTempletGroupOperationService {


	@Autowired
	private TcgTempletGroupOperationDAO tcgTempletGroupOperationDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgTempletGroupOperationDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgTempletGroupOperationDAO;
	}
}
