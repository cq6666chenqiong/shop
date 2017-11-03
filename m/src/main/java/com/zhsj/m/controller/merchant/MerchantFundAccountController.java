package com.zhsj.m.controller.merchant;

import com.zhsj.m.service.MerchantFundAccountService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.service.WechatInfoService;
import com.zhsj.m.service.WithdrawRecordService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.DateUtil;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.enums.MerchantInfoTypeEnum;
import com.zhsj.m.util.enums.WechatInfoStatusEnum;
import com.zhsj.m.util.enums.WithdrawStatusEnum;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.util.result.JsonResult;
import com.zhsj.m.vo.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by taoxiangshan on 2017/10/30.
 */
@Controller
@RequestMapping("/merchant/fundAccount")
public class MerchantFundAccountController implements Constants {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MerchantFundAccountController.class);
    @Autowired
    private MerchantFundAccountService merchantFundAccountService;
    @Autowired
    private WithdrawRecordService withdrawRecordService;
    @Autowired
    private ShopService shopService;
    /**
     * 账户概览
     * @return
     */
    @RequestMapping("/overview")
    public String overview(HttpServletRequest request,Model model) {
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantFundAccountVO merchantFundAccountVO=merchantFundAccountService.getByMerchantId(uInfo.getForeignId());
        model.addAttribute("merchantFundAccount",merchantFundAccountVO);
        //TODO 实时提现余额 调接口
        model.addAttribute("realTimeAmount",0.00);
        return "/merchantPages/account/overview";
    }

    /**
     * 去提现
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toWithdraw")
    public String toWithdraw(HttpServletRequest request,Model model,Integer type) {
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantInfoVO merchantInfoVO=shopService.getById(Integer.valueOf(uInfo.getForeignId()));
        MerchantExtendInfoVO merchantExtendInfoVO = shopService.getMerchantExtendByMerchantCode(merchantInfoVO.getMchCode());
        model.addAttribute("mechantExtendInfo", merchantExtendInfoVO);
        model.addAttribute("merchantInfo", merchantInfoVO);
        //余额提现
        if (type==1) {
            MerchantFundAccountVO merchantFundAccountVO=merchantFundAccountService.getByMerchantId(uInfo.getForeignId());
            model.addAttribute("canWithdrawAmount",merchantFundAccountVO.getWithdrawAmount());
        //实时提现
        }else{
            //TODO 实时提现余额 调接口
            model.addAttribute("fee",0.00);
            model.addAttribute("canWithdrawAmount",0.00);
        }
        model.addAttribute("type", type);
        return "/merchantPages/account/withdraw";
    }
    @RequestMapping("/withdrawRecord")
    public String withdrawRecord(HttpServletRequest request, Model model, WithdrawRecordVO withdrawRecordVO) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        // pageNo判空
        if (withdrawRecordVO.getPageNo() == null) {
            withdrawRecordVO.setPageNo(1);
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (withdrawRecordVO.getStartTime()!=null) {
                withdrawRecordVO.setStartTime(df1.parse(df.format(withdrawRecordVO.getStartTime()) + " 00:00:00"));
            }
            if (withdrawRecordVO.getEndTime()!=null) {
                withdrawRecordVO.setEndTime(df1.parse(df.format(withdrawRecordVO.getEndTime()) + " 23:59:59"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PageBean pageBean = this.withdrawRecordService.queryByPage(withdrawRecordVO);
        BigDecimal sumAmount=this.withdrawRecordService.querySumAmount(withdrawRecordVO);
        model.addAttribute("sumAmount", sumAmount);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("searchCondition",withdrawRecordVO);
        model.addAttribute("today",formatter.format(new Date()));
        model.addAttribute("yesterday",formatter.format(DateUtil.getDateBeforeNDays(1)));
        model.addAttribute("sevenDayStart",formatter.format(DateUtil.getDateBeforeNDays(7)));
        model.addAttribute("sevenDayEnd",formatter.format(new Date()));
        model.addAttribute("monthStart",formatter.format(DateUtil.getDateBeforeNDays(30)));
        model.addAttribute("monthDayEnd",formatter.format(new Date()));

        return "/merchantPages/account/withdrawRecord";
    }

    /**
     * 新增保存
     * @return
     */
    @RequestMapping(value = "/saveWithdrawRecord")
    @ResponseBody
    public JsonResult saveWithdrawRecord(HttpServletRequest request,WithdrawRecordVO withdrawRecordVO) throws Exception {
        JsonResult result = new JsonResult();
        try {
            String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
            UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
            String bussNo = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS");
            //String merchantCode = withdrawRecordVO.getMchCode().toString();
            //String bussNo = String.format("%s%s%s", nowStr.substring(0, 14), merchantCode.substring(merchantCode.length() - 4), nowStr.substring(nowStr.length() - 3));
            withdrawRecordVO.setCreateTime(new Date());
            withdrawRecordVO.setBusinessNo(bussNo);
            withdrawRecordVO.setOperatorId(Integer.valueOf(uInfo.getUserId()));
            withdrawRecordVO.setStatus(WithdrawStatusEnum.PROCESSING.getCode());
            int count = withdrawRecordService.insert(withdrawRecordVO);
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
