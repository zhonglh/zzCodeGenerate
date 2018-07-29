package com.zz.bsmcc.gen.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
public class ConstraintEntity extends IndexEntity implements java.io.Serializable{

    public ConstraintEntity() {
    }

    public ConstraintEntity(String indexName, List<String> columnNames, List<String> javaNames) {
        super(indexName, columnNames,javaNames );
    }
}
