package com.zhsj.m.controller.manager;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhsj.m.model.OrderInfo;
import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.service.MerchantFinanceService;
import com.zhsj.m.service.MerchantHomeService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.OrderInfoVO;
import com.zhsj.m.vo.RoleInfoVO;

@Controller
@RequestMapping("/manager/finance")
public class ManagerFinanceContoller {
	
	 @Autowired
	    private MerchantAccountService merchantAccountService;
	    
	    @Autowired
		private MerchantFinanceService merchantFinanceService;

	    @Autowired
	    private MerchantHomeService merchantHomeService;
	
	@RequestMapping("/orderCenter")
    public String orderCenter(HttpServletRequest req,OrderInfoVO orderInfo,Model model) throws SQLException {
		PageBean page = new PageBean();
		String userInfoJson = CookieUtils.readCookie(req, Constants.properties.getString(Constants.SECURITY_KEY), Constants.MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO account = merchantAccountService.getByAccount(uInfo.getUserName());
        //OrderInfoVO info = new OrderInfoVO();
        //管理员
        if(account.getIsAdmin() == 1){
        	orderInfo.setAuth(1);
         }else{
        	if(account.getAccountType() == 1){//商户
        		orderInfo.setAuth(1);
        	}else if(account.getAccountType() == 2){//门店
        		orderInfo.setAuth(2);
      
        	}
        }

        page.setTotalCount(100090);
        page.setPageNo(3);
        page.setPageSize(15);
        model.addAttribute("pageBean", page);
        return "/managerPages/finance/orderCenter";
    }
	
	@RequestMapping("/checkCenter")
    public String checkCenter(Model model) {
		PageBean pageBean = new PageBean();
		pageBean.setPageNo(2);
		pageBean.setTotalCount(100);
		pageBean.setPageSize(5);
		model.addAttribute("pageBean", pageBean);
        return "/managerPages/finance/checkCenter";
    }
	
}
