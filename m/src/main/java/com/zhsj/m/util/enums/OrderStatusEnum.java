package com.zhsj.m.util.enums;

public enum OrderStatusEnum {

	NO_CONFIRM(0,"未确认"),
    SUCCESS(1,"成功"),
	FAIL(2,"失败");
    private final int code;
    private final String name;
    OrderStatusEnum(int i, String name){
        this.code=i;
        this.name=name;
    }

    public OrderStatusEnum getType(int type){
        for(OrderStatusEnum activeCType:values()){
            if(activeCType!=null&&activeCType.getCode()==type){
                return activeCType;
            }
        }
        return null;
    }
    public static OrderStatusEnum valueOf(int type) {
        switch (type) {
            case 0:
                return NO_CONFIRM;
            case 1:
                return SUCCESS;
            case 2:
                return FAIL;
        }
        return null;
    }
    public static String getValueChina(int type) {
        switch (type) {
            case 0:
            	return "未确认";
            case 1:
                return "成功";
            case 2:
                return "失败";
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
