package com.zhsj.m.controller.merchant;

import com.zhsj.m.bo.ShopBo;
import com.zhsj.m.model.AreaInfo;
import com.zhsj.m.model.MerchantExtendInfo;
import com.zhsj.m.model.MerchantInfo;
import com.zhsj.m.service.AreaService;
import com.zhsj.m.service.SequenceInfoService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.service.convert.impl.MerchantExtendInfoConvert;
import com.zhsj.m.service.convert.impl.MerchantInfoConvert;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.StoreNoUtils;
import com.zhsj.m.util.StoreUtils;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.util.result.JsonResult;
import com.zhsj.m.vo.MerchantInfoVO;
import org.apache.commons.lang3.CharSequenceUtils;
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
import com.zhsj.m.util.auth.Constants;

import static com.zhsj.m.util.auth.Constants.MERCHANT_USER_INFO;
import static com.zhsj.m.util.auth.Constants.SECURITY_KEY;


/**
 * Created by wuyongtao on 2017/10/15.
 */
@Controller
@RequestMapping("/merchant/shopManage")
public class ShopController implements  Constants{
    @Autowired
    private ShopService shopService;
    @Autowired
    private AreaService areaService;

    @Autowired
    private SequenceInfoService sequenceInfoService;

    private MerchantInfoConvert merchantInfoConvert = new MerchantInfoConvert();
    private MerchantExtendInfoConvert merchantExtendInfoConvert = new MerchantExtendInfoConvert();

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
    public String shopAddSave(@ModelAttribute("shopBo") MerchantInfoVO merchantInfoVO,HttpServletRequest request) {
        JsonResult result = new JsonResult();
        //获取用户信息
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantInfo merchantInfoMct = null;
        if(uInfo == null){
            result.setMessage("用户信息不存在");
            result.setSuccess(false);
        }else{
            //获取商户信息
             merchantInfoMct = shopService.getById(uInfo.getForeignId());
        }
        MerchantInfo merchantInfoPo = merchantInfoConvert.toPO(merchantInfoVO);//转换对象
        if(merchantInfoMct != null){//设置从商户继承的信息
            merchantInfoPo.setParentCode(merchantInfoMct.getMchCode());
            merchantInfoPo.setOrgId(merchantInfoMct.getOrgId());
            merchantInfoPo.setOrgIds(merchantInfoMct.getOrgIds());
        }
        String mchcode = StoreNoUtils.getStoreNO(sequenceInfoService.getCodeForShop());
        System.out.println(mchcode+"----------------------------------------");
        merchantInfoPo.setMchCode(mchcode);//门店编码
        merchantInfoPo.setType(1);//1门店
        merchantInfoMct.setStatus(0);//门店状态 0 初始1 审核中2 审核通过
        merchantInfoPo.setIsDelete(0);

        MerchantExtendInfo merchantExtendInfoPo = merchantExtendInfoConvert.toPO1(merchantInfoVO);
        /*merchantInfo.setName(shop.getName());
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
        merchantInfo.setHasSettle(shop.getHasSettle());*/
        shopService.save(merchantInfoPo,merchantExtendInfoPo);
        System.out.println("=====================================");
        return "merchantPages/shop/shopAdd";
    }

}
