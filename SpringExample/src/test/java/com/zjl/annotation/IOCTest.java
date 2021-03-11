package com.zjl.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zjl.annotation.config.registerBean.MainConfig;

public class IOCTest {

	@SuppressWarnings("resource")
	@Test
	public void testComponentScanAnnotation() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		
		// 容器中的Bean名称
		for (String beanName : beanDefinitionNames) {
			System.out.println(beanName);
		}
	}
}
