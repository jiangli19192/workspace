package com.zjl.annotation.config.scope;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeConfigTest {
	
	@Test
	public void test2() {
		try (
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig2.class)) {
			System.out.println("IOC容器创建成功...");
		} catch (Exception e) {
			System.out.println("容器启动错误.");
		}
	}

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
			System.out.println("配置的作用域scope的值是prototype,相同ID的两个实例是不相等的：" + (bean == bean2));
		} catch (Exception e) {
			System.out.println("容器启动错误.");
		}
	}

}
