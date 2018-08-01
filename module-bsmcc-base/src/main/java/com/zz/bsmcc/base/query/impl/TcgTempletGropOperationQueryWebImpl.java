package com.zz.bsmcc.base.query.impl;


import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 模板组操作定义 用于装载用户在查询时提交的数据
 * 链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:17
 */
public class TcgTempletGropOperationQueryWebImpl<PK extends Serializable> extends TcgTempletGropOperationAbstractQueryImpl<PK> implements Serializable {








            private PK id_IN;
            private PK id_NOTIN;











            private PK groupId_IN;
            private PK groupId_NOTIN;











            private PK operationId_IN;
            private PK operationId_NOTIN;










            private String icons_IN;
            private String icons_NOTIN;










            private String styles_IN;
            private String styles_NOTIN;










            private String classs_IN;
            private String classs_NOTIN;










            private String position_IN;
            private String position_NOTIN;
























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


















                public PK getGroupId() {
                    return groupId;
                }


                public void setGroupId(PK groupId) {
                    this.groupId = groupId;
                }


                public PK getGroupId_NE() {
                return groupId_NE;
                }


                public void setGroupId_NE(PK groupId_NE) {
                this.groupId_NE = groupId_NE;
                }








                public PK getGroupId_IN() {
                    return groupId_IN;
                }

                public void setGroupId_IN(PK groupId_IN) {
                    this.groupId_IN = groupId_IN;
                }

                public PK getGroupId_NOTIN() {
                    return groupId_NOTIN;
                }

                public void setGroupId_NOTIN(PK groupId_NOTIN) {
                    this.groupId_NOTIN = groupId_NOTIN;
                }


















                public PK getOperationId() {
                    return operationId;
                }


                public void setOperationId(PK operationId) {
                    this.operationId = operationId;
                }


                public PK getOperationId_NE() {
                return operationId_NE;
                }


                public void setOperationId_NE(PK operationId_NE) {
                this.operationId_NE = operationId_NE;
                }








                public PK getOperationId_IN() {
                    return operationId_IN;
                }

                public void setOperationId_IN(PK operationId_IN) {
                    this.operationId_IN = operationId_IN;
                }

                public PK getOperationId_NOTIN() {
                    return operationId_NOTIN;
                }

                public void setOperationId_NOTIN(PK operationId_NOTIN) {
                    this.operationId_NOTIN = operationId_NOTIN;
                }


















                public String getIcons() {
                    return icons;
                }


                public void setIcons(String icons) {
                    this.icons = icons;
                }


                public String getIcons_NE() {
                    return icons_NE;
                }


                public void setIcons_NE(String icons_NE) {
                    this.icons_NE = icons_NE;
                }



                public String getIcons_IN() {
                    return icons_IN;
                }

                public void setIcons_IN(String icons_IN) {
                    this.icons_IN = icons_IN;
                }

                public String getIcons_NOTIN() {
                    return icons_NOTIN;
                }

                public void setIcons_NOTIN(String icons_NOTIN) {
                    this.icons_NOTIN = icons_NOTIN;
                }




                public String getIcons_LIKE() {
                    return icons_LIKE;
                }

                public void setIcons_LIKE(String icons_LIKE) {
                    this.icons_LIKE = icons_LIKE;
                }

                public String getIcons_NOTLIKE() {
                    return icons_NOTLIKE;
                }

                public void setIcons_NOTLIKE(String icons_NOTLIKE) {
                    this.icons_NOTLIKE = icons_NOTLIKE;
                }















                public String getStyles() {
                    return styles;
                }


                public void setStyles(String styles) {
                    this.styles = styles;
                }


                public String getStyles_NE() {
                    return styles_NE;
                }


                public void setStyles_NE(String styles_NE) {
                    this.styles_NE = styles_NE;
                }



                public String getStyles_IN() {
                    return styles_IN;
                }

                public void setStyles_IN(String styles_IN) {
                    this.styles_IN = styles_IN;
                }

                public String getStyles_NOTIN() {
                    return styles_NOTIN;
                }

                public void setStyles_NOTIN(String styles_NOTIN) {
                    this.styles_NOTIN = styles_NOTIN;
                }




                public String getStyles_LIKE() {
                    return styles_LIKE;
                }

                public void setStyles_LIKE(String styles_LIKE) {
                    this.styles_LIKE = styles_LIKE;
                }

                public String getStyles_NOTLIKE() {
                    return styles_NOTLIKE;
                }

                public void setStyles_NOTLIKE(String styles_NOTLIKE) {
                    this.styles_NOTLIKE = styles_NOTLIKE;
                }















                public String getClasss() {
                    return classs;
                }


                public void setClasss(String classs) {
                    this.classs = classs;
                }


                public String getClasss_NE() {
                    return classs_NE;
                }


                public void setClasss_NE(String classs_NE) {
                    this.classs_NE = classs_NE;
                }



                public String getClasss_IN() {
                    return classs_IN;
                }

                public void setClasss_IN(String classs_IN) {
                    this.classs_IN = classs_IN;
                }

                public String getClasss_NOTIN() {
                    return classs_NOTIN;
                }

                public void setClasss_NOTIN(String classs_NOTIN) {
                    this.classs_NOTIN = classs_NOTIN;
                }




                public String getClasss_LIKE() {
                    return classs_LIKE;
                }

                public void setClasss_LIKE(String classs_LIKE) {
                    this.classs_LIKE = classs_LIKE;
                }

                public String getClasss_NOTLIKE() {
                    return classs_NOTLIKE;
                }

                public void setClasss_NOTLIKE(String classs_NOTLIKE) {
                    this.classs_NOTLIKE = classs_NOTLIKE;
                }















                public String getPosition() {
                    return position;
                }


                public void setPosition(String position) {
                    this.position = position;
                }


                public String getPosition_NE() {
                    return position_NE;
                }


                public void setPosition_NE(String position_NE) {
                    this.position_NE = position_NE;
                }



                public String getPosition_IN() {
                    return position_IN;
                }

                public void setPosition_IN(String position_IN) {
                    this.position_IN = position_IN;
                }

                public String getPosition_NOTIN() {
                    return position_NOTIN;
                }

                public void setPosition_NOTIN(String position_NOTIN) {
                    this.position_NOTIN = position_NOTIN;
                }




                public String getPosition_LIKE() {
                    return position_LIKE;
                }

                public void setPosition_LIKE(String position_LIKE) {
                    this.position_LIKE = position_LIKE;
                }

                public String getPosition_NOTLIKE() {
                    return position_NOTLIKE;
                }

                public void setPosition_NOTLIKE(String position_NOTLIKE) {
                    this.position_NOTLIKE = position_NOTLIKE;
                }







	
}