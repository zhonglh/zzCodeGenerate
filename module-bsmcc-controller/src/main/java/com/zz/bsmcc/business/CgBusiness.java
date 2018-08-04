package com.zz.bsmcc.business;


import com.zz.bms.core.db.entity.*;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bms.util.base.java.ReflectionSuper;
import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.*;
import com.zz.bsmcc.base.query.impl.TcgModuleConfigQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTableConfigQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletGroupOperationQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletQueryImpl;
import com.zz.bsmcc.base.service.*;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 代码生成处理
 * @author Administrator
 */
@Component
public class CgBusiness {


    @Autowired
    private TcgProjectService tcgProjectService ;
    @Autowired
    private TcgTempletService tcgTempletService ;
    @Autowired
    private TcgModuleConfigService tcgModuleConfigService ;
    @Autowired
    private TcgTempletGroupOperationService tcgTempletGroupOperationService ;
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
     * 生成代码
     * @param projectId
     * @param templetGroupId
     */
    public void cg(String projectId , String templetGroupId) {
        TcgProjectBO projectBO = tcgProjectService.selectById(projectId);
        TcgTempletQuery templetQuery = new TcgTempletQueryImpl();
        templetQuery.groupId(templetGroupId);
        List<TcgTempletBO> templets = tcgTempletService.selectList(templetQuery.buildWrapper());

        cg(projectBO , templets);

    }

