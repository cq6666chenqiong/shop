package com.zhsj.m.controller.merchant;

import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.service.WechatInfoService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.enums.WechatInfoStatusEnum;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.result.JsonResult;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.MerchantInfoVO;
import com.zhsj.m.vo.WechatInfoVO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by taoxiangshan on 2017/10/28.
 */
@Controller
@RequestMapping("/merchant/wechatInfo")
public class WechatInfoController implements Constants {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WechatInfoController.class);
    @Autowired
    private ShopService shopService;
    @Autowired
    private WechatInfoService wechatInfoService;
    /**
     * 去微信授权页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toWxAuth")
    public String toWxAuth(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantInfoVO merchantInfoVO = shopService.getById(Integer.valueOf(uInfo.getForeignId()));
        WechatInfoVO wechatInfoVO=wechatInfoService.getByMerchantCode(merchantInfoVO.getMchCode());
        model.addAttribute("wechatInfo",wechatInfoVO);
        return "/merchantPages/system/wxAuth";
    }
    /**
     * 去微信授权页面2
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toWxAuth2")
    public String toWxAuth2(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantInfoVO merchantInfoVO = shopService.getById(Integer.valueOf(uInfo.getForeignId()));
        WechatInfoVO wechatInfoVO=wechatInfoService.getByMerchantCode(merchantInfoVO.getMchCode());
        model.addAttribute("wechatInfo",wechatInfoVO);
        return "/merchantPages/system/wxAuth2";
    }

    /**
     * 更新账户信息
     * @return
     */
    @RequestMapping(value = "/saveWechatInfo")
    @ResponseBody
    public JsonResult saveWechatInfo(HttpServletRequest request,String name,String appId,String appSecret) throws Exception {
        JsonResult result = new JsonResult();
        try {
            String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
            UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
            MerchantInfoVO merchantInfoVO = shopService.getById(Integer.valueOf(uInfo.getForeignId()));
            WechatInfoVO wechatInfoVO=wechatInfoService.getByMerchantCode(merchantInfoVO.getMchCode());
            int count =0;
            if (wechatInfoVO!=null){
                wechatInfoVO.setAppId(appId);
                wechatInfoVO.setAppSecret(appSecret);
                wechatInfoVO.setName(name);
                count =wechatInfoService.update(wechatInfoVO);
            }else{
                wechatInfoVO=new WechatInfoVO();
                wechatInfoVO.setAppId(appId);
                wechatInfoVO.setAppSecret(appSecret);
                wechatInfoVO.setName(name);
                wechatInfoVO.setMchId(merchantInfoVO.getMchCode());
                wechatInfoVO.setStatus(WechatInfoStatusEnum.INIT.getCode());
                count =wechatInfoService.insert(wechatInfoVO);
            }
            if (count > 0) {
                result.setSuccess(true);
            } else {
                result.setMessage("保存失败");
                result.setSuccess(false);
            }

        } catch (Exception e) {
            logger.error("保存数据异常", e);
            result.setMessage("保存数据异常");
            result.setSuccess(false);
        }
        return result;
    }
}
