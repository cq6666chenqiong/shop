package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/18.
 * 状态。0 初始；末接入  1，授权第三方
 */
public enum WechatInfoStatusEnum implements java.io.Serializable{
    INIT(0,"初始"),
    AUTHED(1,"授权第三方");
    private final int code;
    private final String name;
    WechatInfoStatusEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public WechatInfoStatusEnum getType(int type){
        for(WechatInfoStatusEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static WechatInfoStatusEnum valueOf(int type) {
        switch (type) {
            case 0:
                return INIT;
            case 1:
                return AUTHED;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 0:
                return "初始";
            case 1:
                return "授权第三方";
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