    /**
     * 生成代码
     * @param projectBO
     * @param templets
     */
    public void cg(TcgProjectBO projectBO, List<TcgTempletBO> templets ) {

        Map<String , TcgTempletGroupOperationBO> operationBOMap = getOperations(templets.get(0).getGroupId());


        TcgModuleConfigQuery moduleConfigQuery = new TcgModuleConfigQueryImpl();
        moduleConfigQuery.projectId(projectBO.getId());
        Map<String,TcgModuleConfigBO> moduleConfigMap = new HashMap<String,TcgModuleConfigBO>();
        List<TcgModuleConfigBO> moduleConfigBOs = tcgModuleConfigService.selectList(moduleConfigQuery.buildWrapper());
        if(moduleConfigBOs != null && !moduleConfigBOs.isEmpty()){
            for(TcgModuleConfigBO moduleConfigBO : moduleConfigBOs){
                moduleConfigMap.put(moduleConfigBO.getId() , moduleConfigBO);
            }
        }


        Map<String,TcgTableConfigBO> tableConfigMap = new HashMap<String,TcgTableConfigBO>();
        TcgTableConfigQuery tableConfigQuery = new TcgTableConfigQueryImpl();
        tableConfigQuery.projectId(projectBO.getId());
        List<TcgTableConfigBO> tableConfigs = tcgTableConfigService.selectList(tableConfigQuery.buildWrapper());

        if(tableConfigs != null && !tableConfigs.isEmpty()){
            tableConfigs.sort(new Comparator<TcgTableConfigBO>(){
                @Override
                public int compare(TcgTableConfigBO o1, TcgTableConfigBO o2) {
                    return o1.getIsTable().compareTo(o2.getIsTable());
                }
            });
        }else {
            return ;
        }

        for(TcgTableConfigBO tableConfig : tableConfigs){
            tableConfigMap.put(tableConfig.getSchemaName()+"."+tableConfig.getTableName(), tableConfig);
            tableConfigMap.put(tableConfig.getId(), tableConfig);
        }

        for(TcgTableConfigBO tableConfig : tableConfigs){
            Map<String,Object> searchMap = new HashMap<String,Object>();
            searchMap.put("table_id" , tableConfig.getId());


            //处理列的信息
            Map<String , TcgColumnConfigBO> columnMap = new HashMap<String , TcgColumnConfigBO>();
            List<TcgColumnConfigBO> columns = tcgColumnConfigService.selectByMap(searchMap);
            if(columns != null && !columns.isEmpty()) {
                processColumnConfig(tableConfig , columns , tableConfigMap , columnMap);
                columns.sort(new Comparator<TcgColumnConfigBO>(){
                    @Override
                    public int compare(TcgColumnConfigBO o1, TcgColumnConfigBO o2) {
                        return o1.getColumnSort().compareTo(o2.getColumnSort());
                    }
                });
            }else {
                throw new BizException(" 没有列的信息 :"+tableConfig.getTableComment());
            }


            //处理表对应实体类的 imports 和 基类
            processTableImprotAndParent(tableConfig, columns );

            //处理表的资源和包名
            processTableResource(projectBO, moduleConfigMap, tableConfig);


            //处理扩展列的信息
            Map<String , TcgExColumnBO> exColumnMap = new HashMap<String , TcgExColumnBO>();
            List<TcgExColumnBO> exColumns = tcgExColumnService.selectByMap(searchMap);
            if(exColumns != null && !exColumns.isEmpty()) {
                exColumns.sort(new Comparator<TcgExColumnBO>() {
                    @Override
                    public int compare(TcgExColumnBO o1, TcgExColumnBO o2) {
                        return o1.getColumnSort().compareTo(o2.getColumnSort());
                    }
                });
                //处理扩展列的信息
                processExColumn(tableConfig ,exColumns , columns , exColumnMap);
            }

            //处理列界面信息
            Map<String ,TcgColumnPageBO> columnPageMap = new HashMap<String ,TcgColumnPageBO>();
            List<TcgColumnPageBO> columnPages = tcgColumnPageService.selectByMap(searchMap);
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
            List<TcgColumnValidateBO> validates = tcgColumnValidateService.selectByMap(searchMap);
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
            List<TcgColumnEventBO> events = tcgColumnEventService.selectByMap(searchMap);
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
            List<TcgQueryConfigBO> queryConfigs = tcgQueryConfigService.selectByMap(searchMap);
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
            List<TcgIndexConfigBO> indexs = tcgIndexConfigService.selectByMap(searchMap);
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
            if(!EnumYesNo.YES.getCode().equals(tableConfig.getIsTable())){
                TcgTableConfigBO mainTableConfig = tableConfigMap.get(tableConfig.getMainTableId());
                if(mainTableConfig == null){
                    throw new BizException("视图没有设置主要的表 : " + tableConfig.getTableComment());
                }
                tableConfig.setMainTableIdConfig(mainTableConfig);
            }



            TablePO tablePO = new TablePO();
            tablePO.setTableBO(tableConfig);
            tablePO.setColumns(columns);
            tablePO.setExColumns(exColumns);
            tablePO.setColumnPages(columnPages);
            tablePO.setColumnValidates(validates);
            tablePO.setColumnEvents(events);
            tablePO.setQueryConfigs(queryConfigs);
            tablePO.setIndexs(indexs);

            List<TcgTempletGroupOperationBO> operations = new ArrayList<TcgTempletGroupOperationBO>(operationBOMap.values());
            tablePO.setTempletGroupOperations(operations);





            cgCode(tablePO);

        }




    }

