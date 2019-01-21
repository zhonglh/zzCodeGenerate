package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;
import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bsmcc.base.bo.TcgModuleConfigBO;
import com.zz.bsmcc.base.bo.TcgTableConfigBO;
import com.zz.bsmcc.base.dao.TcgDbConfigDAO;
import com.zz.bsmcc.base.dao.TcgModuleConfigDAO;
import com.zz.bsmcc.base.dao.TcgProjectDAO;
import com.zz.bsmcc.base.dao.TcgTableConfigDAO;
import com.zz.bsmcc.base.domain.TcgDbConfigEntity;
import com.zz.bsmcc.base.domain.TcgProjectEntity;
import com.zz.bsmcc.base.service.TcgTableConfigService;
import com.zz.bsmcc.core.enums.EnumQueryMode;
import com.zz.bsmcc.core.enums.EnumTableRelation;
import com.zz.bsmcc.core.enums.EnumTableType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgTableConfigServiceImpl extends BaseServiceImpl<TcgTableConfigBO,String> implements TcgTableConfigService {


	@Autowired
	private TcgTableConfigDAO tcgTableConfigDAO ;


	@Autowired
	private TcgDbConfigDAO tcgDbConfigDAO ;
	@Autowired
	private TcgProjectDAO tcgProjectDAO ;
	@Autowired
	private TcgModuleConfigDAO tcgModuleConfigDAO ;



	@Override
	public BaseDAO getQueryDAO() {
	return tcgTableConfigDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgTableConfigDAO;
	}



	@Override
	public TcgTableConfigBO processResult(TcgTableConfigBO tcgTableConfigBO) {
		TcgDbConfigEntity tcgDbConfigEntity = tcgDbConfigDAO.selectById(tcgTableConfigBO.getDbId());
		tcgTableConfigBO.setDbConfigTitle(tcgDbConfigEntity.getTitle());

		TcgProjectEntity tcgProjectEntity = tcgProjectDAO.selectById(tcgTableConfigBO.getProjectId());
		tcgTableConfigBO.setProjectName(tcgProjectEntity.getProjectName());

		if(StringUtils.isNotEmpty(tcgTableConfigBO.getModuleId())) {
			TcgModuleConfigBO tcgModuleConfigBO = tcgModuleConfigDAO.selectById(tcgTableConfigBO.getModuleId());
			tcgTableConfigBO.setModuleName(tcgModuleConfigBO.getModuleName());
		}

		if(StringUtils.isNotEmpty(tcgTableConfigBO.getTableType())) {
			EnumTableType type = EnumTableType.getTableTypeByValue(tcgTableConfigBO.getTableType());
			if(type != null){
				tcgTableConfigBO.setTableTypeName(type.getLabel());
			}

		}

		if(StringUtils.isNotEmpty(tcgTableConfigBO.getTableRelation())) {
			EnumTableRelation relation = EnumTableRelation.getTableRelationByValue(tcgTableConfigBO.getTableRelation());
			if(relation != null) {
				tcgTableConfigBO.setTableRelationName(relation.getLabel());
			}
		}

		if(StringUtils.isNotEmpty(tcgTableConfigBO.getQueryMode())) {
			EnumQueryMode queryMode = EnumQueryMode.getQueryModeByValue(tcgTableConfigBO.getQueryMode());
			if(queryMode != null) {
				tcgTableConfigBO.setQueryModeName(queryMode.getLabel());
			}
		}

		if(EnumYesNo.NO.getCode().equals(tcgTableConfigBO.getIsTable())){

			if(StringUtils.isNotEmpty(tcgTableConfigBO.getMainTableId())){
				TcgTableConfigBO mainTableConfigBO = tcgTableConfigDAO.selectById(tcgTableConfigBO.getMainTableId());
				if(mainTableConfigBO != null){
					tcgTableConfigBO.setMainTableName(mainTableConfigBO.getTableName());
				}
			}

		}


		String simpleTableName = tcgTableConfigBO.getTableName().substring(tcgTableConfigBO.getTableName().indexOf("_")+1);
		tcgTableConfigBO.setSimpleName(StringFormatKit.toCamelCase(simpleTableName));



		return tcgTableConfigBO;
	}
}
