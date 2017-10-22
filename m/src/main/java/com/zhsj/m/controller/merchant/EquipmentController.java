package com.zhsj.m.controller.merchant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wuyongtao on 2017/10/18.
 */
@Controller
@RequestMapping("/merchant/equipmentManage")
public class EquipmentController {
    @RequestMapping("/getEquipmentList")
    private String getEquipmentList(HttpServletRequest request) {
        //获取门店信息
        return "merchantPages/shop/equipment";
    }
}
