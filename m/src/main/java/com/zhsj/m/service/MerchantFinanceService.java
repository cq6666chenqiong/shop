package com.zhsj.m.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import com.zhsj.m.model.OrderInfo;
import com.zhsj.m.vo.CheckOrderDetailVO;
import com.zhsj.m.vo.CheckOrderVO;
import com.zhsj.m.vo.OrderInfoVO;

public interface MerchantFinanceService {
	

	public int getOrderCount(OrderInfoVO orderInfo) throws SQLException;

	public BigDecimal getPerAveOrderMoney(OrderInfoVO orderInfo) throws SQLException;

	public BigDecimal getComparedMoneyProportion(OrderInfoVO orderInfo) throws SQLException;

	public BigDecimal getComparedOrderCountProportion(OrderInfoVO orderInfo) throws SQLException;

	public BigDecimal getComparedPerPriceProportion(OrderInfoVO orderInfo) throws SQLException;

	public List getGraphData() throws SQLException;

	public BigDecimal getOrderSumNetInCome(OrderInfoVO orderInfo) throws SQLException;

	public List<OrderInfoVO> getOrderList(OrderInfoVO orderInfo) throws SQLException;

	public List<OrderInfoVO> getOrderListForExcel(OrderInfoVO orderInfo) throws SQLException;

	public BigDecimal getOrderSumInCome(OrderInfoVO orderInfo) throws SQLException ;

	public BigDecimal getOrderSumDiscountTradeMoney(OrderInfoVO orderInfo) throws SQLException ;

	public BigDecimal getOrderRealSumTradeMoney(OrderInfoVO orderInfo) throws SQLException ;

	public List<CheckOrderVO> getCheckOrderList(OrderInfoVO orderInfo) throws SQLException ;

	public List<CheckOrderDetailVO> getCheckOrderDetailList(OrderInfoVO orderInfo) throws SQLException ;
	
}
