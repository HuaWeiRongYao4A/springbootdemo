package com.example.demo;

import com.example.demo.taskjob.SyncTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/6/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class SyncTaskTest {
    @Autowired
    private SyncTask syncTask;

    @Test
    public void syncTest() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = syncTask.doTaskOne();
        Future<String> task2 = syncTask.doTaskTwo();
        Future<String> task3 = syncTask.doTaskThree();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时： " + (end - start) + "毫秒");
    }
}
