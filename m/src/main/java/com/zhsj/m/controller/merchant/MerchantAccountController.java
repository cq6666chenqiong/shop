package com.zhsj.m.controller.merchant;

import com.zhsj.m.model.MerchantInfo;
import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.service.RoleInfoService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.PasswordUtil;
import com.zhsj.m.util.VerifyCodeUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.result.JsonResult;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.RoleInfoVO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by taoxiangshan on 17/10/20.
 */
@Controller
@RequestMapping("/merchant/merchantAccount")
public class MerchantAccountController implements Constants{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MerchantAccountController.class);
    @Autowired
    private MerchantAccountService merchantAccountService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private RoleInfoService roleInfoService;
    @RequestMapping("/accountList")
    public String accountList() {
        return "/merchantPages/system/accountList";
    }
    /**
     * 从cookie中读取用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getAccountFormCookie")
    @ResponseBody
    public JsonResult getAccountFormCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        try {
            MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
            //查询记录
            result.setData(merchantAccount);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error("获取数据异常", e);
            result.setMessage("获取数据异常");
            result.setSuccess(false);
        }
        return result;
    }
    /**
     * 获取账户信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getMyAccountInfo")
    public String getMyAccountInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
        MerchantInfo merchantInfo=shopService.getById(merchantAccount.getForeignId());
        List<RoleInfoVO> roleInfoList=roleInfoService.getRoleInfoListByMerchantAccountId(merchantAccount.getForeignId());
        StringBuffer sb=new StringBuffer();
        if (roleInfoList!=null&&roleInfoList.size()>0){
            for (RoleInfoVO roleInfoVO:roleInfoList){
                sb.append(roleInfoVO.getRoleName()+",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        model.addAttribute("roleNames",sb.toString());
        model.addAttribute("merchantAccount",merchantAccount);
        model.addAttribute("merchantInfo",merchantInfo);
        return "/merchantPages/system/myAccountInfo";
    }
    /**
     * 去编辑账户信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toEditMyAccountInfo")
    public String toEditMyAccountInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));

        return "/merchantPages/system/editMyAccountInfo";
    }
    /**
     * 更新账户信息
     * @return
     */
    @RequestMapping(value = "/saveMyAccountInfo")
    @ResponseBody
    public JsonResult saveMyAccountInfo(HttpServletRequest request,String phone,String password,String imagecode) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //读取验证码
            String verifyCode = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), RAND_CODE);
            if(verifyCode!=null &&  imagecode !=null &&verifyCode.toUpperCase().equalsIgnoreCase(imagecode.toUpperCase())) {
                String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
                UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
                MerchantAccountVO merchantAccountVO = new MerchantAccountVO();
                merchantAccountVO.setId(Integer.valueOf(uInfo.getUserId()));
                merchantAccountVO.setPhone(phone);
                merchantAccountVO.setPassword(PasswordUtil.encodePassword(password));
                int count = merchantAccountService.update(merchantAccountVO);
                if (count > 0) {
                    result.setSuccess(true);
                } else {
                    result.setMessage("保存失败");
                    result.setSuccess(false);
                }
            }else{
                result.setSuccess(false);
                result.setMessage("验证码错误");
            }
        } catch (Exception e) {
            logger.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
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
