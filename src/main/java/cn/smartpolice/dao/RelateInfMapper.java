package cn.smartpolice.dao;

import cn.smartpolice.entity.RelateInf;
import cn.smartpolice.entity.RelateInfExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RelateInfMapper {
    int countByExample(RelateInfExample example);

    int deleteByExample(RelateInfExample example);

    int insert(RelateInf record);

    int insertSelective(RelateInf record);

    List<RelateInf> selectByExample(RelateInfExample example);

    int updateByExampleSelective(@Param("record") RelateInf record, @Param("example") RelateInfExample example);

    int updateByExample(@Param("record") RelateInf record, @Param("example") RelateInfExample example);

    List<RelateInf> findUserIdByDeviceId(int deviceid);

    List<RelateInf> findManagerIdByDeviceId(int deviceid);
}