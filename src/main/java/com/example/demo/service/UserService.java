package com.example.demo.service;

import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface UserService {

    User detail(int id);

    int update(int id, String username);

    PageInfo<User> list(int pageNum);

    void sendEmailToUserQueue(User user);
}
