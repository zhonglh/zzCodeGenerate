package ${table.fullPackageName}.${templet.fileInnerPackage};

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import com.fullbloom.source.component.files.db.interfaces.TsFilesService;
import com.fullbloom.source.component.files.domain.TsFiles;
import com.fullbloom.core.vo.Pager;
import ${table.fullPackageName}.interfaces.${table.javaName}Service;
import ${table.fullPackageName}.domain.${table.javaName};
import ${table.fullPackageName}.dao.${table.javaName}Dao;


<#list fkTables as being>
import ${being.fullPackageName}.interfaces.${being.javaName}Service;
</#list>


<#list fkTables as being>
import ${being.fullPackageName}.domain.${being.javaName};
</#list>


import com.fullbloom.source.component.dict.interfaces.TsDictService;

import com.fullbloom.source.component.dict.domain.TsDict;


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

	@Autowired
	private TsDictService tsDictService;


	@Autowired
	private TsFilesService tsFilesService;



	<#list table.fkTables as being>
	@Autowired
	private ${being.javaName}Service ${being.javaName?uncap_first}Service;
	</#list>


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
    	return findById(id,false);
	}


    /**
    * 根据id查询${table.tableComment}
    *
    * @param id
    * @param lazy
    * @return
    */
	@Override
	public ${table.javaName} findById(String id , boolean lazy){
		${table.javaName} ${table.javaName?uncap_first} = new ${table.javaName}();
		${table.javaName?uncap_first}.setId(id);
		${table.javaName}  result = ${table.javaName?uncap_first}Dao.findTopOne(${table.javaName?uncap_first});
		if(!lazy){
			processResult(result);
		}
		return result;
	}

	/**
	* 根据条件查询第一条${table.tableComment}
	*
	* @param ${table.javaName?uncap_first}
	* @return
	*/
	@Override
	public ${table.javaName} findTopOne(${table.javaName} ${table.javaName?uncap_first}){

		${table.javaName}  result = ${table.javaName?uncap_first}Dao.findTopOne(${table.javaName?uncap_first});
    	processResult(result);
		return result;
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

		List<${table.javaName}> list =  ${table.javaName?uncap_first}Dao.findList(${table.javaName?uncap_first});
		if(list != null && !list.isEmpty()){
			for(${table.javaName} temp : list){
				processResult(temp);
			}
		}
		return list;
	}

	/**
	* 查询所有
	* @return
	*/
	@Override
	public List<${table.javaName}> findAll(){
    	List<${table.javaName}> list = ${table.javaName?uncap_first}Dao.findAll();
		for(${table.javaName} temp : list){
			processResult(temp);
		}
		return list;
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
		if(list != null && !list.isEmpty()){
			for(${table.javaName} temp : list){
    			processResult(temp);
			}
		}
		return new Pager<${table.javaName}>(list);
	}


    @Override
	public void processResult(${table.javaName} ${table.javaName?uncap_first}){


	<#if project.pageUseView == '0' ||  (project.pageUseView == '1' && table.isTable == '0')>

			if( ${table.javaName?uncap_first} == null ) {
				return ;
			}

		<#if exColumnMap?exists>
            TsDict tempDict = null;

		<#list exColumnMap?keys as key>
			<#if exColumnMap[key][0].originalColumnFk == '1'>
				<#assign fkColumn = exColumnMap[key][0].originalColumn >
			if(StringUtils.isNotEmpty(${table.javaName?uncap_first}.${fkColumn.getMethodName}())){
				${fkColumn.fkTableConfig.javaName} ${fkColumn.javaName}Obj = ${fkColumn.fkTableConfig.javaName?uncap_first}Service.findById(${table.javaName?uncap_first}.${fkColumn.getMethodName}() , true);
				if(${fkColumn.javaName}Obj != null){
				<#list exColumnMap[key] as val>
					${table.javaName?uncap_first}.set${val.javaName?cap_first}(${fkColumn.javaName}Obj.get${val.fkJavaName?cap_first}());
				</#list>
					${table.javaName?uncap_first}.set${fkColumn.fkTableConfig.javaName}(${fkColumn.javaName}Obj);
				}
			}

			<#else>


			<#list exColumnMap[key] as val>
				<#assign fkColumn = exColumnMap[key][0].originalColumn >
			if(StringUtils.isNotEmpty(${table.javaName?uncap_first}.${fkColumn.getMethodName}())){
				tempDict = tsDictService.findByTypeVal(  "${fkColumn.dictType}",${table.javaName?uncap_first}.${fkColumn.getMethodName}());
				if(tempDict != null){
					${table.javaName?uncap_first}.set${val.javaName?cap_first}(   tempDict.getDictName()  );
				}
			}
			</#list>

			</#if>
		</#list>
		</#if>



		<#list columnPages as being>
			<#if being.element == 'singlefile' || being.element == 'multifile' >
			if(StringUtils.isNotEmpty(${table.javaName?uncap_first}.get${being.javaName?cap_first}())){
				TsFiles tsFiles = new TsFiles();
				List<String> idList = Arrays.asList(${table.javaName?uncap_first}.get${being.javaName?cap_first}().split(","));
				tsFiles.setQueryIdList(idList);
				${table.javaName?uncap_first}.set${being.javaName?cap_first}List(tsFilesService.findList(tsFiles));
			}
			</#if>
		</#list>

	</#if>

	}



<#list operations as op>

	<#if op.operationResource != 'add' && op.operationResource != 'update' && op.operationResource != 'del' && op.operationResource != 'detail'>
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
