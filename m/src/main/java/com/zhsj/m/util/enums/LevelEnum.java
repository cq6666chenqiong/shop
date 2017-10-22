package com.zhsj.m.util.enums;

import java.util.logging.Level;

/**
 * Created by wuyongtao on 2017/10/16.
 */
public enum LevelEnum {
    Level0(0,"0级"),
    Level1(1,"1级"),
    Level26(26,"26级");
    private final int code;
    private final String name;
    LevelEnum(int i, String name){
        this.code=i;
        this.name=name;
    }
}
