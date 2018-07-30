package com.zz.bsmcc.base.service;


import com.zz.bsmcc.base.po.TablePO;

import java.util.List;

/**
 * 表格数据处理
 */
public interface TableBusinessService {

    public boolean insertTable(List<TablePO> tablePOList) ;

    public boolean updateTable(TablePO tablePO) ;

    public boolean deleteTable(String tableId) ;
}
