package ${table.fullPackageName}.${templet.fileInnerPackage};

import org.springframework.stereotype.Repository;
import java.util.List;
import ${table.fullPackageName}.domain.${table.javaName};

/**
 * ${table.tableComment} 数据访问层
 * 
 * @author ${project.projectAuthor}
 * @date ${.now}
 */
@Repository
public interface ${table.javaName}Dao {

	/**
	 * 保存${table.tableComment}
	 * 
	 * @param ${table.javaName?uncap_first}
	 * @return
	 */
	int save(${table.javaName} ${table.javaName?uncap_first});

	/**
	 * 删除${table.tableComment}
	 *
	 * @param ${table.javaName?uncap_first}
	 * @return
	 */
	int delete(${table.javaName} ${table.javaName?uncap_first}) ;

	/**
	 * 更新${table.tableComment}
	 *
	 * @param ${table.javaName?uncap_first}
	 * @return
	 */
	int update(${table.javaName} ${table.javaName?uncap_first});


	/**
	 * 根据条件查询第一条${table.tableComment}
	 *
	 * @param ${table.javaName?uncap_first}
	 * @return
	 */
	${table.javaName} findTopOne(${table.javaName} ${table.javaName?uncap_first});
	${table.javaName} findTopOne4Check(${table.javaName} ${table.javaName?uncap_first});



	/**
	 * 根据条件查询${table.tableComment}列表
	 *
	 * @param ${table.javaName?uncap_first}
	 * @return
	 */
	List<${table.javaName}> findList(${table.javaName} ${table.javaName?uncap_first});

	/**
	* 查询所有
	* @return
	*/
	List<${table.javaName}> findAll();


}
