package com.zjl.study.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StartApp.class) // 通过Spring Boot加载上下文
@WebAppConfiguration
public class StartAppTest {

	@Test
	public void test() {
	}

}
