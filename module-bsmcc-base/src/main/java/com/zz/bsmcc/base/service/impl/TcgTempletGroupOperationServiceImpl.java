package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.bo.TcgOperationBO;
import com.zz.bsmcc.base.bo.TcgTableOperationBO;
import com.zz.bsmcc.base.dao.TcgOperationDAO;
import com.zz.bsmcc.base.service.TcgTempletGroupOperationService;
import com.zz.bsmcc.base.dao.TcgTempletGroupOperationDAO;
import com.zz.bsmcc.base.bo.TcgTempletGroupOperationBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
*/
@Service
public class TcgTempletGroupOperationServiceImpl extends BaseServiceImpl<TcgTempletGroupOperationBO,String> implements TcgTempletGroupOperationService {


	@Autowired
	private TcgOperationDAO tcgOperationDAO;

	@Autowired
	private TcgTempletGroupOperationDAO tcgTempletGroupOperationDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgTempletGroupOperationDAO;
	}


	@Override
	public void isExist(TcgTempletGroupOperationBO tcgTempletGroupOperationBO) {

	}


	@Override
	public List<TcgTempletGroupOperationBO> processResult(List<TcgTempletGroupOperationBO> bos){
		for(TcgTempletGroupOperationBO bo : bos){
			processResult(bo);
		}
		return bos;
	}

	@Override
	public TcgTempletGroupOperationBO processResult(TcgTempletGroupOperationBO t) {
		if(t == null){
			return null;
		}
		if(StringUtils.isNotEmpty(t.getOperationId())){
			TcgOperationBO operationBO = tcgOperationDAO.selectById(t.getOperationId());
			t.setOperationName(operationBO.getOperationName());
			t.setOperationResource(operationBO.getOperationResource());
			t.setOperationBO(operationBO);
		}
		return t;
	}
}
