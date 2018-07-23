package com.zz.bsmcc.core.db;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class BaseEntity implements Serializable{

    private String id ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
