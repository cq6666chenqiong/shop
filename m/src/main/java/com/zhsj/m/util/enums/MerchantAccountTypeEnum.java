package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/28.
 * 商户账户类型 1 商户账户 2 门店账户
 */
public enum MerchantAccountTypeEnum implements java.io.Serializable{
    MERCHANT_ACCOUNT(1,"商户账户"),
    SHOP_ACCOUNT(2,"门店账户");
    private final int code;
    private final String name;
    MerchantAccountTypeEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public MerchantAccountTypeEnum getType(int type){
        for(MerchantAccountTypeEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static MerchantAccountTypeEnum valueOf(int type) {
        switch (type) {
            case 1:
                return MERCHANT_ACCOUNT;
            case 2:
                return SHOP_ACCOUNT;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 1:
                return "商户账户";
            case 2:
                return "门店账户";
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
