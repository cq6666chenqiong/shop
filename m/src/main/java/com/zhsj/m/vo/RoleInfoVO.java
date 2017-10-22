package com.zhsj.m.vo;

import com.zhsj.m.model.RoleInfo;

import java.io.Serializable;

public class RoleInfoVO extends RoleInfo implements Serializable {

    /**
     * 资源IDS
     */
    private String resourceIds;

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }
}