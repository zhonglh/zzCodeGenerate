package ${table.basePackage}.interfaces;



import com.zz.bms.core.db.base.service.BaseService;
import com.zz.bsmcc.base.domain.${table.shortTableName?cap_first}Entity;

/**
 * ${table.tableComments}Service
 * 
 * @author ${table.author}
 * @date ${.now}
 */
public interface ${table.shortTableName?cap_first}Service extends BaseService<${table.shortTableName?cap_first}Entity , String> {

}
