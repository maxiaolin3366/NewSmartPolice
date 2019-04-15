package cn.smartpolice.dao;

import cn.smartpolice.entity.ContactWait;
import cn.smartpolice.entity.ContactWaitExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ContactWaitMapper {
    int countByExample(ContactWaitExample example);

    int deleteByExample(ContactWaitExample example);

    int insert(ContactWait record);

    int insertSelective(ContactWait record);

    List<ContactWait> selectByExample(ContactWaitExample example);

    int updateByExampleSelective(@Param("record") ContactWait record, @Param("example") ContactWaitExample example);

    int updateByExample(@Param("record") ContactWait record, @Param("example") ContactWaitExample example);
}