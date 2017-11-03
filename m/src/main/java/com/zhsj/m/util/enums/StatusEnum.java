package com.zhsj.m.util.enums;

/**
 *  Created by taoxiangshan on 17/10/18.
 * 状态。0 停用 1 在用
 */
public enum StatusEnum implements java.io.Serializable{
    FROZEN(0,"冻结"),
    NORMAL(1,"正常");
    private final int code;
    private final String name;
    StatusEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public StatusEnum getType(int type){
        for(StatusEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static StatusEnum valueOf(int type) {
        switch (type) {
            case 1:
                return NORMAL;
            case 0:
                return FROZEN;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 1:
                return "正常";
            case 0:
                return "冻结";
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
