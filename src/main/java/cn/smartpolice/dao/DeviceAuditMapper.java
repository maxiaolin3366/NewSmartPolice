package cn.smartpolice.dao;

import cn.smartpolice.entity.DeviceAudit;
import cn.smartpolice.entity.DeviceAuditExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DeviceAuditMapper {
    int countByExample(DeviceAuditExample example);

    int deleteByExample(DeviceAuditExample example);

    int insert(DeviceAudit record);

    int insertSelective(DeviceAudit record);

    List<DeviceAudit> selectByExample(DeviceAuditExample example);

    int updateByExampleSelective(@Param("record") DeviceAudit record, @Param("example") DeviceAuditExample example);

    int updateByExample(@Param("record") DeviceAudit record, @Param("example") DeviceAuditExample example);
}