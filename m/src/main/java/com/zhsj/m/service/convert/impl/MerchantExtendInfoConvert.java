package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.MerchantExtendInfo;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.MerchantExtendInfoVO;
import com.zhsj.m.vo.MerchantInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/8/30.
 */
public class MerchantExtendInfoConvert implements ConvertCommon<MerchantExtendInfoVO,MerchantExtendInfo> {
    @Override
    public MerchantExtendInfoVO toVO(MerchantExtendInfo merchantExtendInfo) {
        if(merchantExtendInfo==null)
            return null;
        MerchantExtendInfoVO vo = new MerchantExtendInfoVO();
        BeanUtils.copyProperties(merchantExtendInfo, vo);
        return vo;
    }

    @Override
    public MerchantExtendInfo toPO(MerchantExtendInfoVO merchantExtendInfoVO) {
        if(merchantExtendInfoVO==null)
            return null;
        MerchantExtendInfo po = new MerchantExtendInfo();
        BeanUtils.copyProperties(merchantExtendInfoVO, po);
        return po;
    }

    public MerchantExtendInfo toPO1(MerchantInfoVO merchantInfoVO) {
        if(merchantInfoVO==null)
            return null;
        MerchantExtendInfo po = new MerchantExtendInfo();
        BeanUtils.copyProperties(merchantInfoVO, po);
        return po;
    }
}
