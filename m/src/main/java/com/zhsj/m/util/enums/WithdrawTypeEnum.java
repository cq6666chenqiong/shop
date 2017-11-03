package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/31.
 *  提现类型 1 余额提现 2 实时提现
 */
public enum WithdrawTypeEnum implements java.io.Serializable{

    BALANCE_WITHDRAW(1,"余额提现"),
    REALTIME_WITHDRAW(2,"实时提现");
    private final int code;
    private final String name;
    WithdrawTypeEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public WithdrawTypeEnum getType(int type){
        for(WithdrawTypeEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static WithdrawTypeEnum valueOf(int type) {
        switch (type) {

            case 1:
                return BALANCE_WITHDRAW;
            case 2:
                return REALTIME_WITHDRAW;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {

            case 1:
                return "余额提现";
            case 2:
                return "实时提现";
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
