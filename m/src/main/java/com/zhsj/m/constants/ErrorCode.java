package com.zhsj.m.constants;

public enum ErrorCode {
    unique(1, "排它优惠"),
    STORE(2, "商家优惠"),
    blend(3, "普通优惠");  // 待定

    private int type;

    private String desc;

    ErrorCode(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static ErrorCode of(int type) {
        for (ErrorCode elem : ErrorCode.values()) {
            if (type == elem.getType()) {
                return elem;
            }
        }
        return null;
    }
}
