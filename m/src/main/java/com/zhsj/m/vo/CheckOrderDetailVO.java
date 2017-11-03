package com.zhsj.m.vo;

import java.math.BigDecimal;

public class CheckOrderDetailVO {

	private int sumNetTradeCount;            //交易总净笔数
	private BigDecimal sumNetTradeMoney;     //交易总净金额
	private BigDecimal chanelName;           //通道名称
	private int sumRefundMoney;              //支付类型
	private BigDecimal rate;                 //商户费率
	private BigDecimal sumRemitIncomeMoney;   //预计划账金额
	
	public int getSumNetTradeCount() {
		return sumNetTradeCount;
	}
	public void setSumNetTradeCount(int sumNetTradeCount) {
		this.sumNetTradeCount = sumNetTradeCount;
	}
	public BigDecimal getSumNetTradeMoney() {
		return sumNetTradeMoney;
	}
	public void setSumNetTradeMoney(BigDecimal sumNetTradeMoney) {
		this.sumNetTradeMoney = sumNetTradeMoney;
	}
	public BigDecimal getChanelName() {
		return chanelName;
	}
	public void setChanelName(BigDecimal chanelName) {
		this.chanelName = chanelName;
	}
	public int getSumRefundMoney() {
		return sumRefundMoney;
	}
	public void setSumRefundMoney(int sumRefundMoney) {
		this.sumRefundMoney = sumRefundMoney;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getSumRemitIncomeMoney() {
		return sumRemitIncomeMoney;
	}
	public void setSumRemitIncomeMoney(BigDecimal sumRemitIncomeMoney) {
		this.sumRemitIncomeMoney = sumRemitIncomeMoney;
	}
	
	
	
}
