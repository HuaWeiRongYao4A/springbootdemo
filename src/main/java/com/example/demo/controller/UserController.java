package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/20.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping("detail")
    public User detail(int id) {
       return userService.detail(id);
    }

    @RequestMapping("detail/{id}")
    public User detail2(@PathVariable int id) {
       return userService.detail(id);
    }

    @RequestMapping("update")
    public int update(int id, String username) {
       return userService.update(id, username);
    }

    @RequestMapping("list")
    public PageInfo<User> list() {
        return userService.list(1);
    }
}
