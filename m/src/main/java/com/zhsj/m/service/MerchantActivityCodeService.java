package com.zhsj.m.service;

import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantActivityCodeVO;

import java.util.List;

/**
 * Created by taoxiangshan on 17/11/2.
 */
public interface MerchantActivityCodeService {

    public PageBean queryByPage(MerchantActivityCodeVO merchantActivityCodeVO);


    /**
     * 新增
     *
     * @param merchantActivityCodeVO
     * @return int
     */
    public int insert(final MerchantActivityCodeVO merchantActivityCodeVO) throws Exception;

    /**
     * 获取
     *
     * @param id
     * @return int
     */
    public MerchantActivityCodeVO getById(Integer id);

    /**
     * 新增
     *
     * @param merchantActivityCodeVO
     * @return int
     */
    public int update(final MerchantActivityCodeVO merchantActivityCodeVO) throws Exception;



}
