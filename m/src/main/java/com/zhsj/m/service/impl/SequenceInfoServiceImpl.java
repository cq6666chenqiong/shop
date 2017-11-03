package com.zhsj.m.service.impl;

import com.zhsj.m.dao.MerchantInfoDao;
import com.zhsj.m.dao.SequenceInfoDao;
import com.zhsj.m.model.SequenceInfo;
import com.zhsj.m.service.SequenceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuyongtao on 2017/11/2.
 */
@Service
public class SequenceInfoServiceImpl implements SequenceInfoService{
    @Autowired
    private SequenceInfoDao sequenceInfoDao;

    public long getCodeForShop(){
        return sequenceInfoDao.getCode();
    }
}
