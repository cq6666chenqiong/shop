package com.zhsj.m.service.convert.impl;

import com.zhsj.m.model.MerchantInfo;
import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.MerchantInfoVO;
import com.zhsj.m.vo.RoleInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by wuyongtao on 2017/10/19.
 */
public class MerchantInfoConvert implements ConvertCommon<MerchantInfoVO,MerchantInfo> {
    @Override
    public MerchantInfoVO toVO(MerchantInfo merchantInfo) {
        if(merchantInfo==null)
            return null;
        MerchantInfoVO vo = new MerchantInfoVO();
        BeanUtils.copyProperties(merchantInfo, vo);
        return vo;
    }

    @Override
    public MerchantInfo toPO(MerchantInfoVO merchantInfoVO) {
        if(merchantInfoVO==null)
            return null;
        MerchantInfo po = new MerchantInfo();
        BeanUtils.copyProperties(merchantInfoVO, po);
        return po;
    }
}
