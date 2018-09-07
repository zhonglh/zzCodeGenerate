package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.db.entity.EntityUtil;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.core.exceptions.DbException;
import com.zz.bms.core.ui.Pages;
import com.zz.bms.core.ui.easyui.EasyUiDataGrid;
import com.zz.bms.core.vo.AjaxJson;
import com.zz.bms.shiro.utils.ShiroUtils;


import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.dao.*;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.*;
import com.zz.bsmcc.base.query.impl.*;

import com.zz.bms.util.base.java.IdUtils;

import com.zz.bsmcc.base.service.*;
import com.zz.bsmcc.business.TableBusiness;
import com.zz.bsmcc.core.TablesLocalThread;
import com.zz.bsmcc.core.util.table.engine.ReadDbFactory;
import com.zz.bsmcc.core.util.table.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 表设置 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:20
 */
@RequestMapping("/table/config")
@Controller
public class TcgTableConfigController extends ZzccBaseController<TcgTableConfigBO, String , TcgTableConfigQueryWebImpl> {

    @Autowired
    private TableBusiness tableBusiness;

    @Autowired
    private TableBusinessService tableBusinessService;



	@Autowired
	private TcgDbConfigService tcgDbConfigService;

    @Autowired
    private TcgProjectService tcgProjectService;

    @Autowired
    private TcgModuleConfigService tcgModuleConfigService;


    @Autowired
    private TcgColumnConfigService tcgColumnConfigService;

    @Autowired
    private TcgExColumnService tcgExColumnService;

    @Autowired
    private TcgColumnPageService tcgColumnPageService;
    @Autowired
    private TcgIndexConfigService tcgIndexConfigService;



    @Autowired
    private TcgColumnEventService tcgColumnEventService;
    @Autowired
    private TcgColumnValidateService tcgColumnValidateService;
    @Autowired
    private TcgColumnExService tcgColumnExService;
    @Autowired
    private TcgQueryConfigService tcgQueryConfigService;
    @Autowired
    private TcgTableOperationService tcgTableOperationService;
    @Autowired
    private TcgOperationService tcgOperationService;




