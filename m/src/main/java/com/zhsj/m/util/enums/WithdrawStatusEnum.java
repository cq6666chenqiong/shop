package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/31.
 *  提现状态：0 处理中 1 提现成功 2 提现失败
 */
public enum WithdrawStatusEnum implements java.io.Serializable{
    PROCESSING(0,"处理中"),
    WITHDRAW_SUCCESS(1,"提现成功"),
    WITHDRAW_FAIL(2,"提现失败");
    private final int code;
    private final String name;
    WithdrawStatusEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public WithdrawStatusEnum getType(int type){
        for(WithdrawStatusEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static WithdrawStatusEnum valueOf(int type) {
        switch (type) {
            case 0:
                return PROCESSING;
            case 1:
                return WITHDRAW_SUCCESS;
            case 2:
                return WITHDRAW_FAIL;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 0:
                return "处理中";
            case 1:
                return "提现成功";
            case 2:
                return "提现失败";
        }
        return null;
    }
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
