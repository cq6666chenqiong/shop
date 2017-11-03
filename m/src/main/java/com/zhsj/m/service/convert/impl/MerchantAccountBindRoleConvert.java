package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.MerchantAccountBindRole;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.MerchantAccountBindRoleVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/8/19.
 */
public class MerchantAccountBindRoleConvert implements ConvertCommon<MerchantAccountBindRoleVO,MerchantAccountBindRole> {
    @Override
    public MerchantAccountBindRoleVO toVO(MerchantAccountBindRole merchantAccountBindRole) {
        if(merchantAccountBindRole==null)
            return null;
        MerchantAccountBindRoleVO vo = new MerchantAccountBindRoleVO();
        BeanUtils.copyProperties(merchantAccountBindRole, vo);
        return vo;
    }

    @Override
    public MerchantAccountBindRole toPO(MerchantAccountBindRoleVO merchantAccountBindRoleVO) {
        if(merchantAccountBindRoleVO==null)
            return null;
        MerchantAccountBindRole po = new MerchantAccountBindRole();
        BeanUtils.copyProperties(merchantAccountBindRoleVO, po);
        return po;
    }
}
