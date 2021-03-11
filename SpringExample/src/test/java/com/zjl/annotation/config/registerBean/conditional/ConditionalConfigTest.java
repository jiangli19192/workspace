package com.zjl.annotation.config.registerBean.conditional;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.zjl.annotation.bean.Person;


/**
 * 测试Linux系统：VM arguments:-Dos.name=Linux
 * 
 * ClassName : ConditionalConfigTest
 * @author 张江立
 * @date 2021年2月7日 下午10:55:43
 *
 */
public class ConditionalConfigTest {
	
	@Test
	public void testConditionalApplyToClass() {
		try (
				AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalConfig2.class)) {
				// 动态获取操作系统的名称
				ConfigurableEnvironment environment = applicationContext.getEnvironment();
				String property = environment.getProperty("os.name");
				System.out.println("操作系统名字:" + property);
				
				String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
				for (String name : beanDefinitionNames) {
					System.out.println(name);
				}
				
				Map<String, Person> ofType = applicationContext.getBeansOfType(Person.class);
				System.out.println(ofType);
				
			} catch (Exception e) {
				System.out.println("容器启动错误.");
			}
	}

	@Test
	public void testConditionalApplyToMethod() {
		try (
			AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalConfig.class)) {
			// 动态获取操作系统的名称
			ConfigurableEnvironment environment = applicationContext.getEnvironment();
			String property = environment.getProperty("os.name");
			System.out.println("操作系统名字:" + property);
			
			String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
			for (String name : beanDefinitionNames) {
				System.out.println(name);
			}
			
			Map<String, Person> ofType = applicationContext.getBeansOfType(Person.class);
			System.out.println(ofType);
			
		} catch (Exception e) {
			System.out.println("容器启动错误.");
		}
	}
}
