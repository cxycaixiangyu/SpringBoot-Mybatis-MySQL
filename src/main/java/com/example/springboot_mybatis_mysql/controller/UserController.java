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

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        int i = userService.Del(id);
        if (i > 0) {
            return "删除数据成功";
        } else {
            return "删除数据失败";
        }
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id) {
        int i = userService.Upd(id, "zhangsan", "456", "zs");
        if (i > 0) {
            return "删除数据成功";
        } else {
            return "删除数据失败";
        }
    }

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