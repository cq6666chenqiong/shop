package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.MerchantFundAccount;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.MerchantFundAccountVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/8/19.
 */
public class MerchantFundAccountConvert implements ConvertCommon<MerchantFundAccountVO,MerchantFundAccount> {
    @Override
    public MerchantFundAccountVO toVO(MerchantFundAccount merchantFundAccount) {
        if(merchantFundAccount==null)
            return null;
        MerchantFundAccountVO vo = new MerchantFundAccountVO();
        BeanUtils.copyProperties(merchantFundAccount, vo);
        return vo;
    }

    @Override
    public MerchantFundAccount toPO(MerchantFundAccountVO merchantFundAccountVO) {
        if(merchantFundAccountVO==null)
            return null;
        MerchantFundAccount po = new MerchantFundAccount();
        BeanUtils.copyProperties(merchantFundAccountVO, po);
        return po;
    }
}
