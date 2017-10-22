package com.zhsj.m.service;

import com.zhsj.m.model.AreaInfo;

import java.util.List;

/**
 * Created by wuyongtao on 2017/10/17.
 */
public interface AreaService {
    public List<AreaInfo> getAreasByParentId(int parentId);
}

