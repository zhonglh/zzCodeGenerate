package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.util.base.data.StringUtil;
import com.zz.bsmcc.base.bo.TcgColumnConfigBO;
import com.zz.bsmcc.base.bo.TcgColumnEventBO;
import com.zz.bsmcc.base.bo.TcgColumnValidateBO;
import com.zz.bsmcc.base.dao.TcgColumnConfigDAO;
import com.zz.bsmcc.base.service.TcgExColumnService;
import com.zz.bsmcc.base.dao.TcgExColumnDAO;
import com.zz.bsmcc.base.bo.TcgExColumnBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
*/
@Service
public class TcgExColumnServiceImpl extends BaseServiceImpl<TcgExColumnBO,String> implements TcgExColumnService {



	@Autowired
	private TcgColumnConfigDAO tcgColumnConfigDAO ;


	@Autowired
	private TcgExColumnDAO tcgExColumnDAO ;



	@Override
	public BaseDAO getDAO() {
	return tcgExColumnDAO;
	}


	@Override
	public void isExist(TcgExColumnBO tcgExColumnBO) {

	}



	@Override
	public List<TcgExColumnBO> processResult(List<TcgExColumnBO> tcgExColumnBOs){
		for(TcgExColumnBO bo : tcgExColumnBOs){
			processResult(bo);
		}
		return tcgExColumnBOs;
	}

	@Override
	public TcgExColumnBO processResult(TcgExColumnBO tcgExColumnBO) {


		if(StringUtil.isNotEmpty(tcgExColumnBO.getOriginalColumnId())) {
			TcgColumnConfigBO tcgColumnConfigBO = tcgColumnConfigDAO.selectById(tcgExColumnBO.getOriginalColumnId());
			if (tcgColumnConfigBO != null) {
				tcgExColumnBO.setOriginalColumnDict(tcgColumnConfigBO.getColumnIsdict());
				tcgExColumnBO.setOriginalColumnFk(tcgColumnConfigBO.getColumnIsfk());
				tcgExColumnBO.setOriginalColumnName(tcgColumnConfigBO.getColumnName());
				tcgExColumnBO.setOriginalJavaName(tcgColumnConfigBO.getJavaName());
				tcgExColumnBO.setGroupCode(tcgColumnConfigBO.getGroupCode());
				tcgExColumnBO.setDictType(tcgColumnConfigBO.getDictType());
			}
		}

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


		if(StringUtils.isNotEmpty(tcgExColumnBO.getJavaFullClass())){
			try {
				tcgExColumnBO.setJavaClass(Class.forName(tcgExColumnBO.getJavaFullClass()));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return tcgExColumnBO;
	}
}
