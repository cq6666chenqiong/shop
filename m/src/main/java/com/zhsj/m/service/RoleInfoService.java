package com.zhsj.m.service;

import com.zhsj.m.model.ChannelInfo;
import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.RoleInfoVO;

import java.util.List;

/**
 * Created by taoxiangshan on 17/10/14.
 */
public interface RoleInfoService {
    /**
     * 通过组织ID或商家id获取角色列表
     * @param foreignId
     * @return
     */
    List<RoleInfo> getRolelListByForeignIdAndSystemId(Integer foreignId,Integer systemId);

    /**
     * 查询
     *
     * @param role
     * @return List<RoleInfoVO>
     */
    public List<RoleInfoVO> query(final RoleInfoVO role) throws Exception;

    /**
     * 查询记录数
     *
     * @param role
     * @return List<RoleInfoVO>
     */
    public Long queryCount(final RoleInfoVO role) throws Exception;

    public PageBean queryByPage(RoleInfoVO role);

    public RoleInfoVO getByName(String name);

    /**
     * 新增
     *
     * @param roleInfoVO
     * @return int
     */
    public int insert(final RoleInfoVO roleInfoVO) throws Exception;

    /**
     * 获取
     *
     * @param id
     * @return int
     */
    public RoleInfoVO getRoleInfoById(Integer id);

    /**
     * 新增
     *
     * @param roleInfoVO
     * @return int
     */
    public int update(final RoleInfoVO roleInfoVO) throws Exception;


    public List<RoleInfoVO>getRoleInfoListByMerchantAccountId(Integer merchantAccountId);

    /**
     * 通过组织ID或商家id和账户类型获取角色列表
     * @param foreignId
     * @return
     */
    List<RoleInfoVO> getRolelListByForeignIdAndRoleType(Integer foreignId,Integer roleType);

}
