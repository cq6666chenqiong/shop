package com.zhsj.m.controller.merchant;

import com.zhsj.m.service.MerchantActivityCodeService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.util.result.JsonResult;
import com.zhsj.m.vo.MerchantActivityCodeVO;
import com.zhsj.m.vo.MerchantInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wuyongtao on 2017/10/18.
 */
@Controller
@RequestMapping("/merchant/terminalDevice")
public class TerminalDeviceController implements Constants {
    @Autowired
    private MerchantActivityCodeService merchantActivityCodeService;
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/getDeviceListByMacCode")
    @ResponseBody
    public JsonResult getDeviceListByMacCode(Model model, HttpServletRequest request, String macCode) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //先删除
            //List<TroubleTypeVO>troubleTypeVOList=troubleTypeService.getTroubleTypeListByDeviceId(deviceId);
            //result.setData(troubleTypeVOList);
            result.setSuccess(true);
        } catch (Exception e) {
            //log.error("提交数据异常", e);
            result.setMessage("提交数据异常");
            result.setSuccess(false);
        }
        return result;
    }
}
