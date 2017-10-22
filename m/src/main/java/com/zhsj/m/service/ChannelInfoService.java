package com.zhsj.m.service;

import com.zhsj.m.model.ChannelInfo;
import com.zhsj.m.util.enums.ResourceTypeEnum;
import com.zhsj.m.vo.tree.ExtTreeNode;

import java.util.List;

/**
 * Created by taoxiangshan on 17/10/14.
 */
public interface ChannelInfoService {
    List<ChannelInfo> getParentChannelListBySystemId(Integer systemId);
    List<ChannelInfo> getSonChannelListBySystemIdAndParentId(Integer systemId,Integer parentId);
    /**
     * 根据角色Id获取资源树
     *
     * @param contextPath
     * @param roleId
     * @param resourceType
     * @param isUsedCheckBox
     * @return
     */
    public List<ExtTreeNode> getTreeWithRoleId(final String contextPath, final Integer roleId, final ResourceTypeEnum resourceType, final boolean isUsedCheckBox);


    /**
     * 根据用户Id、appId获取资源树
     *
     * @param contextPath
     * @param userId
     * @param resourceType
     * @param isAdministrator
     * @return
     */
    public List<ExtTreeNode> getTree(final String contextPath,final  String userId,  final ResourceTypeEnum resourceType, final boolean isAdministrator);

}
