package cn.smartpolice.dao;

import cn.smartpolice.entity.UserInf;
import cn.smartpolice.entity.UserInfExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserInfMapper {
    int countByExample(UserInfExample example);

    int deleteByExample(UserInfExample example);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    List<UserInf> selectByExample(UserInfExample example);

    int updateByExampleSelective(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByExample(@Param("record") UserInf record, @Param("example") UserInfExample example);

    UserInf selectUserBySid(Integer sid);

    UserInf selectUserByUserName(String username);

    void updateUserInf(UserInf record);

    void changeStateToZeroById(int userId);

    List<UserInf> selectAllUser();

    List<UserInf> selectAllCompanyUser();

    List<UserInf> selectAllManagerUser();

}