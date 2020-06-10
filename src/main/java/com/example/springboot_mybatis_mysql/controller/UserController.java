package com.example.springboot_mybatis_mysql.controller;

import com.example.springboot_mybatis_mysql.entity.User;
import com.example.springboot_mybatis_mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/test")
public class UserController {

    HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/AjaxDemo", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "index";
    }

    @RequestMapping("/main")
    public String test() {
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/registerUser")
    @ResponseBody
    //responsebody可以直接返回一个json格式的数据，如果不适用的话返回的就是一个视图解析器
    public String registerUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String realname = request.getParameter("realname");
        //System.out.println("id:" + id + ",username:" + username + ",password:" + password + ",realname:" + realname);
        //调用service方法完成用户的注册

        int i = userService.InsWithoutID(username, password, realname);
        if (i == 1) {
            return "注册成功";
        } else {
            return "注册失败";
        }
    }

    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + password);
        Map map = userService.loginUser(username, password);
        //System.out.println("mysqlmap中的数据" + map.get("userName"));
        if (map != null) {
            return "登陆成功";
        } else {
            return "登陆失败";
        }
    }


    //http://localhost:8080/testBoot/insertUser?id=1&username=zhangsan&password=123&realname=zs
    @RequestMapping("/insertUser")
    //为了方便代码编写，此处直接将要写入的数据写死，然后写到mysql中
    public String insertUser() {
        int i = userService.Ins(1, "zhangsan", "123", "zs");
        int j = userService.Ins(2, "lisi", "123", "ww");

        if (i + j > 0) {
            return "删除数据成功";
        } else {
            return "删除数据失败";
        }
    }

    //注销用户操作
    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        int i = userService.Del(id);
        if (i > 0) {
            return "删除数据成功";
        } else {
            return "删除数据失败";
        }
    }

    //更新用户信息操作
    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id) {
        int i = userService.Upd(id, "zhangsan", "456", "zs");
        if (i > 0) {
            return "删除数据成功";
        } else {
            return "删除数据失败";
        }
    }

    //查询用户信息操作
    @RequestMapping("getUser/{id}")
    @ResponseBody
    public List<User> SelUser(@PathVariable int id) {
        List<User> list = new ArrayList<>();
        list.add(userService.Sel(id));
        System.out.println(list.get(0).getId());
        System.out.println(list.get(0).getUsername());
        return list;
    }


}