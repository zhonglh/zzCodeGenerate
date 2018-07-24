package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgTempletGropOperationQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 模板组操作定义 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-7-24 14:46:26
 */
public class TcgTempletGropOperationQueryImpl<PK extends Serializable> extends TcgTempletGropOperationAbstractQueryImpl<PK> implements TcgTempletGropOperationQuery<PK>, Serializable  {
	private static final long serialVersionUID = 1L;






            private List<PK> id_IN;
            private List<PK> id_NOTIN;













            private List<PK> groupId_IN;
            private List<PK> groupId_NOTIN;













            private List<PK> operationId_IN;
            private List<PK> operationId_NOTIN;













            private List<String> icons_IN;
            private List<String> icons_NOTIN;













            private List<String> styles_IN;
            private List<String> styles_NOTIN;













            private List<String> classs_IN;
            private List<String> classs_NOTIN;













            private List<String> position_IN;
            private List<String> position_NOTIN;
























                @Override
                public TcgTempletGropOperationQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGropOperationQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgTempletGropOperationQuery groupId(PK groupId) {
                    if(!IdUtils.isEmpty(groupId)){
                        this.groupId = groupId;
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery groupIdNot(PK groupIdNot) {
                    if(!IdUtils.isEmpty(groupIdNot)){
                        this.groupId_NE = groupIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGropOperationQuery groupIdIn(PK groupIdIn) {
                    if(!IdUtils.isEmpty(groupIdIn)){
                        this.groupId_IN.add( groupIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery groupIdNotIn(PK groupIdNotIn) {
                    if(!IdUtils.isEmpty(groupIdNotIn)){
                        this.groupId_NOTIN.add( groupIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery groupIdIsNull() {
                    this.isNulls.add("groupId");
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery groupIdIsNotNull() {
                    this.isNotNulls.add("groupId");
                    return this;
                }















                @Override
                public TcgTempletGropOperationQuery operationId(PK operationId) {
                    if(!IdUtils.isEmpty(operationId)){
                        this.operationId = operationId;
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery operationIdNot(PK operationIdNot) {
                    if(!IdUtils.isEmpty(operationIdNot)){
                        this.operationId_NE = operationIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGropOperationQuery operationIdIn(PK operationIdIn) {
                    if(!IdUtils.isEmpty(operationIdIn)){
                        this.operationId_IN.add( operationIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery operationIdNotIn(PK operationIdNotIn) {
                    if(!IdUtils.isEmpty(operationIdNotIn)){
                        this.operationId_NOTIN.add( operationIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery operationIdIsNull() {
                    this.isNulls.add("operationId");
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery operationIdIsNotNull() {
                    this.isNotNulls.add("operationId");
                    return this;
                }















                @Override
                public TcgTempletGropOperationQuery icons(String icons) {
                    if(!IdUtils.isEmpty(icons)){
                        this.icons = icons;
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery iconsNot(String iconsNot) {
                    if(!IdUtils.isEmpty(iconsNot)){
                        this.icons_NE = iconsNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGropOperationQuery iconsLike(String iconsLike) {
                    if(!IdUtils.isEmpty(iconsLike)){
                        this.icons_LIKE = iconsLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery iconsNotLike(String iconsNotLike) {
                    if(!IdUtils.isEmpty(iconsNotLike)){
                        this.icons_NOTLIKE = iconsNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGropOperationQuery iconsIn(String iconsIn) {
                    if(!IdUtils.isEmpty(iconsIn)){
                        this.icons_IN.add( iconsIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery iconsNotIn(String iconsNotIn) {
                    if(!IdUtils.isEmpty(iconsNotIn)){
                        this.icons_NOTIN.add( iconsNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery iconsIsNull() {
                    this.isNulls.add("icons");
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery iconsIsNotNull() {
                    this.isNotNulls.add("icons");
                    return this;
                }













                @Override
                public TcgTempletGropOperationQuery styles(String styles) {
                    if(!IdUtils.isEmpty(styles)){
                        this.styles = styles;
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery stylesNot(String stylesNot) {
                    if(!IdUtils.isEmpty(stylesNot)){
                        this.styles_NE = stylesNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGropOperationQuery stylesLike(String stylesLike) {
                    if(!IdUtils.isEmpty(stylesLike)){
                        this.styles_LIKE = stylesLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery stylesNotLike(String stylesNotLike) {
                    if(!IdUtils.isEmpty(stylesNotLike)){
                        this.styles_NOTLIKE = stylesNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGropOperationQuery stylesIn(String stylesIn) {
                    if(!IdUtils.isEmpty(stylesIn)){
                        this.styles_IN.add( stylesIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery stylesNotIn(String stylesNotIn) {
                    if(!IdUtils.isEmpty(stylesNotIn)){
                        this.styles_NOTIN.add( stylesNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery stylesIsNull() {
                    this.isNulls.add("styles");
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery stylesIsNotNull() {
                    this.isNotNulls.add("styles");
                    return this;
                }













                @Override
                public TcgTempletGropOperationQuery classs(String classs) {
                    if(!IdUtils.isEmpty(classs)){
                        this.classs = classs;
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery classsNot(String classsNot) {
                    if(!IdUtils.isEmpty(classsNot)){
                        this.classs_NE = classsNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGropOperationQuery classsLike(String classsLike) {
                    if(!IdUtils.isEmpty(classsLike)){
                        this.classs_LIKE = classsLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery classsNotLike(String classsNotLike) {
                    if(!IdUtils.isEmpty(classsNotLike)){
                        this.classs_NOTLIKE = classsNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGropOperationQuery classsIn(String classsIn) {
                    if(!IdUtils.isEmpty(classsIn)){
                        this.classs_IN.add( classsIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery classsNotIn(String classsNotIn) {
                    if(!IdUtils.isEmpty(classsNotIn)){
                        this.classs_NOTIN.add( classsNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery classsIsNull() {
                    this.isNulls.add("classs");
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery classsIsNotNull() {
                    this.isNotNulls.add("classs");
                    return this;
                }













                @Override
                public TcgTempletGropOperationQuery position(String position) {
                    if(!IdUtils.isEmpty(position)){
                        this.position = position;
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery positionNot(String positionNot) {
                    if(!IdUtils.isEmpty(positionNot)){
                        this.position_NE = positionNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGropOperationQuery positionLike(String positionLike) {
                    if(!IdUtils.isEmpty(positionLike)){
                        this.position_LIKE = positionLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery positionNotLike(String positionNotLike) {
                    if(!IdUtils.isEmpty(positionNotLike)){
                        this.position_NOTLIKE = positionNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGropOperationQuery positionIn(String positionIn) {
                    if(!IdUtils.isEmpty(positionIn)){
                        this.position_IN.add( positionIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGropOperationQuery positionNotIn(String positionNotIn) {
                    if(!IdUtils.isEmpty(positionNotIn)){
                        this.position_NOTIN.add( positionNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery positionIsNull() {
                    this.isNulls.add("position");
                    return this;
                }



                @Override
                public TcgTempletGropOperationQuery positionIsNotNull() {
                    this.isNotNulls.add("position");
                    return this;
                }








	
}