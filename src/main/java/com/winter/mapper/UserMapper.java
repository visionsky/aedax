package com.winter.mapper;

import com.winter.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    long countUser();
    String getInviterUserId(String inviteCode);
    int insertSelective(User record);
    int checkRegisterUser(User record);
    String getUserId(@Param("phone")String phone,@Param("nickname")String nickname,@Param("email") String email);
    int login(@Param("userId")String userId,@Param("password") String password,@Param("tokenid")String tokenid);
    int logout(@Param("userId")String userId,@Param("tokenid")String tokenid);
    User getUser(@Param("userId")String userId,@Param("tokenid")String tokenid);

    int changePassword(@Param("userId")String userid,@Param("tokenid")String tokenid,@Param("phone")String phone,@Param("password")String password);

    int deleteByPrimaryKey(String userId);

    //@Insert("insert into t_user(id,name,age) values (#{id},#{name},#{age})")
    //@Update("update t_user set name=#{name},age=#{age} where id=#{id}")
    //@Delete("delete from t_user where id=#{id}")
    //@Select("SELECT id,name,age FROM t_user where name=#{userName}")
    int insert(User record);





    User selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}