package com.example.demo;

/**
 * Created by Administrator on 2017/7/13.
 */
public class TestThread719 implements Runnable {
    private int i;
    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "当前线程" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "主线程" +i);
            if (i == 20) {
                TestThread719 thread717 = new TestThread719();
                new Thread(thread717, "新线程1").start();
                new Thread(thread717, "新线程2").start();
            }
        }
    }
}
