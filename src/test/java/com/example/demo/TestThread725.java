package com.example.demo;

/**
 * Created by Administrator on 2017/7/14.
 */
public class TestThread725 extends Thread {
    private int i;
    public void run() {
        for (; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        TestThread725 thread725 = new TestThread725();
        for (int i = 0; i < 300; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                thread725.start();
                System.out.println(thread725.isAlive());
            }
            if (i > 20 && !thread725.isAlive()) {
                thread725.start();
            }
        }
    }
}
