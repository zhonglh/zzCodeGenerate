package com.zz.bsmcc.business;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.bms.core.db.entity.*;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.core.exceptions.InternalException;
import com.zz.bms.enums.EnumPageElement;
import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bms.util.base.data.StringUtil;
import com.zz.bms.util.base.java.IdUtils;
import com.zz.bms.util.freemarker.FreemarkerUtil;
import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.logic.TableLogic;
import com.zz.bsmcc.base.po.DictTypePO;
import com.zz.bsmcc.base.po.MenuPO;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.*;
import com.zz.bsmcc.base.query.impl.*;
import com.zz.bsmcc.base.service.*;
import com.zz.bsmcc.core.enums.EnumButtonPosition;
import com.zz.bsmcc.core.enums.EnumPageRelation;
import com.zz.bsmcc.core.enums.EnumTableRelation;
import com.zz.bsmcc.core.enums.EnumTableType;
import com.zz.bsmcc.core.util.CgBeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 代码生成处理
 * @author Administrator
 */
@Component
public class CgBusiness extends CgBaseBusiness{


    public Logger logger = Logger.getLogger(this.getClass());


    @Autowired
    private TcgProjectService tcgProjectService ;
    @Autowired
    private TcgTempletService tcgTempletService ;
    @Autowired
    private TcgModuleConfigService tcgModuleConfigService ;
    @Autowired
    private TcgTempletGroupOperationService tcgTempletGroupOperationService ;

    @Autowired
    private TcgTableOperationService tcgTableOperationService;

    @Autowired
    private TcgOperationService tcgOperationService ;
    @Autowired
    private TcgTableConfigService tcgTableConfigService ;
    @Autowired
    private TcgColumnConfigService tcgColumnConfigService ;
    @Autowired
    private TcgExColumnService tcgExColumnService ;
    @Autowired
    private TcgColumnPageService tcgColumnPageService ;

    @Autowired
    private TcgColumnValidateService tcgColumnValidateService ;
    @Autowired
    private TcgColumnEventService tcgColumnEventService ;
    @Autowired
    private TcgColumnExService tcgColumnExService ;
    @Autowired
    private TcgQueryConfigService tcgQueryConfigService ;
    @Autowired
    private TcgIndexConfigService tcgIndexConfigService ;

    /**
     * 通过模块创建菜单
     * @param menus
     * @param moduleConfigMap
     */
    private void processMenu(List<MenuPO> menus,  List<TcgModuleConfigBO> list,Map<String,TcgModuleConfigBO > moduleConfigMap) {

        for(TcgModuleConfigBO moduleConfigBO : list) {


            MenuPO menu = new MenuPO();
            menu.setId(moduleConfigBO.getId());
            menu.setPid(moduleConfigBO.getPid());
            menu.setName(moduleConfigBO.getModuleResource());
            menu.setTitle(moduleConfigBO.getModuleName());
            menu.setResource(moduleConfigBO.getModuleFullResource());

            String path = moduleConfigBO.getModuleFullResource().replaceAll("/", "");
            menu.setPath(path);

            menu.setLeaf(EnumYesNo.NO.getCode());
            menu.setLevel(moduleConfigBO.getLevel());

            if(StringUtils.isEmpty(moduleConfigBO.getPid())){
                menu.setTopId(menu.getId());
            }else {
                String topId = moduleConfigBO.getId();
                TcgModuleConfigBO parent = moduleConfigMap.get(moduleConfigBO.getPid());
                while(parent != null){
                    topId = parent.getId();
                    if(StringUtils.isNotEmpty(parent.getPid())){
                        parent = moduleConfigMap.get(parent.getPid());
                    }else {
                        break;
                    }
                }
                menu.setTopId(topId);
            }

            menus.add(menu);
        }

    }

    private void setModuleLevel(Map<String,TcgModuleConfigBO > moduleConfigMap){
        for(String key : moduleConfigMap.keySet()) {
            TcgModuleConfigBO moduleConfigBO = moduleConfigMap.get(key);
            if(moduleConfigBO.getLevel() > 0 ){
                continue;
            }
            if(StringUtils.isEmpty(moduleConfigBO.getPid())){
                moduleConfigBO.setLevel(1);
                continue;
            }
            TcgModuleConfigBO parent = moduleConfigMap.get(moduleConfigBO.getPid());
            if (parent != null) {
                if(StringUtils.isEmpty(parent.getPid())){
                    parent.setLevel(1);
                    moduleConfigBO.setLevel(parent.getLevel() + 1);
                }else if (parent.getLevel() > 0){
                    moduleConfigBO.setLevel(parent.getLevel() + 1);
                }else {
                    setParentLevel(parent , moduleConfigMap);
                    moduleConfigBO.setLevel(parent.getLevel() + 1);
                }
            }else {
                throw new InternalException("数据错误， 上级模块不存在" + moduleConfigBO.getModuleName());
            }
        }
    }

    private void setParentLevel(TcgModuleConfigBO moduleConfigBO , Map<String,TcgModuleConfigBO > moduleConfigMap){
        TcgModuleConfigBO parent = moduleConfigMap.get(moduleConfigBO.getPid());
        if (parent != null) {
            if(StringUtils.isEmpty(parent.getPid())){
                parent.setLevel(1);
                moduleConfigBO.setLevel(parent.getLevel() + 1);
            }else if (parent.getLevel() > 0){
                moduleConfigBO.setLevel(parent.getLevel() + 1);
            }else {
                setParentLevel(parent , moduleConfigMap);
                moduleConfigBO.setLevel(parent.getLevel() + 1);
            }
        }else {
            throw new InternalException("数据错误， 上级模块不存在" + moduleConfigBO.getModuleName());
        }

    }

    /**
     * 通过表创建菜单
     * @param menus
     * @param table
     * @param moduleMenus
     */
    private void processMenu(List<MenuPO> menus, TcgTableConfigBO table , List<MenuPO> moduleMenus) {

        if(EnumYesNo.YES.getCode().equals(table.getIsBuildMenu())) {
            MenuPO menu = new MenuPO();
            menu.setId(table.getId());
            menu.setPid(table.getModuleId());
            menu.setName(table.getJavaName());
            menu.setTitle(table.getTableComment());
            menu.setResource(table.getFullResourceName());
            menu.setPath(table.getFullResourceFile());
            menu.setTable(table);

            menu.setLeaf("1");
            menu.setLevel(1);

            if(StringUtils.isNotEmpty(table.getModuleId())){
                for(MenuPO moduleMenu : moduleMenus){
                    if(moduleMenu.getId().equals(table.getModuleId())){
                        menu.setLevel(moduleMenu.getLevel() + 1);
                        menu.setTopId(moduleMenu.getTopId());
                    }
                }
            }else {
                menu.setTopId(menu.getId());
            }

            menus.add(menu);
        }

    }


    /**
     * 生成代码
     * @param projectId
     * @param templetGroupId
     */
    public void cg(String projectId , String templetGroupId , boolean autoBuildView) {
        TcgProjectBO projectBO = tcgProjectService.getById(projectId);
        TcgTempletQuery templetQuery = new TcgTempletQueryImpl();
        templetQuery.groupId(templetGroupId);
        List<TcgTempletBO> templets = tcgTempletService.list(templetQuery.buildWrapper());
        if(templets != null && !templets.isEmpty()) {
            cg(projectBO, templets , autoBuildView);
        }

    }

