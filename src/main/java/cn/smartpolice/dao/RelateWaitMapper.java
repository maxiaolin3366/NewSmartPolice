package cn.smartpolice.dao;

import cn.smartpolice.entity.RelateWait;
import cn.smartpolice.entity.RelateWaitExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RelateWaitMapper {
    int countByExample(RelateWaitExample example);

    int deleteByExample(RelateWaitExample example);

    int insert(RelateWait record);

    int insertSelective(RelateWait record);

    List<RelateWait> selectByExample(RelateWaitExample example);

    int updateByExampleSelective(@Param("record") RelateWait record, @Param("example") RelateWaitExample example);

    int updateByExample(@Param("record") RelateWait record, @Param("example") RelateWaitExample example);
}