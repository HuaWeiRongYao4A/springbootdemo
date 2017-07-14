package com.example.demo.serviceimpl;

import com.example.demo.service.Shape;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/23.
 */
@Service
public class Triangle extends Shape {

    @Override
    public String getType() {
        System.out.println(666);
        return "666";
    }
}
