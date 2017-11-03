package com.zhsj.m.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhsj.m.dao.MerchantHomeDao;
import com.zhsj.m.service.MerchantHomeService;

@Service
public class MerchantHomeServiceImpl implements MerchantHomeService {

	@Autowired
	private MerchantHomeDao merchantHomeDao;
	
	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return merchantHomeDao.queryCount();
	}

}
