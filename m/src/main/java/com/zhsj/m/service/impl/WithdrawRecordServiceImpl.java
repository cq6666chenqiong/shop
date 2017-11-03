package com.zhsj.m.service.impl;

import com.zhsj.m.dao.MerchantFundAccountDao;
import com.zhsj.m.dao.WithdrawRecordDao;
import com.zhsj.m.model.WithdrawRecord;
import com.zhsj.m.service.WithdrawRecordService;
import com.zhsj.m.service.convert.impl.WithdrawRecordConvert;
import com.zhsj.m.util.enums.WithdrawTypeEnum;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.WithdrawRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 17/10/30.
 */
@Service
public class WithdrawRecordServiceImpl implements WithdrawRecordService {
    @Autowired
    private WithdrawRecordDao withdrawRecordDao;

    @Autowired
    private MerchantFundAccountDao merchantFundAccountDao;

    WithdrawRecordConvert withdrawRecordConvert =new WithdrawRecordConvert();
    @Override
    public WithdrawRecordVO getById(Integer id) {
        return withdrawRecordConvert.toVO(withdrawRecordDao.selectByPrimaryKey(id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(WithdrawRecordVO withdrawRecordVO) throws Exception {
        int count =0;
        if (withdrawRecordVO.getWithdrawType()== WithdrawTypeEnum.BALANCE_WITHDRAW.getCode()) {
            count = merchantFundAccountDao.updateFundAccountForBalanceWithdraw(withdrawRecordVO.getMerchantId(), withdrawRecordVO.getAmount());
        }else{
            count=1;
            //TODO 调接口 处理实时提现数据
            //count = merchantFundAccountDao.updateFundAccountForRealTimeWithdraw(withdrawRecordVO.getMerchantId(), withdrawRecordVO.getAmount());
        }
        if (count>0){
            count=withdrawRecordDao.insert(withdrawRecordConvert.toPO(withdrawRecordVO));
        }
        if (count<=0){
            throw new RuntimeException("保存数据失败");
        }
        return count;
    }

    @Override
    public int update(WithdrawRecordVO withdrawRecordVO) throws Exception {
        return withdrawRecordDao.updateByPrimaryKeySelective(withdrawRecordConvert.toPO(withdrawRecordVO));
    }

    @Override
    public PageBean queryByPage(WithdrawRecordVO withdrawRecordVO) {
        Integer totalCount = withdrawRecordDao.queryCount(withdrawRecordConvert.toPO(withdrawRecordVO)).intValue();
        PageBean page = new PageBean();
        page.setTotalCount(totalCount);
        page.setPageNo(withdrawRecordVO.getPageNo());
        Integer startNum = page.getStartNum();
        withdrawRecordVO.setPageSize(page.getPageSize());
        withdrawRecordVO.setStartNum(page.getStartNum());
        List<WithdrawRecordVO> resultList = new ArrayList<WithdrawRecordVO>();
        List<WithdrawRecord> withdrawList = withdrawRecordDao.query(withdrawRecordConvert.toPO(withdrawRecordVO));
        for (WithdrawRecord temp : withdrawList) {
            resultList.add(withdrawRecordConvert.toVO(temp));
        }
        page.setList(resultList);
        return page;
    }

    @Override
    public BigDecimal querySumAmount(WithdrawRecordVO withdrawRecordVO) {
        return withdrawRecordDao.querySumAmount(withdrawRecordConvert.toPO(withdrawRecordVO));
    }
}
