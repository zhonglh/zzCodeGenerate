package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TsUserQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 用户 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-27 17:40:59
 */
public class TsUserQueryImpl<PK extends Serializable> extends TsUserAbstractQueryImpl<PK> implements TsUserQuery<PK>, Serializable  {







            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<String> userName_IN;
            private List<String> userName_NOTIN;













            private List<String> loginName_IN;
            private List<String> loginName_NOTIN;













            private List<String> loginPassword_IN;
            private List<String> loginPassword_NOTIN;













            private List<PK> salt_IN;
            private List<PK> salt_NOTIN;













            private List<String> status_IN;
            private List<String> status_NOTIN;














            private List<PK> leadId_IN;
            private List<PK> leadId_NOTIN;













            private List<String> phone_IN;
            private List<String> phone_NOTIN;













            private List<String> email_IN;
            private List<String> email_NOTIN;













            private List<String> avatarUrl_IN;
            private List<String> avatarUrl_NOTIN;













            private List<PK> openId_IN;
            private List<PK> openId_NOTIN;













            private List<PK> unionId_IN;
            private List<PK> unionId_NOTIN;













            private List<String> systemAdmin_IN;
            private List<String> systemAdmin_NOTIN;














            private List<PK> depId_IN;
            private List<PK> depId_NOTIN;













            private List<PK> organId_IN;
            private List<PK> organId_NOTIN;













            private List<String> remark_IN;
            private List<String> remark_NOTIN;













            private List<String> deleteFlag_IN;
            private List<String> deleteFlag_NOTIN;














            private List<PK> createUserId_IN;
            private List<PK> createUserId_NOTIN;













            private List<String> createUserName_IN;
            private List<String> createUserName_NOTIN;























            private List<PK> updateUserId_IN;
            private List<PK> updateUserId_NOTIN;













            private List<String> updateUserName_IN;
            private List<String> updateUserName_NOTIN;

































            private List<PK> tenantId_IN;
            private List<PK> tenantId_NOTIN;
























                @Override
                public TsUserQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TsUserQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TsUserQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TsUserQuery userName(String userName) {
                    if(!IdUtils.isEmpty(userName)){
                        this.userName = userName;
                    }
                    return this;
                }


