package com.zz.bsmcc.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.zz.bms.util.spring.SpringUtil;
import org.junit.Assert;
import org.junit.Test;

public class SpringConfigTest extends BaseTest {



    @Test
    public void testSpringStart() {
        DruidDataSource ds = (DruidDataSource) SpringUtil.getBean("dataSource");
        Assert.assertNotNull(ds);
    }


}
