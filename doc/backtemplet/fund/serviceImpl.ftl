package ${table.fullPackageName}.${templet.fileInnerPackage};

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import com.fullbloom.core.vo.Pager;
import ${table.fullPackageName}.interfaces.${table.javaName}Service;
import ${table.fullPackageName}.domain.${table.javaName};
import ${table.fullPackageName}.dao.${table.javaName}Dao;


/**
 * ${table.tableComment}Service
 *
 * @author ${project.projectAuthor}
 * @date ${.now}
 */
@Service
public class ${table.javaName}ServiceImpl implements  ${table.javaName}Service{

	@Autowired
	private ${table.javaName}Dao ${table.javaName?uncap_first}Dao;

	/**
	* 保存${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@Override
	public int save(${table.javaName} ${table.javaName?uncap_first}){

		return ${table.javaName?uncap_first}Dao.save(${table.javaName?uncap_first});
	}

	/**
	* 删除${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@Override
	public int delete(${table.javaName} ${table.javaName?uncap_first}){

		return ${table.javaName?uncap_first}Dao.delete(${table.javaName?uncap_first});
	}


	/**
	* 删除${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}s
	* @return
	*/
	@Override
	public int delete(List<${table.javaName}> ${table.javaName?uncap_first}s){

		if(${table.javaName?uncap_first}s == null || ${table.javaName?uncap_first}s.isEmpty()){
			return 0;
		}else {
			${table.javaName} ${table.javaName?uncap_first} = new ${table.javaName}();
			List<String> ids= new ArrayList<String>();
			for(${table.javaName} temp : ${table.javaName?uncap_first}s){
				ids.add(temp.getId());
			}
			${table.javaName?uncap_first}.setQueryIdList(ids);
			return this.${table.javaName?uncap_first}Dao.delete(${table.javaName?uncap_first});
		}

	}

	/**
	* 更新${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@Override
	public int update(${table.javaName} ${table.javaName?uncap_first}){

		return ${table.javaName?uncap_first}Dao.update(${table.javaName?uncap_first});
	}

	/**
	* 根据id查询${table.tableComment}
	*
	* @param id
	* @return
	*/
	@Override
	public ${table.javaName} findById(String id){
		${table.javaName} ${table.javaName?uncap_first} = new ${table.javaName}();
		${table.javaName?uncap_first}.setId(id);
		return ${table.javaName?uncap_first}Dao.findTopOne(${table.javaName?uncap_first});
	}

	/**
	* 根据条件查询第一条${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@Override
	public ${table.javaName} findTopOne(${table.javaName} ${table.javaName?uncap_first}){

		return ${table.javaName?uncap_first}Dao.findTopOne(${table.javaName?uncap_first});
	}


	/**
	* 根据条件查询第一条${table.tableComment}, 用于校验数据唯一性
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@Override
	public ${table.javaName} findTopOne4Check(${table.javaName} ${table.javaName?uncap_first}){

		return ${table.javaName?uncap_first}Dao.findTopOne4Check(${table.javaName?uncap_first});
	}

	/**
	* 根据条件查询${table.tableComment}列表
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@Override
	public List<${table.javaName}> findList(${table.javaName} ${table.javaName?uncap_first}){

		return ${table.javaName?uncap_first}Dao.findList(${table.javaName?uncap_first});
	}

	/**
	* 查询所有
	* @return
	*/
	@Override
	public List<${table.javaName}> findAll(){
		return ${table.javaName?uncap_first}Dao.findAll();
	}
	/**
	* 根据条件分页查询${table.tableComment}列表
	*
	* @param ${table.javaName?uncap_first}
	* @param pager
	* @return
	*/
	@Override
	public Pager<${table.javaName}> findPageList(${table.javaName} ${table.javaName?uncap_first},Pager pager){

		PageHelper.startPage(pager.getPageNum(), pager.getPageSize());
		List<${table.javaName}> list = this.findList(${table.javaName?uncap_first});
		return new Pager<${table.javaName}>(list);
	}






<#list operations as op>

	<#if op.operationResource != 'add' && op.operationResource != 'update' && op.operationResource != 'delete' && op.operationResource != 'detail'>
		<#if op.operationBO.opMode == '1'>
			<#if op.operationBO.selectMode == '0'>
                /**
                * ${op.operationName}${table.tableComment}
                */
                @Override
                public int ${op.operationResource}(${table.javaName} ${table.javaName?uncap_first}) {
					//todo
					return 1;
				}
			<#elseif op.operationBO.selectMode == '1'>

                /**
                * ${op.operationName}${table.tableComment}
                */
                @Override
                public int ${op.operationResource}(${table.javaName} ${table.javaName?uncap_first})  {
					//todo
					return 1;
                }
			<#elseif op.operationBO.selectMode == '2'>

			</#if>
		<#else >
			<#if op.operationBO.selectMode == '0'>

                /**
                * ${op.operationName}${table.tableComment}
                */
                @Override
                public void ${op.operationResource}(){
					//todo
					return ;
				}

			<#elseif op.operationBO.selectMode == '1'>

                /**
                * ${op.operationName}${table.tableComment}
                */
                @Override
                public int ${op.operationResource}(${table.javaName} ${table.javaName?uncap_first}) {
					//todo
					return 1;
				}
			<#elseif op.operationBO.selectMode == '2'>

                /**
                * ${op.operationName}${table.tableComment}
                */
                @Override
                public int ${op.operationResource}(List<${table.javaName}> ${table.javaName?uncap_first}s) {
					//todo
					return 0;
                }
			</#if>

		</#if>
	</#if>
</#list>



}
