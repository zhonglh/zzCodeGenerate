package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bms.core.ui.Pages;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public abstract class ZzccBaseController<M extends BaseEntity<PK>, PK extends Serializable, Q extends Query> extends DefaultController<M, PK, Q> {



    @Override
    public void processPages(Pages page, HttpServletRequest request) {
        page.setPageSize(Integer.parseInt(request.getParameter("limit")));
        page.setPageNum((Integer.parseInt(request.getParameter("offset"))/page.getPageSize())+1);


    }


}


