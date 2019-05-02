package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bms.enums.EnumYesNo;
import com.zz.bsmcc.base.bo.TcgExColumnBO;
import com.zz.bsmcc.base.bo.TcgTempletBO;
import com.zz.bsmcc.base.service.TcgOperationService;
import com.zz.bsmcc.base.dao.TcgOperationDAO;
import com.zz.bsmcc.base.bo.TcgOperationBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
*/
@Service
public class TcgOperationServiceImpl extends BaseServiceImpl<TcgOperationBO,String> implements TcgOperationService {


	@Autowired
	private TcgOperationDAO tcgOperationDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgOperationDAO;
	}


	@Override
	public void isExist(TcgOperationBO tcgOperationBO) {

	}



	@Override
	public List<TcgOperationBO> processResult(List<TcgOperationBO> tcgOperationBOs){
		for(TcgOperationBO bo : tcgOperationBOs){
			processResult(bo);
		}
		return tcgOperationBOs;
	}

	@Override
	public TcgOperationBO processResult(TcgOperationBO tcgOperationBO) {
		if (tcgOperationBO == null) {
			return null;
		}

		if(EnumYesNo.YES.getCode().equals(tcgOperationBO.getIsDefault())){
			tcgOperationBO.setIsDefaultName(EnumYesNo.YES.getName());
		}else if(EnumYesNo.NO.getCode().equals(tcgOperationBO.getIsDefault())){
			tcgOperationBO.setIsDefaultName(EnumYesNo.NO.getName());
		}

		return tcgOperationBO;
	}
}