    /**
     * 根据数据库设置 返回该库 所有的表和视图
     * @param tcgTableConfigBO
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/tableListByDbConfig/{dbId}" , method = RequestMethod.GET)
    @ResponseBody
    public Object tableListByDbConfig(@PathVariable("dbId") String dbId, TcgTableConfigBO tcgTableConfigBO , Model model , TcgTableConfigQueryWebImpl query ,HttpServletRequest request, HttpServletResponse response) {


        tcgTableConfigBO.setDbId(dbId);
        if(StringUtils.isEmpty(tcgTableConfigBO.getDbId())){
            return null;
        }

        TcgDbConfigBO dbConfigBO = tcgDbConfigService.selectById(tcgTableConfigBO.getDbId());

        try {
            List<Table> tables = ReadDbFactory.buildReadDbProcess(dbConfigBO.getDbType()).readAllTable(
                    new DbConfig(dbConfigBO.getDbType() , dbConfigBO.getDbUrl() , dbConfigBO.getDbUsername() , dbConfigBO.getDbPassword())
            );
            Map<String,Table> tableMap = new HashMap<String ,Table>();
            for(Table table : tables){
                tableMap.put(table.getTableSchema()+table.getTableName() , table);
            }



            TcgTableConfigQuery existQuery = new TcgTableConfigQueryImpl();
            existQuery.dbId(dbId);
            List<TcgTableConfigBO> exists = this.baseService.selectList(existQuery.buildWrapper());
            for(TcgTableConfigBO tableBO : exists){
                tableMap.remove(tableBO.getSchemaName()+tableBO.getTableName());
            }


            Collection<Table> ts = tableMap.values();
            tables = new ArrayList(ts);
            tables.sort(new Comparator<Table>(){
                @Override
                public int compare(Table o1, Table o2) {
                    return o1.getTableSchema().compareTo(o2.getTableSchema());

                }
            });

            return new EasyUiDataGrid(tables.size(), tables);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }

        return null;



    }

    @Override
	protected String getAddPageName() {
		return "addForm";
	}


    @RequestMapping( value = "/createAll",  method = {RequestMethod.POST} )
    @ResponseBody
    public Object createAll(TcgTableConfigBO m, ModelMap model, HttpServletRequest request , HttpServletResponse response) {
        this.permissionList.assertHasCreatePermission();

        ILoginUserEntity<String> sessionUserVO = this.getSessionUser();
        boolean success = false;

        String[] tablesn = request.getParameterValues("ids");
        if(tablesn == null || tablesn.length == 0){
            return new AjaxJson(false,"请先选择要添加的表");
        }

        TcgDbConfigBO dbConfigBO = tcgDbConfigService.selectById(m.getDbId());
        TcgProjectBO projectBO = tcgProjectService.selectById(m.getProjectId());



        Map<String,List<Table>> tablesMap = new HashMap<String,List<Table>>();
        try {
            List<String> schemaList = null;
            if(EnumYesNo.YES.getCode().equals(projectBO.getIsMultiSchema())) {
                schemaList = new ArrayList<String>();
                if(StringUtils.isNotEmpty(projectBO.getOtherSchema())){
                    String[] schemas = projectBO.getOtherSchema().split(",");
                    for(String schema : schemas) {
                        if(StringUtils.isNotEmpty(schema)) {
                            schema = schema.toLowerCase().trim().replaceAll("\t", "");
                            schemaList.add(schema);
                        }

                    }
                }
            }

            List<Table> dbTables = ReadDbFactory.buildReadDbProcess(dbConfigBO.getDbType()).readAllTable(
                    new DbConfig(dbConfigBO.getDbType(), dbConfigBO.getDbUrl(), dbConfigBO.getDbUsername(), dbConfigBO.getDbPassword())
            );
            for(Table table : dbTables){
                String tableSchema = table.getTableSchema();
                String tableName = table.getTableName();
                if(schemaList != null && !schemaList.contains(tableSchema)){
                    continue;
                }
                List<Table> list = tablesMap.get(tableSchema);
                if(list == null){
                    list = new ArrayList<Table>();
                    tablesMap.put(tableSchema,list);
                }
                list.add(table);
            }
        }catch(Exception e){
            throw new BizException(e);
        }



        List<TablePO> tablePOs = new ArrayList<TablePO>();

        TablesLocalThread.setTables(null);
        if(EnumYesNo.YES.getCode().equals(projectBO.getIsMultiSchema())) {
            TablesLocalThread.setTablesMap(tablesMap);
        }
        for(String sns : tablesn) {
            TcgTableConfigBO tcgTableConfigBO = new TcgTableConfigBO();
            BeanUtils.copyProperties(m , tcgTableConfigBO);
            String[] sn = sns.split(":");
            tcgTableConfigBO.setSchemaName(sn[0]);
            tcgTableConfigBO.setTableName(sn[1]);


            if (StringUtils.isEmpty(tcgTableConfigBO.getDbId()) || StringUtils.isEmpty(tcgTableConfigBO.getTableName()) || StringUtils.isEmpty(tcgTableConfigBO.getProjectId())) {
                continue;
            }
            if (this.isExist(tcgTableConfigBO)) {
                continue;
            }
            TablesLocalThread.setTables(tablesMap.get(tcgTableConfigBO.getSchemaName()));

            TablePO tablePO = tableBusiness.tableBusiness( dbConfigBO,  tcgTableConfigBO, sessionUserVO);
            tablePOs.add(tablePO);
            TablesLocalThread.setTables(null);
        }
        TablesLocalThread.setTables(null);
        TablesLocalThread.setTablesMap(null);

        try {
            success = tableBusinessService.insertTable(tablePOs);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw DbException.DB_INSERT_RESULT_0;
        }

        if (!success) {
            throw DbException.DB_INSERT_RESULT_0;
        } else {
            return AjaxJson.successAjax;
        }

    }



    @RequestMapping(
            value = {"/{id}/updateAll"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Object updateAll(@PathVariable("id") String id, ModelMap model, TablePO tablePO, TcgTableConfigBO tcgTableConfigBO,
                            HttpServletRequest request, HttpServletResponse response) {
        this.permissionList.assertHasUpdatePermission();

        ILoginUserEntity<String> sessionUserVO = this.getSessionUser();
        boolean success = false;

        tablePO.setTableBO(tcgTableConfigBO);

        try {

            if(tablePO.getColumns() != null && !tablePO.getColumns().isEmpty()) {
                for (TcgColumnConfigBO item : tablePO.getColumns()) {
                    //替换掉空格 , Tab 键
                    if(StringUtils.isNotEmpty(item.getDictType())){
                        item.setDictType(item.getDictType().trim().replaceAll("\t",""));
                    }
                    if(StringUtils.isNotEmpty(item.getFkSchema())){
                        item.setFkSchema(item.getFkSchema().trim().replaceAll("\t",""));
                    }
                    if(StringUtils.isNotEmpty(item.getFkName())){
                        item.setFkName(item.getFkName().trim().replaceAll("\t",""));
                    }
                }
            }


            if(tablePO.getExColumns() != null && !tablePO.getExColumns().isEmpty()) {
                for (TcgExColumnBO item : tablePO.getExColumns()){
                    if(item != null && StringUtils.isEmpty(item.getId())){
                        EntityUtil.autoSetInsertEntity(item , sessionUserVO,false);
                        item.setTableId(tcgTableConfigBO.getId());
                    }
                }
            }

            if(tablePO.getColumnEvents() != null && !tablePO.getColumnEvents().isEmpty()) {
                for (TcgColumnEventBO item : tablePO.getColumnEvents()){
                    if(item != null && StringUtils.isEmpty(item.getId())){
                        EntityUtil.autoSetInsertEntity(item , sessionUserVO,false);
                        item.setTableId(tcgTableConfigBO.getId());
                    }
                }
            }

            if(tablePO.getColumnValidates() != null && !tablePO.getColumnValidates().isEmpty()) {
                for (TcgColumnValidateBO item : tablePO.getColumnValidates()){
                    if(item != null && StringUtils.isEmpty(item.getId())){
                        EntityUtil.autoSetInsertEntity(item , sessionUserVO,false);
                        item.setTableId(tcgTableConfigBO.getId());
                    }
                }
            }



            if(tablePO.getQueryConfigs() != null && !tablePO.getQueryConfigs().isEmpty()) {
                for (TcgQueryConfigBO item : tablePO.getQueryConfigs()){
                    if(item != null && StringUtils.isEmpty(item.getId())){
                        EntityUtil.autoSetInsertEntity(item , sessionUserVO,false);
                        item.setTableId(tcgTableConfigBO.getId());

                        if(StringUtils.isNotEmpty(item.getColumnId())){

                            TcgColumnPageBO page = tcgColumnPageService.selectById(item.getColumnId());
                            if(page != null) {
                                item.setQueryFieldName(page.getJavaName());
                                item.setQueryTitle(page.getColumnComment());
                            }

                        }
                    }
                }
            }

            String[] operations = request.getParameterValues("operations");
            List<TcgTableOperationBO> operationList = new ArrayList<TcgTableOperationBO>();
            if(operations != null && operations.length > 0){
                for(String operation : operations){
                    TcgTableOperationBO operationBO = new TcgTableOperationBO();
                    operationBO.setTableId(tcgTableConfigBO.getId());
                    operationBO.setOperationId(operation);
                    operationBO.setId(IdUtils.getId());
                    EntityUtil.autoSetInsertEntity(operationBO , sessionUserVO);
                    operationList.add(operationBO);
                }
            }
            tablePO.setTableOperations(operationList);

            success = tableBusinessService.updateTable(tablePO);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw DbException.DB_INSERT_RESULT_0;
        }

        if (!success) {
            throw DbException.DB_UPDATE_RESULT_0;
        } else {
            return AjaxJson.successAjax;
        }

    }


    @RequestMapping(
            value = {"/{id}/deleteAll"},
            method = {RequestMethod.POST, RequestMethod.DELETE}
    )
    @ResponseBody
    public Object deleteAll(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {
        tableBusinessService.deleteTable(id);
        return AjaxJson.successAjax;
    }




	/**
	 * 增加界面一些定制的操作
	 * 如有， 需要重载
	 * @param model
	 */
	@Override
	protected void customInfoByCreateForm(TcgTableConfigBO tcgTableConfigBO, ModelMap model) {

		TcgDbConfigQuery dbConfigQuery = new TcgDbConfigQueryImpl();
        List<TcgDbConfigBO> dbConfigs =tcgDbConfigService.selectList(dbConfigQuery.buildWrapper());
		model.put("dbConfigs" , dbConfigs);

		if(!dbConfigs.isEmpty()){
            model.put("dbId" , dbConfigs.get(0).getId());
        }

        TcgProjectQuery projectQuery = new TcgProjectQueryImpl();

        List<TcgProjectBO> projects = tcgProjectService.selectList(projectQuery.buildWrapper());
        model.put("projects" , projects);

	}

