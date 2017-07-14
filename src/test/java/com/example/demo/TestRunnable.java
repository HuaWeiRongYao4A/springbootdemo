package com.example.demo;

import java.io.File;

/**
 * Created by Administrator on 2017/7/12.
 */


public class TestRunnable {
    public static void main(String[] args) {
        File file = new File(".");
        String[] nameList = file.list(((dir, name) -> name.endsWith(".java") || new File(name).isDirectory()));
        for (String list : nameList) {
            System.out.println(list);
        }
    }
}
