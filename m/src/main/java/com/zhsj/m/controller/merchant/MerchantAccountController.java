package com.zhsj.m.controller.merchant;

import com.zhsj.m.model.MerchantInfo;
import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.service.RoleInfoService;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.PasswordUtil;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.enums.IsDeleteEnum;
import com.zhsj.m.util.enums.MerchantAccountTypeEnum;
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
import java.util.*;

/**
 * Created by taoxiangshan on 17/10/20.
 */
@Controller
@RequestMapping("/merchant/merchantAccount")
public class MerchantAccountController implements Constants{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MerchantAccountController.class);
    @Autowired
    private MerchantAccountService merchantAccountService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private RoleInfoService roleInfoService;
    @RequestMapping("/accountList")
    public String accountList(HttpServletRequest request,Model model,MerchantAccountVO merchantAccountVO) {
        if (merchantAccountVO.getPageNo() == null) {
            merchantAccountVO.setPageNo(1);
        }
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        merchantAccountVO.setForeignId(Integer.valueOf(uInfo.getUserId()));
        if (merchantAccountVO.getShopName()!=null&&!merchantAccountVO.getShopName().trim().equals("")){
            List<MerchantAccountBindShopVO> merchantAccountBindShopVOS = merchantAccountService.getMerchantAccountBindShopListByShopName(merchantAccountVO.getShopName());
            Set<Integer>shopIdSet=new HashSet<>();

            //StringBuffer sb=new StringBuffer("(");
            if (merchantAccountBindShopVOS != null && merchantAccountBindShopVOS.size() > 0) {
                for (int i=0;i<merchantAccountBindShopVOS.size();i++) {
                    MerchantAccountBindShopVO merchantAccountBindShopVO = merchantAccountBindShopVOS.get(i);
                    shopIdSet.add(merchantAccountBindShopVO.getShopId());
/*                    if (sb.toString().equals("(")){
                        sb.append(merchantAccountBindShopVO.getShopId());
                    }else{
                        sb.append(","+merchantAccountBindShopVO.getShopId());
                    }
                    if (i==merchantAccountBindShopVOS.size()-1){
                        sb.append(")");
                    }*/

                }
            }
            List<Integer> shopIdList =new ArrayList<Integer>(shopIdSet);
            merchantAccountVO.setShopIdList(shopIdList);
        }

        PageBean pageBean=merchantAccountService.queryByPage(merchantAccountVO);
        model.addAttribute("pageBean", pageBean);
        model.addAttribute("searchCondition",merchantAccountVO);
        return "merchantPages/system/accountList";
    }
    /**
     * 从cookie中读取用户信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getAccountFormCookie")
    @ResponseBody
    public JsonResult getAccountFormCookie(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        try {
            MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
            //查询记录
            result.setData(merchantAccount);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error("获取数据异常", e);
            result.setMessage("获取数据异常");
            result.setSuccess(false);
        }
        return result;
    }
    /**
     * 获取账户信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getMyAccountInfo")
    public String getMyAccountInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
        MerchantInfo merchantInfo=shopService.getById(merchantAccount.getForeignId());
        List<RoleInfoVO> roleInfoList=roleInfoService.getRoleInfoListByMerchantAccountId(merchantAccount.getForeignId());
        StringBuffer sb=new StringBuffer();
        if (roleInfoList!=null&&roleInfoList.size()>0){
            for (RoleInfoVO roleInfoVO:roleInfoList){
                sb.append(roleInfoVO.getRoleName()+",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        model.addAttribute("roleNames",sb.toString());
        model.addAttribute("merchantAccount",merchantAccount);
        model.addAttribute("merchantInfo",merchantInfo);
        return "/merchantPages/system/myAccountInfo";
    }
    /**
     * 去编辑账户信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toEditMyAccountInfo")
    public String toEditMyAccountInfo(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));

        return "/merchantPages/system/editMyAccountInfo";
    }
    /**
     * 去修改密码页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toUpdateMyPassword")
    public String toUpdateMyPassword(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));

        return "/merchantPages/system/updateMyPassword";
    }

    @RequestMapping(value="/checkPassword")
    @ResponseBody
    public JsonResult  checkPassword(HttpServletRequest request,String password){
        JsonResult result =new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        try {
            MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
            if (!merchantAccount.getPassword().equalsIgnoreCase(PasswordUtil.encodePassword(password))) {
                result.setSuccess(false);
            }else {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping(value="/checkAccountIsExists")
    @ResponseBody
    public JsonResult  checkAccountIsExists(HttpServletRequest request,Integer id,String account){
        JsonResult result =new JsonResult();
        try {
            MerchantAccountVO merchantAccount = merchantAccountService.getByAccount(account);
            if (merchantAccount!=null) {
                if (id!=null&&!id.equals("")){
                    if(merchantAccount.getId()!=id){
                        result.setSuccess(false);
                    }else{
                        result.setSuccess(true);
                    }
                }else{
                    result.setSuccess(false);
                }

            }else {
                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    /**
     * 更新账户信息
     * @return
     */
    @RequestMapping(value = "/updateMyPassword")
    @ResponseBody
    public JsonResult updateMyPassword(HttpServletRequest request,String password) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //读取验证码
                String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
                UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
                //MerchantAccountVO oldMerchantAccountVO=merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
                MerchantAccountVO merchantAccountVO = new MerchantAccountVO();
                merchantAccountVO.setId(Integer.valueOf(uInfo.getUserId()));
                merchantAccountVO.setPassword(PasswordUtil.encodePassword(password));
                //merchantAccountVO.setPassword(PasswordUtil.encodePassword(password));
                int count = merchantAccountService.update(merchantAccountVO);
                if (count > 0) {
                    result.setSuccess(true);
                } else {
                    result.setMessage("保存失败");
                    result.setSuccess(false);
                }

        } catch (Exception e) {
            logger.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }
    /**
     * 更新账户信息
     * @return
     */
    @RequestMapping(value = "/saveMyAccountInfo")
    @ResponseBody
    public JsonResult saveMyAccountInfo(HttpServletRequest request,String phone,String password,String imagecode) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //读取验证码
            String verifyCode = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), RAND_CODE);
            if(verifyCode!=null &&  imagecode !=null &&verifyCode.toUpperCase().equalsIgnoreCase(imagecode.toUpperCase())) {
                String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
                UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
                MerchantAccountVO oldMerchantAccountVO=merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
                //if (oldMerchantAccountVO.getPassword())
                if(oldMerchantAccountVO.getPassword().equalsIgnoreCase(PasswordUtil.encodePassword(password))) {
                    MerchantAccountVO merchantAccountVO = new MerchantAccountVO();
                    merchantAccountVO.setId(Integer.valueOf(uInfo.getUserId()));
                    merchantAccountVO.setPhone(phone);
                    //merchantAccountVO.setPassword(PasswordUtil.encodePassword(password));
                    int count = merchantAccountService.update(merchantAccountVO);
                    if (count > 0) {
                        result.setSuccess(true);
                    } else {
                        result.setMessage("保存失败");
                        result.setSuccess(false);
                    }
                }else{
                    result.setSuccess(false);
                    result.setMessage("登陆密码错误！");
                }
            }else{
                result.setSuccess(false);
                result.setMessage("验证码错误");
            }
        } catch (Exception e) {
            logger.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 更新账户状态
     *
     * @param merchantAccountId,status
     * @return
     */
    @RequestMapping(value = "/setMerchantAccountStatus")
    @ResponseBody
    public JsonResult setMerchantAccountStatus(HttpServletRequest request, Integer merchantAccountId,Integer status) throws Exception {
        JsonResult result = new JsonResult();
        try {
            MerchantAccountVO merchantAccountVO=new MerchantAccountVO();
            merchantAccountVO.setId(merchantAccountId);
            merchantAccountVO.setStatus(status);
            merchantAccountService.update(merchantAccountVO);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error("提交数据异常", e);
            result.setMessage("提交数据异常");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResult delete(Integer id,HttpServletRequest request) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantAccountVO merchantAccount = merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
        try {
            //删除记录
            MerchantAccountVO upMerchantAccount=new MerchantAccountVO();
            upMerchantAccount.setIsDelete(IsDeleteEnum.DELETE.getCode());
            upMerchantAccount.setId(id);
            int count=merchantAccountService.update(upMerchantAccount);
            if (count>0) {
                result.setSuccess(true);
            }else{
                result.setMessage("删除数据失败");
                result.setSuccess(false);
            }
        } catch (Exception e) {
            logger.error("删除数据异常", e);
            result.setMessage("删除数据异常");
            result.setSuccess(false);
        }
        return result;
    }
    /**
     * 去新增账户信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toAddAccount")
    public String toAddAccount(Model model, HttpServletRequest request, HttpServletResponse response,Integer type) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        MerchantInfoVO merchantInfoVO = shopService.getById(Integer.valueOf(uInfo.getForeignId()));
        List<RoleInfoVO>roleList=roleInfoService.getRolelListByForeignIdAndRoleType(merchantInfoVO.getId(),type);
        List<MerchantInfoVO>shopList=shopService.getAllShopListByParentCode(merchantInfoVO.getMchCode());
        model.addAttribute("type",type);
        model.addAttribute("roleList",roleList);
        model.addAttribute("shopList",shopList);
        if (type== MerchantAccountTypeEnum.MERCHANT_ACCOUNT.getCode()) {
            return "merchantPages/system/addMerchantAccount";
        }else{
            return "merchantPages/system/addShopAccount";
        }
    }

    /**
     * 新增保存账户信息
     * @return
     */
    @RequestMapping(value = "/saveAccount")
    @ResponseBody
    public JsonResult saveAccount(HttpServletRequest request,MerchantAccountVO merchantAccountVO) throws Exception {
        JsonResult result = new JsonResult();
        try {
            String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
            UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
            MerchantAccountVO nowMerchantAccountVO=merchantAccountService.getById(Integer.valueOf(uInfo.getUserId()));
            merchantAccountVO.setForeignId(nowMerchantAccountVO.getForeignId());
            int count = merchantAccountService.insert(merchantAccountVO);
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

    /**
     * 去编辑账户信息页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toEditAccount")
    public String toEditAccount(Model model, HttpServletRequest request, HttpServletResponse response,Integer id,Integer type) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        List<MerchantAccountBindRoleVO>merchantAccountBindRoleVOS=merchantAccountService.getMerchantAccountBindRoleListByAccountId(id);
        Map<Integer,Object>bindRoleMap=new HashMap<>();
        if (merchantAccountBindRoleVOS!=null&&merchantAccountBindRoleVOS.size()>0){
            for (MerchantAccountBindRoleVO merchantAccountBindRoleVO:merchantAccountBindRoleVOS){
                bindRoleMap.put(merchantAccountBindRoleVO.getRoleId(),merchantAccountBindRoleVO);
            }
        }
        List<MerchantAccountBindShopVO>merchantAccountBindShopVOS=merchantAccountService.getMerchantAccountBindShopListByAccountId(id);
        Map<Integer,Object>bindShopMap=new HashMap<>();
        if (merchantAccountBindShopVOS!=null&&merchantAccountBindShopVOS.size()>0){
            for (MerchantAccountBindShopVO merchantAccountBindShopVO:merchantAccountBindShopVOS){
                bindShopMap.put(merchantAccountBindShopVO.getShopId(),merchantAccountBindShopVO);
            }
        }

        MerchantInfoVO merchantInfoVO = shopService.getById(Integer.valueOf(uInfo.getForeignId()));
        List<RoleInfoVO>roleList=roleInfoService.getRolelListByForeignIdAndRoleType(merchantInfoVO.getId(),type);
        List<MerchantInfoVO>shopList=shopService.getAllShopListByParentCode(merchantInfoVO.getMchCode());

        if (roleList!=null&&roleList.size()>0){
            for (RoleInfoVO roleInfo:roleList){
              if (bindRoleMap.get(roleInfo.getId())!=null){
                  roleInfo.setIsChecked(1);
              }else{
                  roleInfo.setIsChecked(0);
              }
            }
        }
        StringBuffer sb=new StringBuffer();
        Integer selectedCount=0;
        if (shopList!=null&&shopList.size()>0){
            for (MerchantInfoVO temp:shopList){
                if (bindShopMap.get(temp.getId())!=null){
                    selectedCount++;
                    temp.setIsChecked(1);
                    if (sb.toString().equals("")){
                        sb.append(temp.getId());
                    }else{
                        sb.append(","+temp.getId());
                    }
                }else{
                    temp.setIsChecked(0);
                }
            }
        }
        MerchantAccountVO merchantAccountVO=merchantAccountService.getById(id);
        model.addAttribute("selectedCount",selectedCount);
        model.addAttribute("shopIds",sb.toString());
        model.addAttribute("merchantAcount",merchantAccountVO);
        model.addAttribute("type",type);
        model.addAttribute("roleList",roleList);
        model.addAttribute("shopList",shopList);
        if (type== MerchantAccountTypeEnum.MERCHANT_ACCOUNT.getCode()) {
            return "merchantPages/system/editMerchantAccount";
        }else{
            return "merchantPages/system/editShopAccount";
        }
    }
    /**
     * 修改账户信息
     * @return
     */
    @RequestMapping(value = "/updateAccount")
    @ResponseBody
    public JsonResult updateAccount(HttpServletRequest request,MerchantAccountVO merchantAccountVO) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
            //UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
            int count = merchantAccountService.update(merchantAccountVO);
            if (count > 0) {
                result.setSuccess(true);
            } else {
                result.setMessage("保存失败");
                result.setSuccess(false);
            }
        } catch (Exception e) {
            logger.error("修改数据异常", e);
            result.setMessage("修改数据异常");
            result.setSuccess(false);
        }
        return result;
    }
}
