package com.zhsj.m.dao;

import com.zhsj.m.model.WithdrawRecord;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface WithdrawRecordDao {

    int deleteByPrimaryKey(Integer id);


    int insert(WithdrawRecord record);


    int insertSelective(WithdrawRecord record);


    WithdrawRecord selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(WithdrawRecord record);


    int updateByPrimaryKey(WithdrawRecord record);

    /**
     * 查询
     *
     * @param record
     * @return List<Withdraw>
     */
    public List<WithdrawRecord> query(WithdrawRecord record);

    /**
     * 查询
     *
     * @param record
     * @return List<Withdraw>
     */
    public Long queryCount(WithdrawRecord record);

    /**
     * 查询
     *
     * @param record
     * @return List<Withdraw>
     */
    public BigDecimal querySumAmount(WithdrawRecord record);
}