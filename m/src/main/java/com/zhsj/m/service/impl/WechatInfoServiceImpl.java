package com.zhsj.m.service.impl;

import com.zhsj.m.dao.WechatInfoDao;
import com.zhsj.m.service.WechatInfoService;
import com.zhsj.m.service.convert.impl.WechatInfoConvert;
import com.zhsj.m.vo.WechatInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tao on 2017/10/28.
 */
@Service
public class WechatInfoServiceImpl implements WechatInfoService {
    @Autowired
    private WechatInfoDao wechatInfoDao;

    WechatInfoConvert wechatInfoConvert=new WechatInfoConvert();

    @Override
    public WechatInfoVO getById(Integer id) {
        return wechatInfoConvert.toVO(wechatInfoDao.selectByPrimaryKey(id));
    }

    @Override
    public WechatInfoVO getByMerchantCode(String merchantCode) {
        return wechatInfoConvert.toVO(wechatInfoDao.getByMerchantCode(merchantCode));
    }

    @Override
    public WechatInfoVO getByAppId(String appId) {
        return wechatInfoConvert.toVO(wechatInfoDao.getByAppId(appId));
    }

    @Override
    public int insert(WechatInfoVO wechatInfoVO) throws Exception {
        return wechatInfoDao.insert(wechatInfoConvert.toPO(wechatInfoVO));
    }

    @Override
    public int update(WechatInfoVO wechatInfoVO) throws Exception {
        return  wechatInfoDao.updateByPrimaryKeySelective(wechatInfoConvert.toPO(wechatInfoVO));
    }
}
