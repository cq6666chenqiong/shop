package com.zhsj.m.util.enums;

public enum OrderTypeEnum {

	COLLECT(1,"收款"),
    REFUNDS(2,"退款");
    private final int code;
    private final String name;
    OrderTypeEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public OrderTypeEnum getType(int type){
        for(OrderTypeEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static OrderTypeEnum valueOf(int type) {
        switch (type) {
            case 1:
                return COLLECT;
            case 2:
                return REFUNDS;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 1:
                return "收款";
            case 2:
                return "退款";
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
