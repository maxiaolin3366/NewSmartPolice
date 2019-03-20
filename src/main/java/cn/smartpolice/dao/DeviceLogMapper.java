package cn.smartpolice.dao;

import cn.smartpolice.entity.DeviceLog;
import cn.smartpolice.entity.DeviceLogExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DeviceLogMapper {
    int countByExample(DeviceLogExample example);

    int deleteByExample(DeviceLogExample example);

    int insert(DeviceLog record);

    int insertSelective(DeviceLog record);

    List<DeviceLog> selectByExample(DeviceLogExample example);

    int updateByExampleSelective(@Param("record") DeviceLog record, @Param("example") DeviceLogExample example);

    int updateByExample(@Param("record") DeviceLog record, @Param("example") DeviceLogExample example);

    Date selectOffDateByIdAndOprate(int DeviceId, Integer oprate);

}