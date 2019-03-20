package cn.smartpolice.dao;

import cn.smartpolice.entity.DeviceInf;
import cn.smartpolice.entity.DeviceInfExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DeviceInfMapper {
    int countByExample(DeviceInfExample example);

    int deleteByExample(DeviceInfExample example);

    int insert(DeviceInf record);

    int insertSelective(DeviceInf record);

    List<DeviceInf> selectByExample(DeviceInfExample example);

    int updateByExampleSelective(@Param("record") DeviceInf record, @Param("example") DeviceInfExample example);

    int updateByExample(@Param("record") DeviceInf record, @Param("example") DeviceInfExample example);

    void changeStateToZeroById(int deviceId);

    DeviceInf selectDeviceBySid(Integer sid);

    DeviceInf selectDeviceByUserName(String username);

    DeviceInf updateDeviceInf(DeviceInf record);

}