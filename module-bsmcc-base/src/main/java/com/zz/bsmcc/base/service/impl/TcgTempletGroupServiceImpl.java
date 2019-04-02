package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgTempletGroupService;
import com.zz.bsmcc.base.dao.TcgTempletGroupDAO;
import com.zz.bsmcc.base.bo.TcgTempletGroupBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgTempletGroupServiceImpl extends BaseServiceImpl<TcgTempletGroupBO,String> implements TcgTempletGroupService {


	@Autowired
	private TcgTempletGroupDAO tcgTempletGroupDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgTempletGroupDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgTempletGroupDAO;
	}

	@Override
	public void isExist(TcgTempletGroupBO tcgTempletGroupBO) {

	}
}
