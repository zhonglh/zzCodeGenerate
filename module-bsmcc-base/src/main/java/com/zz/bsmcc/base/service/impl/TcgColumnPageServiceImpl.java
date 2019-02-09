package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;
import com.zz.bms.enums.EnumYesNo;
import com.zz.bsmcc.base.bo.TcgColumnConfigBO;
import com.zz.bsmcc.base.bo.TcgColumnPageBO;
import com.zz.bsmcc.base.bo.TcgExColumnBO;
import com.zz.bsmcc.base.dao.TcgColumnConfigDAO;
import com.zz.bsmcc.base.dao.TcgColumnPageDAO;
import com.zz.bsmcc.base.dao.TcgExColumnDAO;
import com.zz.bsmcc.base.service.TcgColumnPageService;
import com.zz.bms.enums.EnumPageElement;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TcgColumnPageServiceImpl extends BaseServiceImpl<TcgColumnPageBO,String> implements TcgColumnPageService {



	@Autowired
	private TcgColumnConfigDAO tcgColumnConfigDAO ;
	@Autowired
	private TcgExColumnDAO tcgExColumnDAO ;


	@Autowired
	private TcgColumnPageDAO tcgColumnPageDAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return tcgColumnPageDAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return tcgColumnPageDAO;
	}



	@Override
	public TcgColumnPageBO processResult(TcgColumnPageBO tcgColumnPageBO) {
		TcgColumnConfigBO tcgColumnConfigBO = tcgColumnConfigDAO.selectById(tcgColumnPageBO.getId());
		if(tcgColumnConfigBO != null){
			tcgColumnPageBO.setColumnComment(tcgColumnConfigBO.getColumnComment());
			tcgColumnPageBO.setJavaName(tcgColumnConfigBO.getJavaName());
			tcgColumnPageBO.setColumnConfig(tcgColumnConfigBO);
			try {
				tcgColumnConfigBO.setJavaClass(Class.forName(tcgColumnConfigBO.getJavaFullClass()));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			tcgColumnPageBO.setNumber(tcgColumnConfigBO.isNumber());
			tcgColumnPageBO.setDate(tcgColumnConfigBO.isDate());
		}else {
			TcgExColumnBO tcgExColumnBO = tcgExColumnDAO.selectById(tcgColumnPageBO.getId());
			if(tcgExColumnBO != null){
				tcgColumnPageBO.setColumnComment(tcgExColumnBO.getColumnTitle());
				tcgColumnPageBO.setJavaName(tcgExColumnBO.getJavaName());
				tcgColumnPageBO.setExColumn(tcgExColumnBO);
				try {
					tcgExColumnBO.setJavaClass(Class.forName(tcgExColumnBO.getJavaFullClass()));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				tcgColumnPageBO.setNumber(tcgExColumnBO.isNumber());
				tcgColumnPageBO.setDate(tcgExColumnBO.isDate());


			}
		}


		if(StringUtils.isNotEmpty(tcgColumnPageBO.getEditable())){
			if(EnumYesNo.YES.getCode().equals(tcgColumnPageBO.getEditable())){
				tcgColumnPageBO.setEditableName(EnumYesNo.YES.getName());
			}else {
				tcgColumnPageBO.setEditableName(EnumYesNo.NO.getName());
			}
		}

		if(StringUtils.isNotEmpty(tcgColumnPageBO.getExistPage())){
			if(EnumYesNo.YES.getCode().equals(tcgColumnPageBO.getExistPage())){
				tcgColumnPageBO.setExistPageName(EnumYesNo.YES.getName());
			}else {
				tcgColumnPageBO.setExistPageName(EnumYesNo.NO.getName());
			}
		}

		if(StringUtils.isNotEmpty(tcgColumnPageBO.getHiddenable())){
			if(EnumYesNo.YES.getCode().equals(tcgColumnPageBO.getHiddenable())){
				tcgColumnPageBO.setHiddenableName(EnumYesNo.YES.getName());
			}else {
				tcgColumnPageBO.setHiddenableName(EnumYesNo.NO.getName());
			}
		}

		if(StringUtils.isNotEmpty(tcgColumnPageBO.getRequired())){
			if(EnumYesNo.YES.getCode().equals(tcgColumnPageBO.getRequired())){
				tcgColumnPageBO.setRequiredName(EnumYesNo.YES.getName());
			}else {
				tcgColumnPageBO.setRequiredName(EnumYesNo.NO.getName());
			}
		}

		if(StringUtils.isNotEmpty(tcgColumnPageBO.getListShowable())){
			if(EnumYesNo.YES.getCode().equals(tcgColumnPageBO.getListShowable())){
				tcgColumnPageBO.setListShowableName(EnumYesNo.YES.getName());
			}else {
				tcgColumnPageBO.setListShowableName(EnumYesNo.NO.getName());
			}
		}

		if(StringUtils.isNotEmpty(tcgColumnPageBO.getRealColumn())){
			if(EnumYesNo.YES.getCode().equals(tcgColumnPageBO.getRealColumn())){
				tcgColumnPageBO.setRealColumnName(EnumYesNo.YES.getName());
			}else {
				tcgColumnPageBO.setRealColumnName(EnumYesNo.NO.getName());
			}
		}

		if(StringUtils.isNotEmpty(tcgColumnPageBO.getElement())){
			EnumPageElement pe = EnumPageElement.getEnumByValue(tcgColumnPageBO.getElement());
			if(pe != null){
				tcgColumnPageBO.setElementNmae(pe.getLabel());
			}
		}

		return tcgColumnPageBO;
	}
}
