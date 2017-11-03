package com.zhsj.m.controller.merchant;

import com.zhsj.m.model.OrderInfo;
import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.service.MerchantFinanceService;
import com.zhsj.m.service.MerchantHomeService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.DateUtil;
import com.zhsj.m.util.FinanceUtil;
import com.zhsj.m.util.PasswordUtil;
import com.zhsj.m.util.VerifyCodeUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.LoginContext;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.result.JsonResult;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.MerchantInfoVO;
import com.zhsj.m.vo.OrderInfoVO;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by taoxiangshan on 17/10/13.
 */
@Controller
@RequestMapping("/merchant/index")
public class IndexController implements Constants{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private MerchantAccountService merchantAccountService;
    
    @Autowired
	private MerchantFinanceService merchantFinanceService;

    @Autowired
    private MerchantHomeService merchantHomeService;
    
    @Autowired
	private ShopService shopService;
    
    @RequestMapping("")
    public String index() {
        return "/merchantPages/index";
    }
    
   
    @RequestMapping(value = "/home",method= {RequestMethod.GET,RequestMethod.POST})
    public String home(HttpServletRequest req,Model model) throws SQLException {
    	OrderInfoVO orderInfo = new OrderInfoVO();
    	orderInfo.setStatus(1);
    	String timeDate = null;
    	String startTime = null;
    	String endTime = req.getParameter("endTimeStr");
    	if(timeDate != null && !timeDate.equals("")){
    		Long startTimeNumber = DateUtil.formatTime2Long(startTime+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    		orderInfo.setStartTime(startTimeNumber);
    		Long endTimeNumber = DateUtil.formatTime2Long(endTime+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
        	orderInfo.setEndTime(endTimeNumber);
    	}else{
    		String todayStr = DateUtil.formateDate2String(new Date(), "yyyy-MM-dd");
        	Long startTimeNumber = DateUtil.formatTime2Long(DateUtil.addDateBeginStr(todayStr), "yyyy-MM-dd HH:mm:ss");
    		orderInfo.setStartTime(startTimeNumber);
    		Long endTimeNumber = DateUtil.formatTime2Long(DateUtil.addDateEndStr(todayStr), "yyyy-MM-dd HH:mm:ss");
        	orderInfo.setEndTime(endTimeNumber);
    	}
        
        Integer pageNo = orderInfo.getPageNo()==null?0:orderInfo.getPageNo();
    	String userInfoJson = CookieUtils.readCookie(req, Constants.properties.getString(Constants.SECURITY_KEY), Constants.MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO account = merchantAccountService.getByAccount(uInfo.getUserName());
    	
        if(account.getIsAdmin() == 1){
        	
         }else{
        	if(account.getAccountType() == 1){//商户
        		orderInfo.setAuth(1);
        		MerchantInfoVO merchant = shopService.getById(uInfo.getForeignId());
        		orderInfo.setMerchantCode(merchant.getMchCode());
        		List storeList = shopService.getAllShopListByParentCode(merchant.getMchCode());
        		storeList.add(merchant.getMchCode());
        		String condition = FinanceUtil.getCondition(storeList);
        		orderInfo.setCondition(condition);
        		//list 门店list
        		//orderInfo.setCondition(FinanceUtil.getCondition(list));
        	}else if(account.getAccountType() == 2){//门店
        		orderInfo.setAuth(2);
        		MerchantInfoVO store = shopService.getById(uInfo.getForeignId());
        		orderInfo.setStoreCode(store.getMchCode());
        	}
        }
        
        int todayAccountNum = 0;
        int todayOrderNum = 0;
        BigDecimal todeyTradeMoney = new BigDecimal(0);
        BigDecimal todeyPerAveMoney = new BigDecimal(0);
        
        /**********************昨天***************************/
        BigDecimal ydaySumTradeMoney = new BigDecimal(0);
        BigDecimal ydayDiscountSumTradeMoney = new BigDecimal(0);
        BigDecimal ydayRealSumTradeMoney = new BigDecimal(0);
        BigDecimal ydayPerAveMoney = new BigDecimal(0);
        int ydayOrderNum = 0;
        
        /**********************最近7天***************************/
        BigDecimal lsdaySumTradeMoney = new BigDecimal(0);
        BigDecimal lsdayDiscountSumTradeMoney = new BigDecimal(0);
        BigDecimal lsdayRealSumTradeMoney = new BigDecimal(0);
        BigDecimal lsdayPerAveMoney = new BigDecimal(0);
        int lsdayOrderNum = 0;
        
        /**********************最近30天***************************/
        BigDecimal ltdaySumTradeMoney = new BigDecimal(0);
        BigDecimal ltdayDiscountSumTradeMoney = new BigDecimal(0);
        BigDecimal ltdayRealSumTradeMoney = new BigDecimal(0);
        BigDecimal ltdayPerAveMoney = new BigDecimal(0);
        int ltdayOrderNum = 0;
        
        /***************************时段分析************************************/
        
        BigDecimal ydComparedSumMoney = new BigDecimal(0);
    	BigDecimal ywComparedSumMoney = new BigDecimal(0);
    	BigDecimal ydComparedPerAveMoney = new BigDecimal(0);
    	BigDecimal ywComparedPerAveMoney = new BigDecimal(0);
    	BigDecimal ydComparedOrderCount = new BigDecimal(0);
    	BigDecimal ywComparedOrderCount = new BigDecimal(0);
    	
    	Long start = 0L;
    	Long end = 0L;
    	String formatStr = "yyyy-MM-dd";
    	String todayStr = DateUtil.formateDate2String(new Date(), formatStr);
    	start = DateUtil.formatTime2Long(DateUtil.addDateBeginStr(todayStr), "yyyy-MM-dd HH:mm:ss");
    	end = DateUtil.formatTime2Long(DateUtil.addDateEndStr(todayStr), "yyyy-MM-dd HH:mm:ss");
    	//今日登录人数
    	OrderInfoVO orderInfoVO1 = new OrderInfoVO();
    	FinanceUtil.copyOrderBeanProperties(orderInfo, orderInfoVO1);
    	orderInfoVO1.setStartTime(start);
    	orderInfoVO1.setEndTime(end);
    	todayAccountNum = merchantFinanceService.getOrderCount(orderInfoVO1);
    	
    	//今日交易金额
    	todeyTradeMoney = merchantFinanceService.getOrderSumInCome(orderInfoVO1);
    	
    	//今日交易笔数
    	todayOrderNum = merchantFinanceService.getOrderCount(orderInfoVO1);
    	
    	//今日平均客单价
    	todeyPerAveMoney = merchantFinanceService.getPerAveOrderMoney(orderInfoVO1);
        
    	/***************************昨日************************************/
    	//交易总金额
    	OrderInfoVO orderInfoVO2 = new OrderInfoVO();
    	FinanceUtil.copyOrderBeanProperties(orderInfo, orderInfoVO2);
    	ydaySumTradeMoney = merchantFinanceService.getOrderSumInCome(orderInfoVO2);
    	
    	//交易总笔数
    	ydayOrderNum = merchantFinanceService.getOrderCount(orderInfoVO2);
    	
    	orderInfoVO2.setOrderType("1");
    	//优惠总金额
    	ydayDiscountSumTradeMoney = merchantFinanceService.getOrderSumDiscountTradeMoney(orderInfoVO2);
        
        //实际交易金额
    	ydayRealSumTradeMoney = merchantFinanceService.getOrderRealSumTradeMoney(orderInfoVO2);
        
        //交易客单价
    	ydayPerAveMoney = merchantFinanceService.getPerAveOrderMoney(orderInfoVO2);
    	
    	/***************************最近7天************************************/
    	//交易总金额
    	OrderInfoVO orderInfoVO3 = new OrderInfoVO();
    	FinanceUtil.copyOrderBeanProperties(orderInfo, orderInfoVO3);
    	ltdaySumTradeMoney = merchantFinanceService.getOrderSumInCome(orderInfoVO3);
    	
    	//交易总笔数
    	ltdayOrderNum = merchantFinanceService.getOrderCount(orderInfoVO3);
    	
    	orderInfoVO3.setOrderType("1");
    	//优惠总金额
    	ltdayDiscountSumTradeMoney = merchantFinanceService.getOrderSumDiscountTradeMoney(orderInfoVO3);
        
        //实际交易金额
    	ltdayRealSumTradeMoney = merchantFinanceService.getOrderRealSumTradeMoney(orderInfoVO3);
        
        //交易客单价
    	ltdayPerAveMoney = merchantFinanceService.getPerAveOrderMoney(orderInfoVO3);
    
    	/***************************最近30天************************************/
    	//交易总金额
    	OrderInfoVO orderInfoVO4 = new OrderInfoVO();
    	FinanceUtil.copyOrderBeanProperties(orderInfo, orderInfoVO4);
    	ltdaySumTradeMoney = merchantFinanceService.getOrderSumInCome(orderInfoVO4);
    	
    	//交易总笔数
    	ltdayOrderNum = merchantFinanceService.getOrderCount(orderInfoVO4);
    	
    	orderInfoVO4.setOrderType("1");
    	//优惠总金额
    	ltdayDiscountSumTradeMoney = merchantFinanceService.getOrderSumDiscountTradeMoney(orderInfoVO4);
        
        //实际交易金额
    	ltdayRealSumTradeMoney = merchantFinanceService.getOrderRealSumTradeMoney(orderInfoVO4);
        
        //交易客单价
    	ltdayPerAveMoney = merchantFinanceService.getPerAveOrderMoney(orderInfoVO4);
    	
    	/***************************时段分析************************************/
    	OrderInfoVO orderInfoVO20 = new OrderInfoVO();
    	ydComparedSumMoney = merchantFinanceService.getComparedMoneyProportion(orderInfo);
    	
    	OrderInfoVO orderInfoVO21 = new OrderInfoVO();
    	ywComparedSumMoney = merchantFinanceService.getComparedMoneyProportion(orderInfo);
    	
    	OrderInfoVO orderInfoVO22 = new OrderInfoVO();
    	ydComparedPerAveMoney = merchantFinanceService.getComparedPerPriceProportion(orderInfo);
    	
    	OrderInfoVO orderInfoVO23 = new OrderInfoVO();
    	ywComparedPerAveMoney = merchantFinanceService.getComparedPerPriceProportion(orderInfo);
    	
    	OrderInfoVO orderInfoVO24 = new OrderInfoVO();
    	ydComparedOrderCount = merchantFinanceService.getComparedOrderCountProportion(orderInfo);
    	
    	OrderInfoVO orderInfoVO25 = new OrderInfoVO();
    	ywComparedOrderCount = merchantFinanceService.getComparedOrderCountProportion(orderInfo);
    	
    	//OrderInfoVO orderInfoVO25 = new OrderInfoVO();
    	List list = merchantFinanceService.getGraphData();
    	
        
        
        
      
        
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
