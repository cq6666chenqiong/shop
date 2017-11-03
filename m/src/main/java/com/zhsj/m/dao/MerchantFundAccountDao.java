package com.zhsj.m.dao;

import com.zhsj.m.model.MerchantFundAccount;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface MerchantFundAccountDao {

    int deleteByPrimaryKey(Integer id);


    int insert(MerchantFundAccount record);


    int insertSelective(MerchantFundAccount record);


    MerchantFundAccount selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(MerchantFundAccount record);

    int updateByPrimaryKey(MerchantFundAccount record);

    /**
     * 通过商户Id或者门店Id(商户门店信息表)
     * @param merchantId
     * @return
     */
    MerchantFundAccount getByMerchantId(@Param("merchantId") Integer merchantId);

    /***
     * 余额提现更新账户信息
     * @param merchantId,amount
     * @return
     */
    int updateFundAccountForBalanceWithdraw(@Param("merchantId") Integer merchantId, @Param("amount") BigDecimal amount);
    /***
     * 实时提现更新账户信息
     * @param merchantId,amount
     * @return
     */
    int updateFundAccountForRealTimeWithdraw(@Param("merchantId") Integer merchantId, @Param("amount") BigDecimal amount);
}