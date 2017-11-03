package com.zhsj.m.service.impl;

import com.zhsj.m.dao.RoleBindChannelDao;
import com.zhsj.m.dao.RoleInfoDao;
import com.zhsj.m.model.RoleBindChannel;
import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.service.RoleInfoService;
import com.zhsj.m.service.convert.impl.RoleInfoConvert;
import com.zhsj.m.util.enums.IsDeleteEnum;
import com.zhsj.m.util.enums.StatusEnum;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by taoxiangshan on 17/10/15.
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    private RoleInfoDao roleInfoDao;
    @Autowired
    private RoleBindChannelDao roleBindChannelDao;
    private RoleInfoConvert roleInfoConvert = new RoleInfoConvert();
    @Override
    public List<RoleInfo> getRolelListByForeignIdAndSystemId(Integer foreignId,Integer systemId) {
        return roleInfoDao.getRolelListByForeignIdAndSystemId(foreignId,systemId);
    }

    @Override
    public List<RoleInfoVO> query(RoleInfoVO roleInfoVO) throws Exception {
        List<RoleInfoVO> returnValue = new ArrayList<RoleInfoVO>();
        List<RoleInfo> roleList = roleInfoDao.query(roleInfoConvert.toPO(roleInfoVO));
        for (RoleInfo temp : roleList) {
            returnValue.add(roleInfoConvert.toVO(temp));
        }
        return returnValue;
    }

    @Override
    public Long queryCount(RoleInfoVO roleInfoVO) throws Exception {
        return roleInfoDao.queryCount(roleInfoConvert.toPO(roleInfoVO));
    }

    @Override
    public PageBean queryByPage(RoleInfoVO roleInfoVO) {
        Integer totalCount = roleInfoDao.queryCount(roleInfoConvert.toPO(roleInfoVO)).intValue();
        PageBean page = new PageBean();
        page.setTotalCount(totalCount);
        page.setPageNo(roleInfoVO.getPageNo());
        Integer startNum = page.getStartNum();
        roleInfoVO.setPageSize(page.getPageSize());
        roleInfoVO.setStartNum(page.getStartNum());
        List<RoleInfoVO> resultList = new ArrayList<RoleInfoVO>();
        List<RoleInfo> roleList = roleInfoDao.query(roleInfoConvert.toPO(roleInfoVO));
        for (RoleInfo temp : roleList) {
            resultList.add(roleInfoConvert.toVO(temp));
        }
        page.setList(resultList);
        return page;
    }


    @Override
    public RoleInfoVO getByName(String name) {
        RoleInfo po = roleInfoDao.getByName(name);
        return roleInfoConvert.toVO(po);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(RoleInfoVO roleInfoVO) throws Exception {
        Date date = new Date();
        //保存角色记录
        roleInfoVO.setCreateTime(date);
        roleInfoVO.setUpdateTime(date);
        roleInfoVO.setStatus(StatusEnum.NORMAL.getCode());
        roleInfoVO.setIsDelete(IsDeleteEnum.UN_DELETE.getCode());
        RoleInfo  roleInfo = roleInfoConvert.toPO(roleInfoVO);
        int rowCount = roleInfoDao.insert(roleInfo);
        //保存角色权限记录
        if (!StringUtils.isEmpty(roleInfoVO.getResourceIds())) {
            String[] resourcesIds = roleInfoVO.getResourceIds().split(",");
            for (String resourceId : resourcesIds) {
                RoleBindChannel roleBindChannel = new RoleBindChannel();
                roleBindChannel.setChannelId(Integer.valueOf(resourceId));
                roleBindChannel.setCreateTime(new Date());
                roleBindChannel.setIsDelete(IsDeleteEnum.UN_DELETE.getCode());
                roleBindChannel.setRoleId(roleInfo.getId());
                roleBindChannel.setStatus(StatusEnum.NORMAL.getCode());
                roleBindChannelDao.insert(roleBindChannel);
            }
        }
        return rowCount;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(RoleInfoVO roleInfoVO) throws Exception {
        roleBindChannelDao.deleteByPrimaryKey(roleInfoVO.getId());
        //保存角色权限记录
        if (!StringUtils.isEmpty(roleInfoVO.getResourceIds())) {
            String[] resourcesIds = roleInfoVO.getResourceIds().split(",");
            for (String resourceId : resourcesIds) {
                RoleBindChannel roleBindChannel = new RoleBindChannel();
                roleBindChannel.setChannelId(Integer.valueOf(resourceId));
                roleBindChannel.setCreateTime(new Date());
                roleBindChannel.setIsDelete(IsDeleteEnum.UN_DELETE.getCode());
                roleBindChannel.setRoleId(roleInfoVO.getId());
                roleBindChannel.setStatus(StatusEnum.NORMAL.getCode());
                roleBindChannelDao.insert(roleBindChannel);
            }
        }
        RoleInfo  roleInfo = roleInfoConvert.toPO(roleInfoVO);
        roleInfo.setUpdateTime(new Date());
        return roleInfoDao.updateByPrimaryKeySelective(roleInfo);
    }

    @Override
    public RoleInfoVO getRoleInfoById(Integer id) {
        RoleInfo po = roleInfoDao.selectByPrimaryKey(id);
        //查询资源
        List<RoleBindChannel> roleResources =roleBindChannelDao.queryWithRoleId(id);
        List<String> resourcesids = new ArrayList<String>();
        for(RoleBindChannel roleResource : roleResources){
            resourcesids.add(roleResource.getChannelId().toString());
        }
        RoleInfoVO vo=new RoleInfoVO();
        vo=roleInfoConvert.toVO(po);
        if(resourcesids.size()>0){
            vo.setResourceIds(join(resourcesids,","));
        }

        return vo;
    }


    @Override
    public List<RoleInfoVO> getRoleInfoListByMerchantAccountId(Integer merchantAccountId) {
        List<RoleInfoVO> returnValue = new ArrayList<RoleInfoVO>();
        List<RoleInfo> roleList = roleInfoDao.getRoleInfoListByMerchantAccountId(merchantAccountId);
        for (RoleInfo temp : roleList) {
            returnValue.add(roleInfoConvert.toVO(temp));
        }
        return returnValue;
    }

    @Override
    public List<RoleInfoVO> getRolelListByForeignIdAndRoleType(Integer foreignId, Integer roleType) {
        List<RoleInfoVO> returnValue = new ArrayList<RoleInfoVO>();
        List<RoleInfo> roleList = roleInfoDao.getRolelListByForeignIdAndRoleType(foreignId,roleType);
        for (RoleInfo temp : roleList) {
            returnValue.add(roleInfoConvert.toVO(temp));
        }
        return returnValue;
    }

    /**
     * 按分隔符将数组元素分开，组成一个字符串
     * @param list
     * @param separator
     * @return
     */
    private String join(List list, String separator) {
        String newString = "";
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                newString = newString + (String) list.get(i) + separator;
            } else {
                newString = newString + (String) list.get(i);
            }
        }
        return newString;
    }
}
