package com.zhsj.m.dao;

import com.zhsj.m.model.MerchantAccount;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface MerchantAccountDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_merchant_account
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_merchant_account
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    int insert(MerchantAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_merchant_account
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    int insertSelective(MerchantAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_merchant_account
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    MerchantAccount selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_merchant_account
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    int updateByPrimaryKeySelective(MerchantAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_merchant_account
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    int updateByPrimaryKey(MerchantAccount record);


    public MerchantAccount getByAccount(@Param("account") String account);
}