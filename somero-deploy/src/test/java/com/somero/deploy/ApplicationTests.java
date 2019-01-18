package com.somero.deploy;

import com.somero.deploy.mapper.UserMapper;
import com.somero.deploy.model.User;
import com.somero.deploy.service.UserService;
import com.somero.deploy.utils.JSON;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


    @Test
    public void contextLoads() {
    }


    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setMail("304536797@qq.com");
        user.setPassword("123456");
        user.setUsername("housong12590");
        user.setRealName("侯松");
        userMapper.insert(user);
        System.out.println(JSON.toJsonString(user));
    }

    @Test
    public void test01() {
        User user = new User();
        user.setMail("304536797@qq.com");
        user.setPassword("123456");
        user.setUsername("housong12592");
        user.setRealName("侯松");
        user.setId(4);
        Boolean ret = userService.update(user);
        System.out.println("更新用户 : " + ret);
    }


}

