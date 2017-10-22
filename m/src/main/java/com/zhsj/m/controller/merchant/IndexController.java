package com.zhsj.m.controller.merchant;

import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.PasswordUtil;
import com.zhsj.m.util.VerifyCodeUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.LoginContext;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.result.JsonResult;
import com.zhsj.m.vo.MerchantAccountVO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by taoxiangshan on 17/10/13.
 */
@Controller
@RequestMapping("/merchant/index")
public class IndexController implements Constants{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private MerchantAccountService merchantAccountService;
    @RequestMapping("")
    public String index() {
        return "/merchantPages/index";
    }
    @RequestMapping("/home")
    public String home() {
        return "/merchantPages/home";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, String backUrl) {
        String desKey = properties.getString(SECURITY_KEY);
        //写backurl
        //CookieUtils.writeCookie(response, desKey, BACK_URL, backUrl);
        return "/merchantPages/login";
    }

    @RequestMapping("/authenticate")
    @ResponseBody
    public JsonResult authenticate(HttpServletRequest request, HttpServletResponse response, String account, String password, String imagecode, String backUrl) {
        JsonResult jsonResult = new JsonResult();
        String desKey = properties.getString(SECURITY_KEY);
        //读取验证码
        String verifyCode = CookieUtils.readCookie(request, desKey, RAND_CODE);
        try {
            if(verifyCode!=null &&  imagecode !=null &&verifyCode.toUpperCase().equalsIgnoreCase(imagecode.toUpperCase())){//验证码
                MerchantAccountVO user = merchantAccountService.getByAccount(account);
                String pwd = PasswordUtil.encodePassword(password);
                if(user!=null){
                    if(pwd.equalsIgnoreCase(user.getPassword())){
                        //登录成功
                        jsonResult.setSuccess(true);
                        jsonResult.setMessage("登录认证成功。");
                        //写backUrl
                        jsonResult.put(BACK_URL,CookieUtils.readCookie(request,desKey,BACK_URL));
                        //清除backUrl
                        CookieUtils.invalidate(request,response,BACK_URL);
                        //设置登录用户信息
                        UserInfo userInfo = new UserInfo();
                        userInfo.setUserId(user.getId()+"");
                        userInfo.setUserName(user.getAccount());
                        userInfo.setForeignId(Integer.valueOf(user.getForeignId()));
                        userInfo.setName(user.getName());
                        CookieUtils.writeCookie(response,desKey,MERCHANT_USER_INFO, JsonUtils.toJSON(userInfo));

                    }else{
                        jsonResult.setSuccess(false);
                        jsonResult.setMessage("认证失败，用户名或密码错误");
                    }

                }else{
                    jsonResult.setSuccess(false);
                    jsonResult.setMessage("认证失败，用户不存在");
                }
            }else{
                jsonResult.setSuccess(false);
                jsonResult.setMessage("验证码错误");
            }
        } catch (Exception e) {
            logger.error("登录异常", e);
            jsonResult.setSuccess(false);
            jsonResult.setMessage("认证用户身份信息时异常");
        }

        //清除验证码
        CookieUtils.invalidate(request, response, RAND_CODE);
        return jsonResult;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        //清除用户cookie
        CookieUtils.invalidate(request,response);
        LoginContext.clear();
        return "/merchantPages/login";
    }

    @RequestMapping("/imageCode")
    public void imageCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);


        //写入Cookie
        CookieUtils.writeCookie(response, properties.getString(SECURITY_KEY), RAND_CODE, verifyCode);
        //生成图片
        int w = 200, h = 80;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }
}
