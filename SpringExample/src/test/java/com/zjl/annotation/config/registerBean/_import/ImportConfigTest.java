package com.zjl.annotation.config.registerBean._import;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zjl.annotation.bean.Blue;

public class ImportConfigTest {
	
	@Test
	public void testImplementsFactoryBeanRegistor() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig2.class);
		printBeans(applicationContext);
		
		// 工厂bean获取的是调用getObject方法创建的对象
		Object bean = applicationContext.getBean("colorFactoryBean");
		Object bean2 = applicationContext.getBean("colorFactoryBean");
		System.out.println("bean的类型：" + bean.getClass());
		
		// 定义ColorFactoryBean的isSingleton()方法返回值是true时：创建的对象是单实例，两个对象是相等的
		// 定义ColorFactoryBean的isSingleton()方法返回值是false时：创建的对象是多实例，两个对象是不相等的
		System.out.println("这两个bean是否一样：" + (bean == bean2));
		
		// 获取工厂bean本身
		Object bean3 = applicationContext.getBean("&colorFactoryBean");
		System.out.println("bean3的类型：" + bean3.getClass());
	}

	@Test
	public void testImportComponent() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ImportConfig.class);
		printBeans(applicationContext);
		
		/** eclipse列选择: Alt + Shift + A
		 * 打印结果：
		 * importConfig
		 * com.zjl.annotation.bean.Color
		 * com.zjl.annotation.bean.Red
		 * com.zjl.annotation.bean.Blue
		 * com.zjl.annotation.bean.Yellow
		 * person
		 * bill
		 */
		
		Blue blue = applicationContext.getBean(Blue.class);
		System.out.println(blue);
	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext) {
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for(String name : definitionNames) {
			System.out.println(name);
		}
	}
}
