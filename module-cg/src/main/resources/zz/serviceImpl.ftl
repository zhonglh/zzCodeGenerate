package ${table.basePackage}.services;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseServiceImpl;
import com.zz.bms.system.base.dao.${table.shortTableName?cap_first}DAO;
import com.zz.bms.system.base.entity.${table.shortTableName?cap_first}Entity;
import com.zz.bms.system.base.service.${table.shortTableName?cap_first}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
*/
@Service
public class TsUserServiceImpl extends BaseServiceImpl<TsUserEntity,String> implements TsUserService {


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