    /**
     * 生成代码
     * @param projectBO
     * @param templets
     */
    public void cg(TcgProjectBO projectBO, List<TcgTempletBO> templets , boolean autoBuildView ) {

        //所有的字典类型
        Map<String,String> dictTypeMap = new HashMap<String,String>();

        List<MenuPO> menus = new ArrayList<MenuPO>();

        Map<String,TablePO> tablePOMap = new HashMap<String,TablePO>();

        Map<String , TcgTempletGroupOperationBO> operationBOMap = getOperations(templets.get(0).getGroupId());


        TcgModuleConfigQuery moduleConfigQuery = new TcgModuleConfigQueryImpl();
        moduleConfigQuery.projectId(projectBO.getId());
        Map<String,TcgModuleConfigBO> moduleConfigMap = new HashMap<String,TcgModuleConfigBO>();
        QueryWrapper queryWrapper = moduleConfigQuery.buildWrapper();
        queryWrapper.orderByAsc("create_time");
        List<TcgModuleConfigBO> moduleConfigBOs = tcgModuleConfigService.list(queryWrapper);
        if(moduleConfigBOs != null && !moduleConfigBOs.isEmpty()){
            for(TcgModuleConfigBO moduleConfigBO : moduleConfigBOs){
                moduleConfigMap.put(moduleConfigBO.getId() , moduleConfigBO);
            }

            setModuleLevel(moduleConfigMap);

            moduleConfigBOs.sort((o1,o2) -> o1.getLevel() * 100000 - o2.getLevel() * 100000  );


            //处理菜单
            processMenu(menus,moduleConfigBOs ,moduleConfigMap);
        }


        Map<String,TcgTableConfigBO> tableConfigMap = new HashMap<String,TcgTableConfigBO>();
        TcgTableConfigQuery tableConfigQuery = new TcgTableConfigQueryImpl();
        tableConfigQuery.projectId(projectBO.getId());
        QueryWrapper tableWrapper = tableConfigQuery.buildWrapper();

        tableWrapper.orderByDesc("is_table" );
        tableWrapper.orderByAsc("create_time" );
        List<TcgTableConfigBO> tableConfigs = tcgTableConfigService.list(tableWrapper);


        boolean isColumnError = false;
        boolean isViewError = false;
        StringBuilder columnErrorSb = new StringBuilder(" 下列表没有设置业务名称列 : \r\n");
        //StringBuilder mainTableErrorSb = new StringBuilder(" \r\n 下列视图没有设置对应的主表信息 : \n");
        for(TcgTableConfigBO tableConfig : tableConfigs){
            tableConfigMap.put(tableConfig.getSchemaName()+"."+tableConfig.getTableName(), tableConfig);
            tableConfigMap.put(tableConfig.getId(), tableConfig);

            //处理表的资源和包名
            processTableResource(projectBO, moduleConfigMap, tableConfig);

            if(EnumYesNo.YES.getCode().equals(tableConfig.getIsTable())) {
                if (EnumYesNo.YES.getCode().equals(tableConfig.getIsTree()) && StringUtils.isEmpty(tableConfig.getBusinessName())) {
                    columnErrorSb.append(tableConfig.getTableComment() + "(" + tableConfig.getTableName() + ") \r\n ");
                    isColumnError = true;
                }
            }

            TablePO tablePO = new TablePO();
            tablePO.setTableBO(tableConfig);
            tablePOMap.put(tableConfig.getId(),tablePO);
            tablePOMap.put(tableConfig.getSchemaName()+tableConfig.getTableName(),tablePO);
        }

        if(isColumnError){
            throw new BizException(columnErrorSb.toString());
        }



        //所有列
        Map<String , TcgColumnConfigBO> allColumnMap = new HashMap<String , TcgColumnConfigBO>();
        //所有外键类型扩展列
        Map<String , TcgExColumnBO> allExFkColumnMap = new HashMap<String , TcgExColumnBO>();
        Map<String , TcgExColumnBO> allExColumnMap = new HashMap<String , TcgExColumnBO>();


        for(TcgTableConfigBO tableConfig : tableConfigs){
            Map<String,Object> searchMap = new HashMap<String,Object>();
            searchMap.put("table_id" , tableConfig.getId());


            tableConfig.setChildFkTables(new ArrayList<TcgTableConfigBO>());
            tableConfig.setChildFkColumns(new ArrayList<TcgColumnConfigBO>());
            tableConfig.setPageChildTables(new ArrayList<TcgTableConfigBO>());
            tableConfig.setPageChildColumns(new ArrayList<TcgColumnConfigBO>());
            tableConfig.setPageChildTableSet(new HashSet<TcgTableConfigBO>());
            tableConfig.setNotPageChildTables(new ArrayList<TcgTableConfigBO>());
            tableConfig.setNotPageChildColumns(new ArrayList<TcgColumnConfigBO>());





            Map<String , TcgColumnConfigBO> columnMap = new HashMap<String , TcgColumnConfigBO>();
            List<TcgColumnConfigBO> columns = (List<TcgColumnConfigBO>)tcgColumnConfigService.listByMap(searchMap);


            //处理表对应实体类的 imports 和 基类
            processTableImprotAndParent(tableConfig, columns );

            //处理列的信息
            if(columns != null && !columns.isEmpty()) {


                processColumnConfig(tableConfig , columns , tableConfigMap , columnMap , allColumnMap);
                columns.sort(new Comparator<TcgColumnConfigBO>(){
                    @Override
                    public int compare(TcgColumnConfigBO o1, TcgColumnConfigBO o2) {
                        return o1.getColumnSort().compareTo(o2.getColumnSort());
                    }
                });
            }else {
                throw new BizException(" 没有列的信息 :"+tableConfig.getTableComment());
            }


            //处理表的 业务名称列和业务主键列
            processTableBusiness(  tableConfig ,columnMap);




            //处理扩展列的信息
            Map<String,List<TcgExColumnBO>> exMap = null;
            Map<String,List<TcgExColumnBO>> exFkMap = null;
            Map<String,List<TcgExColumnBO>> exDictMap = null;
            Map<String , TcgExColumnBO> exColumnMap = new HashMap<String , TcgExColumnBO>();

            List<TcgExColumnBO> exColumns = (List<TcgExColumnBO>)tcgExColumnService.listByMap(searchMap);
            if(exColumns != null && !exColumns.isEmpty()) {
                exColumns.sort(new Comparator<TcgExColumnBO>() {
                    @Override
                    public int compare(TcgExColumnBO o1, TcgExColumnBO o2) {
                        return o1.getColumnSort().compareTo(o2.getColumnSort());
                    }
                });

                //处理扩展列的信息
                processExColumn(tableConfig ,exColumns , columns , exColumnMap);
                Map<String,List<TcgExColumnBO>>[] mapArray = processExColumnMap(exColumns);
                exMap = mapArray[0];
                exFkMap = mapArray[1];
                exDictMap = mapArray[2];

                exColumns.forEach(item -> {
                    if(EnumYesNo.YES.getCode().equals(item.getOriginalColumnFk())) {
                        allExFkColumnMap.put(item.getId(), item);
                    }

                    String tableColumnKey = tableConfig.getSchemaName().trim().toLowerCase() +
                            tableConfig.getTableName().trim().toLowerCase() + item.getFkColumnName().trim().toLowerCase();
                    allExColumnMap.put(tableColumnKey , item);
                });


            }

            //处理列界面信息
            Map<String ,TcgColumnPageBO> columnPageMap = new HashMap<String ,TcgColumnPageBO>();
            List<TcgColumnPageBO> columnPages = (List<TcgColumnPageBO>)tcgColumnPageService.listByMap(searchMap);
            if(columnPages != null && !columnPages.isEmpty()) {
                //处理列界面设置信息
                processColumnPage(columnMap , exColumnMap , columnPages , columnPageMap);

                columnPages.sort(new Comparator<TcgColumnPageBO>() {
                    @Override
                    public int compare(TcgColumnPageBO o1, TcgColumnPageBO o2) {
                        Integer s1 = ( o1.getColumnConfig() != null ? o1.getColumnConfig().getColumnSort() : o1.getExColumn().getColumnSort());
                        Integer s2 = ( o2.getColumnConfig() != null ? o2.getColumnConfig().getColumnSort() : o2.getExColumn().getColumnSort());
                        return s1.compareTo(s2);
                    }
                });
            }else {
                throw new BizException(" 没有界面配置信息 :"+tableConfig.getTableComment());
            }

            //处理列校验信息
            List<TcgColumnValidateBO> validates = (List<TcgColumnValidateBO>)tcgColumnValidateService.listByMap(searchMap);
            if(validates != null && !validates.isEmpty()){
                for(TcgColumnValidateBO validate : validates){
                    TcgColumnPageBO columnPage = columnPageMap.get(validate.getColumnId());
                    if(columnPage == null){
                        throw new BizException("列校验设置错误 ： "+ validate.getColumnComment());
                    }
                    validate.setColumnPage(columnPage);
                }
                validates.sort(new Comparator<TcgColumnValidateBO>() {
                    @Override
                    public int compare(TcgColumnValidateBO o1, TcgColumnValidateBO o2) {
                        Integer s1 = ( o1.getColumnPage().getColumnConfig() != null ? o1.getColumnPage().getColumnConfig().getColumnSort() : o1.getColumnPage().getExColumn().getColumnSort());
                        Integer s2 = ( o2.getColumnPage().getColumnConfig() != null ? o2.getColumnPage().getColumnConfig().getColumnSort() : o2.getColumnPage().getExColumn().getColumnSort());
                        return s1.compareTo(s2);
                    }
                });

            }

            //处理列事件
            List<TcgColumnEventBO> events = (List<TcgColumnEventBO>)tcgColumnEventService.listByMap(searchMap);
            if(events != null && !events.isEmpty()){
                for(TcgColumnEventBO event  : events){
                    TcgColumnPageBO columnPage = columnPageMap.get(event.getColumnId());
                    if(columnPage == null){
                        throw new BizException("列校验设置错误 ： "+ event.getColumnComment());
                    }
                    event.setColumnPage(columnPage);
                }
                events.sort(new Comparator<TcgColumnEventBO>() {
                    @Override
                    public int compare(TcgColumnEventBO o1, TcgColumnEventBO o2) {
                        Integer s1 = ( o1.getColumnPage().getColumnConfig() != null ? o1.getColumnPage().getColumnConfig().getColumnSort() : o1.getColumnPage().getExColumn().getColumnSort());
                        Integer s2 = ( o2.getColumnPage().getColumnConfig() != null ? o2.getColumnPage().getColumnConfig().getColumnSort() : o2.getColumnPage().getExColumn().getColumnSort());
                        return s1.compareTo(s2);
                    }
                });

            }

            //处理查询条件
            List<TcgQueryConfigBO> queryConfigs = (List<TcgQueryConfigBO>)tcgQueryConfigService.listByMap(searchMap);
            if(queryConfigs != null && !queryConfigs.isEmpty()){
                for(TcgQueryConfigBO queryConfig  : queryConfigs){
                    TcgColumnPageBO columnPage = columnPageMap.get(queryConfig.getColumnId());
                    if(columnPage == null){
                        ;
                    }else {
                        queryConfig.setColumnPage(columnPage);
                    }
                }
                queryConfigs.sort(new Comparator<TcgQueryConfigBO>() {
                    @Override
                    public int compare(TcgQueryConfigBO o1, TcgQueryConfigBO o2) {
                        return o1.getQuerySort().compareTo(o2.getQuerySort());
                    }
                });
            }

            //处理索引
            List<TcgIndexConfigBO> indexs = (List<TcgIndexConfigBO>)tcgIndexConfigService.listByMap(searchMap);
            if(indexs != null && !indexs.isEmpty()){
                for(TcgIndexConfigBO index : indexs){
                    if(StringUtils.isEmpty(index.getIndexCloumns())){
                        throw new BizException("索引中没有列的信息 : "+index.getIndexName());
                    }
                    String[] columnNames = index.getIndexCloumns().split(",");
                    index.setColumns(new ArrayList<TcgColumnConfigBO>());
                    for(String columnName : columnNames){

                        TcgColumnConfigBO column = columnMap.get(columnName);
                        if(column == null){
                            throw new BizException("索引中没有列名称设置错误 : "+index.getIndexName());
                        }
                        index.getColumns().add(column);
                    }
                }
            }


            //处理视图的主表
            if(EnumYesNo.NO.getCode().equals(tableConfig.getIsTable())){

                if(StringUtils.isNotEmpty(tableConfig.getMainTableName())){
                    TablePO po = tablePOMap.get(tableConfig.getMainTableSchema()+tableConfig.getMainTableName());
                    if(po != null){
                        tableConfig.setMainTableConfig(po.getTableBO());
                        tableConfig.setTableOtherComment(po.getTableBO().getTableOtherComment());
                        tableConfig.setTableComment(po.getTableBO().getTableComment());

                        if(StringUtils.isEmpty(tableConfig.getIsTree())){
                            tableConfig.setIsTree(po.getTableBO().getIsTree());
                        }
                        if(StringUtils.isEmpty(tableConfig.getParentFieldName())){
                            tableConfig.setParentFieldName(po.getTableBO().getParentFieldName());
                        }

                        if(StringUtils.isEmpty(tableConfig.getBusinessKey())){
                            tableConfig.setBusinessKey(po.getTableBO().getBusinessKey());
                        }

                        if(StringUtils.isEmpty(tableConfig.getBusinessName())){
                            tableConfig.setBusinessName(po.getTableBO().getBusinessName());
                        }



                        //视图的实体类是继承表的实体类， 需要重新设置列是否要在类中
                        processColumnConfig(tableConfig , columns , po.getColumns());

                        //将表的 约束加到视图中来
                        if(indexs == null || indexs.isEmpty()){
                            indexs = po.getIndexs();
                        }

                        if(po.getTableBO().getReciprocalView() == null){
                            po.getTableBO().setReciprocalView(tableConfig);
                        }
                    }
                }
            }

            for(TcgColumnConfigBO column : columns){
                if(EnumYesNo.YES.getCode().equals(column.getColumnIsdict()) && StringUtils.isNotEmpty(column.getDictType())){
                    dictTypeMap.put(column.getDictType().trim().toLowerCase() , column.getColumnComment());
                }
            }



            TablePO tablePO = tablePOMap.get( tableConfig.getId());
            tablePO.setTableBO(tableConfig);
            tablePO.setColumns(columns);
            tablePO.setExColumns(exColumns);
            tablePO.setExColumnMap(exMap);
            tablePO.setExFkColumnMap(exFkMap);
            tablePO.setExDictColumnMap(exDictMap);

            tablePO.setColumnPages(columnPages);
            tablePO.setColumnValidates(validates);
            tablePO.setColumnEvents(events);


            List<TcgColumnPageBO> showPages = new ArrayList<TcgColumnPageBO>();
            for(TcgColumnPageBO page : columnPages){
                if(EnumYesNo.YES.getCode().equals(page.getExistPage()) && EnumYesNo.NO.getCode().equals(page.getHiddenable())){
                    showPages.add(page);
                }
            }
            tablePO.setShowPages(showPages);


            List listColumnPages = tablePO.getColumnPages().stream().filter(item -> EnumYesNo.YES.getCode().equals(item.getListShowable())).collect(Collectors.toList());
            tablePO.setListColumnPages(listColumnPages);

            processPageOther(tablePO);
            tableConfig.setTablePO(tablePO);

            tablePO.setIndexs(indexs);
            tablePO.setQueryConfigs(queryConfigs);


            processQueryFkDict(tablePO);
            processFkDict(tablePO);

            //处理操作
            TcgTableOperationQuery tableOperationQuery = new TcgTableOperationQueryImpl();
            tableOperationQuery.tableId(tableConfig.getId());
            List<TcgTableOperationBO> tableOperations = tcgTableOperationService.list(tableOperationQuery.buildWrapper());
            tablePO.setTableOperations(tableOperations);

            if(operationBOMap == null || operationBOMap.isEmpty()){
                tablePO.setTempletGroupOperations(new ArrayList<>());
            }else {
                if (tableOperations != null && !tableOperations.isEmpty()) {

                    Map<String, TcgTempletGroupOperationBO> tableOperationMap = new HashMap<String, TcgTempletGroupOperationBO>();
                    for(TcgTableOperationBO tableOperation : tableOperations){
                        if(operationBOMap.containsKey(tableOperation.getOperationId())){
                            tableOperationMap.put(tableOperation.getOperationId() , operationBOMap.get(tableOperation.getOperationId()));
                        }
                    }

                    List<TcgTempletGroupOperationBO> operations = new ArrayList<TcgTempletGroupOperationBO>(tableOperationMap.values());
                    tablePO.setTempletGroupOperations(operations);
                } else {
                    tablePO.setTempletGroupOperations(new ArrayList<>());
                }
            }

            tablePO.getTempletGroupOperations().sort(new Comparator<TcgTempletGroupOperationBO>() {
                @Override
                public int compare(TcgTempletGroupOperationBO o1, TcgTempletGroupOperationBO o2) {
                    return o1.getSort() > o2.getSort() ? 1 : (o1.getSort() < o2.getSort()? -1 : 0);
                }
            });


            if(EnumYesNo.YES.getCode().equals(tableConfig.getIsBuildMenu())) {
                //处理菜单
                processMenu(menus, tableConfig, menus);
            }


        }

        //处理 tableBO的 childFkTables , 就是拿到表的 子表信息
        for(TcgTableConfigBO tableConfig : tableConfigs){
            if(tableConfig.getFkTables() != null && !tableConfig.getFkTables().isEmpty()){
                int index = 0;
                for(TcgTableConfigBO p : tableConfig.getFkTables()){
                    if(EnumTableType.singleTable.getVal().equalsIgnoreCase(p.getTableType()) ){
                        index ++;
                        continue;
                    }
                    p.getChildFkTables().add(tableConfig);
                    p.getChildFkColumns().add(tableConfig.getFkColumns().get(index));
                    if(EnumPageRelation.embed.getVal().equals(tableConfig.getPageRelation())){
                        p.getPageChildTables().add(tableConfig);
                        p.getPageChildColumns().add(tableConfig.getFkColumns().get(index));
                        if(EnumTableRelation.one2multi.getVal().equalsIgnoreCase(tableConfig.getTableRelation())){
                            if(tableConfig.getFkTables() != null && !tableConfig.getFkTables().isEmpty()) {
                                for (TcgTableConfigBO fkTable : tableConfig.getFkTables()) {
                                    p.getPageChildTableSet().add(fkTable);
                                }
                            }
                        }
                    }else {
                        p.getNotPageChildTables().add(tableConfig);
                        p.getNotPageChildColumns().add(tableConfig.getFkColumns().get(index));
                    }
                    index ++;
                }
            }

        }

        for(Map.Entry<String , TcgExColumnBO> exColumnEntry : allExFkColumnMap.entrySet()){

            TcgExColumnBO exColumnBO = exColumnEntry.getValue();
            if(exColumnBO.getOriginalColumn() == null){
                continue;
            }
            String tableColumnKey = exColumnBO.getOriginalColumn().getFkSchema().trim().toLowerCase() + exColumnBO.getOriginalColumn().getFkName().trim().toLowerCase() + exColumnBO.getFkColumnName().trim().toLowerCase();

            TcgColumnConfigBO columnConfigBO = allColumnMap.get(tableColumnKey);
            if (columnConfigBO == null) {
                TcgExColumnBO tcgExColumnBO = allExColumnMap.get(tableColumnKey);
                if(tcgExColumnBO == null) {
                    throw new RuntimeException(exColumnBO.getTableBO().getTableName() + "表 " + exColumnBO.getColumnTitle() + "列  设置错误");
                }
            }
            exColumnBO.setFkColumn(columnConfigBO);


        }




        for(TcgTableConfigBO tableConfig : tableConfigs){
            if(tableConfig.getPageChildTables() != null && !tableConfig.getPageChildTables().isEmpty()){
                tableConfig.setChildListDicts(new ArrayList<String>());
                tableConfig.setDictAllTypes(new ArrayList<String>());
                if(tableConfig.getDictTypes() != null && !tableConfig.getDictTypes().isEmpty()){
                    tableConfig.getDictAllTypes().addAll(tableConfig.getDictTypes());
                }
                for(TcgTableConfigBO child : tableConfig.getPageChildTables()){
                    if(EnumTableRelation.one2multi.getVal().equalsIgnoreCase(child.getTableRelation())){
                        if(child.getDictTypes() != null && !child.getDictTypes().isEmpty()) {
                            tableConfig.getChildListDicts().addAll(child.getDictTypes());
                        }
                    }
                    if(child.getDictTypes() != null && !child.getDictTypes().isEmpty()) {
                        tableConfig.getDictAllTypes().addAll(child.getDictTypes());
                    }

                }

                if(!tableConfig.getDictAllTypes().isEmpty()) {
                    Set<String> set = new HashSet<String>(tableConfig.getDictAllTypes());
                    tableConfig.setDictAllTypes(Arrays.asList(set.toArray(new String[tableConfig.getDictAllTypes().size()])));
                }


                if(!tableConfig.getChildListDicts().isEmpty()) {
                    Set<String> set1 = new HashSet<String>(tableConfig.getChildListDicts());
                    tableConfig.setChildListDicts(Arrays.asList(set1.toArray(new String[tableConfig.getChildListDicts().size()])));
                }

            }else {
                if(tableConfig.getDictTypes() != null && !tableConfig.getDictTypes().isEmpty()){
                    tableConfig.setDictAllTypes(tableConfig.getDictTypes());
                }
            }


        }

        //设置表对应的视图
        for(TcgTableConfigBO tableConfig : tableConfigs){
            if(EnumYesNo.YES.getCode().equals(tableConfig.getIsTable())){
                String viewName = "V"+tableConfig.getTableName().substring(1);
                TablePO po = tablePOMap.get(tableConfig.getSchemaName()+viewName );
                if(po != null && po.getTableBO() != null){
                    tableConfig.setReciprocalView(po.getTableBO());
                }
            }
        }


        //生成菜单SQL
        List<MenuPO> topMenus = new ArrayList<MenuPO>();
        Map<MenuPO,List<MenuPO>> menusMap = new HashMap<MenuPO,List<MenuPO>>();
        for(MenuPO menuPO : menus){
            if(menuPO.getId().equals(menuPO.getTopId())){
                topMenus.add(menuPO);
            }
        }
        for(MenuPO top : topMenus){
            List<MenuPO> subMenus = new ArrayList<MenuPO>() ;

            for(MenuPO menuPO : menus){
                if(menuPO.getTopId().equals(top.getTopId())){
                    subMenus.add(menuPO);

                }
            }
            menusMap.put(top , subMenus);
        }
        //生成菜单
        cgMenuSql(templets, menusMap);





        Map<MenuPO,List<TablePO>> tableMap = new HashMap<MenuPO,List<TablePO>>();
        for(MenuPO top : topMenus){
            List<TablePO> subTables = new ArrayList<TablePO>();

            for(MenuPO menuPO : menus) {
                if (menuPO.getTopId().equals(top.getTopId())) {

                    for(TablePO tp : tablePOMap.values()){
                        if(menuPO.getId().equals(tp.getTableBO().getModuleId())){
                            subTables.add(tp);
                        }
                    }
                }
            }
            HashSet<TablePO> set = new HashSet(subTables);
            tableMap.put(top , new ArrayList(set));
        }

        List<TablePO> topTables = new ArrayList<TablePO>();
        for(TablePO tp : tablePOMap.values()){
            if(StringUtils.isEmpty(tp.getTableBO().getModuleId())){
                topTables.add(tp);
            }
        }
        if(!topTables.isEmpty()){
            MenuPO top = new MenuPO();
            top.setId(IdUtils.getId());
            top.setResource("/null");
            tableMap.put(top , topTables);
        }
        //生成权限SQL
        cgRbacCode(tableMap ,projectBO, templets);


        //处理字典信息
        if(!dictTypeMap.isEmpty()){

            //生成字典枚举类
            DictTypeBusiness.buildDictType(projectBO, dictTypeMap);


            List<DictTypePO> dictTypes = new ArrayList<DictTypePO>();

            for(Map.Entry<String,String> entry : dictTypeMap.entrySet()){
                DictTypePO dictTypePO = new DictTypePO(IdUtils.getId() , entry.getKey() , entry.getValue());
                dictTypes.add(dictTypePO);
            }

            //生成字典SQL
            String basePath = BusinessUtil.getBasePath();
            for (TcgTempletBO templet : templets) {
                if (StringUtils.isEmpty(templet.getIsDictSql()) ||EnumYesNo.NO.getCode().equals(templet.getIsDictSql())) {
                    continue;
                }

                String filePath = basePath + File.separator + templet.getFileOutDir();
                String fileName =   (templet.getFileSuffix().isEmpty() ? "" : templet.getFileSuffix()) +
                        "." + templet.getFileType();
                Map<String, Object> model = new HashMap<>();
                model.put("templet", templet);
                model.put("dictTypes", dictTypes);
                String templetContent = templet.getTempletContent();
                String result = FreemarkerUtil.renderString(templetContent, model);
                BusinessUtil.buildFile(filePath, fileName, result);

            }

        }

        //生成代码
        for(TablePO tablePO : tablePOMap.values()){
            cgCode(tablePO, projectBO, templets);
        }

    }

