package cn.smartpolice.dao;

import cn.smartpolice.entity.SoftPublish;
import cn.smartpolice.entity.SoftPublishExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SoftPublishMapper {
    int countByExample(SoftPublishExample example);

    int deleteByExample(SoftPublishExample example);

    int insert(SoftPublish record);

    int insertSelective(SoftPublish record);

    List<SoftPublish> selectByExample(SoftPublishExample example);

    int updateByExampleSelective(@Param("record") SoftPublish record, @Param("example") SoftPublishExample example);

    int updateByExample(@Param("record") SoftPublish record, @Param("example") SoftPublishExample example);
}