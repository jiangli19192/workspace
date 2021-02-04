package com.zjl.annotation.config.scope;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeConfigTest {

	@Test
	public void test() {
		try (
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class)) {
			String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
			
			// 容器中的Bean名称
			for (String beanName : beanDefinitionNames) {
				System.out.println(beanName);
			}
			
			Object bean = applicationContext.getBean("person");
			Object bean2 = applicationContext.getBean("person");
			System.out.println(bean == bean2);
		} catch (Exception e) {
			System.out.println("容器启动错误.");
		}
	}

}