    private void cgMenuSql(List<TcgTempletBO> templets, Map<MenuPO, List<MenuPO>> menusMap) {
        String basePath = BusinessUtil.getBasePath();

        for(Map.Entry<MenuPO , List<MenuPO>> entry : menusMap.entrySet()) {

            MenuPO top = entry.getKey();
            List<MenuPO> subList = entry.getValue();

            for (TcgTempletBO templet : templets) {
                if (StringUtils.isEmpty(templet.getIsMenuSql()) || EnumYesNo.NO.getCode().equals(templet.getIsMenuSql())) {
                    continue;
                }

                String filePath = basePath + File.separator + templet.getFileOutDir();
                String fileName = (templet.getFileSuffix().isEmpty() ? "" : templet.getFileSuffix()) +
                        "." + templet.getFileType();
                fileName = top.getResource()+"_"+fileName;

                Map<String, Object> model = new HashMap<>();

                model.put("templet", templet);
                model.put("menus", subList);

                String templetContent = templet.getTempletContent();

                String result = FreemarkerUtil.renderString(templetContent, model);

                BusinessUtil.buildFile(filePath, fileName, result);


            }
        }
    }

    private void cgRbacCode(Map<MenuPO,List<TablePO>> tableMap, TcgProjectBO projectBO, List<TcgTempletBO> templets) {

        StringBuilder projectNoteBuild = BusinessUtil.getProjectNote(projectBO);

        for(Map.Entry<MenuPO , List<TablePO>> entry : tableMap.entrySet()) {

            String basePath = BusinessUtil.getBasePath();
            StringBuilder sb = new StringBuilder("");
            String filePath = null;


            String fileName = entry.getKey().getResource().substring(1)+".sql";


            for (TablePO tablePO : entry.getValue()) {



                for (TcgTempletBO templet : templets) {

                    //如果表里设置的不生成权限SQL, 而模板是权限SQL的模板， 将不继续
                    if(EnumYesNo.YES.getCode().equals(tablePO.getTableBO().getIsBuildRbac()) &&
                            EnumYesNo.YES.getCode().equals(templet.getIsRbacSql())){
                        ;
                    }else {
                        continue;
                    }


                    filePath = basePath + File.separator + templet.getFileOutDir() + File.separator + templet.getFileInnerDir();




                    Map<String, Object> model = buildModel(tablePO, projectBO);

                    model.put("templet", templet);


                    String templetContent = templet.getTempletContent();


                    String result = FreemarkerUtil.renderString(templetContent, model);

                    sb.append("\r\n");
                    sb.append("\r\n");
                    sb.append(result) ;

                }
            }


            BusinessUtil.buildFile(filePath, fileName, sb.toString());
        }
    }


