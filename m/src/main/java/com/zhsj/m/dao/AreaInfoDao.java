package com.zhsj.m.dao;

import com.zhsj.m.model.AreaInfo;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface AreaInfoDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbggenerated Tue Oct 17 17:37:00 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbggenerated Tue Oct 17 17:37:00 CST 2017
     */
    int insert(AreaInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbggenerated Tue Oct 17 17:37:00 CST 2017
     */
    int insertSelective(AreaInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbggenerated Tue Oct 17 17:37:00 CST 2017
     */
    AreaInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbggenerated Tue Oct 17 17:37:00 CST 2017
     */
    int updateByPrimaryKeySelective(AreaInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_area
     *
     * @mbggenerated Tue Oct 17 17:37:00 CST 2017
     */
    int updateByPrimaryKey(AreaInfo record);


    List<AreaInfo> selectByParentId(@Param("parentId") Integer parentId);
}