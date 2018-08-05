package com.zz.bsmcc.base.service.impl;

import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.EntityUtil;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.core.exceptions.DbException;
import com.zz.bms.core.exceptions.InternalException;
import com.zz.bms.util.base.java.IdUtils;
import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.dao.*;
import com.zz.bsmcc.base.logic.TableLogic;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.*;
import com.zz.bsmcc.base.query.impl.*;
import com.zz.bsmcc.base.service.TableBusinessService;
import com.zz.bsmcc.base.service.TcgColumnEventService;
import com.zz.bsmcc.base.service.TcgTableConfigService;
import com.zz.bsmcc.core.Applications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service
@Transactional(rollbackFor=RuntimeException.class)
public class TableBusinessServiceImpl implements TableBusinessService {

    @Autowired
    private TcgTableConfigDAO tcgTableConfigDAO;
    @Autowired
    private TcgColumnConfigDAO tcgColumnConfigDAO;
    @Autowired
    private TcgExColumnDAO tcgExColumnDAO;
    @Autowired
    private TcgColumnPageDAO tcgColumnPageDAO;
    @Autowired
    private TcgIndexConfigDAO tcgIndexConfigDAO;



    @Autowired
    private TcgColumnEventDAO tcgColumnEventDAO;
    @Autowired
    private TcgColumnValidateDAO tcgColumnValidateDAO;
    @Autowired
    private TcgColumnExDAO tcgColumnExDAO;
    @Autowired
    private TcgQueryConfigDAO tcgQueryConfigDAO;
    @Autowired
    private TcgTableOperationDAO tcgTableOperationDAO;
    @Autowired
    private TcgOperationDAO tcgOperationDAO;





    @Override
    public boolean deleteTable(String tableId) {
        Map<String ,Object> delPkMap = new HashMap<String,Object>();
        delPkMap.put("id" , tableId);
        tcgTableConfigDAO.deleteByMap(delPkMap);

        Map<String ,Object> delFkMap = new HashMap<String,Object>();
        delFkMap.put("table_id" , tableId);
        tcgColumnConfigDAO.deleteByMap(delFkMap);
        tcgExColumnDAO.deleteByMap(delFkMap);
        tcgColumnPageDAO.deleteByMap(delFkMap);
        tcgIndexConfigDAO.deleteByMap(delFkMap);

        tcgColumnEventDAO.deleteByMap(delFkMap);
        tcgColumnValidateDAO.deleteByMap(delFkMap);
        tcgColumnExDAO.deleteByMap(delFkMap);
        tcgQueryConfigDAO.deleteByMap(delFkMap);
        tcgTableOperationDAO.deleteByMap(delFkMap);

        return true;
    }

    @Override
    public boolean insertTable(List<TablePO> tablePOList) {
        for(TablePO tablePO : tablePOList){
            tcgTableConfigDAO.insert(tablePO.getTableBO());
            for(TcgColumnConfigBO columnConfigBO : tablePO.getColumns()) {
                tcgColumnConfigDAO.insert(columnConfigBO);
            }
            for(TcgExColumnBO exColumnBO : tablePO.getExColumns()) {
                tcgExColumnDAO.insert(exColumnBO);
            }
            for(TcgColumnPageBO columnPageBO : tablePO.getColumnPages()) {
                tcgColumnPageDAO.insert(columnPageBO);
            }
            for(TcgIndexConfigBO indexConfigBO : tablePO.getIndexs()) {
                tcgIndexConfigDAO.insert(indexConfigBO);
            }

            insertDefaultOperation(tablePO);


        }
        return true;
    }

    private void insertDefaultOperation(TablePO tablePO) {
        //增加  默认的操作
        TcgOperationQuery tcgOperationQuery = new TcgOperationQueryImpl();
        tcgOperationQuery.isDefault(EnumYesNo.YES.getCode());
        List<TcgOperationBO> operations =  tcgOperationDAO.selectList(tcgOperationQuery.buildWrapper());
        if(operations != null && !operations.isEmpty()){
            ILoginUserEntity session = Applications.getLoginUserEntity();
            for(TcgOperationBO operation : operations){
                TcgTableOperationBO to = new TcgTableOperationBO();
                to.setId(IdUtils.getId());
                to.setOperationId(operation.getId());
                to.setTableId(tablePO.getTableBO().getId());
                EntityUtil.autoSetEntity(to , session);
                tcgTableOperationDAO.insert(to);
            }
        }
    }


