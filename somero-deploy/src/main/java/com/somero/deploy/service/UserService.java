package com.somero.deploy.service;

import com.somero.deploy.exception.UserException;
import com.somero.deploy.model.User;

public interface UserService {

    User register(User user) throws UserException;

    User login(String username, String password) throws UserException;

    void logout(int id) throws UserException;

    void update(User user) throws UserException;

    void delete(int id) throws UserException;

    User findUser(int id) throws UserException;
}
