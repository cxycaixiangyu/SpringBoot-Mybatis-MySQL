package com.example.springboot_mybatis_mysql.service;

import com.example.springboot_mybatis_mysql.entity.User;
import com.example.springboot_mybatis_mysql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    //通过html进行注册
    public int InsWithoutID(String username, String password, String realname) {
        return userMapper.InsWithoutID(username, password, realname);
    }

    //登录用户
    public Map loginUser(String username, String password) {
        return userMapper.loginUser(username, password);
    }


    /////////////////////////////////////////////////////////////////////////////
    //以下为一些增删改查的内容
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