package com.somero.deploy.service.impl;

import com.somero.deploy.exception.ServiceException;
import com.somero.deploy.mapper.UserMapper;
import com.somero.deploy.model.User;
import com.somero.deploy.service.UserService;
import com.somero.deploy.utils.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user = userMapper.findByCase(user, false);
        if (user == null) {
            throw new ServiceException("用户不存在");
        }
        if (StringUtils.equals(user.getPassword(), password)) {
            return user;
        }
        throw new ServiceException("密码错误");
    }

    @Override
    public User register(User user) {
        User caseUser = new User();
        user.setUsername(user.getUsername());
        if (userMapper.findByCase(caseUser, true) != null) {
            throw new ServiceException("用户名已存在");
        }
        userMapper.insert(user);
        return user;
    }

    @Override
    public boolean update(User user) {
        if (userMapper.isExistUser(user.getId(), user.getUsername())) {
            throw new ServiceException("用户名已存在");
        }
        return userMapper.update(user);
    }
}
