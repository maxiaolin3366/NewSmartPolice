package cn.smartpolice.dao;

import cn.smartpolice.entity.DeviceList;
import cn.smartpolice.entity.DeviceListExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DeviceListMapper {
    int countByExample(DeviceListExample example);

    int deleteByExample(DeviceListExample example);

    int insert(DeviceList record);

    int insertSelective(DeviceList record);

    List<DeviceList> selectByExample(DeviceListExample example);

    int updateByExampleSelective(@Param("record") DeviceList record, @Param("example") DeviceListExample example);

    int updateByExample(@Param("record") DeviceList record, @Param("example") DeviceListExample example);
}