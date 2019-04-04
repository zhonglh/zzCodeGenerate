package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.TcgIndexConfigService;
import com.zz.bsmcc.base.dao.TcgIndexConfigDAO;
import com.zz.bsmcc.base.bo.TcgIndexConfigBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgIndexConfigServiceImpl extends BaseServiceImpl<TcgIndexConfigBO,String> implements TcgIndexConfigService {


	@Autowired
	private TcgIndexConfigDAO tcgIndexConfigDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgIndexConfigDAO;
	}

	@Override
	public void isExist(TcgIndexConfigBO tcgIndexConfigBO) {

	}
}
