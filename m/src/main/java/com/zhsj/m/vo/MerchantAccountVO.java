package com.zhsj.m.vo;

import com.zhsj.m.model.MerchantAccount;

import java.io.Serializable;

/**
 * Created by taoxiangshan on 17/10/20.
 */
public class MerchantAccountVO extends MerchantAccount implements Serializable {


    private String roleNames;

    private Integer shopNum;

    private String roleIds;

    private String shopIds;

    private String shopName;


    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public Integer getShopNum() {
        return shopNum;
    }

    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getShopIds() {
        return shopIds;
    }

    public void setShopIds(String shopIds) {
        this.shopIds = shopIds;
    }


    public String getShopName() {
        return shopName;
    }


    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
