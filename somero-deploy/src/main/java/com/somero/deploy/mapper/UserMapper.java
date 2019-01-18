package com.somero.deploy.mapper;

import com.somero.deploy.model.User;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int insert(User record);

    User findById(Integer id);

    boolean update(User user);

    boolean delete(Integer id);

    User findByCase(@Param("user") User user, @Param("filter") boolean filter);
}