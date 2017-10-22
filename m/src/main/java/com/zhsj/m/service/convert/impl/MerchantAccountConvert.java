package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.MerchantAccount;
import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.RoleInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/8/19.
 */
public class MerchantAccountConvert implements ConvertCommon<MerchantAccountVO,MerchantAccount> {
    @Override
    public MerchantAccountVO toVO(MerchantAccount merchantAccount) {
        if(merchantAccount==null)
            return null;
        MerchantAccountVO vo = new MerchantAccountVO();
        BeanUtils.copyProperties(merchantAccount, vo);
        return vo;
    }

    @Override
    public MerchantAccount toPO(MerchantAccountVO merchantAccountVO) {
        if(merchantAccountVO==null)
            return null;
        MerchantAccount po = new MerchantAccount();
        BeanUtils.copyProperties(merchantAccountVO, po);
        return po;
    }
}
