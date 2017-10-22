package com.zhsj.m.dao;

import com.zhsj.m.model.ChannelInfo;
import com.zhsj.m.util.db.DS;
import com.zhsj.m.util.db.DynamicDataSource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@DynamicDataSource(DS.DB_MANAGER)
public interface ChannelInfoDao {

    int deleteByPrimaryKey(Integer id);


    int insert(ChannelInfo record);


    int insertSelective(ChannelInfo record);


    ChannelInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(ChannelInfo record);


    int updateByPrimaryKey(ChannelInfo record);

    /**
     * 查询
     *
     * @return List<ChannelInfo>
     */
    public List<ChannelInfo> getParentChannelListBySystemId(@Param("systemId") Integer systemId);
    /**
     * 查询
     *
     * @return List<ChannelInfo>
     */
    public List<ChannelInfo> getSonChannelListBySystemIdAndParentId(@Param("systemId") Integer systemId,@Param("parentId") Integer parentId);


    /**
     * 查询二级菜单 或者 按钮
     *
     * @return List<ChannelInfo>
     */
    public List<ChannelInfo> getResourceChannelListBySystemId(@Param("systemId") Integer systemId,@Param("channelType")Integer channelType);
}