package com.zjl.annotation.config.lifecycle;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleConfigTest {

	@Test
	public void test() {
		// 创建IOC容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifecycleConfig.class);
		System.out.println("容器创建完成。。。");
		
		// 关闭容器
		applicationContext.close();
	}

}
