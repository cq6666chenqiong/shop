package com.zhsj.m.dao;

import com.zhsj.m.model.RoleBindChannel;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface RoleBindChannelDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_role_bind_channel
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_role_bind_channel
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int insert(RoleBindChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_role_bind_channel
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int insertSelective(RoleBindChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_role_bind_channel
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    RoleBindChannel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_role_bind_channel
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int updateByPrimaryKeySelective(RoleBindChannel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_role_bind_channel
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int updateByPrimaryKey(RoleBindChannel record);


    /**
     * 根据角色ID查询
     * @param roleId
     */
    public List<RoleBindChannel> queryWithRoleId(@Param("roleId") Integer roleId);


    /**
     * 根据角色ID删除记录
     * @param roleId
     */
    public void deleteWithRoleId(@Param("roleId") Integer roleId);
}