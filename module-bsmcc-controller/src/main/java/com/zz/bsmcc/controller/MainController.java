package com.zz.bsmcc.controller;

import com.zz.bms.controller.base.controller.BaseBussinessController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/main")
public class MainController extends BaseBussinessController {



    @RequestMapping(value = "home")
    public String login(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        /*
        TsUser user = ResourceUtil.getSessionUser();
        if (user != null) {
            request.setAttribute("user", user);
            return "main/hplus_main";
        } else {
            return "login/login";
        }
        */
        return "main/hplus_main";

    }

}
