package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 列界面设置 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-7-29 1:16:10
 */
public class TcgColumnPageQueryWebImpl<PK extends Serializable> extends TcgColumnPageAbstractQueryImpl<PK> implements Serializable {
    private static final long serialVersionUID = 1L;







            private PK id_IN;
            private PK id_NOTIN;











            private String editable_IN;
            private String editable_NOTIN;











            private String element_IN;
            private String element_NOTIN;








        ;







        ;







        ;







        ;










            private String required_IN;
            private String required_NOTIN;









        ;










            private PK createUserId_IN;
            private PK createUserId_NOTIN;








        ;










            private PK updateUserId_IN;
            private PK updateUserId_NOTIN;








        ;























                public PK getId() {
                    return id;
                }


                public void setId(PK id) {
                    this.id = id;
                }


                public PK getId_NE() {
                return id_NE;
                }


                public void setId_NE(PK id_NE) {
                this.id_NE = id_NE;
                }








                public PK getId_IN() {
                    return id_IN;
                }

                public void setId_IN(PK id_IN) {
                    this.id_IN = id_IN;
                }

                public PK getId_NOTIN() {
                    return id_NOTIN;
                }

                public void setId_NOTIN(PK id_NOTIN) {
                    this.id_NOTIN = id_NOTIN;
                }


















                public String getEditable() {
                    return editable;
                }


                public void setEditable(String editable) {
                    this.editable = editable;
                }


                public String getEditable_NE() {
                    return editable_NE;
                }


                public void setEditable_NE(String editable_NE) {
                    this.editable_NE = editable_NE;
                }



                public String getEditable_IN() {
                    return editable_IN;
                }

                public void setEditable_IN(String editable_IN) {
                    this.editable_IN = editable_IN;
                }

                public String getEditable_NOTIN() {
                    return editable_NOTIN;
                }

                public void setEditable_NOTIN(String editable_NOTIN) {
                    this.editable_NOTIN = editable_NOTIN;
                }
















                public String getElement() {
                    return element;
                }


                public void setElement(String element) {
                    this.element = element;
                }


                public String getElement_NE() {
                    return element_NE;
                }


                public void setElement_NE(String element_NE) {
                    this.element_NE = element_NE;
                }



                public String getElement_IN() {
                    return element_IN;
                }

                public void setElement_IN(String element_IN) {
                    this.element_IN = element_IN;
                }

                public String getElement_NOTIN() {
                    return element_NOTIN;
                }

                public void setElement_NOTIN(String element_NOTIN) {
                    this.element_NOTIN = element_NOTIN;
                }




                public String getElement_LIKE() {
                    return element_LIKE;
                }

                public void setElement_LIKE(String element_LIKE) {
                    this.element_LIKE = element_LIKE;
                }

                public String getElement_NOTLIKE() {
                    return element_NOTLIKE;
                }

                public void setElement_NOTLIKE(String element_NOTLIKE) {
                    this.element_NOTLIKE = element_NOTLIKE;
                }












            public Integer getMaxlength() {
                return maxlength;
            }


            public void setMaxlength(Integer maxlength) {
                this.maxlength = maxlength;
            }


            public Integer getMaxlength_NE() {
                return maxlength_NE;
            }


            public void setMaxlength_NE(Integer maxlength_NE) {
                this.maxlength_NE = maxlength_NE;
            }



            public Integer getMaxlength_GT() {
                return maxlength_GT;
            }


            public void setMaxlength_GT(Integer maxlength_GT) {
                this.maxlength_GT = maxlength_GT;
            }


            public Integer getMaxlength_GE() {
                return maxlength_GE;
            }


            public void setMaxlength_GE(Integer maxlength_GE) {
                this.maxlength_GE = maxlength_GE;
            }




            public Integer getMaxlength_LT() {
                return maxlength_LT;
            }


            public void setMaxlength_LT(Integer maxlength_LT) {
                this.maxlength_LT = maxlength_LT;
            }


            public Integer getMaxlength_LE() {
                return maxlength_LE;
            }


            public void setMaxlength_LE(Integer maxlength_LE) {
                this.maxlength_LE = maxlength_LE;
            }












            public Integer getMinlength() {
                return minlength;
            }


            public void setMinlength(Integer minlength) {
                this.minlength = minlength;
            }


            public Integer getMinlength_NE() {
                return minlength_NE;
            }


