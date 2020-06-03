package com.example.springboot_mybatis_mysql.controller;

import com.example.springboot_mybatis_mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/testBoot1")
public class UserController1 {


    @Autowired
    private UserService userService;


    //http://localhost:8080/testBoot/insertUser?id=3&username=zhangsan&password=123&realname=zs
    @RequestMapping("/insertUser")
    //通过在url中添加数据实现对MySQL数据库进行一个操作
    //httpServletRequest必须写在这里，这样才能实现url了解析，因为requestmapping映射到这里的
    public String insertUser(HttpServletRequest httpServletRequest) {
        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String realname = httpServletRequest.getParameter("realname");

        int i = userService.Ins(id, username, password, realname);

        if (i > 0) return "添加数据成功";
        else return "添加数据失败";
    }
}
