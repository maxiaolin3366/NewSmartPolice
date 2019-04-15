package cn.smartpolice.dao;

import cn.smartpolice.entity.SoftDownload;
import cn.smartpolice.entity.SoftDownloadExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SoftDownloadMapper {
    int countByExample(SoftDownloadExample example);

    int deleteByExample(SoftDownloadExample example);

    int insert(SoftDownload record);

    int insertSelective(SoftDownload record);

    List<SoftDownload> selectByExample(SoftDownloadExample example);

    int updateByExampleSelective(@Param("record") SoftDownload record, @Param("example") SoftDownloadExample example);

    int updateByExample(@Param("record") SoftDownload record, @Param("example") SoftDownloadExample example);
}