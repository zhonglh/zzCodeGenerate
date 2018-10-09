package ${table.fullPackageName}.${templet.fileInnerPackage};

import java.util.List;
import ${table.fullPackageName}.domain.${table.javaName};
import com.fullbloom.core.vo.Pager;
import com.fullbloom.core.annotations.PermissionAnnotation;

/**
 * ${table.tableComment}Service
 *
 * @author ${project.projectAuthor}
 * @date ${.now}
 */
public interface ${table.javaName}Service {

	/**
	* 保存${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@PermissionAnnotation(permissionCode="")
	public int save(${table.javaName} ${table.javaName?uncap_first});

	/**
	* 删除${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@PermissionAnnotation(permissionCode="")
	public int delete(${table.javaName} ${table.javaName?uncap_first}) ;



	/**
	* 删除${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}s
	* @return
	*/
	@PermissionAnnotation(permissionCode="")
	public int delete(List<${table.javaName}> ${table.javaName?uncap_first}s) ;


	/**
	* 更新${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@PermissionAnnotation(permissionCode="")
	public int update(${table.javaName} ${table.javaName?uncap_first});

	/**
	* 根据id查询${table.tableComment}
	*
	* @param id
	* @return
	*/
	public ${table.javaName} findById(String id);

	/**
	* 根据条件查询第一条${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	public ${table.javaName} findTopOne(${table.javaName} ${table.javaName?uncap_first});
	public ${table.javaName} findTopOne4Check(${table.javaName} ${table.javaName?uncap_first});

	/**
	* 根据条件查询${table.tableComment}列表
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	public List<${table.javaName}> findList(${table.javaName} ${table.javaName?uncap_first});

	/**
	* 查询所有
	* @return
	*/
	List<${table.javaName}> findAll();

	/**
	* 根据条件分页查询${table.tableComment}列表
	*
	* @param ${table.javaName?uncap_first}
	* @param pager
	* @return
	*/
	@PermissionAnnotation(permissionCode="")
	public Pager<${table.javaName}> findPageList(${table.javaName} ${table.javaName?uncap_first},Pager pager);


	/**
	 * 处理其它数据
	 * ${table.javaName?uncap_first}
    */
	public void processResult(${table.javaName} ${table.javaName?uncap_first});



<#list operations as op>

<#if op.operationResource != 'add' && op.operationResource != 'update' && op.operationResource != 'del' && op.operationResource != 'detail'>
<#if op.operationBO.opMode == '1'>
	<#if op.operationBO.selectMode == '0'>
    /**
    * ${op.operationName}${table.tableComment}
    */
	public int ${op.operationResource}(${table.javaName} ${table.javaName?uncap_first}) ;
	<#elseif op.operationBO.selectMode == '1'>

    /**
    * ${op.operationName}${table.tableComment}
    */
    public int ${op.operationResource}(${table.javaName} ${table.javaName?uncap_first}) ;
	<#elseif op.operationBO.selectMode == '2'>

	</#if>
<#else >
	<#if op.operationBO.selectMode == '0'>

    /**
    * ${op.operationName}${table.tableComment}
    */
	public void ${op.operationResource}();

	<#elseif op.operationBO.selectMode == '1'>

    /**
    * ${op.operationName}${table.tableComment}
    */
    public int ${op.operationResource}(${table.javaName} ${table.javaName?uncap_first}) ;
	<#elseif op.operationBO.selectMode == '2'>

    /**
    * ${op.operationName}${table.tableComment}
    */
    public int ${op.operationResource}(List<${table.javaName}> ${table.javaName?uncap_first}s) ;
	</#if>

</#if>
</#if>
</#list>


}
