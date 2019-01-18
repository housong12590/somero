package com.somero.deploy.controller;

import com.somero.deploy.model.User;
import com.somero.deploy.param.LoginParam;
import com.somero.deploy.param.RegisterParam;
import com.somero.deploy.service.UserService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
@Api(description = "用户管理")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("login")
    @ResponseBody
    public User login(@Valid @RequestBody LoginParam param) {
        return userService.login(param.getUsername(), param.getPassword());
    }

    @ApiOperation(value = "注册")
    @PostMapping("register")
    @ResponseBody
    public User register(@Valid @RequestBody RegisterParam param) {
        User user = new User();
        BeanUtils.copyProperties(param, user);
        return userService.register(user);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("update/{id}")
    @ResponseBody
    public Object update(@Valid @RequestBody RegisterParam param, @PathVariable("id") int id) {
        User user = new User();
        BeanUtils.copyProperties(param, user);
        user.setId(id);
        return userService.update(user);
    }

}
