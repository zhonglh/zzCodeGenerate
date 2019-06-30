package com.zz.bsmcc.base.domain;



import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.db.entity.BaseBusinessEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessSimpleExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
* 模板实体类
*
* @author Administrator
* @date 2018-8-5 9:44:37
*/
public class TcgTempletEntity extends BaseBusinessEntity<String> implements java.io.Serializable{

    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





    //@EntityAttrAnnotation(attrName="模板组",sort=1  , attrLength=32    )
    private String groupId;





    //@EntityAttrAnnotation(attrName="生成文件外部文件夹",sort=2  , attrLength=200    )
    private String fileOutDir;





    //@EntityAttrAnnotation(attrName="生成文件内部文件夹",sort=3  , attrLength=200    )
    private String fileInnerDir;





    //@EntityAttrAnnotation(attrName="生成文件的文件类型",sort=4  , attrLength=10    )
        //如 jsp , js ,vue ,java等
    private String fileType;





    //@EntityAttrAnnotation(attrName="生成文件的后缀",sort=5  , attrLength=10    )
        //如 jsp , js ,vue ,java等
    private String fileSuffix;





    //@EntityAttrAnnotation(attrName="模板标题",sort=6  , attrLength=50    )
    private String templetTitle;





    //@EntityAttrAnnotation(attrName="是否UI",sort=7  , attrLength=1    )
    private String isUi;


    private String isMenuSql;

    private String isRbacSql;

    private String isDictSql;




    //是否只对关联表 有效
    private String effectiveReal;


    //是否只对树状 有效
    private String effectiveTree ;

    //是否只对单表有效 , 界面只有一个表的信息
    private String effectiveSingle ;


    //是否只对视图有效
    private String effectiveView;




    //文件名是否要包含对象名
    private String haveObjectName;


    //@EntityAttrAnnotation(attrName="模板内容",sort=8  , attrLength=5000    )
    private String templetContent;




    /**
    * 模板组
    * @return the groupId
    */
    public String getGroupId() {
    return groupId;
    }

    /**
    * 模板组
    */
    public void setGroupId(String groupId) {
    this.groupId = groupId;
    }
    /**
    * 生成文件外部文件夹
    * @return the fileOutDir
    */
    public String getFileOutDir() {
    return fileOutDir;
    }

    /**
    * 生成文件外部文件夹
    */
    public void setFileOutDir(String fileOutDir) {
    this.fileOutDir = fileOutDir;
    }
    /**
    * 生成文件内部文件夹
    * @return the fileInnerDir
    */
    public String getFileInnerDir() {
    return fileInnerDir;
    }

    /**
    * 生成文件内部文件夹
    */
    public void setFileInnerDir(String fileInnerDir) {
    this.fileInnerDir = fileInnerDir;
    }
    /**
    * 生成文件的文件类型
    * @return the fileType
    */
    public String getFileType() {
    return fileType;
    }

    /**
    * 生成文件的文件类型
    */
    public void setFileType(String fileType) {
    this.fileType = fileType;
    }
    /**
    * 生成文件的后缀
    * @return the fileSuffix
    */
    public String getFileSuffix() {
    return fileSuffix;
    }

    /**
    * 生成文件的后缀
    */
    public void setFileSuffix(String fileSuffix) {
    this.fileSuffix = fileSuffix;
    }
    /**
    * 模板标题
    * @return the templetTitle
    */
    public String getTempletTitle() {
    return templetTitle;
    }

    /**
    * 模板标题
    */
    public void setTempletTitle(String templetTitle) {
    this.templetTitle = templetTitle;
    }
    /**
    * 是否UI
    * @return the isUi
    */
    public String getIsUi() {
    return isUi;
    }

    /**
    * 是否UI
    */
    public void setIsUi(String isUi) {
    this.isUi = isUi;
    }
    /**
    * 模板内容
    * @return the templetContent
    */
    public String getTempletContent() {
    return templetContent;
    }

    /**
    * 模板内容
    */
    public void setTempletContent(String templetContent) {
    this.templetContent = templetContent;
    }

    public String getIsMenuSql() {
        return isMenuSql;
    }

    public void setIsMenuSql(String isMenuSql) {
        this.isMenuSql = isMenuSql;
    }

    public String getIsRbacSql() {
        return isRbacSql;
    }

    public void setIsRbacSql(String isRbacSql) {
        this.isRbacSql = isRbacSql;
    }

    public String getHaveObjectName() {
        return haveObjectName;
    }

    public void setHaveObjectName(String haveObjectName) {
        this.haveObjectName = haveObjectName;
    }


    public String getEffectiveReal() {
        return effectiveReal;
    }

    public void setEffectiveReal(String effectiveReal) {
        this.effectiveReal = effectiveReal;
    }

    public String getEffectiveTree() {
        return effectiveTree;
    }

    public void setEffectiveTree(String effectiveTree) {
        this.effectiveTree = effectiveTree;
    }

    public String getEffectiveSingle() {
        return effectiveSingle;
    }

    public void setEffectiveSingle(String effectiveSingle) {
        this.effectiveSingle = effectiveSingle;
    }

    public String getEffectiveView() {
        return effectiveView;
    }

    public void setEffectiveView(String effectiveView) {
        this.effectiveView = effectiveView;
    }

    public String getIsDictSql() {
        return isDictSql;
    }

    public void setIsDictSql(String isDictSql) {
        this.isDictSql = isDictSql;
    }
}