                @Override
                public TsUserQuery userNameNot(String userNameNot) {
                    if(!IdUtils.isEmpty(userNameNot)){
                        this.userName_NE = userNameNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery userNameLike(String userNameLike) {
                    if(!IdUtils.isEmpty(userNameLike)){
                        this.userName_LIKE = userNameLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery userNameNotLike(String userNameNotLike) {
                    if(!IdUtils.isEmpty(userNameNotLike)){
                        this.userName_NOTLIKE = userNameNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery userNameIn(String userNameIn) {
                    if(!IdUtils.isEmpty(userNameIn)){
                        this.userName_IN.add( userNameIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery userNameNotIn(String userNameNotIn) {
                    if(!IdUtils.isEmpty(userNameNotIn)){
                        this.userName_NOTIN.add( userNameNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery userNameIsNull() {
                    this.isNulls.add("userName");
                    return this;
                }



                @Override
                public TsUserQuery userNameIsNotNull() {
                    this.isNotNulls.add("userName");
                    return this;
                }













                @Override
                public TsUserQuery loginName(String loginName) {
                    if(!IdUtils.isEmpty(loginName)){
                        this.loginName = loginName;
                    }
                    return this;
                }


                @Override
                public TsUserQuery loginNameNot(String loginNameNot) {
                    if(!IdUtils.isEmpty(loginNameNot)){
                        this.loginName_NE = loginNameNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery loginNameLike(String loginNameLike) {
                    if(!IdUtils.isEmpty(loginNameLike)){
                        this.loginName_LIKE = loginNameLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery loginNameNotLike(String loginNameNotLike) {
                    if(!IdUtils.isEmpty(loginNameNotLike)){
                        this.loginName_NOTLIKE = loginNameNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery loginNameIn(String loginNameIn) {
                    if(!IdUtils.isEmpty(loginNameIn)){
                        this.loginName_IN.add( loginNameIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery loginNameNotIn(String loginNameNotIn) {
                    if(!IdUtils.isEmpty(loginNameNotIn)){
                        this.loginName_NOTIN.add( loginNameNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery loginNameIsNull() {
                    this.isNulls.add("loginName");
                    return this;
                }



                @Override
                public TsUserQuery loginNameIsNotNull() {
                    this.isNotNulls.add("loginName");
                    return this;
                }













                @Override
                public TsUserQuery loginPassword(String loginPassword) {
                    if(!IdUtils.isEmpty(loginPassword)){
                        this.loginPassword = loginPassword;
                    }
                    return this;
                }


                @Override
                public TsUserQuery loginPasswordNot(String loginPasswordNot) {
                    if(!IdUtils.isEmpty(loginPasswordNot)){
                        this.loginPassword_NE = loginPasswordNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery loginPasswordLike(String loginPasswordLike) {
                    if(!IdUtils.isEmpty(loginPasswordLike)){
                        this.loginPassword_LIKE = loginPasswordLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery loginPasswordNotLike(String loginPasswordNotLike) {
                    if(!IdUtils.isEmpty(loginPasswordNotLike)){
                        this.loginPassword_NOTLIKE = loginPasswordNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery loginPasswordIn(String loginPasswordIn) {
                    if(!IdUtils.isEmpty(loginPasswordIn)){
                        this.loginPassword_IN.add( loginPasswordIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery loginPasswordNotIn(String loginPasswordNotIn) {
                    if(!IdUtils.isEmpty(loginPasswordNotIn)){
                        this.loginPassword_NOTIN.add( loginPasswordNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery loginPasswordIsNull() {
                    this.isNulls.add("loginPassword");
                    return this;
                }



                @Override
                public TsUserQuery loginPasswordIsNotNull() {
                    this.isNotNulls.add("loginPassword");
                    return this;
                }













                @Override
                public TsUserQuery salt(PK salt) {
                    if(!IdUtils.isEmpty(salt)){
                        this.salt = salt;
                    }
                    return this;
                }


                @Override
                public TsUserQuery saltNot(PK saltNot) {
                    if(!IdUtils.isEmpty(saltNot)){
                        this.salt_NE = saltNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery saltIn(PK saltIn) {
                    if(!IdUtils.isEmpty(saltIn)){
                        this.salt_IN.add( saltIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery saltNotIn(PK saltNotIn) {
                    if(!IdUtils.isEmpty(saltNotIn)){
                        this.salt_NOTIN.add( saltNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery saltIsNull() {
                    this.isNulls.add("salt");
                    return this;
                }



                @Override
                public TsUserQuery saltIsNotNull() {
                    this.isNotNulls.add("salt");
                    return this;
                }















                @Override
                public TsUserQuery status(String status) {
                    if(!IdUtils.isEmpty(status)){
                        this.status = status;
                    }
                    return this;
                }


                @Override
                public TsUserQuery statusNot(String statusNot) {
                    if(!IdUtils.isEmpty(statusNot)){
                        this.status_NE = statusNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery statusIn(String statusIn) {
                    if(!IdUtils.isEmpty(statusIn)){
                        this.status_IN.add( statusIn );
                    }
                    return this;
                }


                @Override
                    public TsUserQuery statusNotIn(String statusNotIn) {
                    if(!IdUtils.isEmpty(statusNotIn)){
                        this.status_NOTIN.add( statusNotIn );
                    }
                    return this;
                    }



                @Override
                public TsUserQuery statusIsNull() {
                    this.isNulls.add("status");
                    return this;
                }



                @Override
                public TsUserQuery statusIsNotNull() {
                    this.isNotNulls.add("status");
                    return this;
                }














                @Override
                public TsUserQuery leadId(PK leadId) {
                    if(!IdUtils.isEmpty(leadId)){
                        this.leadId = leadId;
                    }
                    return this;
                }


                @Override
                public TsUserQuery leadIdNot(PK leadIdNot) {
                    if(!IdUtils.isEmpty(leadIdNot)){
                        this.leadId_NE = leadIdNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery leadIdIn(PK leadIdIn) {
                    if(!IdUtils.isEmpty(leadIdIn)){
                        this.leadId_IN.add( leadIdIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery leadIdNotIn(PK leadIdNotIn) {
                    if(!IdUtils.isEmpty(leadIdNotIn)){
                        this.leadId_NOTIN.add( leadIdNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery leadIdIsNull() {
                    this.isNulls.add("leadId");
                    return this;
                }



                @Override
                public TsUserQuery leadIdIsNotNull() {
                    this.isNotNulls.add("leadId");
                    return this;
                }















                @Override
                public TsUserQuery phone(String phone) {
                    if(!IdUtils.isEmpty(phone)){
                        this.phone = phone;
                    }
                    return this;
                }


                @Override
                public TsUserQuery phoneNot(String phoneNot) {
                    if(!IdUtils.isEmpty(phoneNot)){
                        this.phone_NE = phoneNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery phoneLike(String phoneLike) {
                    if(!IdUtils.isEmpty(phoneLike)){
                        this.phone_LIKE = phoneLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery phoneNotLike(String phoneNotLike) {
                    if(!IdUtils.isEmpty(phoneNotLike)){
                        this.phone_NOTLIKE = phoneNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery phoneIn(String phoneIn) {
                    if(!IdUtils.isEmpty(phoneIn)){
                        this.phone_IN.add( phoneIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery phoneNotIn(String phoneNotIn) {
                    if(!IdUtils.isEmpty(phoneNotIn)){
                        this.phone_NOTIN.add( phoneNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery phoneIsNull() {
                    this.isNulls.add("phone");
                    return this;
                }



                @Override
                public TsUserQuery phoneIsNotNull() {
                    this.isNotNulls.add("phone");
                    return this;
                }













                @Override
                public TsUserQuery email(String email) {
                    if(!IdUtils.isEmpty(email)){
                        this.email = email;
                    }
                    return this;
                }


                @Override
                public TsUserQuery emailNot(String emailNot) {
                    if(!IdUtils.isEmpty(emailNot)){
                        this.email_NE = emailNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery emailLike(String emailLike) {
                    if(!IdUtils.isEmpty(emailLike)){
                        this.email_LIKE = emailLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery emailNotLike(String emailNotLike) {
                    if(!IdUtils.isEmpty(emailNotLike)){
                        this.email_NOTLIKE = emailNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery emailIn(String emailIn) {
                    if(!IdUtils.isEmpty(emailIn)){
                        this.email_IN.add( emailIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery emailNotIn(String emailNotIn) {
                    if(!IdUtils.isEmpty(emailNotIn)){
                        this.email_NOTIN.add( emailNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery emailIsNull() {
                    this.isNulls.add("email");
                    return this;
                }



                @Override
                public TsUserQuery emailIsNotNull() {
                    this.isNotNulls.add("email");
                    return this;
                }













                @Override
                public TsUserQuery avatarUrl(String avatarUrl) {
                    if(!IdUtils.isEmpty(avatarUrl)){
                        this.avatarUrl = avatarUrl;
                    }
                    return this;
                }


                @Override
                public TsUserQuery avatarUrlNot(String avatarUrlNot) {
                    if(!IdUtils.isEmpty(avatarUrlNot)){
                        this.avatarUrl_NE = avatarUrlNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery avatarUrlLike(String avatarUrlLike) {
                    if(!IdUtils.isEmpty(avatarUrlLike)){
                        this.avatarUrl_LIKE = avatarUrlLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery avatarUrlNotLike(String avatarUrlNotLike) {
                    if(!IdUtils.isEmpty(avatarUrlNotLike)){
                        this.avatarUrl_NOTLIKE = avatarUrlNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery avatarUrlIn(String avatarUrlIn) {
                    if(!IdUtils.isEmpty(avatarUrlIn)){
                        this.avatarUrl_IN.add( avatarUrlIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery avatarUrlNotIn(String avatarUrlNotIn) {
                    if(!IdUtils.isEmpty(avatarUrlNotIn)){
                        this.avatarUrl_NOTIN.add( avatarUrlNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery avatarUrlIsNull() {
                    this.isNulls.add("avatarUrl");
                    return this;
                }



                @Override
                public TsUserQuery avatarUrlIsNotNull() {
                    this.isNotNulls.add("avatarUrl");
                    return this;
                }













                @Override
                public TsUserQuery openId(PK openId) {
                    if(!IdUtils.isEmpty(openId)){
                        this.openId = openId;
                    }
                    return this;
                }


                @Override
                public TsUserQuery openIdNot(PK openIdNot) {
                    if(!IdUtils.isEmpty(openIdNot)){
                        this.openId_NE = openIdNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery openIdIn(PK openIdIn) {
                    if(!IdUtils.isEmpty(openIdIn)){
                        this.openId_IN.add( openIdIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery openIdNotIn(PK openIdNotIn) {
                    if(!IdUtils.isEmpty(openIdNotIn)){
                        this.openId_NOTIN.add( openIdNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery openIdIsNull() {
                    this.isNulls.add("openId");
                    return this;
                }



                @Override
                public TsUserQuery openIdIsNotNull() {
                    this.isNotNulls.add("openId");
                    return this;
                }















                @Override
                public TsUserQuery unionId(PK unionId) {
                    if(!IdUtils.isEmpty(unionId)){
                        this.unionId = unionId;
                    }
                    return this;
                }


                @Override
                public TsUserQuery unionIdNot(PK unionIdNot) {
                    if(!IdUtils.isEmpty(unionIdNot)){
                        this.unionId_NE = unionIdNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery unionIdIn(PK unionIdIn) {
                    if(!IdUtils.isEmpty(unionIdIn)){
                        this.unionId_IN.add( unionIdIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery unionIdNotIn(PK unionIdNotIn) {
                    if(!IdUtils.isEmpty(unionIdNotIn)){
                        this.unionId_NOTIN.add( unionIdNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery unionIdIsNull() {
                    this.isNulls.add("unionId");
                    return this;
                }



                @Override
                public TsUserQuery unionIdIsNotNull() {
                    this.isNotNulls.add("unionId");
                    return this;
                }















                @Override
                public TsUserQuery systemAdmin(String systemAdmin) {
                    if(!IdUtils.isEmpty(systemAdmin)){
                        this.systemAdmin = systemAdmin;
                    }
                    return this;
                }


                @Override
                public TsUserQuery systemAdminNot(String systemAdminNot) {
                    if(!IdUtils.isEmpty(systemAdminNot)){
                        this.systemAdmin_NE = systemAdminNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery systemAdminIn(String systemAdminIn) {
                    if(!IdUtils.isEmpty(systemAdminIn)){
                        this.systemAdmin_IN.add( systemAdminIn );
                    }
                    return this;
                }


                @Override
                    public TsUserQuery systemAdminNotIn(String systemAdminNotIn) {
                    if(!IdUtils.isEmpty(systemAdminNotIn)){
                        this.systemAdmin_NOTIN.add( systemAdminNotIn );
                    }
                    return this;
                    }



                @Override
                public TsUserQuery systemAdminIsNull() {
                    this.isNulls.add("systemAdmin");
                    return this;
                }



                @Override
                public TsUserQuery systemAdminIsNotNull() {
                    this.isNotNulls.add("systemAdmin");
                    return this;
                }














                @Override
                public TsUserQuery depId(PK depId) {
                    if(!IdUtils.isEmpty(depId)){
                        this.depId = depId;
                    }
                    return this;
                }


                @Override
                public TsUserQuery depIdNot(PK depIdNot) {
                    if(!IdUtils.isEmpty(depIdNot)){
                        this.depId_NE = depIdNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery depIdIn(PK depIdIn) {
                    if(!IdUtils.isEmpty(depIdIn)){
                        this.depId_IN.add( depIdIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery depIdNotIn(PK depIdNotIn) {
                    if(!IdUtils.isEmpty(depIdNotIn)){
                        this.depId_NOTIN.add( depIdNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery depIdIsNull() {
                    this.isNulls.add("depId");
                    return this;
                }



                @Override
                public TsUserQuery depIdIsNotNull() {
                    this.isNotNulls.add("depId");
                    return this;
                }















                @Override
                public TsUserQuery organId(PK organId) {
                    if(!IdUtils.isEmpty(organId)){
                        this.organId = organId;
                    }
                    return this;
                }


                @Override
                public TsUserQuery organIdNot(PK organIdNot) {
                    if(!IdUtils.isEmpty(organIdNot)){
                        this.organId_NE = organIdNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery organIdIn(PK organIdIn) {
                    if(!IdUtils.isEmpty(organIdIn)){
                        this.organId_IN.add( organIdIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery organIdNotIn(PK organIdNotIn) {
                    if(!IdUtils.isEmpty(organIdNotIn)){
                        this.organId_NOTIN.add( organIdNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery organIdIsNull() {
                    this.isNulls.add("organId");
                    return this;
                }



                @Override
                public TsUserQuery organIdIsNotNull() {
                    this.isNotNulls.add("organId");
                    return this;
                }















                @Override
                public TsUserQuery remark(String remark) {
                    if(!IdUtils.isEmpty(remark)){
                        this.remark = remark;
                    }
                    return this;
                }


                @Override
                public TsUserQuery remarkNot(String remarkNot) {
                    if(!IdUtils.isEmpty(remarkNot)){
                        this.remark_NE = remarkNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery remarkLike(String remarkLike) {
                    if(!IdUtils.isEmpty(remarkLike)){
                        this.remark_LIKE = remarkLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery remarkNotLike(String remarkNotLike) {
                    if(!IdUtils.isEmpty(remarkNotLike)){
                        this.remark_NOTLIKE = remarkNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery remarkIn(String remarkIn) {
                    if(!IdUtils.isEmpty(remarkIn)){
                        this.remark_IN.add( remarkIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery remarkNotIn(String remarkNotIn) {
                    if(!IdUtils.isEmpty(remarkNotIn)){
                        this.remark_NOTIN.add( remarkNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery remarkIsNull() {
                    this.isNulls.add("remark");
                    return this;
                }



                @Override
                public TsUserQuery remarkIsNotNull() {
                    this.isNotNulls.add("remark");
                    return this;
                }













                @Override
                public TsUserQuery deleteFlag(String deleteFlag) {
                    if(!IdUtils.isEmpty(deleteFlag)){
                        this.deleteFlag = deleteFlag;
                    }
                    return this;
                }


                @Override
                public TsUserQuery deleteFlagNot(String deleteFlagNot) {
                    if(!IdUtils.isEmpty(deleteFlagNot)){
                        this.deleteFlag_NE = deleteFlagNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery deleteFlagIn(String deleteFlagIn) {
                    if(!IdUtils.isEmpty(deleteFlagIn)){
                        this.deleteFlag_IN.add( deleteFlagIn );
                    }
                    return this;
                }


                @Override
                    public TsUserQuery deleteFlagNotIn(String deleteFlagNotIn) {
                    if(!IdUtils.isEmpty(deleteFlagNotIn)){
                        this.deleteFlag_NOTIN.add( deleteFlagNotIn );
                    }
                    return this;
                    }



                @Override
                public TsUserQuery deleteFlagIsNull() {
                    this.isNulls.add("deleteFlag");
                    return this;
                }



                @Override
                public TsUserQuery deleteFlagIsNotNull() {
                    this.isNotNulls.add("deleteFlag");
                    return this;
                }














                @Override
                public TsUserQuery createUserId(PK createUserId) {
                    if(!IdUtils.isEmpty(createUserId)){
                        this.createUserId = createUserId;
                    }
                    return this;
                }


                @Override
                public TsUserQuery createUserIdNot(PK createUserIdNot) {
                    if(!IdUtils.isEmpty(createUserIdNot)){
                        this.createUserId_NE = createUserIdNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery createUserIdIn(PK createUserIdIn) {
                    if(!IdUtils.isEmpty(createUserIdIn)){
                        this.createUserId_IN.add( createUserIdIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery createUserIdNotIn(PK createUserIdNotIn) {
                    if(!IdUtils.isEmpty(createUserIdNotIn)){
                        this.createUserId_NOTIN.add( createUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery createUserIdIsNull() {
                    this.isNulls.add("createUserId");
                    return this;
                }



                @Override
                public TsUserQuery createUserIdIsNotNull() {
                    this.isNotNulls.add("createUserId");
                    return this;
                }















                @Override
                public TsUserQuery createUserName(String createUserName) {
                    if(!IdUtils.isEmpty(createUserName)){
                        this.createUserName = createUserName;
                    }
                    return this;
                }


                @Override
                public TsUserQuery createUserNameNot(String createUserNameNot) {
                    if(!IdUtils.isEmpty(createUserNameNot)){
                        this.createUserName_NE = createUserNameNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery createUserNameLike(String createUserNameLike) {
                    if(!IdUtils.isEmpty(createUserNameLike)){
                        this.createUserName_LIKE = createUserNameLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery createUserNameNotLike(String createUserNameNotLike) {
                    if(!IdUtils.isEmpty(createUserNameNotLike)){
                        this.createUserName_NOTLIKE = createUserNameNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery createUserNameIn(String createUserNameIn) {
                    if(!IdUtils.isEmpty(createUserNameIn)){
                        this.createUserName_IN.add( createUserNameIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery createUserNameNotIn(String createUserNameNotIn) {
                    if(!IdUtils.isEmpty(createUserNameNotIn)){
                        this.createUserName_NOTIN.add( createUserNameNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery createUserNameIsNull() {
                    this.isNulls.add("createUserName");
                    return this;
                }



                @Override
                public TsUserQuery createUserNameIsNotNull() {
                    this.isNotNulls.add("createUserName");
                    return this;
                }













            @Override
            public TsUserQuery createTime(Timestamp createTime) {
                if(!IdUtils.isEmpty(createTime)){
                    this.createTime = createTime;
                }
                return this;
            }



            @Override
            public TsUserQuery createTimeNot(Timestamp createTimeNot) {
                if(!IdUtils.isEmpty(createTimeNot)){
                    this.createTime_NE = createTimeNot;
                }
                return this;
            }

            @Override
            public TsUserQuery createTimeGreaterThan(Timestamp createTimeGreaterThan){
                if(createTimeGreaterThan != null){
                    this.createTime_GT = createTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TsUserQuery createTimeGreaterEqual(Timestamp createTimeGreaterEqual){
                if(createTimeGreaterEqual != null){
                    this.createTime_GE = createTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TsUserQuery createTimeLessThan(Timestamp createTimeLessThan){
                if(createTimeLessThan != null){
                    this.createTime_LT = createTimeLessThan;
                }
                return this;
            }

            @Override
            public TsUserQuery createTimeLessEqual(Timestamp createTimeLessEqual){
                if(createTimeLessEqual != null){
                    this.createTime_LE = createTimeLessEqual;
                }
                return this;
            }











                @Override
                public TsUserQuery updateUserId(PK updateUserId) {
                    if(!IdUtils.isEmpty(updateUserId)){
                        this.updateUserId = updateUserId;
                    }
                    return this;
                }


                @Override
                public TsUserQuery updateUserIdNot(PK updateUserIdNot) {
                    if(!IdUtils.isEmpty(updateUserIdNot)){
                        this.updateUserId_NE = updateUserIdNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery updateUserIdIn(PK updateUserIdIn) {
                    if(!IdUtils.isEmpty(updateUserIdIn)){
                        this.updateUserId_IN.add( updateUserIdIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery updateUserIdNotIn(PK updateUserIdNotIn) {
                    if(!IdUtils.isEmpty(updateUserIdNotIn)){
                        this.updateUserId_NOTIN.add( updateUserIdNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery updateUserIdIsNull() {
                    this.isNulls.add("updateUserId");
                    return this;
                }



                @Override
                public TsUserQuery updateUserIdIsNotNull() {
                    this.isNotNulls.add("updateUserId");
                    return this;
                }















                @Override
                public TsUserQuery updateUserName(String updateUserName) {
                    if(!IdUtils.isEmpty(updateUserName)){
                        this.updateUserName = updateUserName;
                    }
                    return this;
                }


                @Override
                public TsUserQuery updateUserNameNot(String updateUserNameNot) {
                    if(!IdUtils.isEmpty(updateUserNameNot)){
                        this.updateUserName_NE = updateUserNameNot;
                    }
                    return this;
                }




                @Override
                public TsUserQuery updateUserNameLike(String updateUserNameLike) {
                    if(!IdUtils.isEmpty(updateUserNameLike)){
                        this.updateUserName_LIKE = updateUserNameLike;
                    }
                    return this;
                }



                @Override
                public TsUserQuery updateUserNameNotLike(String updateUserNameNotLike) {
                    if(!IdUtils.isEmpty(updateUserNameNotLike)){
                        this.updateUserName_NOTLIKE = updateUserNameNotLike;
                    }
                    return this;
                }

                @Override
                public TsUserQuery updateUserNameIn(String updateUserNameIn) {
                    if(!IdUtils.isEmpty(updateUserNameIn)){
                        this.updateUserName_IN.add( updateUserNameIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery updateUserNameNotIn(String updateUserNameNotIn) {
                    if(!IdUtils.isEmpty(updateUserNameNotIn)){
                        this.updateUserName_NOTIN.add( updateUserNameNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery updateUserNameIsNull() {
                    this.isNulls.add("updateUserName");
                    return this;
                }



                @Override
                public TsUserQuery updateUserNameIsNotNull() {
                    this.isNotNulls.add("updateUserName");
                    return this;
                }













            @Override
            public TsUserQuery updateTime(Timestamp updateTime) {
                if(!IdUtils.isEmpty(updateTime)){
                    this.updateTime = updateTime;
                }
                return this;
            }



            @Override
            public TsUserQuery updateTimeNot(Timestamp updateTimeNot) {
                if(!IdUtils.isEmpty(updateTimeNot)){
                    this.updateTime_NE = updateTimeNot;
                }
                return this;
            }

            @Override
            public TsUserQuery updateTimeGreaterThan(Timestamp updateTimeGreaterThan){
                if(updateTimeGreaterThan != null){
                    this.updateTime_GT = updateTimeGreaterThan;
                }
                return this;
            }


            @Override
            public TsUserQuery updateTimeGreaterEqual(Timestamp updateTimeGreaterEqual){
                if(updateTimeGreaterEqual != null){
                    this.updateTime_GE = updateTimeGreaterEqual;
                }
                return this;
            }


            @Override
            public TsUserQuery updateTimeLessThan(Timestamp updateTimeLessThan){
                if(updateTimeLessThan != null){
                    this.updateTime_LT = updateTimeLessThan;
                }
                return this;
            }

            @Override
            public TsUserQuery updateTimeLessEqual(Timestamp updateTimeLessEqual){
                if(updateTimeLessEqual != null){
                    this.updateTime_LE = updateTimeLessEqual;
                }
                return this;
            }











            @Override
            public TsUserQuery versionNo(Integer versionNo) {
                if(!IdUtils.isEmpty(versionNo)){
                    this.versionNo = versionNo;
                }
                return this;
            }



            @Override
            public TsUserQuery versionNoNot(Integer versionNoNot) {
                if(!IdUtils.isEmpty(versionNoNot)){
                    this.versionNo_NE = versionNoNot;
                }
                return this;
            }

            @Override
            public TsUserQuery versionNoGreaterThan(Integer versionNoGreaterThan){
                if(versionNoGreaterThan != null){
                    this.versionNo_GT = versionNoGreaterThan;
                }
                return this;
            }


            @Override
            public TsUserQuery versionNoGreaterEqual(Integer versionNoGreaterEqual){
                if(versionNoGreaterEqual != null){
                    this.versionNo_GE = versionNoGreaterEqual;
                }
                return this;
            }


            @Override
            public TsUserQuery versionNoLessThan(Integer versionNoLessThan){
                if(versionNoLessThan != null){
                    this.versionNo_LT = versionNoLessThan;
                }
                return this;
            }

            @Override
            public TsUserQuery versionNoLessEqual(Integer versionNoLessEqual){
                if(versionNoLessEqual != null){
                    this.versionNo_LE = versionNoLessEqual;
                }
                return this;
            }












                @Override
                public TsUserQuery tenantId(PK tenantId) {
                    if(!IdUtils.isEmpty(tenantId)){
                        this.tenantId = tenantId;
                    }
                    return this;
                }


                @Override
                public TsUserQuery tenantIdNot(PK tenantIdNot) {
                    if(!IdUtils.isEmpty(tenantIdNot)){
                        this.tenantId_NE = tenantIdNot;
                    }
                    return this;
                }

                @Override
                public TsUserQuery tenantIdIn(PK tenantIdIn) {
                    if(!IdUtils.isEmpty(tenantIdIn)){
                        this.tenantId_IN.add( tenantIdIn );
                    }
                    return this;
                }


                @Override
                public TsUserQuery tenantIdNotIn(PK tenantIdNotIn) {
                    if(!IdUtils.isEmpty(tenantIdNotIn)){
                        this.tenantId_NOTIN.add( tenantIdNotIn );
                    }
                    return this;
                }



                @Override
                public TsUserQuery tenantIdIsNull() {
                    this.isNulls.add("tenantId");
                    return this;
                }



                @Override
                public TsUserQuery tenantIdIsNotNull() {
                    this.isNotNulls.add("tenantId");
                    return this;
                }










	
}