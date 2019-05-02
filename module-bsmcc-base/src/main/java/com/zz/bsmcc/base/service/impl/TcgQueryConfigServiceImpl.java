package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.dao.TcgColumnConfigDAO;
import com.zz.bsmcc.base.dao.TcgExColumnDAO;
import com.zz.bsmcc.base.service.TcgQueryConfigService;
import com.zz.bsmcc.base.dao.TcgQueryConfigDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
*/
@Service
public class TcgQueryConfigServiceImpl extends BaseServiceImpl<TcgQueryConfigBO,String> implements TcgQueryConfigService {


	@Autowired
	private TcgColumnConfigDAO tcgColumnConfigDAO ;


	@Autowired
	private TcgExColumnDAO tcgExColumnDAO ;


	@Autowired
	private TcgQueryConfigDAO tcgQueryConfigDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgQueryConfigDAO;
	}


	@Override
	public void isExist(TcgQueryConfigBO tcgQueryConfigBO) {

	}


	@Override
	public List<TcgQueryConfigBO> processResult(List<TcgQueryConfigBO> bos){
		for(TcgQueryConfigBO bo : bos){
			processResult(bo);
		}
		return bos;
	}

	@Override
	public TcgQueryConfigBO processResult(TcgQueryConfigBO tcgQueryConfigBO) {
		if(StringUtils.isNotEmpty(tcgQueryConfigBO.getColumnId())) {
			TcgColumnConfigBO TcgColumnConfigBO = tcgColumnConfigDAO.selectById(tcgQueryConfigBO.getColumnId());
			if (TcgColumnConfigBO != null) {
				tcgQueryConfigBO.setColumnComment(TcgColumnConfigBO.getColumnComment());
			}else {
				TcgExColumnBO tcgExColumnBO = tcgExColumnDAO.selectById(tcgQueryConfigBO.getColumnId());
				if(tcgExColumnBO != null){
					tcgQueryConfigBO.setColumnComment(tcgExColumnBO.getColumnTitle());
				}
			}
		}
		return tcgQueryConfigBO;
	}
}
