package cn.smartpolice.dao;

import cn.smartpolice.entity.SystemRuninfo;
import cn.smartpolice.entity.SystemRuninfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SystemRuninfoMapper {
    int countByExample(SystemRuninfoExample example);

    int deleteByExample(SystemRuninfoExample example);

    int insert(SystemRuninfo record);

    int insertSelective(SystemRuninfo record);

    List<SystemRuninfo> selectByExample(SystemRuninfoExample example);

    int updateByExampleSelective(@Param("record") SystemRuninfo record, @Param("example") SystemRuninfoExample example);

    int updateByExample(@Param("record") SystemRuninfo record, @Param("example") SystemRuninfoExample example);
}