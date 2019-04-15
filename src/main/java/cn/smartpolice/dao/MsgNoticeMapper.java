package cn.smartpolice.dao;

import cn.smartpolice.entity.MsgNotice;
import cn.smartpolice.entity.MsgNoticeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MsgNoticeMapper {
    int countByExample(MsgNoticeExample example);

    int deleteByExample(MsgNoticeExample example);

    int insert(MsgNotice record);

    int insertSelective(MsgNotice record);

    List<MsgNotice> selectByExample(MsgNoticeExample example);

    int updateByExampleSelective(@Param("record") MsgNotice record, @Param("example") MsgNoticeExample example);

    int updateByExample(@Param("record") MsgNotice record, @Param("example") MsgNoticeExample example);
}