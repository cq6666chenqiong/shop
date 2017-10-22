package com.zhsj.m.service;

import com.zhsj.m.model.MerchantInfo;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantInfoVO;
import com.zhsj.m.vo.RoleInfoVO;

import java.util.List;

/**
 * Created by wuyongtao on 2017/10/16.
 */
public interface ShopService {
    /**
     * 通过ID获取
     * @param id
     * @return
     */
    public MerchantInfoVO getById(Integer id);
    void  save(MerchantInfo merchantInfo);
    List<MerchantInfo> getShopList(MerchantInfo merchantInfo);
    public PageBean queryByPage(MerchantInfoVO merchantInfoVO);

}
