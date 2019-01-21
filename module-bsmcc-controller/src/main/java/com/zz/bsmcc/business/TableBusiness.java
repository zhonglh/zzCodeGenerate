package com.zz.bsmcc.business;


import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.db.entity.EntityUtil;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.InternalException;
import com.zz.bms.util.base.data.StringFormatKit;
import com.zz.bms.util.base.data.StringUtil;
import com.zz.bms.util.base.java.IdUtils;
import com.zz.bms.util.base.java.ReflectionSuper;
import com.zz.bsmcc.base.bo.*;
import com.zz.bsmcc.base.dao.TcgJavaDatatypeRealDAO;
import com.zz.bsmcc.base.dao.TcgProjectDAO;
import com.zz.bsmcc.base.domain.TcgProjectEntity;
import com.zz.bsmcc.base.logic.TableLogic;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.TcgJavaDatatypeRealQuery;
import com.zz.bsmcc.base.query.impl.TcgJavaDatatypeRealQueryImpl;
import com.zz.bsmcc.core.TablesLocalThread;
import com.zz.bsmcc.core.enums.EnumDbColumnType;
import com.zz.bsmcc.core.enums.EnumJavaType;
import com.zz.bms.enums.EnumPageElement;
import com.zz.bsmcc.core.util.table.engine.ReadDbFactory;
import com.zz.bsmcc.core.util.table.engine.ReadDbProcess;
import com.zz.bsmcc.core.util.table.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;

/**
 * 表数据处理
 * @author Administrator
 */
@Component
public class TableBusiness {



    @Autowired
    private TcgProjectDAO tcgProjectDAO;

    @Autowired
    private TcgJavaDatatypeRealDAO tcgJavaDatatypeRealDAO;



