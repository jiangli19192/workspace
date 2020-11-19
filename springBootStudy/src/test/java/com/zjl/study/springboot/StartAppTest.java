package com.zjl.study.springboot;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zjl.study.springboot.controller.HelloWorldController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartApp.class) // 通过Spring Boot加载上下文
@WebAppConfiguration
public class StartAppTest {
	
	@Resource
	private HelloWorldController helloService;

	@Test
	public void test() {
		assertEquals("Hello World!!!", helloService.getName("World"));
	}

}
