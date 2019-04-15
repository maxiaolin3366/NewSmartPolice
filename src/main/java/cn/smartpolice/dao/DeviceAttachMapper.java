package cn.smartpolice.dao;

import cn.smartpolice.entity.DeviceAttach;
import cn.smartpolice.entity.DeviceAttachExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DeviceAttachMapper {
    int countByExample(DeviceAttachExample example);

    int deleteByExample(DeviceAttachExample example);

    int insert(DeviceAttach record);

    int insertSelective(DeviceAttach record);

    List<DeviceAttach> selectByExample(DeviceAttachExample example);

    int updateByExampleSelective(@Param("record") DeviceAttach record, @Param("example") DeviceAttachExample example);

    int updateByExample(@Param("record") DeviceAttach record, @Param("example") DeviceAttachExample example);
}