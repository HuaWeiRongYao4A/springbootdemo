package com.example.demo.serviceimpl;

import com.example.demo.mapper.HelloMapper;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/23.
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloMapper helloMapper;

    @Override
    public int update(String patentId, String patentType) {
        return helloMapper.update(patentId, patentType);
    }
}
