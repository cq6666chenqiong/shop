package com.zhsj.m.service;

import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantFundAccountVO;
import com.zhsj.m.vo.WithdrawRecordVO;

import java.util.List;

/**
 * Created by taoxiangshan on 17/10/30.
 */
public interface MerchantFundAccountService {

    public PageBean queryByPage(MerchantFundAccountVO merchantFundAccountVO);


    /**
     * 新增
     *
     * @param merchantFundAccountVO
     * @return int
     */
    public int insert(final MerchantFundAccountVO merchantFundAccountVO) throws Exception;

    /**
     * 获取
     *
     * @param id
     * @return int
     */
    public MerchantFundAccountVO getById(Integer id);

    /**
     * 新增
     *
     * @param merchantFundAccountVO
     * @return int
     */
    public int update(final MerchantFundAccountVO merchantFundAccountVO) throws Exception;

    /**
     * 通过商户Id或者门店Id(商户门店信息表)
     * @param merchantId
     * @return
     */
    public MerchantFundAccountVO getByMerchantId(Integer merchantId);



}
