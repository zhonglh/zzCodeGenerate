package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.dao.TcgProjectDAO;
import com.zz.bsmcc.base.domain.TcgModuleConfigEntity;
import com.zz.bsmcc.base.domain.TcgProjectEntity;
import com.zz.bsmcc.base.service.TcgModuleConfigService;
import com.zz.bsmcc.base.dao.TcgModuleConfigDAO;
import com.zz.bsmcc.base.bo.TcgModuleConfigBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
*/
@Service
public class TcgModuleConfigServiceImpl extends BaseServiceImpl<TcgModuleConfigBO,String> implements TcgModuleConfigService {


	@Autowired
	private TcgModuleConfigDAO tcgModuleConfigDAO ;

	@Autowired
	private TcgProjectDAO tcgProjectDAO ;


	@Override
	public void isExist(TcgModuleConfigBO tcgModuleConfigBO) {

	}


	@Override
	public List<TcgModuleConfigBO> processResult(List<TcgModuleConfigBO> tcgModuleConfigBOs){
		for(TcgModuleConfigBO bo : tcgModuleConfigBOs){
			processResult(bo);
		}
		return tcgModuleConfigBOs;
	}

	@Override
	public TcgModuleConfigBO processResult(TcgModuleConfigBO tcgModuleConfigBO){
		if(tcgModuleConfigBO == null){
			return null;
		}

		if(StringUtils.isNotEmpty(tcgModuleConfigBO.getProjectId())) {
			TcgProjectEntity project = tcgProjectDAO.selectById(tcgModuleConfigBO.getProjectId());
			tcgModuleConfigBO.setProjectName(project.getProjectName());
		}

		StringBuilder sb = new StringBuilder("");
		if(StringUtils.isNotEmpty( tcgModuleConfigBO.getPid() )){
			TcgModuleConfigEntity parentModule = tcgModuleConfigDAO.selectById(tcgModuleConfigBO.getPid());
			if(parentModule != null){
				tcgModuleConfigBO.setParentModuleNme(parentModule.getModuleName());
				sb.append("/").append(parentModule.getModuleResource());
			}

			TcgModuleConfigEntity pm = parentModule;
			while(StringUtils.isNotEmpty( pm.getPid() )){
				pm = tcgModuleConfigDAO.selectById(pm.getPid());
				if(pm != null){
					sb.append("/").append(pm.getModuleResource());
				}
			}
		}
		sb.append("/").append(tcgModuleConfigBO.getModuleResource());
		tcgModuleConfigBO.setModuleFullResource(sb.toString());

		return tcgModuleConfigBO;
	}


	@Override
	public BaseDAO getDAO() {
	return tcgModuleConfigDAO;
	}


}
