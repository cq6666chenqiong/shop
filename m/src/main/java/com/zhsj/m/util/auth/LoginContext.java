package com.zhsj.m.util.auth;

/**
 * Created by taoxiangshan on 2017/10/19.
 */
public class LoginContext {
    private static final ThreadLocal<LoginContext> contextThreadLocal = new ThreadLocal<LoginContext>();

    private UserInfo userInfo;

    /**
     * 设置用户信息
     * @param userInfo
     */
    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo(){
                return this.userInfo;
    }

    /**
     * 清除
     */
    public static void clear(){
        contextThreadLocal.remove();
    }

    /**
     * 获取用户上下文
     * @return
     */
    public static LoginContext getContext(){
        if(contextThreadLocal.get()==null){
            LoginContext loginContext =  new LoginContext();
            contextThreadLocal.set(loginContext);
        }
        return contextThreadLocal.get();
    }
}
