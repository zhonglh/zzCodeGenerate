package com.zz.bsmcc.base.domain;



import com.zz.bms.util.configs.annotaions.EntityAnnotation;

import com.zz.bms.core.db.entity.BaseBusinessSimpleEntity;
import com.zz.bms.core.Constant;
import com.zz.bms.core.db.entity.BaseBusinessExEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
* 用户实体类
*
* @author Administrator
* @date 2018-7-29 1:16:16
*/
public class TsUserEntity extends BaseBusinessExEntity<String> implements java.io.Serializable{

    @TableField(exist=false)
    private static final long serialVersionUID = 1L;





        //@EntityAttrAnnotation(attrName="用户姓名",sort=1  , attrLength=50    )
        private String userName;





        //@EntityAttrAnnotation(attrName="登录名",sort=2  , attrLength=20    )
        private String loginName;





        //@EntityAttrAnnotation(attrName="登录密码",sort=3  , attrLength=128    )
        private String loginPassword;





        //@EntityAttrAnnotation(attrName="加密盐",sort=4  , attrLength=64    )
        private String salt;





        //@EntityAttrAnnotation(attrName="状态",sort=5  , attrLength=1    )
            //字典类型: user_status  
        private String status;





        //@EntityAttrAnnotation(attrName="上级领导ID",sort=6  , attrLength=32    )
        private String leadId;





        //@EntityAttrAnnotation(attrName="电话",sort=7  , attrLength=20    )
        private String phone;





        //@EntityAttrAnnotation(attrName="邮箱",sort=8  , attrLength=60    )
        private String email;





        //@EntityAttrAnnotation(attrName="头像",sort=9  , attrLength=220    )
        private String avatarUrl;





        //@EntityAttrAnnotation(attrName="微信ID",sort=10  , attrLength=64    )
        private String openId;





        //@EntityAttrAnnotation(attrName="微信唯一ID",sort=11  , attrLength=64    )
        private String unionId;





        //@EntityAttrAnnotation(attrName="系统管理人员",sort=12  , attrLength=1    )
        private String systemAdmin;





        //@EntityAttrAnnotation(attrName="部门ID",sort=13  , attrLength=32    )
        private String depId;





        //@EntityAttrAnnotation(attrName="机构ID",sort=14  , attrLength=32    )
        private String organId;





        //@EntityAttrAnnotation(attrName="备注",sort=15  , attrLength=500    )
        private String remark;











        /**
        * 用户姓名
        * @return the userName
        */
        public String getUserName() {
        return userName;
        }

        /**
        * 用户姓名
        */
        public void setUserName(String userName) {
        this.userName = userName;
        }
        /**
        * 登录名
        * @return the loginName
        */
        public String getLoginName() {
        return loginName;
        }

        /**
        * 登录名
        */
        public void setLoginName(String loginName) {
        this.loginName = loginName;
        }
        /**
        * 登录密码
        * @return the loginPassword
        */
        public String getLoginPassword() {
        return loginPassword;
        }

        /**
        * 登录密码
        */
        public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
        }
        /**
        * 加密盐
        * @return the salt
        */
        public String getSalt() {
        return salt;
        }

        /**
        * 加密盐
        */
        public void setSalt(String salt) {
        this.salt = salt;
        }
        /**
        * 状态
        * @return the status
        */
        public String getStatus() {
        return status;
        }

        /**
        * 状态
        */
        public void setStatus(String status) {
        this.status = status;
        }
        /**
        * 上级领导ID
        * @return the leadId
        */
        public String getLeadId() {
        return leadId;
        }

        /**
        * 上级领导ID
        */
        public void setLeadId(String leadId) {
        this.leadId = leadId;
        }
        /**
        * 电话
        * @return the phone
        */
        public String getPhone() {
        return phone;
        }

        /**
        * 电话
        */
        public void setPhone(String phone) {
        this.phone = phone;
        }
        /**
        * 邮箱
        * @return the email
        */
        public String getEmail() {
        return email;
        }

        /**
        * 邮箱
        */
        public void setEmail(String email) {
        this.email = email;
        }
        /**
        * 头像
        * @return the avatarUrl
        */
        public String getAvatarUrl() {
        return avatarUrl;
        }

        /**
        * 头像
        */
        public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        }
        /**
        * 微信ID
        * @return the openId
        */
        public String getOpenId() {
        return openId;
        }

        /**
        * 微信ID
        */
        public void setOpenId(String openId) {
        this.openId = openId;
        }
        /**
        * 微信唯一ID
        * @return the unionId
        */
        public String getUnionId() {
        return unionId;
        }

        /**
        * 微信唯一ID
        */
        public void setUnionId(String unionId) {
        this.unionId = unionId;
        }
        /**
        * 系统管理人员
        * @return the systemAdmin
        */
        public String getSystemAdmin() {
        return systemAdmin;
        }

        /**
        * 系统管理人员
        */
        public void setSystemAdmin(String systemAdmin) {
        this.systemAdmin = systemAdmin;
        }
        /**
        * 部门ID
        * @return the depId
        */
        public String getDepId() {
        return depId;
        }

        /**
        * 部门ID
        */
        public void setDepId(String depId) {
        this.depId = depId;
        }
        /**
        * 机构ID
        * @return the organId
        */
        public String getOrganId() {
        return organId;
        }

        /**
        * 机构ID
        */
        public void setOrganId(String organId) {
        this.organId = organId;
        }
        /**
        * 备注
        * @return the remark
        */
        public String getRemark() {
        return remark;
        }

        /**
        * 备注
        */
        public void setRemark(String remark) {
        this.remark = remark;
        }


}