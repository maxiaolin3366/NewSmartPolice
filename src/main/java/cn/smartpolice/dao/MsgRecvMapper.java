package cn.smartpolice.dao;

import cn.smartpolice.entity.MsgRecv;
import cn.smartpolice.entity.MsgRecvExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MsgRecvMapper {
    int countByExample(MsgRecvExample example);

    int deleteByExample(MsgRecvExample example);

    int insert(MsgRecv record);

    int insertSelective(MsgRecv record);

    List<MsgRecv> selectByExample(MsgRecvExample example);

    int updateByExampleSelective(@Param("record") MsgRecv record, @Param("example") MsgRecvExample example);

    int updateByExample(@Param("record") MsgRecv record, @Param("example") MsgRecvExample example);

    int selectUnReadAll(int recvuserid);

    int selectUnReadAlarm(int recvuserid);

    int selectUnReadChat(int recvuserid);

    int selectUnReadNotice(int recvuserid);

    List<MsgRecv> selectMessageOfUnReadMsg(int recvuserid, int pageSize);

    List<MsgRecv> selectMessageOfAlarm(int recvuserid, int pageSize);

    List<MsgRecv> selectMessageOfChat(int recvuserid, int pageSize);

    List<MsgRecv> selectMessageOfNotice(int recvuserid, int pageSize);
}