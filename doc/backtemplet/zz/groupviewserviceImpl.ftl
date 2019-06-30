package ${table.fullPackageName}.${templet.fileInnerPackage};

import com.zz.bms.core.db.base.service.impl.BaseGroupServiceImpl;
import com.zz.bms.core.db.base.service.BaseService;


import ${table.fullPackageName}.bo.${table.javaName}GroupBO;
import ${table.fullPackageName}.service.${table.javaName}GroupService;
import ${table.fullPackageName}.service.${table.javaName}Service;

<#list table.pageChildTables as childTable>
import ${childTable.fullPackageName}.service.${childTable.javaName}Service;
</#list>

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* <h1>${table.tableComment}Group ServiceImpl</h1>
* @author ${project.projectAuthor}
* @date ${.now}
*/
@Service
public class ${table.javaName}GroupServiceImpl extends BaseGroupServiceImpl<${table.javaName}GroupBO,String> implements ${table.javaName}GroupService {


	@Autowired
	${table.javaName}Service ${table.simpleName}Service;

<#list table.mainTableConfig.pageChildTables as childTable>
	@Autowired
	private ${childTable.javaName}Service ${childTable.simpleName}Service;

</#list>

	private BaseService[] bss = null;


	/**
	* 此数组需要和 ${table.javaName}GroupBO 对象对应
	* @return
	*/
	@Override
	public BaseService[] getServices() {
		if(bss == null) {
			bss = new BaseService[]{${table.simpleName}Service<#list table.pageChildColumns as childColumn>,${childColumn.tableBO.simpleName}Service</#list>};
		}
		return bss;
	}



}