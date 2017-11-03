package com.zhsj.m.service;

import com.zhsj.m.model.MerchantExtendInfo;
import com.zhsj.m.model.MerchantInfo;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantExtendInfoVO;
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
    void  save(MerchantInfo merchantInfo, MerchantExtendInfo merchantExtendInfo);
    List<MerchantInfo> getShopList(MerchantInfo merchantInfo);
    public PageBean queryByPage(MerchantInfoVO merchantInfoVO);

    /**
     * 根据商户编号获取该商户的所有门店信息
     * @param parentCode
     * @return
     */
    List<MerchantInfoVO> getAllShopListByParentCode(String parentCode);

    /**
     * 通过商户/门店Code获取商户/门店扩展新
     * @param merchantCode
     * @return
     */
    MerchantExtendInfoVO getMerchantExtendByMerchantCode(String merchantCode);


}
