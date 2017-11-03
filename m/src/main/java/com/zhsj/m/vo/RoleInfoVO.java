package com.zhsj.m.vo;

import com.zhsj.m.model.RoleInfo;

import java.io.Serializable;

public class RoleInfoVO extends RoleInfo implements Serializable {

    /**
     * 资源IDS
     */
    private String resourceIds;
    /**
     * 是否选择 1 选中 0 未选
     */
    private Integer isChecked;

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }
}