package cn.smartpolice.dao;

import cn.smartpolice.entity.MsgChat;
import cn.smartpolice.entity.MsgChatExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MsgChatMapper {
    int countByExample(MsgChatExample example);

    int deleteByExample(MsgChatExample example);

    int insert(MsgChat record);

    int insertSelective(MsgChat record);

    List<MsgChat> selectByExampleWithBLOBs(MsgChatExample example);

    List<MsgChat> selectByExample(MsgChatExample example);

    int updateByExampleSelective(@Param("record") MsgChat record, @Param("example") MsgChatExample example);

    int updateByExampleWithBLOBs(@Param("record") MsgChat record, @Param("example") MsgChatExample example);

    int updateByExample(@Param("record") MsgChat record, @Param("example") MsgChatExample example);

    MsgChat selectChat(int messageid);
}