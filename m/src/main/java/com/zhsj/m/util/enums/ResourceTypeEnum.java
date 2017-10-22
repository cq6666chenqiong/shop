package com.zhsj.m.util.enums;

/**
 * Created by taoxiangshan on 2016/12/13.
 */
public enum ResourceTypeEnum {
    Application("0", "应用"), Menu("1", "菜单"), Button("2", "按钮"), ALL("", "");
    private String type;
    private String typeName;

    private ResourceTypeEnum(String type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    public static ResourceTypeEnum form(String type) {
        if ("0".equalsIgnoreCase(type)) {
            return Application;
        }

        if ("1".equalsIgnoreCase(type)) {
            return Menu;
        }
        if ("2".equalsIgnoreCase(type)) {
            return Button;
        }
        return null;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getType() {
        return type;
    }
}
