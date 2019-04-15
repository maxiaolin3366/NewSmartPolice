package cn.smartpolice.dao;

import cn.smartpolice.entity.SoftInf;
import cn.smartpolice.entity.SoftInfExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SoftInfMapper {
    int countByExample(SoftInfExample example);

    int deleteByExample(SoftInfExample example);

    int insert(SoftInf record);

    int insertSelective(SoftInf record);

    List<SoftInf> selectByExample(SoftInfExample example);

    int updateByExampleSelective(@Param("record") SoftInf record, @Param("example") SoftInfExample example);

    int updateByExample(@Param("record") SoftInf record, @Param("example") SoftInfExample example);
}