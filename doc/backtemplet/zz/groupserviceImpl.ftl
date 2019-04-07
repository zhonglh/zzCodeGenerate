package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.core.db.entity.EntityUtil;
import com.zz.bms.core.exceptions.DbException;
import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bms.core.db.base.service.impl.BaseGroupServiceImpl;

<#list table.pageChildTables as childTable>
	import ${childTable.fullPackageName}.service.${childTable.javaName}Service;
</#list>

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ${table.tableComment} ServiceImpl
* @author ${project.projectAuthor}
* @date ${.now}
*/
@Service
public class ${table.javaName}ServiceImpl extends BaseGroupServiceImpl<${table.javaName}GroupBO,String> implements ${table.javaName}GroupService {

<#list table.pageChildTables as childTable>
	@Autowired
	private ${childTable.fullPackageName}.service.${childTable.javaName}Service ${childTable.simpleName}Service;

</#list>


/**
* 此数组需要和 ${table.javaName}GroupBO 对象对应
* @return
*/
	@Override
	public BaseService[] getServices() {
		BaseService[] bss = null;
		if(bss == null) {
			bss = new BaseService[]{<#list table.pageChildTables as childTable>${childTable.simpleName}Service<#if childTable_has_next>,</#if></#list>};
		}
		return bss;
	}



}