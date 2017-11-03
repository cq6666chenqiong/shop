package com.zhsj.m.model;

import java.math.BigDecimal;

public class OrderInfo extends BaseModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.order_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.plan_charge_amount
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private BigDecimal planChargeAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.actual_charge_amount
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private BigDecimal actualChargeAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.status
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.pay_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Integer payType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.pay_method
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String payMethod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.门店编号
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String storeCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.商家编号
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String merchantCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.org_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Long orgId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.org_ids
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String orgIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.user_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.utime
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Long utime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.ctime
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Long ctime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.sale_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Integer saleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.discount_detail
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String discountDetail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.store_discount_price
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private BigDecimal storeDiscountPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.org_discount_price
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private BigDecimal orgDiscountPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.ref_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String refNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.refund_money
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private BigDecimal refundMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.pay_channel
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Integer payChannel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.device_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Integer deviceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.pay_device
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String payDevice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.transaction_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String transactionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.special_rate_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private Integer specialRateId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.rate
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private BigDecimal rate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.service_charge
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private BigDecimal serviceCharge;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.mchnt_order_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String mchntOrderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.fuyou_order_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String fuyouOrderNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.card_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String cardType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.code
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.notify_url
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String notifyUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order.order_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    private String orderType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.id
     *
     * @return the value of tb_order.id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.id
     *
     * @param id the value for tb_order.id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.order_id
     *
     * @return the value of tb_order.order_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.order_id
     *
     * @param orderId the value for tb_order.order_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.plan_charge_amount
     *
     * @return the value of tb_order.plan_charge_amount
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public BigDecimal getPlanChargeAmount() {
        return planChargeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.plan_charge_amount
     *
     * @param planChargeAmount the value for tb_order.plan_charge_amount
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setPlanChargeAmount(BigDecimal planChargeAmount) {
        this.planChargeAmount = planChargeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.actual_charge_amount
     *
     * @return the value of tb_order.actual_charge_amount
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public BigDecimal getActualChargeAmount() {
        return actualChargeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.actual_charge_amount
     *
     * @param actualChargeAmount the value for tb_order.actual_charge_amount
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setActualChargeAmount(BigDecimal actualChargeAmount) {
        this.actualChargeAmount = actualChargeAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.status
     *
     * @return the value of tb_order.status
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.status
     *
     * @param status the value for tb_order.status
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.pay_type
     *
     * @return the value of tb_order.pay_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.pay_type
     *
     * @param payType the value for tb_order.pay_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.pay_method
     *
     * @return the value of tb_order.pay_method
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.pay_method
     *
     * @param payMethod the value for tb_order.pay_method
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.门店编号
     *
     * @return the value of tb_order.门店编号
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getStoreCode() {
        return storeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.门店编号
     *
     * @param 门店编号 the value for tb_order.门店编号
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode == null ? null : storeCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.商家编号
     *
     * @return the value of tb_order.商家编号
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.商家编号
     *
     * @param 商家编号 the value for tb_order.商家编号
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.org_id
     *
     * @return the value of tb_order.org_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.org_id
     *
     * @param orgId the value for tb_order.org_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.org_ids
     *
     * @return the value of tb_order.org_ids
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getOrgIds() {
        return orgIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.org_ids
     *
     * @param orgIds the value for tb_order.org_ids
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds == null ? null : orgIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.user_id
     *
     * @return the value of tb_order.user_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.user_id
     *
     * @param userId the value for tb_order.user_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.utime
     *
     * @return the value of tb_order.utime
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Long getUtime() {
        return utime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.utime
     *
     * @param utime the value for tb_order.utime
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setUtime(Long utime) {
        this.utime = utime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.ctime
     *
     * @return the value of tb_order.ctime
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Long getCtime() {
        return ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.ctime
     *
     * @param ctime the value for tb_order.ctime
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.sale_id
     *
     * @return the value of tb_order.sale_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Integer getSaleId() {
        return saleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.sale_id
     *
     * @param saleId the value for tb_order.sale_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.discount_detail
     *
     * @return the value of tb_order.discount_detail
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getDiscountDetail() {
        return discountDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.discount_detail
     *
     * @param discountDetail the value for tb_order.discount_detail
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setDiscountDetail(String discountDetail) {
        this.discountDetail = discountDetail == null ? null : discountDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.store_discount_price
     *
     * @return the value of tb_order.store_discount_price
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public BigDecimal getStoreDiscountPrice() {
        return storeDiscountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.store_discount_price
     *
     * @param storeDiscountPrice the value for tb_order.store_discount_price
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setStoreDiscountPrice(BigDecimal storeDiscountPrice) {
        this.storeDiscountPrice = storeDiscountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.org_discount_price
     *
     * @return the value of tb_order.org_discount_price
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public BigDecimal getOrgDiscountPrice() {
        return orgDiscountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.org_discount_price
     *
     * @param orgDiscountPrice the value for tb_order.org_discount_price
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setOrgDiscountPrice(BigDecimal orgDiscountPrice) {
        this.orgDiscountPrice = orgDiscountPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.ref_no
     *
     * @return the value of tb_order.ref_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.ref_no
     *
     * @param refNo the value for tb_order.ref_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setRefNo(String refNo) {
        this.refNo = refNo == null ? null : refNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.refund_money
     *
     * @return the value of tb_order.refund_money
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public BigDecimal getRefundMoney() {
        return refundMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.refund_money
     *
     * @param refundMoney the value for tb_order.refund_money
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setRefundMoney(BigDecimal refundMoney) {
        this.refundMoney = refundMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.pay_channel
     *
     * @return the value of tb_order.pay_channel
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Integer getPayChannel() {
        return payChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.pay_channel
     *
     * @param payChannel the value for tb_order.pay_channel
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setPayChannel(Integer payChannel) {
        this.payChannel = payChannel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.device_type
     *
     * @return the value of tb_order.device_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Integer getDeviceType() {
        return deviceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.device_type
     *
     * @param deviceType the value for tb_order.device_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.pay_device
     *
     * @return the value of tb_order.pay_device
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getPayDevice() {
        return payDevice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.pay_device
     *
     * @param payDevice the value for tb_order.pay_device
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setPayDevice(String payDevice) {
        this.payDevice = payDevice == null ? null : payDevice.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.transaction_id
     *
     * @return the value of tb_order.transaction_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.transaction_id
     *
     * @param transactionId the value for tb_order.transaction_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.special_rate_id
     *
     * @return the value of tb_order.special_rate_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public Integer getSpecialRateId() {
        return specialRateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.special_rate_id
     *
     * @param specialRateId the value for tb_order.special_rate_id
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setSpecialRateId(Integer specialRateId) {
        this.specialRateId = specialRateId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.rate
     *
     * @return the value of tb_order.rate
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.rate
     *
     * @param rate the value for tb_order.rate
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.service_charge
     *
     * @return the value of tb_order.service_charge
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.service_charge
     *
     * @param serviceCharge the value for tb_order.service_charge
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.mchnt_order_no
     *
     * @return the value of tb_order.mchnt_order_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getMchntOrderNo() {
        return mchntOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.mchnt_order_no
     *
     * @param mchntOrderNo the value for tb_order.mchnt_order_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setMchntOrderNo(String mchntOrderNo) {
        this.mchntOrderNo = mchntOrderNo == null ? null : mchntOrderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.fuyou_order_no
     *
     * @return the value of tb_order.fuyou_order_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getFuyouOrderNo() {
        return fuyouOrderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.fuyou_order_no
     *
     * @param fuyouOrderNo the value for tb_order.fuyou_order_no
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setFuyouOrderNo(String fuyouOrderNo) {
        this.fuyouOrderNo = fuyouOrderNo == null ? null : fuyouOrderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.card_type
     *
     * @return the value of tb_order.card_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.card_type
     *
     * @param cardType the value for tb_order.card_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.code
     *
     * @return the value of tb_order.code
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.code
     *
     * @param code the value for tb_order.code
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.notify_url
     *
     * @return the value of tb_order.notify_url
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.notify_url
     *
     * @param notifyUrl the value for tb_order.notify_url
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order.order_type
     *
     * @return the value of tb_order.order_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order.order_type
     *
     * @param orderType the value for tb_order.order_type
     *
     * @mbggenerated Sun Oct 29 12:06:32 CST 2017
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }
}