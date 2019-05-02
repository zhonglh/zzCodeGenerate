package com.zz.bsmcc.controller;

import com.zz.bms.controller.base.controller.BaseCURDController;
import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.db.mybatis.query.Query;
import com.zz.bms.core.ui.Pages;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public abstract class ZzccBaseController<M extends BaseEntity<PK>, PK extends Serializable, Q extends Query> extends BaseCURDController<M,M, PK, Q,Q> {

    @Override
    public void checkInsertInfo(BaseEntity entity){

    }


    @Override
    public void checkEntityLegality(BaseEntity entity , boolean checkRequired , boolean checkLength , boolean checkRule){

    }

    @Override
    public void processPages(Pages page, HttpServletRequest request) {
        page.setPageSize(Integer.parseInt(request.getParameter("limit")));
        page.setPageNum((Integer.parseInt(request.getParameter("offset"))/page.getPageSize())+1);
    }



    @Override
    public void assertHasCreatePermission() {
    }

    @Override
    public void assertHasUpdatePermission() {
    }

    @Override
    public void assertHasDeletePermission() {
    }

    @Override
    public void assertHasViewPermission() {
    }

    @Override
    public void assertHasImportPermission() {
    }

    @Override
    public void assertHasExportPermission() {
    }

    @Override
    public void assertHasEditPermission() {
    }

    @Override
    public void assertHasPermission(String permission) {
    }

    @Override
    public void assertHasPermission(String permission, String errorCode) {
    }



}


