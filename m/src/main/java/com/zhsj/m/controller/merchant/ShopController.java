package com.zhsj.m.controller.merchant;

import com.zhsj.m.bo.ShopBo;
import com.zhsj.m.model.AreaInfo;
import com.zhsj.m.model.MerchantInfo;
import com.zhsj.m.service.AreaService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wuyongtao on 2017/10/15.
 */
@Controller
@RequestMapping("/merchant/shopManage")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "getShopList",method= {RequestMethod.GET,RequestMethod.POST})
    public Object list(Model model, MerchantInfoVO merchantInfoVO, HttpServletRequest request, HttpServletResponse response) {//获取门店信息        // pageNo判空
        System.out.println(merchantInfoVO.getMchCode()+"-----------------------------");
        if (merchantInfoVO.getPageNo() == null) {
            merchantInfoVO.setPageNo(1);
        }
        PageBean pageBean = (PageBean) this.shopService.queryByPage(merchantInfoVO);
        System.out.println(pageBean.getList().size()+"===========================");
        model.addAttribute("pageBean", pageBean);
        return "merchantPages/shop/shop";
    }


    @RequestMapping("/shopAdd")
    public ModelAndView shopAdd(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("merchantPages/shop/shopAdd");
        try {
            List<AreaInfo> areaInfos = areaService.getAreasByParentId(1);
            mav.addObject("areaInfos",areaInfos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("/shopAddSave")
    public String shopAddSave(@ModelAttribute("shopBo") ShopBo shop) {
        MerchantInfo merchantInfo = new MerchantInfo();
        System.out.println(shop.getName()+"=========================");
        merchantInfo.setName(shop.getName());
        merchantInfo.setShortName(shop.getShortName());
        merchantInfo.setRegion(shop.getRegion());
        merchantInfo.setCounty(shop.getCounty());
        merchantInfo.setDistrict(shop.getDistrict());
        merchantInfo.setContactPhone(shop.getContactPhone());
        merchantInfo.setBusinessStarttimeHour(shop.getBusinessStarttimeHour());
        merchantInfo.setBusinessStarttimeMin(shop.getBusinessStarttimeMin());
        merchantInfo.setBusinessEndtimeHour(shop.getBusinessEndtimeHour());
        merchantInfo.setBusinessEndtimeMin(shop.getBusinessEndtimeMin());
        merchantInfo.setLegalPersonName(shop.getLegalPersonName());
        merchantInfo.setLegalPersonTel(shop.getLegalPersonTel());
        merchantInfo.setAddress(shop.getAddress());
        merchantInfo.setLon(shop.getLon());
        merchantInfo.setLat(shop.getLat());
        merchantInfo.setHasSettle(shop.getHasSettle());

        merchantInfo.setMchCode("123");
        merchantInfo.setOrgId(1);
        merchantInfo.setOrgIds("1,2");
        merchantInfo.setType(1);//1门店



        shopService.save(merchantInfo);
        System.out.println("=====================================");
        return "merchantPages/shop/shopAdd";
    }

}