    /**
     * 处理 columnPage 的 events , validates
     * @param tablePO
     */
    private void processPageOther(TablePO tablePO) {
        if(tablePO.getColumnPages() == null || tablePO.getColumnPages().isEmpty()){
            return ;
        }


        if( tablePO.getColumnEvents() != null && !tablePO.getColumnEvents().isEmpty()) {
            for (TcgColumnEventBO event : tablePO.getColumnEvents()){
                TcgColumnPageBO page = event.getColumnPage();
                if(page.getEvents() == null){
                    page.setEvents(new ArrayList<TcgColumnEventBO>());
                }
                page.getEvents().add(event);
            }
        }

        if( tablePO.getColumnValidates() != null && !tablePO.getColumnValidates().isEmpty()) {
            for (TcgColumnValidateBO validate : tablePO.getColumnValidates()){
                TcgColumnPageBO page = validate.getColumnPage();
                if(page.getValidates() == null){
                    page.setValidates(new ArrayList<TcgColumnValidateBO>());
                }
                page.getValidates().add(validate);
            }
        }

    }


    /**
     * 生成代码
     * @param tablePO
     */
    private void cgCode(TablePO tablePO , TcgProjectBO projectBO, List<TcgTempletBO> templets) {

        String basePath = BusinessUtil.getBasePath();


        StringBuilder projectNoteBuild = BusinessUtil.getProjectNote(projectBO);


        for(TcgTempletBO templet : templets){


            //菜单SQL模板 不在这里处理
            if(EnumYesNo.YES.getCode().equals(templet.getIsMenuSql())){
                continue;
            }


            //字典SQL模板 不在这里处理
            if(EnumYesNo.YES.getCode().equals(templet.getIsDictSql())){
                continue;
            }

            //字典SQL模板 不在这里处理
            if(EnumYesNo.YES.getCode().equals(templet.getIsRbacSql())){
                continue;
            }



            //如果表里设置的不生成UI, 而模板是UI的模板， 将不继续
            if(EnumYesNo.NO.getCode().equals(tablePO.getTableBO().getIsBuildUi()) &&  EnumYesNo.YES.getCode().equals(templet.getIsUi())){
                continue;
            }

            //视图不生成UI
            if(
                    EnumYesNo.NO.getCode().equals(tablePO.getTableBO().getIsTable()) &&
                    (EnumYesNo.YES.getCode().equals(templet.getIsUi()) || EnumYesNo.YES.getCode().equals(templet.getIsRbacSql()) )
            ){
                continue;
            }





            if(StringUtils.isNotEmpty(templet.getEffectiveReal())){
                if(EnumYesNo.YES.getCode().equals(templet.getEffectiveReal()) && EnumYesNo.NO.getCode().equals(tablePO.getTableBO().getIsReal())){
                    continue;
                }
                if(EnumYesNo.NO.getCode().equals(templet.getEffectiveReal()) && EnumYesNo.YES.getCode().equals(tablePO.getTableBO().getIsReal())){
                    continue;
                }
            }


            if(StringUtils.isNotEmpty(templet.getEffectiveTree())){
                if(EnumYesNo.YES.getCode().equals(templet.getEffectiveTree()) && EnumYesNo.NO.getCode().equals(tablePO.getTableBO().getIsTree())){
                    continue;
                }
                if(EnumYesNo.NO.getCode().equals(templet.getEffectiveTree()) && EnumYesNo.YES.getCode().equals(tablePO.getTableBO().getIsTree())){
                    continue;
                }
            }


            if(StringUtils.isNotEmpty(templet.getEffectiveSingle())){
                if(EnumYesNo.YES.getCode().equals(templet.getEffectiveSingle()) && !tablePO.getTableBO().getPageChildTables().isEmpty()){
                    continue;
                }
                if(EnumYesNo.NO.getCode().equals(templet.getEffectiveSingle()) && tablePO.getTableBO().getPageChildTables().isEmpty()){
                    continue;
                }
            }

            if( this.isComponent(tablePO.getTableBO().getSchemaName() , tablePO.getTableBO().getTableName())  ){
                if("java".equalsIgnoreCase(templet.getFileType()) || "xml".equalsIgnoreCase(templet.getFileType())){
                    //第三方（或者组件）用到的表， Java和XML文件将不再生成
                    continue;
                }

            }

            String filePath = null;
            if("java".equalsIgnoreCase(templet.getFileType())){
                filePath = basePath + File.separator + templet.getFileOutDir() + File.separator +
                        tablePO.getTableBO().getFullPackageName().replaceAll("\\.","/") +
                        File.separator +templet.getFileInnerDir();
            }else if(EnumYesNo.YES.getCode().equals(templet.getIsUi())){
                filePath = basePath + File.separator + templet.getFileOutDir() + File.separator +
                        tablePO.getTableBO().getFullResourceName().replaceAll("//",File.separator);

            }else {
                filePath = basePath + File.separator + templet.getFileOutDir() + File.separator + templet.getFileInnerDir();
            }

            String fileName = ( EnumYesNo.YES.getCode().equals(templet.getHaveObjectName()) ? tablePO.getTableBO().getJavaName(): "" ) +
                    (templet.getFileSuffix().isEmpty()?"":templet.getFileSuffix()) +
                    "."+templet.getFileType();


            Map<String  , Object >  model = buildModel(tablePO , projectBO);

            model.put("templet" , templet) ;


            String templetContent = templet.getTempletContent();

            //生成的 Java 文件加上项目的总注释
            if("java".equalsIgnoreCase(templet.getFileType())) {
                templetContent =  projectNoteBuild.toString() + templetContent;
            }

            System.out.println("table:"+tablePO.getTableBO().getTableName() + " =====  templet :"+ templet.getTempletTitle() +  " =====  FileName :" +(filePath + fileName));


            String result = FreemarkerUtil.renderString( templetContent , model);

            BusinessUtil.buildFile(filePath, fileName, result);



        }


    }




