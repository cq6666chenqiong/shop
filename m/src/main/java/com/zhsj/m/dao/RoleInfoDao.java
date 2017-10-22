package com.zhsj.m.dao;

import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface RoleInfoDao {

    int deleteByPrimaryKey(Integer id);


    int insert(RoleInfo record);


    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    public List<RoleInfo> getRolelListByForeignIdAndSystemId(@Param("foreignId") Integer foreignId,@Param("systemId") Integer systemId);


    /**
     * 查询
     *
     * @param roleInfo
     * @return List<RoleInfo>
     */
    public List<RoleInfo> query(RoleInfo roleInfo);

    /**
     * 查询
     *
     * @param roleInfo
     * @return List<Role>
     */
    public Long queryCount(RoleInfo roleInfo);

    public RoleInfo getByName(@Param("name")String name);

    public List<RoleInfo> getRoleInfoListByMerchantAccountId(@Param("merchantAccountId") Integer merchantAccountId);
}