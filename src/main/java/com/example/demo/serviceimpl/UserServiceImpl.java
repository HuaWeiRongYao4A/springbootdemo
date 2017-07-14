package com.example.demo.serviceimpl;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public User detail(int id) {
        return userMapper.detail(new User(id));
    }

    @Override
    public int update(int id, String username) {
        return userMapper.update(new User(id, username));
    }

    @Override
    public PageInfo<User> list(int pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<User> list = userMapper.list();
        return new PageInfo<>(list);

    }

    @Override
    public void sendEmailToUserQueue(User user) {
        rabbitTemplate.convertAndSend("direct-exchange","direct-binding-key", user);
    }
}
