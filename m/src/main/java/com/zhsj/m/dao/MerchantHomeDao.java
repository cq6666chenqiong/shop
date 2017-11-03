package com.zhsj.m.dao;

import org.springframework.stereotype.Component;

import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface MerchantHomeDao {

	int queryCount();

}
