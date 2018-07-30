package com.zz.bsmcc.base.service.impl;

import com.zz.bsmcc.base.bo.TcgColumnConfigBO;
import com.zz.bsmcc.base.bo.TcgColumnPageBO;
import com.zz.bsmcc.base.bo.TcgExColumnBO;
import com.zz.bsmcc.base.bo.TcgIndexConfigBO;
import com.zz.bsmcc.base.dao.*;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.service.TableBusinessService;
import com.zz.bsmcc.base.service.TcgColumnEventService;
import com.zz.bsmcc.base.service.TcgTableConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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
            for(TcgColumnPageBO columnPageBO : tablePO.getPageBOS()) {
                tcgColumnPageDAO.insert(columnPageBO);
            }
            for(TcgIndexConfigBO indexConfigBO : tablePO.getIndexBOs()) {
                tcgIndexConfigDAO.insert(indexConfigBO);
            }

        }
        return true;
    }

    @Override
    public boolean updateTable(TablePO tablePO) {
        return false;
    }

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
}
