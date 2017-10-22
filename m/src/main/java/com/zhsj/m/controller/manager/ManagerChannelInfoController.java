package com.zhsj.m.controller.manager;

import com.zhsj.m.model.ChannelInfo;
import com.zhsj.m.service.ChannelInfoService;
import com.zhsj.m.util.enums.ResourceTypeEnum;
import com.zhsj.m.util.enums.SystemIdEnum;
import com.zhsj.m.util.json.JsonUtils;
import com.zhsj.m.vo.MenuVO;
import com.zhsj.m.vo.Particular;
import com.zhsj.m.vo.tree.ExtTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by taoxiangshan on 17/10/13.
 */
@Controller
@RequestMapping("/manager/channelInfo")
public class ManagerChannelInfoController {
    @Autowired
    private ChannelInfoService channelInfoService;

    /**
     * 获取菜单树
     *
     * @return
     */
    @RequestMapping("/getParentChannelList")
    @ResponseBody
    public List<ChannelInfo> getParentChannelList(HttpServletRequest request) {
        //获取登录用户信息

        return channelInfoService.getParentChannelListBySystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode());
    }
    /**
     * 获取菜单树
     *
     * @return
     */
    @RequestMapping("/loadMenu")
    @ResponseBody
    public String loadMenu(HttpServletRequest request) {
        List<MenuVO>menuList=new ArrayList<>();

        //获取登录用户信息
        List<ChannelInfo>parentList=channelInfoService.getParentChannelListBySystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode());
        if (parentList!=null&&parentList.size()>0){
            for (ChannelInfo channelInfo:parentList){
               MenuVO menuVO=new MenuVO();
               menuVO.setTitle(channelInfo.getChannelName());
               List<Particular>particulars=new ArrayList<>();
               List<ChannelInfo>sonList=channelInfoService.getSonChannelListBySystemIdAndParentId(SystemIdEnum.MERCHANT_PLATFORM.getCode(),channelInfo.getId());
               if (sonList!=null&&sonList.size()>0){
                   for (ChannelInfo son:sonList){
                       Particular particular=new Particular();
                       particular.setSontile(son.getChannelName());
                       particular.setSonurl(son.getUrl());
                       particulars.add(particular);
                   }
                   menuVO.setParticulars(particulars);
               }
                menuList.add(menuVO);
            }
        }
        String jsonStr=JsonUtils.toJSON(menuList);
        return jsonStr;
    }

    /**
     * 获取菜单树
     *
     * @return
     */
    @RequestMapping("/getChannelTree")
    @ResponseBody
    public List<ExtTreeNode> getChannelTree(HttpServletRequest request) {
        return channelInfoService.getTree(request.getContextPath(), null,  ResourceTypeEnum.ALL, false);
    }

    /**
     * 获取资源树 带checkbox
     *
     * @return
     */
    @RequestMapping("/getChannelTreeWithRoleId")
    @ResponseBody
    public List<ExtTreeNode> getChannelTreeWithRoleId(HttpServletRequest request, Integer roleId) {
        return channelInfoService.getTreeWithRoleId(request.getContextPath(), roleId, ResourceTypeEnum.ALL, true);
    }

}
