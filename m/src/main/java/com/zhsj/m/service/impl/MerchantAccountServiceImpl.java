package com.zhsj.m.service.impl;

import com.zhsj.m.dao.*;
import com.zhsj.m.model.*;
import com.zhsj.m.service.MerchantAccountService;
import com.zhsj.m.service.RoleInfoService;
import com.zhsj.m.service.convert.impl.MerchantAccountBindRoleConvert;
import com.zhsj.m.service.convert.impl.MerchantAccountBindShopConvert;
import com.zhsj.m.service.convert.impl.MerchantAccountConvert;
import com.zhsj.m.service.convert.impl.RoleInfoConvert;
import com.zhsj.m.util.enums.IsDeleteEnum;
import com.zhsj.m.util.enums.StatusEnum;
import com.zhsj.m.util.enums.SystemIdEnum;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantAccountBindRoleVO;
import com.zhsj.m.vo.MerchantAccountBindShopVO;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

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
    @Autowired
    private MerchantAccountBindRoleDao merchantAccountBindRoleDao;
    @Autowired
    private MerchantAccountBindShopDao  merchantAccountBindShopDao;

    private MerchantAccountConvert merchantAccountConvert= new MerchantAccountConvert();

    private MerchantAccountBindRoleConvert merchantAccountBindRoleConvert= new MerchantAccountBindRoleConvert();

    private MerchantAccountBindShopConvert merchantAccountBindShopConvert= new MerchantAccountBindShopConvert();



    @Override
    public PageBean queryByPage(MerchantAccountVO merchantAccountVO) {
/*        List<RoleInfo>roleInfoList=roleInfoDao.getRolelListByForeignIdAndSystemId(merchantAccountVO.getForeignId(), SystemIdEnum.MERCHANT_PLATFORM.getCode());
        Map<Integer,Object>roleInfoMap=new HashMap<>();
        if (roleInfoList!=null&&roleInfoList.size()>0){
            for (RoleInfo roleInfo:roleInfoList){
                roleInfoMap.put(roleInfo.getId(),roleInfo);
            }
        }*/
       Integer totalCount = merchantAccountDao.queryCount(merchantAccountConvert.toPO(merchantAccountVO)).intValue();
        PageBean page = new PageBean();
        page.setTotalCount(totalCount);
        page.setPageNo(merchantAccountVO.getPageNo());
        Integer startNum = page.getStartNum();
        merchantAccountVO.setPageSize(page.getPageSize());
        merchantAccountVO.setStartNum(page.getStartNum());
        List<MerchantAccountVO> resultList = new ArrayList<MerchantAccountVO>();
        List<MerchantAccount> merchantAccountList = merchantAccountDao.query(merchantAccountConvert.toPO(merchantAccountVO));
        for (MerchantAccount temp : merchantAccountList) {
            List<RoleInfo> roleList = roleInfoDao.getRoleInfoListByMerchantAccountId(temp.getId());
            StringBuffer sb=new StringBuffer();
            if (roleList!=null&&roleList.size()>0){
                for (RoleInfo roleInfo:roleList){
                    sb.append(roleInfo.getRoleName()+"，");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            MerchantAccountVO merchantAccountVO1=new MerchantAccountVO();
            merchantAccountVO1=merchantAccountConvert.toVO(temp);
            merchantAccountVO1.setRoleNames(sb.toString());
            resultList.add(merchantAccountVO1);
        }
        page.setList(resultList);
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
        Date date = new Date();
        //保存角色记录
        merchantAccountVO.setCreateTime(date);
        merchantAccountVO.setUpdateTime(date);
        merchantAccountVO.setStatus(StatusEnum.NORMAL.getCode());
        merchantAccountVO.setIsDelete(IsDeleteEnum.UN_DELETE.getCode());
        MerchantAccount  merchantAccount = merchantAccountConvert.toPO(merchantAccountVO);
        int rowCount = merchantAccountDao.insert(merchantAccount);
        if (rowCount>0) {
            //保存角色权限记录
            if (!StringUtils.isEmpty(merchantAccountVO.getRoleIds())) {
                String[] roleIds = merchantAccountVO.getRoleIds().split(",");
                for (String roleId : roleIds) {
                    MerchantAccountBindRole merchantAccountBindRole = new MerchantAccountBindRole();
                    merchantAccountBindRole.setAccountId(merchantAccount.getId());
                    merchantAccountBindRole.setCreateTime(new Date());
                    merchantAccountBindRole.setRoleId(Integer.valueOf(roleId));
                    rowCount =merchantAccountBindRoleDao.insert(merchantAccountBindRole);
                }
            }
            if (rowCount==0){
                throw new RuntimeException("商户账户绑定角色保存失败");
            }
            //保存角色权限记录
            if (!StringUtils.isEmpty(merchantAccountVO.getShopIds())) {
                String[] shopIds = merchantAccountVO.getShopIds().split(",");
                for (String shopId : shopIds) {
                    MerchantAccountBindShop merchantAccountBindShop = new MerchantAccountBindShop();
                    merchantAccountBindShop.setMerchantAccountId(merchantAccount.getId());
                    merchantAccountBindShop.setCreateTime(new Date());
                    merchantAccountBindShop.setShopId(Integer.valueOf(shopId));
                    rowCount =merchantAccountBindShopDao.insert(merchantAccountBindShop);
                }
            }
            if (rowCount==0){
                throw new RuntimeException("商户账户绑定门店保存失败");
            }
        }else{
            throw new RuntimeException("商户账号基本信息保存失败");
        }
        return rowCount;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(MerchantAccountVO merchantAccountVO) throws Exception {
        Date date = new Date();
        //保存角色记录
        //merchantAccountVO.setCreateTime(date);
        merchantAccountVO.setUpdateTime(date);
        //merchantAccountVO.setStatus(StatusEnum.NORMAL.getCode());
        //merchantAccountVO.setIsDelete(IsDeleteEnum.UN_DELETE.getCode());
        MerchantAccount  merchantAccount = merchantAccountConvert.toPO(merchantAccountVO);
        int rowCount = merchantAccountDao.updateByPrimaryKeySelective(merchantAccount);
        if (rowCount>0) {
            merchantAccountBindRoleDao.deleteWithAccountId(merchantAccountVO.getId());
            //保存角色权限记录
            if (!StringUtils.isEmpty(merchantAccountVO.getRoleIds())) {
                String[] roleIds = merchantAccountVO.getRoleIds().split(",");
                for (String roleId : roleIds) {
                    MerchantAccountBindRole merchantAccountBindRole = new MerchantAccountBindRole();
                    merchantAccountBindRole.setAccountId(merchantAccount.getId());
                    merchantAccountBindRole.setCreateTime(new Date());
                    merchantAccountBindRole.setRoleId(Integer.valueOf(roleId));
                    rowCount =merchantAccountBindRoleDao.insert(merchantAccountBindRole);
                }
            }
            if (rowCount==0){
                throw new RuntimeException("商户账户绑定角色保存失败");
            }
            merchantAccountBindShopDao.deleteWithAccountId(merchantAccountVO.getId());
            //保存角色权限记录
            if (!StringUtils.isEmpty(merchantAccountVO.getShopIds())) {
                String[] shopIds = merchantAccountVO.getShopIds().split(",");
                for (String shopId : shopIds) {
                    MerchantAccountBindShop merchantAccountBindShop = new MerchantAccountBindShop();
                    merchantAccountBindShop.setMerchantAccountId(merchantAccount.getId());
                    merchantAccountBindShop.setCreateTime(new Date());
                    merchantAccountBindShop.setShopId(Integer.valueOf(shopId));
                    rowCount =merchantAccountBindShopDao.insert(merchantAccountBindShop);
                }
            }
            if (rowCount==0){
                throw new RuntimeException("商户账户绑定门店保存失败");
            }
        }else{
            throw new RuntimeException("商户账号基本信息保存失败");
        }
        return rowCount;
    }

    @Override
    public MerchantAccountVO getById(Integer id) {
        MerchantAccount po = merchantAccountDao.selectByPrimaryKey(id);

        MerchantAccountVO vo=new MerchantAccountVO();
        vo=merchantAccountConvert.toVO(po);
        return vo;
    }

    @Override
    public List<MerchantAccountBindRoleVO> getMerchantAccountBindRoleListByAccountId(Integer accountId) {
        List<MerchantAccountBindRoleVO> returnValue = new ArrayList<MerchantAccountBindRoleVO>();
        List<MerchantAccountBindRole> merchantAccountBindRoles = merchantAccountBindRoleDao.getMerchantAccountBindRoleListByAccountId(accountId);
        for (MerchantAccountBindRole temp : merchantAccountBindRoles) {
            returnValue.add(merchantAccountBindRoleConvert.toVO(temp));
        }
        return returnValue;
    }

    @Override
    public List<MerchantAccountBindShopVO> getMerchantAccountBindShopListByAccountId(Integer accountId) {
        List<MerchantAccountBindShopVO> returnValue = new ArrayList<MerchantAccountBindShopVO>();
        List<MerchantAccountBindShop> merchantAccountBindShops = merchantAccountBindShopDao.getMerchantAccountBindShopListByAccountId(accountId);
        for (MerchantAccountBindShop temp : merchantAccountBindShops) {
            returnValue.add(merchantAccountBindShopConvert.toVO(temp));
        }
        return returnValue;
    }

    @Override
    public List<MerchantAccountBindShopVO> getMerchantAccountBindShopListByShopName(String shopName) {
        List<MerchantAccountBindShopVO> returnValue = new ArrayList<MerchantAccountBindShopVO>();
        List<MerchantAccountBindShop> merchantAccountBindShops = merchantAccountBindShopDao.getMerchantAccountBindShopListByShopName(shopName);
        for (MerchantAccountBindShop temp : merchantAccountBindShops) {
            returnValue.add(merchantAccountBindShopConvert.toVO(temp));
        }
        return returnValue;
    }
}
