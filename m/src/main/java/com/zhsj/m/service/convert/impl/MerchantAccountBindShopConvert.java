package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.MerchantAccountBindShop;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.MerchantAccountBindShopVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/8/19.
 */
public class MerchantAccountBindShopConvert implements ConvertCommon<MerchantAccountBindShopVO,MerchantAccountBindShop> {
    @Override
    public MerchantAccountBindShopVO toVO(MerchantAccountBindShop merchantAccountBindShop) {
        if(merchantAccountBindShop==null)
            return null;
        MerchantAccountBindShopVO vo = new MerchantAccountBindShopVO();
        BeanUtils.copyProperties(merchantAccountBindShop, vo);
        return vo;
    }

    @Override
    public MerchantAccountBindShop toPO(MerchantAccountBindShopVO merchantAccountBindShopVO) {
        if(merchantAccountBindShopVO==null)
            return null;
        MerchantAccountBindShop po = new MerchantAccountBindShop();
        BeanUtils.copyProperties(merchantAccountBindShopVO, po);
        return po;
    }
}
