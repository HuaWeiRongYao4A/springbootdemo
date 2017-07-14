package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * Created by Administrator on 2017/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {
    @Test
    public void testFile() throws Exception {
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsoluteFile().getParent());
        File newFile = new File(System.currentTimeMillis() + "");
        System.out.println("newFile对象是否存在： " + newFile.exists());
        newFile.createNewFile();
        newFile.mkdir();
        String[] fileList = file.list();
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }
    }
}
