package cn.smartpolice.dao;

import cn.smartpolice.entity.ContactInf;
import cn.smartpolice.entity.ContactInfExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ContactInfMapper {
    int countByExample(ContactInfExample example);

    int deleteByExample(ContactInfExample example);

    int insert(ContactInf record);

    int insertSelective(ContactInf record);

    List<ContactInf> selectByExample(ContactInfExample example);

    int updateByExampleSelective(@Param("record") ContactInf record, @Param("example") ContactInfExample example);

    int updateByExample(@Param("record") ContactInf record, @Param("example") ContactInfExample example);
}