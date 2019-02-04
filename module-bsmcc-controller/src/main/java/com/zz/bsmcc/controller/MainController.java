package com.zz.bsmcc.controller;

import com.zz.bms.controller.base.controller.BaseBusinessController;
import com.zz.bms.core.db.entity.BaseEntity;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 */
@Controller
@RequestMapping("/main")
public class MainController extends BaseBusinessController {



    @RequestMapping(value = "home")
    public String login(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {

        return "main/hplus_main";

    }

}
