package com.zhsj.m.model;

import java.util.Date;

public class MerchantAccountBindShop {

    private Integer id;


    private Integer merchantAccountId;


    private Integer shopId;


    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantAccountId() {
        return merchantAccountId;
    }

    public void setMerchantAccountId(Integer merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}