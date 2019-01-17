package com.somero.deploy.service.impl;

import com.somero.deploy.exception.UserException;
import com.somero.deploy.mapper.UserMapper;
import com.somero.deploy.model.User;
import com.somero.deploy.service.UserService;
import com.somero.deploy.utils.SqlResultCheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User register(User user) throws UserException {

        return user;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public void logout(int id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findUser(int id) throws UserException {
        return null;
    }
}
