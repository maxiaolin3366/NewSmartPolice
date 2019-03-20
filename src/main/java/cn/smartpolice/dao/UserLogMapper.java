package cn.smartpolice.dao;

import cn.smartpolice.entity.UserLog;
import cn.smartpolice.entity.UserLogExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserLogMapper {
    int countByExample(UserLogExample example);

    int deleteByExample(UserLogExample example);

    int insert(UserLog record);

    int insertSelective(UserLog record);

    List<UserLog> selectByExample(UserLogExample example);

    int updateByExampleSelective(@Param("record") UserLog record, @Param("example") UserLogExample example);

    int updateByExample(@Param("record") UserLog record, @Param("example") UserLogExample example);

    Date selectOffDateByIdAndOprate(int userId, Integer oprate);
}