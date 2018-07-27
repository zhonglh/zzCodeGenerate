package com.zz.bsmcc.base.dao;

import com.zz.bms.core.db.base.dao.BaseDAO;
import com.zz.bsmcc.base.bo.TsUserBO;
import org.springframework.stereotype.Repository;



/**
* 用户操作DAO
* @author Administrator
*/
@Repository("tsUserDAO4CG")
public interface TsUserDAO extends BaseDAO<TsUserBO , String> {

}
