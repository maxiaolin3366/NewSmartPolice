package cn.smartpolice.dao;

import cn.smartpolice.entity.Oprate;
import cn.smartpolice.entity.OprateExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OprateMapper {
    int countByExample(OprateExample example);

    int deleteByExample(OprateExample example);

    int insert(Oprate record);

    int insertSelective(Oprate record);

    List<Oprate> selectByExample(OprateExample example);

    int updateByExampleSelective(@Param("record") Oprate record, @Param("example") OprateExample example);

    int updateByExample(@Param("record") Oprate record, @Param("example") OprateExample example);
}