package com.zz.bsmcc.core;

import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.core.exceptions.BizException;
import com.zz.bms.core.exceptions.InternalException;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * App 信息
 * @author Administrator
 */
public class Applications {

    /**
     * 获取使用目录
     * @return
     */
    public static String getUsrDir(){
        String dir = System.getProperty("user.dir");
        if(dir == null){
            File d = new File("/");
            String path = d.getAbsolutePath();
            if(d.exists()){
                System.setProperty("user.dir" , path);
            }else {
                throw new InternalException("获取使用目录信息错误");
            }
            return path;
        }else {
            return dir;
        }
    }

    /**
     * 获取用户登录信息
     * @return
     */
    public static  ILoginUserEntity getLoginUserEntity() {
        ILoginUserEntity session = null;
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
            session = (ILoginUserEntity)request.getSession().getAttribute(Constant.SESSION_USER);
        }
        return session;
    }


}
