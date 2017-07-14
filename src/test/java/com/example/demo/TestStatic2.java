package com.example.demo;

/**
 * Created by Administrator on 2017/6/24.
 */
public class TestStatic2 {
    public final static long a = 4;
    public final static long b = 4;
    public final static long c = a + System.currentTimeMillis();

    static {
        System.out.println("TestStatic2初始化");
    }
    public static void main(String[] args) {
        System.out.println(Character.isDigit('0'));
        String str = "aiower85";
        char ch = str.charAt(0);
        System.out.println(ch);
    }
}
