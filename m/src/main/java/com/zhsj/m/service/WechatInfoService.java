package com.zhsj.m.service;

import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantAccountVO;
import com.zhsj.m.vo.WechatInfoVO;

/**
 * Created by taoxiangshan on 17/10/19.
 */
public interface WechatInfoService {

    /**
     * 获取
     *
     * @param id
     * @return int
     */
    public WechatInfoVO getById(Integer id);

    /**
     * 通过商户编号查询
     * @param merchantCode
     * @return
     */
    public WechatInfoVO getByMerchantCode(String merchantCode);

    /**
     * 通过appId查询
     * @param appId
     * @return
     */

    public WechatInfoVO getByAppId(String appId);

    /**
     * 新增
     *
     * @param wechatInfoVO
     * @return int
     */
    public int insert(final WechatInfoVO wechatInfoVO) throws Exception;


    /**
     * 新增
     *
     * @param wechatInfoVO
     * @return int
     */
    public int update(final WechatInfoVO wechatInfoVO) throws Exception;


}
