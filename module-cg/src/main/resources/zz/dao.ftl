package ${table.basePackage}.dao;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bsmcc.base.domain.${table.shortTableName?cap_first}Entity;
import org.springframework.stereotype.Repository;



/**
* ${table.tableComments}操作DAO
* @author Administrator
*/
@Repository
public interface ${table.shortTableName?cap_first}DAO extends BaseDAO<${table.shortTableName?cap_first}Entity , String> {

}
