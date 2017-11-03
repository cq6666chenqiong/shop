package com.zhsj.m.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhsj.m.dao.MchHourCountDao;
import com.zhsj.m.dao.MerchantFinanceDao;
import com.zhsj.m.dao.OrderInfoDao;
import com.zhsj.m.model.OrderInfo;
import com.zhsj.m.service.MerchantFinanceService;
import com.zhsj.m.vo.CheckOrderDetailVO;
import com.zhsj.m.vo.CheckOrderVO;
import com.zhsj.m.vo.OrderInfoVO;

@Service
public class MerchantFinanceServiceImpl implements MerchantFinanceService{

	@Autowired
	private MerchantFinanceDao merchantFinanceDao;
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Autowired
	private MchHourCountDao mchHourCountDao;

	@Override
	public int getOrderCount(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getOrderCount(orderInfo);
	}


	@Override
	public BigDecimal getPerAveOrderMoney(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getPerAveOrderMoney(orderInfo);
	}


	@Override
	public BigDecimal getComparedMoneyProportion(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getComparedMoneyProportion(orderInfo);
	}

	@Override
	public BigDecimal getComparedOrderCountProportion(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getComparedOrderCountProportion(orderInfo);
	}

	@Override
	public BigDecimal getComparedPerPriceProportion(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getComparedPerPriceProportion(orderInfo);
	}

	@Override
	public BigDecimal getOrderSumNetInCome(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getOrderSumNetInCome(orderInfo);
	}

	@Override
	public List<OrderInfoVO> getOrderList(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getOrderList(orderInfo);
	}

	@Override
	public List<OrderInfoVO> getOrderListForExcel(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getOrderListForExcel(orderInfo);
	}

	@Override
	public List getGraphData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getOrderSumInCome(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getOrderSumInCome(orderInfo);
	}

	@Override
	public BigDecimal getOrderSumDiscountTradeMoney(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getOrderSumDiscountTradeMoney(orderInfo);
	}

	@Override
	public BigDecimal getOrderRealSumTradeMoney(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		return orderInfoDao.getOrderRealSumTradeMoney(orderInfo);
	}


	@Override
	public List<CheckOrderVO> getCheckOrderList(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		List<CheckOrderVO> list = new ArrayList<CheckOrderVO>();
		//查出门店，以门店为单位组成list
		return list;
	}


	@Override
	public List<CheckOrderDetailVO> getCheckOrderDetailList(OrderInfoVO orderInfo) throws SQLException {
		// TODO Auto-generated method stub
		List<CheckOrderDetailVO> list = new ArrayList<CheckOrderDetailVO>();
		//以通道为单位组成list
		return list;
	}


	

	

}
