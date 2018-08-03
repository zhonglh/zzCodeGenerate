package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgOperationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 操作表 BO , 扩展 操作表Entity对象
* @author Administrator
*/
@EntityAnnotation(value="操作表" , resource = "")
@TableName(value="tcg_operation" , resultMap = "TcgOperationResultMap")
public class TcgOperationBO extends TcgOperationEntity implements Serializable {
    private boolean checked ;

    private String isDefaultName;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getIsDefaultName() {
        return isDefaultName;
    }

    public void setIsDefaultName(String isDefaultName) {
        this.isDefaultName = isDefaultName;
    }
}
