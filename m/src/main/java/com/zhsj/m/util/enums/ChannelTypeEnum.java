package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/16.
 * 频道类型 1 菜单 2 按钮
 */
public enum ChannelTypeEnum implements java.io.Serializable{
    MENU(1,"菜单"),
    BUTTON(2,"按钮");
    private final int code;
    private final String name;
    ChannelTypeEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public ChannelTypeEnum getType(int type){
        for(ChannelTypeEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static ChannelTypeEnum valueOf(int type) {
        switch (type) {
            case 1:
                return MENU;
            case 2:
                return BUTTON;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 1:
                return "菜单";
            case 2:
                return "按钮";
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
