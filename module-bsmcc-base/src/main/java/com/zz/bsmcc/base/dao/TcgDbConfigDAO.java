package com.zz.bsmcc.base.dao;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bsmcc.base.domain.TcgDbConfigEntity;
import org.springframework.stereotype.Repository;



/**
* 连接池设置操作DAO
* @author Administrator
*/
@Repository
public interface TcgDbConfigDAO extends BaseDAO<TcgDbConfigEntity , String> {

}
