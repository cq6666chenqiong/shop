package com.zhsj.m.dao;

import com.zhsj.m.model.SystemInfo;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.springframework.stereotype.Component;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface SystemInfoDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_system
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_system
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int insert(SystemInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_system
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int insertSelective(SystemInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_system
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    SystemInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_system
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int updateByPrimaryKeySelective(SystemInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table td_system
     *
     * @mbggenerated Sun Oct 15 16:02:14 CST 2017
     */
    int updateByPrimaryKey(SystemInfo record);
}