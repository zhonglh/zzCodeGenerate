package com.zz.bsmcc.base.bo;

import com.zz.bsmcc.base.domain.TcgExColumnEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zz.bms.annotaions.EntityAnnotation;

import java.io.Serializable;



/**
* 扩展列设置 BO , 扩展 扩展列设置Entity对象
* @author Administrator
*/
@EntityAnnotation(value="扩展列设置" , resource = "")
@TableName(value="tcg_ex_column" , resultMap = "TcgExColumnResultMap")
public class TcgExColumnBO extends TcgExColumnEntity implements Serializable {

    private String originalColumnFk;

    private String originalColumnDict;

    //@EntityAttrAnnotation(attrName="组编码",sort=11  , attrLength=50    )
    //一般相同的数据项用相同的组名 ， 比如在项目表中， 客户名称，客户编号， 客户电话 ，客户ID等
    private String groupCode;

    //@EntityAttrAnnotation(attrName="字典类型",sort=12  , attrLength=50    )
    private String dictType;


    private String originalColumnFkName ;

    private String originalColumnDictName;

    /**
     * 原始列是否外键
     * @return the originalColumnFk
     */
    public String getOriginalColumnFk() {
        return originalColumnFk;
    }

    /**
     * 原始列是否外键
     */
    public void setOriginalColumnFk(String originalColumnFk) {
        this.originalColumnFk = originalColumnFk;
    }
    /**
     * 原始列是否字典
     * @return the originalColumnDict
     */
    public String getOriginalColumnDict() {
        return originalColumnDict;
    }

    /**
     * 原始列是否字典
     */
    public void setOriginalColumnDict(String originalColumnDict) {
        this.originalColumnDict = originalColumnDict;
    }


    public String getOriginalColumnFkName() {
        return originalColumnFkName;
    }

    public void setOriginalColumnFkName(String originalColumnFkName) {
        this.originalColumnFkName = originalColumnFkName;
    }

    public String getOriginalColumnDictName() {
        return originalColumnDictName;
    }

    public void setOriginalColumnDictName(String originalColumnDictName) {
        this.originalColumnDictName = originalColumnDictName;
    }

    /**
     * 组编码
     * @return the groupCode
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * 组编码
     */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }
    /**
     * 字典类型
     * @return the dictType
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 字典类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
}
