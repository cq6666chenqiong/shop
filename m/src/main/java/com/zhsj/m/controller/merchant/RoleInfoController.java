package com.zhsj.m.controller.merchant;

import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.service.RoleInfoService;
import com.zhsj.m.util.CookieUtils;
import com.zhsj.m.util.auth.Constants;
import com.zhsj.m.util.auth.UserInfo;
import com.zhsj.m.util.enums.SystemIdEnum;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.util.result.JsonResult;
import com.zhsj.m.vo.RoleInfoVO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by taoxiangshan on 17/10/15.
 */
@Controller
@RequestMapping("/merchant/roleInfo")
public class RoleInfoController implements Constants {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(RoleInfoController.class);
    @Autowired
    private RoleInfoService roleInfoService;
    @RequestMapping("/roleListForMechant")
    public String roleListForMechant(Model model) {
        List<RoleInfo> roleInfoList=roleInfoService.getRolelListByForeignIdAndSystemId(1, SystemIdEnum.MERCHANT_PLATFORM.getCode());
        model.addAttribute("roleList",roleInfoList);
        return "/merchantPages/system/roleListForMerchant";
    }

    @RequestMapping("/addRole")
    public String addRole(Model model) {
        return "/merchantPages/system/addRole";
    }
    /**
     * 新增记录
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public JsonResult save(HttpServletRequest request, RoleInfoVO role) throws Exception {
        JsonResult result = new JsonResult();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        try {
            //重复的角色不能被添加 ----Ronrey
            if(roleInfoService.getByName(role.getRoleName())!=null){
                result.setMessage("【"+role.getRoleName()+"】角色已存在,不能重复添加");
                result.setSuccess(false);
                return result;
            }
            //保存
            role.setSystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode());
            role.setForeignId(Integer.valueOf(uInfo.getUserId()));
            roleInfoService.insert(role);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error("提交数据异常", e);
            result.setMessage("提交数据异常");
            result.setSuccess(false);
        }
        return result;
    }


    /**
     * 查询列表页
     *
     * @param roleInfoVO
     * @return
     */
    @RequestMapping(value = "/list1")
    @ResponseBody
    public String list1(Model model,RoleInfoVO roleInfoVO) {
        JsonResult result = new JsonResult();
        try {
/*            if (role != null
                    && role.getRoleName() != null
                    && !"".equalsIgnoreCase(role.getRoleName())) {
                role.setRoleName(new String(role.getRoleName().getBytes("ISO-8859-1"), "UTF-8"));
            }*/
            // 设置结果集
            result.put("list", roleInfoService.query(roleInfoVO));
            result.put("rowCount", roleInfoService.queryCount(roleInfoVO));
            model.addAttribute("roleList",roleInfoService.query(roleInfoVO));
            model.addAttribute("rowCount",roleInfoService.queryCount(roleInfoVO));
        } catch (Exception e) {
            logger.error("查询异常", e);
            result.setMessage("查询异常");
            result.setSuccess(false);
        }
        return "/merchantPages/system/roleList";
    }
    /**
     * 活动列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/list",method= {RequestMethod.GET,RequestMethod.POST})
    public Object list(Model model,RoleInfoVO roleInfoVO, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        String userInfoJson = CookieUtils.readCookie(request, properties.getString(SECURITY_KEY), MERCHANT_USER_INFO);
        UserInfo uInfo = JsonUtils.fromJSON(userInfoJson, UserInfo.class);
        // pageNo判空
        if (roleInfoVO.getPageNo() == null) {
            roleInfoVO.setPageNo(1);
        }
        roleInfoVO.setSystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode());
        roleInfoVO.setForeignId(Integer.valueOf(uInfo.getUserId()));
        PageBean pageBean = (PageBean) this.roleInfoService.queryByPage(roleInfoVO);
        //model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageBean", pageBean);
        return "/merchantPages/system/roleList";
    }

    @RequestMapping("/editRole")
    public String editRole(Model model,Integer id) {
        RoleInfoVO roleInfoVO=roleInfoService.getRoleInfoById(id);
        model.addAttribute("roleInfo", roleInfoVO);
        return "/merchantPages/system/editRole";
    }

    /**
     * 更新记录
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonResult update(RoleInfoVO role) throws Exception {
        JsonResult result = new JsonResult();
        try {
            //更新记录
            roleInfoService.update(role);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error("更新数据异常", e);
            result.setMessage("更新数据异常");
            result.setSuccess(false);
        }
        return result;
    }
}
