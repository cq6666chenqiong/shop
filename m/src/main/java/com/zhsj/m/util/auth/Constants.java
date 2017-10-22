package com.zhsj.m.util.auth;

import java.util.ResourceBundle;

/**
 * Created by taoxiangshan on 2017/10/19.
 */
public interface Constants {
    static final ResourceBundle properties = ResourceBundle.getBundle("config");
    static final String ENC = "utf-8";
    static final String RAND_CODE = "randCode";
    static final String MERCHANT_USER_INFO = "merchant";
    static final String MANAGER_USER_INFO = "manager";
    static final String BACK_URL = "backUrl";
    static  final String SECURITY_KEY = "security.des.key";
    static  final String MERCHANT_LOGIN_URL = "merchant.authenticate.url";
    static  final String MANAGER_LOGIN_URL = "manager.authenticate.url";
    static  final String MENU_CENTER_INTERFACE_URL = "menu.center.interface.url";
}
