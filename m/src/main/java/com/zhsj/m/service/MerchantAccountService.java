package com.zhsj.m.service;

import com.zhsj.m.model.RoleInfo;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.RoleInfoVO;

import java.util.List;

/**
 * Created by taoxiangshan on 17/10/19.
 */
public interface MerchantAccountService {

    public PageBean queryByPage(MerchantAccountVO merchantAccountVO);

    public MerchantAccountVO getByAccount(String account);

    /**
     * 新增
     *
     * @param merchantAccountVO
     * @return int
     */
    public int insert(final MerchantAccountVO merchantAccountVO) throws Exception;

    /**
     * 获取
     *
     * @param id
     * @return int
     */
    public MerchantAccountVO getById(Integer id);

    /**
     * 新增
     *
     * @param merchantAccountVO
     * @return int
     */
    public int update(final MerchantAccountVO merchantAccountVO) throws Exception;


}
