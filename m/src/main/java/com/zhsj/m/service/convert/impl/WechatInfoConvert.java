package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.model.WechatInfo;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.RoleInfoVO;
import com.zhsj.m.vo.WechatInfoVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/10/29.
 */
public class WechatInfoConvert implements ConvertCommon<WechatInfoVO,WechatInfo> {
    @Override
    public WechatInfoVO toVO(WechatInfo roleInfo) {
        if(roleInfo==null)
            return null;
        WechatInfoVO vo = new WechatInfoVO();
        BeanUtils.copyProperties(roleInfo, vo);
        return vo;
    }

    @Override
    public WechatInfo toPO(WechatInfoVO roleInfoVO) {
        if(roleInfoVO==null)
            return null;
        WechatInfo po = new WechatInfo();
        BeanUtils.copyProperties(roleInfoVO, po);
        return po;
    }
}
