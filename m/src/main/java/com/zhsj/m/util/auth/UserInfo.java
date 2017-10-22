package com.zhsj.m.util.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by taoxiangshan on 2017/10/19.
 */
public class UserInfo {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名 对应account
     */
    private String userName;
    /**
     * 管理渠道或者商户ID
     */
    private Integer foreignId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 角色Id
     */
    private String roleIds;

    /**
     * 扩展属性
     */
    private Map<String,Object> extInfo = new HashMap<String,Object>();

    /**
     * 设置扩展属性
     * @param key
     * @param value
     */
    public void putExtInfo(String key, Object value){
        extInfo.put(key,value);
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getForeignId() {
        return foreignId;
    }

    public void setForeignId(Integer foreignId) {
        this.foreignId = foreignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Map<String, Object> getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(Map<String, Object> extInfo) {
        this.extInfo = extInfo;
    }
}