    @Override
    public boolean updateTable(TablePO tablePO) {
        Integer result = tcgTableConfigDAO.updateById(tablePO.getTableBO());
        if(result != 1){
            throw DbException.DB_UPDATE_RESULT_0;
        }


        //处理操作配置信息
        this.updateOperation(tablePO);

        //处理查询条件配置信息
        this.updateQuery(tablePO);

        //处理列校验配置信息
        this.updateValidate(tablePO);

        //处理列事件配置信息
        this.updateEvent(tablePO);

        //处理列界面配置信息
        this.updatePage(tablePO);

        //处理列配置信息
        this.updateColumns(tablePO);

        //处理扩展列配置信息
        this.updateExColumn(tablePO);


        return true;
    }


    /**
     * 处理操作配置信息
     * 更新或者插入， 删除页面上没有传过来的信息
     * @param tablePO
     */
    private void updateOperation(TablePO tablePO) {
        TcgTableOperationQuery query = new TcgTableOperationQueryImpl();
        query.tableId(tablePO.getTableBO().getId());
        tcgTableOperationDAO.delete(query.buildWrapper());

        if(tablePO.getTableOperations() != null && !tablePO.getTableOperations().isEmpty()){
            for(TcgTableOperationBO operation : tablePO.getTableOperations()) {
                tcgTableOperationDAO.insert(operation);
            }
        }
    }


    /**
     * 处理条件配置信息
     * 更新或者插入， 删除页面上没有传过来的信息
     * @param tablePO
     */
    private void updateQuery(TablePO tablePO) {
        List<String> ids = new ArrayList<String>();
        if(tablePO.getQueryConfigs() != null && !tablePO.getQueryConfigs().isEmpty()) {
            for (TcgQueryConfigBO item : tablePO.getQueryConfigs()) {
                if(item == null || (StringUtils.isEmpty(item.getQueryRelation()) && StringUtils.isEmpty(item.getQueryTitle()) && StringUtils.isEmpty(item.getQueryPlaceholder()))  ){
                    continue;
                }
                if(StringUtils.isEmpty(item.getId())){
                    item.setId(IdUtils.getId());
                    tcgQueryConfigDAO.insert(item);
                }else {
                    tcgQueryConfigDAO.updateById(item);
                }
                ids.add(item.getId());
            }
        }
        TcgQueryConfigQuery query = new TcgQueryConfigQueryImpl();
        query.tableId(tablePO.getTableBO().getId());
        if(!ids.isEmpty()) {
            for(String id : ids) {
                query.idNotIn(id);
            }
        }
        tcgQueryConfigDAO.delete(query.buildWrapper());
    }



    /**
     * 处理事件配置信息
     * 更新或者插入， 删除页面上没有传过来的信息
     * @param tablePO
     */
    private void updateEvent(TablePO tablePO) {
        List<String> ids = new ArrayList<String>();
        if(tablePO.getColumnEvents() != null && !tablePO.getColumnEvents().isEmpty()) {
            for (TcgColumnEventBO item : tablePO.getColumnEvents()) {
                if(item == null || StringUtils.isEmpty(item.getEventName())){
                    continue;
                }
                if(StringUtils.isEmpty(item.getId())){
                    item.setId(IdUtils.getId());
                    tcgColumnEventDAO.insert(item);
                }else {
                    tcgColumnEventDAO.updateById(item);
                }
                ids.add(item.getId());
            }
        }
        TcgColumnEventQuery query = new TcgColumnEventQueryImpl();
        query.tableId(tablePO.getTableBO().getId());
        if(!ids.isEmpty()) {
            for(String id : ids) {
                query.idNotIn(id);
            }
        }
        tcgColumnEventDAO.delete(query.buildWrapper());
    }


    /**
     * 处理校验配置信息
     * 更新或者插入， 删除页面上没有传过来的信息
     * @param tablePO
     */
    private void updateValidate(TablePO tablePO) {
        List<String> ids = new ArrayList<String>();
        if(tablePO.getColumnValidates() != null && !tablePO.getColumnValidates().isEmpty()) {
            for (TcgColumnValidateBO item : tablePO.getColumnValidates()) {
                if(item == null || StringUtils.isEmpty(item.getRex())){
                    continue;
                }
                if(StringUtils.isEmpty(item.getId())){
                    item.setId(IdUtils.getId());
                    tcgColumnValidateDAO.insert(item);
                }else {
                    tcgColumnValidateDAO.updateById(item);
                }
                ids.add(item.getId());
            }
        }
        TcgColumnValidateQuery query = new TcgColumnValidateQueryImpl();
        query.tableId(tablePO.getTableBO().getId());
        if(!ids.isEmpty()) {
            for(String id : ids) {
                query.idNotIn(id);
            }
        }
        tcgColumnValidateDAO.delete(query.buildWrapper());
    }



