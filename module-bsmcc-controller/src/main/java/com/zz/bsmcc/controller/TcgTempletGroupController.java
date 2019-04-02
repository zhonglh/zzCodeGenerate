package com.zz.bsmcc.controller;

import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.vo.AjaxJson;
import com.zz.bsmcc.base.bo.TcgOperationBO;
import com.zz.bsmcc.base.bo.TcgTempletGroupBO;
import com.zz.bsmcc.base.bo.TcgTempletGroupOperationBO;
import com.zz.bsmcc.base.po.TablePO;
import com.zz.bsmcc.base.query.TcgOperationQuery;
import com.zz.bsmcc.base.query.TcgTempletGroupOperationQuery;
import com.zz.bsmcc.base.query.impl.TcgOperationQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletGroupOperationQueryImpl;
import com.zz.bsmcc.base.query.impl.TcgTempletGroupQueryWebImpl;
import com.zz.bsmcc.base.service.TcgOperationService;
import com.zz.bsmcc.base.service.TcgTempletGroupOperationService;
import com.zz.bsmcc.core.enums.EnumButtonPosition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板组 控制层
 *
 * @author Administrator
 * @date 2018-7-24 15:13:21
 */
@RequestMapping("/templet/group")
@Controller
public class TcgTempletGroupController extends ZzccBaseController<TcgTempletGroupBO, String , TcgTempletGroupQueryWebImpl> {


	@Autowired
	private TcgTempletGroupOperationService tcgTempletGroupOperationService;


	@Autowired
	private TcgOperationService tcgOperationService;


	@RequestMapping(
			value = {"/{id}/operationsEdit"},
			method = {RequestMethod.GET}
	)
	public String operationsEdit(@PathVariable String id, ModelMap model, HttpServletRequest request, HttpServletResponse response) {


		this.permissionList.assertHasPermission("operationsEdit");


		List<TcgTempletGroupOperationBO> list = null;

		TcgTempletGroupOperationQuery query = new TcgTempletGroupOperationQueryImpl();
		query.groupId(id);
		List<TcgTempletGroupOperationBO> operationBOs = tcgTempletGroupOperationService.list(query.buildWrapper());
		Map<String,TcgTempletGroupOperationBO> operationMap  = new HashMap<String,TcgTempletGroupOperationBO>();

		if(operationBOs != null && !operationBOs.isEmpty() ){
			for(TcgTempletGroupOperationBO operationBO : operationBOs){
				operationMap.put(operationBO.getOperationId() , operationBO);
			}
		}


		TcgOperationQuery operationQuery = new TcgOperationQueryImpl();
		List<TcgOperationBO> opBOs = tcgOperationService.list(operationQuery.buildWrapper());

		if(operationBOs != null && operationBOs.size() == opBOs.size()){
			list = operationBOs;
		}else {
			list = new ArrayList<TcgTempletGroupOperationBO>();
			int index = 0;
			for (TcgOperationBO opBO : opBOs) {
				index ++;
				if(operationMap.containsKey(opBO.getId())){
					list.add(operationMap.get(opBO.getId()));
				}else {
					TcgTempletGroupOperationBO tgo = new TcgTempletGroupOperationBO();
					tgo.setOperationBO(opBO);
					tgo.setOperationName(opBO.getOperationName());
					tgo.setOperationResource(opBO.getOperationResource());
					tgo.setOperationId(opBO.getId());
					tgo.setPosition((String) EnumButtonPosition.top.getVal());
					tgo.setSort(index);
					list.add(tgo);
				}
			}
		}

		model.addAttribute("operations", list);



		return viewName("operationsEdit");

	}




	@RequestMapping(
			value = {"/{id}/operationsEdit"},
			method = {RequestMethod.POST}
	)
	@ResponseBody
	public Object operationsEdit(@PathVariable("id") String id, TablePO tablePO, ModelMap model, HttpServletRequest request, HttpServletResponse response) {


		this.permissionList.assertHasPermission("operationsEdit");
		ILoginUserEntity<String> sessionUserVO = this.getSessionUser();

		List<TcgTempletGroupOperationBO> operations = tablePO.getTempletGroupOperations();
		if(operations != null && !operations.isEmpty()){
			for(TcgTempletGroupOperationBO operation : operations){
				operation.setGroupId(id);
				if(StringUtils.isEmpty(operation.getId())){
					this.setInsertInfo(operation, sessionUserVO);
					tcgTempletGroupOperationService.save(operation);
				}else {
					this.setUpdateInfo(operation, sessionUserVO);
					tcgTempletGroupOperationService.updateById(operation);
				}
			}
		}

		return AjaxJson.successAjax;
	}









}
