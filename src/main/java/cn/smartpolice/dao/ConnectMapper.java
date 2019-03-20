package cn.smartpolice.dao;

import cn.smartpolice.entity.Connect;
import cn.smartpolice.entity.ConnectExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ConnectMapper {
    int countByExample(ConnectExample example);

    int deleteByExample(ConnectExample example);

    int insert(Connect record);

    int insertSelective(Connect record);

    List<Connect> selectByExample(ConnectExample example);

    int updateByExampleSelective(@Param("record") Connect record, @Param("example") ConnectExample example);

    int updateByExample(@Param("record") Connect record, @Param("example") ConnectExample example);
}