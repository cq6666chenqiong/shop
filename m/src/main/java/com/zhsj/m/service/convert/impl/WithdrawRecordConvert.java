package com.zhsj.m.service.convert.impl;


import com.zhsj.m.model.WithdrawRecord;
import com.zhsj.m.service.convert.ConvertCommon;
import com.zhsj.m.vo.WithdrawRecordVO;
import org.springframework.beans.BeanUtils;

/**
 * Created by taoxiangshan on 2017/8/19.
 */
public class WithdrawRecordConvert implements ConvertCommon<WithdrawRecordVO,WithdrawRecord> {
    @Override
    public WithdrawRecordVO toVO(WithdrawRecord withdraw) {
        if(withdraw==null)
            return null;
        WithdrawRecordVO vo = new WithdrawRecordVO();
        BeanUtils.copyProperties(withdraw, vo);
        return vo;
    }

    @Override
    public WithdrawRecord toPO(WithdrawRecordVO withdrawRecordVO) {
        if(withdrawRecordVO ==null)
            return null;
        WithdrawRecord po = new WithdrawRecord();
        BeanUtils.copyProperties(withdrawRecordVO, po);
        return po;
    }
}
