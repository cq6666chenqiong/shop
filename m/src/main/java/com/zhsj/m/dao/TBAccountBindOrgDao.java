package com.zhsj.m.dao;


import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface TBAccountBindOrgDao {

    Long getOrgIdByAccountId(@Param("accountId")long accountId);


}
