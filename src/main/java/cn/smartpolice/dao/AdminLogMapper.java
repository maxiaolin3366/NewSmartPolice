package cn.smartpolice.dao;

import cn.smartpolice.entity.AdminLog;
import cn.smartpolice.entity.AdminLogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdminLogMapper {
    int countByExample(AdminLogExample example);

    int deleteByExample(AdminLogExample example);

    int insert(AdminLog record);

    int insertSelective(AdminLog record);

    List<AdminLog> selectByExample(AdminLogExample example);

    int updateByExampleSelective(@Param("record") AdminLog record, @Param("example") AdminLogExample example);

    int updateByExample(@Param("record") AdminLog record, @Param("example") AdminLogExample example);
}