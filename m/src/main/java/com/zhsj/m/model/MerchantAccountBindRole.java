package com.zhsj.m.model;

import java.util.Date;

public class MerchantAccountBindRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_merchant_account_bind_role.ID
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_merchant_account_bind_role.role_id
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_merchant_account_bind_role.account_id
     *
     * @mbggenerated Tue Oct 17 14:40:45 CST 2017
     */
    private Integer accountId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_merchant_account_bind_role.create_time
     *
     * @mbggenerated Tue Oct 17 14:40:45 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_merchant_account_bind_role.ID
     *
     * @return the value of tb_merchant_account_bind_role.ID
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_merchant_account_bind_role.ID
     *
     * @param id the value for tb_merchant_account_bind_role.ID
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_merchant_account_bind_role.role_id
     *
     * @return the value of tb_merchant_account_bind_role.role_id
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_merchant_account_bind_role.role_id
     *
     * @param roleId the value for tb_merchant_account_bind_role.role_id
     *
     * @mbggenerated Tue Oct 17 14:40:44 CST 2017
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_merchant_account_bind_role.account_id
     *
     * @return the value of tb_merchant_account_bind_role.account_id
     *
     * @mbggenerated Tue Oct 17 14:40:45 CST 2017
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_merchant_account_bind_role.account_id
     *
     * @param accountId the value for tb_merchant_account_bind_role.account_id
     *
     * @mbggenerated Tue Oct 17 14:40:45 CST 2017
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_merchant_account_bind_role.create_time
     *
     * @return the value of tb_merchant_account_bind_role.create_time
     *
     * @mbggenerated Tue Oct 17 14:40:45 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_merchant_account_bind_role.create_time
     *
     * @param createTime the value for tb_merchant_account_bind_role.create_time
     *
     * @mbggenerated Tue Oct 17 14:40:45 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}