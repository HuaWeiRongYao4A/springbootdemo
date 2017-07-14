package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by Administrator on 2017/6/24.
 */
public class TestJVM {
    public static void main(String[] args) throws IOException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemLoader);
        Enumeration<URL> enumeration = systemLoader.getResources("");
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        ClassLoader extensionLoader = systemLoader.getParent();
        System.out.println("扩展类加载器：" + extensionLoader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parent:" + extensionLoader.getParent());
    }
}
