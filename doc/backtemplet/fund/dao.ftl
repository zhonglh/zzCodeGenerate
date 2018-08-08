package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.core.db.base.dao.BaseDAO;
import ${table.fullPackageName}.bo.${table.javaName}BO;
import org.springframework.stereotype.Repository;

/**
* ${table.tableComment} 操作DAO
* @author ${project.projectAuthor}
* @date ${.now}
*/
@Repository
public interface ${table.javaName}DAO extends BaseDAO<${table.javaName}BO , String> {

}
