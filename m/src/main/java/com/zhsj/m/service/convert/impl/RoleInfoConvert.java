package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.RoleInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/8/19.
 */
public class RoleInfoConvert implements ConvertCommon<RoleInfoVO,RoleInfo> {
    @Override
    public RoleInfoVO toVO(RoleInfo roleInfo) {
        if(roleInfo==null)
            return null;
        RoleInfoVO vo = new RoleInfoVO();
        BeanUtils.copyProperties(roleInfo, vo);
        return vo;
    }

    @Override
    public RoleInfo toPO(RoleInfoVO roleInfoVO) {
        if(roleInfoVO==null)
            return null;
        RoleInfo po = new RoleInfo();
        BeanUtils.copyProperties(roleInfoVO, po);
        return po;
    }
}
