package com.zhsj.m.controller.merchant;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.model.OrderInfo;
import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.service.MerchantFinanceService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.DateUtil;
import com.zhsj.m.util.FinanceUtil;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.CheckOrderDetailVO;
import com.zhsj.m.vo.CheckOrderVO;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.MerchantInfoVO;
import com.zhsj.m.vo.OrderInfoVO;

@Controller
@RequestMapping("/merchant/finance")
public class MerchantFinanceContoller {
	
	@Autowired
	private MerchantFinanceService merchantFinanceService;
	
	@Autowired
	private MerchantAccountService merchantAccountService;
	
	@Autowired
	private ShopService shopService;
	
    @RequestMapping(value = "/orderCenter",method= {RequestMethod.GET,RequestMethod.POST})
    public String orderCenter(OrderInfoVO orderInfo,HttpServletRequest req,Model model) throws SQLException {
    	String startTime = req.getParameter("startTimeStr");
    	String endTime = req.getParameter("endTimeStr");
    	if(startTime != null && !startTime.equals("")){
    		Long startTimeNumber = DateUtil.formatTime2Long(startTime+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    		orderInfo.setStartTime(startTimeNumber);
    	}
        if(endTime != null && !endTime.equals("")){
        	Long endTimeNumber = DateUtil.formatTime2Long(endTime+" 23:59:59", "yyyy-MM-dd  HH:mm:ss");
        	orderInfo.setEndTime(endTimeNumber);
    	}
    	Integer pageNo = orderInfo.getPageNo()==null?0:orderInfo.getPageNo();
    	String userInfoJson = CookieUtils.readCookie(req, Constants.properties.getString(Constants.SECURITY_KEY), Constants.MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO account = merchantAccountService.getByAccount(uInfo.getUserName());
        
        int orderNum = 0;
        BigDecimal merchantIncome = new BigDecimal(0);
        BigDecimal merchantNetIncome = new BigDecimal(0);
        List<OrderInfoVO> orderInfoList = new ArrayList<OrderInfoVO>();
        PageBean page = new PageBean();
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
        	}else if(account.getAccountType() == 2){//门店
        		orderInfo.setAuth(2);
        		MerchantInfoVO store = shopService.getById(uInfo.getForeignId());
        		orderInfo.setStoreCode(store.getMchCode());
        	}
        }
        //订单数量
		orderNum = merchantFinanceService.getOrderCount(orderInfo);
		//获取订单收入
    	merchantIncome = merchantFinanceService.getOrderSumInCome(orderInfo);
    	//获取订单净收入
    	merchantNetIncome = merchantFinanceService.getOrderSumNetInCome(orderInfo);
        //获取订单信息
    	Integer totalCount = merchantFinanceService.getOrderCount(orderInfo);
    	page.setTotalCount(totalCount);
        page.setPageNo(orderInfo.getPageNo()==null?1:orderInfo.getPageNo());
        Integer startNum = page.getStartNum();
        orderInfo.setPageSize(page.getPageSize());
        orderInfo.setStartNum((page.getPageNo()-1)*page.getPageSize());
    	orderInfoList = merchantFinanceService.getOrderList(orderInfo);
    	page.setList(orderInfoList);
       
        model.addAttribute("pageBean", page);
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        return "/merchantPages/finance/orderCenter";
    }
	
	
	@RequestMapping(value = "/createExcelForOrder",method= {RequestMethod.GET,RequestMethod.POST})
    public String createExcelForOrder(OrderInfoVO orderInfo,HttpServletRequest req,HttpServletResponse resp,Model model) throws SQLException {
	       // 第一步，创建一个webbook，对应一个Excel文件    
        HSSFWorkbook wb = new HSSFWorkbook();    
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
        HSSFSheet sheet = wb.createSheet("学生表一");    
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
        HSSFRow row = sheet.createRow((int) 0);    
        // 第四步，创建单元格，并设置值表头 设置表头居中    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式    
    
        HSSFCell cell = row.createCell((short) 0);    
        cell.setCellValue("学号");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 1);    
        cell.setCellValue("姓名");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 2);    
        cell.setCellValue("年龄");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 3);    
        cell.setCellValue("生日");    
        cell.setCellStyle(style);    
        
        String startTime = req.getParameter("startTimeStr");
    	String endTime = req.getParameter("endTimeStr");
    	if(startTime != null && !startTime.equals("")){
    		Long startTimeNumber = DateUtil.formatTime2Long(startTime+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    		orderInfo.setStartTime(startTimeNumber);
    	}
        if(endTime != null && !endTime.equals("")){
        	Long endTimeNumber = DateUtil.formatTime2Long(endTime+" 23:59:59", "yyyy-MM-dd  HH:mm:ss");
        	orderInfo.setEndTime(endTimeNumber);
    	}
    	Integer pageNo = orderInfo.getPageNo()==null?0:orderInfo.getPageNo();
    	String userInfoJson = CookieUtils.readCookie(req, Constants.properties.getString(Constants.SECURITY_KEY), Constants.MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO account = merchantAccountService.getByAccount(uInfo.getUserName());
        List<OrderInfoVO> orderInfoList = new ArrayList<OrderInfoVO>();
        PageBean page = new PageBean();
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
        	}else if(account.getAccountType() == 2){//门店
        		orderInfo.setAuth(2);
        		MerchantInfoVO store = shopService.getById(uInfo.getForeignId());
        		orderInfo.setStoreCode(store.getMchCode());
        	}
        }
    
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，    
        List<OrderInfoVO> list = merchantFinanceService.getOrderListForExcel(orderInfo); 
          
        for (int i = 0; i < list.size(); i++)    
        {    
            row = sheet.createRow((int) i + 1);    
            OrderInfoVO order = (OrderInfoVO) list.get(i);    
            // 第四步，创建单元格，并设置值    
            row.createCell((short) 0).setCellValue(order.getOrderId());    
            row.createCell((short) 1).setCellValue(order.getOrderId());    
            row.createCell((short) 2).setCellValue(order.getOrderId());    
            /*
            cell = row.createCell((short) 3);    
            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu    
                    .getBirth()));  
                    */  
        }    
        // 第六步，将文件存到指定位置    
        OutputStream out = null;    
        try {        
            out = resp.getOutputStream();    
            String fileName = "订单信息表.xls";// 文件名    
            resp.setContentType("application/x-msdownload");    
            resp.setHeader("Content-Disposition", "attachment; filename="    
                                       + URLEncoder.encode(fileName, "UTF-8"));    
            wb.write(out);    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {      
            try {       
                out.close();      
            } catch (IOException e) {      
                e.printStackTrace();    
            }      
        }     
    
        return null;
    }

	@RequestMapping(value = "/checkCenter",method= {RequestMethod.GET,RequestMethod.POST})
    public String checkCenter(OrderInfoVO orderInfo,HttpServletRequest req,Model model) throws SQLException {
		String startTime = req.getParameter("startTimeStr");
    	String endTime = req.getParameter("endTimeStr");
    	if(startTime != null && !startTime.equals("")){
    		Long startTimeNumber = DateUtil.formatTime2Long(startTime+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    		orderInfo.setStartTime(startTimeNumber);
    	}
        if(endTime != null && !endTime.equals("")){
        	Long endTimeNumber = DateUtil.formatTime2Long(endTime+" 23:59:59", "yyyy-MM-dd  HH:mm:ss");
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
	       	}else if(account.getAccountType() == 2){//门店
	       		orderInfo.setAuth(2);
	       		MerchantInfoVO store = shopService.getById(uInfo.getForeignId());
	       		orderInfo.setStoreCode(store.getMchCode());
	       	}
        }
        List<CheckOrderVO> list =  merchantFinanceService.getCheckOrderList(orderInfo);
        PageBean pageBean = new PageBean();
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        return "/merchantPages/finance/checkCenter";
    }
	
	
	@RequestMapping(value = "/createExcelForCheckOrder",method= {RequestMethod.GET,RequestMethod.POST})
    public String createExcelForCheckOrder(OrderInfoVO orderInfo,HttpServletRequest req,HttpServletResponse resp,Model model) throws SQLException {
	       // 第一步，创建一个webbook，对应一个Excel文件    
        HSSFWorkbook wb = new HSSFWorkbook();    
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
        HSSFSheet sheet = wb.createSheet("学生表一");    
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short    
        HSSFRow row = sheet.createRow((int) 0);    
        // 第四步，创建单元格，并设置值表头 设置表头居中    
        HSSFCellStyle style = wb.createCellStyle();    
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式    
    
        HSSFCell cell = row.createCell((short) 0);    
        cell.setCellValue("学号");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 1);    
        cell.setCellValue("姓名");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 2);    
        cell.setCellValue("年龄");    
        cell.setCellStyle(style);    
        cell = row.createCell((short) 3);    
        cell.setCellValue("生日");    
        cell.setCellStyle(style);    
        
        String startTime = req.getParameter("startTimeStr");
    	String endTime = req.getParameter("endTimeStr");
    	if(startTime != null && !startTime.equals("")){
    		Long startTimeNumber = DateUtil.formatTime2Long(startTime+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    		orderInfo.setStartTime(startTimeNumber);
    	}
        if(endTime != null && !endTime.equals("")){
        	Long endTimeNumber = DateUtil.formatTime2Long(endTime+" 23:59:59", "yyyy-MM-dd  HH:mm:ss");
        	orderInfo.setEndTime(endTimeNumber);
    	}
    	Integer pageNo = orderInfo.getPageNo()==null?0:orderInfo.getPageNo();
    	String userInfoJson = CookieUtils.readCookie(req, Constants.properties.getString(Constants.SECURITY_KEY), Constants.MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO account = merchantAccountService.getByAccount(uInfo.getUserName());
        List<OrderInfoVO> orderInfoList = new ArrayList<OrderInfoVO>();
        PageBean page = new PageBean();
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
        	}else if(account.getAccountType() == 2){//门店
        		orderInfo.setAuth(2);
        		MerchantInfoVO store = shopService.getById(uInfo.getForeignId());
        		orderInfo.setStoreCode(store.getMchCode());
        	}
        }
    
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，    
        List<OrderInfoVO> list = merchantFinanceService.getOrderListForExcel(orderInfo); 
          
        for (int i = 0; i < list.size(); i++)    
        {    
            row = sheet.createRow((int) i + 1);    
            OrderInfoVO order = (OrderInfoVO) list.get(i);    
            // 第四步，创建单元格，并设置值    
            row.createCell((short) 0).setCellValue(order.getOrderId());    
            row.createCell((short) 1).setCellValue(order.getOrderId());    
            row.createCell((short) 2).setCellValue(order.getOrderId());    
            /*
            cell = row.createCell((short) 3);    
            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu    
                    .getBirth()));  
                    */  
        }    
        // 第六步，将文件存到指定位置    
        OutputStream out = null;    
        try {        
            out = resp.getOutputStream();    
            String fileName = "订单信息表.xls";// 文件名    
            resp.setContentType("application/x-msdownload");    
            resp.setHeader("Content-Disposition", "attachment; filename="    
                                       + URLEncoder.encode(fileName, "UTF-8"));    
            wb.write(out);    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {      
            try {       
                out.close();      
            } catch (IOException e) {      
                e.printStackTrace();    
            }      
        }     
    
        return null;
    }
	
	
	@RequestMapping(value = "/checkDetail",method= {RequestMethod.GET,RequestMethod.POST})
    public String checkDetail(OrderInfoVO orderInfo,HttpServletRequest req,Model model) throws SQLException {
		String startTime = req.getParameter("startTimeStr");
    	String endTime = req.getParameter("endTimeStr");
    	if(startTime != null && !startTime.equals("")){
    		Long startTimeNumber = DateUtil.formatTime2Long(startTime+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
    		orderInfo.setStartTime(startTimeNumber);
    	}
        if(endTime != null && !endTime.equals("")){
        	Long endTimeNumber = DateUtil.formatTime2Long(endTime+" 23:59:59", "yyyy-MM-dd  HH:mm:ss");
        	orderInfo.setEndTime(endTimeNumber);
    	}
    	Integer pageNo = orderInfo.getPageNo()==null?0:orderInfo.getPageNo();
    	String userInfoJson = CookieUtils.readCookie(req, Constants.properties.getString(Constants.SECURITY_KEY), Constants.MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO account = merchantAccountService.getByAccount(uInfo.getUserName());
        PageBean pageBean = new PageBean();
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
	       	}else if(account.getAccountType() == 2){//门店
	       		orderInfo.setAuth(2);
	       		MerchantInfoVO store = shopService.getById(uInfo.getForeignId());
	       		orderInfo.setStoreCode(store.getMchCode());
	       	}
        }
        List<CheckOrderDetailVO> list =  merchantFinanceService.getCheckOrderDetailList(orderInfo);
		model.addAttribute("pageBean", pageBean);
        return "/merchantPages/finance/checkDetail";
    }
}
