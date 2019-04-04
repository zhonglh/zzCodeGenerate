package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bsmcc.base.bo.TcgTableConfigBO;
import com.zz.bsmcc.base.service.TcgColumnConfigService;
import com.zz.bsmcc.base.dao.TcgColumnConfigDAO;
import com.zz.bsmcc.base.bo.TcgColumnConfigBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgColumnConfigServiceImpl extends BaseServiceImpl<TcgColumnConfigBO,String> implements TcgColumnConfigService {


	@Autowired
	private TcgColumnConfigDAO tcgColumnConfigDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgColumnConfigDAO;
	}


	@Override
	public void isExist(TcgColumnConfigBO tcgColumnConfigBO) {

	}

	@Override
	public TcgColumnConfigBO processResult(TcgColumnConfigBO tcgColumnConfigBO) {
		if(StringUtils.isNotEmpty(tcgColumnConfigBO.getColumnIsnull())){
			if(EnumYesNo.YES.getCode().equals(tcgColumnConfigBO.getColumnIsnull())){
				tcgColumnConfigBO.setColumnIsnullName(EnumYesNo.YES.getName());
			}else {
				tcgColumnConfigBO.setColumnIsnullName(EnumYesNo.NO.getName());
			}
		}

		if(StringUtils.isNotEmpty(tcgColumnConfigBO.getFkColumnName())){
			tcgColumnConfigBO.setFkJavaName(StringFormatKit.toCamelCase(tcgColumnConfigBO.getFkColumnName()));
		}


		if(StringUtils.isNotEmpty(tcgColumnConfigBO.getJavaFullClass())){
			try {
				tcgColumnConfigBO.setJavaClass(Class.forName(tcgColumnConfigBO.getJavaFullClass()));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return tcgColumnConfigBO;
	}
}
