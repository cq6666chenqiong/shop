package com.zhsj.m.controller.merchant;

import com.zhsj.m.model.AreaInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wuyongtao on 2017/10/18.
 */
@Controller
@RequestMapping("/merchant/merchantActivityCodeManage")
public class MerchantActivityCodeController {

    @RequestMapping("/getMacList")
    private String getMacList(HttpServletRequest request) {
        //获取活动码信息
        return "merchantPages/shop/mac";
    }
    @RequestMapping("/macAdd")
    private ModelAndView macAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("merchantPages/shop/macAdd");
        return mav;
    }
}
