package com.zhsj.m.vo;

import com.zhsj.m.model.WithdrawRecord;

/**
 * Created by taoxiangshan on 17/10/30.
 */
public class WithdrawRecordVO extends WithdrawRecord {
    private String mchCode;


    private Integer timeType;

    public String getMchCode() {
        return mchCode;
    }

    public void setMchCode(String mchCode) {
        this.mchCode = mchCode;
    }



    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }
}
