package com.zhsj.m.service.impl;

import com.zhsj.m.dao.MerchantInfoDao;
import com.zhsj.m.model.MerchantInfo;
import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.service.ShopService;
import com.zhsj.m.service.convert.impl.MerchantInfoConvert;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantInfoVO;
import com.zhsj.m.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyongtao on 2017/10/16.
 */
@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
    private MerchantInfoDao merchantInfoDao;

    private MerchantInfoConvert merchantInfoConvert = new MerchantInfoConvert();

    @Override
    public MerchantInfoVO getById(Integer id) {
        MerchantInfo po = merchantInfoDao.selectByPrimaryKey(id);
        return merchantInfoConvert.toVO(po);
    }

    @Override
    public void save(MerchantInfo merchantInfo) {
        merchantInfoDao.insert(merchantInfo);
    }

    @Override
    public List<MerchantInfo> getShopList(MerchantInfo merchantInfo) {
        return merchantInfoDao.getMerchantInfoList(merchantInfo);
    }

    @Override
    public PageBean queryByPage(MerchantInfoVO merchantInfoVO) {
        Integer totalCount = merchantInfoDao.queryCount(merchantInfoConvert.toPO(merchantInfoVO)).intValue();
        PageBean page = new PageBean();
        page.setTotalCount(totalCount);
        page.setPageNo(merchantInfoVO.getPageNo());
        Integer startNum = page.getStartNum();
        merchantInfoVO.setPageSize(page.getPageSize());
        merchantInfoVO.setStartNum(page.getStartNum());
        List<MerchantInfoVO> resultList = new ArrayList<MerchantInfoVO>();
        List<MerchantInfo> merchantInfoList = merchantInfoDao.query(merchantInfoConvert.toPO(merchantInfoVO));
        for (MerchantInfo temp : merchantInfoList) {
            resultList.add(merchantInfoConvert.toVO(temp));
        }
        page.setList(resultList);
        return page;
    }
}