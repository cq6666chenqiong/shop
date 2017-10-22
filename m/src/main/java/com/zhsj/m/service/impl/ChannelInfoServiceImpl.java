package com.zhsj.m.service.impl;

import com.zhsj.m.dao.ChannelInfoDao;
import com.zhsj.m.dao.RoleBindChannelDao;
import com.zhsj.m.model.ChannelInfo;
import com.zhsj.m.model.RoleBindChannel;
import com.zhsj.m.service.ChannelInfoService;
import com.zhsj.m.util.enums.ChannelTypeEnum;
import com.zhsj.m.util.enums.ResourceTypeEnum;
import com.zhsj.m.util.enums.SystemIdEnum;
import com.zhsj.m.vo.tree.ExtTreeNode;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by taoxiangshan on 17/10/14.
 */
@Service
public class ChannelInfoServiceImpl  implements ChannelInfoService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ChannelInfoServiceImpl.class);
    @Autowired
    private ChannelInfoDao channelInfoDao;
    @Autowired
    private RoleBindChannelDao roleBindChannelDao;
    @Override
    public List<ChannelInfo> getParentChannelListBySystemId(Integer systemId) {
        return channelInfoDao.getParentChannelListBySystemId(systemId);
    }

    @Override
    public List<ChannelInfo> getSonChannelListBySystemIdAndParentId(Integer systemId,Integer parentId) {
        return channelInfoDao.getSonChannelListBySystemIdAndParentId(systemId,parentId);
    }

    @Override
    public List<ExtTreeNode> getTreeWithRoleId(String contextPath, Integer roleId, ResourceTypeEnum resourceType, boolean isUsedCheckBox) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();
        try {
            Map<Integer, Object> channelCheckedMap = new HashMap<Integer, Object>();
            List<RoleBindChannel>roleBindChannels=roleBindChannelDao.queryWithRoleId(roleId);
            if (roleBindChannels!=null&&roleBindChannels.size()>0){
                for (RoleBindChannel roleBindChannel:roleBindChannels){
                    channelCheckedMap.put(roleBindChannel.getChannelId(),roleBindChannel);
                }
            }
            /*************************************二级菜单**************************************/
            List<ChannelInfo> menuList = channelInfoDao.getResourceChannelListBySystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode(), ChannelTypeEnum.MENU.getCode());
            //角色权限关联信息
            Map<Integer, Object> menuMap = new HashMap<Integer, Object>();
            Set menuSet=new HashSet();
            if (menuList!=null&&menuList.size()>0){
                for (ChannelInfo temp:menuList){
                    menuSet.add(temp.getParentId());
                }
            }
            Iterator<Integer> it = menuSet.iterator();
            while (it.hasNext()) {
                Integer parentId = it.next();
                List<ChannelInfo>childList=new ArrayList<>();
                for (ChannelInfo temp : menuList) {
                    if (temp.getParentId()==parentId){
                        childList.add(temp);
                    }
                }
                menuMap.put(parentId,childList);
            }
            /*************************************按钮**************************************/
            List<ChannelInfo> btnList = channelInfoDao.getResourceChannelListBySystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode(), ChannelTypeEnum.BUTTON.getCode());
            //角色权限关联信息
            Map<Integer, Object> btnMap = new HashMap<Integer, Object>();
            Set btnSet=new HashSet();
            if (btnList!=null&&btnList.size()>0){
                for (ChannelInfo temp:btnList){
                    btnSet.add(temp.getParentId());
                }
            }
            Iterator<Integer> it1 = btnSet.iterator();
            while (it1.hasNext()) {
                Integer parentId = it1.next();
                List<ChannelInfo>childList=new ArrayList<>();
                for (ChannelInfo temp : btnList) {
                    if (temp.getParentId()==parentId){
                        childList.add(temp);
                    }
                }
                btnMap.put(parentId,childList);
            }
            /*************************************按钮**************************************/
            //查询应用
            List<ChannelInfo> applicationList = channelInfoDao.getParentChannelListBySystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode());
            Map<String, ChannelInfo> applicationMap = new HashMap<String, ChannelInfo>();
            for (ChannelInfo application : applicationList) {
                ExtTreeNode pNode =new ExtTreeNode();
                pNode.setAppId(application.getId().toString());
                pNode.setType("一级菜单");
                pNode.setRemark(application.getDescription());
                pNode.setId(application.getId().toString());
                pNode.setText(application.getChannelName2());
                pNode.setParentId(application.getId().toString());
                List<ExtTreeNode>menuChildren=new ArrayList<>();
                List<ChannelInfo>mList= (List<ChannelInfo>) menuMap.get(application.getId());
                if (mList!=null&&mList.size()>0){
                    for (ChannelInfo menuChild:mList){
                        ExtTreeNode menuNode =new ExtTreeNode();
                        menuNode.setAppId(menuChild.getParentId().toString());
                        menuNode.setType("二级菜单");
                        menuNode.setRemark(menuChild.getDescription());
                        menuNode.setId(menuChild.getId().toString());
                        menuNode.setText(menuChild.getChannelName2());
                        menuNode.setParentId(menuChild.getParentId().toString());
                        if (channelCheckedMap.get(menuChild.getId())!=null){
                            menuNode.setChecked(true);
                        }else{
                            menuNode.setChecked(false);
                        }
                        List<ChannelInfo>bList= (List<ChannelInfo>) btnMap.get(menuChild.getId());
                        List<ExtTreeNode>btnChildren=new ArrayList<>();
                        if (bList!=null&&bList.size()>0) {
                            for (ChannelInfo btnChild : bList) {
                                ExtTreeNode btnNode =new ExtTreeNode();
                                btnNode.setAppId(btnChild.getParentId().toString());
                                btnNode.setType("操作按钮");
                                btnNode.setRemark(btnChild.getDescription());
                                btnNode.setId(btnChild.getId().toString());
                                btnNode.setText(btnChild.getChannelName2());
                                btnNode.setParentId(btnChild.getParentId().toString());
                                btnNode.setChildren(null);
                                btnNode.setLeaf(true);
                                if (channelCheckedMap.get(btnChild.getId())!=null){
                                    btnNode.setChecked(true);
                                }else{
                                    menuNode.setChecked(false);
                                }
                                btnChildren.add(btnNode);
                            }
                        }
                        if (btnChildren.size()>0){
                            menuNode.setChildren(btnChildren);
                            menuNode.setLeaf(false);
                        }else{
                            menuNode.setChildren(null);
                            menuNode.setLeaf(true);
                        }
                        menuChildren.add(menuNode);
                    }
                }
                if (menuChildren.size()>0){
                    pNode.setChildren(menuChildren);
                    pNode.setLeaf(false);
                }else{
                    pNode.setChildren(null);
                    pNode.setLeaf(true);
                }
                nodes.add(pNode);
            }


        } catch (Exception e) {
            logger.error("获取菜单树异常", e);
        }
        return nodes;
    }

    @Override
    public List<ExtTreeNode> getTree(String contextPath, String userId,  ResourceTypeEnum resourceType, boolean isAdministrator) {
        List<ExtTreeNode> nodes = new ArrayList<ExtTreeNode>();
        try {
            /*************************************二级菜单**************************************/
            List<ChannelInfo> menuList = channelInfoDao.getResourceChannelListBySystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode(), ChannelTypeEnum.MENU.getCode());
            //角色权限关联信息
            Map<Integer, Object> menuMap = new HashMap<Integer, Object>();
            Set menuSet=new HashSet();
            if (menuList!=null&&menuList.size()>0){
                for (ChannelInfo temp:menuList){
                    menuSet.add(temp.getParentId());
                }
            }
            Iterator<Integer> it = menuSet.iterator();
            while (it.hasNext()) {
                Integer parentId = it.next();
                List<ChannelInfo>childList=new ArrayList<>();
                for (ChannelInfo temp : menuList) {
                    if (temp.getParentId()==parentId){
                        childList.add(temp);
                    }
                }
                menuMap.put(parentId,childList);
            }
            /*************************************按钮**************************************/
            List<ChannelInfo> btnList = channelInfoDao.getResourceChannelListBySystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode(), ChannelTypeEnum.BUTTON.getCode());
            //角色权限关联信息
            Map<Integer, Object> btnMap = new HashMap<Integer, Object>();
            Set btnSet=new HashSet();
            if (btnList!=null&&btnList.size()>0){
                for (ChannelInfo temp:btnList){
                    btnSet.add(temp.getParentId());
                }
            }
            Iterator<Integer> it1 = btnSet.iterator();
            while (it1.hasNext()) {
                Integer parentId = it1.next();
                List<ChannelInfo>childList=new ArrayList<>();
                for (ChannelInfo temp : btnList) {
                    if (temp.getParentId()==parentId){
                        childList.add(temp);
                    }
                }
                btnMap.put(parentId,childList);
            }
            /*************************************按钮**************************************/
            //查询应用
                List<ChannelInfo> applicationList = channelInfoDao.getParentChannelListBySystemId(SystemIdEnum.MERCHANT_PLATFORM.getCode());
                Map<String, ChannelInfo> applicationMap = new HashMap<String, ChannelInfo>();
                for (ChannelInfo application : applicationList) {
                    ExtTreeNode pNode =new ExtTreeNode();
                    pNode.setAppId(application.getId().toString());
                    pNode.setType("一级菜单");
                    pNode.setRemark(application.getDescription());
                    pNode.setId(application.getId().toString());
                    pNode.setText(application.getChannelName2());
                    pNode.setParentId(application.getId().toString());
                    List<ExtTreeNode>menuChildren=new ArrayList<>();
                    List<ChannelInfo>mList= (List<ChannelInfo>) menuMap.get(application.getId());
                    if (mList!=null&&mList.size()>0){
                        for (ChannelInfo menuChild:mList){
                            ExtTreeNode menuNode =new ExtTreeNode();
                            menuNode.setAppId(menuChild.getParentId().toString());
                            menuNode.setType("二级菜单");
                            menuNode.setRemark(menuChild.getDescription());
                            menuNode.setId(menuChild.getId().toString());
                            menuNode.setText(menuChild.getChannelName2());
                            menuNode.setParentId(menuChild.getParentId().toString());
                            List<ChannelInfo>bList= (List<ChannelInfo>) btnMap.get(menuChild.getId());
                            List<ExtTreeNode>btnChildren=new ArrayList<>();
                            if (bList!=null&&bList.size()>0) {
                                for (ChannelInfo btnChild : bList) {
                                    ExtTreeNode btnNode =new ExtTreeNode();
                                    btnNode.setAppId(btnChild.getParentId().toString());
                                    btnNode.setType("操作按钮");
                                    btnNode.setRemark(btnChild.getDescription());
                                    btnNode.setId(btnChild.getId().toString());
                                    btnNode.setText(btnChild.getChannelName2());
                                    btnNode.setParentId(btnChild.getParentId().toString());
                                    btnNode.setChildren(null);
                                    btnNode.setLeaf(true);
                                    btnChildren.add(btnNode);
                                }
                            }
                            if (btnChildren.size()>0){
                                menuNode.setChildren(btnChildren);
                                menuNode.setLeaf(false);
                            }else{
                                menuNode.setChildren(null);
                                menuNode.setLeaf(true);
                            }
                            menuChildren.add(menuNode);
                        }
                    }
                    if (menuChildren.size()>0){
                        pNode.setChildren(menuChildren);
                        pNode.setLeaf(false);
                    }else{
                        pNode.setChildren(null);
                        pNode.setLeaf(true);
                    }
                    nodes.add(pNode);
                }


        } catch (Exception e) {
            logger.error("获取菜单树异常", e);
        }
        return nodes;
    }

}
