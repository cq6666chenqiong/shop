package com.zhsj.m.util.enums;

public enum OrderPayMethodEnum {
	WEIXIN(1,"微信"),
    ZHIFUBAO(2,"支付宝"),
	BANK(3,"银联卡"),
	JINGDONG(4,"京东");
    private final int code;
    private final String name;
    OrderPayMethodEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public OrderPayMethodEnum getType(int type){
        for(OrderPayMethodEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static OrderPayMethodEnum valueOf(int type) {
        switch (type) {
            case 1:
                return WEIXIN;
            case 2:
                return ZHIFUBAO;
            case 3:
                return BANK;
            case 4:
                return JINGDONG;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 1:
                return "微信";
            case 2:
                return "支付宝";
            case 3:
                return "银联卡";
            case 4:
                return "京东";
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
