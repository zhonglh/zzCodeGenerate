package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.bo.TcgTableConfigBO;
import com.zz.bsmcc.base.dao.TcgOperationDAO;
import com.zz.bsmcc.base.service.TcgTableOperationService;
import com.zz.bsmcc.base.dao.TcgTableOperationDAO;
import com.zz.bsmcc.base.bo.TcgTableOperationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgTableOperationServiceImpl extends BaseServiceImpl<TcgTableOperationBO,String> implements TcgTableOperationService {

    @Autowired
    private TcgOperationDAO tcgOperationDAO;

	@Autowired
	private TcgTableOperationDAO tcgTableOperationDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgTableOperationDAO;
	}


	@Override
	public void isExist(TcgTableOperationBO tcgTableOperationBO) {

	}

	@Override
    public TcgTableOperationBO processResult(TcgTableOperationBO tcgTableOperationBO) {
        tcgTableOperationBO.setOperationBO(tcgOperationDAO.selectById(tcgTableOperationBO.getOperationId()));
        return tcgTableOperationBO;
    }
}
