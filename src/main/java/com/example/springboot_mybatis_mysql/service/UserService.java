package com.example.springboot_mybatis_mysql.service;

import com.example.springboot_mybatis_mysql.entity.User;
import com.example.springboot_mybatis_mysql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int Ins(int id, String username, String password, String realname) {
        return userMapper.Ins(id, username, password, realname);
    }

    public int Del(int id) {
        return userMapper.Del(id);
    }

    public int Upd(int id, String username, String password, String realname) {
        return userMapper.Upd(id, username, password, realname);
    }

    public User Sel(int id) {
        return userMapper.Sel(id);
    }
}