package cn.smartpolice.dao;

import cn.smartpolice.entity.CompanyInfo;
import cn.smartpolice.entity.CompanyInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CompanyInfoMapper {
    int countByExample(CompanyInfoExample example);

    int deleteByExample(CompanyInfoExample example);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    List<CompanyInfo> selectByExample(CompanyInfoExample example);

    int updateByExampleSelective(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    int updateByExample(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);
}