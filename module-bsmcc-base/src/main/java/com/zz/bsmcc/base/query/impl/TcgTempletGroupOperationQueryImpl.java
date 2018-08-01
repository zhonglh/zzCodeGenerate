package com.zz.bsmcc.base.query.impl;



import com.zz.bsmcc.base.query.TcgTempletGroupOperationQuery;
import com.zz.bms.util.base.java.IdUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 模板组操作定义 查询抽象类
 * 用于链式查询
 * @author Administrator
 * @date 2018-8-1 12:58:18
 */
public class TcgTempletGroupOperationQueryImpl<PK extends Serializable> extends TcgTempletGroupOperationAbstractQueryImpl<PK> implements TcgTempletGroupOperationQuery<PK>, Serializable  {







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
                public TcgTempletGroupOperationQuery id(PK id) {
                    if(!IdUtils.isEmpty(id)){
                        this.id = id;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery idNot(PK idNot) {
                    if(!IdUtils.isEmpty(idNot)){
                        this.id_NE = idNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupOperationQuery idIn(PK idIn) {
                    if(!IdUtils.isEmpty(idIn)){
                        if(this.id_IN == null){
                            this.id_IN = new ArrayList<PK>();
                        }
                        this.id_IN.add( idIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery idNotIn(PK idNotIn) {
                    if(!IdUtils.isEmpty(idNotIn)){
                        if(this.id_NOTIN == null){
                            this.id_NOTIN = new ArrayList<PK>();
                        }
                        this.id_NOTIN.add( idNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery idIsNull() {
                    this.isNulls.add("id");
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery idIsNotNull() {
                    this.isNotNulls.add("id");
                    return this;
                }















                @Override
                public TcgTempletGroupOperationQuery groupId(PK groupId) {
                    if(!IdUtils.isEmpty(groupId)){
                        this.groupId = groupId;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery groupIdNot(PK groupIdNot) {
                    if(!IdUtils.isEmpty(groupIdNot)){
                        this.groupId_NE = groupIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupOperationQuery groupIdIn(PK groupIdIn) {
                    if(!IdUtils.isEmpty(groupIdIn)){
                        if(this.groupId_IN == null){
                            this.groupId_IN = new ArrayList<PK>();
                        }
                        this.groupId_IN.add( groupIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery groupIdNotIn(PK groupIdNotIn) {
                    if(!IdUtils.isEmpty(groupIdNotIn)){
                        if(this.groupId_NOTIN == null){
                            this.groupId_NOTIN = new ArrayList<PK>();
                        }
                        this.groupId_NOTIN.add( groupIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery groupIdIsNull() {
                    this.isNulls.add("groupId");
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery groupIdIsNotNull() {
                    this.isNotNulls.add("groupId");
                    return this;
                }















                @Override
                public TcgTempletGroupOperationQuery operationId(PK operationId) {
                    if(!IdUtils.isEmpty(operationId)){
                        this.operationId = operationId;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery operationIdNot(PK operationIdNot) {
                    if(!IdUtils.isEmpty(operationIdNot)){
                        this.operationId_NE = operationIdNot;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupOperationQuery operationIdIn(PK operationIdIn) {
                    if(!IdUtils.isEmpty(operationIdIn)){
                        if(this.operationId_IN == null){
                            this.operationId_IN = new ArrayList<PK>();
                        }
                        this.operationId_IN.add( operationIdIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery operationIdNotIn(PK operationIdNotIn) {
                    if(!IdUtils.isEmpty(operationIdNotIn)){
                        if(this.operationId_NOTIN == null){
                            this.operationId_NOTIN = new ArrayList<PK>();
                        }
                        this.operationId_NOTIN.add( operationIdNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery operationIdIsNull() {
                    this.isNulls.add("operationId");
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery operationIdIsNotNull() {
                    this.isNotNulls.add("operationId");
                    return this;
                }















                @Override
                public TcgTempletGroupOperationQuery icons(String icons) {
                    if(!IdUtils.isEmpty(icons)){
                        this.icons = icons;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery iconsNot(String iconsNot) {
                    if(!IdUtils.isEmpty(iconsNot)){
                        this.icons_NE = iconsNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGroupOperationQuery iconsLike(String iconsLike) {
                    if(!IdUtils.isEmpty(iconsLike)){
                        this.icons_LIKE = iconsLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery iconsNotLike(String iconsNotLike) {
                    if(!IdUtils.isEmpty(iconsNotLike)){
                        this.icons_NOTLIKE = iconsNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupOperationQuery iconsIn(String iconsIn) {
                    if(!IdUtils.isEmpty(iconsIn)){
                        if(this.icons_IN == null){
                            this.icons_IN = new ArrayList<String>();
                        }
                        this.icons_IN.add( iconsIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery iconsNotIn(String iconsNotIn) {
                    if(!IdUtils.isEmpty(iconsNotIn)){
                        if(this.icons_NOTIN == null){
                            this.icons_NOTIN = new ArrayList<String>();
                        }
                        this.icons_NOTIN.add( iconsNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery iconsIsNull() {
                    this.isNulls.add("icons");
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery iconsIsNotNull() {
                    this.isNotNulls.add("icons");
                    return this;
                }













                @Override
                public TcgTempletGroupOperationQuery styles(String styles) {
                    if(!IdUtils.isEmpty(styles)){
                        this.styles = styles;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery stylesNot(String stylesNot) {
                    if(!IdUtils.isEmpty(stylesNot)){
                        this.styles_NE = stylesNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGroupOperationQuery stylesLike(String stylesLike) {
                    if(!IdUtils.isEmpty(stylesLike)){
                        this.styles_LIKE = stylesLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery stylesNotLike(String stylesNotLike) {
                    if(!IdUtils.isEmpty(stylesNotLike)){
                        this.styles_NOTLIKE = stylesNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupOperationQuery stylesIn(String stylesIn) {
                    if(!IdUtils.isEmpty(stylesIn)){
                        if(this.styles_IN == null){
                            this.styles_IN = new ArrayList<String>();
                        }
                        this.styles_IN.add( stylesIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery stylesNotIn(String stylesNotIn) {
                    if(!IdUtils.isEmpty(stylesNotIn)){
                        if(this.styles_NOTIN == null){
                            this.styles_NOTIN = new ArrayList<String>();
                        }
                        this.styles_NOTIN.add( stylesNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery stylesIsNull() {
                    this.isNulls.add("styles");
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery stylesIsNotNull() {
                    this.isNotNulls.add("styles");
                    return this;
                }













                @Override
                public TcgTempletGroupOperationQuery classs(String classs) {
                    if(!IdUtils.isEmpty(classs)){
                        this.classs = classs;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery classsNot(String classsNot) {
                    if(!IdUtils.isEmpty(classsNot)){
                        this.classs_NE = classsNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGroupOperationQuery classsLike(String classsLike) {
                    if(!IdUtils.isEmpty(classsLike)){
                        this.classs_LIKE = classsLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery classsNotLike(String classsNotLike) {
                    if(!IdUtils.isEmpty(classsNotLike)){
                        this.classs_NOTLIKE = classsNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupOperationQuery classsIn(String classsIn) {
                    if(!IdUtils.isEmpty(classsIn)){
                        if(this.classs_IN == null){
                            this.classs_IN = new ArrayList<String>();
                        }
                        this.classs_IN.add( classsIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery classsNotIn(String classsNotIn) {
                    if(!IdUtils.isEmpty(classsNotIn)){
                        if(this.classs_NOTIN == null){
                            this.classs_NOTIN = new ArrayList<String>();
                        }
                        this.classs_NOTIN.add( classsNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery classsIsNull() {
                    this.isNulls.add("classs");
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery classsIsNotNull() {
                    this.isNotNulls.add("classs");
                    return this;
                }













                @Override
                public TcgTempletGroupOperationQuery position(String position) {
                    if(!IdUtils.isEmpty(position)){
                        this.position = position;
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery positionNot(String positionNot) {
                    if(!IdUtils.isEmpty(positionNot)){
                        this.position_NE = positionNot;
                    }
                    return this;
                }




                @Override
                public TcgTempletGroupOperationQuery positionLike(String positionLike) {
                    if(!IdUtils.isEmpty(positionLike)){
                        this.position_LIKE = positionLike;
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery positionNotLike(String positionNotLike) {
                    if(!IdUtils.isEmpty(positionNotLike)){
                        this.position_NOTLIKE = positionNotLike;
                    }
                    return this;
                }

                @Override
                public TcgTempletGroupOperationQuery positionIn(String positionIn) {
                    if(!IdUtils.isEmpty(positionIn)){
                        if(this.position_IN == null){
                            this.position_IN = new ArrayList<String>();
                        }
                        this.position_IN.add( positionIn );
                    }
                    return this;
                }


                @Override
                public TcgTempletGroupOperationQuery positionNotIn(String positionNotIn) {
                    if(!IdUtils.isEmpty(positionNotIn)){
                        if(this.position_NOTIN == null){
                            this.position_NOTIN = new ArrayList<String>();
                        }
                        this.position_NOTIN.add( positionNotIn );
                    }
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery positionIsNull() {
                    this.isNulls.add("position");
                    return this;
                }



                @Override
                public TcgTempletGroupOperationQuery positionIsNotNull() {
                    this.isNotNulls.add("position");
                    return this;
                }








	
}