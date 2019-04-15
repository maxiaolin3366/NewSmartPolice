package cn.smartpolice.dao;

import cn.smartpolice.entity.MsgAlarm;
import cn.smartpolice.entity.MsgAlarmExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MsgAlarmMapper {
    int countByExample(MsgAlarmExample example);

    int deleteByExample(MsgAlarmExample example);

    int insert(MsgAlarm record);

    int insertSelective(MsgAlarm record);

    List<MsgAlarm> selectByExample(MsgAlarmExample example);

    int updateByExampleSelective(@Param("record") MsgAlarm record, @Param("example") MsgAlarmExample example);

    int updateByExample(@Param("record") MsgAlarm record, @Param("example") MsgAlarmExample example);
}