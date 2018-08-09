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



}
