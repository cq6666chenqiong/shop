package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/16.
 * 是否归档。0 未归档、1 归档
 */
public enum IsDeleteEnum implements java.io.Serializable{
    UN_DELETE(0,"未归档"),
    DELETE(1,"归档");
    private final int code;
    private final String name;
    IsDeleteEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public IsDeleteEnum getType(int type){
        for(IsDeleteEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static IsDeleteEnum valueOf(int type) {
        switch (type) {
            case 0:
                return UN_DELETE;
            case 1:
                return DELETE;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 0:
                return "未归档";
            case 1:
                return "归档";
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
