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
}