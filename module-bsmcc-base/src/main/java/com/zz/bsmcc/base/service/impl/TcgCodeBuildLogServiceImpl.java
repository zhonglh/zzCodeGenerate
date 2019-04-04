package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.dao.TcgProjectDAO;
import com.zz.bsmcc.base.dao.TcgTempletDAO;
import com.zz.bsmcc.base.dao.TcgTempletGroupDAO;
import com.zz.bsmcc.base.query.TcgTempletGroupQuery;
import com.zz.bsmcc.base.service.TcgCodeBuildLogService;
import com.zz.bsmcc.base.dao.TcgCodeBuildLogDAO;
import com.zz.bsmcc.base.service.TcgProjectService;
import com.zz.bsmcc.base.service.TcgTempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgCodeBuildLogServiceImpl extends BaseServiceImpl<TcgCodeBuildLogBO,String> implements TcgCodeBuildLogService {



	@Autowired
	private TcgProjectDAO tcgProjectDAO;

	@Autowired
	private TcgTempletGroupDAO tcgTempletGroupDAO;

	@Autowired
	private TcgCodeBuildLogDAO tcgCodeBuildLogDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgCodeBuildLogDAO;
	}


	@Override
	public void isExist(TcgCodeBuildLogBO tcgCodeBuildLogBO) {

	}

	@Override
	public TcgCodeBuildLogBO processResult(TcgCodeBuildLogBO tcgCodeBuildLogBO) {

		if(tcgCodeBuildLogBO == null){
			return null;
		}

		TcgProjectBO projectBO = tcgProjectDAO.selectById(tcgCodeBuildLogBO.getProjectId());
		if(projectBO != null){
			tcgCodeBuildLogBO.setProjectName(projectBO.getProjectName());
		}

		TcgTempletGroupBO templetGroupBO = tcgTempletGroupDAO.selectById(tcgCodeBuildLogBO.getTempletGroupId());
		if(projectBO != null){
			tcgCodeBuildLogBO.setTempletGroupName(templetGroupBO.getGroupName());
		}

		return tcgCodeBuildLogBO;
	}
}
