package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.dao.TcgColumnConfigDAO;
import com.zz.bsmcc.base.dao.TcgColumnPageDAO;
import com.zz.bsmcc.base.dao.TcgExColumnDAO;
import com.zz.bsmcc.base.service.TcgColumnValidateService;
import com.zz.bsmcc.base.dao.TcgColumnValidateDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
*/
@Service
public class TcgColumnValidateServiceImpl extends BaseServiceImpl<TcgColumnValidateBO,String> implements TcgColumnValidateService {


	@Autowired
	private TcgColumnConfigDAO tcgColumnConfigDAO ;
	@Autowired
	private TcgExColumnDAO tcgExColumnDAO ;

	@Autowired
	private TcgColumnValidateDAO tcgColumnValidateDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgColumnValidateDAO;
	}


	@Override
	public void isExist(TcgColumnValidateBO tcgColumnValidateBO) {

	}



	@Override
	public List<TcgColumnValidateBO> processResult(List<TcgColumnValidateBO> tcgColumnValidateBOs){
		for(TcgColumnValidateBO bo : tcgColumnValidateBOs){
			processResult(bo);
		}
		return tcgColumnValidateBOs;
	}

	@Override
	public TcgColumnValidateBO processResult(TcgColumnValidateBO tcgColumnValidateBO) {
		if(StringUtils.isNotEmpty(tcgColumnValidateBO.getColumnId())){
			TcgColumnConfigBO TcgColumnConfigBO = tcgColumnConfigDAO.selectById(tcgColumnValidateBO.getColumnId());
			if(TcgColumnConfigBO != null){
				tcgColumnValidateBO.setColumnComment(TcgColumnConfigBO.getColumnComment());
			}else {
				TcgExColumnBO tcgExColumnBO = tcgExColumnDAO.selectById(tcgColumnValidateBO.getColumnId());
				if(tcgExColumnBO != null){
					tcgColumnValidateBO.setColumnComment(tcgExColumnBO.getColumnTitle());
				}
			}
		}
		return tcgColumnValidateBO;
	}
}
