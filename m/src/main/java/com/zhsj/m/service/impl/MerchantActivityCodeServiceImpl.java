package com.zhsj.m.service.impl;

import com.zhsj.m.dao.MerchantActivityCodeDao;
import com.zhsj.m.model.MerchantActivityCode;
import com.zhsj.m.service.MerchantActivityCodeService;
import com.zhsj.m.service.convert.impl.MerchantActivityCodeConvert;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.MerchantActivityCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taoxiangshan on 17/11/2.
 */
@Service
public class MerchantActivityCodeServiceImpl implements MerchantActivityCodeService{
    @Autowired
    private MerchantActivityCodeDao merchantActivityCodeDao;

    private MerchantActivityCodeConvert merchantActivityCodeConvert=new MerchantActivityCodeConvert();
    @Override
    public PageBean queryByPage(MerchantActivityCodeVO merchantActivityCodeVO) {
        Integer totalCount = merchantActivityCodeDao.queryCount(merchantActivityCodeConvert.toPO(merchantActivityCodeVO)).intValue();
        PageBean page = new PageBean();
        page.setTotalCount(totalCount);
        page.setPageNo(merchantActivityCodeVO.getPageNo());
        Integer startNum = page.getStartNum();
        merchantActivityCodeVO.setPageSize(page.getPageSize());
        merchantActivityCodeVO.setStartNum(page.getStartNum());
        List<MerchantActivityCodeVO> resultList = new ArrayList<MerchantActivityCodeVO>();
        List<MerchantActivityCode> withdrawList = merchantActivityCodeDao.query(merchantActivityCodeConvert.toPO(merchantActivityCodeVO));
        for (MerchantActivityCode temp : withdrawList) {
            resultList.add(merchantActivityCodeConvert.toVO(temp));
        }
        page.setList(resultList);
        return page;
    }


    @Override
    public int insert(MerchantActivityCodeVO merchantActivityCodeVO) throws Exception {
        return merchantActivityCodeDao.insert(merchantActivityCodeConvert.toPO(merchantActivityCodeVO));
    }

    @Override
    public MerchantActivityCodeVO getById(Integer id) {
        return merchantActivityCodeConvert.toVO(merchantActivityCodeDao.selectByPrimaryKey(id));
    }

    @Override
    public int update(MerchantActivityCodeVO merchantActivityCodeVO) throws Exception {
        return merchantActivityCodeDao.updateByPrimaryKeySelective(merchantActivityCodeConvert.toPO(merchantActivityCodeVO));
    }
}