    /**
     * 构建模板需要的变量
     * @param tablePO
     * @param projectBO
     * @return
     */
    public Map<String  , Object > buildModel(TablePO tablePO , TcgProjectBO projectBO){

        /**
         * 如果项目中设置了界面使用视图， 那么在表格对应的UI就不生成了
         */
        /*if(EnumYesNo.YES.getCode().equals(projectBO.getPageUseView())){
            if(EnumYesNo.YES.getCode().equals(tablePO.getTableBO().getIsTable())){
                tablePO.getTableBO().setIsBuildUi(EnumYesNo.NO.getCode());
            }
        }*/



        Map<String  , Object > freemarkerModel = new HashMap<String  , Object>();
        freemarkerModel.put("table" , tablePO.getTableBO());
        freemarkerModel.put("columns" , tablePO.getColumns());
        freemarkerModel.put("exColumns" , tablePO.getExColumns());
        freemarkerModel.put("exColumnMap" , tablePO.getExColumnMap());
        freemarkerModel.put("exFkColumnMap" , tablePO.getExFkColumnMap());
        freemarkerModel.put("exDictColumnMap" , tablePO.getExDictColumnMap());


        freemarkerModel.put("columnPages" , tablePO.getColumnPages());
        freemarkerModel.put("columnPageMap" , processColumnPageBOMap(tablePO.getColumnPages()));


        freemarkerModel.put("showColumnPages" , tablePO.getShowPages());
        freemarkerModel.put("columnEvents" , tablePO.getColumnEvents());
        freemarkerModel.put("columnValidates" , tablePO.getColumnValidates());


        if(tablePO.getListColumnPages() != null && !tablePO.getListColumnPages().isEmpty()) {
            freemarkerModel.put("listColumnPages", tablePO.getListColumnPages());
        }


        freemarkerModel.put("indexs" , tablePO.getIndexs());
        freemarkerModel.put("querys" , tablePO.getQueryConfigs());
        freemarkerModel.put("operations" , tablePO.getTempletGroupOperations());

        List<TcgTempletGroupOperationBO> topOperations = new ArrayList<TcgTempletGroupOperationBO>();
        List<TcgTempletGroupOperationBO> rightOperations = new ArrayList<TcgTempletGroupOperationBO>();
        for(TcgTempletGroupOperationBO operationBO : tablePO.getTempletGroupOperations()){

            if(operationBO.getPosition().equals(EnumButtonPosition.all.getVal()) ){
                topOperations.add(0,operationBO);
                rightOperations.add(operationBO);
            }else {

                if (operationBO.getPosition().equals(EnumButtonPosition.top.getVal())) {
                    topOperations.add(0,operationBO);
                } else {
                    rightOperations.add(operationBO);
                }
            }
        }
        freemarkerModel.put("topOperations" , topOperations);
        freemarkerModel.put("rightOperations" , rightOperations);


        freemarkerModel.put("tableoperations" , tablePO.getTableOperations());

        freemarkerModel.put("queryDicts" , tablePO.getQueryDicts());
        freemarkerModel.put("queryFks" , tablePO.getQueryFks());
        freemarkerModel.put("queryFkTables" , tablePO.getQueryFkTables());
        freemarkerModel.put("queryDictSet" , tablePO.getQueryDictSet().values());


        freemarkerModel.put("dicts" , tablePO.getDicts());
        freemarkerModel.put("fks" , tablePO.getFks());
        freemarkerModel.put("fkTables" , tablePO.getFkTables());
        freemarkerModel.put("dictSet" , tablePO.getDictSet().values());



        freemarkerModel.put("project" , projectBO);

        return freemarkerModel;
    }


    /**
     * 处理用于查询界面的弹框选择和字典选择
     * @param tablePO
     */
    private void processQueryFkDict(TablePO tablePO) {
        List<TcgQueryConfigBO> queryDicts = new ArrayList<TcgQueryConfigBO>();
        Map<String,TcgQueryConfigBO> queryDictSet = new HashMap<String,TcgQueryConfigBO>();
        Map<String,List<TcgQueryConfigBO>> fkMap = new HashMap<String,List<TcgQueryConfigBO>>();

        Map<String,TcgTableConfigBO> queryFkTableMap = new HashMap<String,TcgTableConfigBO>();
        if(tablePO.getQueryConfigs() != null && !tablePO.getQueryConfigs().isEmpty()){
            for(TcgQueryConfigBO query : tablePO.getQueryConfigs() ){
                if(query.getColumnPage() != null &&
                        EnumPageElement.openwin.getVal().equals(query.getColumnPage().getElement())){
                    String key = null;
                    if(query.getColumnPage().getExColumn() != null){
                        key = query.getColumnPage().getExColumn().getOriginalColumn().getFkTableConfig().getFullResourceFile();
                        queryFkTableMap.put(key,query.getColumnPage().getExColumn().getOriginalColumn().getFkTableConfig());
                    }else {
                        if(query.getColumnPage().getColumnConfig() != null && StringUtils.isNotEmpty(query.getColumnPage().getColumnConfig().getGroupCode())) {
                            TcgColumnConfigBO originalColumn = getOriginalColumnByGroup(query.getColumnPage().getColumnConfig().getGroupCode(), tablePO.getColumns());
                            key = originalColumn.getFkTableConfig().getFullResourceFile();
                            query.getColumnPage().getColumnConfig().setOriginalColumn(originalColumn);
                            queryFkTableMap.put(key,originalColumn.getFkTableConfig());
                        }else {
                            continue;
                        }
                    }
                    List<TcgQueryConfigBO> list = fkMap.get(key);
                    if(list == null){
                        list = new ArrayList<TcgQueryConfigBO>();
                        fkMap.put(key,list);
                    }
                    list.add(query);
                }else  if(query.getColumnPage() != null &&
                        (
                            EnumPageElement.select.getVal().equals(query.getColumnPage().getElement()) ||
                            EnumPageElement.checkbox.getVal().equals(query.getColumnPage().getElement()) ||
                            EnumPageElement.radio.getVal().equals(query.getColumnPage().getElement())
                        )
                ){
                    queryDicts.add(query);
                    String key = null;

                    if(query.getColumnPage().getExColumn()!=null){
                        key = query.getColumnPage().getExColumn().getDictType();
                    }else {
                            key = query.getColumnPage().getColumnConfig().getDictType();
                    }
                    queryDictSet.put(key, query);
                }
            }

        }

        tablePO.setQueryDicts(queryDicts);
        tablePO.setQueryFks(fkMap);

        tablePO.setQueryFkTables(new ArrayList<TcgTableConfigBO>(queryFkTableMap.values()));
        tablePO.setQueryDictSet(queryDictSet);
    }


