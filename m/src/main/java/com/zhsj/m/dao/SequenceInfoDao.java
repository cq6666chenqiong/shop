package com.zhsj.m.dao;

import com.zhsj.m.model.SequenceInfo;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.springframework.stereotype.Component;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface SequenceInfoDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sequence
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sequence
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    int insert(SequenceInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sequence
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    int insertSelective(SequenceInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sequence
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    SequenceInfo selectByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sequence
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    int updateByPrimaryKeySelective(SequenceInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sequence
     *
     * @mbggenerated Thu Nov 02 21:51:33 CST 2017
     */
    int updateByPrimaryKey(SequenceInfo record);


    long getCode();
}