package com.zhsj.m.interceptors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor extends AbstractInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authURI = request.getParameter("authURI");
        String uri = request.getServletPath();
        
        if(!StringUtils.isEmpty(authURI)){
        	uri = authURI;
        }
        boolean result = false;
        if(!result){
        	String type = request.getParameter("type");
        	if("0".equals(type)){
        		sendFailResponse(response,"{\"code\":1,\"msg\":\"没有权限\"}");
        	}else if("1".equals(type)){
        		sendFailResponsePage(response,1000,"没有权限,请联系相关人开通权限");
			}
        	
        	return false;
        }
        return true;
    }
    



}
