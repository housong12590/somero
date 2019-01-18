package com.somero.deploy;

import com.somero.deploy.mapper.UserMapper;
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
    @Test
    public void test01() {
//        UserExample example = new UserExample();
//        example.createCriteria().andIdEqualTo(0);
//        userMapper.selectByExample(example);
//        userMapper.findById();
        boolean empty = userMapper.isNotEmpty();
        System.out.println(empty);
    }
}

