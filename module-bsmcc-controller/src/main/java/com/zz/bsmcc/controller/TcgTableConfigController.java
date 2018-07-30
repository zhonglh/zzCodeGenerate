package com.zz.bsmcc.controller;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.core.exceptions.DbException;
import com.zz.bms.core.ui.Pages;
import com.zz.bms.core.ui.easyui.EasyUiDataGrid;
import com.zz.bms.core.vo.AjaxJson;
import com.zz.bms.shiro.utils.ShiroUtils;


import com.zz.bsmcc.base.bo.TcgDbConfigBO;
import com.zz.bsmcc.base.bo.TcgProjectBO;
import com.zz.bsmcc.base.bo.TcgTableConfigBO;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.TcgDbConfigQuery;
import com.zz.bsmcc.base.query.TcgProjectQuery;
import com.zz.bsmcc.base.query.impl.TcgDbConfigQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgProjectQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTableConfigQueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import com.zz.bsmcc.base.service.TableBusinessService;
import com.zz.bsmcc.base.service.TcgDbConfigService;
import com.zz.bsmcc.base.service.TcgProjectService;
import com.zz.bsmcc.business.TableBusiness;
import com.zz.bsmcc.core.util.table.engine.ReadDbFactory;
import com.zz.bsmcc.core.util.table.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 表设置 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:20
 */
@RequestMapping("/table/config")
@Controller
public class TcgTableConfigController extends ZzccBaseController<TcgTableConfigBO, String , TcgTableConfigQueryWebImpl> {


	@Autowired
	private TcgDbConfigService tcgDbConfigService;

    @Autowired
    private TcgProjectService tcgProjectService;

    @Autowired
    private TableBusiness tableBusiness;

    @Autowired
    private TableBusinessService tableBusinessService;


    /**
     * 根据数据库设置 返回该库 所有的表和视图
     * @param tcgTableConfigBO
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/tableListByDbConfig/{dbId}" , method = RequestMethod.GET)
    @ResponseBody
    public Object tableListByDbConfig(@PathVariable("dbId") String dbId, TcgTableConfigBO tcgTableConfigBO , Model model , TcgTableConfigQueryWebImpl query ,HttpServletRequest request, HttpServletResponse response) {


        tcgTableConfigBO.setDbId(dbId);
        if(StringUtils.isEmpty(tcgTableConfigBO.getDbId())){
            return null;
        }

        TcgDbConfigBO dbConfigBO = tcgDbConfigService.selectById(tcgTableConfigBO.getDbId());

        try {
            List<Table> tables = ReadDbFactory.buildReadDbProcess(dbConfigBO.getDbType()).readAllTable(
                    new DbConfig(dbConfigBO.getDbType() , dbConfigBO.getDbUrl() , dbConfigBO.getDbUsername() , dbConfigBO.getDbPassword())
            );
            return new EasyUiDataGrid(tables.size(), tables);
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }

        return null;



    }

    @Override
	protected String getAddPageName() {
		return "addForm";
	}


    @Override
    @RequestMapping( value = "/create",  method = {RequestMethod.POST} )
    @ResponseBody
    public Object create(TcgTableConfigBO m, ModelMap model, HttpServletRequest request , HttpServletResponse response) {
        this.permissionList.assertHasCreatePermission();

        ILoginUserEntity<String> sessionUserVO = this.getSessionUser();
        boolean success = false;

        String[] tablesn = request.getParameterValues("ids");


        TcgDbConfigBO dbConfigBO = tcgDbConfigService.selectById(m.getDbId());

        List<TablePO> tablePOs = new ArrayList<TablePO>();

        for(String sns : tablesn) {
            TcgTableConfigBO tcgTableConfigBO = new TcgTableConfigBO();
            BeanUtils.copyProperties(m , tcgTableConfigBO);
            String[] sn = sns.split(":");
            tcgTableConfigBO.setSchemaName(sn[0]);
            tcgTableConfigBO.setTableName(sn[1]);
            if (StringUtils.isEmpty(m.getDbId()) || StringUtils.isEmpty(m.getTableName()) || StringUtils.isEmpty(m.getProjectId())) {
                continue;
            }
            if (this.isExist(tcgTableConfigBO)) {
                continue;
            }
            TablePO tablePO = tableBusiness.tableBusiness( dbConfigBO,  tcgTableConfigBO, sessionUserVO);
            tablePOs.add(tablePO);
        }

        try {
            success = tableBusinessService.insertTable(tablePOs);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw DbException.DB_INSERT_RESULT_0;
        }

        if (!success) {
            throw DbException.DB_INSERT_RESULT_0;
        } else {
            return AjaxJson.successAjax;
        }

    }




	/**
	 * 增加界面一些定制的操作
	 * 如有， 需要重载
	 * @param model
	 */
	@Override
	protected void customInfoByCreateForm(TcgTableConfigBO tcgTableConfigBO, ModelMap model) {

		TcgDbConfigQuery dbConfigQuery = new TcgDbConfigQueryImpl();
        List<TcgDbConfigBO> dbConfigs =tcgDbConfigService.selectList(dbConfigQuery.buildWrapper());
		model.put("dbConfigs" , dbConfigs);

		if(!dbConfigs.isEmpty()){
            model.put("dbId" , dbConfigs.get(0).getId());
        }

        TcgProjectQuery projectQuery = new TcgProjectQueryImpl();

        List<TcgProjectBO> projects = tcgProjectService.selectList(projectQuery.buildWrapper());
        model.put("projects" , projects);

	}

	@Override
	protected boolean isExist(TcgTableConfigBO tcgTableConfigBO) {

        TcgTableConfigBO tmp = new TcgTableConfigBO();
        tmp.setId(tcgTableConfigBO.getId());
        tmp.setProjectId(tcgTableConfigBO.getProjectId());
        tmp.setDbId(tcgTableConfigBO.getDbId());
        tmp.setTableName(tcgTableConfigBO.getTableName());

        TcgTableConfigBO result =  this.baseService.selectCheck(tmp);
        if(result != null && result.getId() != null){
            return true;
        }else {
            return false;
        }

	}



}
