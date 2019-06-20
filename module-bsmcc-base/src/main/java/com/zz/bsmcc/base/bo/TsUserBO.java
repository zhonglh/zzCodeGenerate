package com.zz.bsmcc.base.bo;

import com.zz.bms.core.db.entity.ILoginUserEntity;
import com.zz.bms.enums.EnumYesNo;
import com.zz.bms.util.configs.annotaions.EntityAnnotation;
import com.zz.bsmcc.base.domain.TsUserEntity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;



/**
* 用户 BO , 扩展 用户Entity对象
* @author Administrator
*/
@EntityAnnotation(value="用户" , resource = "")
@TableName(value="ts_user" , resultMap = "TsUserResultMap")
public class TsUserBO extends TsUserEntity implements ILoginUserEntity<String> ,Serializable {

    @Override
    public String getDepName() {
        return null;
    }

    @Override
    public String getOrganName() {
        return null;
    }

    @Override
    public String getUserStatus() {
        return super.getStatus();
    }

    @Override
    public boolean isSystemUser() {
        return super.getSystemAdmin().equals(EnumYesNo.YES.getCode());
    }

    @Override
    public String getLeadName() {
        return null;
    }

    @Override
    public String getAvatarImage() {
        return null;
    }

    @Override
    public Integer getPageLimit() {
        return 50;
    }


    @Override
    public String getTenantName() {
        return null;
    }
}
