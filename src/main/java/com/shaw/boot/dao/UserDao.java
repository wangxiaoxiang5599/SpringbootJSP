package com.shaw.boot.dao;

import com.shaw.boot.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 通过账号和密码查询用户
     */
    public User findUser(@Param("usercode") String usercode,
                         @Param("password") String password);
}
