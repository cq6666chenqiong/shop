package com.zhsj.m.interceptors;

import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.LoginContext;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@Component
public class LoginInterceptor extends AbstractInterceptor implements Constants {
    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //读取登录信息
        String userInfoJson ="";
        if (request.getRequestURI().contains("/merchant/")){
            userInfoJson= CookieUtils.readCookie(request,properties.getString(SECURITY_KEY),MERCHANT_USER_INFO);
        }else if(request.getRequestURI().contains("/manager/")){
            userInfoJson= CookieUtils.readCookie(request,properties.getString(SECURITY_KEY),MANAGER_USER_INFO);
        }else{
            userInfoJson= CookieUtils.readCookie(request,properties.getString(SECURITY_KEY),MERCHANT_USER_INFO);
        }
        if(StringUtils.isEmpty(userInfoJson)){
            logger.debug("未登录请求："+request.getRequestURI());
            System.out.println("**************************"+request.getRequestURI());
            //String url = request.getContextPath() + properties.getString(LOGIN_URL) + "?backUrl=" + URLEncoder.encode(request.getRequestURL().toString(), ENC);
            if(request.getRequestURI().contains("/merchant/")) {
                String url = request.getContextPath() + properties.getString(MERCHANT_LOGIN_URL);
                response.sendRedirect(url);
            }else if(request.getRequestURI().contains("/manager/")){
                String url = request.getContextPath() + properties.getString(MANAGER_LOGIN_URL);
                response.sendRedirect(url);
            }else{
                String url = request.getContextPath() + properties.getString(MERCHANT_LOGIN_URL);
                response.sendRedirect(url);
            }
            return false;
        }else {
            UserInfo userInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
            LoginContext.getContext().setUserInfo(userInfo);
            logger.debug("用户:::" +LoginContext.getContext().getUserInfo().getUserName() +":::角色Id:::"+LoginContext.getContext().getUserInfo().getRoleIds() +":::请求资源:::" + request.getRequestURI());
            return super.preHandle(request, response, handler);
        }

    }

}
