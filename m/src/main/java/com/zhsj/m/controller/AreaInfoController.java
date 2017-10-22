package com.zhsj.m.controller;

import com.zhsj.m.model.AreaInfo;
import com.zhsj.m.model.ChannelInfo;
import com.zhsj.m.service.AreaService;
import com.zhsj.m.util.enums.SystemIdEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wuyongtao on 2017/10/17.
 */
@Controller
@RequestMapping("/merchant/areaInfo")
public class AreaInfoController {
    @Autowired
    private AreaService areaService;

    @RequestMapping("/getAreaList")
    @ResponseBody
    public List<AreaInfo> getParentChannelList(Integer parentId) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa"+parentId);
        //获取地区信息
        return areaService.getAreasByParentId(parentId);
    }
}