            public void setMinlength_NE(Integer minlength_NE) {
                this.minlength_NE = minlength_NE;
            }



            public Integer getMinlength_GT() {
                return minlength_GT;
            }


            public void setMinlength_GT(Integer minlength_GT) {
                this.minlength_GT = minlength_GT;
            }


            public Integer getMinlength_GE() {
                return minlength_GE;
            }


            public void setMinlength_GE(Integer minlength_GE) {
                this.minlength_GE = minlength_GE;
            }




            public Integer getMinlength_LT() {
                return minlength_LT;
            }


            public void setMinlength_LT(Integer minlength_LT) {
                this.minlength_LT = minlength_LT;
            }


            public Integer getMinlength_LE() {
                return minlength_LE;
            }


            public void setMinlength_LE(Integer minlength_LE) {
                this.minlength_LE = minlength_LE;
            }












            public BigDecimal getMax() {
                return max;
            }


            public void setMax(BigDecimal max) {
                this.max = max;
            }


            public BigDecimal getMax_NE() {
                return max_NE;
            }


            public void setMax_NE(BigDecimal max_NE) {
                this.max_NE = max_NE;
            }



            public BigDecimal getMax_GT() {
                return max_GT;
            }


            public void setMax_GT(BigDecimal max_GT) {
                this.max_GT = max_GT;
            }


            public BigDecimal getMax_GE() {
                return max_GE;
            }


            public void setMax_GE(BigDecimal max_GE) {
                this.max_GE = max_GE;
            }




            public BigDecimal getMax_LT() {
                return max_LT;
            }


            public void setMax_LT(BigDecimal max_LT) {
                this.max_LT = max_LT;
            }


            public BigDecimal getMax_LE() {
                return max_LE;
            }


            public void setMax_LE(BigDecimal max_LE) {
                this.max_LE = max_LE;
            }












            public BigDecimal getMin() {
                return min;
            }


            public void setMin(BigDecimal min) {
                this.min = min;
            }


            public BigDecimal getMin_NE() {
                return min_NE;
            }


            public void setMin_NE(BigDecimal min_NE) {
                this.min_NE = min_NE;
            }



            public BigDecimal getMin_GT() {
                return min_GT;
            }


            public void setMin_GT(BigDecimal min_GT) {
                this.min_GT = min_GT;
            }


            public BigDecimal getMin_GE() {
                return min_GE;
            }


            public void setMin_GE(BigDecimal min_GE) {
                this.min_GE = min_GE;
            }




            public BigDecimal getMin_LT() {
                return min_LT;
            }


            public void setMin_LT(BigDecimal min_LT) {
                this.min_LT = min_LT;
            }


            public BigDecimal getMin_LE() {
                return min_LE;
            }


            public void setMin_LE(BigDecimal min_LE) {
                this.min_LE = min_LE;
            }















                public String getRequired() {
                    return required;
                }


                public void setRequired(String required) {
                    this.required = required;
                }


                public String getRequired_NE() {
                    return required_NE;
                }


                public void setRequired_NE(String required_NE) {
                    this.required_NE = required_NE;
                }



                public String getRequired_IN() {
                    return required_IN;
                }

                public void setRequired_IN(String required_IN) {
                    this.required_IN = required_IN;
                }

                public String getRequired_NOTIN() {
                    return required_NOTIN;
                }

                public void setRequired_NOTIN(String required_NOTIN) {
                    this.required_NOTIN = required_NOTIN;
                }














            public Timestamp getCreateTime() {
                return createTime;
            }


            public void setCreateTime(Timestamp createTime) {
                this.createTime = createTime;
            }


            public Timestamp getCreateTime_NE() {
                return createTime_NE;
            }


            public void setCreateTime_NE(Timestamp createTime_NE) {
                this.createTime_NE = createTime_NE;
            }



            public Timestamp getCreateTime_GT() {
                return createTime_GT;
            }


            public void setCreateTime_GT(Timestamp createTime_GT) {
                this.createTime_GT = createTime_GT;
            }


            public Timestamp getCreateTime_GE() {
                return createTime_GE;
            }


            public void setCreateTime_GE(Timestamp createTime_GE) {
                this.createTime_GE = createTime_GE;
            }




            public Timestamp getCreateTime_LT() {
                return createTime_LT;
            }


            public void setCreateTime_LT(Timestamp createTime_LT) {
                this.createTime_LT = createTime_LT;
            }


