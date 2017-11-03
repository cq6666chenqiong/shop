package com.zhsj.m.dao;

import com.zhsj.m.model.WechatInfo;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface WechatInfoDao {

    int deleteByPrimaryKey(Integer id);


    int insert(WechatInfo record);


    int insertSelective(WechatInfo record);


    WechatInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(WechatInfo record);


    int updateByPrimaryKey(WechatInfo record);

    public WechatInfo getByMerchantCode(@Param("merchantCode") String merchantCode);

    public WechatInfo getByAppId(@Param("appId") String appId);
}