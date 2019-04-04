package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.bo.TcgModuleConfigBO;
import com.zz.bsmcc.base.bo.TcgTempletGroupBO;
import com.zz.bsmcc.base.dao.TcgTempletGroupDAO;
import com.zz.bsmcc.base.service.TcgTempletService;
import com.zz.bsmcc.base.dao.TcgTempletDAO;
import com.zz.bsmcc.base.bo.TcgTempletBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgTempletServiceImpl extends BaseServiceImpl<TcgTempletBO,String> implements TcgTempletService {

	@Autowired
	private TcgTempletGroupDAO tcgTempletGroupDAO ;

	@Autowired
	private TcgTempletDAO tcgTempletDAO ;


	@Override
	public BaseDAO getDAO() {
	return tcgTempletDAO;
	}


	@Override
	public void isExist(TcgTempletBO tcgTempletBO) {

	}

	@Override
	public TcgTempletBO processResult(TcgTempletBO tcgTempletBO) {
		if (tcgTempletBO == null) {
			return null;
		}

		if(StringUtils.isNotEmpty(tcgTempletBO.getGroupId())){
			TcgTempletGroupBO tcgTempletGroupBO = tcgTempletGroupDAO.selectById(tcgTempletBO.getGroupId());
			if(tcgTempletGroupBO != null){
				tcgTempletBO.setGroupName(tcgTempletGroupBO.getGroupName());
			}
		}


		if(StringUtils.isNotEmpty(tcgTempletBO.getFileInnerDir())){
			String innerPackage = tcgTempletBO.getFileInnerDir();
			innerPackage = innerPackage.replace("/",".");
			innerPackage = innerPackage.replace("\\",".");
			tcgTempletBO.setFileInnerPackage(innerPackage);
		}

		return tcgTempletBO;

	}
}
