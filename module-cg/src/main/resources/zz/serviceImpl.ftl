package ${table.basePackage}.services;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;


import com.zz.bsmcc.base.service.${table.shortTableName?cap_first}Service;
import com.zz.bsmcc.base.dao.${table.shortTableName?cap_first}DAO;
import com.zz.bsmcc.base.bo.${table.shortTableName?cap_first}BO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class ${table.shortTableName?cap_first}ServiceImpl extends BaseServiceImpl<${table.shortTableName?cap_first}BO,String> implements ${table.shortTableName?cap_first}Service {


	@Autowired
	private ${table.shortTableName?cap_first}DAO ${table.shortTableName}DAO ;


	@Override
	public BaseDAO getQueryDAO() {
	return ${table.shortTableName}DAO;
	}

	@Override
	public BaseDAO getRwDAO() {
	return ${table.shortTableName}DAO;
	}
}
