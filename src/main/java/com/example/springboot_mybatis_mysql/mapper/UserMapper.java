package com.example.springboot_mybatis_mysql.mapper;

import com.example.springboot_mybatis_mysql.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    //用户注册逻辑
    int InsWithoutID(String username, String password, String realname);

    //用户登录逻辑
    Map loginUser(String username, String password);


    ////////////////////////////////////////////
    //简单的增删改查逻辑
    //增
    int Ins(int id, String username, String password, String realname);

    //删
    int Del(int id);

    //改
    int Upd(int id, String username, String password, String realname);

    //查
    User Sel(int id);
}