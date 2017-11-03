package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/30.
 * 商户门店信息表 类型 type:0;商户 1门店
 */
public enum MerchantInfoTypeEnum implements java.io.Serializable{
    MERCHANT(0,"商户"),
    SHOP(1,"门店");
    private final int code;
    private final String name;
    MerchantInfoTypeEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public MerchantInfoTypeEnum getType(int type){
        for(MerchantInfoTypeEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static MerchantInfoTypeEnum valueOf(int type) {
        switch (type) {
            case 0:
                return MERCHANT;
            case 1:
                return SHOP;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 0:
                return "商户";
            case 1:
                return "门店";
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
