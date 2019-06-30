package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.bms.core.db.entity.EntityUtil;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.core.exceptions.DbException;
import com.zz.bms.core.ui.easyui.EasyUiDataGrid;
import com.zz.bms.core.vo.AjaxJson;
import com.zz.bms.util.base.java.IdUtils;
import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.*;
import com.zz.bsmcc.base.query.impl.*;
import com.zz.bsmcc.base.service.*;
import com.zz.bsmcc.business.TableBusiness;
import com.zz.bsmcc.core.TablesLocalThread;
import com.zz.bsmcc.core.util.table.engine.ReadDbFactory;
import com.zz.bsmcc.core.util.table.pojo.DbConfig;
import com.zz.bsmcc.core.util.table.pojo.Table;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.*;

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

        TcgDbConfigBO dbConfigBO = tcgDbConfigService.getById(tcgTableConfigBO.getDbId());

        try {
            List<Table> tables = ReadDbFactory.buildReadDbProcess(dbConfigBO.getDbType()).readAllTable(
                    new DbConfig(dbConfigBO.getDbType() , dbConfigBO.getDbUrl() , dbConfigBO.getDbUsername() , dbConfigBO.getDbPassword())
            );
            Map<String,Table> tableMap = new TreeMap<String ,Table>();
            for(Table table : tables){
                tableMap.put(table.getTableSchema()+table.getTableName() , table);
            }



            TcgTableConfigQuery existQuery = new TcgTableConfigQueryImpl();
            existQuery.dbId(dbId);
            List<TcgTableConfigBO> exists = this.baseRwService.list(existQuery.buildWrapper());
            for(TcgTableConfigBO tableBO : exists) {
                tableMap.remove(tableBO.getSchemaName() + tableBO.getTableName());
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
        this.assertHasCreatePermission();

        ILoginUserEntity<String> sessionUserVO = this.getSessionUser();
        boolean success = false;

        String[] tablesn = request.getParameterValues("ids");
        if(tablesn == null || tablesn.length == 0){
            return new AjaxJson(false,"请先选择要添加的表");
        }

        TcgDbConfigBO dbConfigBO = tcgDbConfigService.getById(m.getDbId());
        TcgProjectBO projectBO = tcgProjectService.getById(m.getProjectId());



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
            this.baseRwService.isExist(tcgTableConfigBO) ;
            TablesLocalThread.setTables(tablesMap.get(tcgTableConfigBO.getSchemaName()));

            //收集表（视图）的所有信息
            TablePO tablePO = tableBusiness.tableBusiness( dbConfigBO,  tcgTableConfigBO, projectBO,sessionUserVO);
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
            value = {"/{id}/tableOrViewUpdate"},
            method = {RequestMethod.GET}
    )
    public String tableOrViewUpdate(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {

        this.assertHasUpdatePermission();
            TcgTableConfigBO tcBO = this.baseRwService.getById(id , true);
        if(EnumYesNo.YES.getCode().equals(tcBO.getIsTable())){
            return "redirect:/table/config/"+id+"/update" ;
        }else {
            return "redirect:/table/config/"+id+"/updateView" ;
        }
    }



    @RequestMapping(
            value = {"/{id}/updateView"},
            method = {RequestMethod.GET}
    )
    public String updateViewForm(ModelMap model, @PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) {

        this.assertHasUpdatePermission();
        TcgTableConfigBO m = this.baseRwService.getById(id , true);
        model.put("entity" , m);
        model.put("m" , m);


        TcgProjectQuery projectQuery = new TcgProjectQueryImpl();
        List<TcgProjectBO> projects =  tcgProjectService.list(projectQuery.buildWrapper());
        model.put("projects" , projects);



        Map<String , Object> tableMap = new HashMap<String , Object>();
        tableMap.put("project_id" , m.getProjectId());
        tableMap.put("is_table" , EnumYesNo.YES.getCode());
        List<TcgTableConfigBO> tables = (List<TcgTableConfigBO>)this.baseRwService.listByMap(tableMap);
        model.put("tables" , tables);

        Map<String , Object> moduleMap = new HashMap<String , Object>();
        moduleMap.put("project_id" , m.getProjectId());
        List<TcgModuleConfigBO> modules = (List<TcgModuleConfigBO>)tcgModuleConfigService.listByMap(moduleMap);
        model.put("modules" , modules);

        String pageName = "editViewForm";
        return this.viewName(pageName);
    }


    @RequestMapping(
            value = {"/{id}/updateView"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Object updateView(ModelMap model, @PathVariable("id") String id, TcgTableConfigBO tcgTableConfigBO,HttpServletRequest request, HttpServletResponse response) {

        this.assertHasUpdatePermission();
        tcgTableConfigBO.setIsTable(EnumYesNo.NO.getCode());
        TablePO tablePO = new TablePO();
        tablePO.setTableBO(tcgTableConfigBO);
        boolean success = tableBusinessService.updateTable(tablePO);

        if (!success) {
            throw DbException.DB_UPDATE_RESULT_0;
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

        this.assertHasUpdatePermission();

        ILoginUserEntity<String> sessionUserVO = this.getSessionUser();
        boolean success = false;

        tablePO.setTableBO(tcgTableConfigBO);

        try {

            if(tablePO.getColumns() != null && !tablePO.getColumns().isEmpty()) {
                for (TcgColumnConfigBO item : tablePO.getColumns()) {
                    //替换掉空格 , Tab 键
                    if(StringUtils.isNotEmpty(item.getDictType())){
                        item.setDictType(item.getDictType().toLowerCase().trim().replaceAll("\t",""));
                    }
                    if(StringUtils.isNotEmpty(item.getFkSchema())){
                        item.setFkSchema(item.getFkSchema().toLowerCase().trim().replaceAll("\t",""));
                    }
                    if(StringUtils.isNotEmpty(item.getFkName())){
                        item.setFkName(item.getFkName().toLowerCase().trim().replaceAll("\t",""));
                    }
                }
            }


            if(tablePO.getExColumns() != null && !tablePO.getExColumns().isEmpty()) {
                for (TcgExColumnBO item : tablePO.getExColumns()){
                    if(item != null && StringUtils.isEmpty(item.getId())){

                        if(StringUtils.isNotEmpty(item.getFkColumnName())){
                            item.setFkColumnName(item.getFkColumnName().toLowerCase().trim().replaceAll("\t",""));
                        }

                        EntityUtil.autoSetInsertEntity(item , sessionUserVO,false);
                        item.setTableId(tcgTableConfigBO.getId());
                        if(StringUtils.isEmpty(item.getOriginalColumnId())){
                            item.setOriginalColumnDict(EnumYesNo.NO.getCode());
                            item.setOriginalColumnFk(EnumYesNo.NO.getCode());
                        }else {
                            if(item.getOriginalColumn() == null){
                                TcgColumnConfigBO columnBO = tcgColumnConfigService.getById(item.getOriginalColumnId());
                                if(columnBO == null){
                                    item.setOriginalColumnDict(EnumYesNo.NO.getCode());
                                    item.setOriginalColumnFk(EnumYesNo.NO.getCode());
                                }
                                item.setOriginalColumnName(columnBO.getColumnName());
                                item.setOriginalColumn(columnBO);
                                item.setOriginalColumnDict(EnumYesNo.NO.getCode());
                                item.setOriginalColumnFk(EnumYesNo.YES.getCode());
                            }

                            if(item.getOriginalColumn() != null && item.getFkColumn() == null){
                                QueryWrapper<TcgTableConfigBO> tableConfigBOQueryWrapper = new QueryWrapper<TcgTableConfigBO>();
                                tableConfigBOQueryWrapper.lambda().eq(TcgTableConfigBO::getSchemaName , item.getOriginalColumn().getFkSchema());
                                tableConfigBOQueryWrapper.lambda().eq(TcgTableConfigBO::getTableName , item.getOriginalColumn().getFkName());
                                TcgTableConfigBO fkTable = this.getBaseRwService().getOne(tableConfigBOQueryWrapper , false);
                                if(fkTable != null) {
                                    QueryWrapper<TcgColumnConfigBO> columnConfigBOQueryWrapper = new QueryWrapper<TcgColumnConfigBO>();
                                    columnConfigBOQueryWrapper.lambda().eq(TcgColumnConfigBO::getTableId , fkTable.getId());
                                    columnConfigBOQueryWrapper.lambda().eq(TcgColumnConfigBO::getColumnName , item.getFkColumnName());
                                    TcgColumnConfigBO one = tcgColumnConfigService.getOne(columnConfigBOQueryWrapper, false);
                                    item.setFkColumn(one);
                                }
                            }



                        }
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

                            TcgColumnPageBO page = tcgColumnPageService.getById(item.getColumnId());
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
        List<TcgDbConfigBO> dbConfigs =tcgDbConfigService.list(dbConfigQuery.buildWrapper());
		model.put("dbConfigs" , dbConfigs);

		if(!dbConfigs.isEmpty()){
            model.put("dbId" , dbConfigs.get(0).getId());
        }

        TcgProjectQuery projectQuery = new TcgProjectQueryImpl();

        List<TcgProjectBO> projects = tcgProjectService.list(projectQuery.buildWrapper());
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
        List<TcgProjectBO> projects =  tcgProjectService.list(projectQuery.buildWrapper());
        model.put("projects" , projects);



        Map<String , Object> tableMap = new HashMap<String , Object>();
        tableMap.put("project_id" , m.getProjectId());
        tableMap.put("is_table" , EnumYesNo.YES.getCode());
        List<TcgTableConfigBO> tables = (List<TcgTableConfigBO>)this.baseRwService.listByMap(tableMap);
        model.put("tables" , tables);

        Map<String , Object> moduleMap = new HashMap<String , Object>();
        moduleMap.put("project_id" , m.getProjectId());
        List<TcgModuleConfigBO> modules = (List<TcgModuleConfigBO>)tcgModuleConfigService.listByMap(moduleMap);
        model.put("modules" , modules);



        TcgColumnConfigQuery columnQuery = new TcgColumnConfigQueryImpl();
        columnQuery.tableId(m.getId());
        QueryWrapper<TcgColumnConfigBO> columnWrapper = columnQuery.buildWrapper();
        columnWrapper.orderByAsc( "column_sort");
        List<TcgColumnConfigBO> columnConfigBOs = tcgColumnConfigService.list(columnWrapper);
        model.put("columnConfigs" , columnConfigBOs);


        TcgExColumnQuery exColumnQuery = new TcgExColumnQueryImpl();
        exColumnQuery.tableId(m.getId());
        QueryWrapper<TcgExColumnBO> exColumnWrapper = exColumnQuery.buildWrapper();
        exColumnWrapper.orderByAsc( "column_sort");
        List<TcgExColumnBO> exColumnBOs = tcgExColumnService.list(exColumnWrapper);
        model.put("exColumns" , exColumnBOs);


        Map<String , Object> map = new HashMap<String , Object>();
        map.put("table_id" , m.getId());


        List<TcgColumnPageBO> columnPageBOs = (List<TcgColumnPageBO>)tcgColumnPageService.listByMap(map) ;
        model.put("columnPages" , columnPageBOs);
        if(columnPageBOs != null && !columnPageBOs.isEmpty()) {
            for (TcgColumnPageBO columnPageBO : columnPageBOs) {

                for (TcgColumnConfigBO columnConfigBO : columnConfigBOs) {
                    if (columnPageBO.getId().equals(columnConfigBO.getId())) {
                        columnPageBO.setColumnConfig(columnConfigBO);
                        try {
                            columnConfigBO.setJavaClass(Class.forName(columnConfigBO.getJavaFullClass()));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        columnPageBO.setNumber(columnConfigBO.isNumber());
                        columnPageBO.setDate(columnConfigBO.isDate());
                        break;
                    }
                }


                if (columnPageBO.getColumnConfig() == null) {
                    for (TcgExColumnBO exColumnBO : exColumnBOs) {
                        if (columnPageBO.getId().equals(exColumnBO.getId())) {
                            columnPageBO.setExColumn(exColumnBO);
                            try {
                                exColumnBO.setJavaClass(Class.forName(exColumnBO.getJavaFullClass()));
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            columnPageBO.setNumber(exColumnBO.isNumber());
                            columnPageBO.setDate(exColumnBO.isDate());
                            break;
                        }
                    }
                }



            }
        }

        List<TcgIndexConfigBO> indexConfigBOs = (List<TcgIndexConfigBO>)tcgIndexConfigService.listByMap(map) ;
        model.put("indexConfigs" , indexConfigBOs);

        List<TcgColumnEventBO> columnEventBOs = (List<TcgColumnEventBO>)tcgColumnEventService.listByMap(map) ;
        model.put("columnEvents" , columnEventBOs);

        List<TcgColumnValidateBO> columnValidateBOs = (List<TcgColumnValidateBO>)tcgColumnValidateService.listByMap(map) ;
        model.put("columnValidates" , columnValidateBOs);

        List<TcgColumnExBO> columnExBOs = (List<TcgColumnExBO>)tcgColumnExService.listByMap(map) ;
        model.put("columnExs" , columnExBOs);

        List<TcgQueryConfigBO> queryConfigBOs = (List<TcgQueryConfigBO>)tcgQueryConfigService.listByMap(map) ;
        model.put("queryConfigs" , queryConfigBOs);

        List<TcgTableOperationBO> tableOperationBOs = (List<TcgTableOperationBO>)tcgTableOperationService.listByMap(map) ;
        Set<String> operationIdSet = new HashSet<String>() ;
        if(tableOperationBOs != null && !tableOperationBOs.isEmpty()) {
            for (TcgTableOperationBO tableOperationBO : tableOperationBOs) {
                operationIdSet.add(tableOperationBO.getOperationId());
            }
        }

        TcgOperationQuery operationQuery = new TcgOperationQueryImpl();
        List<TcgOperationBO> operationBOs = tcgOperationService.list(operationQuery.buildWrapper());
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
    protected QueryWrapper buildQueryWrapper(TcgTableConfigQueryWebImpl query, TcgTableConfigBO m) {
        QueryWrapper wrapper = query.buildWrapper();
        wrapper.orderByAsc("project_id" );
        wrapper.orderByAsc("is_table" );
        wrapper.orderByAsc("table_name" );
        return wrapper;
    }





}
