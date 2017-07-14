package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testMathRound() throws UnsupportedEncodingException {
		String s1 = "你好";
		String s2 = new String(s1.getBytes("UTF-8"), "GB2312");
		System.out.println(s2);
	}

}
