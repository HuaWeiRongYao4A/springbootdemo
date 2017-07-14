package com.example.demo;

/**
 * Created by Administrator on 2017/6/24.
 */

class TestInitialization {
    static {
        System.out.println("TestInitialization初始化");
    }
}

public class TestStatic {
    public static int a = 6;
    public static final int b = a + 1;

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.example.demo.TestStatic2");
    }
}
