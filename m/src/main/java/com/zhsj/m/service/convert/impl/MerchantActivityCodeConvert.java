package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.MerchantActivityCode;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.MerchantActivityCodeVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/8/19.
 */
public class MerchantActivityCodeConvert implements ConvertCommon<MerchantActivityCodeVO,MerchantActivityCode> {
    @Override
    public MerchantActivityCodeVO toVO(MerchantActivityCode merchantActivityCode) {
        if(merchantActivityCode==null)
            return null;
        MerchantActivityCodeVO vo = new MerchantActivityCodeVO();
        BeanUtils.copyProperties(merchantActivityCode, vo);
        return vo;
    }

    @Override
    public MerchantActivityCode toPO(MerchantActivityCodeVO merchantActivityCodeVO) {
        if(merchantActivityCodeVO==null)
            return null;
        MerchantActivityCode po = new MerchantActivityCode();
        BeanUtils.copyProperties(merchantActivityCodeVO, po);
        return po;
    }
}
