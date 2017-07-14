package com.example.demo;

/**
 * Created by Administrator on 2017/7/13.
 */

public class TestThread718 extends Thread {
    private int i;
    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + "骗人的吧" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new TestThread718().start();
                new TestThread718().start();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