    /**
     * 处理用于编辑界面的弹框选择和字典选择
     * @param tablePO
     */
    private void processFkDict(TablePO tablePO) {
        List<TcgColumnPageBO> queryDicts = new ArrayList<TcgColumnPageBO>();
        Map<String,TcgColumnPageBO> dictMap = new HashMap<String,TcgColumnPageBO>();

        Map<String,List<TcgColumnPageBO>> fkMap = new HashMap<String,List<TcgColumnPageBO>>();
        Map<String,TcgTableConfigBO> fkTableMap = new HashMap<String,TcgTableConfigBO>();
        for(TcgColumnPageBO page : tablePO.getColumnPages()){
            if(  EnumPageElement.openwin.getVal().equals(page.getElement())){
                String key = null;
                if(page.getExColumn() != null) {
                    key = page.getExColumn().getOriginalColumn().getFkTableConfig().getFullResourceFile();
                    fkTableMap.put(key , page.getExColumn().getOriginalColumn().getFkTableConfig());
                }else if(page.getColumnConfig() != null && StringUtils.isNotEmpty(page.getColumnConfig().getGroupCode())) {
                    TcgColumnConfigBO originalColumn = getOriginalColumnByGroup(page.getColumnConfig().getGroupCode(), tablePO.getColumns());
                    if(originalColumn == null){
                        throw new BizException("配置错误， 相同组的列没有是外键的");
                    }
                    key = originalColumn.getFkTableConfig().getFullResourceFile();
                    page.getColumnConfig().setOriginalColumn(originalColumn);
                    fkTableMap.put(key , originalColumn.getFkTableConfig());
                }else {
                    continue;
                }
                List<TcgColumnPageBO> list = fkMap.get(key);
                if(list == null){
                    list = new ArrayList<TcgColumnPageBO>();
                    fkMap.put(key,list);
                }
                list.add(page);
            }else  if(
                        EnumPageElement.select.getVal().equals(page.getElement()) ||
                        EnumPageElement.checkbox.getVal().equals(page.getElement()) ||
                        EnumPageElement.radio.getVal().equals(page.getElement())

                    ){
                queryDicts.add(page);

                String key = null;

                if(page.getExColumn()!=null){
                    key = page.getExColumn().getDictType();
                }else {
                        key = page.getColumnConfig().getDictType();
                }
                dictMap.put(key,page);
            }
        }



        tablePO.setDicts(queryDicts);
        tablePO.setFks(fkMap);
        tablePO.setDictSet(dictMap);
        tablePO.setFkTables(new ArrayList<TcgTableConfigBO>(fkTableMap.values()));
    }




    /**
     * 处理扩展列信息
     * @param tableConfig
     * @param exColumns
     * @param tcgColumnConfigBOs
     */
    private void processExColumn(TcgTableConfigBO tableConfig, List<TcgExColumnBO> exColumns,
                                 List<TcgColumnConfigBO> tcgColumnConfigBOs , Map<String , TcgExColumnBO> exColumnMap) {
        for(TcgExColumnBO exColumn : exColumns){
            exColumn.setTableBO(tableConfig);
            exColumn.setFkJavaName(StringFormatKit.toCamelCase(exColumn.getFkColumnName()));
            if(StringUtils.isNotEmpty(exColumn.getOriginalColumnId() )){
                for(TcgColumnConfigBO columnBO : tcgColumnConfigBOs){
                    if(columnBO.getId().equals(exColumn.getOriginalColumnId())){
                        exColumn.setOriginalColumn(columnBO);
                        if(columnBO.getExCloumns() == null){
                            columnBO.setExCloumns(new ArrayList<TcgExColumnBO>());
                        }
                        columnBO.getExCloumns().add(exColumn);
                    }
                }
            }
            exColumnMap.put(exColumn.getId() , exColumn );
        }
    }



    private Map<String,TcgColumnPageBO> processColumnPageBOMap(List<TcgColumnPageBO> columnPages) {
        Map<String,TcgColumnPageBO> map = new HashMap<String,TcgColumnPageBO>();
        for(TcgColumnPageBO columnPage : columnPages){
            String key = columnPage.getId();
            map.put(key , columnPage) ;
        }
        return map;
    }

    private Map<String,List<TcgExColumnBO>>[] processExColumnMap(List<TcgExColumnBO> exColumns) {
        Map<String,List<TcgExColumnBO>> map = new HashMap<String,List<TcgExColumnBO>>();
        Map<String,List<TcgExColumnBO>> fkmap = new HashMap<String,List<TcgExColumnBO>>();
        Map<String,List<TcgExColumnBO>> dickmap = new HashMap<String,List<TcgExColumnBO>>();

        for(TcgExColumnBO exColumn : exColumns){
            String key = exColumn.getOriginalColumnId();
            if(key == null || key.isEmpty()){
                continue;
            }


            List<TcgExColumnBO> list = map.get(key);
            if(list == null){
                list = new ArrayList<TcgExColumnBO>();
                map.put(key , list);
                if(EnumYesNo.YES.getCode().equals( exColumn.getOriginalColumnFk())){
                    fkmap.put(key , list);
                }else {
                    dickmap.put(key , list);
                }
            }
            list.add(exColumn);
        }
        return new Map[]{map , fkmap , dickmap};
    }

