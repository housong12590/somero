package com.somero.deploy.controller;

import com.somero.deploy.exception.UserException;
import com.somero.deploy.model.User;
import com.somero.deploy.service.UserService;
import com.somero.deploy.utils.MakerResp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.DELETE})
    public String index(HttpServletRequest request, @PathVariable("id") int id) {

        return "user/index";
    }

    @RequestMapping(value = "create", method = {RequestMethod.GET, RequestMethod.POST})
    public String createUser(HttpServletRequest request, User user) {
        try {
            userService.register(user);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return "user/index";
    }

    @RequestMapping(value = "update/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public Object updateUser(HttpServletRequest request, User user, @PathVariable("id") int id) {
        if (request.getMethod().equals("GET")) {
            try {
                user = userService.findUser(id);
            } catch (UserException e) {
                e.printStackTrace();
            }
            return "user/detail";
        }
        user.setId(id);
        try {
            userService.update(user);
        } catch (UserException e) {
            e.printStackTrace();
        }
        return "user/index";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Object deleteUser(@PathVariable("id") int id) {
        try {
            userService.delete(id);
            return MakerResp.success();
        } catch (UserException e) {
            e.printStackTrace();
            return MakerResp.failed(e.getCode(), e.getMessage());
        }
    }

}
