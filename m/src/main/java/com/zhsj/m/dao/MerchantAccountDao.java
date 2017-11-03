package com.zhsj.m.dao;

import com.zhsj.m.model.MerchantAccount;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface MerchantAccountDao {

    int deleteByPrimaryKey(Integer id);


    int insert(MerchantAccount record);


    int insertSelective(MerchantAccount record);


    MerchantAccount selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(MerchantAccount record);


    int updateByPrimaryKey(MerchantAccount record);


    public MerchantAccount getByAccount(@Param("account") String account);

    /**
     * 查询
     *
     * @param merchantAccount
     * @return List<MerchantAccount>
     */
    public List<MerchantAccount> query(MerchantAccount merchantAccount);

    /**
     * 查询
     *
     * @param merchantAccount
     * @return List<MerchantAccount>
     */
    public Long queryCount(MerchantAccount merchantAccount);
}