    public TablePO tableBusiness(TcgDbConfigBO dbConfigBO, TcgTableConfigBO tableBO, ILoginUserEntity<String> sessionUserVO){


        TablePO tablePO = new TablePO();
        try {

            TcgProjectEntity project = tcgProjectDAO.selectById(tableBO.getProjectId());

            TcgJavaDatatypeRealQuery typeQuery = new TcgJavaDatatypeRealQueryImpl();
            List<TcgJavaDatatypeRealBO> types = tcgJavaDatatypeRealDAO.selectList(typeQuery.buildWrapper());
            Map<String,String> typeMap = new HashMap<String,String>();
            if(types != null && !types.isEmpty()){
                for(TcgJavaDatatypeRealBO type : types){
                    typeMap.put(type.getDataType() , type.getJavaType()) ;
                }
            }


            DbConfig dbConfig = new DbConfig(dbConfigBO.getDbType() , dbConfigBO.getDbUrl() , dbConfigBO.getDbUsername() , dbConfigBO.getDbPassword());

            ReadDbProcess readDbProcess = ReadDbFactory.buildReadDbProcess(dbConfigBO.getDbType());

            Table table = readDbProcess.readOneTable(dbConfig , tableBO.getSchemaName() , tableBO.getTableName());

            List<Column> columns = readDbProcess.readColumnsByTable(dbConfig, tableBO.getSchemaName() , tableBO.getTableName());



            List<Index> insexs = readDbProcess.readIndexsByTable( dbConfig, tableBO.getSchemaName() , tableBO.getTableName() );

            List<Constraint> constraints = readDbProcess.readConstraintsByTable( dbConfig, tableBO.getSchemaName(), tableBO.getTableName());

            //初始化表信息
            TableLogic.initTableConfig(tableBO, table , project , sessionUserVO);


            //初始化列信息
            List<TcgColumnConfigBO> columnBOs = new ArrayList<TcgColumnConfigBO>();
            int index = 0;
            for(Column column : columns){
                column.setDataType(column.getDataType().toUpperCase());
                TcgColumnConfigBO tcgColumnConfigBO = new TcgColumnConfigBO();
                TableLogic.initColumnConfig(tcgColumnConfigBO , tableBO, column ,typeMap , sessionUserVO);
                index ++ ;
                tcgColumnConfigBO.setColumnSort(index * 100);
                columnBOs.add(tcgColumnConfigBO);
            }

            //初始化列的扩展信息，  也就是BO里的属性
            List<TcgExColumnBO> exColumnBOs = new ArrayList<TcgExColumnBO>();
            if(EnumYesNo.YES.getCode().equals(project.getAutoExColumn())) {
                for (TcgColumnConfigBO columnBO : columnBOs) {
                    if (TableLogic.insideFieldNames.contains(columnBO.getJavaName()) || "id".equals(columnBO.getJavaName())) {
                        continue;
                    }
                    if (columnBO.getColumnIsdict().equals(EnumYesNo.YES.getCode())) {
                        //处理字典信息
                        TcgExColumnBO exColumnBO = new TcgExColumnBO();
                        TableLogic.initExColumn(exColumnBO, columnBO, sessionUserVO);
                        exColumnBO.setOriginalColumnDict(EnumYesNo.YES.getCode());
                        exColumnBOs.add(exColumnBO);
                    }
                    if (project.getPageUseView().equals(EnumYesNo.NO.getCode())
                            && EnumYesNo.YES.getCode().equals(tableBO.getIsTable())
                            && columnBO.getColumnIsfk().equals(EnumYesNo.YES.getCode())) {
                        //处理外键信息
                        TcgExColumnBO exColumnBO = new TcgExColumnBO();
                        TableLogic.initExColumn(exColumnBO, columnBO, sessionUserVO);
                        exColumnBO.setOriginalColumnFk(EnumYesNo.YES.getCode());
                        exColumnBOs.add(exColumnBO);
                    }
                }
            }

            //处理列的页面信息
            List<TcgColumnPageBO> columnPageBOs = new ArrayList<TcgColumnPageBO>();
            for(TcgColumnConfigBO columnBO : columnBOs){
                TcgColumnPageBO pageBO = new TcgColumnPageBO();
                TableLogic.initColumnPage(pageBO , columnBO , sessionUserVO );
                columnPageBOs.add(pageBO);
            }
            for(TcgExColumnBO exColumnBO : exColumnBOs){
                TcgColumnPageBO pageBO = new TcgColumnPageBO();
                TableLogic.initColumnPage(pageBO , exColumnBO , sessionUserVO );
                columnPageBOs.add(pageBO);
            }


            //初始化表的索引信息
            List<TcgIndexConfigBO> indexBOs = new ArrayList<TcgIndexConfigBO>();
            for(Index ci : insexs){
                TcgIndexConfigBO indexBO = new TcgIndexConfigBO();
                TableLogic.initIndexConfig(indexBO , tableBO, ci , sessionUserVO);
                indexBOs.add(indexBO);
            }

            //初始化表的约束信息
            for(Constraint constraint : constraints){
                TcgIndexConfigBO indexBO = new TcgIndexConfigBO();
                TableLogic.initIndexConfig(indexBO , tableBO, constraint , sessionUserVO);
                indexBOs.add(indexBO);
            }


            //处理视图
            if(EnumYesNo.NO.getCode().equals(tableBO.getIsTable())){
                //约定， 视图名称是以 ‘v' 开头 , 表是以 't' 开头
                String tableName = "t"+tableBO.getTableName().substring(1);
                List<Table> tables = TablesLocalThread.getTables();
                if(tables != null){
                    for(Table t : tables){
                        if(tableName.equals(t.getTableName())){
                            tableBO.setMainTableSchema(tableBO.getSchemaName());
                            tableBO.setMainTableName(tableName);
                            tableBO.setTableComment(t.getTableComment());
                            tableBO.setTableOtherComment(t.getTableOtherComment());
                            break;
                        }
                    }
                }

                if(StringUtils.isEmpty(tableBO.getMainTableName())){
                    tableBO.setIsBuildRbac(EnumYesNo.NO.getCode());
                    tableBO.setIsBuildUi(EnumYesNo.NO.getCode());
                    tableBO.setIsBuildMenu(EnumYesNo.NO.getCode());
                }
            }

            tablePO.setTableBO(tableBO);
            tablePO.setColumns(columnBOs);
            tablePO.setExColumns(exColumnBOs);
            tablePO.setColumnPages(columnPageBOs);
            tablePO.setIndexs(indexBOs);

            return tablePO;

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return null;

    }



}
