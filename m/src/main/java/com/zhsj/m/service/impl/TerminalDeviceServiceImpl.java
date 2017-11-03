package com.zhsj.m.service.impl;

import com.zhsj.m.service.TerminalDeviceService;
import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.TerminalDeviceVO;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 17/11/3.
 */
@Service
public class TerminalDeviceServiceImpl implements TerminalDeviceService {
    @Override
    public PageBean queryByPage(TerminalDeviceVO terminalDeviceVO) {
        return null;
    }

    @Override
    public int insert(TerminalDeviceVO terminalDeviceVO) throws Exception {
        return 0;
    }

    @Override
    public TerminalDeviceVO getById(Integer id) {
        return null;
    }

    @Override
    public int update(TerminalDeviceVO terminalDeviceVO) throws Exception {
        return 0;
    }
}