            public Timestamp getCreateTime_LE() {
                return createTime_LE;
            }


            public void setCreateTime_LE(Timestamp createTime_LE) {
                this.createTime_LE = createTime_LE;
            }













                public PK getCreateUserId() {
                    return createUserId;
                }


                public void setCreateUserId(PK createUserId) {
                    this.createUserId = createUserId;
                }


                public PK getCreateUserId_NE() {
                return createUserId_NE;
                }


                public void setCreateUserId_NE(PK createUserId_NE) {
                this.createUserId_NE = createUserId_NE;
                }








                public PK getCreateUserId_IN() {
                    return createUserId_IN;
                }

                public void setCreateUserId_IN(PK createUserId_IN) {
                    this.createUserId_IN = createUserId_IN;
                }

                public PK getCreateUserId_NOTIN() {
                    return createUserId_NOTIN;
                }

                public void setCreateUserId_NOTIN(PK createUserId_NOTIN) {
                    this.createUserId_NOTIN = createUserId_NOTIN;
                }
















            public Timestamp getUpdateTime() {
                return updateTime;
            }


            public void setUpdateTime(Timestamp updateTime) {
                this.updateTime = updateTime;
            }


            public Timestamp getUpdateTime_NE() {
                return updateTime_NE;
            }


            public void setUpdateTime_NE(Timestamp updateTime_NE) {
                this.updateTime_NE = updateTime_NE;
            }



            public Timestamp getUpdateTime_GT() {
                return updateTime_GT;
            }


            public void setUpdateTime_GT(Timestamp updateTime_GT) {
                this.updateTime_GT = updateTime_GT;
            }


            public Timestamp getUpdateTime_GE() {
                return updateTime_GE;
            }


            public void setUpdateTime_GE(Timestamp updateTime_GE) {
                this.updateTime_GE = updateTime_GE;
            }




            public Timestamp getUpdateTime_LT() {
                return updateTime_LT;
            }


            public void setUpdateTime_LT(Timestamp updateTime_LT) {
                this.updateTime_LT = updateTime_LT;
            }


            public Timestamp getUpdateTime_LE() {
                return updateTime_LE;
            }


            public void setUpdateTime_LE(Timestamp updateTime_LE) {
                this.updateTime_LE = updateTime_LE;
            }













                public PK getUpdateUserId() {
                    return updateUserId;
                }


                public void setUpdateUserId(PK updateUserId) {
                    this.updateUserId = updateUserId;
                }


                public PK getUpdateUserId_NE() {
                return updateUserId_NE;
                }


                public void setUpdateUserId_NE(PK updateUserId_NE) {
                this.updateUserId_NE = updateUserId_NE;
                }








                public PK getUpdateUserId_IN() {
                    return updateUserId_IN;
                }

                public void setUpdateUserId_IN(PK updateUserId_IN) {
                    this.updateUserId_IN = updateUserId_IN;
                }

                public PK getUpdateUserId_NOTIN() {
                    return updateUserId_NOTIN;
                }

                public void setUpdateUserId_NOTIN(PK updateUserId_NOTIN) {
                    this.updateUserId_NOTIN = updateUserId_NOTIN;
                }















            public Integer getVersionNo() {
                return versionNo;
            }


            public void setVersionNo(Integer versionNo) {
                this.versionNo = versionNo;
            }


            public Integer getVersionNo_NE() {
                return versionNo_NE;
            }


            public void setVersionNo_NE(Integer versionNo_NE) {
                this.versionNo_NE = versionNo_NE;
            }



            public Integer getVersionNo_GT() {
                return versionNo_GT;
            }


            public void setVersionNo_GT(Integer versionNo_GT) {
                this.versionNo_GT = versionNo_GT;
            }


            public Integer getVersionNo_GE() {
                return versionNo_GE;
            }


            public void setVersionNo_GE(Integer versionNo_GE) {
                this.versionNo_GE = versionNo_GE;
            }




            public Integer getVersionNo_LT() {
                return versionNo_LT;
            }


            public void setVersionNo_LT(Integer versionNo_LT) {
                this.versionNo_LT = versionNo_LT;
            }


            public Integer getVersionNo_LE() {
                return versionNo_LE;
            }


            public void setVersionNo_LE(Integer versionNo_LE) {
                this.versionNo_LE = versionNo_LE;
            }







	
}