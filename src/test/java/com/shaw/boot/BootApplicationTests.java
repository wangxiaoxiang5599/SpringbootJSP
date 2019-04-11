package com.shaw.boot;

import com.shaw.boot.dao.UserDao;
import com.shaw.boot.po.User;
import com.shaw.boot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest()
@WebAppConfiguration
public class BootApplicationTests {

    @Resource
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Test
    public void testConnection() {
        System.out.println(this.dataSource);
    }

    @Test
    public void testMybatis(){
        User user = userService.findUser("m0001", "123");
        System.out.println(user.toString());
    }

}
