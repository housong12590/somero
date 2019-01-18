package com.somero.deploy.service;

import com.somero.deploy.model.User;

public interface UserService {

    User login(String username, String password);

    User register(User user);

    boolean update(User user);
}
