package com.zz.bsmcc.auto;


import com.zz.bms.util.configs.AppConfig;
import com.zz.bms.util.configs.BusinessConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrator
 */
@Component
public class ProjectConfig {

    static{
        BusinessConfig.USE_TENANT = false;
        BusinessConfig.USE_ORGAN = false;

        AppConfig.USE_SASS = false;
        AppConfig.DEBUG_MODE = true;
    }

}
