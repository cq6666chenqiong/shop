package com.zhsj.m.service.impl;

import com.zhsj.m.dao.MerchantAccountDao;
import com.zhsj.m.dao.RoleBindChannelDao;
import com.zhsj.m.dao.RoleInfoDao;
import com.zhsj.m.model.MerchantAccount;
import com.zhsj.m.model.RoleBindChannel;
import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.service.RoleInfoService;
import com.zhsj.m.service.convert.impl.MerchantAccountConvert;
import com.zhsj.m.service.convert.impl.RoleInfoConvert;
import com.zhsj.m.util.enums.IsDeleteEnum;
import com.zhsj.m.util.enums.StatusEnum;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by taoxiangshan on 17/10/19.
 */
@Service
public class MerchantAccountServiceImpl implements MerchantAccountService {
    @Autowired
    private MerchantAccountDao merchantAccountDao;
    @Autowired
    private RoleInfoDao roleInfoDao;
    @Autowired
    private RoleBindChannelDao roleBindChannelDao;
    private MerchantAccountConvert merchantAccountConvert= new MerchantAccountConvert();



    @Override
    public PageBean queryByPage(MerchantAccountVO merchantAccountVO) {
       //Integer totalCount = roleInfoDao.queryCount(roleInfoConvert.toPO(roleInfoVO)).intValue();
        PageBean page = new PageBean();
/*        page.setTotalCount(totalCount);
        page.setPageNo(roleInfoVO.getPageNo());
        Integer startNum = page.getStartNum();
        roleInfoVO.setPageSize(page.getPageSize());
        roleInfoVO.setStartNum(page.getStartNum());
        List<RoleInfoVO> resultList = new ArrayList<RoleInfoVO>();
        List<RoleInfo> roleList = roleInfoDao.query(roleInfoConvert.toPO(roleInfoVO));
        for (RoleInfo temp : roleList) {
            resultList.add(roleInfoConvert.toVO(temp));
        }
        page.setList(resultList);*/
        return page;
    }


    @Override
    public MerchantAccountVO getByAccount(String account) {
        MerchantAccount po = merchantAccountDao.getByAccount(account);
        return merchantAccountConvert.toVO(po);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(MerchantAccountVO merchantAccountVO) throws Exception {
/*        Date date = new Date();
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
        return rowCount;*/
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(MerchantAccountVO merchantAccountVO) throws Exception {
        MerchantAccount merchantAccount=merchantAccountConvert.toPO(merchantAccountVO);
        return merchantAccountDao.updateByPrimaryKeySelective(merchantAccount);
    }

    @Override
    public MerchantAccountVO getById(Integer id) {
        MerchantAccount po = merchantAccountDao.selectByPrimaryKey(id);

        MerchantAccountVO vo=new MerchantAccountVO();
        vo=merchantAccountConvert.toVO(po);


        return vo;
    }

}
