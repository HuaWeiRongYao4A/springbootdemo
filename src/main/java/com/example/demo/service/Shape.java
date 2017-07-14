package com.example.demo.service;

/**
 * Created by Administrator on 2017/6/23.
 */
public abstract class Shape {
    {
        System.out.println("执行Shape的初始化块。。。");
    }

    private String color;
    public abstract String getType();

    public int niceMethod() {
        return 1;
    }

//    public Shape(String color) {
//        this.color = color;
//    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
