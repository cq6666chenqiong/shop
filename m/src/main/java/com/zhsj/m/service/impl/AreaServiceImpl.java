package com.zhsj.m.service.impl;

import com.zhsj.m.dao.AreaInfoDao;
import com.zhsj.m.model.AreaInfo;
import com.zhsj.m.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyongtao on 2017/10/17.
 */
@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    private AreaInfoDao areaInfoDao;

    public List<AreaInfo> getAreasByParentId(int parentId){
        List<AreaInfo> areaInfos = new ArrayList<AreaInfo>();
        areaInfos  = areaInfoDao.selectByParentId(parentId);
        return areaInfos;
    }
}
