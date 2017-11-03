package com.zhsj.m.service;

import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.WithdrawRecordVO;

import java.math.BigDecimal;

/**
 * Created by taoxiangshan on 17/10/30.
 */
public interface WithdrawRecordService {

    /**
     * 获取
     *
     * @param id
     * @return int
     */
    public WithdrawRecordVO getById(Integer id);



    /**
     * 新增
     *
     * @param withdrawRecordVO
     * @return int
     */
    public int insert(final WithdrawRecordVO withdrawRecordVO) throws Exception;


    /**
     * 新增
     *
     * @param withdrawRecordVO
     * @return int
     */
    public int update(final WithdrawRecordVO withdrawRecordVO) throws Exception;

    /**
     * 提现记录分页查询
     * @param withdrawRecordVO
     * @return
     */
    public PageBean queryByPage(WithdrawRecordVO withdrawRecordVO);

    public BigDecimal querySumAmount(WithdrawRecordVO withdrawRecordVO);
}
