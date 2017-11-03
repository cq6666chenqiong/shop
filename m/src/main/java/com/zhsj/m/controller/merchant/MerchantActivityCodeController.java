package com.zhsj.m.controller.merchant;

import com.zhsj.m.model.AreaInfo;
import com.zhsj.m.service.MerchantActivityCodeService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantActivityCodeVO;
import com.zhsj.m.vo.MerchantInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wuyongtao on 2017/10/18.
 */
@Controller
@RequestMapping("/merchant/activityCode")
public class MerchantActivityCodeController implements Constants {
    @Autowired
    private MerchantActivityCodeService merchantActivityCodeService;
    @Autowired
    private ShopService shopService;


    @RequestMapping("/getActivityCodeList")
    private String getMacList(HttpServletRequest request, Model model, MerchantActivityCodeVO merchantActivityCodeVO) {


        // pageNo判空
        if (merchantActivityCodeVO.getPageNo() == null) {
            merchantActivityCodeVO.setPageNo(1);
        }
        PageBean pageBean = this.merchantActivityCodeService.queryByPage(merchantActivityCodeVO);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("searchCondition",merchantActivityCodeVO);
        //获取活动码信息
        return "merchantPages/shop/activityCodeList";
    }
    @RequestMapping("/toAddActivityCode")
    private String toAddActivityCode(Model model, HttpServletRequest request) {
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantInfoVO merchantInfoVO = shopService.getById(Integer.valueOf(uInfo.getForeignId()));
        List<MerchantInfoVO>shopList=shopService.getAllShopListByParentCode(merchantInfoVO.getMchCode());
        model.addAttribute("shopList",shopList);
        return "merchantPages/shop/addActivityCode";
    }
}
