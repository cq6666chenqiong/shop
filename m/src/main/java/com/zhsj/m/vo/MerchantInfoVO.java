package com.zhsj.m.vo;

import com.zhsj.m.model.MerchantInfo;

import java.io.Serializable;

/**
 * Created by wuyongtao on 2017/10/19.
 */
public class MerchantInfoVO extends MerchantInfo implements Serializable {
    /**
     * 是否选择 1 选中 0 未选
     */
    private Integer isChecked;

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }
}
