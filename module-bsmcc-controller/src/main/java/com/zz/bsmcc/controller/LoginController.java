package com.zz.bsmcc.controller;

import com.zz.bms.controller.base.controller.BaseBussinessController;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.vo.AjaxJson;
import com.zz.bms.shiro.utils.ShiroUtils;
import com.zz.bsmcc.base.domain.TsUserEntity;
import com.zz.bsmcc.base.query.TsUserQuery;
import com.zz.bsmcc.base.query.impl.TsUserQueryImpl;
import com.zz.bsmcc.base.service.TsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseBussinessController {

    @Autowired
    private TsUserService tsUserService;


    /**
     * 检查用户名称
     *
     * @param user
     * @param req
     * @return
     */
    @RequestMapping(value = "/checkUser")
    @ResponseBody
    public Object checkUser(TsUserEntity user, HttpServletRequest req) {
        HttpSession session = req.getSession();
        AjaxJson j = new AjaxJson();
        String msg = "";
        try {
            TsUserQuery userQuery = new TsUserQueryImpl();
            userQuery.loginName(user.getLoginName());
            TsUserEntity dbUser = tsUserService.selectOne(userQuery.buildWrapper());
            boolean b = (dbUser != null);

            if(b) {

                if(!ShiroUtils.encodeSalt(user.getLoginPassword(), dbUser.getSalt()).equals(dbUser.getLoginPassword())){
                    b = false;
                    msg = "用户名密码错误";
                }
            }else {
                msg = "用户名密码错误";
            }

            j.setSuccess(b);
            j.setMsg(msg);

            if(b){
                req.getSession().setAttribute(Constant.SESSION_USER , dbUser);
            }

        } catch (Exception e) {
            j.setSuccess(false);
            j.setMsg("出现错误");
            e.printStackTrace();
        }
        return j;
    }

/*
    @RequestMapping(value = "toRegiste")
    public String toRegiste(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "login/registe";
    }*/


    /**
     * 注册用户
     *
     * @return
     */
    /*@RequestMapping(value = "registeUser")
    @ResponseBody
    public AjaxJson registeUser(TsUser user, HttpServletRequest req) {
        HttpSession session = req.getSession();
        AjaxJson j = new AjaxJson();
        try {
            TsUser user1 = new TsUser();
            user1.setUserName(user.getUserName());
            List<TsUser> list = systemService.getUser(user1);
            if (list != null && list.size() > 0) {
                j.setSuccess(false);
                j.setMsg("该用户名已经存在!");
            }

            user.setIp(IpUtil.getIpAddr(req));

            systemService.addUser(user);

        } catch (Exception e) {
            j.setSuccess(false);
            j.setMsg("出现错误");
        }
        return j;
    }*/


    //@RequestMapping(params = "toRegisteSuccess")
   /* public String toRegisteSuccess(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        return "login/registeSuccess";
    }*/


    @RequestMapping(value = "/login")
    public String login(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        ILoginUserEntity<String> sessionUserVO = getSessionUser(request);
        if (sessionUserVO != null) {
            return "redirect:/login/home" ;
        } else {
            return "login/login";
        }

    }


    @RequestMapping(value = "/home")
    public String home(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        ILoginUserEntity<String> sessionUserVO = getSessionUser(request);
        if (sessionUserVO != null) {
            request.setAttribute("user", sessionUserVO);
            return "main/hplus_main";
        }else {
            return "redirect:/login/login" ;
        }

    }

    /**
     * 退出系统
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.SESSION_USER);
        return "redirect:/login/login" ;
    }

}
