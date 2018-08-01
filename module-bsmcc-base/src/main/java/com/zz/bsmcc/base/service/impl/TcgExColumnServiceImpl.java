package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bsmcc.base.bo.TcgColumnConfigBO;
import com.zz.bsmcc.base.bo.TcgColumnEventBO;
import com.zz.bsmcc.base.service.TcgExColumnService;
import com.zz.bsmcc.base.dao.TcgExColumnDAO;
import com.zz.bsmcc.base.bo.TcgExColumnBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgExColumnServiceImpl extends BaseServiceImpl<TcgExColumnBO,String> implements TcgExColumnService {


	@Autowired
	private TcgExColumnDAO tcgExColumnDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgExColumnDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgExColumnDAO;
	}


	@Override
	public TcgExColumnBO processResult(TcgExColumnBO tcgExColumnBO) {

		if(StringUtils.isNotEmpty(tcgExColumnBO.getOriginalColumnDict())){
			if(EnumYesNo.YES.getCode().equals(tcgExColumnBO.getOriginalColumnDict())){
				tcgExColumnBO.setOriginalColumnDictName(EnumYesNo.YES.getName());
			}else {
				tcgExColumnBO.setOriginalColumnDictName(EnumYesNo.NO.getName());
			}
		}


		if(StringUtils.isNotEmpty(tcgExColumnBO.getOriginalColumnFk())){
			if(EnumYesNo.YES.getCode().equals(tcgExColumnBO.getOriginalColumnFk())){
				tcgExColumnBO.setOriginalColumnFkName(EnumYesNo.YES.getName());
			}else {
				tcgExColumnBO.setOriginalColumnFkName(EnumYesNo.NO.getName());
			}
		}
		return tcgExColumnBO;
	}
}
