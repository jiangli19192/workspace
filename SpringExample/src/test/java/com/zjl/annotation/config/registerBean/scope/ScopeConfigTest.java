package com.zjl.annotation.config.registerBean.scope;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeConfigTest {
	
	@Test
	public void test4() {
		try (
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig3.class)) {
			System.out.println("标注懒加载的Bean，容器启动的时候，不创建对象。");
			
			Object bean = applicationContext.getBean("person");
			System.out.println("标注懒加载的Bean，在第一次获取的时候，才创建对象并初始化");
			Object bean2 = applicationContext.getBean("person");
			System.out.println("标注懒加载的Bean，在第二次获取的时候，就直接从容器中拿");
			System.out.println(bean == bean2);
		} catch (Exception e) {
			System.out.println("容器启动错误.");
		}
	}
	
	@Test
	public void test3() {
		/**
		 * prototype作用域对象，在容器中实例化情况
		 */
		try (
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class)) {
			System.out.println("prototype:多实例的Bean：ioc容器启动并不会去调用方法创建对象到容器中。");
			
			Object bean = applicationContext.getBean("person");
			Object bean2 = applicationContext.getBean("person");
			System.out.println("而是每次获取的时候才会调用方法创建对象;");
			System.out.println(bean == bean2);
			// git log --pretty=oneline
		} catch (Exception e) {
			System.out.println("容器启动错误.");
		}
	}
	
	@Test
	public void test2() {
		try (
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig2.class)) {
			System.out.println("singleton:单实例的Bean:ioc容器启动时，就会调用方法创建对象到ioc容器中。");
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
