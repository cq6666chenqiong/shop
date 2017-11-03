package com.zhsj.m.vo;

import java.math.BigDecimal;

public class CheckOrderVO {
	private String storeName;                //门店名称
	private BigDecimal sumTradeMoney;        //交易总金额
	private BigDecimal sumTradeCount;        //交易总笔数
	private BigDecimal sumRefundMoney;       //退款总金额
	private BigDecimal sumDiscountMoney;     //退款总金额
	private BigDecimal sumRealIncomeMoney;   //实收总金额
	private BigDecimal sumNetIncomeMoney;    //划账总金额
	
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public BigDecimal getSumTradeMoney() {
		return sumTradeMoney;
	}
	public void setSumTradeMoney(BigDecimal sumTradeMoney) {
		this.sumTradeMoney = sumTradeMoney;
	}
	public BigDecimal getSumTradeCount() {
		return sumTradeCount;
	}
	public void setSumTradeCount(BigDecimal sumTradeCount) {
		this.sumTradeCount = sumTradeCount;
	}
	public BigDecimal getSumRefundMoney() {
		return sumRefundMoney;
	}
	public void setSumRefundMoney(BigDecimal sumRefundMoney) {
		this.sumRefundMoney = sumRefundMoney;
	}
	public BigDecimal getSumDiscountMoney() {
		return sumDiscountMoney;
	}
	public void setSumDiscountMoney(BigDecimal sumDiscountMoney) {
		this.sumDiscountMoney = sumDiscountMoney;
	}
	public BigDecimal getSumRealIncomeMoney() {
		return sumRealIncomeMoney;
	}
	public void setSumRealIncomeMoney(BigDecimal sumRealIncomeMoney) {
		this.sumRealIncomeMoney = sumRealIncomeMoney;
	}
	public BigDecimal getSumNetIncomeMoney() {
		return sumNetIncomeMoney;
	}
	public void setSumNetIncomeMoney(BigDecimal sumNetIncomeMoney) {
		this.sumNetIncomeMoney = sumNetIncomeMoney;
	}
}
