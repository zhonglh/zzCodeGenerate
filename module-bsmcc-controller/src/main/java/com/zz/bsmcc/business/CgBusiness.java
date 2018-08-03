package com.zz.bsmcc.business;


import com.zz.bms.core.db.entity.*;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bms.util.base.java.ReflectionSuper;
import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.query.TcgModuleConfigQuery;
import com.zz.bsmcc.base.query.TcgTableConfigQuery;
import com.zz.bsmcc.base.query.TcgTempletGroupOperationQuery;
import com.zz.bsmcc.base.query.impl.TcgModuleConfigQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTableConfigQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletGroupOperationQueryImpl;
import com.zz.bsmcc.base.service.*;
import com.zz.bsmcc.base.service.impl.TcgModuleConfigServiceImpl;
import io.swagger.models.auth.In;
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


    public void cgBusiness(TcgProjectBO projectBO, List<TcgTempletBO> templets ) {

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

            List<TcgColumnConfigBO> columns = tcgColumnConfigService.selectByMap(searchMap);
            if(columns != null && !columns.isEmpty()) {
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
            processTableImprotAndParent(tableConfig, columns);

            //处理表的资源和包名
            processTableResource(projectBO, moduleConfigMap, tableConfig);

            //处理列的信息
            processColumnConfig(tableConfig , columns , tableConfigMap);



            List<TcgExColumnBO> exColumns = tcgExColumnService.selectByMap(searchMap);
            if(exColumns != null && !exColumns.isEmpty()) {
                exColumns.sort(new Comparator<TcgExColumnBO>() {
                    @Override
                    public int compare(TcgExColumnBO o1, TcgExColumnBO o2) {
                        return o1.getColumnSort().compareTo(o2.getColumnSort());
                    }
                });
                //处理扩展列的信息
                processExColumn(tableConfig ,exColumns , columns);
            }

            List<TcgColumnPageBO> columnPages = tcgColumnPageService.selectByMap(searchMap);

            if(columnPages != null && !columnPages.isEmpty()) {
                //处理列界面设置信息
                processColumnPage(columns , exColumns , columnPages);

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



            //处理视图的主表
            if(!EnumYesNo.YES.getCode().equals(tableConfig.getIsTable())){
                TcgTableConfigBO mainTableConfig = tableConfigMap.get(tableConfig.getMainTableId());
                if(mainTableConfig == null){
                    throw new BizException("视图没有设置主要的表 : " + tableConfig.getTableComment());
                }
                tableConfig.setMainTableIdConfig(mainTableConfig);
            }
        }







    }


    /**
     * 处理扩展列信息
     * @param tableConfig
     * @param exColumns
     * @param tcgColumnConfigBOs
     */
    private void processExColumn(TcgTableConfigBO tableConfig, List<TcgExColumnBO> exColumns, List<TcgColumnConfigBO> tcgColumnConfigBOs) {
        for(TcgExColumnBO exColumn : exColumns){
            exColumn.setFkJavaName(StringFormatKit.toCamelCase(exColumn.getFkColumnName()));
        }
    }

    /**
     * 处理列数据
     * @param tableConfig
     * @param tcgColumnConfigBOs
     * @param tableConfigMap
     */
    private void processColumnConfig(TcgTableConfigBO tableConfig, List<TcgColumnConfigBO> tcgColumnConfigBOs, Map<String, TcgTableConfigBO> tableConfigMap) {

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
            }
        }

    }

    /**
     * 处理列的界面
     * @param columns
     * @param exColumns
     * @param columnPages
     */
    private void processColumnPage(List<TcgColumnConfigBO> columns, List<TcgExColumnBO> exColumns, List<TcgColumnPageBO> columnPages) {

        for(TcgColumnPageBO columnPage : columnPages){

            for(TcgColumnConfigBO column : columns){
                if(columnPage.getId().equals(column.getId())){
                    columnPage.setColumnConfig(column);
                    break;
                }
            }

            if(columnPage.getColumnConfig() == null){
                for(TcgExColumnBO exColumn : exColumns){
                    if(columnPage.getId().equals(exColumn.getId())){
                        columnPage.setExColumn(exColumn);
                        break;
                    }
                }
            }

            if(columnPage.getColumnConfig() == null && columnPage.getExColumn() == null){
                throw new BizException("列的界面设置错误 ： "+ columnPage.getColumnComment());
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
