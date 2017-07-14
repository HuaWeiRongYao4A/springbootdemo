package com.example.demo;

import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/7/14.
 */
public class TestThread721 {
    public static void main(String[] args) {
        TestThread721 thread721 = new TestThread721();
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "循环变量i的值：" + i);
            }
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "循环变量i的值" + i);
            if (i == 20) {
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
