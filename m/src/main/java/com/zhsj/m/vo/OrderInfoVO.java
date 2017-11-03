package com.zhsj.m.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.zhsj.m.model.OrderInfo;
import com.zhsj.m.util.DateUtil;
import com.zhsj.m.util.enums.OrderPayMethodEnum;
import com.zhsj.m.util.enums.OrderTypeEnum;

public class OrderInfoVO extends OrderInfo implements Serializable{
	
	public Long startTime;
	public Long endTime;
	public Integer startPage;
	public String tradeTime;                 //交易时间
	public BigDecimal netIncome;             //划归金额
	public String shortName;                 //门店或商户名
	public String orderTypeName;
	public String orderPayMethedName;
	public int auth;                         //身份 空为管理员 1为商户 2为门店
	public String discountType;              //打折类型
	public String condition;                 //门店集合查询条件语句
	
	
	
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public String getOrderPayMethedName() {
		
		return OrderPayMethodEnum.getValueChina(Integer.valueOf(this.getPayMethod()));
	}
	public void setOrderPayMethedName(String orderPayMethedName) {
		this.orderPayMethedName = orderPayMethedName;
	}
	public String getOrderTypeName() {
		return OrderTypeEnum.getValueChina(Integer.valueOf(this.getOrderType()));
	}
	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Integer getStartPage() {
		return (this.getPageNo()-1)*this.getPageSize();
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public String getTradeTime() {
		return DateUtil.getYMDHMS(this.getCtime());
	}
	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}
	public BigDecimal getNetIncome() {
		return this.getActualChargeAmount().multiply(BigDecimal.valueOf(1).subtract(this.getRate())).setScale(2, BigDecimal.ROUND_HALF_UP);
	   
	}
	public void setNetIncome(BigDecimal netIncome) {
		this.netIncome = netIncome;
	}
	
	
	
	
	

}