    /**
     * 修改界面一些定制的操作
     * @param m
     * @param model
     */
    @Override
    protected void customInfoByUpdateForm(TcgTableConfigBO m, ModelMap model) {

        TcgProjectQuery projectQuery = new TcgProjectQueryImpl();
        List<TcgProjectBO> projects =  tcgProjectService.selectList(projectQuery.buildWrapper());
        model.put("projects" , projects);



        Map<String , Object> tableMap = new HashMap<String , Object>();
        tableMap.put("project_id" , m.getProjectId());
        tableMap.put("is_table" , EnumYesNo.YES.getCode());
        List<TcgTableConfigBO> tables = this.baseService.selectByMap(tableMap);
        model.put("tables" , tables);

        Map<String , Object> moduleMap = new HashMap<String , Object>();
        moduleMap.put("project_id" , m.getProjectId());
        List<TcgModuleConfigBO> modules = tcgModuleConfigService.selectByMap(moduleMap);
        model.put("modules" , modules);



        TcgColumnConfigQuery columnQuery = new TcgColumnConfigQueryImpl();
        columnQuery.tableId(m.getId());
        Wrapper<TcgColumnConfigBO> columnWrapper = columnQuery.buildWrapper();
        columnWrapper.orderBy(true, "column_sort", true);
        List<TcgColumnConfigBO> columnConfigBOs = tcgColumnConfigService.selectList(columnWrapper);
        model.put("columnConfigs" , columnConfigBOs);


        TcgExColumnQuery exColumnQuery = new TcgExColumnQueryImpl();
        exColumnQuery.tableId(m.getId());
        Wrapper<TcgExColumnBO> exColumnWrapper = exColumnQuery.buildWrapper();
        exColumnWrapper.orderBy(true, "column_sort", true);
        List<TcgExColumnBO> exColumnBOs = tcgExColumnService.selectList(exColumnWrapper);
        model.put("exColumns" , exColumnBOs);


        Map<String , Object> map = new HashMap<String , Object>();
        map.put("table_id" , m.getId());


        List<TcgColumnPageBO> columnPageBOs = tcgColumnPageService.selectByMap(map) ;
        model.put("columnPages" , columnPageBOs);

        List<TcgIndexConfigBO> indexConfigBOs = tcgIndexConfigService.selectByMap(map) ;
        model.put("indexConfigs" , indexConfigBOs);

        List<TcgColumnEventBO> columnEventBOs = tcgColumnEventService.selectByMap(map) ;
        model.put("columnEvents" , columnEventBOs);

        List<TcgColumnValidateBO> columnValidateBOs = tcgColumnValidateService.selectByMap(map) ;
        model.put("columnValidates" , columnValidateBOs);

        List<TcgColumnExBO> columnExBOs = tcgColumnExService.selectByMap(map) ;
        model.put("columnExs" , columnExBOs);

        List<TcgQueryConfigBO> queryConfigBOs = tcgQueryConfigService.selectByMap(map) ;
        model.put("queryConfigs" , queryConfigBOs);

        List<TcgTableOperationBO> tableOperationBOs = tcgTableOperationService.selectByMap(map) ;
        Set<String> operationIdSet = new HashSet<String>() ;
        if(tableOperationBOs != null && !tableOperationBOs.isEmpty()) {
            for (TcgTableOperationBO tableOperationBO : tableOperationBOs) {
                operationIdSet.add(tableOperationBO.getOperationId());
            }
        }

        TcgOperationQuery operationQuery = new TcgOperationQueryImpl();
        List<TcgOperationBO> operationBOs = tcgOperationService.selectList(operationQuery.buildWrapper());
        if(operationBOs != null && !operationBOs.isEmpty() && !operationIdSet.isEmpty()) {
            for (TcgOperationBO operationBO : operationBOs) {
                if (operationIdSet.contains(operationBO.getId())) {
                    operationBO.setChecked(true);
                }
            }
        }
        model.put("operations" , operationBOs);



    }



    @Override
    protected Wrapper buildWrapper(TcgTableConfigQueryWebImpl query, TcgTableConfigBO m) {
        Wrapper wrapper = query.buildWrapper();
        wrapper.orderBy("project_id" , true);
        wrapper.orderBy("is_table" , false);
        wrapper.orderBy("table_name" , true);
        return wrapper;
    }

	@Override
	protected boolean isExist(TcgTableConfigBO tcgTableConfigBO) {

        TcgTableConfigBO tmp = new TcgTableConfigBO();
        tmp.setId(tcgTableConfigBO.getId());
        tmp.setProjectId(tcgTableConfigBO.getProjectId());
        tmp.setDbId(tcgTableConfigBO.getDbId());
        tmp.setTableName(tcgTableConfigBO.getTableName());

        TcgTableConfigBO result =  this.baseService.selectCheck(tmp);
        if(result != null && result.getId() != null){
            return true;
        }else {
            return false;
        }

	}



}
