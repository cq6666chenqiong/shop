package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/16.
 * 系统IDEnum。1 管理后台、2 商户后台 3 商户APP
 */
public enum SystemIdEnum implements java.io.Serializable{
    MANAGER_PLATFORM(1,"管理后台"),
    MERCHANT_PLATFORM(2,"商户后台"),
    MERCHANT_APP(3,"商户APP");
    private final int code;
    private final String name;
    SystemIdEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public SystemIdEnum getType(int type){
        for(SystemIdEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static SystemIdEnum valueOf(int type) {
        switch (type) {
            case 1:
                return MANAGER_PLATFORM;
            case 2:
                return MERCHANT_PLATFORM;
            case 3:
                return MERCHANT_APP;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 1:
                return "管理后台";
            case 2:
                return "商户后台";
            case 3:
                return "商户APP";
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
