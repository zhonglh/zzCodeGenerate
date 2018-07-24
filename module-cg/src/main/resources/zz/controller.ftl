package ${table.basePackage}.restful;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zz.bms.controller.base.controller.DefaultController;
import com.zz.bms.core.enums.EnumYesNo;
import com.zz.bms.shiro.utils.ShiroUtils;



import com.zz.bsmcc.base.bo.${table.shortTableName?cap_first}BO;
import com.zz.bsmcc.base.query.impl.${table.shortTableName?cap_first}QueryWebImpl;

import com.zz.bms.util.base.java.IdUtils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ${table.tableComments} 控制层
 *
 * @author ${table.author}
 * @date ${.now}
 */
@RequestMapping("/sys/user")
@Controller
public class ${table.shortTableName?cap_first}Controller extends DefaultController<${table.shortTableName?cap_first}BO, String , ${table.shortTableName?cap_first}QueryWebImpl> {




	@Override
	protected boolean isExist(${table.shortTableName?cap_first}BO ${table.shortTableName?uncap_first}BO) {
		return false;
	}



}
