package com.zz.bsmcc.base.po;

import com.zz.bsmcc.base.bo.TcgTableConfigBO;

import java.io.Serializable;

/**
 * 菜单数据项
 * @author Administrator
 */
public class MenuPO implements Serializable {
    private String id  ;
    private String topId;
    private String pid ;
    private String name;
    private String title;
    private String resource;
    private String path;
    private int level ;
    private String leaf;

    private TcgTableConfigBO table;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTopId() {
        return topId;
    }

    public void setTopId(String topId) {
        this.topId = topId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLeaf() {
        return leaf;
    }

    public void setLeaf(String leaf) {
        this.leaf = leaf;
    }

    public TcgTableConfigBO getTable() {
        return table;
    }

    public void setTable(TcgTableConfigBO table) {
        this.table = table;
    }
}
