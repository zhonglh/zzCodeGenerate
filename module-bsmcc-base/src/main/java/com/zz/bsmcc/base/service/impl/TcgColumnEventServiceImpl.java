package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.bo.TcgColumnConfigBO;
import com.zz.bsmcc.base.bo.TcgColumnValidateBO;
import com.zz.bsmcc.base.bo.TcgExColumnBO;
import com.zz.bsmcc.base.dao.TcgColumnConfigDAO;
import com.zz.bsmcc.base.dao.TcgExColumnDAO;
import com.zz.bsmcc.base.service.TcgColumnEventService;
import com.zz.bsmcc.base.dao.TcgColumnEventDAO;
import com.zz.bsmcc.base.bo.TcgColumnEventBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgColumnEventServiceImpl extends BaseServiceImpl<TcgColumnEventBO,String> implements TcgColumnEventService {


	@Autowired
	private TcgColumnConfigDAO tcgColumnConfigDAO ;
	@Autowired
	private TcgExColumnDAO tcgExColumnDAO ;

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


	@Override
	public void isExist(TcgColumnEventBO tcgColumnEventBO) {

	}

	@Override
	public TcgColumnEventBO processResult(TcgColumnEventBO tcgColumnEventBO) {
		if(StringUtils.isNotEmpty(tcgColumnEventBO.getColumnId())){
			TcgColumnConfigBO TcgColumnConfigBO = tcgColumnConfigDAO.selectById(tcgColumnEventBO.getColumnId());
			if(TcgColumnConfigBO != null){
				tcgColumnEventBO.setColumnComment(TcgColumnConfigBO.getColumnComment());
			}else {
				TcgExColumnBO tcgExColumnBO = tcgExColumnDAO.selectById(tcgColumnEventBO.getColumnId());
				if(tcgExColumnBO != null){
					tcgColumnEventBO.setColumnComment(tcgExColumnBO.getColumnTitle());
				}
			}
		}
		return tcgColumnEventBO;
	}
}
