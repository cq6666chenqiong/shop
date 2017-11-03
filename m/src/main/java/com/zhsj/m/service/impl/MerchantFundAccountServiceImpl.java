package com.zhsj.m.service.impl;

import com.zhsj.m.dao.MerchantFundAccountDao;
import com.zhsj.m.service.MerchantFundAccountService;
import com.zhsj.m.service.convert.impl.MerchantFundAccountConvert;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantFundAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 17/10/30.
 */
@Service
public class MerchantFundAccountServiceImpl implements MerchantFundAccountService {
    @Autowired
    private MerchantFundAccountDao merchantFundAccountDao;
    MerchantFundAccountConvert merchantFundAccountConvert=new MerchantFundAccountConvert();
    @Override
    public PageBean queryByPage(MerchantFundAccountVO merchantFundAccountVO) {
        return null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(MerchantFundAccountVO merchantFundAccountVO) throws Exception {
        return merchantFundAccountDao.insert(merchantFundAccountConvert.toPO(merchantFundAccountVO));
    }

    @Override
    public MerchantFundAccountVO getById(Integer id) {
        return merchantFundAccountConvert.toVO(merchantFundAccountDao.selectByPrimaryKey(id));
    }

    @Override
    public int update(MerchantFundAccountVO merchantFundAccountVO) throws Exception {
        return merchantFundAccountDao.updateByPrimaryKeySelective(merchantFundAccountConvert.toPO(merchantFundAccountVO));
    }

    @Override
    public MerchantFundAccountVO getByMerchantId(Integer merchantId) {
        return merchantFundAccountConvert.toVO(merchantFundAccountDao.getByMerchantId(merchantId));
    }


}
