package com.somero.deploy.mapper;

import com.somero.deploy.model.User;
import com.somero.deploy.model.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from so_user where id = 0")
    User findById();

    @Select("select count(id) from so_user")
    boolean isNotEmpty();

    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}