    /**
     * 处理界面配置信息
     * 更新或者插入， 删除页面上没有传过来的信息
     * @param tablePO
     */
    private void updatePage(TablePO tablePO) {
        if(tablePO.getColumnPages() != null && !tablePO.getColumnPages().isEmpty()) {
            for (TcgColumnPageBO item : tablePO.getColumnPages()) {
                tcgColumnPageDAO.updateById(item);
            }
        }
    }


    /**
     * 处理列配置信息
     * 更新或者插入， 删除页面上没有传过来的信息
     * @param tablePO
     */
    private void updateColumns(TablePO tablePO) {
        if(tablePO.getColumns() != null && !tablePO.getColumns().isEmpty()) {
            for (TcgColumnConfigBO item : tablePO.getColumns()){
                String[] clzs = item.getJavaFullClass().split("\\.");
                item.setJavaSimpleClass(clzs[clzs.length-1]);
                tcgColumnConfigDAO.updateById(item);
            }
        }
    }



    /**
     * 处理扩展列配置信息
     * 更新或者插入， 删除页面上没有传过来的信息
     * @param tablePO
     */
    private void updateExColumn(TablePO tablePO) {
        List<String> ids = new ArrayList<String>();
        if(tablePO.getExColumns() != null && !tablePO.getExColumns().isEmpty()) {
            ILoginUserEntity session = Applications.getLoginUserEntity();

            for (TcgExColumnBO item : tablePO.getExColumns()) {
                if(item == null || StringUtils.isEmpty(item.getJavaFullClass())){
                    continue;
                }
                String[] clzs = item.getJavaFullClass().split("\\.");
                item.setJavaSimpleClass(clzs[clzs.length-1]);
                if(StringUtils.isEmpty(item.getId())){
                    item.setId(IdUtils.getId());
                    tcgExColumnDAO.insert(item);
                    //增加columnPage 信息
                    TcgColumnPageBO pageBO = new TcgColumnPageBO();
                    TableLogic.initColumnPage(pageBO , item , session );
                    tcgColumnPageDAO.insert(pageBO);

                }else {
                    tcgExColumnDAO.updateById(item);
                }
                ids.add(item.getId());
            }
        }
        TcgExColumnQuery query = new TcgExColumnQueryImpl();
        query.tableId(tablePO.getTableBO().getId());
        if(!ids.isEmpty()) {
            for(String id : ids) {
                query.idNotIn(id);
            }
        }
        tcgExColumnDAO.delete(query.buildWrapper());


        List<TcgColumnConfigBO> columns = tablePO.getColumns();
        for(TcgColumnConfigBO column : columns) {
            ids.add(column.getId());
        }

        //删除 columnPage
        TcgColumnPageQuery pageQuery = new TcgColumnPageQueryImpl();
        pageQuery.tableId(tablePO.getTableBO().getId());
        if(!ids.isEmpty()) {
            for(String id : ids) {
                pageQuery.idNotIn(id);
            }
        }
        tcgColumnPageDAO.delete(pageQuery.buildWrapper());

        //删除columnEvent
        TcgColumnEventQuery eventQuery = new TcgColumnEventQueryImpl();
        eventQuery.tableId(tablePO.getTableBO().getId());
        if(!ids.isEmpty()) {
            for(String id : ids) {
                eventQuery.columnIdNotIn(id);
            }
        }
        tcgColumnEventDAO.delete(eventQuery.buildWrapper());

        //删除 columnValidate
        TcgColumnValidateQuery validateQuery = new TcgColumnValidateQueryImpl();
        validateQuery.tableId(tablePO.getTableBO().getId());
        if(!ids.isEmpty()) {
            for(String id : ids) {
                validateQuery.columnIdNotIn(id);
            }
        }
        tcgColumnValidateDAO.delete(validateQuery.buildWrapper());


        //删除 queryConfig
        TcgQueryConfigQuery queryConfigQuery = new TcgQueryConfigQueryImpl();
        queryConfigQuery.tableId(tablePO.getTableBO().getId());
        if(!ids.isEmpty()) {
            for(String id : ids) {
                queryConfigQuery.columnIdNotIn(id);
            }
        }
        tcgQueryConfigDAO.delete(queryConfigQuery.buildWrapper());


    }


}
