package com.example.springboot_mybatis_mysql.mapper;

import com.example.springboot_mybatis_mysql.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //增
    int Ins(int id, String username, String password, String realname);

    //删
    int Del(int id);

    //改
    int Upd(int id,String username, String password, String realname);

    //查
    User Sel(int id);
}