    /**
     * 处理列数据
     * @param tableConfig
     * @param tcgColumnConfigBOs
     * @param tableConfigMap
     */
    private void processColumnConfig(TcgTableConfigBO tableConfig,
                                     List<TcgColumnConfigBO> tcgColumnConfigBOs,
                                     Map<String, TcgTableConfigBO> tableConfigMap ,
                                     Map<String , TcgColumnConfigBO> columnMap,
                                     Map<String , TcgColumnConfigBO> allColumnMap ) {

        List fkTables = new ArrayList<TcgTableConfigBO>();
        List<TcgColumnConfigBO> fkColumns = new ArrayList<TcgColumnConfigBO>();
        Set<TcgTableConfigBO> fkTableSet = new HashSet<TcgTableConfigBO>();

        Class parentClass = null;
        try {
            if(StringUtils.isNotEmpty(tableConfig.getParentClass())) {
                parentClass = Class.forName(tableConfig.getParentClass());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if(tcgColumnConfigBOs != null && !tcgColumnConfigBOs.isEmpty()){

            Set<String> dictTypeSet = new HashSet<String>();

            Set<String> parentFieldNames = CgBeanUtil.getAllClassFieldName((parentClass == null ? BaseBusinessExEntity.class : parentClass));

            String businessName = tableConfig.getBusinessName();
            String businessKey = tableConfig.getBusinessKey();

            for(TcgColumnConfigBO columnConfigBO : tcgColumnConfigBOs){

                columnConfigBO.setTableBO(tableConfig);

                if(businessName != null && businessName.trim().toLowerCase().equals(columnConfigBO.getColumnName().trim().toLowerCase()) ){
                    columnConfigBO.setTableBusinessName(EnumYesNo.YES.getCode());
                }
                if(businessKey != null && businessKey.toLowerCase().indexOf(columnConfigBO.getColumnName().toLowerCase()) != -1){
                    columnConfigBO.setTableBusinessKey(EnumYesNo.YES.getCode());
                }

                if(columnConfigBO.getColumnName().equalsIgnoreCase("tenant_id")){
                    tableConfig.setHaveTenant(true);
                }

                if(columnConfigBO.getColumnName().equalsIgnoreCase("organ_id")){
                    tableConfig.setHaveOrgan(true);
                }

                //替换掉空格 , Tab 键
                if(StringUtils.isNotEmpty(columnConfigBO.getDictType())){
                    columnConfigBO.setDictType(columnConfigBO.getDictType().trim().replaceAll("\t",""));
                }
                if(StringUtils.isNotEmpty(columnConfigBO.getFkSchema())){
                    columnConfigBO.setFkSchema(columnConfigBO.getFkSchema().trim().replaceAll("\t",""));
                }
                if(StringUtils.isNotEmpty(columnConfigBO.getFkName())){
                    columnConfigBO.setFkName(columnConfigBO.getFkName().trim().replaceAll("\t",""));
                }


                if(EnumYesNo.YES.getCode().equals(columnConfigBO.getColumnIsfk())) {
                    columnConfigBO.setFkColumnName("id");
                    columnConfigBO.setFkJavaFullClass("id");
                    columnConfigBO.setFkJavaFullClass(String.class.getName());
                    columnConfigBO.setFkJavaSimpleClass(String.class.getSimpleName());
                    TcgTableConfigBO fkTableConfig = tableConfigMap.get(columnConfigBO.getFkSchema() + "." + columnConfigBO.getFkName());
                    if (fkTableConfig == null) {
                        throw new BizException("列的外键Schema ， 外键表名 设置错误 : " +
                                tableConfig.getTableName() + "    " + columnConfigBO.getColumnName());
                    }
                    columnConfigBO.setFkTableConfig(fkTableConfig);
                    fkTables.add(fkTableConfig);
                    fkColumns.add(columnConfigBO);
                    fkTableSet.add(fkTableConfig);
                }else if(EnumYesNo.YES.getCode().equals(columnConfigBO.getColumnIsdict())) {
                    dictTypeSet.add(columnConfigBO.getDictType());
                }



                if(parentFieldNames.contains(columnConfigBO.getJavaName())){
                    columnConfigBO.setInParentClass(true);
                }else if("id".equals(columnConfigBO.getJavaName())){
                    columnConfigBO.setInParentClass(true);
                }else {
                    columnConfigBO.setInParentClass(false);
                }



                //处理文件
                if(TableLogic.isFiles(columnConfigBO)){
                    columnConfigBO.setFileType(EnumPageElement.multifile.getValue());
                    processTableFile(tableConfig , columnConfigBO);
                }else if(TableLogic.isFile(columnConfigBO)){
                    columnConfigBO.setFileType(EnumPageElement.singlefile.getValue());
                    processTableFile(tableConfig , columnConfigBO);
                }else if(TableLogic.isImages(columnConfigBO)){
                    columnConfigBO.setFileType(EnumPageElement.multiimage.getValue());
                    processTableFile(tableConfig , columnConfigBO);
                }else if(TableLogic.isImage(columnConfigBO)){
                    columnConfigBO.setFileType(EnumPageElement.singleimage.getValue());
                    processTableFile(tableConfig , columnConfigBO);
                }




                String setMethodName = "";
                String getMethodName = "";
                if("boolean".equals(columnConfigBO.getJavaFullClass())){

                    if(columnConfigBO.getJavaName().length() >4){
                        String first2 = columnConfigBO.getJavaName().substring(0,2);
                        String first4 = columnConfigBO.getJavaName().substring(0,4);
                        char c3 = columnConfigBO.getJavaName().charAt(2);
                        char c5 = columnConfigBO.getJavaName().charAt(4);
                        if("is".equals(first2) && c3 >= 'A' && c3 <= 'Z'){
                            setMethodName = "set"+ columnConfigBO.getJavaName().substring(2);
                            getMethodName = columnConfigBO.getJavaName();
                        }else if("have".equals(first4) && c5 >= 'A' && c5 <= 'Z'){
                            setMethodName = "set"+ columnConfigBO.getJavaName().substring(4);
                            getMethodName = columnConfigBO.getJavaName();
                        }else {
                            setMethodName = "set"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                            getMethodName = "is"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                        }
                    }if(columnConfigBO.getJavaName().length() >2){
                        String first2 = columnConfigBO.getJavaName().substring(0,2);
                        char c3 = columnConfigBO.getJavaName().charAt(2);
                        if("is".equals(first2) && c3 >= 'A' && c3 <= 'Z'){
                            setMethodName = "set"+ columnConfigBO.getJavaName().substring(2);
                            getMethodName = columnConfigBO.getJavaName();
                        }else {
                            setMethodName = "set"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                            getMethodName = "is"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                        }
                    }else {
                        setMethodName = "set"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                        getMethodName = "get"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                    }
                }else if("java.lang.Boolean".equals(columnConfigBO.getJavaFullClass())){

                    if(columnConfigBO.getJavaName().length() >4){
                        String first2 = columnConfigBO.getJavaName().substring(0,2);
                        String first4 = columnConfigBO.getJavaName().substring(0,4);
                        char c3 = columnConfigBO.getJavaName().charAt(2);
                        char c5 = columnConfigBO.getJavaName().charAt(4);
                        if("is".equals(first2) && c3 >= 'A' && c3 <= 'Z'){
                            setMethodName = "set"+ columnConfigBO.getJavaName().substring(2);
                            getMethodName = "get"+ columnConfigBO.getJavaName().substring(2);
                        }else if("have".equals(first4) && c3 >= 'A' && c3 <= 'Z'){
                            setMethodName = "set"+ columnConfigBO.getJavaName().substring(4);
                            getMethodName = "get"+ columnConfigBO.getJavaName().substring(4);
                        }else {
                            setMethodName = "set"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                            getMethodName = "get"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                        }
                    }else if(columnConfigBO.getJavaName().length() >2){
                        String first2 = columnConfigBO.getJavaName().substring(0,2);
                        char c3 = columnConfigBO.getJavaName().charAt(2);
                        if("is".equals(first2) && c3 >= 'A' && c3 <= 'Z'){
                            setMethodName = "set"+ columnConfigBO.getJavaName().substring(2);
                            getMethodName = "get"+ columnConfigBO.getJavaName().substring(2);
                        }else {
                            setMethodName = "set"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                            getMethodName = "get"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                        }
                    }else {
                        setMethodName = "set"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                        getMethodName = "get"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                    }

                }else {
                    setMethodName = "set"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                    getMethodName = "get"+ StringUtil.firstUpperCase(columnConfigBO.getJavaName());
                }

                columnConfigBO.setSetMethodName(setMethodName);
                columnConfigBO.setGetMethodName(getMethodName);

                columnMap.put(columnConfigBO.getId() , columnConfigBO);
                columnMap.put(columnConfigBO.getColumnName() , columnConfigBO);

                String tableColumnKey = tableConfig.getSchemaName().trim().toLowerCase() + tableConfig.getTableName().trim().toLowerCase() + columnConfigBO.getColumnName().trim().toLowerCase();
                allColumnMap.put(tableColumnKey , columnConfigBO);
            }

            if(!dictTypeSet.isEmpty()){
                List<String> dictTypes = new ArrayList<String>();
                for(String dictType : dictTypeSet){
                    dictTypes.add(dictType);
                }
                tableConfig.setDictTypes(dictTypes);
            }
        }

        tableConfig.setFkTables(fkTables);
        tableConfig.setFkColumns(fkColumns);
        tableConfig.setFkTableSet(fkTableSet);


    }

    /**
     * 处理文件类型的列
     * @param tableConfig
     * @param columnConfigBO
     */
    private void processTableFile(TcgTableConfigBO tableConfig, TcgColumnConfigBO columnConfigBO){
        if(tableConfig.getFileColumns() == null){
            tableConfig.setFileColumns(new ArrayList<TcgColumnConfigBO>());
        }
        tableConfig.getFileColumns().add(columnConfigBO);
    }

    /**
     * 处理视图中 的列
     * @param tableConfig
     * @param columns
     * @param mainTableColumns
     */
    private void processColumnConfig(TcgTableConfigBO tableConfig, List<TcgColumnConfigBO> columns, List<TcgColumnConfigBO> mainTableColumns) {
        Set<String> mainTableCoumnSet = new HashSet<String>();
        for(TcgColumnConfigBO mainTableColumn : mainTableColumns){
            mainTableCoumnSet.add(mainTableColumn.getJavaName());
        }

        for(TcgColumnConfigBO column : columns){
            if(mainTableCoumnSet.contains(column.getJavaName())){
                column.setInParentClass(true);
            }
        }
    }


    /**
     * 处理列的界面
     * @param columnMap
     * @param exColumnMap
     * @param columnPages
     */
    private void processColumnPage(Map<String , TcgColumnConfigBO> columnMap,  Map<String ,TcgExColumnBO> exColumnMap,
                                   List<TcgColumnPageBO> columnPages,Map<String ,TcgColumnPageBO> columnPageMap) {

        for(TcgColumnPageBO columnPage : columnPages){


            TcgColumnConfigBO column = columnMap.get(columnPage.getId());
            if(column != null){
                columnPage.setColumnConfig(column);
                try {
                    column.setJavaClass(Class.forName(column.getJavaFullClass()));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                columnPage.setNumber(column.isNumber());
                columnPage.setDate(column.isDate());
            }

            if(columnPage.getColumnConfig() == null){
                TcgExColumnBO exColumn = exColumnMap.get(columnPage.getId());
                if(exColumn != null){
                    columnPage.setExColumn(exColumn);
                    try {
                        exColumn.setJavaClass(Class.forName(exColumn.getJavaFullClass()));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    columnPage.setNumber(exColumn.isNumber());
                    columnPage.setDate(exColumn.isDate());
                }
            }

            if(columnPage.getColumnConfig() == null && columnPage.getExColumn() == null){
                throw new BizException("列的界面设置错误 ： "+ columnPage.getColumnComment());
            }

            columnPageMap.put(columnPage.getId() , columnPage);



            if(columnPage.getDefaultType() == null || columnPage.getDefaultType().trim().isEmpty()){
                columnPage.setDefaultType(null);
                columnPage.setDefaultValue(null);
            }

        }

    }




    private void processTableBusiness(TcgTableConfigBO tableConfig,Map<String , TcgColumnConfigBO> columnMap) {

        if(StringUtils.isNotEmpty(tableConfig.getBusinessName())){
            tableConfig.setBusinessNameGetMethods(new ArrayList<String>());
            String[] bns = tableConfig.getBusinessName().trim().split(",");
            for(String bn : bns){
                if(StringUtils.isEmpty(bn)){
                    continue;
                }
                String bnName = bn.trim().toLowerCase();

                if(StringUtils.isEmpty(bnName)){
                    continue;
                }
                TcgColumnConfigBO columnConfigBO = columnMap.get(bnName);
                if(columnConfigBO != null){
                    tableConfig.getBusinessNameGetMethods().add(columnConfigBO.getGetMethodName());
                }else {
                    String getMethodName = "get"+StringUtil.firstUpperCase(StringFormatKit.toCamelCase(bnName));
                    tableConfig.getBusinessNameGetMethods().add(getMethodName);
                }
            }
        }

        if(StringUtils.isNotEmpty(tableConfig.getBusinessKey())){
            tableConfig.setBusinessKeyGetMethods(new ArrayList<String>());
            String[] bns = tableConfig.getBusinessKey().trim().split(",");
            for(String bn : bns){
                if(StringUtils.isEmpty(bn)){
                    continue;
                }
                String bnName = bn.trim().toLowerCase();

                if(StringUtils.isEmpty(bnName)){
                    continue;
                }
                TcgColumnConfigBO columnConfigBO = columnMap.get(bnName);
                if(columnConfigBO != null){
                    tableConfig.getBusinessKeyGetMethods().add(columnConfigBO.getGetMethodName());
                }else {
                    String getMethodName = StringUtil.firstUpperCase(StringFormatKit.toCamelCase(bnName));
                    tableConfig.getBusinessKeyGetMethods().add(getMethodName);
                }
            }
        }

    }

    /**
     * 处理表的资源和包名
     * @param projectBO
     * @param moduleConfigMap
     * @param tableConfig
     */
    private void processTableResource(TcgProjectBO projectBO, Map<String, TcgModuleConfigBO> moduleConfigMap, TcgTableConfigBO tableConfig) {
        String fullResourceName = "";
        String fullPackageName = "";

        if(EnumYesNo.YES.getCode().equals(projectBO.getPackageIncludeModule())) {
            if (StringUtils.isNotEmpty(tableConfig.getModuleId())) {
                if (moduleConfigMap.containsKey(tableConfig.getModuleId())) {
                    fullResourceName = moduleConfigMap.get(tableConfig.getModuleId()).getModuleFullResource();
                    //只取最上层模块的资源
                    if(fullResourceName != null && fullResourceName.substring(2).indexOf("/")>0     ){
                        fullResourceName = fullResourceName.substring(0, fullResourceName.substring(2).indexOf("/")+2) ;
                    }
                    fullPackageName = fullResourceName.replaceAll("/", ".");

                }
            }
        }

        String tableSourceName = (tableConfig.getResourceName().startsWith("/")? "" : "/") + tableConfig.getResourceName();
        fullResourceName = fullResourceName +  tableSourceName;
        tableConfig.setFullResourceName(fullResourceName);

        String fullResource = fullResourceName.replaceAll("/", ".");
        if(fullResource.startsWith(".")){
            fullResource = fullResource.substring(1);
        }
        tableConfig.setFullResource(fullResource);

        String fullUpperResourceName = fullResourceName;
        fullUpperResourceName = fullUpperResourceName.replaceAll("/", "_");
        fullUpperResourceName = StringFormatKit.toCamelCase(fullUpperResourceName);
        fullUpperResourceName = StringUtil.firstUpperCase(fullUpperResourceName);
        tableConfig.setFullUpperResourceName(fullUpperResourceName);


        String fullResourceFile = fullResourceName;
        fullResourceFile = fullResourceFile.replaceAll("/", "");
        tableConfig.setFullResourceFile(fullResourceFile);



        String basePackageName = projectBO.getProjectPackage();
        if("zzframe".equals(tableConfig.getSchemaName())){
            basePackageName = "com.zz.bms";
        }


        if(StringUtils.isNotEmpty(fullPackageName)) {
            fullPackageName =  basePackageName + (fullPackageName.startsWith(".") ? "" : ".") + fullPackageName;
        }else {
            fullPackageName = basePackageName;
        }
        tableConfig.setFullPackageName(fullPackageName);
        tableConfig.setFullBoClassName(fullPackageName+".bo."+tableConfig.getJavaName()+"BO");
    }

    /**
     * 处理表对应实体类的 imports 和 基类
     * @param tableConfig
     * @param tcgColumnConfigBOs
     */
    private void processTableImprotAndParent(TcgTableConfigBO tableConfig, List<TcgColumnConfigBO> tcgColumnConfigBOs) {
        Set<String> javaNames = new HashSet<String>();
        Set<String> imports = new HashSet<String>();
        for (TcgColumnConfigBO tcgColumnConfigBO : tcgColumnConfigBOs){
            String fullJavaClass = tcgColumnConfigBO.getJavaFullClass();
            if( fullJavaClass != null && !fullJavaClass.isEmpty() && fullJavaClass.split("\\.").length >0 ){
                imports.add(fullJavaClass);
            }
            javaNames.add(tcgColumnConfigBO.getJavaName());
        }

        if(contains(javaNames , CgBeanUtil.getClassFieldName(BaseBusinessExEntity.class) )){
            tableConfig.setParentClass( BaseBusinessExEntity.class.getName() );
            tableConfig.setHaveVersion(true);
        }else if(contains(javaNames , CgBeanUtil.getClassFieldName(BaseBusinessSimpleExEntity.class) )){
            tableConfig.setParentClass( BaseBusinessSimpleExEntity.class.getName() );
            tableConfig.setHaveVersion(true);
        }else if(contains(javaNames , CgBeanUtil.getClassFieldName(BaseBusinessEntity.class) )){
            tableConfig.setParentClass( BaseBusinessEntity.class.getName() );
            tableConfig.setHaveVersion(true);
        }else if(contains(javaNames , CgBeanUtil.getClassFieldName(BaseBusinessSimpleEntity.class) )){
            tableConfig.setParentClass( BaseBusinessEntity.class.getName() );
            tableConfig.setHaveVersion(true);
        }else {
            tableConfig.setParentClass( BaseEntity.class.getName() );
            tableConfig.setHaveVersion(false);
        }
        tableConfig.setImportClasss(new ArrayList<String>(imports));
    }




    /**
     * 是否包含
     * @param all
     * @param child
     * @return
     */
    private boolean contains(Set<String> all , Set<String> child){
        return all.containsAll(child);
    }

    /**
     * 获取模板组定义的操作信息
     * @param templetGroupId
     * @return
     */
    private Map<String , TcgTempletGroupOperationBO> getOperations(String templetGroupId) {
        Map<String , TcgTempletGroupOperationBO> operationBOMap = new HashMap<String , TcgTempletGroupOperationBO>();
        List<TcgTempletGroupOperationBO> operationBOs = null;
        TcgTempletGroupOperationQuery operationQuery = new TcgTempletGroupOperationQueryImpl();
        operationQuery.groupId(templetGroupId);
        operationBOs = tcgTempletGroupOperationService.list(operationQuery.buildWrapper());


        if(operationBOs  != null && !operationBOs.isEmpty()){
            for(TcgTempletGroupOperationBO operationBO : operationBOs){
                operationBOMap.put(operationBO.getOperationId() , operationBO);
            }
        }

        if(operationBOMap.isEmpty()) {
            TcgOperationQuery tcgOperationQuery = new TcgOperationQueryImpl();
            List<TcgOperationBO> ops = tcgOperationService.list(tcgOperationQuery.buildWrapper());
            if (ops != null && !ops.isEmpty()) {
                int index = 0;
                for (TcgOperationBO op : ops) {
                    TcgTempletGroupOperationBO tgo = operationBOMap.get(op.getId());
                    if (tgo == null) {
                        tgo = new TcgTempletGroupOperationBO();
                        tgo.setOperationBO(op);
                        tgo.setOperationName(op.getOperationName());
                        tgo.setOperationResource(op.getOperationResource());
                        tgo.setOperationId(op.getId());
                        tgo.setPosition((String) EnumButtonPosition.top.getVal());
                        tgo.setSort(++index);
                        operationBOMap.put(op.getId(), tgo);
                    }
                }
            }
        }



        return operationBOMap;
    }


    /**
     * 获取相同组的 列信息
     * @param groupCode
     * @param allColumns
     * @return
     */
    private TcgColumnConfigBO getOriginalColumnByGroup(String groupCode , List<TcgColumnConfigBO> allColumns){
        List<TcgColumnConfigBO> columns = new ArrayList<TcgColumnConfigBO>();
        for(TcgColumnConfigBO column : allColumns){
            if(groupCode.equals(column.getGroupCode())){
                columns.add(column);
            }
        }
        if(columns.isEmpty()){
            return null;
        }
        if(!columns.isEmpty()) {
            columns.sort(new Comparator<TcgColumnConfigBO>() {
                @Override
                public int compare(TcgColumnConfigBO o1, TcgColumnConfigBO o2) {
                    return o1.getColumnSort().compareTo(o2.getColumnSort());
                }
            });
        }
        for(TcgColumnConfigBO column : columns){
            if(EnumYesNo.YES.getCode().equals(column.getColumnIsfk())){
                return column;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        String sss = "111       ";
        System.out.println(sss.length());
        System.out.println(sss.trim().length());

    }


}
