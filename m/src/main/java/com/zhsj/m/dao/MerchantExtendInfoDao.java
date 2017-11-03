package com.zhsj.m.dao;

import com.zhsj.m.model.MerchantExtendInfo;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface MerchantExtendInfoDao {

    int deleteByPrimaryKey(Integer id);


    int insert(MerchantExtendInfo record);


    int insertSelective(MerchantExtendInfo record);


    MerchantExtendInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(MerchantExtendInfo record);


    int updateByPrimaryKeyWithBLOBs(MerchantExtendInfo record);


    int updateByPrimaryKey(MerchantExtendInfo record);

    MerchantExtendInfo getMerchantExtendByMerchantCode(@Param("merchantCode") String merchantCode);

}