package com.zhsj.m.service;

import com.zhsj.m.util.page.PageBean;
import com.zhsj.m.vo.TerminalDeviceVO;

/**
 * Created by taoxiangshan on 17/11/3.
 */
public interface TerminalDeviceService {

    public PageBean queryByPage(TerminalDeviceVO terminalDeviceVO);


    /**
     * 新增
     *
     * @param terminalDeviceVO
     * @return int
     */
    public int insert(final TerminalDeviceVO terminalDeviceVO) throws Exception;

    /**
     * 获取
     *
     * @param id
     * @return int
     */
    public TerminalDeviceVO getById(Integer id);

    /**
     * 新增
     *
     * @param terminalDeviceVO
     * @return int
     */
    public int update(final TerminalDeviceVO terminalDeviceVO) throws Exception;



}