    /**
     * 生成代码
     * @param tablePO
     */
    private void cgCode(TablePO tablePO) {
        //todo
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
            exColumn.setFkJavaName(StringFormatKit.toCamelCase(exColumn.getFkColumnName()));
            exColumnMap.put(exColumn.getId() , exColumn );
        }
    }

    /**
     * 处理列数据
     * @param tableConfig
     * @param tcgColumnConfigBOs
     * @param tableConfigMap
     */
    private void processColumnConfig(TcgTableConfigBO tableConfig, List<TcgColumnConfigBO> tcgColumnConfigBOs,
                                     Map<String, TcgTableConfigBO> tableConfigMap , Map<String , TcgColumnConfigBO> columnMap) {

        if(tcgColumnConfigBOs != null && !tcgColumnConfigBOs.isEmpty()){
            for(TcgColumnConfigBO columnConfigBO : tcgColumnConfigBOs){
                columnConfigBO.setFkColumnName("id");
                columnConfigBO.setFkJavaFullClass("id");
                columnConfigBO.setFkJavaFullClass(String.class.getName());
                columnConfigBO.setFkJavaSimpleClass(String.class.getSimpleName());
                TcgTableConfigBO fkTableConfig = tableConfigMap.get(columnConfigBO.getFkSchema()+"."+columnConfigBO.getFkName());
                if(fkTableConfig == null){
                    throw new BizException("列的外键Schema ， 外键表名 设置错误 : " +
                            tableConfig.getTableComment() + "    "+ columnConfigBO.getColumnComment());
                }
                columnConfigBO.setFkTableConfig(fkTableConfig);

                columnMap.put(columnConfigBO.getId() , columnConfigBO);
                columnMap.put(columnConfigBO.getColumnName() , columnConfigBO);
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
            }

            if(columnPage.getColumnConfig() == null){
                TcgExColumnBO exColumn = exColumnMap.get(columnPage.getId());
                if(exColumn != null){
                    columnPage.setExColumn(exColumn);
                }
            }

            if(columnPage.getColumnConfig() == null && columnPage.getExColumn() == null){
                throw new BizException("列的界面设置错误 ： "+ columnPage.getColumnComment());
            }

            columnPageMap.put(columnPage.getId() , columnPage);

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
        if(StringUtils.isNotEmpty(tableConfig.getModuleId())) {
            if (moduleConfigMap.containsKey(tableConfig.getModuleId())) {
                fullResourceName = moduleConfigMap.get(tableConfig.getModuleId()).getModuleFullResource();
                fullPackageName = fullResourceName.replaceAll("/" , ".");
            }
        }
        fullResourceName = fullResourceName + "/" + tableConfig.getResourceName();
        tableConfig.setFullResourceName(fullResourceName);

        fullPackageName = projectBO.getProjectPackage() + "." + fullPackageName;
        tableConfig.setFullPackageName(fullPackageName);
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

        if(contains(javaNames , getClassFieldName(BaseBusinessExEntity.class) )){
            tableConfig.setParentClass( BaseBusinessExEntity.class.getName() );
        }else if(contains(javaNames , getClassFieldName(BaseBusinessSimpleExEntity.class) )){
            tableConfig.setParentClass( BaseBusinessSimpleExEntity.class.getName() );
        }else if(contains(javaNames , getClassFieldName(BaseBusinessEntity.class) )){
            tableConfig.setParentClass( BaseBusinessEntity.class.getName() );
        }else if(contains(javaNames , getClassFieldName(BaseBusinessSimpleEntity.class) )){
            tableConfig.setParentClass( BaseBusinessEntity.class.getName() );
        }else {
            tableConfig.setParentClass( BaseEntity.class.getName() );
        }
        tableConfig.setImportClsss(new ArrayList<String>(imports));
    }

    /**
     * 获取类的字段名称
     * @param clz
     * @return
     */
    private Set<String> getClassFieldName(Class clz){
        if(!clz.isAssignableFrom(BaseEntity.class)){
            throw new InternalException("类型必须是 BaseEntity 的子类");
        }
        Set<String> nameSet = new HashSet<String>();
        Field[] fs = ReflectionSuper.getAllField( clz , BaseEntity.class);
        for(Field f : fs){
            nameSet.add(f.getName());
        }
        return nameSet;
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
        operationBOs = tcgTempletGroupOperationService.selectList(operationQuery.buildWrapper());
        if(operationBOs  != null && !operationBOs.isEmpty()){
            for(TcgTempletGroupOperationBO operationBO : operationBOs){
                operationBOMap.put(operationBO.getOperationId() , operationBO);
            }
        }
        return operationBOMap;
    }


}
